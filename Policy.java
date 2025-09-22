import java.util.Scanner;

public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String policyHolderSmokingStatus;
    private double policyHolderHeight;
    private double policyHolderWeight;

    public Policy() {
        this.policyNumber = 0;
        this.providerName = "Unknown";
        this.policyHolderFirstName = "John";
        this.policyHolderLastName = "Doe";
        this.policyHolderAge = 0;
        this.policyHolderSmokingStatus = "non-smoker";
        this.policyHolderHeight = 65.0;
        this.policyHolderWeight = 150.0;
    }

    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolderFirstName = firstName;
        this.policyHolderLastName = lastName;
        this.policyHolderAge = age;
        this.policyHolderSmokingStatus = smokingStatus;
        this.policyHolderHeight = height;
        this.policyHolderWeight = weight;
    }

    public double calculateBMI() {
        return (policyHolderWeight * 703) / (policyHolderHeight * policyHolderHeight);
    }

    public double calculatePolicyPrice() {
        double price = 600.0;
        if (policyHolderAge > 50) price += 75;
        if (policyHolderSmokingStatus.equalsIgnoreCase("smoker")) price += 100;
        double bmi = calculateBMI();
        if (bmi > 35) price += (bmi - 35) * 20;
        return price;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\nPolicyholder: " + policyHolderFirstName + " " + policyHolderLastName +
               "\nAge: " + policyHolderAge +
               "\nSmoking Status: " + policyHolderSmokingStatus +
               "\nHeight (in): " + policyHolderHeight +
               "\nWeight (lbs): " + policyHolderWeight +
               "\nBMI: " + String.format("%.2f", calculateBMI()) +
               "\nPolicy Price: $" + String.format("%.2f", calculatePolicyPrice());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Policy Number: ");
        int number = input.nextInt();
        input.nextLine(); // consume newline

        System.out.print("Enter Provider Name: ");
        String provider = input.nextLine();

        System.out.print("Enter Policyholder's First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Policyholder's Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Policyholder's Age: ");
        int age = input.nextInt();
        input.nextLine(); // consume newline

        System.out.print("Enter Policyholder's Smoking Status (smoker/non-smoker): ");
        String smokingStatus = input.nextLine();

        System.out.print("Enter Policyholder's Height (in inches): ");
        double height = input.nextDouble();

        System.out.print("Enter Policyholder's Weight (in pounds): ");
        double weight = input.nextDouble();

        Policy policy = new Policy(number, provider, firstName, lastName, age, smokingStatus, height, weight);

        System.out.println("\n---- Policy Information ----");
        System.out.println(policy);

        input.close();
    }
}
