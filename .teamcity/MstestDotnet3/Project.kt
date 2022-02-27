package MstestDotnet3

import MstestDotnet3.buildTypes.*
import MstestDotnet3.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("MstestDotnet3")
    parentId("_Root")
    name = "Mstest Dotnet3"

    vcsRoot(MstestDotnet3_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster)

    buildType(MstestDotnet3_Build)
})
