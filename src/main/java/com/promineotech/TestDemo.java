package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive (int a, int b) {
		if (a <= 0 || b <= 0) {
				throw new IllegalArgumentException ("Both parameters must be positive!");
			}
			return a + b;
		}
	
	//step 3
	public int divideNegative(int a, int b) {
		if (a >= 0 || b >= 0) {
			throw new IllegalArgumentException ("Both parameters must be negative!");
		}
		return a / b;
	}
	
	//step 4
	//still need to finish this, not sure if this is correct
	public int randomNumberSquared () {
		int a = getRandomInt();
		return a * a;
		}
		
	
	
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}