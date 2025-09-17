package com.sinosoft.nlis.claim.registration.mapper;

import java.util.List;

import com.sinosoft.nlis.claim.registration.dto.MissionDto;
import com.sinosoft.nlis.claim.registration.dto.MissionPoolDto;

public interface MissionMapper {
    
    /**
     * 获取立案信息列表
     * @param operator 操作员
     * @param comcode 机构代码
     * @return
     */
    List<MissionDto> getMissionList(String operator, String comcode);

    /**
     * 获取机构配置
     * @param comcode
     * @return 机构配置
     */
    String getComCodeConf(String comcode);

    /**
     * 获取待申领立案工作池信息
     * @param comcode 机构代码
     * @param missionid 任务ID
     * @param flag 理赔模块业务标识
     * @return 立案工作池信息列表
     */
    List<MissionPoolDto> getOwnerlessPools(String comcode, String missionid, String flag);

    /**
     * 获取已申领立案工作池信息
     * @param usercode 用户代码
     * @param comcode 机构代码
     * @return 立案工作池信息列表
     */
    List<MissionPoolDto> getOwnerPools(String usercode, String comcode);

}
