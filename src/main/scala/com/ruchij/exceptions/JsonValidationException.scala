package com.ruchij.exceptions

import play.api.libs.json.{JsPath, JsonValidationError}

case class JsonValidationException(validationErrors: Seq[(JsPath, Seq[JsonValidationError])])
    extends ValidationException
