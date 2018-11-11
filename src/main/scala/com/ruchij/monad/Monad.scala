package com.ruchij.monad

import com.ruchij.exceptions.EmptyOptionException

import scala.language.higherKinds
import scala.util.Try

trait Monad[M[+ _]] {
  def map[A, B](f: A => B)(m: M[A]): M[B] = flatMap((value: A) => lift[B](f(value)))(m)

  def flatMap[A, B](f: A => M[B])(m: M[A]): M[B]

  def lift[A](value: A): M[A]

  def fold[A, B](onFailure: Throwable => B)(onSuccess: A => B)(m: M[A]): B
}

object Monad {
  def sequence[A, M[+ _]](values: List[M[A]])(implicit monad: Monad[M]): Either[List[Throwable], List[A]] =
    values match {
      case x :: xs =>
        monad.fold[A, Either[List[Throwable], List[A]]](_ => Left(failures(values))) { value =>
          sequence(xs).map(value :: _)
        }(x)

      case Nil => Right(List.empty[A])
    }

  def failures[A, M[+ _]](values: List[M[A]])(implicit monad: Monad[M]): List[Throwable] =
    values match {
      case x :: xs =>
        monad.fold[A, List[Throwable]](_ :: failures(xs))(_ => failures(xs))(x)

      case Nil => List.empty
    }

  implicit object OptionMonad extends Monad[Option] {
    override def flatMap[A, B](f: A => Option[B])(option: Option[A]): Option[B] =
      option.flatMap(f)

    override def lift[A](value: A): Option[A] = Option(value)

    override def fold[A, B](onFailure: Throwable => B)(onSuccess: A => B)(option: Option[A]): B =
      option.fold(onFailure(EmptyOptionException))(onSuccess)
  }

  implicit object TryMonad extends Monad[Try] {
    override def flatMap[A, B](f: A => Try[B])(tryValue: Try[A]): Try[B] =
      tryValue.flatMap(f)

    override def lift[A](value: A): Try[A] = Try(value)

    override def fold[A, B](onFailure: Throwable => B)(onSuccess: A => B)(tryValue: Try[A]): B =
      tryValue.fold(onFailure, onSuccess)
  }
}
