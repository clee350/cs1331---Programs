import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
/**
*Class: ToDoList	
*The framework of the ToDoList GUI.
*@author: Charles Lee	
*GTID: 902760050
*Course: CS 1331
*Teacher: Monica Sweat
*@version: 1.0 3/22/2013
*Assignment: Homework 10.
*Collaboration: I have worked on this with Ethan and Thomas.
*/
public class ToDoList extends JFrame{
	private JButton AddItem, RemoveItem;
	private JLabel show;
	private JTextField name;
	public static final int NUMBER_OF_CHAR =30;
	private JPanel panel;
	private String[] array;
	private int counter;
	/**
	*Constructor: The Constructor of the ToDoList
	*/
	public ToDoList(){
		super("To Do List Program:");
		array = new String[1];
		name = new JTextField(NUMBER_OF_CHAR);
		setLayout(new BorderLayout());
		JPanel foo = new JPanel();
		foo.setLayout(new GridLayout(3,2));
		show = new JLabel("To Do:");
		AddItem = new JButton("AddItem");
		AddItem.addActionListener(new AddEnterListener());
		RemoveItem = new JButton("RemoveItem");
		RemoveItem.addActionListener(new RemoveEnterListener());
		add(show, BorderLayout.CENTER);
		foo.add(name);
		foo.add(AddItem);
		foo.add(RemoveItem);
		
		add(foo, BorderLayout.SOUTH);
	}
	/**
	*Method: Add item from textfield to list by one
	*@param: The string from the textfield
	*/
	public void AddList(String args){
		if ((counter+1)>array.length){
			String[] temp = new String[array.length*2];
			for(int i =0;i<counter;i++){
				temp[i]=array[i];
			}
			array=temp;
		}
		array[counter++] = args;
	}
	/**
	*Method: removes an item  to list by one
	*@param: The string from the textfield
	*/
	public void RemoveList(){
		array[--counter]=null;
	}
	/** 
	*Method:.Adds when the add button is pressed
	*@param: ActionEvent e. 
	*/
	private class AddEnterListener implements ActionListener {
	/** 
	*Method:.Adds when the add button is pressed
	*@param: ActionEvent e. 
	*/
		public void actionPerformed(ActionEvent e){
			if(name.getText().equals("")){
				name.setText("You are adding nothing foo!");
			}
			else{
			AddList(name.getText());
			name.setText("");
			update();
			}
		}
	}
	/** 
	*Method: Removes an item when the remove button is pressed
	*@param: ActionEvent e. 
	*/
	private class RemoveEnterListener implements ActionListener{
	/**
	*Method: Removes an item when the remove button is pressed
	*@param: ActionEvent e. 
	*/
		public void actionPerformed(ActionEvent e){
			if(counter==0){
				name.setText("There is nothing!!");
			}
			else{
				RemoveList();
				update();
			}
		}
	}
	/** 
	*Method:Updates the textfield to show the total items.
	*/
	public void update(){
		show.setText(toString());
	}
	/** 
	*Method: stores the strings in an array.
	*@return: The string with everything added to list.
	*/
	public String toString(){
		String list="To do list:\n";
		for(int i=0; i<array.length; i++){
			if (array[i]!=null){
				list+=array[i]+"\n";
			}
		}
		return "<html><pre>"+list+"</pre></html>";
	}
}