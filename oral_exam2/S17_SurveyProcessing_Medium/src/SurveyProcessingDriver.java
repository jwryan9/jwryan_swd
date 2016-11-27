import java.util.Scanner;

/**
 * Driver program for demonstrating the capabilities of survey processing program.
 *
 * @author Jason Ryan
 */
public class SurveyProcessingDriver {

    public static void main(String[] args)
    {
        String product = "", filter = "", inputPath = "", outputPath = "";
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter filepath for input file:");
        inputPath = kb.nextLine();
        System.out.println("Enter product to filter on:");
        product = kb.nextLine();
        System.out.println("enter a demographic attribute to filter on. Enter a value contained in any of the following columns [Gender|Age Group|State of Residence]:");
        filter = kb.nextLine();
        System.out.println("Enter filepath for output file:");
        outputPath = kb.nextLine();

        SurveyParser surveyParser = new SurveyParser(inputPath);
        surveyParser.parseData(product, filter);

        ResultWriter resultWriter = new ResultWriter(outputPath);
        resultWriter.writeFile(surveyParser.getRatings());
    }
}
