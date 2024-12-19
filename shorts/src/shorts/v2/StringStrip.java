package shorts.v2;

/**
 *
 */
public class StringStrip {

    public static void main(String[] args) {
        java8();
    }

    public static String java11() {
        String s = "  abc  def\t";

//        s = s.strip();

        return s;
    }

    public static void java8() {
        String str = " Hello,   World! ";
        String strippedStr = str.replaceAll("^\\s+|\\s+$", "");
        System.out.println("Original string: \"" + str + "\"");
        System.out.println("Stripped string: \"" + strippedStr + "\"");
    }

}
