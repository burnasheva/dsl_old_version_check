package SbtHelloworld13

import SbtHelloworld13.buildTypes.*
import SbtHelloworld13.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("SbtHelloworld13")
    parentId("_Root")
    name = "Sbt Helloworld 1.3"

    vcsRoot(SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)

    buildType(SbtHelloworld13_CopyBuild)
    buildType(SbtHelloworld13_Build)
})
