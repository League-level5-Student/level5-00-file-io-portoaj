package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/msg.txt"));
			String s = "";
			while(br.readLine() != null)
				s += br.readLine();
			char [] chars = s.toCharArray();
			for(int i = 0; i < s.length(); i++)
			{
				chars[i]--;
			}
			JOptionPane.showMessageDialog(null, chars.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
