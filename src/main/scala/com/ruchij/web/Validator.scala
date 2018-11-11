package com.ruchij.web

import scala.util.{Success, Try}

trait Validator[-A] {
  def apply[B <: A](value: B): Try[B]
}

object Validator {
  implicit object EmptyValidator extends Validator[AnyRef] {
    override def apply[B <: AnyRef](value: B): Try[B] = Success(value)
  }
}
