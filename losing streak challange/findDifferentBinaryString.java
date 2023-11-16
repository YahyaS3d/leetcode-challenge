import java.util.HashSet;
import java.util.Set;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();

        // Add all binary strings in nums to the set
        for (String num : nums) {
            set.add(num);
        }

        // Iterate through all possible binary strings
        for (int i = 0; i < (1 << n); i++) {
            String binaryString = Integer.toBinaryString(i);

            // Pad the binary string with leading zeros if necessary
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }

            // Check if the binary string is not in nums
            if (!set.contains(binaryString)) {
                return binaryString;
            }
        }

        return "";
    }
}
