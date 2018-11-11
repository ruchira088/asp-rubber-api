package configuration

import com.ruchij.configuration.ServiceConfiguration
import play.api.libs.json.{Json, Writes}

case class UserServiceConfigurableProps()

object UserServiceConfigurableProps {
  implicit val userServiceConfigurablePropsWrites: Writes[UserServiceConfigurableProps] =
    (userServiceConfigurableProps: UserServiceConfigurableProps) => Json.obj()

  def apply(implicit serviceConfiguration: ServiceConfiguration[_]): UserServiceConfigurableProps =
    UserServiceConfigurableProps()
}
