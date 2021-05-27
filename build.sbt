ThisBuild / scalaVersion := "2.12.13"

ThisBuild / organization := "org.alexr"
ThisBuild / version      := "0.0.5-SNAPSHOT"

lazy val `plugin-1` = (project in file("."))
  .settings(
    sbtPlugin := true,
  )
