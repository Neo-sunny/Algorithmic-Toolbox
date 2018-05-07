package com.mmt.challenge;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Poisionous1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < tcase; t++) {
			int num = Integer.parseInt(br.readLine());
			String[] valus = br.readLine().split("\\s+");
			System.out.println(Arrays.toString(valus));
			long maximumsum = 0;
			for (int n = 0; n < num; n++) {
				int val =  Integer.parseInt(valus[n]);
				if (val > 0) {
					maximumsum += val;
				}
			}
			//System.out.println(maximumsum);
			if (maximumsum == 1) {
				System.out.println("Yes");
			} else if (maximumsum % 2 != 0) {
				System.out.println("No");
			} else if (maximumsum % 2 == 0) {
				while (maximumsum > 0) {
					maximumsum = maximumsum / 2;
					//System.out.println(maximumsum);
					if (maximumsum % 2 != 0)
						break;
				}
				if (maximumsum == 1) {
					System.out.println("Yes");
				} else if (maximumsum != 1) {
					System.out.println("No");
				}
			}
		}

	}
}