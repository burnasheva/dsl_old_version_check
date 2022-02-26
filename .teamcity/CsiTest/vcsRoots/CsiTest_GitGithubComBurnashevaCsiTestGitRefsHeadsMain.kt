package CsiTest.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object CsiTest_GitGithubComBurnashevaCsiTestGitRefsHeadsMain : GitVcsRoot({
    name = "git@github.com:burnasheva/csi_test.git#refs/heads/main"
    url = "git@github.com:burnasheva/csi_test.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = defaultPrivateKey {
        userName = "git"
    }
})
