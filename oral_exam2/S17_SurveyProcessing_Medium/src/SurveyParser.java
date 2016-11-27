import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

/**
 * Used for parsing survey results from customers on a variety of products.
 *
 * @author Jason Ryan
 */
public class SurveyParser {
    private int fileLen;
    private BufferedReader fileReader;
    private TreeMap<Integer, Integer> ratings;
    private String[][] fileContents;

    /**
     * Constructor. Initializes ratings, opens survey file, initializes file contents array.
     *
     * @param path filepath for survey data
     */
    public SurveyParser(String path) {
        ratings = new TreeMap<>();

        // Initialize ratings counts
        ratings.put(1, 0);
        ratings.put(2, 0);
        ratings.put(3, 0);
        ratings.put(4, 0);
        ratings.put(5, 0);

        try {
            fileReader = new BufferedReader(new FileReader(path));

            // Get number of lines in file
            fileLen = (int) Files.lines(Paths.get(path)).count();

            fileContents = new String[fileLen][5];
        } catch (Exception e) {
            System.out.println("Error opening file.");
        }
    }

    /**
     * Reads contents of opened file to 2D string array.
     */
    private void readFile() {
        String line;
        int lineNum = 0;
        try {
            // Read first line so header is ignored
            fileReader.readLine();

            // Fill array with file contents
            while ((line = fileReader.readLine()) != null) {
                String delimiter = ",";
                fileContents[lineNum] = line.split(delimiter);
                lineNum++;
            }
        } catch (Exception e) {
            System.out.println("Error reading file.");
        } finally {
            try {
                fileReader.close();
            } catch (Exception e) {
                System.out.println("Error closing file.");
            }
        }
    }

    /**
     * Parse file contents for survey results matching specified constraints.
     *
     * @param product type of product customer responded to survey regarding
     * @param filter filter to be applied
     */
    public void parseData(String product, String filter) {
        boolean matchProduct = false, matchFilter = false, addRating = false;
        int rating = -1;

        readFile();

        // Check that contents of file have been read properly
        if(fileContents != null) {
            for (String[] response : fileContents) {
                // Check that filter constraints are met
                for (String data : response) {
                    if (data != null) {
                        if (data.equals(product)) {
                            matchProduct = true;
                        }
                        if (data.equals(filter)) {
                            matchFilter = true;
                        }
                    }
                }

                if (matchFilter && matchProduct) {
                    addRating = true;
                }

                // Increment ratings meeting filter
                if (addRating) {
                    try {
                        rating = Integer.parseInt(response[4]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    ratings.put(rating, (ratings.get(rating) + 1));
                }

                // Rest variables
                addRating = false;
                matchFilter = false;
                matchProduct = false;
            }
        }
    }

    /**
     * Getter method for ratings TreeMap.
     *
     * @return TreeMap of ratings counts
     */
    public TreeMap<Integer, Integer> getRatings() {
        return ratings;
    }
}
