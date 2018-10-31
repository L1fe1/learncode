package effectivejava.universalmethodsforobject;

/**
 * 延迟初始化hashCode
 */
public class LazyInitializeHashcode {
    // Lazily initialized, cached hashCode
    private volatile int hashCode;
    private int areaCode;
    private int prefix;
    private int lineNumber;

    @Override public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31  -  result + areaCode;
            result = 31  -  result + prefix;
            result = 31  -  result + lineNumber;
            hashCode = result;
        }
        return result;
    }
}