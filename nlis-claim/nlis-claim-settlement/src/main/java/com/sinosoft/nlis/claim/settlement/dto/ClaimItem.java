package com.sinosoft.nlis.claim.settlement.dto;

/**
 * 理赔项目
 */
public class ClaimItem {
    
    /**
     * 理赔项目名称
     */
    private String itemName;

    /**
     * 给付状态代码：0-给付，1-拒赔，2-不承担，4-通融给付，5-协议给付
     */
    private String benefitCode; 

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

}
