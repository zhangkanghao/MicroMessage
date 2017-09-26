package com.chat.service;

import com.chat.bean.Message;
import com.chat.dao.MessageDao;
import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 与维护相关的业务功能
 */
public class MaintainService {
    /**
     * 单条删除
     */
    public void deleteOne(String id){
        if(id!=null&&!"".equals(id)){
            MessageDao messageDao=new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }

    }
    /**
     * 批量删除
     */
    public void deleteBatch(String[] ids){
        List<Integer> deleteList = new ArrayList<Integer>();
        for (String id:ids) {
            deleteList.add(Integer.valueOf(id));
        }
        MessageDao messageDao=new MessageDao();
        messageDao.deleteBatch(deleteList);
    }
    /**
     * 新增数据
     */
    public void insertOne(String command,String description,String content){
        Message message=new Message();
        message.setCommand(command);
        message.setDescription(description);
        message.setContent(content);
        MessageDao messageDao=new MessageDao();
        messageDao.insertOne(message);
    }
}
