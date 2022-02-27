package SbtHelloworld13Copye.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object SbtHelloworld13Copye_Build : BuildType({
    uuid = "a87f4dba-8f45-415a-a19a-b4b94ea2a5d8"
    name = "Build"

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
