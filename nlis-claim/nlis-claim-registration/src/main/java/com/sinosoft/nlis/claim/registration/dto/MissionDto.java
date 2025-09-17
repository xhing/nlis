package com.sinosoft.nlis.claim.registration.dto;

import java.util.Date;

/**
 * 立案信息DTO
 */
public class MissionDto {

    /**
     * 立案流程编号
     */
    private String processid;

    /**
     * 流程激活状态
     */
    private String activitystatus;

    /**
     * 立案数据属性1
     */
    private String missionprop1;

    /**
     * 立案数据属性2
     */
    private String missionprop2;

    /**
     * 立案数据属性3
     */
    private String missionprop3;

    /**
     * 最后操作员
     */
    private String lastoperator;

    /**
     * 创建操作员
     */
    private String createoperator;

    /**
     * 创建日期
     */
    private Date makedate;

    /**
     * 创建时间
     */
    private String maketime;

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid;
    }

    public String getActivitystatus() {
        return activitystatus;
    }

    public void setActivitystatus(String activitystatus) {
        this.activitystatus = activitystatus;
    }

    public String getMissionprop1() {
        return missionprop1;
    }

    public void setMissionprop1(String missionprop1) {
        this.missionprop1 = missionprop1;
    }

    public String getMissionprop2() {
        return missionprop2;
    }

    public void setMissionprop2(String missionprop2) {
        this.missionprop2 = missionprop2;
    }

    public String getMissionprop3() {
        return missionprop3;
    }

    public void setMissionprop3(String missionprop3) {
        this.missionprop3 = missionprop3;
    }

    public String getLastoperator() {
        return lastoperator;
    }

    public void setLastoperator(String lastoperator) {
        this.lastoperator = lastoperator;
    }

    public String getCreateoperator() {
        return createoperator;
    }

    public void setCreateoperator(String createoperator) {
        this.createoperator = createoperator;
    }

    public Date getMakedate() {
        return makedate;
    }

    public void setMakedate(Date makedate) {
        this.makedate = makedate;
    }

    public String getMaketime() {
        return maketime;
    }

    public void setMaketime(String maketime) {
        this.maketime = maketime;
    }

}
