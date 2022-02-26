package CsiTest.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.csharpFile
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object CsiTest_AutoDetectedBuild : BuildType({
    name = "Auto detected build"

    vcs {
        root(CsiTest.vcsRoots.CsiTest_GitGithubComBurnashevaCsiTestGitRefsHeadsMain)
    }

    steps {
        csharpFile {
            path = "hello.world.csx"
            tool = "%teamcity.tool.TeamCity.csi.DEFAULT%"
        }
        csharpFile {
            path = "include.hello.world.csx"
            tool = "%teamcity.tool.TeamCity.csi.DEFAULT%"
        }
    }

    triggers {
        vcs {
        }
    }
})
