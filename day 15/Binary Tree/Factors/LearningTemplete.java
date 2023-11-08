class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int N = arr.length;

        Arrays.sort(arr);

        Set<Integer> memCheck = new HashSet<>();
        Map<Integer, Integer> numTrees = new HashMap<>();
        Map<Integer, Set<Integer>> divisors = new HashMap<>();

        for (int num : arr) {
            memCheck.add(num);
            numTrees.put(num, 1);
            divisors.put(num, new HashSet<>());
        }
        
        for (int idx = 0; idx < N - 1; idx++) {
            int numA = arr[idx];
            for (int jdx = idx + 1; jdx < N; jdx++) {
                int numB = arr[jdx];
                if (numB % numA == 0 && numTrees.containsKey(numB / numA) && numA <= numB / numA) {
                    divisors.get(numB).add(numA);
                }
            }
        }

        int result = N;
        int mod = 1000000007;
        for (int num : arr) {
            int extraTrees = 0;
            for (int div : divisors.get(num)) {
                int otherDiv = num / div;
                long divTrees = numTrees.get(div).longValue();
                long otherDivTrees = numTrees.get(otherDiv).longValue();
                int prodTrees = (int) (divTrees * otherDivTrees % (long) mod);
                if (div == otherDiv) {
                    extraTrees = (extraTrees + prodTrees) % mod;
                } else {
                    prodTrees = (int) (2L * (long) prodTrees % (long) mod);
                    extraTrees = (extraTrees + prodTrees) % mod;
                }
            }
            numTrees.put(num, (1 + extraTrees) % mod);
            result = (result + extraTrees) % mod;
        }

        return result;
    }
}