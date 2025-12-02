/**
 * Operators - example class that might represent mobile operators or packages.
 * This is a placeholder — adjust fields/methods per your original assignment needs.
 */
public class Operators {
    private String name;
    private String packageName;
    private double rate;

    public Operators() {}

    public Operators(String name, String packageName, double rate) {
        this.name = name;
        this.packageName = packageName;
        this.rate = rate;
    }

    public String getName() { return name; }
    public void setName(String n) { this.name = n; }
    public String getPackageName() { return packageName; }
    public void setPackageName(String p) { this.packageName = p; }
    public double getRate() { return rate; }
    public void setRate(double r) { this.rate = r; }

    public void printDetails() {
        System.out.println("Operator: " + name + " | Package: " + packageName + " | Rate: " + rate);
    }
}
