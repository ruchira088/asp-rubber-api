package com.ruchij.exceptions

trait ValidationException extends Exception

object ValidationException {
  def apply(validationError: String): ValidationException =
    new ValidationException {
      override def getMessage: String = validationError
    }
}
