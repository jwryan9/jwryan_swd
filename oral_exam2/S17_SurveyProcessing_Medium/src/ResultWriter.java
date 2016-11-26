import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 *
 * @author Jason Ryan
 */
public class ResultWriter {
    private BufferedWriter output;

    public ResultWriter(String path) {
        try {
            output = new BufferedWriter(new FileWriter(path));
        } catch (IOException e) {
            System.out.println("Error opening output file.");
        }
    }

    public void writeFile(TreeMap<Integer, Integer> data) {
        Object[] keys = data.keySet().toArray();
        for(Object key : keys) {
            try {
                output.write(key + "," + data.get(key) + "\n");
            } catch (IOException e) {
                System.out.println("Error writing file.");
            }
        }

        try {
            output.close();
        } catch (IOException e) {
            System.out.println("Error closing file");
        }
    }
}
