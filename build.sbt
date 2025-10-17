lazy val root = (project in file("."))
  .aggregate(functionalScala, catsEffects) // All projects in here
  .settings(
    name := "ScalaLearning",
    scalaVersion := "2.13.17" // Default Scala version for shared tasks
  )

// Subproject 1
lazy val functionalScala = (project in file("functionalscala"))
  .settings(
    name := "functionalscala",
    scalaVersion := "3.7.3", // Scala version for FunctionalScala specifically
    scalacOptions += "-Wnonunit-statement"
  )

// Subproject 2
lazy val catsEffects = (project in file("catseffects"))
  .settings(
    name := "catseffects",
    scalaVersion := "2.13.17", // Scala version for FunctionalScala specifically
    libraryDependencies += "org.typelevel" %% "cats-effect" % "3.6.3",
    scalacOptions += "-Wnonunit-statement"
  )