import java.util.regex.Pattern;

public class Main {
    public static boolean isValidClassDate(String className) {
        String regex = "^[CAP][0-9]{4}[GHIK]$";
        return Pattern.matches(regex,className);
    }
    public static void main(String[] args) {
        String[] validClassDateName = {"C0223G", "A0323K", "P1234H"};
        String[] inValidClassDateNames = {"M0318G", "P0323A", "C02@3G", "A123"};
        System.out.println("Valid class names");
        for (String className : validClassDateName) {
            System.out.println(className + " " + isValidClassDate(className));
        }

        System.out.println("\nInvalid class name");
        for (String className : inValidClassDateNames) {
            System.out.println(className + " " + isValidClassDate(className));
        }
    }
}