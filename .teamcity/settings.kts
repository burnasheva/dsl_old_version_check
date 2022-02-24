import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.dockerECRRegistry
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.youtrack
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.2"

project {
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
        feature {
            id = "PROJECT_EXT_4"
            type = "JetBrains.SharedResources"
            param("quota", "2")
            param("name", "abc_abc")
            param("type", "quoted")
        }
        youtrack {
            id = "PROJECT_EXT_5"
            displayName = "abc"
            host = "http://youtrack.com"
            userName = ""
            password = ""
            projectExtIds = "abc"
            accessToken = "credentialsJSON:787cf195-6dcb-4655-8353-282659ff4fda"
            param("authType", "accesstoken")
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(DockerComposeGetStarted)
    subProject(MstestDotnet5)
    subProject(MavenUnbalancedMessages)
}


object DockerComposeGetStarted : Project({
    name = "Docker Compose Get Started"

    vcsRoot(DockerComposeGetStarted_HttpsGithubComBurnashevaDockerComposeGetStartedGitRefsHeadsMaster)

    buildType(DockerComposeGetStarted_Build)
})

object DockerComposeGetStarted_Build : BuildType({
    name = "Build"

    vcs {
        root(DockerComposeGetStarted_HttpsGithubComBurnashevaDockerComposeGetStartedGitRefsHeadsMaster)
    }

    steps {
        dockerCommand {
            commandType = build {
                source = file {
                    path = "Dockerfile"
                }
            }
        }
        dockerCompose {
            file = "docker-compose.yml"
        }
    }

    triggers {
        vcs {
        }
    }
})

object DockerComposeGetStarted_HttpsGithubComBurnashevaDockerComposeGetStartedGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/docker-compose-get-started.git#refs/heads/master"
    url = "https://github.com/burnasheva/docker-compose-get-started.git"
})


object MavenUnbalancedMessages : Project({
    name = "Maven Unbalanced Messages"

    vcsRoot(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)

    buildType(MavenUnbalancedMessages_Build)
})

object MavenUnbalancedMessages_Build : BuildType({
    name = "Build"

    vcs {
        root(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }
})

object MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/maven_unbalanced_messages.git#refs/heads/master"
    url = "https://github.com/burnasheva/maven_unbalanced_messages.git"
})

object CommandLine : Project({
    name = "Command line"

    buildType(CommandLine_EchoHelloWorld)
})

object CommandLine_EchoHelloWorld : BuildType({
    name = "Simple echo hello world"

    steps {
        script {
            dockerImage = "ubuntu"
            scriptContent = """
                echo "hello, world!"
                """.trimIndent()
        }
    }
})


object MstestDotnet5 : Project({
    name = "Mstest Dotnet5"

    vcsRoot(MstestDotnet5_HttpsGithubComBurnashevaMstestDotnet5gitRefsHeadsMain)

    buildType(MstestDotnet5_Build)
})

object MstestDotnet5_Build : BuildType({
    name = "Build"

    vcs {
        root(MstestDotnet5_HttpsGithubComBurnashevaMstestDotnet5gitRefsHeadsMain)
    }

    steps {
        dotnetBuild {
            projects = "MSTestCore.sln"
        }
        dotnetTest {
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
        }
    }

    triggers {
        vcs {
        }
    }
})

object MstestDotnet5_HttpsGithubComBurnashevaMstestDotnet5gitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/burnasheva/mstest_dotnet5.git#refs/heads/main"
    url = "https://github.com/burnasheva/mstest_dotnet5.git"
    branch = "refs/heads/main"
})
