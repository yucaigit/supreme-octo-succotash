package com.etc.demo.dao;


import com.etc.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsDao {
    int deleteByPrimaryKey(Integer gId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    void updateGAByID(Integer g_id);

    List<Goods> searchByName(String query1);

    Goods findOne(Integer g_id);

    boolean saveGoods(String name, int gAttributes, String img1, String price, String senTime, Integer id, String adress, String textarea);
}