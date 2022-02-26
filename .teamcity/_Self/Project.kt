package _Self

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.projectFeatures.dockerECRRegistry
import jetbrains.buildServer.configs.kotlin.projectFeatures.youtrack
import jetbrains.buildServer.configs.kotlin.sharedResource

object Project : Project({
    description = "Contains all other projects"

    params {
        param("a", "b")
    }

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
        dockerECRRegistry {
            id = "PROJECT_EXT_3"
            displayName = "Amazon ECR"
            registryId = "aaa"
            credentialsProvider = accessKey {
                accessKeyId = "aaa"
                secretAccessKey = "credentialsJSON:a1f44748-7c9a-4945-a8c9-0e8d5f6fb7ac"
            }
            regionCode = "eu-central-1"
            credentialsType = accessKeys()
        }
        sharedResource {
            id = "PROJECT_EXT_4"
            name = "abc_abc"
            resourceType = quoted(2)
        }
        youtrack {
            id = "PROJECT_EXT_5"
            displayName = "abc"
            host = "http://youtrack.com"
            userName = ""
            password = ""
            projectExtIds = "abc"
            accessToken = "credentialsJSON:787cf195-6dcb-4655-8353-282659ff4fda"
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(CommandLine.Project)
    subProject(DockerComposeGetStarted.Project)
    subProject(CsiTest.Project)
    subProject(MstestDotnet5.Project)
    subProject(MavenUnbalancedMessages.Project)
})
