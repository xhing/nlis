package com.sinosoft.nlis.claim.settlement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sinosoft.nlis.claim.settlement.dto.ClaimItem;
import com.sinosoft.nlis.claim.settlement.enums.BenefitStatus;
import com.sinosoft.nlis.claim.settlement.service.impl.AuditConclusionServiceImpl;

public class AuditConclusionServiceTest {
    
    //@Mock
    //private AuditMapper auditMapper;

    private AuditConclusionService auditConclusionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        auditConclusionService = new AuditConclusionServiceImpl(); // Inject mocks into the service
    }

    @Test
    void testCheck_withBenefitCode0_1() {
        List<ClaimItem> claimItems = new ArrayList<ClaimItem>();
        // 给付
        ClaimItem item1 = new ClaimItem();
        item1.setBenefitCode(BenefitStatus.JF.getCode());
        item1.setItemName("item1");
        claimItems.add(item1);

        boolean result = auditConclusionService.check(claimItems, "正常赔付");
        assert(result == true);
    }

    @Test
    void testCheck_withBenefitCode0_2() {
        List<ClaimItem> claimItems = new ArrayList<ClaimItem>();
        // 给付
        ClaimItem item1 = new ClaimItem();
        item1.setBenefitCode(BenefitStatus.JF.getCode());
        item1.setItemName("item1");
        claimItems.add(item1);

        boolean result = auditConclusionService.check(claimItems, "审核回退");
        assert(result == true);
    }

@Test
    void testCheck_withBenefitCode0_3() {
        List<ClaimItem> claimItems = new ArrayList<ClaimItem>();
        // 给付
        ClaimItem item1 = new ClaimItem();
        item1.setBenefitCode(BenefitStatus.JF.getCode());
        item1.setItemName("item1");
        claimItems.add(item1);

        // 不承担
        ClaimItem item2 = new ClaimItem();
        item2.setBenefitCode(BenefitStatus.BCD.getCode());
        item2.setItemName("item2");
        claimItems.add(item2);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            auditConclusionService.check(claimItems, "部分赔付");
        });
        assertEquals("给付结论与审核结论不符，请核实", exception.getMessage());
    }

}
