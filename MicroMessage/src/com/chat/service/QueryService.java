package com.chat.service;

import com.chat.bean.Message;
import com.chat.dao.MessageDao;
import com.chat.util.Iconst;
import com.sun.org.apache.bcel.internal.generic.ICONST;

import java.io.OutputStream;
import java.util.List;

/**
 * 列表相关业务功能
 */
public class QueryService {
    public List<Message> queryMessageList(String command, String description){
        MessageDao messageDao=new MessageDao();
        return messageDao.queryMessageList(command,description);
    }

    /**
     * 通过指令查询自动回复的内容
     * @param command 指令
     * @return 自动回复的内容
     */
    public String queryByCommand(String command){
        MessageDao messageDao=new MessageDao();
        List<Message> messageList;
        if(Iconst.HELP_COMMAND.equals(command)){
            messageList=messageDao.queryMessageList(null,null);
            StringBuilder result=new StringBuilder();
            for(int i=0;i<messageList.size();i++){
                if(i!=0)result.append("<br/>");
                result.append("回复["+messageList.get(i).getCommand()+"]可以查看"+messageList.get(i).getDescription());
        }
            return result.toString();
        }
        messageList=messageDao.queryMessageList(command,null);
        if(messageList.size()>0){
            return messageList.get(0).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }

}
