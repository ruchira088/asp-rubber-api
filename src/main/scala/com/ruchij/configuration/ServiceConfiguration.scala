package com.ruchij.configuration

import java.util.UUID

import org.joda.time.DateTime

trait ServiceConfiguration[+A] {
  def environmentVariables(): Map[String, String] = sys.env

  def currentTime(): DateTime = DateTime.now()

  def uuid(): UUID = UUID.randomUUID()

  def serviceInformation(): ServiceInformation

  def configurableProps(): A
}
