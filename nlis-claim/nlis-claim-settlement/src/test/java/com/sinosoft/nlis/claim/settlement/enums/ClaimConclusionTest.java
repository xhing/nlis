package com.sinosoft.nlis.claim.settlement.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ClaimConclusionTest {
    
        @Test
    void testEnumConstants() {
        assertNotNull(ClaimConclusion.FULL);
        assertNotNull(ClaimConclusion.PART);
        assertNotNull(ClaimConclusion.AGREEMENT);
        assertNotNull(ClaimConclusion.EXGRATIA);
        assertNotNull(ClaimConclusion.REJECT);
        assertNotNull(ClaimConclusion.CANCEL);

        assertEquals("FULL", ClaimConclusion.FULL.name());
        assertEquals("PART", ClaimConclusion.PART.name());
        assertEquals("AGREEMENT", ClaimConclusion.AGREEMENT.name());
        assertEquals("EXGRATIA", ClaimConclusion.EXGRATIA.name());
        assertEquals("REJECT", ClaimConclusion.REJECT.name());
        assertEquals("CANCEL", ClaimConclusion.CANCEL.name());
    }
    
    @Test
    void testEnumText() {
        assertEquals("正常赔付", ClaimConclusion.FULL.getText());
        assertEquals("部分赔付", ClaimConclusion.PART.getText());
        assertEquals("协议赔付", ClaimConclusion.AGREEMENT.getText());
        assertEquals("通融赔付", ClaimConclusion.EXGRATIA.getText());
        assertEquals("拒赔", ClaimConclusion.REJECT.getText());
        assertEquals("撤件", ClaimConclusion.CANCEL.getText());
    }

}
