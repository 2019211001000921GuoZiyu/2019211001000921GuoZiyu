<%@include file="header.jsp"%>
<!--    This is my JSP page.<br>
<h1><%= "Hello World!!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet-Week1</a>
<br/>
<a href="hello">Student  Info Servlet-Week2</a>
<br/>
<a href="Life">Life cycle Servlet-Week3</a>
<br/>
<a href="Register.jsp">Register-getParameter-Week3</a>
<br/>
<a href="Config">Config Parameter-Week4</a>
<br/>
<a href="Register.jsp">Register JDBC -Week4</a>
<br/>
<a href="index.jsp">include-Week5</a>
<br/>
<a href="Login.jsp">Login-Week5</a>
<br/>
-->
<h2>Welcome to My Online Shop Home Page!!</h2><br>
<form method="get" target='_blank' action="search">

    <input type="text" name="text" size=30/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@include file="footer.jsp"%>