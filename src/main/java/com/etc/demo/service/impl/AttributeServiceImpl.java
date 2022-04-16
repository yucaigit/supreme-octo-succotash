package com.etc.demo.service.impl;

import com.etc.demo.dao.AttributeMapper;
import com.etc.demo.service.AttributeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeMapper attributeMapper;

    @Override
    public int selectIdByAName(String name) {
        System.out.println("Service Impl ============"+name);
        int aId = attributeMapper.selectIdByName(name);
        return aId;
    }
}
