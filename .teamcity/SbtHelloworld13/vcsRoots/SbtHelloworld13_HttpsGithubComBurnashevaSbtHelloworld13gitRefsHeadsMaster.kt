package SbtHelloworld13.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster : GitVcsRoot({
    uuid = "04a791a6-34e1-4abd-b3ab-de5980ffd711"
    id = "SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster"
    name = "https://github.com/burnasheva/sbt-helloworld-1-3.git#refs/heads/master"
    url = "https://github.com/burnasheva/sbt-helloworld-1-3.git"
})
