import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Demo program for Project 3:
 * Reads policy records from PolicyInformation.txt (8 lines per policy)
 * Creates PolicyHolder + Policy objects
 * Displays each policy
 * Displays summary counts
 */
public class PolicyDemo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        final String FILE_NAME = "PolicyInformation.txt";
        ArrayList<Policy> policies = new ArrayList<>();

        try (Scanner file = new Scanner(new File(FILE_NAME))) {
            while (true) {
                String line1 = nextNonEmptyLine(file);
                if (line1 == null) break;

                String line2 = nextNonEmptyLine(file);
                String line3 = nextNonEmptyLine(file);
                String line4 = nextNonEmptyLine(file);
                String line5 = nextNonEmptyLine(file);
                String line6 = nextNonEmptyLine(file);
                String line7 = nextNonEmptyLine(file);
                String line8 = nextNonEmptyLine(file);

                if (line2 == null || line3 == null || line4 == null || line5 == null ||
                    line6 == null || line7 == null || line8 == null) {
                    System.err.println("Incomplete record found. Stopping.");
                    break;
                }

                int policyNumber = Integer.parseInt(line1.trim());
                String providerName = line2.trim();
                String firstName = line3.trim();
                String lastName = line4.trim();
                int age = Integer.parseInt(line5.trim());
                String smokingStatus = line6.trim();
                double height = Double.parseDouble(line7.trim());
                double weight = Double.parseDouble(line8.trim());

                PolicyHolder holder = new PolicyHolder(firstName, lastName, age,
                                                      smokingStatus, height, weight);

                Policy policy = new Policy(policyNumber, providerName, holder);

                policies.add(policy);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not find " + FILE_NAME);
            return;
        }

        // Print all policies
        for (Policy p : policies) {
            System.out.println(p);
            System.out.println();
        }

        // Count smokers vs non-smokers
        int smokers = 0, nonSmokers = 0;

        for (Policy p : policies) {
            if (p.getPolicyHolder().isSmoker())
                smokers++;
            else
                nonSmokers++;
        }

        // Summary
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }

    private static String nextNonEmptyLine(Scanner sc) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) return line;
        }
        return null;
    }
}
