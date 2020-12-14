package Gmax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Properties {
	private static Scanner sr;
	void createFile(String filename) {
		try {
		      File file = new File(filename);
		      if (file.createNewFile()) {
		    	  System.out.println("Created the file Successfully!! :)");
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("Unable to Create File:(");
		      e.printStackTrace();
		    }
	  }
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	 public void WriteToFile(String data,String filename,String x) {
		    try {
		    	sr = new Scanner(new File(filename));
		         String input;
			      while (sr.hasNextLine()) {
			         input = sr.nextLine();
		         if(input.contains(x))
		         {
		         System.out.println("Key is Unique for DataStore. So, Cannot be Re-used!!");
		         return;
		         }
			     }
		    	 BufferedWriter out = new BufferedWriter( 
		                   new FileWriter(filename, true)); 
		            out.write(data); 
		            out.newLine();
		            out.close(); 
		      System.out.println("Key-Value pair has been added in "+filename);
		    } catch (IOException e) {
		      System.out.println("Unable to write");
		      e.printStackTrace();
		    }
		  }
	 
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 
	 public void readFile(String x,ArrayList<String> keY,ArrayList<Integer> value)
		{
		if(keY.contains(x))
		 {
		 int index=keY.indexOf(x);
		 System.out.println("{"+keY.get(index)+" : "+value.get(index)+"}");
		 }
		 else
			 System.out.println("Invalid KEY!!");
	     }
	 
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 
	 public void ModifyValue(String x,int y,ArrayList<String> keY,ArrayList<Integer> value,String fname)
	 {
		 try {
			 sr = new Scanner(new File(fname));
		if(keY.contains(x))
		 {
		 int index=keY.indexOf(x);
		String m=""+keY.get(index)+" : "+value.get(index);
		String n=""+keY.get(index)+" : "+y;
		value.set(index, y);
		StringBuffer sb = new StringBuffer();
	      String input;
	      while (sr.hasNextLine()) {
	         input = sr.nextLine();
	         sb.append(input);
	         sb.append(System.getProperty("line.separator"));
	      }
	      String contents = sb.toString();
	      //Replacing the word with desired one
	      contents = contents.replace(m, n);
	      FileWriter writer = null;
	      try {
			writer=new FileWriter(new File(fname));
	             
	            writer.write(contents);
	            writer.close();
		 }
	            catch (IOException e) {
	    			// TODO Auto-generated catch block
	            	 System.out.println("File Modification Unsuccessful.");
	    			e.printStackTrace();
	    		}
	      System.out.println("File Modified Successfully!!");
		 }
		else
		{
			System.out.println("KEY not found!!");
		}
	 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFound");
			e.printStackTrace();
		}
	 } 
	 
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 
	 public void DeleteKeyValuePair(String x,ArrayList<String> keY,ArrayList<Integer> value,String fname)
	 {
		 try {
			 sr = new Scanner(new File(fname));
		if(keY.contains(x))
		 {
		 int index=keY.indexOf(x);
		String m=""+keY.get(index)+" : "+value.get(index);
		keY.remove(index);value.remove(index);
		StringBuffer sb = new StringBuffer();
	      String input;
	      while (sr.hasNextLine()) {
	         input = sr.nextLine();
	         sb.append(input);
	         sb.append(System.getProperty("line.separator"));
	      }
	      String contents = sb.toString();
	      //Replacing the word with desired one
	      contents = contents.replace(m,"");
	      String pattern="(?m)^\\s*\\r?\\n|\\r?\\n\\s*(?!.*\\r?\\n)";
	      contents = contents.replaceAll(pattern, "");
	      FileWriter writer = null;
	      try {
			writer=new FileWriter(new File(fname));
	             
	            writer.write(contents);
	            writer.close();
		 }
	            catch (IOException e) {
	    			// TODO Auto-generated catch block
	            	 System.out.println("File Modification Unsuccessful.");
	    			e.printStackTrace();
	    		}
	      System.out.println("Key-Value Pair deleted Successfully!!");
		 }
		else
		{
			System.out.println("KEY not found!!");
		}
	 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFound");
			e.printStackTrace();
		}
	 } 
}
