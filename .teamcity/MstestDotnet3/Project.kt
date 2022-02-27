package MstestDotnet3

import MstestDotnet3.buildTypes.*
import MstestDotnet3.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "ab3de252-0847-4f9c-9561-c62743d911ff"
    id = "MstestDotnet3"
    parentId = "_Root"
    name = "Mstest Dotnet3"

    vcsRoot(MstestDotnet3_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster)

    buildType(MstestDotnet3_Build)
})
