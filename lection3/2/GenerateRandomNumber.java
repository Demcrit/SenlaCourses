package lection3_2;

import java.util.Random;

public class GenerateRandomNumber {

	public int randomNumber(){
	Random random = new Random();
	return random.nextInt(900)+100;
		}
	}