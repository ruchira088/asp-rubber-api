package com.ruchij.exceptions

object EmptyOptionException extends Exception {
  override def getMessage: String = "Option is EMPTY"
}
