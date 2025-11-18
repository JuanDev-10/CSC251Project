// PolicyDemo.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Demo program for Project 2:
 * Reads policy records from PolicyInformation.txt (8 lines per policy, blank lines allowed between records),
 * stores them in an ArrayList, prints each policy, and totals smokers vs non-smokers.
 */
public class PolicyDemo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        final String FILE_NAME = "PolicyInformation.txt";
        ArrayList<Policy> policies = new ArrayList<>();

        try (Scanner file = new Scanner(new File(FILE_NAME))) {
            while (true) {
                String line1 = nextNonEmptyLine(file);
                if (line1 == null) break; // no more records

                String line2 = nextNonEmptyLine(file);
                String line3 = nextNonEmptyLine(file);
                String line4 = nextNonEmptyLine(file);
                String line5 = nextNonEmptyLine(file);
                String line6 = nextNonEmptyLine(file);
                String line7 = nextNonEmptyLine(file);
                String line8 = nextNonEmptyLine(file);

                if (line2 == null || line3 == null || line4 == null || line5 == null
                        || line6 == null || line7 == null || line8 == null) {
                    System.err.println("Warning: Incomplete policy record encountered. Skipping the remainder.");
                    break;
                }

                int policyNumber = Integer.parseInt(line1.trim());
                String providerName = line2.trim();
                String firstName = line3.trim();
                String lastName = line4.trim();
                int age = Integer.parseInt(line5.trim());
                String smokingStatus = line6.trim(); // "smoker" or "non-smoker"
                double height = Double.parseDouble(line7.trim());
                double weight = Double.parseDouble(line8.trim());

                policies.add(new Policy(policyNumber, providerName, firstName, lastName,
                                        age, smokingStatus, height, weight));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not find " + FILE_NAME + " in the project folder.");
            return;
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number in " + FILE_NAME + ". " + e.getMessage());
            return;
        }

        // Display each policy's information
        for (Policy p : policies) {
            System.out.println(p);
            System.out.println(); // blank line between policies
        }

        // Count smokers vs non-smokers
        int smokers = 0, nonSmokers = 0;
        for (Policy p : policies) {
            if (p.getPolicyHolderSmokingStatus().equalsIgnoreCase("smoker")) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }

        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("\nThe number of policies with a non-smoker is: " + nonSmokers);
    }

    /**
     * Returns the next non-empty line from the scanner, or null if no more lines exist.
     *
     * @param sc the Scanner reading the file
     * @return the next non-empty trimmed line, or null if EOF
     */
    private static String nextNonEmptyLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) return line;
        }
        return null;
    }
}
