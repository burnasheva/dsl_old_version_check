package MstestDotnet5

import MstestDotnet5.buildTypes.*
import MstestDotnet5.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("MstestDotnet5")
    name = "Mstest Dotnet5"

    vcsRoot(MstestDotnet5_HttpsGithubComBurnashevaMstestDotnet5gitRefsHeadsMain)

    buildType(MstestDotnet5_Build)
})
