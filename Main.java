package Gmax;
import java.util.*;
public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
	sc = new Scanner(System.in);
    Properties p=new Properties();
    System.out.println("Welcome to File based Key-Value Data Store:)");
    System.out.println("How do you like to create a file?");
    System.out.println("Enter the name of file");System.out.println();
    String fname=sc.next();   //give filename with '.txt' extension
    p.createFile(fname);
    System.out.println("What Operation do you want to perform on the existing file?");
    System.out.println();
    System.out.println("1->writeToFile; 2->Read; 3->ModifyValue; 4->DeletePair;(OR) Any Character for Exit");
    System.out.println();
    ArrayList<String> keY=new ArrayList<String>();
	ArrayList<Integer> value=new ArrayList<Integer>(); 
	int flag=1;
	while(flag==1)
	{System.out.println("Choice: ");
	System.out.println();
    switch(sc.nextInt())
	{
	 case 1:
	 {	
		 try
		 {
		 System.out.println();System.out.println("Enter Key : "); System.out.println();String x=sc.next();
		 System.out.println();System.out.println("Enter Value : ");System.out.println();int y=sc.nextInt();
		 
	    if(Integer.toString(y).length()<(16*1024*1024) && x.length()<=32) //(file.length()<(1024*1024*1024)) && 
		 {
		 keY.add(x);value.add(y);String data=""+x+" : "+y;p.WriteToFile(data,fname,x);
		 }
	    else
	    {
	    	System.out.println("Constraint issue encountered!");	
	    }
		 }
		 catch (Exception e) {
             System.out.println("Invalid input!! Key->String; Value->Integer");
         }
	 break;
	 }
	 case 2:
	 {
		 try
		 {
		 System.out.println("Enter Key : ");System.out.println();
		 String x=sc.next();
		 p.readFile(x,keY,value);
		 }
		 catch (Exception e) {
             System.out.println("Invalid input!! Key->String");
         }
		break; 
	 }
	 case 3:
	 {
		 try
		 {
		 System.out.println("Enter Key : ");System.out.println(); String x=sc.next();
		 System.out.println("Enter new Value : ");System.out.println();int y=sc.nextInt();
		 p.ModifyValue(x,y,keY,value,fname);
	     }
		 catch (Exception e) {
             System.out.println("Invalid input!! Key->String; Value->Integer");
         }
		 break;
	 }
	 case 4:
	 {
		 try
		 {
		 System.out.println("Enter Key : "); System.out.println();String x=sc.next();
		 if(keY.contains(x))
		 {
		 p.DeleteKeyValuePair(x,keY,value,fname);
		 }
		 else
		 {
		 System.out.println("Key not found!!"); 
		 }
		 }
		 catch (Exception e) {
             System.out.println("Invalid input!! Key->String");
         }
		break; 
	 }
	 default:
	 {
		 flag=0;
		 System.out.println("Successfully Exited from the process!!"); 
	 }
	}
}
    
	}

}
