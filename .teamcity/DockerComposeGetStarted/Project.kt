package DockerComposeGetStarted

import DockerComposeGetStarted.buildTypes.*
import DockerComposeGetStarted.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({
    id("DockerComposeGetStarted")
    name = "Docker Compose Get Started"

    vcsRoot(DockerComposeGetStarted_HttpsGithubComBurnashevaDockerComposeGetStartedGitRefsHeadsMaster)

    buildType(DockerComposeGetStarted_Build)
})
