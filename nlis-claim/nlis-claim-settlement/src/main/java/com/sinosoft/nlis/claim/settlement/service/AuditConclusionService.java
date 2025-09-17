package com.sinosoft.nlis.claim.settlement.service;

import java.util.List;

import com.sinosoft.nlis.claim.settlement.dto.ClaimItem;

public interface AuditConclusionService {

    boolean check(List<ClaimItem> claimItems, String conclusion);

}
