public class PotionDivider {
    
    // Function to check if a given divisor satisfies the condition
    public static boolean canDivide(int[] potions, int divisor, int limit) {
        int total = 0;
        for (int power : potions) {
            total += (power + divisor - 1) / divisor; // equivalent to Math.ceil(power / divisor)
            if (total > limit) {
                return false; // Early exit if total exceeds limit
            }
        }
        return total <= limit;
    }

    // Function to find the smallest divisor
    public static int smallestDivisor(int[] potions, int limit) {
        int low = 1;
        int high = 0;
        for (int power : potions) {
            high = Math.max(high, power); // finding the maximum potion power level
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDivide(potions, mid, limit)) {
                high = mid; // try to find a smaller divisor
            } else {
                low = mid + 1; // increase the divisor
            }
        }

        return low; // This will be the smallest divisor
    }

    public static void main(String[] args) {
        // Example input
        int[] potions = {12, 59};
        int limit = 6;

        // Calculate the smallest divisor
        int result = smallestDivisor(potions, limit);
        
        // Print the result
        System.out.println(result);
    }
}