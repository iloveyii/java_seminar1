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
		
		public static void main(String[] args) {
			int greaterThanZero = 1;
			System.out.println("main");
			while(greaterThanZero > 0) {
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
		
	}
	
