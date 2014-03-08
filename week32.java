import java.util.*;
import java.util.Scanner;

class weekTest3_2{
	
	public static void main(String[] args){
	
		int opt=0,stuGrade;
		String stuName,searchKey;
		Scanner stdIn = new Scanner(System.in);
		while(true)
		{
			HashMap<String,Integer> stuData = new HashMap<String,Integer>();
			System.out.println("1)Input 2)Search 3)Exit?");
			opt = stdIn.nextInt();
			if(opt == 1){
				stuName = stdIn.nextLine();
				System.out.print("Student Name:");
				stuName = stdIn.nextLine();
				
				System.out.print("Student Grade:");
				stuGrade = stdIn.nextInt();
				stuData.put(stuName,stuGrade);
			}
			else if(opt ==2){
				searchKey = stdIn.nextLine();
				System.out.print("Search Key(stuName):");
				searchKey = stdIn.nextLine();
				if(stuData.get(searchKey) == null)
					System.out.println("Not Found!\n");
				else
					System.out.println("stuGrade :" + stuData.get(searchKey));
			}
			else
				return;
		}
	}
}