package com.mmt.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringHelper {
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    public static void main(String[] args) {
        String s = "abmmm";
       // String s1 = "ABC";
        //String s2 = "ABCD";
        List<String> sirted = new ArrayList<String>(permutationFinder(s));
        Collections.sort(sirted);
        System.out.println("\nPermutations for " + s + " are: \n" +  sirted);
        System.out.println(sirted.size());
       // System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
       // System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
    }
}