package com.centiro.convergence.amg

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.HeavyPlatformTestCase
import org.junit.Before

abstract class AbstractAutomaticMapperGeneratorLightTest : HeavyPlatformTestCase() {
    protected lateinit var incomingMessageDir : VirtualFile
    protected lateinit var bqSchemaDir : VirtualFile
    protected lateinit var mapperDir : VirtualFile

    protected val application = "tmapi"

    override fun setUpProject() {
        super.setUpProject()

        // myProject = ProjectUtil.openOrImport(Paths.get("C:\\dev\\code\\centiro-convergence"))
    }

    @Before
    fun init() {

    }


}