package com.etc.demo.webSocket;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint(value = "/chat")
public class ChatClass {
/*成功建立连接*/
    @OnOpen
    public void onOpen(Session session){

        System.out.println("成功建立连接");
    }
    @OnMessage
    public void onMessage(String msg,Session session){
        System.out.println("msg");
    }

    @OnError
    public void onError(){
        System.out.println("Error");
    }

    @OnClose
    public void onClose(){
        System.out.println("close");
    }

}
