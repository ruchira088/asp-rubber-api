package configuration

import com.ruchij.configuration.{ServiceConfiguration, ServiceInformation}
import com.ruchij.eed3si9n.BuildInfo

import scala.util.Properties

object UserServiceConfiguration extends ServiceConfiguration[UserServiceConfigurableProps] {
  self =>

  override def serviceInformation(): ServiceInformation =
    ServiceInformation(
      BuildInfo.name,
      BuildInfo.version,
      currentTime(),
      Properties.javaVersion,
      BuildInfo.sbtVersion,
      BuildInfo.scalaVersion
    )

  override def configurableProps(): UserServiceConfigurableProps =
    UserServiceConfigurableProps(self)
}
