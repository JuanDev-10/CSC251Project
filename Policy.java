/**
 * Represents an insurance policy and provides utilities to compute price.
 * A Policy "has a" PolicyHolder (class collaboration).
 */
public class Policy
{
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    // Price constants
    private static final double BASE_PRICE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_LIMIT = 35.0;
    private static final double BMI_MULTIPLIER = 20.0;

    /**
     * No-arg constructor.
     */
    public Policy()
    {
        this(0, "Unknown", new PolicyHolder());
    }

    /**
     * Full constructor with PolicyHolder object.
     */
    public Policy(int policyNumber, String providerName, PolicyHolder holder)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(holder); // defensive copy
        policyCount++;
    }

    public int getPolicyNumber() { return policyNumber; }

    public String getProviderName() { return providerName; }

    /**
     * Returns a defensive copy of the PolicyHolder.
     */
    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(policyHolder);
    }

    /**
     * Gets how many Policy objects were created.
     */
    public static int getPolicyCount()
    {
        return policyCount;
    }

    /**
     * Policy price calculation.
     */
    public double calculatePolicyPrice()
    {
        double price = BASE_PRICE;

        if (policyHolder.getAge() > 50)
            price += AGE_FEE;

        if (policyHolder.isSmoker())
            price += SMOKER_FEE;

        double bmi = policyHolder.getBMI(); // fixed
        if (bmi > BMI_LIMIT)
            price += (bmi - BMI_LIMIT) * BMI_MULTIPLIER;

        return price;
    }

    /**
     * toString prints policy AND policyholder.
     */
    public String toString()
    {
        return "Policy Number: " + policyNumber +
                "\n\nProvider Name: " + providerName +
                "\n\n" + policyHolder.toString() +
                "\n\nPolicy Price: $" + String.format("%.2f", calculatePolicyPrice());
    }
}
