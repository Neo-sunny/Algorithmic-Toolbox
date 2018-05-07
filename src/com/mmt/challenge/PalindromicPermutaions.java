package com.mmt.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PalindromicPermutaions {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		allPalPermutation(s);
	}
	
	static void allPalPermutation(String str){
		Map<Character, Integer> charmap = new HashMap<Character, Integer>();
		
		for(char c: str.toCharArray()){
			if(charmap.containsKey(c)){
				charmap.put(c, charmap.get(c)+1);
			}else{
				charmap.put(c, 1);
			}
		}
		int odd =0;
		String mid="", left="", right="";
		
		for(Map.Entry<Character, Integer> m: charmap.entrySet() ){
			char key = m.getKey();
			int val = m.getValue();
			
			
			if( (val & 1)==1){
				
				if(++odd >1)
					return;
				
				val = val-1;
				mid = Character.toString(key);
			}
			
			val = val/2;
			while(val-->0){
				left = left + key;
			}
		}
		System.out.println(left);
		Set<String> allperms = StringHelper.permutationFinder(left);
		System.out.println(allperms);
		 List<String> sirted = new ArrayList<String>(allperms);
	     Collections.sort(sirted);
		for(int i=0; i<allperms.size(); i++){
			StringBuilder b = new StringBuilder(sirted.get(i));
			right = b.reverse().toString();
			System.out.println(left+mid+right);
		}
	}
}
