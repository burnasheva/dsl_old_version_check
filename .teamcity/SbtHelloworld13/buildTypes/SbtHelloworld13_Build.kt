package SbtHelloworld13.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object SbtHelloworld13_Build : BuildType({
    uuid = "8aebfa6c-e4d4-4323-9056-3ff9b08a3bf4"
    id = "SbtHelloworld13_Build"
    name = "Build"

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
