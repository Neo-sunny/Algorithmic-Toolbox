package com.mmt.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Candies {
	static Set<Integer> countpalindromiclengths = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		allPalPermutation(s);
		allPalindromicSubStrings(s);
		System.out.println(countpalindromiclengths);
		int tcase = Integer.parseInt(br.readLine());
		for(int t=0; t<tcase; t++){
			Integer val = Integer.parseInt(br.readLine());
			if(countpalindromiclengths.contains(val)){
				System.out.println(val);
			}else{
				System.out.println("-1");
			}
		}
	}

	static void allPalPermutation(String str) {
		Map<Character, Integer> charmap = new HashMap<Character, Integer>();

		for (char c : str.toCharArray()) {
			if (charmap.containsKey(c)) {
				charmap.put(c, charmap.get(c) + 1);
			} else {
				charmap.put(c, 1);
			}
		}
		int oddcount = 0;
		String middle = "", left = "", right = "";

		for (Map.Entry<Character, Integer> m : charmap.entrySet()) {
			char key = m.getKey();
			int val = m.getValue();

			if ((val & 1) == 1) {

				if (++oddcount > 1)
					return;

				val = val - 1;
				middle = Character.toString(key);
			}

			val = val / 2;
			while (val-- > 0) {
				left = left + key;
			}
		}
		// System.out.println(left);
		Set<String> allperms = permutationFinder(left);
		// System.out.println(allperms);
		List<String> sirted = new ArrayList<String>(allperms);
		Collections.sort(sirted);
		for (int i = 0; i < allperms.size(); i++) {
			StringBuilder b = new StringBuilder(sirted.get(i));
			right = b.reverse().toString();
			String permpalindrome = left + middle + right;
			System.out.println(permpalindrome);
			countpalindromiclengths.add(permpalindrome.length());
		}
	}

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
	public static void expand(String str, int low, int high, Set<String> set) {

		while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {

			set.add(str.substring(low, high + 1));
			countpalindromiclengths.add(str.substring(low, high + 1).length());

			low--;
			high++;
		}
	}

	public static void allPalindromicSubStrings(String str) {

		Set<String> set = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {

			expand(str, i, i, set);

			expand(str, i, i + 1, set);
		}

	}

}