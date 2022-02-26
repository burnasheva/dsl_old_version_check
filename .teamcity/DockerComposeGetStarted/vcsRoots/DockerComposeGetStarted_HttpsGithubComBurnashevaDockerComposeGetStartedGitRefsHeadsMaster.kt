package DockerComposeGetStarted.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object DockerComposeGetStarted_HttpsGithubComBurnashevaDockerComposeGetStartedGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/docker-compose-get-started.git#refs/heads/master"
    url = "https://github.com/burnasheva/docker-compose-get-started.git"
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.USE_MIRRORS
})
