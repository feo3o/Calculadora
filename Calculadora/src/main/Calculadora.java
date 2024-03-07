package main;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener{
	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, multiButton, divButton;
	JButton decButton, equalsButton, delButton, clearButton, negButton;
	JPanel panel;
	
	Font font = new Font("Roboto", Font.BOLD, 30);
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculadora(){
		Border border = BorderFactory.createLineBorder(Color.white, 2);
		Border border2 = BorderFactory.createLineBorder(new Color(53, 56, 57), 2);
		
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(85, 85, 85));
		
		textField = new JTextField();
		textField.setBounds(25, 25, 380, 50);
		textField.setFont(font);
		textField.setEditable(false);
		textField.setBackground(new Color(128, 128, 128));
		textField.setBorder(border);
		textField.setForeground(Color.white);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		multiButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equalsButton = new JButton("=");
		delButton = new JButton("Deletar");
		clearButton = new JButton("Limpar");
		negButton = new JButton("--");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = multiButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equalsButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clearButton;
		functionButtons[8] = negButton;
		
		for(int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(font);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBorder(border2);
			functionButtons[i].setBackground(new Color(172, 172, 172));
		}
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBorder(border);
			numberButtons[i].setBackground(new Color(192, 192, 192));
		}
		
		negButton.setBounds(15, 400, 100, 50);
		delButton.setBounds(120, 400, 150, 50);
		clearButton.setBounds(275, 400, 150, 50);
		
		panel = new JPanel();
		panel.setBounds(70, 85, 300, 300);
		panel.setLayout(new GridLayout(4, 4,10,10));
		panel.setBackground(new Color(105, 105, 105));
		
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
		panel.add(multiButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equalsButton);
		panel.add(divButton);
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(textField);
		frame.add(delButton);
		frame.add(clearButton);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculadora();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='+';
			textField.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='-';
			textField.setText("");
		}
		if(e.getSource()==multiButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='*';
			textField.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator ='/';
			textField.setText("");
		}
		if(e.getSource()==equalsButton) {
			num2=Double.parseDouble(textField.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource()==clearButton) {
			textField.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}			
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}
	}
}
