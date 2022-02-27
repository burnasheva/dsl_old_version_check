package SbtHelloworld13.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/sbt-helloworld-1-3.git#refs/heads/master"
    url = "https://github.com/burnasheva/sbt-helloworld-1-3.git"
})
