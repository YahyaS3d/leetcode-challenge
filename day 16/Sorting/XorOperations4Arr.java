class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = pref[i];
            } else {
                arr[i] = pref[i] ^ pref[i - 1];
            }
        }

        return arr;
    }
}
