public class Calculations {

    /**
     * Calculate revenue for a song given price and playCount.
     * platformFee e.g., 0.30 for 30% fee.
     */
    public static double calculateRevenue(double price, int playCount, double platformFee) {
        double gross = price * playCount;
        return gross * (1.0 - platformFee);
    }
}
