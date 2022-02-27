package _Root

import _Root.vcsRoots.*
import _Root.vcsRoots.VersionedSettings_1
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project
import jetbrains.buildServer.configs.kotlin.v2018_1.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2018_1.projectFeatures.versionedSettings

object Project : Project({
    uuid = "16ebd3fc-71e6-46bf-8010-8bb951c6a667"
    id("_Root")
    name = "<Root project>"
    description = "Contains all other projects"

    vcsRoot(VersionedSettings_1)

    params {
        param("qq", "qq222")
        param("aaaaaaa", "aaaaaaaa")
    }

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "ReportTab"
            param("startPage", "coverage.zip!index.html")
            param("title", "Code Coverage")
            param("type", "BuildReportTab")
        }
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = "${VersionedSettings_1.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }

    cleanup {
        preventDependencyCleanup = false
    }
})
