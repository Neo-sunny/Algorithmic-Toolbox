package com.mmt.challenge;

import java.util.HashSet;
import java.util.Set;

public class PalindromicSubStrings {
	static Set<Integer> palinsizes = new HashSet<Integer>();
	 public static void expand(String str, int low, int high, Set<String> set)
	    {
	        // run till str[low.high] is a palindrome
	        while (low >= 0 && high < str.length()
	                && str.charAt(low) == str.charAt(high))
	        {
	            // push all palindromes into the set
	            set.add(str.substring(low, high + 1));
	            palinsizes.add(str.substring(low, high + 1).length());
	            // expand in both directions
	            low--;
	            high++;
	        }
	    }
	 
	 
	 public static void allPalindromicSubStrings(String str)
	    {
	        // create an empty set to store all unique palindromic substrings
	        Set<String> set = new HashSet<>();
	 
	        for (int i = 0; i < str.length(); i++)
	        {
	            // find all odd length palindrome with str[i] as mid point
	            expand(str, i, i, set);
	 
	            // find all even length palindrome with str[i] and str[i+1]
	            // as its mid points
	            expand(str, i, i + 1, set);
	        }
	 
	        // print all unique palindromic substrings
	        System.out.print(set);
	        
	    }
	 
	 
	 public static void main(String[] args)
	    {
	        String str = "babammm";
	 
	        allPalindromicSubStrings(str);
	        System.out.println(palinsizes);
	    }
}
