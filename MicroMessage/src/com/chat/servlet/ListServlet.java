package com.chat.servlet;

import com.chat.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 列表页面初始化控制
 */
public class ListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置编码

        String command=req.getParameter("command");//获取jsp页面的参数
        String description=req.getParameter("description");//获取jsp页面的参数
        req.setAttribute("command",command);//反馈回jsp页面保存参数
        req.setAttribute("description",description);//反馈回jsp页面保存参数
        QueryService queryService =new QueryService();
       //查询消息列表并返回结果到jsp页面
        req.setAttribute("messageList", queryService.queryMessageList(command,description));

        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
