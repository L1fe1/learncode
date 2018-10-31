package designpattern.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DynamicConnectionProxy implements InvocationHandler {

    private Connection connection;

    public DynamicConnectionProxy(Connection connection) {
        super();
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里判断是Connection接口的close方法的话
        if (Connection.class.isAssignableFrom(proxy.getClass()) && method.getName().equals("close")) {
            //我们不执行真正的close方法
            //method.invoke(connection, args);
            //将连接归还连接池
            DataSource.getInstance().recoveryConnection(connection);
            return null;
        }else {
            return method.invoke(connection, args);
        }
    }

    public Connection getConnectionProxy(){
        return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Connection.class}, this);
    }

}
