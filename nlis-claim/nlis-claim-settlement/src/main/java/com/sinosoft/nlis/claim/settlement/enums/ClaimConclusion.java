package com.sinosoft.nlis.claim.settlement.enums;

/**
 * 理赔结论
 */
public enum ClaimConclusion {
    
    /**
     * 正常赔付
     */
    FULL("正常赔付"), 
    /**
     * 部分赔付
     */
    PART("部分赔付"), 
    /**
     * 协议赔付
     */
    AGREEMENT("协议赔付"), 
    /**
     * 通融赔付
     */
    EXGRATIA("通融赔付"),
    /**
     * 拒赔
     */
    REJECT("拒赔"),
    /**
     * 撤件
     */
    CANCEL("撤件");

    private String text;

    // Constructor
    ClaimConclusion(String text) {
        this.text = text;
    }

    // Getter method
    public String getText() {
        return text;
    }

}
