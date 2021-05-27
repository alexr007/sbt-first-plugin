package org.alexr.sbt

import sbt.Keys._
import sbt.nio.Keys.{ReloadOnSourceChanges, onChangedBuildSource}
import sbt.{Def, _}

object ScalaBootstrap extends AutoPlugin {

  object const {
    val lihaoyi = Seq(
      "com.lihaoyi"       %% "pprint"                   % "0.6.6",
      "com.lihaoyi"       %% "fansi"                    % "0.2.14",
      "com.lihaoyi"       %% "upickle"                  % "1.3.15",
    )
    val scalaTest = Seq(
      "org.scalatest"     %% "scalatest-shouldmatchers" % "3.2.9",
      "org.scalatest"     %% "scalatest-funspec"        % "3.2.9",
    )
    val scalaCheck = Seq(
      "org.scalacheck"    %% "scalacheck"               % "1.15.4"
    )
    val myLibraries: Seq[ModuleID] = Seq(lihaoyi, scalaTest, scalaTest).flatten

    val scalacOptions = Seq(
      "-unchecked",
      "-Xfatal-warnings",
      "-feature",
      "-language:higherKinds",
      "-deprecation",
      "-Ywarn-dead-code",
      "-Ywarn-unused:-implicits,-explicits,_",
    )
  }

  // just project settings & some dependencies
  override def projectSettings: Seq[Setting[_]] = Seq(
    Global / onChangedBuildSource := ReloadOnSourceChanges,
    libraryDependencies ++= const.myLibraries,
    scalaVersion := "2.13.5",
    scalacOptions ++= const.scalacOptions,
  )

  // some auto running tasks
  override def buildSettings: Seq[Def.Setting[_]] = Seq(
    SettingKey[Unit]("generate uuid") := println(java.util.UUID.randomUUID()),
    SettingKey[Unit]("copyExtraFiles") := {
      IO.write(
        file("1.txt"),
        "Hello from plugin"
      )
    }
  )

}
