package com.ruchij.exceptions

case class ValidationException(validationError: String) extends Exception {
  override def getMessage: String = validationError
}
