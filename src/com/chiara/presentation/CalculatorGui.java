package com.chiara.presentation;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.chiara.calculator.CalculatorLogic;

public class CalculatorGui implements ActionListener {
	private JFrame frame;
    private JTextField textfield;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[9];
    private JPanel panel;
    private CalculatorLogic calculatorLogic;
    double num1=0,num2=0;
	char operator;
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton;
	
	
public CalculatorGui() {

	Font myFont = new Font("Roboto",Font.BOLD,30);
	frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 580);
    frame.setLayout(null);

    textfield = new JTextField();
    textfield.setBounds(50, 35, 400, 50);
    textfield.setFont(new Font("Roboto", Font.BOLD, 30));
    textfield.setEditable(false);
    
    addButton = new JButton("+");
	subButton = new JButton("-");
	mulButton = new JButton("*");
	divButton = new JButton("/");
	decButton = new JButton(".");
	equButton = new JButton("=");
    delButton = new JButton("CE");
    clrButton = new JButton("C");

	
	functionButtons[0] = addButton;
	functionButtons[1] = subButton;
	functionButtons[2] = mulButton;
	functionButtons[3] = divButton;
	functionButtons[4] = decButton;
	functionButtons[5] = equButton;
	functionButtons[6] = delButton;
	functionButtons[7] = clrButton;

	
	for(int i =0;i<8;i++) {
		functionButtons[i].addActionListener(this);
		functionButtons[i].setFont(myFont);
		functionButtons[i].setFocusable(false);
	}
	
	for(int i =0;i<10;i++) {
		numberButtons[i] = new JButton(String.valueOf(i));
		numberButtons[i].addActionListener(this);
		numberButtons[i].setFont(myFont);
		numberButtons[i].setFocusable(false);
	}
	

	delButton.setBounds(250,430,200,50);
	clrButton.setBounds(50,430,200,50);
	
	
	panel = new JPanel();
	panel.setBounds(50, 100, 400, 300);
	panel.setLayout(new GridLayout(4,4,30,10));

	panel.add(numberButtons[1]);
	panel.add(numberButtons[2]);
	panel.add(numberButtons[3]);
	panel.add(addButton);
	panel.add(numberButtons[4]);
	panel.add(numberButtons[5]);
	panel.add(numberButtons[6]);
	panel.add(subButton);
	panel.add(numberButtons[7]);
	panel.add(numberButtons[8]);
	panel.add(numberButtons[9]);
	panel.add(mulButton);
	panel.add(decButton);
	panel.add(numberButtons[0]);
	panel.add(equButton);
	panel.add(divButton);
	
	frame.add(panel);
    frame.add(delButton);
	frame.add(clrButton);
    frame.add(textfield);
	frame.setVisible(true);

}
	



@Override
public void actionPerformed(ActionEvent e) {
	 calculatorLogic = new CalculatorLogic();
		//when the user click on a button, the button clicked display the text on the frame
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				//get text and turn the data value given in string
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
			}
		}
		
		if(e.getSource() == decButton) {
	        textfield.setText(textfield.getText().concat("."));
	    }
	    if(e.getSource() == addButton || e.getSource() == subButton || 
	       e.getSource() == mulButton || e.getSource() == divButton) {
	        // Set num1 to the current value in the text field
	        num1 = Double.parseDouble(textfield.getText());
	        // Set the operator based on the button clicked
	        if(e.getSource() == addButton) {
	            operator = '+';
	        } else if(e.getSource() == subButton) {
	            operator = '-';
	        } else if(e.getSource() == mulButton) {
	            operator = '*';
	        } else if(e.getSource() == divButton) {
	            operator = '/';
	        }
	        // Clear the text field for next input
	       textfield.setText("");
	    }

	    if(e.getSource() == equButton) {
	        // Get num2 from the current value in the text field
	        num2 = Double.parseDouble(textfield.getText());
	        // Calculate the result using CalculatorLogic
	        double result = calculatorLogic.calculate(num1, num2, operator);
	        // Check if the result is an integer
	        if (result % 1 == 0) {
	            // If it's an integer, convert it to int and display
	            textfield.setText(String.valueOf((int) result));
	        } else {
	            textfield.setText(String.valueOf(result));
	       }
	      
	    }
	    
	    //clean entire number
	    if(e.getSource() == clrButton) {
	    	textfield.setText("");
	    }
	    if (e.getSource() == delButton) {
	    	//store the string displayed in a temporary string
	        String stringTemp = textfield.getText();
	        if (stringTemp.length() > 0) {
	        	//remove the last character with substring (from second to last char)
	            stringTemp = stringTemp.substring(0, stringTemp.length() - 1);
	            textfield.setText(stringTemp);
	        }
	    }
	    	
	    
	 }
	

	
}
