package com.ruchij.configuration

import java.util.UUID

import org.joda.time.DateTime
import play.api.libs.json.{Json, Writes}

trait ServiceConfiguration[+A] {
  def environmentVariables(): Map[String, String] = sys.env

  def currentTime(): DateTime = DateTime.now()

  def uuid(): UUID = UUID.randomUUID()

  def serviceInformation(): ServiceInformation

  def configurableProps(): A
}

object ServiceConfiguration {
  def description[A](serviceConfiguration: ServiceConfiguration[A])(implicit writes: Writes[A]): String =
    s"""
       |*******************************************************
       |
       |Service information:
       |${prettyPrintJson(serviceConfiguration.serviceInformation())}
       |
       |Service configurable properties:
       |${prettyPrintJson(serviceConfiguration.configurableProps())}
       |
       |Environment variables:
       |${prettyPrintJson(serviceConfiguration.environmentVariables())}
       |
       |*******************************************************
     """.stripMargin

  private def prettyPrintJson[A](value: A)(implicit writes: Writes[A]): String =
    Json.prettyPrint(Json.toJson(value))
}
