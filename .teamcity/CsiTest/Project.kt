package CsiTest

import CsiTest.buildTypes.*
import CsiTest.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("CsiTest")
    name = "Csi Test"

    vcsRoot(CsiTest_GitGithubComBurnashevaCsiTestGitRefsHeadsMain)

    buildType(CsiTest_AutoDetectedBuild)

    params {
        param("а", "а")
    }
})
