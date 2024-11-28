import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try {
            String url = "https://dantri.com.vn/the-gioi.htm";

            String htmlContent = getHtmlContent(url);
            String regex = "<a[^>]+title=[\"'](.*?)[\"']";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(htmlContent);

            System.out.println("Danh sách các bản tin:");
            while (matcher.find()) {
                System.out.println("- " + matcher.group(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getHtmlContent(String urlString) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }
        reader.close();

        return result.toString();
    }
}
