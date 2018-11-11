package web.controllers

import com.ruchij.configuration.ServiceConfiguration
import configuration.UserServiceConfigurableProps
import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._

@Singleton
class HomeController @Inject()(controllerComponents: ControllerComponents)(
  implicit serviceConfiguration: ServiceConfiguration[UserServiceConfigurableProps]
) extends AbstractController(controllerComponents) {

  def serviceInformation() =
    Action {
      Ok {
        Json.toJson(serviceConfiguration.serviceInformation())
      }
    }
}
