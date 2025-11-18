/**
 * Represents an insurance policy and provides utilities to compute price.
 * A Policy "has a" PolicyHolder (class collaboration).
 */
public class Policy
{
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; // aggregate object

    // Static field to track how many Policy objects have been created.
    private static int policyCount = 0;

    // Constants for price calculation
    private static final double BASE_PRICE = 600.0;
    private static final double AGE_FEE = 75.0;     // age > 50
    private static final double SMOKER_FEE = 100.0; // smoker
    private static final double BMI_LIMIT = 35.0;
    private static final double BMI_MULTIPLIER = 20.0;

    /**
     * No-arg constructor that initializes a default policy.
     */
    public Policy()
    {
        this(0, "Unknown", new PolicyHolder());
    }

    /**
     * Constructs a Policy with a PolicyHolder object.
     *
     * @param policyNumber the policy number
     * @param providerName the provider/company name
     * @param holder       the PolicyHolder associated with the policy
     */
    public Policy(int policyNumber, String providerName, PolicyHolder holder)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        // Defensive copy to avoid security issues with aggregate classes
        this.policyHolder = new PolicyHolder(holder);

        policyCount++;
    }

    /** @return the policy number */
    public int getPolicyNumber()
    {
        return policyNumber;
    }

    /** @return the provider/company name */
    public String getProviderName()
    {
        return providerName;
    }

    /** Set provider name if needed */
    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    /**
     * Returns a COPY of the PolicyHolder to minimize security risks.
     *
     * @return a new PolicyHolder with the same data
     */
    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(policyHolder);
    }

    /**
     * Sets the PolicyHolder using a defensive copy.
     *
     * @param holder the PolicyHolder to associate with this Policy
     */
    public void setPolicyHolder(PolicyHolder holder)
    {
        this.policyHolder = new PolicyHolder(holder);
    }

    /**
     * Gets the total number of Policy objects created.
     *
     * @return the policy object count
     */
    public static int getPolicyCount()
    {
        return policyCount;
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
    public double calculatePolicyPrice()
    {
        double price = BASE_PRICE;

        if (policyHolder.getAge() > 50)
        {
            price += AGE_FEE;
        }

        if (policyHolder.isSmoker())
        {
            price += SMOKER_FEE;
        }

        double bmi = policyHolder.calculateBMI();
        if (bmi > BMI_LIMIT)
        {
            price += (bmi - BMI_LIMIT) * BMI_MULTIPLIER;
        }

        return price;
    }

    /**
     * Returns a formatted, multi-line String with the policy's details.
     * Implicitly includes the PolicyHolder's toString.
     */
    @Override
    public String toString()
    {
        return  "Policy Number: " + policyNumber +
                "\n\nProvider Name: " + providerName +
                "\n\n" + policyHolder.toString() +
                "\n\nPolicy Price: $" + String.format("%.2f", calculatePolicyPrice());
    }
}
