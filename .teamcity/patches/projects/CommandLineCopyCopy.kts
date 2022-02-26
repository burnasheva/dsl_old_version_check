package patches.projects

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a project with id = 'CommandLineCopyCopy'
in the root project, and delete the patch script.
*/
create(DslContext.projectId, Project({
    id("CommandLineCopyCopy")
    name = "Command line (copy_copy)"
}))

