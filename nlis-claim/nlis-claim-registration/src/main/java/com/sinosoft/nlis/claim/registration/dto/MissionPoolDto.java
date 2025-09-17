package com.sinosoft.nlis.claim.registration.dto;

/**
 * 立案工作池信息DTO
 */
public class MissionPoolDto {
    /**
     * 立案号
     */
    private String rgtno;

    /**
     * 客户号
     */
    private String customerno;

    /**
     * 客户名称
     */
    private String customername;

    /**
     * 事故类型
     */
    private String accidenttype;

    /**
     * 事故（发生）日期
     */
    private String accidentdate;

    /**
     * 立案状态
     */
    private String rgtstate;

    /**
     * 立案日期
     */
    private String rgtmakedate;

    /**
     * 代理人组
     */
    private String agentgroup;
    /**
     * 代理人
     */
    private String agentname;

    /**
     * 保单号
     */
    private String contno;

    /**
     * 最后操作员
     */
    private String lastoperator;

    /**
     * 审核人
     */
    private String auditper;

    public String getRgtno() {
        return rgtno;
    }

    public void setRgtno(String rgtno) {
        this.rgtno = rgtno;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getAccidenttype() {
        return accidenttype;
    }

    public void setAccidenttype(String accidenttype) {
        this.accidenttype = accidenttype;
    }

    public String getAccidentdate() {
        return accidentdate;
    }

    public void setAccidentdate(String accidentdate) {
        this.accidentdate = accidentdate;
    }

    public String getRgtstate() {
        return rgtstate;
    }

    public void setRgtstate(String rgtstate) {
        this.rgtstate = rgtstate;
    }

    public String getRgtmakedate() {
        return rgtmakedate;
    }

    public void setRgtmakedate(String rgtmakedate) {
        this.rgtmakedate = rgtmakedate;
    }

    public String getAgentgroup() {
        return agentgroup;
    }

    public void setAgentgroup(String agentgroup) {
        this.agentgroup = agentgroup;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getContno() {
        return contno;
    }

    public void setContno(String contno) {
        this.contno = contno;
    }

    public String getLastoperator() {
        return lastoperator;
    }

    public void setLastoperator(String lastoperator) {
        this.lastoperator = lastoperator;
    }

    public String getAuditper() {
        return auditper;
    }

    public void setAuditper(String auditper) {
        this.auditper = auditper;
    }

}
