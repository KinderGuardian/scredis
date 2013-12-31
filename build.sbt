organization := "com.livestream"

name := "scredis"

version := "1.0.2"

scalaVersion := "2.9.3"

crossScalaVersions := Seq("2.9.0", "2.9.1", "2.9.2", "2.9.3")

scalacOptions ++= Seq("-deprecation")

resolvers += "Akka Repo" at "http://repo.akka.io/repository"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-api" % "1.7.5" intransitive (),
  "org.apache.commons" % "commons-lang3" % "3.1",
  "commons-pool" % "commons-pool" % "1.6",
  "com.typesafe" % "config" % "1.0.0",
  "com.typesafe.akka" % "akka-actor" % "2.0.5",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

publishTo <<= version { (v: String) =>
  val repository = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at repository + "content/repositories/snapshots")
  else
    Some("releases" at repository + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/Livestream/scredis</url>
  <licenses>
    <license>
      <name>The Apache Software License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:Livestream/scredis.git</url>
    <connection>scm:git:git@github.com:Livestream/scredis.git</connection>
  </scm>
  <developers>
    <developer>
      <id>curreli</id>
      <name>Alexandre Curreli</name>
      <url>https://github.com/curreli</url>
    </developer>
  </developers>
)

parallelExecution in Test := false

concurrentRestrictions in Global += Tags.limit(Tags.Test, 1)

site.settings

ghpages.settings

git.remoteRepo := "git@github.com:Livestream/scredis.git"

site.includeScaladoc("")