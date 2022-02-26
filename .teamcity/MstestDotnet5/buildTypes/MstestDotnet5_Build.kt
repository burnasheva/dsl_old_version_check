package MstestDotnet5.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object MstestDotnet5_Build : BuildType({
    name = "Build"

    vcs {
        root(MstestDotnet5.vcsRoots.MstestDotnet5_HttpsGithubComBurnashevaMstestDotnet5gitRefsHeadsMain)
    }

    steps {
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
