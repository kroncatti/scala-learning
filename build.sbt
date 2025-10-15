lazy val root = (project in file("."))
  .aggregate(functionalScala) // All courses in here
  .settings(
    name := "ScalaLearning",
    scalaVersion := "2.13.17" // Default Scala version for shared tasks
  )

// Subproject 1
lazy val functionalScala = (project in file("FunctionalScala"))
  .settings(
    name := "FunctionalScala",
    scalaVersion := "2.13.17", // Scala version for FunctionalScala specifically
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.6.3",
    scalacOptions += "-Wnonunit-statement"
  )
