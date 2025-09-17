package com.sinosoft.nlis.claim.settlement.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class BenefitStatusTest {
    
    @Test
    void testEnumConstants() {
        assertNotNull(BenefitStatus.JF);
        assertNotNull(BenefitStatus.JP);
        assertNotNull(BenefitStatus.BCD);
        assertNotNull(BenefitStatus.TRPF);
        assertNotNull(BenefitStatus.XYPF);

        assertEquals("JP", BenefitStatus.JP.name());
        assertEquals("JP", BenefitStatus.JP.name());
        assertEquals("BCD", BenefitStatus.BCD.name());
        assertEquals("TRPF", BenefitStatus.TRPF.name());
        assertEquals("XYPF", BenefitStatus.XYPF.name());
    }
    
    @Test
    void testEnumCode() {
        assertEquals("0", BenefitStatus.JF.getCode());
        assertEquals("1", BenefitStatus.JP.getCode());
        assertEquals("2", BenefitStatus.BCD.getCode());
        assertEquals("4", BenefitStatus.TRPF.getCode());
        assertEquals("5", BenefitStatus.XYPF.getCode());
    }

/* 
    @Test
    void testEnumDescription() {
        assertEquals("Description A", MyEnum.VALUE_A.getDescription());
        assertEquals("Description B", MyEnum.VALUE_B.getDescription());
    }
        */

}
