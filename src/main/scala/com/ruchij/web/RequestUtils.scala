package com.ruchij.web

import com.ruchij.exceptions.JsonValidationException
import play.api.libs.json.{JsValue, Reads}

import scala.util.{Failure, Try}

object RequestUtils {
  def parseAndValidate[A](body: JsValue)(implicit reads: Reads[A], validator: Validator[A]): Try[A] =
    body
      .validate[A]
      .fold(validationErrors => Failure(JsonValidationException(validationErrors)), validator.apply)
}
