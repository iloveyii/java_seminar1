import java.util.Scanner;
import java.util.*;
	
	public class BookStore {
		static double BOX_SIZE = 5.0;
		
		public BookStore() {
			
		}
		
		public void printMenu() {
	        System.out.println("1. Book a seat ");
	        System.out.println("2. View Booking ");
	        System.out.println(calculateBoxes(13));
	    }
		
		public int calculateBoxes(int booksCount) {
			int boxesCount = (int)Math.ceil(booksCount/BOX_SIZE);
			return boxesCount;
		}
		
		public static void main(String[] args) {
			BookStore bs = new BookStore();
			bs.printMenu();
			System.out.println("main");
		}
		
	}
	
