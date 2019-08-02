package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList extends JPanel implements ActionListener{
	ArrayList<String> tasks;
	JFrame frame;
	JPanel panel;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
	}
	public ToDoList()
	{
		tasks = new ArrayList<String>();
		frame = new JFrame("To-Do List");
		panel = this;
		add = new JButton("Add Task");
		view = new JButton("View Tasks");
		remove = new JButton("Remove Task");
		save = new JButton("Save List");
		load = new JButton("Load List");
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		switch(button)
		{
			case "Add Task":
				System.out.println("add");
				tasks.add(JOptionPane.showInputDialog("What task would you like to add?"));
				break;
			case "View Tasks":
				JOptionPane.showMessageDialog(frame, tasks.toArray());
				break;
			case "Remove Task":
				int taskClicked = JOptionPane.showOptionDialog(frame, "Select a task to remove", "Remove task", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tasks.toArray(), tasks.get(0));
				tasks.remove(taskClicked);
				break;
			case "Save List":
				try {
					FileWriter fw = new FileWriter("src/_03_To_Do_List/save.txt");
					for(int i = 0; i < tasks.size(); i++)
					{
						if(i != tasks.size() - 1)
							fw.write(tasks.get(i) + "\n");
						else
							fw.write(tasks.get(i));
					}
						
					fw.close();
				} 
				catch (IOException e1) {
					System.out.println("Hit an IOexception with the filewriter");
					e1.printStackTrace();
				}
				break;
			case "Load List":
				try {
					BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/save.txt"));
					String s;
					tasks.clear();
					while((s = br.readLine()) != null)
					{
						tasks.add(s);
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			default:
				System.out.println("Switch is broken");
				break;
		}
		
	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
}
