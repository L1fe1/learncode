package designpattern.simplefactorypattern;

import javax.servlet.*;
import java.io.IOException;


//相当于简单工厂模式中的抽象父类产品。
//注意，简单工厂在网络上的资料大部分为了简单容易理解都是只规划了一个产品接口，但这不代表就只能有一个，设计模式的使用要灵活多变。
class HttpServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
//具体的产品
class LoginServlet extends HttpServlet{}
class RegisterServlet extends HttpServlet{}
class LoginoutServlet extends HttpServlet{}
//产品工厂
public class ServletFactory {
    private ServletFactory(){}
    //一个servlet工厂，专门用来生产各个servlet，而我们生产的依据就是传入的servletName，
    //这个serlvetName由我们在filter截获，传给servlet工厂。
    //典型的创造产品的方法，一般是静态的，因为工厂不需要有状态。
    public static Servlet createServlet(String servletName){
        if (servletName.equals("login")) {
            return new LoginServlet();
        }else if (servletName.equals("register")) {
            return new RegisterServlet();
        }else if (servletName.equals("loginout")) {
            return new LoginoutServlet();
        }else {
            throw new RuntimeException("unknown servlet");
        }
    }
}
