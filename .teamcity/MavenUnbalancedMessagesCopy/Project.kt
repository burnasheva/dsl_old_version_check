package MavenUnbalancedMessagesCopy

import MavenUnbalancedMessagesCopy.buildTypes.*
import MavenUnbalancedMessagesCopy.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    uuid = "33355460-58b2-4da0-9fa2-df08b7f66cc8"
    id("MavenUnbalancedMessagesCopy")
    parentId("_Root")
    name = "Maven Unbalanced Messages Copy"

    vcsRoot(MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsH)

    buildType(MavenUnbalancedMessagesCopy_Build)
})
