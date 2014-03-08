import java.util.Scanner;
import java.util.*;
class weekTest3{
	public static void main(String arg[]){
	
		ArrayList <String> myList = new ArrayList<String>();
		int count=0;
		System.out.println("Please write the English sentence:");
		Scanner stdIn = new Scanner(System.in);
		String s = stdIn.nextLine();
		s=s.toLowerCase();   /*轉成小寫型態*/
		String [] tokens = s.split(" |;|\\.|,|!|\\?|-");  /*切割字串*/
		for (String temp:tokens){
			if(temp.length()>0){
				try
				{
					count +=Integer.parseInt(temp); /*累計數字*/
				}
				catch (Exception e)
				{
					myList.add(temp);
				}
			}
		}
		for(String a:myList)
			System.out.println(a);
		System.out.println("count = " + count);
	}
}
