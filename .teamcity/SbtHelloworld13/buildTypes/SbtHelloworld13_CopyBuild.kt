package SbtHelloworld13.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object SbtHelloworld13_CopyBuild : BuildType({
    name = "Copy Build"

    params {
        param("q", "q")
    }

    vcs {
        root(SbtHelloworld13.vcsRoots.SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)
    }

    steps {
        step {
            type = "SBT"
        }
    }

    triggers {
        vcs {
        }
    }
})
