package MstestDotnet3.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object MstestDotnet3_Build : BuildType({
    uuid = "16270ab5-5121-4bcc-9694-67f1a869afdb"
    id = "MstestDotnet3_Build"
    name = "Build"

    vcs {
        root(MstestDotnet3.vcsRoots.MstestDotnet3_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster)

    }

    steps {
        dotnetRestore {
            projects = "MSTestCore.sln"
        }
        dotnetBuild {
            projects = "MSTestCore.sln"
        }
        dotnetTest {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
        }
    }

    triggers {
        vcs {
        }
    }
})
