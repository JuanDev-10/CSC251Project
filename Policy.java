// Policy.java
/**
 * Represents an insurance policy and provides utilities to compute BMI and price.
 */
public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String policyHolderSmokingStatus; // "smoker" or "non-smoker"
    private double policyHolderHeight;        // inches
    private double policyHolderWeight;        // pounds

    /**
     * No-arg constructor that initializes a default policy.
     */
    public Policy() {
        this(0, "Unknown", "John", "Doe", 0, "non-smoker", 65.0, 150.0);
    }

    /**
     * Constructs a Policy with all attributes specified.
     *
     * @param policyNumber the policy number
     * @param providerName the provider/company name
     * @param firstName    policyholder's first name
     * @param lastName     policyholder's last name
     * @param age          policyholder's age in years
     * @param smokingStatus "smoker" or "non-smoker"
     * @param height       policyholder's height in inches
     * @param weight       policyholder's weight in pounds
     */
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

    /** @return the policy number */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /** @return the provider/company name */
    public String getProviderName() {
        return providerName;
    }

    /** @return policyholder first name */
    public String getPolicyHolderFirstName() {
        return policyHolderFirstName;
    }

    /** @return policyholder last name */
    public String getPolicyHolderLastName() {
        return policyHolderLastName;
    }

    /** @return policyholder age */
    public int getPolicyHolderAge() {
        return policyHolderAge;
    }

    /** @return "smoker" or "non-smoker" */
    public String getPolicyHolderSmokingStatus() {
        return policyHolderSmokingStatus;
    }

    /** @return height in inches */
    public double getPolicyHolderHeight() {
        return policyHolderHeight;
    }

    /** @return weight in pounds */
    public double getPolicyHolderWeight() {
        return policyHolderWeight;
    }

    /**
     * Calculates Body Mass Index (BMI) using U.S. customary units.
     * Formula: BMI = (weight * 703) / (height^2)
     *
     * @return the BMI as a double
     */
    public double calculateBMI() {
        return (policyHolderWeight * 703) / (policyHolderHeight * policyHolderHeight);
    }

    /**
     * Calculates the policy price based on age, smoking status, and BMI.
     * Base price: $600
     * + $75 if age > 50
     * + $100 if smoker
     * + $20 for each BMI point above 35 (fractional points prorated)
     *
     * @return the computed policy price
     */
    public double calculatePolicyPrice() {
        double price = 600.0;
        if (policyHolderAge > 50) price += 75;
        if (policyHolderSmokingStatus.equalsIgnoreCase("smoker")) price += 100;
        double bmi = calculateBMI();
        if (bmi > 35) price += (bmi - 35) * 20;
        return price;
    }

    /**
     * Returns a formatted, multi-line String with the policy's details.
     *
     * @return string describing the policy
     */
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\n\nProvider Name: " + providerName +
               "\n\nPolicyholder's First Name: " + policyHolderFirstName +
               "\n\nPolicyholder's Last Name: " + policyHolderLastName +
               "\n\nPolicyholder's Age: " + policyHolderAge +
               "\n\nPolicyholder's Smoking Status (smoker/non-smoker): " + policyHolderSmokingStatus +
               "\n\nPolicyholder's Height: " + String.format("%.1f", policyHolderHeight) + " inches" +
               "\n\nPolicyholder's Weight: " + String.format("%.1f", policyHolderWeight) + " pounds" +
               "\n\nPolicyholder's BMI: " + String.format("%.2f", calculateBMI()) +
               "\n\nPolicy Price: $" + String.format("%.2f", calculatePolicyPrice());
    }
}
