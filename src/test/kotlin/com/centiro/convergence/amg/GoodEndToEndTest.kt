package com.centiro.convergence.amg

import com.centiro.convergence.amg.testUtils.*

import com.intellij.psi.*

import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class GoodEndToEndTest(
    private val testName: String,
) : AbstractAutomaticMapperGeneratorLightTest() {


    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{0}")
        fun data(): Iterable<Array<Any>> {
            return arrayListOf(
                arrayOf("simpleObject")
            )
        }

    }

    @Test
    fun goodEndToEndTest() {
        testIncomingMessageGenerator()
    }


    private fun testIncomingMessageGenerator() {
        val kt = project.load()

        log("Got here ")
        // This complains but works
        log(kt.getClasses().first().isEnum.toString())

        // This does not complain
        val test : PsiClass = kt.getClasses().first()
        log(test.isEnum.toString())
    }

}