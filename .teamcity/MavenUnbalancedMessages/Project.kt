package MavenUnbalancedMessages

import MavenUnbalancedMessages.buildTypes.*
import MavenUnbalancedMessages.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("MavenUnbalancedMessages")
    name = "Maven Unbalanced Messages"

    vcsRoot(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)

    buildType(MavenUnbalancedMessages_Build)
    buildType(MavenUnbalancedMessages_CopiedBuild)
})
