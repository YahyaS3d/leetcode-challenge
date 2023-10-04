import java.io.*;
import java.util.*;

public class HashMapFileIO {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        // Reading key-value pairs from a file and populating the HashMap
        readFromFile("data.txt", myHashMap);

        // Performing some operations on the HashMap
        myHashMap.put(1, 10);
        myHashMap.put(2, 20);
        myHashMap.put(3, 30);
        System.out.println("Value for key 1: " + myHashMap.get(1));
        System.out.println("Value for key 4: " + myHashMap.get(4));

        // Writing the updated HashMap back to a file
        writeToFile("data.txt", myHashMap);
    }

    // Overloaded method to read key-value pairs from a file and populate the HashMap
    public static void readFromFile(String filename, MyHashMap myHashMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    int key = Integer.parseInt(parts[0]);
                    int value = Integer.parseInt(parts[1]);
                    myHashMap.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Overloaded method to write the HashMap contents to a file
    public static void writeToFile(String filename, MyHashMap myHashMap) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int key = 0; key <= 100; key++) {
                int value = myHashMap.get(key);
                if (value != -1) {
                    bw.write(key + ":" + value);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}