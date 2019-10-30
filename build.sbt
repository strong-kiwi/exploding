import sbt.Keys._
import sbt._

name := "kiwipower-exploding"
organization := "com.kiwipower"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.8" % Test)

