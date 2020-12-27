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
		        System.out.printf("You will receive %d boxes, %d boxes containing 5 books each and one box containing %d book(s).", boxesCount, boxesCount - 1, this.booksCount % 5 );
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
			int booksCount;
			while(greaterThanZero > 0) {
				System.out.println();
				System.out.print("How many books do you have for shipping? ");
				try {
					booksCount = userInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid number of books, enter an intger");
					userInput.nextLine();
					continue;
				}
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
			boolean correct = false;
			
			System.out.println();
			System.out.println("Enter a few numbers to find the minumum, 0 to exit. ");
			while(!correct) {
				try {
					System.out.println("Write a number:");
					a = userInput.nextInt();
					correct = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid number, enter an integer");
					userInput.nextLine();
					continue;
				}
			}
			minimum = a;
			while (a > 0) {
				System.out.println("Write another number (0 -exit):");
				try {
					a = userInput.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid number, enter an integer");
					userInput.nextLine();
					continue;
				}
				
				if(a != 0 && a < minimum) minimum = a;	
			} 
			System.out.println("The minimum number that you have entered was: " + minimum);
		}
		
		public static void task3() {
			int averageSpeed = 1;
			double mileage = 1.0;
			boolean correct = false;
			
			System.out.println();
						
			while(!correct) {
				try {
					System.out.println("Enter the average speed <km/h>:");
					averageSpeed = userInput.nextInt();
					correct = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid average speed, enter an integer");
					userInput.nextLine();
					continue;
				} 
			}
			
			correct = false;
			
			while(!correct) {
				try {
					System.out.println("Enter the remaining mileage <mile>:");
					mileage = userInput.nextDouble();
					 correct = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid mileage, enter a double number");
					userInput.nextLine();
					continue;
				} 
			}
			
			mileage = mileage * 10; // in km
			double remainingTime = mileage / averageSpeed;
			remainingTime = remainingTime * 60; // in min
			int remainingHours = (int)remainingTime / 60;
			int remainingMinutes = (int)(remainingTime % 60);
			System.out.printf("Your remaining travel time is: %d hour(s) and %d minutes.", remainingHours, remainingMinutes);			
		}
		
		public static void main(String[] args) {
			int choice = 0;
			while(true) {
				System.out.println();
				System.out.println();
				System.out.println("1. Taks 1");
				System.out.println("2. Taks 2");
				System.out.println("3. Taks 3");
				System.out.println("0. Exit");
				System.out.print("Choose the task number (1-3), 0 to exit : ");

				try {
					choice = userInput.nextInt();
				} catch (InputMismatchException e) {
					userInput.nextLine();
					System.out.println("Invalid choice, enter an integer (0-3).");
					continue; 
				}
				
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
				case 0:
					return;
				}			
			} 
		}
	}
	
