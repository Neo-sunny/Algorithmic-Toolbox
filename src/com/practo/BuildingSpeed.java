package com.practo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BuildingSpeed {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Accept the input from console
		int Associations = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("\\s+");
		// int[] inpArr = convertToIntArray(input);
		// Arrays.sort(inpArr);
		int optimumSum = 0;
		// convert the input to required type  
		List<Integer> inpList = convertToIntList(input);
		Collections.sort(inpList);
		// If N(Associations) == elements/2
		if (Associations == inpList.size() / 2) {
			// use simple approach
			int i = 0;
			while (inpList.size() > 1) {
				// get the first element 		
				Integer x = inpList.get(i);
				for (int j = i + 1; j < inpList.size(); j++) {
					if (inpList.get(j) >= x) {
				// get the next element		
						Integer y = inpList.get(j);
				// get the optimum sum		
						optimumSum += x;
				// remove both the elements		
						inpList.remove(x);
						inpList.remove(y);
						break;
					}
					i = 0;
				}

			}
		// print the optimum sum	
			System.out.println(optimumSum);
// 			If N(Associations) , elements/2
		} else if (Associations < inpList.size()) {
			// get the difference factor
			int diffFactor = (inpList.size() / 2 - Associations);
			// get the difference factor and remove these number of elements
			int startIndex = diffFactor * 2;
			// In order to be optimized sum get only those elements removing the 
			// least elements from the sum
			List<Integer> newInpAray = inpList.subList(startIndex, inpList.size());

			// use the above approach

		}

	}

	
	static List<Integer> convertToIntList(String[] inp) {
		List<Integer> inpList = new ArrayList();
		for (int index = 0; index < inp.length; index++) {
			inpList.add(Integer.parseInt(inp[index]));
		}
		return inpList;
	}
}
