package com.example.knap_web_v1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnapLoggingMessageBuilderTest {

    @Test
    public void testKnapLoggingMessageBuilder() {
        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel("Test Message")
                .messageParams("param1", "param2")
                .plant("TestPlant")
                .alertToBiz()
                .build();

        assertNotNull(knapLoggingMessage);
        assertEquals("Test Message", knapLoggingMessage.getMessageLabel());
        assertArrayEquals(new String[]{"param1", "param2"}, knapLoggingMessage.getMessageParams());
        assertEquals("TestPlant", knapLoggingMessage.getPlant());
        assertTrue(knapLoggingMessage.isAlertToBiz());
        assertFalse(knapLoggingMessage.isAlertToTec());
        assertFalse(knapLoggingMessage.isSaveToDb());

    }

    @Test
    public void testKnapLoggingMessageBuilderWithMultipleParams() {
        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel("Test Message with Multiple Params")
                .messageParams("param1", "param2", "param3", "param4", "param5")
                .plant("TestPlant")
                .alertToTec()
                .saveToDb()
                .build();

        assertNotNull(knapLoggingMessage);
        assertEquals("Test Message with Multiple Params", knapLoggingMessage.getMessageLabel());
        assertArrayEquals(new String[]{"param1", "param2", "param3", "param4", "param5"},
                knapLoggingMessage.getMessageParams());
        assertEquals("TestPlant", knapLoggingMessage.getPlant());
        assertFalse(knapLoggingMessage.isAlertToBiz());
        assertTrue(knapLoggingMessage.isAlertToTec());
        assertTrue(knapLoggingMessage.isSaveToDb());
    }

    @Test
    public void testKnapLoggingMessageBuilderWithNoParams() {
        KnapLoggingMessage knapLoggingMessage = new KnapLoggingMessageBuilder()
                .messageLabel("Test Message with No Params")
                .plant("TestPlant")
                .build();

        assertNotNull(knapLoggingMessage);
        assertEquals("Test Message with No Params", knapLoggingMessage.getMessageLabel());
        assertArrayEquals(new String[]{}, knapLoggingMessage.getMessageParams());
        assertEquals("TestPlant", knapLoggingMessage.getPlant());
        assertFalse(knapLoggingMessage.isAlertToBiz());
        assertFalse(knapLoggingMessage.isAlertToTec());
        assertFalse(knapLoggingMessage.isSaveToDb());
    }
}

