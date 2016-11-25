import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

/**
 * Created by jasonryan on 11/24/16.
 */
public class SurveyParser {
    private String path;
    private int fileLen;
    private BufferedReader fileReader;
    private TreeMap<Integer, Integer> ratings;
    private String[][] fileContents;
    private String[] filterArr;

    private final String delimeter = ",";

    public SurveyParser(String path) {
        this.path = path;

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

    public void readFile() {
        String line;
        int lineNum = 0;
        try {
            // Fill array with file contents
            while ((line = fileReader.readLine()) != null) {
                fileContents[lineNum] = line.split(delimeter);
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

    public void parseData(String product, String filters) {
        boolean addRating = true;
        int rating;

        filterArr = filters.split("/");
        for(String[] response : fileContents) {
            // Check that filter constraints are met
            for(String data : response) {
                if(!filters.contains(data)) {
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

    public TreeMap<Integer, Integer> getRatings() {
        return ratings;
    }
}
