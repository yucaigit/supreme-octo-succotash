package com.etc.demo.service.impl;

import com.etc.demo.dao.AttributeMapper;
import com.etc.demo.dao.GoodsDao;

import com.etc.demo.entity.Goods;
import com.etc.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private static final String localHostPath = "http://localhost:8080/goodsImage/";
    @Autowired
    GoodsDao goodsDao;

    @Autowired
    AttributeMapper attributeMapper;

    @Override
    public void sum1(Integer g_id) {
        goodsDao.updateGAByID(g_id);
    }


    @Override
    public Goods selectByPrimaryKey(int g_id) {
        return goodsDao.selectByPrimaryKey(g_id);
    }

    @Override
    public void updateGA(Integer g_id) {
        goodsDao.updateGAByID(g_id);
    }

    @Override
    public List<Goods> selectLikeQuery(String query) {
        String query1 = "%" + query + "%";
        List<Goods> goods = goodsDao.searchByName(query1);
        return goods;
    }

    @Override
    public Goods findOne(Integer g_id) {
        return goodsDao.findOne(g_id);
    }

    @Override
    public boolean saveGoods(String name, String attribute, String s, String price, String senTime, Integer id, String adress, String textarea, List<String> imgsList) {
        String img1 = localHostPath + s;
        int aid = attributeMapper.selectIdByName(attribute);
        return goodsDao.saveGoods(name, aid, img1, price, senTime, id, adress, textarea);
    }
}
