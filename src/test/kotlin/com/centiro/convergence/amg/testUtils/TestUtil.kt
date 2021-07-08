package com.centiro.convergence.amg.testUtils

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.project.Project
import java.lang.IllegalArgumentException
import java.util.logging.Logger

fun getExpectedResultName(testName : String) : String =
    when (testName) {
        "simpleObject" -> "simpleObject"
        "simpleObjectUnorderedKeys" -> "simpleObject"
        "complexObject" -> "complexObject"
        else -> throw IllegalArgumentException("Test $testName is not know")
    }

const val rootClassName = "RootName"


// TODO REMOVE
fun log(msg : String?) {
    Logger.getLogger("AutomaticMapperGenerator").info(msg ?: "")
}


/**
 * do the action that could be roll-back
 */
fun executeCouldRollBackAction(project: Project, action: (Project) -> Unit) {
    CommandProcessor.getInstance().executeCommand(project, {
        ApplicationManager.getApplication().runWriteAction {
            action.invoke(project)
        }
    }, "Creating File", "AutomaticMapperGenerator")
}