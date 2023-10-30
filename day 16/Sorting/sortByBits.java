class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] countBits = new int[n];
        for (int i = 0; i < n; i++) {
            countBits[i] = Integer.bitCount(arr[i]);
        }
        
        // Custom merge sort based on the number of 1's
        mergeSort(arr, countBits, 0, n - 1);
        
        return arr;
    }
    
    private void mergeSort(int[] arr, int[] countBits, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, countBits, left, mid);
            mergeSort(arr, countBits, mid + 1, right);
            merge(arr, countBits, left, mid, right);
        }
    }
    
    private void merge(int[] arr, int[] countBits, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        int[] countBitsL = new int[n1];
        int[] countBitsR = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
            countBitsL[i] = countBits[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
            countBitsR[j] = countBits[mid + 1 + j];
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (countBitsL[i] < countBitsR[j] || (countBitsL[i] == countBitsR[j] && L[i] <= R[j])) {
                arr[k] = L[i];
                countBits[k] = countBitsL[i];
                i++;
            } else {
                arr[k] = R[j];
                countBits[k] = countBitsR[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = L[i];
            countBits[k] = countBitsL[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = R[j];
            countBits[k] = countBitsR[j];
            j++;
            k++;
        }
    }
}




// TC --> O(n(log n))