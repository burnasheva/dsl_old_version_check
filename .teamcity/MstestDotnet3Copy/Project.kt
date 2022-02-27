package MstestDotnet3Copy

import MstestDotnet3Copy.buildTypes.*
import MstestDotnet3Copy.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    uuid = "0daa5c99-4a57-4312-ae55-922c62e88063"
    id("MstestDotnet3Copy")
    parentId("_Root")
    name = "Mstest Dotnet3 Copy"

    vcsRoot(MstestDotnet3Copy_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster)

    buildType(MstestDotnet3Copy_Build)
})
