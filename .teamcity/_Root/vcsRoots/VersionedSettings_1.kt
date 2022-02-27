package _Root.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object VersionedSettings_1 : GitVcsRoot({
    uuid = "8ce958e5-165a-4248-af27-d34a984de2e3"
    id("VersionedSettings")
    name = "versioned settings"
    url = "https://github.com/burnasheva/dsl_old_version_check.git"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "burnasheva"
        password = "credentialsJSON:b523e5f0-9f59-4c9f-ae8f-b3ecb5fab8aa"
    }
})
