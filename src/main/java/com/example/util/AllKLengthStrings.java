/**
 * @author Anurag
 * @description 
 */
package com.example.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anurag
 * @description 
 */
public class AllKLengthStrings {
//
//    public static Map<String, List<Integer>> KLengthStrings = new HashMap();
//
//    public static void main(String[] args) {
//        // char set1[] = {'a', 'b'};
//        int set1[] = {1, 2};
//        List<Integer> sizes = new ArrayList<Integer>();
//        sizes.add(1);
//        sizes.add(2);
//        sizes.add(1);
//        sizes.add(3);
//        int k = 3;
//        printAllKLength(set1, k, sizes);
//
//        // char set2[] = {'a', 'b', 'c', 'd'};
//        int set2[] = {1, 2, 3, 4};
//        k = 4;
//
//        printAllKLength(set2, k, sizes);
//
//    }
//
//    // The method that prints all possible strings of length k. It is
//    // mainly a wrapper over recursive function printAllKLengthRec()
//    static Map<String, List<Integer>> printAllKLength(int set[], int k, List<Integer> sizes) {
//        KLengthStrings = new HashMap<String, List<Integer>>();
//        int n = set.length;
//        printAllKLengthRec(set, "", n, k, sizes);
//        return KLengthStrings;
//    }
//
//    private static boolean validCombination(List<Integer> combination, List<Integer> sizes) {
//        boolean valid = true;
//        for (int i = 0; i < combination.size(); i++) {
//            valid = valid && combination.get(i) < sizes.get(i) ? true : false;
//        }
//        return valid;
//    }
//
//    // The main recursive method to print all possible strings of length k
//    static void printAllKLengthRec(int set[], String prefix, int n, int k, List<Integer> sizes) {
//
//        // Base case: k is 0, print prefix
//        if (k == 0) {
//            // System.out.println(prefix);
//            List<String> combinationAsString = Arrays.asList(prefix.split(","));
//            List<Integer> combinationAsInteger = new ArrayList<Integer>();
//            for (int z = 0; z < combinationAsString.size(); z++) {
//                combinationAsInteger.add(Integer.parseInt(combinationAsString.get(z)));
//            }
//            // System.out.println(" LIST " + combinationAsInteger.toString());
//            if (validCombination(combinationAsInteger, sizes)) {
//                KLengthStrings.put(prefix, combinationAsInteger);
//            }
//            // System.out.println("HASHMAP " + KLengthStrings.toString());
//            return;
//        }
//
//        // One by one add all characters from set and recursively
//        // call for k equals to k-1
//        for (int i = 0; i < n; ++i) {
//
//            // Next character of input added
//            String newPrefix = null;
//            if (prefix.equals("") || prefix == null) {
//                newPrefix = set[i] + "";
//            } else {
//                newPrefix = prefix + "," + set[i];
//            }
//            // k is decreased, because we have added a new character
//            printAllKLengthRec(set, newPrefix, n, k - 1, sizes);
//        }
//    }
}
