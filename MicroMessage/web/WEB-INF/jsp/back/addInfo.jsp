<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/9/21
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddInfo</title>
</head>
<body>

<form action="<%=basePath%>InsertOneServlet.action" id="infomation" method="post">
    指令:<input name="addCommand" type="text" >
    <br>
    描述:<input name="addDescription" type="text">
    <br>
    备注:<input name="addContent"  type="text"/>
    <br>
    <<input type="submit" id="ok" value="确认">
</form>>

</body>
</html>
