package MavenUnbalancedMessages.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/maven_unbalanced_messages.git#refs/heads/master"
    url = "https://github.com/burnasheva/maven_unbalanced_messages.git"
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.USE_MIRRORS
})
