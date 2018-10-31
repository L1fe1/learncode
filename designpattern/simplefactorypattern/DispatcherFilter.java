package designpattern.simplefactorypattern;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//用来分派请求的filter
public class DispatcherFilter implements Filter {

    private static final String URL_SEPARATOR = "/";

    private static final String SERVLET_PREFIX = "servlet/";

    private String servletName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        parseRequestURI((HttpServletRequest) servletRequest);
        //这里为了体现我们本节的重点，我们采用一个工厂来帮我们制造Action
        if (servletName != null) {
            //这里使用的正是简单工厂模式，创造出一个servlet，然后我们将请求转交给servlet处理
            Servlet servlet = ServletFactory.createServlet(servletName);
            servlet.service(servletRequest, servletResponse);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    //负责解析请求的URI，我们约定请求的格式必须是/contextPath/servlet/servletName
    //不要怀疑约定的好处，因为有一句话叫做，约定优于配置
    private void parseRequestURI(HttpServletRequest httpServletRequest){
        String validURI = httpServletRequest.getRequestURI().replaceFirst(httpServletRequest.getContextPath() + URL_SEPARATOR, "");
        if (validURI.startsWith(SERVLET_PREFIX)) {
            servletName = validURI.split(URL_SEPARATOR)[1];
        }
    }

}
