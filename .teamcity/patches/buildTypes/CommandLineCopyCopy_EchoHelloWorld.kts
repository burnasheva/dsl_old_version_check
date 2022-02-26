package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'CommandLineCopyCopy_EchoHelloWorld'
in the project with id = 'CommandLineCopyCopy', and delete the patch script.
*/
create(RelativeId("CommandLineCopyCopy"), BuildType({
    id("CommandLineCopyCopy_EchoHelloWorld")
    name = "Simple echo hello world"

    steps {
        script {
            scriptContent = """echo "hello, world!""""
            dockerImage = "ubuntu"
        }
    }
}))

