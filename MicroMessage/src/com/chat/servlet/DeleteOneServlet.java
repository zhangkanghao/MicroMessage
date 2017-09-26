package com.chat.servlet;

import com.chat.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");//设置编码

        String id=req.getParameter("id");//获取jsp页面的参数
        MaintainService maintainService=new MaintainService();
        maintainService.deleteOne(id);
        //页面跳转
        req.getRequestDispatcher("/List.action").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
