import java.util.Scanner;
import java.util.*;
	
	public class BookStore {
		static double BOX_SIZE = 5.0;
	    static Scanner userInput = new Scanner(System.in);
	    int booksCount = 0;
	
		public BookStore(int booksCount) {
			this.booksCount = booksCount;
		}
		
		public void shippingInfo() {
	        int boxesCount = calculateBoxes();
	        double shippingCost = calculateShippingFee();
	        int remainder = this.booksCount % 5;
	        if(remainder == 0) {
		        System.out.printf("You will receive %d boxes containing 5 books each.", boxesCount);
	        } else {
		        System.out.printf("You will receive %d boxes, %d boxes containing 5 books each and one box containing %d books.", boxesCount, boxesCount - 1, this.booksCount % 5 );
	        }
	        System.out.println();
	        System.out.printf("The shipping price will be: %.2f sek", shippingCost);
	    }
		
		public int calculateBoxes() {
			int boxesCount = (int)Math.ceil(this.booksCount/BOX_SIZE);
			return boxesCount;
		}
		
		public double calculateShippingFee() {
			double fee = 5;
			double shippingCost = 0;
			int boxesCount = calculateBoxes();
			if(boxesCount > 0 && boxesCount < 6) {
				fee = 8;
			}
			if(boxesCount > 5 && boxesCount < 51) {
				fee = 5;
			}
			shippingCost = boxesCount * fee;
			return shippingCost;
		}
		
		public static void task1() {
			int greaterThanZero = 1;
			while(greaterThanZero > 0) {
				System.out.println();
				System.out.print("How many books do you have for shipping? ");
				int booksCount = userInput.nextInt();
	            if (booksCount < 1) {
	                System.out.println("Not a valid number, try again.");
	            } else {
	            	BookStore bs = new BookStore(booksCount);
	            	bs.shippingInfo();
	            	greaterThanZero = 0;
	            }
			}
		}
		
		public static void task2() {
			int a = 0;
			int minimum = a;
			System.out.println();
			System.out.println("Enter a few numbers to find the minumum, 0 to exit. ");
			System.out.println("Write a number:");
			a = userInput.nextInt();
			minimum = a;
			while (a > 0) {
				System.out.println("Write another number:");
				a = userInput.nextInt();
				if(a != 0 && a < minimum) minimum = a;	
			} 
			System.out.println("The minimum number that you have entered was: " + minimum);
		}
		
		public static void task3() {
			System.out.println();
			System.out.println("Enter the average speed <km/h>:");
			int averageSpeed = userInput.nextInt();
			System.out.println("Enter the remaining mileage <mile>:");
			double mileage = userInput.nextDouble();
			mileage = mileage * 10; // in km
			double remainingTime = mileage / averageSpeed;
			remainingTime = remainingTime * 60; // in min
			int remainingHours = (int)remainingTime / 60;
			int remainingMinutes = (int)(remainingTime % 60);
			System.out.printf("Your remaining travel time is: %d hour(s) and %d minutes.", remainingHours, remainingMinutes);			
		}
		
		public static void main(String[] args) {
			int choice = 0;
			do {
				System.out.println();
				System.out.println();
				System.out.println("1. Taks 1");
				System.out.println("2. Taks 2");
				System.out.println("3. Taks 3");
				System.out.println("0. Exit");
				System.out.print("Choose the task number (1-3), 0 to exit : ");
				choice = userInput.nextInt();
				switch(choice) {
				case 1:
					task1();
					break;
				case 2:
					task2();
					break;
				case 3:
					task3();
					break;
				}			
			} while (choice != 0);
		}
	}
	
