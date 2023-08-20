package codsoft;
import java.util.*;
import java.lang.Math;

public class NumberGame {
	static Scanner scan2 = new Scanner(System.in);



	public static void main(String[] args) {

		System.out.println("Welcome to the game");

		game_method();

		}

	public static void repeat() {

		System.out.println("Would you like to play the game again");

		System.out.println("If YES click 1");

		System.out.println("If NO click 0");

		int YN = scan2.nextInt();

		if(YN == 1) {

			game_method();

		}

		else if (YN == 0) {

			System.out.println("Thank You for Playing");

			

		}

		

	}

	public static void game_method() {

		Random random_obj = new Random();

		int random_number = random_obj.nextInt(101);

		//Scanner scan = new Scanner(System.in);

		System.out.println("You have three chances");

		for( int i =1;i<=3;i++) {

			System.out.println("Enter your choice of number between 1 to 100 : ");

			int user_number = scan2.nextInt();

			if(user_number<0 || user_number > 100) {

				System.out.println("invalid input number , Please choose a number between 1 to 100");

			}

			else {

			System.out.println("The number you have entered is : "+user_number);

			int diff = random_number - user_number;

			diff = Math.abs(diff);

			//System.out.println(diff);

			if(diff>=50 && diff < 100) {

				System.out.println("Wrong guess");

				System.out.println(" ");

			}

			else if (diff >= 40 && diff < 50) {

				System.out.println("Wrong guess");

				System.out.println("you are too far from the target number");

				System.out.println(" ");

			}

			else if (diff >= 30 && diff < 40) {

				System.out.println("Wrong guess");

				System.out.println("You are far from the target");

				System.out.println(" ");



			}

			else if (diff >=20 && diff < 30) {

				System.out.println("Wrong guess");

				System.out.println("you need to get close to the number");

				System.out.println(" ");

			}

			else if (diff >= 10 && diff < 20) {

				System.out.println("Wrong guess");

				System.out.println("you still have to get close to the number");

				System.out.println(" ");

			}

			else if (diff > 0 && diff < 10) {

				System.out.println("Wrong guess");

				System.out.println("A little bit more closer");

				System.out.println(" ");

			}

			else if ( diff==0) {

				System.out.println("OMG ! YOU guessed it right");

				System.out.println("Congratulations ! Winner");

				System.out.println(" ");

			}

		

		}

			

		}

		System.out.println("Better Luck Next Time");

		System.out.println(" ");

		repeat();		

		

		

	}

}
