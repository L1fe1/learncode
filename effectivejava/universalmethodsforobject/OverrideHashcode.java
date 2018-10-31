package effectivejava.universalmethodsforobject;

/**
 * 覆盖equals时总要覆盖hashCode，在每个覆盖了equals方法的类中，也必须覆盖hashCode方法。
 * 如果不那样做的话，就会违反Object.hashCode的通用约定，从而导致该类无法结合所有基于散列的集合一起正常运作，这样的集合包括HashMap、HashSet和Hashtable。
 * 31有个很好的特性，用移位和减法来代替乘法，可以得到更好的性能：31 * i ==(i<<5)-i 。现代的VM可以自动完成这种优化。
 */
public class OverrideHashcode {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    // A decent hashCode method
    @Override 
    public int hashCode() {
        int result = 17;
        result = 31  -  result + areaCode;
        result = 31  -  result + prefix;
        result = 31  -  result + lineNumber;
        return result;
    }
}