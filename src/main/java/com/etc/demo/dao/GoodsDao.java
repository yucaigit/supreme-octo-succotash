package com.etc.demo.dao;


import com.etc.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    int selectgIdByName(String name,String img);

    @Select("select *from goods")
    List<Goods> getAll();

    @Select("select *from goods where g_ifree = 1")
    List<Goods> getAllFree();

    @Select("select *from goods where g_adress like #{adress}")
    List<Goods> seleAllLikeAdress(String adress);
}