package _Root.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object VersionedSettingsRoot : GitVcsRoot({
    uuid = "789787c3-3f35-4470-a5c3-92c938e2ceb3"
    id = "VersionedSettingsRoot"
    name = "versioned settings root"
    url = "https://github.com/burnasheva/dsl_old_version_check.git"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "burnasheva"
        password = "credentialsJSON:aecef0bc-399d-4f15-b925-0f3f7aa0bc2d"
    }
})
