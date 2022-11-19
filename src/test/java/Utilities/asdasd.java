package Utilities;

import java.util.Arrays;
import java.util.Scanner;

public class asdasd {
	public static void main(String[] args) {

		int[] city = { 3, 6, 0, 8, 0, 2, 7, 9 };

		int[] limbo = new int[city.length];
		boolean EXTINCTION = false;
		int days = 0;
		System.out.println("Day 0 " + Arrays.toString(city));

		while (!EXTINCTION) {
			System.arraycopy(city, 0, limbo, 0, city.length);

			for (int i = 0; i < city.length; i++) {

				if (limbo[i] == 0) {
					if (i != 0) {
						city[i - 1] /= 2;
					}
					if (i != city.length - 1) {
						city[i + 1] /= 2;
					} else {
						if ((i != city.length - 1) && (limbo[i + 2] == 0)) {

						} else {
							city[i + 1] /= 2;

						}
					}
				}

				days++;
				System.out.println("Day " + days + " " + Arrays.toString(city));

				int dead_cities = 0;
				for (int idx = 0; idx < city.length; idx++) {
					if (city[idx] == 0) {
						dead_cities++;
					}
				}
				if (dead_cities == city.length)
					EXTINCTION = true;
			}
		}
	}

}
