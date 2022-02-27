package MstestDotnet3Copy.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object MstestDotnet3Copy_Build : BuildType({
    uuid = "126813b3-bfed-4d31-8e04-f9b94c52a91b"
    name = "Build"

    vcs {
        root(MstestDotnet3Copy.vcsRoots.MstestDotnet3Copy_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster)
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
