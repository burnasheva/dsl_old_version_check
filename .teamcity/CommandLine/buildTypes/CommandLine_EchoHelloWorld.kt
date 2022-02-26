package CommandLine.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

object CommandLine_EchoHelloWorld : BuildType({
    name = "Simple echo hello world"

    steps {
        script {
            scriptContent = """echo "hello, world!""""
            dockerImage = "ubuntu"
        }
    }
})
