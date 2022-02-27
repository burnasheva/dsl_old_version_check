package MavenUnbalancedMessages

import MavenUnbalancedMessages.buildTypes.*
import MavenUnbalancedMessages.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("MavenUnbalancedMessages")
    parentId("_Root")
    name = "Maven Unbalanced Messages"

    vcsRoot(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsHeads)

    buildType(MavenUnbalancedMessages_Build)
})
