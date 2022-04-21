package com.etc.demo.dao;

import com.etc.demo.entity.Adress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdressMapper {
    int insert(Adress adress);
}
