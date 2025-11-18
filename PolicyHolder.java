/**
 * The PolicyHolder class represents the person associated with
 * an insurance policy.
 */
public class PolicyHolder
{
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;  // "smoker" or "non-smoker"
    private double height;         // in inches
    private double weight;         // in pounds

    /**
     * No-arg constructor.
     */
    public PolicyHolder()
    {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Copy constructor (used for security/defensive copying).
     */
    public PolicyHolder(PolicyHolder other)
    {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.age = other.age;
        this.smokingStatus = other.smokingStatus;
        this.height = other.height;
        this.weight = other.weight;
    }

    /**
     * Full constructor.
     */
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and setters

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public int getAge() { return age; }

    public String getSmokingStatus() { return smokingStatus; }

    public double getHeight() { return height; }

    public double getWeight() { return weight; }

    public boolean isSmoker()
    {
        return smokingStatus.equalsIgnoreCase("smoker");
    }

    /**
     * Computes BMI.
     */
    public double getBMI()
    {
        if (height == 0)
            return 0;

        return (weight * 703) / (height * height);
    }

    private String getSmokingDescription()
    {
        return isSmoker() ? "smoker" : "non-smoker";
    }

    /**
     * toString for PolicyHolder info.
     */
    public String toString()
    {
        return  "Policyholder's First Name: " + firstName +
                "\n\nPolicyholder's Last Name: " + lastName +
                "\n\nPolicyholder's Age: " + age +
                "\n\nPolicyholder's Smoking Status (Y/N): " + getSmokingDescription() +
                "\n\nPolicyholder's Height: " + String.format("%.1f", height) + " inches" +
                "\n\nPolicyholder's Weight: " + String.format("%.1f", weight) + " pounds" +
                "\n\nPolicyholder's BMI: " + String.format("%.2f", getBMI());
    }
}
