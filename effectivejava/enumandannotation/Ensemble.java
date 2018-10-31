/**
 * 用实例域代替序数
 * 使用ordinal()方法能够获得实例在枚举的顺序，从0开始。
 * 放弃使用序数能够更灵活的使用指定的值
 * Enum with integer data stored in an instance field
 */
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;
    Ensemble(int size) { this.numberOfMusicians = size; }
    public int numberOfMusicians() { return numberOfMusicians; }
}