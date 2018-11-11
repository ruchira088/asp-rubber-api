package web.requests

import play.api.libs.json.{Json, OFormat}

case class CreateUserRequest(email: String, mobileNumber: String)

object CreateUserRequest {
  implicit val createUserRequestFormat: OFormat[CreateUserRequest] = Json.format[CreateUserRequest]
}
