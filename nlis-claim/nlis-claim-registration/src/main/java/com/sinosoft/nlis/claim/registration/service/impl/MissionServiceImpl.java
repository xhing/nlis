package com.sinosoft.nlis.claim.registration.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.nlis.claim.registration.dto.MissionDto;
import com.sinosoft.nlis.claim.registration.dto.MissionPoolDto;
import com.sinosoft.nlis.claim.registration.mapper.MissionMapper;
import com.sinosoft.nlis.claim.registration.service.MissionService;

@Service
public class MissionServiceImpl implements MissionService {

    private static final Logger logger = LoggerFactory.getLogger(MissionServiceImpl.class);

    @Autowired
    private MissionMapper missionMapper;

    @Override
    public List<MissionDto> getMissionsOfOperator(String operator, String comcode) {
        return missionMapper.getMissionList(operator, comcode);
    }

    @Override
    public int countPendingCases(String operator, String comcode, String missionid, String flag) {
        String comCodeConf = missionMapper.getComCodeConf(comcode);
        if (!"".equals(comCodeConf)) {
            comcode = comCodeConf;
        }
        List<MissionPoolDto> selflist = missionMapper.getOwnerlessPools(comcode, missionid, flag);
        // 返回可申领案件数目
        int cases_count  = selflist.size();
        logger.info("{}可申领案件数目为：{}", operator, cases_count);
        return cases_count;

    }

    @Override
    public List<MissionPoolDto> getOwnerPools(String usercode, String comcode) {
        return missionMapper.getOwnerPools(usercode, comcode);
    }

}
