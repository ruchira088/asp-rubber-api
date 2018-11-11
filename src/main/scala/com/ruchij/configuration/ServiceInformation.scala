package com.ruchij.configuration

import org.joda.time.DateTime

case class ServiceInformation(
  serviceName: String,
  serviceVersion: String,
  currentTime: DateTime,
  javaVersion: String,
  sbtVersion: String,
  scalaVersion: String
)
