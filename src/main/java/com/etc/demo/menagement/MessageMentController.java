package com.etc.demo.menagement;

import com.etc.demo.dao.GoodsDao;
import com.etc.demo.entity.Goods;
import com.etc.demo.utils.SendMessageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MessageMentController {

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping("/mesage/login")
    public boolean login(){
        return true;
    }

    @GetMapping("/mesage/findAll")
    public PageInfo<Goods> getList(@RequestParam Integer pageNum){
        PageHelper.startPage(pageNum,3);
        List<Goods> all = goodsDao.getAll();
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(all);

        return goodsPageInfo;
    }

    @RequestMapping("/changeGb")
    public boolean changeGb(@RequestParam Integer gb
    ,@RequestParam Integer gid){
        int a = gb==0?1:0;
        return goodsDao.changeGb(a,gid);
    }

    @RequestMapping("/send")
    public boolean sendMessage(){
        SendMessageUtils sendMessageUtils = new SendMessageUtils();
        JSONObject jsonObject = sendMessageUtils.sendMessage("17339876393");
        System.out.println(jsonObject);
        return true;}

    @RequestMapping("/mesage/updateGoods")
    public boolean updateGoods(Goods goods){
        return goodsDao.updateGoods(goods.getGId(),goods.getGName(),goods.getGAdress(),goods.getGDescribe());
    }
    @RequestMapping("/mesage/deleteGoods")
    public boolean deleteGoods(@RequestParam Integer gid){
        return goodsDao.deleteGoodsById(gid);}

}
