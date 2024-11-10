package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
		
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(2, 7)).isEqualTo(9);
		assertThat(testDemo.addPositive(42, 674)).isEqualTo(716);
		assertThat(testDemo.addPositive(835, 9)).isEqualTo(844);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		//step 1-4 e. ii. Test the value of expectException
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
				arguments(2, 3, 5, false),
				arguments(-1, 5, 0, true),
				arguments(4, -2, 0, true),
				arguments(0, 2, 0, true),
				arguments(1, 1, 2, false)
				);
	}
	
	@Test
	void assertThatPairsOfNegativeNumbersAreDividedCorrectly() {
		assertThat(testDemo.divideNegative(-4, -2)).isEqualTo(2);
		assertThat(testDemo.divideNegative(-635, -127)).isEqualTo(5);
		assertThat(testDemo.divideNegative(-432, -3)).isEqualTo(144);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}	
}

