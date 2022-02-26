import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.csharpFile
import jetbrains.buildServer.configs.kotlin.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.projectFeatures.dockerECRRegistry
import jetbrains.buildServer.configs.kotlin.projectFeatures.youtrack
import jetbrains.buildServer.configs.kotlin.sharedResource
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

version = "2021.2"

project {
    description = "Contains all other projects"

    params {
        param("a", "с")
    }

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            // комментарий на русском
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
            name = "abc_abc_rename"
            enabled = false
            resourceType = quoted(3)
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

    subProject(CommandLine)
    subProject(DockerComposeGetStarted)
    subProject(CsiTest)
    subProject(MstestDotnet5)
    subProject(MavenUnbalancedMessages)
    subProject(MavenUnbalancedMessagesCopy)
}


object CommandLine : Project({
    name = "Command line"

    buildType(CommandLine_EchoHelloWorld)
})

object CommandLine_EchoHelloWorld : BuildType({
    name = "Simple echo hello world"

    steps {
        script {
            scriptContent = """echo "hello, world!""""
            dockerImage = "ubuntu"
        }
    }
})


object CsiTest : Project({
    name = "Csi Test"

    vcsRoot(CsiTest_GitGithubComBurnashevaCsiTestGitRefsHeadsMain)

    buildType(CsiTest_AutoDetectedBuild)

    params {
        param("а", "а")
    }
})

object CsiTest_AutoDetectedBuild : BuildType({
    name = "Auto detected build"

    vcs {
        root(CsiTest_GitGithubComBurnashevaCsiTestGitRefsHeadsMain)
    }

    steps {
        csharpFile {
            path = "hello.world.csx"
            tool = "%teamcity.tool.TeamCity.csi.DEFAULT%"
        }
        csharpFile {
            path = "include.hello.world.csx"
            tool = "%teamcity.tool.TeamCity.csi.DEFAULT%"
        }
    }

    triggers {
        vcs {
        }
    }
})

object CsiTest_GitGithubComBurnashevaCsiTestGitRefsHeadsMain : GitVcsRoot({
    name = "git@github.com:burnasheva/csi_test.git#refs/heads/main"
    url = "git@github.com:burnasheva/csi_test.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = defaultPrivateKey {
        userName = "git"
    }
})


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
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.USE_MIRRORS
})


object MavenUnbalancedMessages : Project({
    name = "Maven Unbalanced Messages"

    vcsRoot(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)

    buildType(MavenUnbalancedMessages_Build)
    buildType(MavenUnbalancedMessages_CopiedBuild)
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

object MavenUnbalancedMessages_CopiedBuild : BuildType({
    name = "copied build"

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
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.USE_MIRRORS
})


object MavenUnbalancedMessagesCopy : Project({
    name = "Maven Unbalanced Messages (copy)"

    vcsRoot(MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)

    buildType(MavenUnbalancedMessagesCopy_CopiedBuild)
    buildType(MavenUnbalancedMessagesCopy_Build)
})

object MavenUnbalancedMessagesCopy_Build : BuildType({
    name = "Build"

    vcs {
        root(MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)
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

object MavenUnbalancedMessagesCopy_CopiedBuild : BuildType({
    name = "copied build"

    vcs {
        root(MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster)
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

object MavenUnbalancedMessagesCopy_HttpsGithubComBurnashevaMavenUnbalancedMessagesGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/maven_unbalanced_messages.git#refs/heads/master"
    url = "https://github.com/burnasheva/maven_unbalanced_messages.git"
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.USE_MIRRORS
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
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.USE_MIRRORS
})
