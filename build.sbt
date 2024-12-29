lazy val root = (project in file("."))
  .aggregate(functionalScala) // All courses in here
  .settings(
    name := "ScalaLearning",
    scalaVersion := "3.3.0" // Default Scala version for shared tasks
  )

// Course 1 Subproject
lazy val functionalScala = (project in file("functional-scala"))
  .settings(
    name := "FunctionalScala",
    scalaVersion := "3.3.0", // Scala version for FunctionalScala specifically
  )