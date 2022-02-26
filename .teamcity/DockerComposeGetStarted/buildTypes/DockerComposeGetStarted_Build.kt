package DockerComposeGetStarted.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object DockerComposeGetStarted_Build : BuildType({
    name = "Build"

    vcs {
        root(DockerComposeGetStarted.vcsRoots.DockerComposeGetStarted_HttpsGithubComBurnashevaDockerComposeGetStartedGitRefsHeadsMaster)
    }

    steps {
        dockerCommand {
            commandType = build {
                source = file {
                    path = "Dockerfile"
                }
            }
        }
        dockerCompose {
            file = "docker-compose.yml"
        }
    }

    triggers {
        vcs {
        }
    }
})
