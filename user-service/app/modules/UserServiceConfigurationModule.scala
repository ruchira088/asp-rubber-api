package modules

import com.google.inject.{AbstractModule, TypeLiteral}
import com.ruchij.configuration.ServiceConfiguration
import configuration.{UserServiceConfigurableProps, UserServiceConfiguration}

class UserServiceConfigurationModule extends AbstractModule {
  override def configure(): Unit = {
    bind(new TypeLiteral[ServiceConfiguration[UserServiceConfigurableProps]] {})
      .toInstance(UserServiceConfiguration)

    println(ServiceConfiguration.description(UserServiceConfiguration))
  }
}
