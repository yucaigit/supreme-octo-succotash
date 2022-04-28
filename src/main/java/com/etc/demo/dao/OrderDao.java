package com.etc.demo.dao;


import com.etc.demo.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper

public interface OrderDao {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

//    @Select("select *from orders left join goods on user_id = #{uid}")
    List<Order> findAll(int uid);

    int deleteById(Integer orderId);

    Boolean updateOrderState(Integer oId);

    boolean addOrder(Integer uid, Integer goodsid);
}