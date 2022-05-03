package com.etc.demo.menagement;

import com.etc.demo.dao.GoodsDao;
import com.etc.demo.dao.MessageMapper;
import com.etc.demo.entity.Goods;
import com.etc.demo.entity.Message;
import com.etc.demo.entity.Order;
import com.etc.demo.entity.ReturnOrder;
import com.etc.demo.service.OrderService;
import com.etc.demo.utils.SendMessageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class MessageMentController {
    private static String phone=null;
    @Autowired
    GoodsDao goodsDao;

    @Autowired
    OrderService orderService;
    @Autowired
    MessageMapper messageMapper;
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
        String phoneNumber = (String) jsonObject.get("phoneNumber");
        phone = phoneNumber;
        return true;}

    @RequestMapping("/mesage/updateGoods")
    public boolean updateGoods(Goods goods){
        return goodsDao.updateGoods(goods.getGId(),goods.getGName(),goods.getGAdress(),goods.getGDescribe());
    }
    @RequestMapping("/mesage/deleteGoods")
    public boolean deleteGoods(@RequestParam Integer gid){
        return goodsDao.deleteGoodsById(gid);}

    @RequestMapping("/getNames")
    public Set<String> getGoodsName(){return orderService.getGoodsName();}

    @RequestMapping("/getValues")
    public List<Integer> getValue(){
        Map<String, Integer> orderNum = this.getOrderNum();
        Set<String> goodsName = this.getGoodsName();
        List<Integer> list = new ArrayList<>();
        for (String str : goodsName){
            Integer integer = orderNum.get(str);
            list.add(integer);
        }
        return list;}

    @RequestMapping("/getOrderNum")
    public Map<String,Integer> getOrderNum(){
        return orderService.getOrderNum();
    }

    @RequestMapping("/message/getOrders")
    public List<ReturnOrder> getOrders(){
        return orderService.getOrders();
    }

    @RequestMapping("/message/getMessage")
    public List<Message> getmyMessage(@RequestParam Integer id){
        return messageMapper.getMyMessage(id);
    }
}
