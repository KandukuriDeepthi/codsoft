package codsoft;
import java.util.*;
public class WordCounter {
		static Scanner scan = new Scanner(System.in);
		public static void main(String[] args) {
			text_wordcounter();
			}
		public static void text_wordcounter() {
			int counter =0;
			System.out.println("Enter the text : ");
			String text = scan.nextLine();
			String[] str_array = null;
			str_array = text.split(" ");
			for(int i=0;i<str_array.length;i++) {
				counter++;
			}
			System.out.println("word count : "+counter);
		}
}
