import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author eugeniachen
 *
 */

public class Lab3 {

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

    /** This is a method to count the number of words in a given document.
     *
     * @param text text from the file you are counting words from
     * @return number of words in the document
     */
    public static int countWords(final String text) {
        StringTokenizer textToken = new StringTokenizer(text);
        return textToken.countTokens();
    }

    /** This is a method to count the number of times a specified word is in a given document.
     *
     * @param text text from the file you are counting words from
     * @param word the word you are looking for
     * @return the number of times the word you are looking for is in the document
     */
    public static int wordFinder(final String text, final String word) {
        String lowerCaseText = text.toLowerCase();
        String lowerCaseWord = word.toLowerCase();
        int wordCount = 0;
        StringTokenizer textToken = new StringTokenizer(lowerCaseText);
        while (textToken.hasMoreTokens()) {
            if (lowerCaseWord.equals(textToken.nextToken())) {
                wordCount++;
            }
        }
        return wordCount;
    }

    /** This is a method to find the number of unique words in a given document.
     *
     * @param text text from the file you are counting words from
     * @return the number of unique words in the document
     */
    public static int uniqueWordCounter(final String text) {
        int uniqueWords = 0;
        String lowerCaseText = text.toLowerCase();
        String[] arrayOfWords = lowerCaseText.split(" ");
        for (int i = 0; i < arrayOfWords.length; i++) {
            String uniqueWord = arrayOfWords[i];
            if (wordFinder(lowerCaseText, uniqueWord) == 1) {
                uniqueWords++;
            } else {
                for (int j = 0; j < arrayOfWords.length; j++) {
                    if (arrayOfWords[j].equals(uniqueWord)) {
                        arrayOfWords[j] = "";
                    }
                }
            }
        }
        return uniqueWords;
    }

    /** This is the main method.
     *
     * @param args
     */
    public static void main(String[] args) {
           System.out.println(countWords("Hello world hi hi"));
           System.out.println(wordFinder("world world world", "world"));
           System.out.println(uniqueWordCounter("H h h i k"));
           System.out.println(countWords(urlToString("http://erdani.com/tdpl/hamlet.txt")));
    }
}
