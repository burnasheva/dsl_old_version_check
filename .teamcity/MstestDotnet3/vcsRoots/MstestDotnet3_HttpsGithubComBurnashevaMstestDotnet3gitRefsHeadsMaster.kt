package MstestDotnet3.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object MstestDotnet3_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/mstest_dotnet3.git#refs/heads/master"
    url = "https://github.com/burnasheva/mstest_dotnet3.git"
})
