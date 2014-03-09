import java.util.Scanner;
import java.util.*;
import java.io.*;

class weekTest3_3{
	public static void main(String[] args)throws IOException{
		
		HashMap<String,Integer> hash = new HashMap<String,Integer>();
		int opt = 0,count = 0;
		
		Scanner stdIn = new Scanner(System.in);
		try{ /*讀取檔案*/
				FileReader fOpen = new FileReader("weekTest3_3.txt");
				BufferedReader fileOpen = new BufferedReader(fOpen);

				String temp = fileOpen.readLine();
				count=Integer.parseInt(temp);
		
				while( (temp = fileOpen.readLine()) != null ){
					String[] tokens = temp.split(" |,|!|\\?|-|_|\\.");
					String word = tokens[0];
					int countNum = Integer.parseInt(tokens[1]);
					hash.put(word,countNum);
			}
			fOpen.close();
		}
		catch(IOException e){
			System.out.println("It doesn't read the file!\n");
		}
		
		while(true)
		{
			System.out.println("1)Input 2)Search 3)Print 4)Exit?");
			opt = stdIn.nextInt();
			if(opt == 1){
				String s = stdIn.nextLine(); /*前面會有空白鍵產生*/
				System.out.println("Please write the English sentence:");
				s = stdIn.nextLine();
				
				s=s.toLowerCase();   /*轉成小寫型態*/
				String [] tokens = s.split(" |;|\\.|,|!|\\?|-");  /*切割字串*/
				for (String str:tokens){
					if(str.length()>0){
						try
						{
							count +=Integer.parseInt(str); /*累計數字*/
						}
						catch (Exception e)
						{
							if(hash.get(str) == null)
								hash.put(str,1);
							else{
								int valueNum = hash.get(str) + 1;
								hash.put(str,valueNum);
							}
						}
					}
				}
			}
			else if(opt == 2){
				Scanner key = new Scanner(System.in);
				System.out.print("Search Key:");
				String searchKey = key.nextLine();
				if(hash.get(searchKey) == null)
					System.out.println("Not Found!\n");
				else
					System.out.println("countNum :" + hash.get(searchKey));
			}
			else if(opt == 3){
				for(Object ob : hash.keySet())
						System.out.println(ob + " : " + hash.get(ob));
					System.out.println("countNum = " + count);
			}
			else if(opt == 4){
				FileWriter fWrite = new FileWriter("weekTest3_3.txt");
				BufferedWriter buFileWite = new BufferedWriter(fWrite);
				String tempValue = Integer.toString(count);
				buFileWite.write(tempValue);
				buFileWite.newLine();
				for(Object ob : hash.keySet()){
					buFileWite.write(ob + " " + hash.get(ob));
					buFileWite.newLine();
				}
				buFileWite.flush();
				buFileWite.close();
				break;
			}
		}
    }
}