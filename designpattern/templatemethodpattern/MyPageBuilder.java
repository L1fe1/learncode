package designpattern.templatemethodpattern;

public class MyPageBuilder extends AbstractPageBuilder{
    protected void appendMeta(StringBuffer stringBuffer) {
        stringBuffer.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
    }

    @Override
    protected void appendTitle(StringBuffer stringBuffer) {
        stringBuffer.append("<title>你好</title>");
    }

    @Override
    protected void appendBody(StringBuffer stringBuffer) {
        stringBuffer.append("<body><h1>你好,世界！</h1></body>");
    }

    public static void main(String[] args) {
        PageBuilder pageBuilder = new MyPageBuilder();
        System.out.println(pageBuilder.buildHtml());
    }
}
