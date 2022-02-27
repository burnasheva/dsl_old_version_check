package SbtHelloworld13Copye.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object SbtHelloworld13Copye_CopyBuild : BuildType({
    uuid = "5a8618a1-dd59-4c92-b561-2adc2d2334b4"
    name = "Copy Build"

    params {
        param("q", "q")
    }

    vcs {
        root(SbtHelloworld13Copye.vcsRoots.SbtHelloworld13Copye_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)
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
