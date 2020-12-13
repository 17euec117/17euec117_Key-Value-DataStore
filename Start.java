/*This is not the complete code of what I have understood from the assignment. It's just the snippet of attributes and functions. 
 If permitted, I'm willing to propose the implementable solution with "CLEAN CODE" during the next phase of discussion */


/*RAMYAA SHREE K(Department of ECE)*/


package Dstore;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.swing.*;
public class Start {
	public static void read(String x,ArrayList<String> keY,ArrayList<Integer> value)
	{
	if(keY.contains(x))
	 {
	 int index=keY.indexOf(x);
	 System.out.println("{"+keY.get(index)+" : "+value.get(index)+"}");
	 }
	 else
		 System.out.println("Invalid KEY!!");
     }
	public static void removeLineFromFile(String file, String lineToRemove) {

	    try {

	      File inFile = new File(file);

	      if (!inFile.isFile()) {
	        System.out.println("Parameter is not an existing file");
	        return;
	      }

	      //Construct the new file that will later be renamed to the original filename.
	      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

	      BufferedReader br = new BufferedReader(new FileReader(file));
	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

	      String line = null;

	      //Read from the original file and write to the new
	      //unless content matches data to be removed.
	      while ((line = br.readLine()) != null) {

	        if (!line.trim().equals(lineToRemove)) {

	          pw.println(line);
	          pw.flush();
	        }
	      }
	      pw.close();
	      br.close();

	      //Delete the original file
	      if (!inFile.delete()) {
	        System.out.println("Could not delete file");
	        return;
	      }

	      //Rename the new file to the filename the original file had.
	      if (!tempFile.renameTo(inFile))
	        System.out.println("Could not rename file");

	    }
	    catch (FileNotFoundException ex) {
	      ex.printStackTrace();
	    }
	    catch (IOException ex) {
	      ex.printStackTrace();
	    }
	  }
public static int create(String x,int y,int z,File file)
{
	int re=1;
	try
	{
if((file.length()<(1024*1024*1024)) && Integer.toString(y).length()<(16*1024*1024) && x.length()<=32)
{
PrintWriter pw;
	pw = new PrintWriter(file);
pw.print(x);
pw.print(" : ");
pw.println(y);
pw.close(); 
re=1;
}
else
{
	System.out.println("File cannot accept this pair because of constraint issue!!");re=0;
}

}
catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return re;
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	try {
	final File file=new File("filename.txt");
	if(!file.exists())
			file.createNewFile();

	ArrayList<String> keY=new ArrayList<String>();
	ArrayList<Integer> value=new ArrayList<Integer>(); 
	/*Map<String, Integer> kvp=new HashMap<>();
	String m=sc.next();int n=sc.nextInt();
	kvp.put(m,n);
	System.out.println(kvp.get(m));*/
	//pw.println("This is the content of a file");
	//pw.println(1000000);
	int flag=1;Start st=new Start();
while(flag==1)
{
	System.out.println("1->create; 2->read; 3->delete");
	switch(sc.nextInt())
	{
	 case 1:
	 {	
	 String x=sc.next();int y=sc.nextInt();int z=sc.nextInt();
	 
	 
	 if((st.create(x,y,z,file))==1)
		 {keY.add(x);value.add(y);}
	 break;
	 }
	 case 2:
	 {
		 String x=sc.next();
		 st.read(x,keY,value);
		break; 
	 }
	 case 3:
	 {
		 String x=sc.next();
		 if(keY.contains(x))
		 {
		 int index=keY.indexOf(x);
		 String pass=""+keY.get(index)+" : "+value.get(index);
		 st.removeLineFromFile(file.getAbsolutePath(),pass);
		 keY.remove(index);value.remove(index);
		 }
		 else
		 {
		 System.out.println("KEY not found!!"); 
		 }
		break; 
	 }
	 default:
	 {
		 flag=0;
	 }
	}
	//System.out.println("DONE");
	//System.out.println("Absolute path:"+file.getAbsolutePath());
}
System.out.println("DONE");
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	} 
}
