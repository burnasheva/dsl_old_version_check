package MavenUnbalancedMessages.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object MavenUnbalancedMessages_Build : BuildType({
    name = "Build"

    vcs {
        root(MavenUnbalancedMessages.vcsRoots.MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsHeads)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = defaultProvidedVersion()
        }
    }

    triggers {
        vcs {
        }
    }
})
