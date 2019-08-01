package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string to be encrypted");
		String str = scanner.next();
		char[]  chars = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			c++;
			chars[i] = c;
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/msg.txt", true);
			fw.write(chars);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
