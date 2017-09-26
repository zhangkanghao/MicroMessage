package com.chat.dao;

import com.chat.bean.Message;
import com.chat.db.DBAccess;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao {

    /**
     * mybatis操作数据库
     */
    public List<Message> queryMessageList(String command,String description){
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
    /**
     * 根据查询条件查询消息列表
     * 原生JDBC操作数据库
     **/
    {
    /*
    public List<Message> queryMessageList(String command,String description){
        //把结果存在messageList里
        List<Message> messagesList=new ArrayList<Message>();
        try {
            //与数据库建立连接
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?characterEncoding=utf8","root","zzz123");

            //构造sql语句
            StringBuilder sql=new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
            //定义statement参数列表
            List<String> paramList=new ArrayList<String>();
            //判断搜索关键词  如果不为空则添加在sql语句后   并加入到参数列表中（因为这里用？占位，后面要用statement.setString来绑定参数)
            if(command!=null&&!("".equals(command.trim()))){
                sql.append(" and COMMAND=?");
                paramList.add(command);
            }
            if(description!=null&&!("".equals(description.trim()))){
                sql.append(" and DESCRIPTION like '%' ? '%'");
                paramList.add(description);
            }

            //包含于 PreparedStatement 对象中的 SQL 语句可具有一个或多个 IN 参数。IN参数的值在 SQL 语句创建时未被指定。
            // 相反的，该语句为每个 IN 参数保留一个问号（“？”）作为占位符。
            PreparedStatement statement=conn.prepareStatement(sql.toString());
            //每个问号的值必须在该语句执行之前，通过适当的setXXX 方法来提供。
            for(int i=0;i<paramList.size();i++){
                statement.setString(i+1,paramList.get(i));
            }
            //ResultSet ts保存查询返回结果
            ResultSet rs=statement.executeQuery();
//            List<Message> messagesList=new ArrayList<Message>();  需要返回list故放在全局
            while(rs.next()){
                Message message=new Message();
                messagesList.add(message);
                message.setId(rs.getString("ID"));
                message.setCommand(rs.getString("COMMAND"));
                message.setDescription(rs.getString("DESCRIPTION"));
                message.setContent(rs.getString("CONTENT"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messagesList;
    }
    */}
    /*
     * 单条删除数据
     */
    public void deleteOne(int id){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            //通过sqlSession执行sql语句
            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
    /**
     * 批量删除数据
     */
    public void deleteBatch(List<Integer> deleteList){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            sqlSession.delete("Message.deleteBatch",deleteList);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    /**
     * 新增数据
     */
    public void insertOne(Message message){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            sqlSession.insert("Message.insertOne",message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
