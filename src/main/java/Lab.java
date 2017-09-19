import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Lab {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main (String[] args) {

        String website = Lab.urlToString("http://erdani.com/tdpl/hamlet.txt");

        int wordCount = 0;

        String keyWord = "lord";
        String lowerCaseKeyWord = keyWord.toLowerCase();


        for (int position = 0; position + keyWord.length() < website.length(); position ++) {

            if (keyWord.equals(website.substring(position, position + keyWord.length()))) {
                wordCount++;
            } else if (lowerCaseKeyWord.equals(website.substring(position, position + keyWord.length()))) {
                wordCount++;
            }

        }

        System.out.println(wordCount);

    }

}
