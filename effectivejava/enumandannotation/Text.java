import java.util.Set;
import java.util.EnumSet;

/**
 * 用EnumSet代替位域
 */
public class Text {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        // Body goes here
    }

    // Sample use
    public static void main(String[] args) {
        Text text = new Text();
        // 替代了原有的A|B 位运算
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}