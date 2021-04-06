
<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2021/4/5
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<body>
<h1 Style="font-size:20px">Login</h1>
<form method="post" action="Login">
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
<%@include file="footer.jsp"%>