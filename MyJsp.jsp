<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 2021/3/14
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
This is my JSP page.<br>
<a href="index.jsp">Back to index</a>
<form method="Get">
    Name:<input type="text" name="name"><br>
    ID:<input type="text" name="id"><br>
    <input type="submit" value ="Send data to server"/>
</form>

<%@include file="footer.jsp"%>