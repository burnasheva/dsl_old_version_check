package MstestDotnet5.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object MstestDotnet5_HttpsGithubComBurnashevaMstestDotnet5gitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/burnasheva/mstest_dotnet5.git#refs/heads/main"
    url = "https://github.com/burnasheva/mstest_dotnet5.git"
    branch = "refs/heads/main"
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.USE_MIRRORS
})
