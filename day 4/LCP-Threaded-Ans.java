import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int numThreads = Runtime.getRuntime().availableProcessors(); // Use available CPU cores
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int chunkSize = strs.length / numThreads;
        int remainder = strs.length % numThreads;

        List<Future<String>> futures = new ArrayList<>();

        int startIndex = 0;
        for (int i = 0; i < numThreads; i++) {
            int endIndex = startIndex + chunkSize + (i < remainder ? 1 : 0);
            String[] chunk = Arrays.copyOfRange(strs, startIndex, endIndex);
            Future<String> future = executor.submit(new LongestCommonPrefixTask(chunk));
            futures.add(future);
            startIndex = endIndex;
        }

        String longestCommonPrefix = "";
        for (Future<String> future : futures) {
            try {
                String result = future.get();
                if (result.isEmpty()) {
                    return "";
                }
                if (longestCommonPrefix.isEmpty()) {
                    longestCommonPrefix = result;
                } else {
                    longestCommonPrefix = findCommonPrefix(longestCommonPrefix, result);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return longestCommonPrefix;
    }

    private String findCommonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        int commonLength = 0;
        while (commonLength < minLength && str1.charAt(commonLength) == str2.charAt(commonLength)) {
            commonLength++;
        }
        return str1.substring(0, commonLength);
    }

    private class LongestCommonPrefixTask implements Callable<String> {
        private final String[] chunk;

        public LongestCommonPrefixTask(String[] chunk) {
            this.chunk = chunk;
        }

        @Override
        public String call() {
            String prefix = chunk[0];
            for (int i = 1; i < chunk.length; i++) {
                while (chunk[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }
            return prefix;
        }
    }
}
