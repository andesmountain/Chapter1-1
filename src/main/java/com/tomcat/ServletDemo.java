package com.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * 嵌入式
 */
public class ServletDemo {
    public static void main(String[] args) throws Exception {

        HttpServlet httpServlet = new HttpServlet() {
            @Override
            public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
                resp.getWriter().write("hello");
            }
        };
        Tomcat tomcat =new Tomcat();
        Context context = tomcat.addContext("/demo",null);
        tomcat.addServlet(context,"hello",httpServlet);
        // 添加映射
        context.addServletMappingDecoded("/hello","hello");
        tomcat.getConnector().setPort(8080);
        tomcat.init();
        tomcat.start();
        tomcat.getServer().await();


    }
}
