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
    private String path;
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
        this.path = path;

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
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file.");
        } catch (IOException e) {
            System.out.println("Error counting entries.");
        }
    }

    /**
     * Reads contents of opened file to 2D string array.
     */
    private void readFile() {
        String line;
        int lineNum = 0;
        try {
            // Fill array with file contents
            while ((line = fileReader.readLine()) != null) {
                String delimiter = ",";
                fileContents[lineNum] = line.split(delimiter);
                lineNum++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }

    /**
     * Parse file contents for survey results matching specified constraints.
     *
     * @param product type of product customer responded to survey regarding
     * @param filters filters to be applied
     */
    public void parseData(String product, String filters) {
        boolean addRating = true;
        int rating;

        readFile();

        for(String[] response : fileContents) {
            // Check that filter constraints are met
            for(String data : response) {
                if(!filters.contains(data) || !data.equals(product)) {
                    addRating = false;
                }
            }

            // Increment ratings meeting filter
            if(addRating) {
                rating = Integer.parseInt(response[4]);
                ratings.put(rating, (ratings.get(rating) + 1));
            }

            // Rest addRating variable
            addRating = true;
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
