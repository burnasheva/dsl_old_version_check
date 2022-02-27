package MavenUnbalancedMessages.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsHeads : GitVcsRoot({
    name = "https://github.com/burnasheva/maven_unbalanced_messages#refs/heads/master"
    url = "https://github.com/burnasheva/maven_unbalanced_messages"
})
