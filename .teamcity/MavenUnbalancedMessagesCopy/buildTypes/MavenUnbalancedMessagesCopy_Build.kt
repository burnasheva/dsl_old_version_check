package MavenUnbalancedMessagesCopy.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object MavenUnbalancedMessagesCopy_Build : BuildType({
    name = "Build"

    vcs {
        root(MavenUnbalancedMessagesCopy.vcsRoots.MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }
})
