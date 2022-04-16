package com.etc.demo.dao;

import com.etc.demo.entity.Imgs;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ImgsDao {
    int deleteByPrimaryKey(Integer imgId);

    int insert(Imgs record);

    int insertSelective(Imgs record);

    Imgs selectByPrimaryKey(Integer imgId);

    int updateByPrimaryKeySelective(Imgs record);

    int updateByPrimaryKey(Imgs record);
}