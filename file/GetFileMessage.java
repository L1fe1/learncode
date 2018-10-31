public class GetFileMessage {
    //获取行号
    public static int getLineNumber( ){
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        
        return stackTrace[1].getLineNumber( );
    }
    
    //获取方法名
    public static String getMethodName( ){
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        
        return stackTrace[1].getMethodName( );
    }
    
    //获取文件名
    public static String getFileName( ){
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        
        return stackTrace[1].getFileName( );
    }
    
    //获取类名
    public static String getClassName( ){
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        
        return stackTrace[1].getClassName();
    }
}