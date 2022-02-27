import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

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

version = "2018.1"

project {
    description = "Contains all other projects"

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "ReportTab"
            param("startPage", "coverage.zip!index.html")
            param("title", "Code Coverage")
            param("type", "BuildReportTab")
        }
    }

    cleanup {
        preventDependencyCleanup = false
    }

    subProject(SbtHelloworld13)
    subProject(MavenUnbalancedMessages)
    subProject(MstestDotnet3)
}


object MavenUnbalancedMessages : Project({
    name = "Maven Unbalanced Messages"

    vcsRoot(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsHeads)

    buildType(MavenUnbalancedMessages_Build)
})

object MavenUnbalancedMessages_Build : BuildType({
    name = "Build"

    vcs {
        root(MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsHeads)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = defaultProvidedVersion()
        }
    }

    triggers {
        vcs {
        }
    }
})

object MavenUnbalancedMessages_HttpsGithubComBurnashevaMavenUnbalancedMessagesRefsHeads : GitVcsRoot({
    name = "https://github.com/burnasheva/maven_unbalanced_messages#refs/heads/master"
    url = "https://github.com/burnasheva/maven_unbalanced_messages"
})


object MstestDotnet3 : Project({
    name = "Mstest Dotnet3"

    vcsRoot(MstestDotnet3_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster)

    buildType(MstestDotnet3_Build)
})

object MstestDotnet3_Build : BuildType({
    name = "Build"

    vcs {
        root(MstestDotnet3_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "MSTestCore.sln"
        }
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

object MstestDotnet3_HttpsGithubComBurnashevaMstestDotnet3gitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/mstest_dotnet3.git#refs/heads/master"
    url = "https://github.com/burnasheva/mstest_dotnet3.git"
})


object SbtHelloworld13 : Project({
    name = "Sbt Helloworld 1.3"

    vcsRoot(SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)

    buildType(SbtHelloworld13_CopyBuild)
    buildType(SbtHelloworld13_Build)
})

object SbtHelloworld13_Build : BuildType({
    name = "Build"

    params {
        param("q", "q")
    }

    vcs {
        root(SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)
    }

    steps {
        step {
            type = "SBT"
        }
    }

    triggers {
        vcs {
        }
    }
})

object SbtHelloworld13_CopyBuild : BuildType({
    name = "Copy Build"

    params {
        param("q", "q")
    }

    vcs {
        root(SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster)
    }

    steps {
        step {
            type = "SBT"
        }
    }

    triggers {
        vcs {
        }
    }
})

object SbtHelloworld13_HttpsGithubComBurnashevaSbtHelloworld13gitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/sbt-helloworld-1-3.git#refs/heads/master"
    url = "https://github.com/burnasheva/sbt-helloworld-1-3.git"
})
