package com.sinosoft.nlis.claim.registration.service;

import java.util.List;

import com.sinosoft.nlis.claim.registration.dto.MissionDto;
import com.sinosoft.nlis.claim.registration.dto.MissionPoolDto;

public interface MissionService {

    /**
     * 获取立案工作池中可申领的案件数目
     * @param operator 操作员
     * @param comcode 机构代码
     * @param missionid 任务ID
     * @param flag 理赔模块业务标识
     * @return 可申领案件数目
     */
    int countPendingCases(String operator, String comcode, String missionid, String flag);

    /**
     * 获取当前操作员的立案工作池中的案件信息
     * @param operator 操作员
     * @param comcode 机构代码
     * @return 当前用户名下的立案案件信息列表
     */
    List<MissionDto> getMissionsOfOperator(String operator, String comcode);

    /**
     * 获取立案工作池信息列表
     * @param usercode 用户代码
     * @param comcode 机构代码
     * @return 立案工作池信息列表
     */
    List<MissionPoolDto> getOwnerPools(String usercode, String comcode);
    
}
