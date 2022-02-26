package MavenUnbalancedMessagesCopy

import MavenUnbalancedMessagesCopy.buildTypes.*
import MavenUnbalancedMessagesCopy.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("MavenUnbalancedMessagesCopy")
    name = "Maven Unbalanced Messages (Copy)"

    vcsRoot(MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)

    buildType(MavenUnbalancedMessagesCopy_CopiedBuild)
    buildType(MavenUnbalancedMessagesCopy_Build)
})
