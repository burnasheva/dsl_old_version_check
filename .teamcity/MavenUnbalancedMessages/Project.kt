package MavenUnbalancedMessages

import MavenUnbalancedMessages.buildTypes.*
import MavenUnbalancedMessages.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "30b7fc93-c5dd-4b9e-ac02-6daa010874f9"
    id = "MavenUnbalancedMessages"
    parentId = "_Root"
    name = "Maven Unbalanced Messages"

    vcsRoot(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHe)

    buildType(MavenUnbalancedMessages_Build)
})
