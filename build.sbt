lazy val root = (project in file("."))
  .aggregate(functionalScala) // All courses in here
  .settings(
    name := "ScalaLearning",
    scalaVersion := "3.3.4" // Default Scala version for shared tasks
  )

// Subproject 1
lazy val functionalScala = (project in file("functionalScala"))
  .settings(
    name := "FunctionalScala",
    scalaVersion := "3.3.4", // Scala version for FunctionalScala specifically
  )
