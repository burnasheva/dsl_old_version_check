package CommandLine

import CommandLine.buildTypes.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("CommandLine")
    name = "Command line"

    buildType(CommandLine_EchoHelloWorld)
})
