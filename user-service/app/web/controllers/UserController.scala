package web.controllers

import com.ruchij.web.RequestUtils.parseAndValidate
import javax.inject.{Inject, Singleton}
import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, ControllerComponents, Request}
import web.requests.CreateUserRequest

import scala.concurrent.ExecutionContext

@Singleton
class UserController @Inject()(controllerComponents: ControllerComponents)(implicit executionContext: ExecutionContext)
    extends AbstractController(controllerComponents) {

//  def createUser() =
//    Action.async(parse.json) {
//      implicit request: Request[JsValue] =>
//        for {
//          createUserRequest <- parseAndValidate[CreateUserRequest](request.body)
//        }
//        yield ???
//    }
}
