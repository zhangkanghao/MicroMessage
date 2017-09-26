package com.chat.servlet;

import com.chat.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class AutoReplyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置编码
        PrintWriter printWriter=resp.getWriter();
        QueryService queryService=new QueryService();
        printWriter.write(queryService.queryByCommand(req.getParameter("content")));
        printWriter.flush();
        printWriter.close();

        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
