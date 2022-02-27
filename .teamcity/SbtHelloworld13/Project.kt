package SbtHelloworld13

import SbtHelloworld13.buildTypes.*
import SbtHelloworld13.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "b6478b01-330e-4a7d-8a17-ab3eeea5a6b4"
    id = "SbtHelloworld13"
    parentId = "_Root"
    name = "Sbt Helloworld 1.3"

    vcsRoot(SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)

    buildType(SbtHelloworld13_Build)
})
