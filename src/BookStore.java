import java.util.Scanner;
import java.util.*;
	
	public class BookStore {
		static double BOX_SIZE = 5.0;
	    static Scanner userInput = new Scanner(System.in);
	    int booksCount = 0;
	
		public BookStore(int booksCount) {
			this.booksCount = booksCount;
		}
		
		public void printMenu() {
	        System.out.println("1. Book a seat ");
	        System.out.println("2. View Booking ");
	        System.out.println(calculateBoxes());
	        System.out.println(calculateShippingFee());
	    }
		
		public int calculateBoxes() {
			int boxesCount = (int)Math.ceil(this.booksCount/BOX_SIZE);
			return boxesCount;
		}
		
		public double calculateShippingFee() {
			double fee = 0;
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
				System.out.print("Enter number of books to ship: ");
				int booksCount = userInput.nextInt();
	            if (booksCount == 0) {
	                System.out.println("Enter number of books greater than 0");
	            } else {
	            	BookStore bs = new BookStore(booksCount);
	            	bs.printMenu();
	            	greaterThanZero = 0;
	            }
			}
		}
		
	}
	
