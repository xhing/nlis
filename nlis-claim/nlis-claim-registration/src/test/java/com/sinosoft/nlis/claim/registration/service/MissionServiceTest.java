package com.sinosoft.nlis.claim.registration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sinosoft.nlis.claim.registration.mapper.MissionMapper;
import com.sinosoft.nlis.claim.registration.service.impl.MissionServiceImpl;

public class MissionServiceTest {
    
    @Mock
    private MissionMapper missionMapper;

    @InjectMocks
    private MissionService missionService = new MissionServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testCountPendingCases_0_0_0() {

        // 准备数据
        String operator = "O0001";
        String comcode = "0";
        String missionid = "0";
        String flag = "0";

        //List<MissionPoolDto> mockMissionPoolList = new ArrayList<MissionPoolDto>();

        // 设置mock行为
        when(missionMapper.getComCodeConf(comcode)).thenReturn("0");
        when(missionMapper.getOwnerlessPools(comcode, missionid, flag)).thenReturn(null);

        // 测试目标
        int cases_count = missionService.countPendingCases(operator, comcode, missionid, flag);

        // 验证结果
        assertEquals(0, cases_count);

        // 验证mock交互
        verify(missionMapper, times(1)).getComCodeConf(comcode); 
        verify(missionMapper, times(1)).getOwnerlessPools(comcode, missionid, flag); 
    }

}
