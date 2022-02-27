package MavenUnbalancedMessagesCopy.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object MavenUnbalancedMessagesCopy_Build : BuildType({
    uuid = "e9916083-ded4-4a0a-9b19-9aadeb7236a5"
    name = "Build"

    vcs {
        root(MavenUnbalancedMessagesCopy.vcsRoots.MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsH)
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
