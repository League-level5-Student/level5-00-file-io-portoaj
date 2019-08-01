package _01_File_Recorder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Type something to add to a file");
		String str = scnr.next();
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/write2.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
