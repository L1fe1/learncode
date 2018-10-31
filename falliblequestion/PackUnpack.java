/**
 * 代码实际执行过程：
 * Short s1 = new Short((short)1);
 * Short s2 = s1;
 * short tempS1 = s1.shortValue();
 * tempS1++;
 * s1 = new Short(tempS1);
 * System.out.println(s1 == s2);
 */
public class PackUnpack {
    public static void main(String[] args) {
        Short s1 = 1;
        Short s2 = s1;
        s1++;
        System.out.println(s1 == s2);
    }
}