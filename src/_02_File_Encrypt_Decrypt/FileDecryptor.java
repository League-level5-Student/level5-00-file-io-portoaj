package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/msg.txt"));
			StringBuilder sb = new StringBuilder("");
			String s;
			while((s = br.readLine()) != null)
				sb.append(s);
			char [] chars = sb.toString().toCharArray();
			for(int i = 0; i < chars.length; i++)
			{
				chars[i]--;
				System.out.println(chars[i]);
			}
			System.out.println(chars.toString());
			JOptionPane.showMessageDialog(null, Arrays.toString(chars));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
