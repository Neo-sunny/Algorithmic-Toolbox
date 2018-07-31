package com.wissen.technology;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Frequency {

	public static void main(String[] args) {

		Map<Integer, Integer> values = new HashMap<Integer, Integer>();
		// To Avoid concurrentModification Exception
		Map<Integer, Integer> maxFreq = new ConcurrentHashMap<Integer, Integer>();
		Map<Integer, Integer> minFreq = new ConcurrentHashMap<Integer, Integer>();
	
		int maxFrequency = Integer.MIN_VALUE;
		int minFrequency = Integer.MAX_VALUE;
		
		Scanner inp = new Scanner(System.in);
		int N = inp.nextInt();
		for (int i = 0; i < N; i++) {
			int value = inp.nextInt();
			if (values.containsKey(value)) {
				values.put(value, (values.get(value) + 1));
				if (values.get(value) >= maxFrequency) {
					maxFrequency = values.get(value);
					maxFreq.put(value,maxFrequency);
					// remove the values whose frequency gets lowered
					for(Map.Entry<Integer, Integer> m : maxFreq.entrySet()){
						if(m.getValue() < maxFrequency){
							maxFreq.remove(m.getKey());
						}
					}
				}
				if (values.get(value) <= minFrequency) {
					minFrequency = values.get(value);
					minFreq.put(value, minFrequency);
					// remove the values whose frequency gets higher
					for(Map.Entry<Integer, Integer> m : minFreq.entrySet()){
						if(m.getValue() > minFrequency){
							minFreq.remove(m.getKey());
						}
					}
				}
			} else {
				values.put(value, 1);
				if (values.get(value) >= maxFrequency) {
					maxFrequency = values.get(value);
					maxFreq.put(value, maxFrequency);
				}
				if (values.get(value) <= minFrequency) {
					minFrequency = values.get(value);
					minFreq.put(value, minFrequency);
				}
			}
		}
		
		System.out.println(values+" "+maxFreq+" "+minFreq+" " +Collections.max(minFreq.keySet()) +" "+ Collections.min(maxFreq.keySet()));
	}

}
