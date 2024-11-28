import java.util.regex.Pattern;

public class Main {
    public static boolean isValidPhone(String numberPhone) {
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        return Pattern.matches(regex, numberPhone);
    }

    public static void main(String[] args) {
        String[] validNumberPhone = {"(84)-(0978489648)"};
        String[] isValidNumberPhones = {"(a8)-(22222222)", "(84)-(22b22222)", "(84)-(9978489648)"};

        System.out.println("Valid number phone");
        for (String numberPhone : validNumberPhone) {
            System.out.println(numberPhone+ " " + isValidPhone(numberPhone));
        }

        System.out.println("\nInvalid number phone");
        for (String numberPhone : isValidNumberPhones) {
            System.out.println(numberPhone + " " + isValidPhone(numberPhone));
        }
    }
}