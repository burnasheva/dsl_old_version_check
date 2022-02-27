package SbtHelloworld13Copye

import SbtHelloworld13Copye.buildTypes.*
import SbtHelloworld13Copye.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    uuid = "bac83239-a4f0-4061-ba26-be32aaf001ae"
    id("SbtHelloworld13Copye")
    parentId("_Root")
    name = "Sbt Helloworld 1.3 Copye"

    vcsRoot(SbtHelloworld13Copye_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)

    buildType(SbtHelloworld13Copye_CopyBuild)
    buildType(SbtHelloworld13Copye_Build)
})
