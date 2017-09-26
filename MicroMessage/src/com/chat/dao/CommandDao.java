package com.chat.dao;

import com.chat.bean.Message;
import com.chat.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * 与指令表对应的数据操作类
 */
public class CommandDao {

    /**
     * mybatis操作数据库
     */
    public List<Message> queryMessageList(String command, String description){
        DBAccess dbAccess=new DBAccess();
        List<Message> messagesList=new ArrayList<Message>();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            Message message=new Message();
            message.setCommand(command);
            message.setDescription(description);
            //通过mybatis执行数据库语句
            messagesList=sqlSession.selectList("Message.queryMessageList",message);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null) {
                sqlSession.close();
            }
        }
        return messagesList;
    }

}
