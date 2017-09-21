package lection3_2;

public class CountSumNumbers {

		public int countSum() {
		GenerateRandomNumber number = new GenerateRandomNumber();
		int a = number.randomNumber();
		System.out.println(a);
		int sum=0;
		while (a != 0) {
			sum = sum + (a % 10);
			a /= 10;
			}
		return sum;
	}
}
