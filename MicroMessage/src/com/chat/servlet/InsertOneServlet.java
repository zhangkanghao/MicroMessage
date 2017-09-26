package com.chat.servlet;

import com.chat.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertOneServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置编码
        String addCommand=req.getParameter("addCommand");
        String addDescription=req.getParameter("addDescription");
        String addContent=req.getParameter("addContent");
        MaintainService maintainService=new MaintainService();
        maintainService.insertOne(addCommand,addDescription,addContent);
        //页面跳转
        req.getRequestDispatcher("/List.action").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
