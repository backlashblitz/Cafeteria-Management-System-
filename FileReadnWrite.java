

import java.lang.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.*;


public class FileReadnWrite
{
	private File f1;					//to create a File
	private FileWriter w;				//to write in a file
	private FileReader r;				//to read from a file
	private BufferedReader br;			//to read file content
	Scanner s = new Scanner(System.in);
	boolean t=false;
	String fileName = "C:\\Users\\ELECTRO2517\\Desktop\\JAVA project\\Cafeteria management\\StudentInformation.txt";


	public void createAccount(Student stu){
		try{
			FileWriter fw = new FileWriter(fileName,true);
			BufferedWriter writer = new BufferedWriter(fw);
			System.out.print("Enter Student Name: ");
			String name = s.next();
			System.out.print("Enter Student ID: ");
			String id = s.next();
			System.out.print("Create A Password: ");
			String p = s.next();
			stu.setId(id);
			stu.setName(name);
			stu.setPassword(p);
			stu.setBalance(2500);
			writer.write(stu.getName()+","+stu.getPassword()+","+stu.getId());
			writer.newLine();
			System.out.println("Account Created Successfully.");
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public boolean login(String username,String password){
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fr);
			String temp;
			String[] info;
			boolean t1=false;
			while((temp=reader.readLine())!=null) {
				info = temp.split(",");

				//info[0] = username, info[1] = password
				if(info[0].equals(username) && info[1].equals(password)){
					System.out.println("Login Successful");
					this.t=true;
					t1=true;
				}
			}
			if(t1==false){
				System.out.println("Invalid Username or password\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public void writeInFile(String s1,Student s)
	{
		try							//we need to write the whole thing in try-catch for Checked Exceptions (compile time)
		{
			f1= new File("History.txt");
			f1.createNewFile();				//If the file does not exists, creates and opens the file, else, just opens the file
			w= new FileWriter(f1, true);			//creating the writer object to write in the file
			w.write(s+"\r"+"\n");				//writing a string s in the file. the "\r" and "\n" has been concat to go to a newline
			w.flush();						//After writing, we need to flush to indicate that we have completed writing
			w.close();						//After flushing, we need to close the file to save our writing
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public void readFromFile()
	{
		try							//we need to write the whole thing in try-catch for Checked Exceptions (compile time)
		{
			f1= new File("History.txt");
			r= new FileReader(f1);				//creating the reader object to read from a file.
			br = new BufferedReader(r);			//creating the BufferedReader object using the reader object to read the file content.
			String text="", temp;				//declaring two string variables to read the file content and storing them.
			while((temp=br.readLine())!=null)		//reading one line from the file, storing it in the variable temp and checking whether it is null or not
			{							//It will be null at the end of reading from the file
				text=text+temp+"\n"+"\r";			//storing the temp string in text by concating it with text and "\n" and "\r" is used to go to a newline
			}
			System.out.println(text);			//printing the whole string in console
			r.close();						//closing the file
		}

		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	public void termsCondition(){
		try {
			File r1 = new File("Terms & Conditions.txt");
			Scanner termReader = new Scanner(r1);
			while (termReader.hasNextLine()) {
				String data = termReader.nextLine();
				System.out.println(data);
			}
			termReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
