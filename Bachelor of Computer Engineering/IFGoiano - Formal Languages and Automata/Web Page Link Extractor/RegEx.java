import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        try {
            // Ask the user to enter the URL
            System.out.print("Enter the URL of the web page: ");
            Scanner sc = new Scanner(System.in);
            String strUrl = sc.nextLine();
            sc.close();

            // Create a URI from the URL string, and then establish a connection to the page
            URI uri = new URI(strUrl);
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();

            // Read the content of the page
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                }

                // Extract links using regex
                String html = sb.toString();
                ArrayList<String> links = extractLinksFromHTML(html);

                // Print the links
                System.out.println("Links found on the page:");
                for (String link : links) {
                    System.out.println(link);
                }
                // In the above code, it provides both complete links "https://..." and relative links "modules/..." / "faq.html"
                // To display only complete links, you can add an if (link.startsWith("https://")) before line 37.
            }
        } catch (IOException | URISyntaxException e) {
            System.err.println("An error occurred while accessing the URL or reading the HTML.");
            e.printStackTrace();
        }
    }

    private static ArrayList<String> extractLinksFromHTML(String html) {
        ArrayList<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("<a\\s+href=\"([^\"]+)\">");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            String link = matcher.group(1);
            links.add(link);
        }

        return links;
    }
}