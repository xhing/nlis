package com.sinosoft.nlis.claim.registration.mapper.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sinosoft.nlis.claim.registration.dto.MissionPoolDto;
import com.sinosoft.nlis.claim.registration.dto.MissionDto;
import com.sinosoft.nlis.claim.registration.mapper.MissionMapper;

@Component
public class MissionMapperImpl implements MissionMapper {

    @Override
    public List<MissionDto> getMissionList(String operator, String comcode) {
        if (operator == null || operator.isEmpty() || comcode == null || comcode.isEmpty()) {
            throw new RuntimeException("该用户立案工作池中还没有立案案件。");
        }

        List<MissionDto> list = new ArrayList<MissionDto>();
        MissionDto m1 = new MissionDto();
        m1.setProcessid("P0000000001");
        list.add(m1);
  
        return list;
    }

    @Override
    public String getComCodeConf(String comcode) {
        if (comcode == null || comcode.isEmpty()) {
            throw new RuntimeException("立案工作池中还没有配置该机构。");
        }

        return "C0001";
    }

    @Override
    public List<MissionPoolDto> getOwnerlessPools(String comcode, String missionid, String flag) {
        if (comcode == null || comcode.isEmpty() || missionid == null || missionid.isEmpty() || flag == null || flag.isEmpty()) {
            throw new RuntimeException("立案工作池中还没有符合该机构及任务信息的立案案件。");
        }

        List<MissionPoolDto> list = new ArrayList<MissionPoolDto>();
        MissionPoolDto mp1 = new MissionPoolDto();
        mp1.setRgtno("R00001");
        list.add(mp1);

        return list;
    }

    @Override
    public List<MissionPoolDto> getOwnerPools(String usercode, String comcode) {
        if (usercode == null || usercode.isEmpty() || comcode == null || comcode.isEmpty()) {
            throw new RuntimeException("该用户还没有在立案工作池中申领任何案件。");
        }
        
        List<MissionPoolDto> list = new ArrayList<MissionPoolDto>();
        MissionPoolDto mp1 = new MissionPoolDto();
        mp1.setRgtno("R00001");
        list.add(mp1);

        return list;

    }

}
