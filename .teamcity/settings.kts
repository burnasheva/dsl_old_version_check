import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dockerCompose
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab
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

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
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
