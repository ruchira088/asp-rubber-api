package com.ruchij.json

import org.joda.time.DateTime
import play.api.libs.json._

import scala.util.Try

object JsonFormats {

  implicit val jodaTimeFormat: Format[DateTime] = new Format[DateTime] {
    override def reads(json: JsValue): JsResult[DateTime] =
      json match {
        case JsString(value) =>
          Try(DateTime.parse(value)).fold(exception => JsError(exception.getMessage), dateTime => JsSuccess(dateTime))

        case _ => JsError("Must be a JSON string")
      }

    override def writes(dateTime: DateTime): JsValue =
      JsString(dateTime.toString)
  }
}
