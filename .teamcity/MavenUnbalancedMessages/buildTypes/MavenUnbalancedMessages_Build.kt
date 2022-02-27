package MavenUnbalancedMessages.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object MavenUnbalancedMessages_Build : BuildType({
    uuid = "02395279-78c9-4c51-a9f8-21c62adcffd0"
    id = "MavenUnbalancedMessages_Build"
    name = "Build"

    vcs {
        root(MavenUnbalancedMessages.vcsRoots.MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHe)

    }

    steps {
        maven {
            goals = "clean test"
            mavenVersion = defaultProvidedVersion()
        }
    }

    triggers {
        vcs {
        }
    }
})
