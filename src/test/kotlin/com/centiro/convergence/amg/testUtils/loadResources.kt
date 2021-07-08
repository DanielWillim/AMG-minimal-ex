package com.centiro.convergence.amg.testUtils

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.codeStyle.CodeStyleManager
import org.jetbrains.kotlin.idea.KotlinLanguage
import org.jetbrains.kotlin.psi.KtFile

fun Project.load() : KtFile {
    val content =  """
        package com.centiro.convergence.processingpipeline.incomingmessages.tmapi.rootname

        import com.centiro.convergence.common.mappers.BaseElement
        import com.fasterxml.jackson.annotation.JsonProperty

        data class RootName(
                @get:JsonProperty("array")
                val array: List<Long>?,
                @get:JsonProperty("boolKey")
                val boolKey: Boolean?,
                @get:JsonProperty("doubleKey")
                val doubleKey: Double?,
                @get:JsonProperty("intKey")
                val intKey: Long?,
                @get:JsonProperty("stringKey")
                val stringKey: String?,
        ) : BaseElement
    """.trimIndent()

    var file : KtFile? = null

    executeCouldRollBackAction(this) {
        file = this.createKotlinPsiFile(rootClassName, content) as KtFile
    }
    return file!!

}

/**
 * Will create a psiFile with specified name and content, will also reformat the file to comply to specified code style
 *
 * Since it modifies the create PsiFile, this function need to be warped in a executeActionCouldRollBack{..}
 */
fun Project.createKotlinPsiFile(fileName: String, content: String): PsiFile {
    val ktFile = PsiFileFactory
        .getInstance(this)
        .createFileFromText("$fileName.kt", KotlinLanguage.INSTANCE, content)

    return CodeStyleManager.getInstance(this).reformat(ktFile) as PsiFile
}