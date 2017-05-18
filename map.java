//code by pratik mallya

//importing libraries
import java.util.*;
import java.io.*;
import java.awt.*;

//class initialised
public class map implements Serializable
{
        //main
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in); //scanner class to read user input
		Map<Integer,String> mapdata = new HashMap<Integer,String>(); //initialising hash map for integer key and String value
		System.out.println("Enter map size:"); 
		int num = sc.nextInt(); //taking user input for map size 
		int count = 0; //initialising count
		while(count<=num) //running while loop for map input till it exceeds the size
		{
			System.out.println("Enter key<int> and value<string> seperated by a space for map:");
			int key = sc.nextInt(); // key input
			String value = sc.nextLine(); // value input
			if(count<num) //checking final count
			mapdata.put(key,value); //entering data to map
			count = count + 1; //increment count
		}
		if(count>num) //checking total input
		{
			System.out.println("Map limit exceeded\nMap content: "+mapdata+"\nSpilling map to disk \nCreating map.ser on disk");
			try{
				FileOutputStream outf = new FileOutputStream("map.ser"); //creating output stream object for serializability
				ObjectOutputStream outob = new ObjectOutputStream(outf);
				outob.writeObject(mapdata);//writing map data serilizably to disk
				outob.close(); //closing objects
				outf.close();
                                System.out.println("Map spilt on map.ser on disk successfully\n");
				mapdata.clear();
                                
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

		}
	}
}
