package lection3_2;

import java.util.Random;

public class All {

	public void sum(int a){
	
	Random random = new Random();
	a = random.nextInt(1000);
	System.out.println("Сгенерированное число: " + a);
	
	int sum=0;
	while(a != 0){
	        sum = sum + (a % 10);
	        a/=10;
	}
	System.out.println("Сумма цифр данного числа:" + sum);


}
}