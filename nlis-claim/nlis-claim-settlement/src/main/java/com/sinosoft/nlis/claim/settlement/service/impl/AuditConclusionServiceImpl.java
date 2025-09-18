package com.sinosoft.nlis.claim.settlement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sinosoft.nlis.claim.settlement.dto.ClaimItem;
import com.sinosoft.nlis.claim.settlement.enums.BenefitStatus;
import com.sinosoft.nlis.claim.settlement.enums.ClaimConclusion;
import com.sinosoft.nlis.claim.settlement.service.AuditConclusionService;

@Service
public class AuditConclusionServiceImpl implements AuditConclusionService {

    private static final Logger logger = LoggerFactory.getLogger(AuditConclusionServiceImpl.class);

    /**
     * 给付状态与理赔结论匹配性校验
     * 
     * @param claimItems 理赔项目列表
     * @param conclusion 理赔结论
     * @return boolean 校验通过返回true
     * @throws RuntimeException 给付结论与审核结论不符，请核实
     */
    @Override
    public boolean check(List<ClaimItem> claimItems, String conclusion) {

        String auditback = "审核回退";
        // 获取理赔项目的给付状态代码列表
        List<String> benefitCodes = getBenefitCodes(claimItems);
        logger.info("给付状态：{}", benefitCodes);

        // 当“给付状态”全部为给付，或者同时含给付和不承担，不含其他，那么审核结论只能是正常赔付或审核回退，否则提示“给付结论与审核结论不符，请核实”。
        if (benefitCodes.size() == 1 && BenefitStatus.JF.getCode().equals(benefitCodes.get(0))
                || benefitCodes.size() == 2 && benefitCodes.contains(BenefitStatus.JF.getCode()) && benefitCodes.contains(BenefitStatus.BCD.getCode())) {
            if (!ClaimConclusion.FULL.getText().equals(conclusion) && !auditback.equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        // 当“给付状态”为给付+拒赔、或者同时含给付+拒赔+不承担，不含其他，那么审核结论只能是部分赔付或审核回退，否则提示“给付结论与审核结论不符，请核实”。
        if (benefitCodes.size() == 2 && benefitCodes.contains(BenefitStatus.JF.getCode()) && benefitCodes.contains(BenefitStatus.JP.getCode())
                || benefitCodes.size() == 3 && benefitCodes.contains(BenefitStatus.JF.getCode()) && benefitCodes.contains(BenefitStatus.JP.getCode())
                        && benefitCodes.contains(BenefitStatus.BCD.getCode())) {
            if (!ClaimConclusion.PART.getText().equals(conclusion) && !auditback.equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        // 当“给付状态”全部为通融给付、或者同时含通融给付+不承担，不含其他，那么审核结论只能是通融赔付或审核回退，否则提示“给付结论与审核结论不符，请核实”。
        if (benefitCodes.size() == 1 && BenefitStatus.TRPF.getCode().equals(benefitCodes.get(0))
                || benefitCodes.size() == 2 && benefitCodes.contains(BenefitStatus.TRPF.getCode()) && benefitCodes.contains(BenefitStatus.BCD.getCode())) {
            if (!ClaimConclusion.EXGRATIA.getText().equals(conclusion) && !auditback.equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        // 当“给付状态”全部为协议给付、或者同时含协议给付+不承担，不含其他，那么审核结论只能是协议赔付或审核回退，否则提示“给付结论与审核结论不符，请核实”。
        if (benefitCodes.size() == 1 && BenefitStatus.XYPF.getCode().equals(benefitCodes.get(0))
                || benefitCodes.size() == 2 && benefitCodes.contains("5") && benefitCodes.contains("2")) {
            if (!ClaimConclusion.AGREEMENT.getText().equals(conclusion) && !auditback.equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        // 当“给付状态”全部为拒赔、或者同时含拒赔+不承担，不含其他，那么审核结论只能是拒赔或审核回退，否则提示“给付结论与审核结论不符，请核实”。
        if (benefitCodes.size() == 1 && BenefitStatus.JP.getCode().equals(benefitCodes.get(0))
                || benefitCodes.size() == 2 && benefitCodes.contains(BenefitStatus.JP.getCode()) && benefitCodes.contains(BenefitStatus.BCD.getCode())) {
            if (!ClaimConclusion.REJECT.getText().equals(conclusion) && !auditback.equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        // 当“给付状态”全部为“不承担”，那么审核结论只能是撤件或审核回退，否则提示“给付结论与审核结论不符，请核实”。
        if (benefitCodes.size() == 1 && BenefitStatus.BCD.getCode().equals(benefitCodes.get(0))) {
            if (!ClaimConclusion.CANCEL.getText().equals(conclusion) && !auditback.equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        // 当给付结论不是全部是“拒赔/拒赔+不承担”时，审核结论不能为拒赔，否则阻断提示“给付结论与审核结论不符，请核实”。
        if (!(benefitCodes.size() == 1 && BenefitStatus.JP.getCode().equals(benefitCodes.get(0))
                || benefitCodes.size() == 2 && benefitCodes.contains(BenefitStatus.JP.getCode()) && benefitCodes.contains(BenefitStatus.BCD.getCode()))) {
            if (ClaimConclusion.REJECT.getText().equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        // 当给付结论不是全部是“给付/给付+不承担”时，审核结论不能为正常给付，否则阻断提示“给付结论与审核结论不符，请核实”。
        if (!(benefitCodes.size() == 1 && BenefitStatus.JF.getCode().equals(benefitCodes.get(0))
                || benefitCodes.size() == 2 && benefitCodes.contains(BenefitStatus.JF.getCode()) && benefitCodes.contains(BenefitStatus.BCD.getCode()))) {
            if (ClaimConclusion.FULL.getText().equals(conclusion)) {
                throw new RuntimeException("给付结论与审核结论不符，请核实");
            }
        }

        return true;
    }

    /**
     * 获取理赔项目的给付状态代码列表
     * @param claimItems 理赔项目列表
     * @return 给付状态代码列表
     */
    private List<String> getBenefitCodes(List<ClaimItem> claimItems) {
        List<String> benefitCodes = new ArrayList<>();
        if (claimItems != null && !claimItems.isEmpty()) {
            for (ClaimItem item : claimItems) {
                String code = item.getBenefitCode();
                if (!benefitCodes.contains(code)) {
                    benefitCodes.add(code);
                }
            }
        }

        if (benefitCodes.isEmpty()) {
            logger.warn("没有找到给付状态代码");
        } else {
            logger.info("找到给付状态代码：{}", benefitCodes);
        }

        // 返回给付状态代码列表
        return benefitCodes;
    }

}
