<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <!--add code about new servlet-->

    <!--
       <servlet>
           <servlet-name>EXPECT^</servlet-name>
           <servlet-class>com.ZhangZhenbin.Week2.FirstTryServlet</servlet-class>
       </servlet>
       <servlet>
           <servlet-name>LifeCycleServlet</servlet-name>
           <servlet-class>com.ZhangZhenbin.Week3.LifeCycleServlet</servlet-class>
       </servlet>
       <servlet>
           <servlet-name>RegisterServlet</servlet-name>
           <servlet-class>com.ZhangZhenbin.Week3.RegisterServlet</servlet-class>
       </servlet>
       <servlet>
           <servlet-name>JDBCDemonServlet</servlet-name>
           <servlet-class>com.ZhangZhenbin.Week4.JDBCDemonServlet</servlet-class>
           <init-param>
               <param-name>driver</param-name>
               <param-value>com.microsoft.sqlserver.jdbc.SQLServerDriver</param-value>
           </init-param>
           <init-param>
               <param-name>url</param-name>
               <param-value>jdbc:sqlserver://localhost;databaseName=userdb</param-value>
           </init-param>
           <init-param>
               <param-name>username</param-name>
               <param-value>sa</param-value>
           </init-param>
           <init-param>
               <param-name>password</param-name>
               <param-value>123456789</param-value>
           </init-param>
           <load-on-startup>1</load-on-startup>
       </servlet>
       <servlet>
           <servlet-name>ConfigDemonServlet</servlet-name>
           <servlet-class>com.ZhangZhenbin.Week4.ConfigDemonServlet</servlet-class>
       </servlet>
       <servlet-mapping>
           <servlet-name>EXPECT^</servlet-name>
           <url-pattern>/MyJsp.jsp</url-pattern>
       </servlet-mapping>
       <servlet-mapping>
           <servlet-name>LifeCycleServlet</servlet-name>
           <url-pattern>/Life</url-pattern>
       </servlet-mapping>
       <servlet-mapping>
           <servlet-name>RegisterServlet</servlet-name>
           <url-pattern>/Register</url-pattern>
       </servlet-mapping>
       <servlet-mapping>
           <servlet-name>JDBCDemonServlet</servlet-name>
           <url-pattern>/jdbc</url-pattern>
       </servlet-mapping>
       <servlet-mapping>
           <servlet-name>ConfigDemonServlet</servlet-name>
           <url-pattern>/Config</url-pattern>
       </servlet-mapping>
   -->

    <context-param>
        <param-name>driver</param-name>
        <param-value>com.microsoft.sqlserver.jdbc.SQLServerDriver</param-value>
    </context-param>
    <context-param>
        <param-name>url</param-name>
        <param-value>jdbc:sqlserver://localhost;databaseName=userdb</param-value>
    </context-param>
    <context-param>
        <param-name>username</param-name>
        <param-value>sa</param-value>
    </context-param>
    <context-param>
        <param-name>password</param-name>
        <param-value>123456789</param-value>
    </context-param>


    <welcome-file-list>
        <welcome-file>home</welcome-file>
    </welcome-file-list>

    <!--filter chain-->
    <!--     <filter>
            <filter-name>AuthFilter</filter-name>
            <filter-class>com.ZhangZhenbin.filter.AuthFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>AuthFilter</filter-name>
            <url-pattern>/hello</url-pattern>
        </filter-mapping>
        <filter>
            <filter-name>HelloServlet</filter-name>
            <filter-class>com.ZhangZhenbin.filter.HelloFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>HelloFilter</filter-name>
            <url-pattern>/hello</url-pattern>
        </filter-mapping>
        <filter>
            <filter-name>LoggerFilter</filter-name>
            <filter-class>com.ZhangZhenbin.filter.LoggerFilter</filter-class>
        </filter>
        <filter-mapping>
            <filter-name>LoggerFilter</filter-name>
            <url-pattern>/hello</url-pattern>
        </filter-mapping>
        -->
    <welcome-file-list>
        <welcome-file>home</welcome-file>
    </welcome-file-list>
    <filter>
        <filter-name>ZhangZhenbinFilter</filter-name>
        <filter-class>com.Lab2.ZhangZhenbinFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>ZhangZhenbinFilter</filter-name>
        <url-pattern>/Lab2/welcome.jsp</url-pattern>
    </filter-mapping>


    <filter>
        <filter-name>LoginFilter</filter-name>
        <filter-class>com.Lab2.LoginFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>LoginFilter</filter-name>
        <url-pattern>/Lab2/welcome.jsp</url-pattern>
    </filter-mapping>



</web-app>