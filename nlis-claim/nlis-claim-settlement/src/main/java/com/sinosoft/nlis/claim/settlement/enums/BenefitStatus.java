package com.sinosoft.nlis.claim.settlement.enums;

/**
 * 给付状态
 */
public enum BenefitStatus {
    
    /**
     * 给付，状态码：0
     */
    JF("0"),
    /**
     * 拒赔，状态码：1
     */
    JP("1"),
    /**
     * 不承担，状态码：2
     */
    BCD("2"),
    /**
     * 通融赔付，状态码：4
     */
    TRPF("4"),
    /**
     * 协议赔付，状态码：5
     */
    XYPF("5");

    private String code;

    // Constructor
    BenefitStatus(String code) {
        this.code = code;
    }

    // Getter method
    public String getCode() {
        return code;
    }

}
