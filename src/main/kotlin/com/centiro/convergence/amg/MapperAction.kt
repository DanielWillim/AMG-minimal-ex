package com.centiro.convergence.amg

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class MapperAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project

        Messages.showMessageDialog(project, "Hello from Kotlin!", "Greeting", Messages.getInformationIcon())
    }
}