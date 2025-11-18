/**
 * The PolicyHolder class represents the person associated with
 * an insurance policy.
 */
public class PolicyHolder
{
    private String firstName;
    private String lastName;
    private int age;
    // Store original Y/N or text form, but interpret it in methods.
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds

    /**
     * No-arg constructor.
     */
    public PolicyHolder()
    {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "N";
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
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSmokingStatus()
    {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus)
    {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * Returns true if this PolicyHolder is a smoker.
     */
    public boolean isSmoker()
    {
        // Accept "Y", "y", "smoker", etc.
        String s = smokingStatus.toLowerCase();
        return s.startsWith("y") || s.equals("smoker");
    }

    /**
     * Computes BMI using the standard formula:
     * BMI = (weight * 703) / (height^2)
     */
    public double getBMI()
    {
        if (height == 0)
        {
            return 0;
        }
        return (weight * 703) / (height * height);
    }

    /**
     * Returns a description for smoking status:
     * "smoker" or "non-smoker".
     */
    private String getSmokingDescription()
    {
        return isSmoker() ? "smoker" : "non-smoker";
    }

    /**
     * toString that outputs the PolicyHolder information.
     */
    public String toString()
    {
        String str = "";

        str += "Policyholder's First Name: " + firstName + "\n";
        str += "Policyholder's Last Name: " + lastName + "\n";
        str += "Policyholder's Age: " + age + "\n";
        str += "Policyholder's Smoking Status (Y/N): " + getSmokingDescription() + "\n";
        str += "Policyholder's Height: " + height + " inches\n";
        str += "Policyholder's Weight: " + weight + " pounds\n";
        str += String.format("Policyholder's BMI: %.2f\n", getBMI());

        return str;
    }
}
