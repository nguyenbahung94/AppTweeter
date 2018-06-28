package com.example.billy.apptweeter

import com.example.billy.apptweeter.utils.containCharacter
import com.example.billy.apptweeter.utils.hasSpace
import com.example.billy.apptweeter.utils.splitMessage
import org.junit.Assert
import org.junit.Test

class MockitoTest {

    @Test
    fun testHasSpace() {
        val messageDontHaSpace = "123456789123456789123456789123456789123456789123456789"
        Assert.assertEquals(hasSpace(messageDontHaSpace), true)

        val messageHaveSpace = "123456789 123456789 123456789 123456789 123456789"
        Assert.assertEquals(hasSpace(messageHaveSpace), false)
    }

    @Test
    fun testSplitMessage() {
        val messageCase1 = "I believe it I believe it I believe it"
        Assert.assertEquals(splitMessage(messageCase1), messageCase1)

        val messageCase2 = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."
        val result = "[\"1/2 I can't believe Tweeter now supports chunking\",\"2/2 my messages, so I don't have to do it myself.\"]"
        Assert.assertEquals(
                splitMessage(messageCase2),
                result
        )
    }
}