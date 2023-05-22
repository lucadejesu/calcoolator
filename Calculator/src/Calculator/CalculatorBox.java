package Calculator;
import javax.imageio.ImageIO;

import java.awt.event.*;
import javax.swing.*;



import java.awt.*;

public class CalculatorBox extends JFrame
{
	// Change the number of rows here
	public static int num_rows = 5;
	// Number of spaces in output
	public static int output_size = 16;

	// Buttons
	CalculatorButton addButton, subButton, divButton,multButton, clearButton, deleteButton, equalsButton, dotButton;
	
	// Array to hold the number buttons
	CalculatorButton numButton[];
	
	// String variables to hold inputs and operator used
	String previous, current, operator;
	
	// Field to display the output
	JTextField output;
	
	// Action listeners to attach to the buttons
	NumberHandler numHandler = new NumberHandler();
	OtherBtnHandler otherHandler = new OtherBtnHandler();
	OperatorHandler opHandler = new OperatorHandler();
	
	// Constructor
	public CalculatorBox()
	{
		// Superclass = JFrame. Set the JFrame title
		super("Cal-cool-ator");
		super.setBackground(Color.cyan);
		
		// Default string is null, we want to add blank space if no string provided
		current = "";
		previous = "";
		
		// Create a JPanel to hold components within the JFrame
		JPanel mainPanel = new JPanel();
		
		// We will align the buttons in rows on a box layout for clean display. Need 5 at least
		JPanel rows[] = new JPanel[num_rows];
		
		Color background = new Color(160,47,17);
		for(int i = 0; i < num_rows; i++)
		{
			rows[i] = new JPanel();
			rows[i].setBackground(background);
		}
		
		// Initialize the operation buttons
		addButton = new CalculatorButton("/buttons/plus.png");
		addButton.addActionListener(opHandler);
		
		subButton = new CalculatorButton("/buttons/minus.png");
		subButton.addActionListener(opHandler);
		
		divButton = new CalculatorButton("/buttons/divide.png");
		divButton.addActionListener(opHandler);
		
		multButton = new CalculatorButton("/buttons/multiply.png");
		multButton.addActionListener(opHandler);
		
		clearButton = new CalculatorButton("/buttons/clear.png");
		clearButton.addActionListener(otherHandler);
		
		deleteButton = new CalculatorButton("/buttons/delete.png");
		deleteButton.addActionListener(otherHandler);
		
		equalsButton = new CalculatorButton("/buttons/equals.png");
		equalsButton.addActionListener(otherHandler);
		
		dotButton = new CalculatorButton("/buttons/dot.png");
		dotButton.addActionListener(numHandler);
		
		// Initialize the output field
		output = new JTextField(output_size);
		output.setBackground(new Color(255,220,177));
		
		
		// Initialize the number buttons
		numButton = new CalculatorButton[11];
		
		numButton[0] = new CalculatorButton("/buttons/one.png");
		numButton[0].setNum(1);
		numButton[0].addActionListener(numHandler);
		
		numButton[1] = new CalculatorButton("/buttons/two.png");
		numButton[1].setNum(2);
		numButton[1].addActionListener(numHandler);
		
		numButton[2] = new CalculatorButton("/buttons/three.png");
		numButton[2].setNum(3);
		numButton[2].addActionListener(numHandler);
	
		numButton[3] = new CalculatorButton("/buttons/four.png");
		numButton[3].setNum(4);
		numButton[3].addActionListener(numHandler);
		
		numButton[4] = new CalculatorButton("/buttons/five.png");
		numButton[4].setNum(5);
		numButton[4].addActionListener(numHandler);
		
		numButton[5] = new CalculatorButton("/buttons/six.png");
		numButton[5].setNum(6);
		numButton[5].addActionListener(numHandler);
		
		numButton[6] = new CalculatorButton("/buttons/seven.png");
		numButton[6].setNum(7);
		numButton[6].addActionListener(numHandler);
		
		numButton[7] = new CalculatorButton("/buttons/eight.png");
		numButton[7].setNum(8);
		numButton[7].addActionListener(numHandler);
		
		numButton[8] = new CalculatorButton("/buttons/nine.png");
		numButton[8].setNum(9);
		numButton[8].addActionListener(numHandler);
		
		numButton[9] = new CalculatorButton("/buttons/zero.png");
		numButton[9].setNum(0);
		numButton[9].addActionListener(numHandler);
		
		// Last button is the decimal
		numButton[10] = dotButton;
		numButton[10].addActionListener(numHandler);
		numButton[10].setNum(".");
		
		
		// Style the output display
		// Note: Dimension(width, height)
		output.setMaximumSize(new Dimension(185, 40));
		output.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		output.setDisabledTextColor(new Color(0,0,0));
		output.setSelectedTextColor(Color.BLACK);
		output.setForeground(Color.BLACK);
		output.setMargin(new Insets(0, 5, 0, 0));
		output.setText("blank");
		
		
		output.setText("0");
		
		// Set each row to a box layout
		for(int i = 0; i < num_rows; i++)
		{
			rows[i].setLayout(new BoxLayout(rows[i], BoxLayout.LINE_AXIS));
		}
		
		// Add the components (buttons) to these rows (sub-panels)
		// 1st row:
		rows[0].add(Box.createHorizontalGlue()); // Horizontal glue forces the buttons towards the horizontal edge
		rows[0].add(clearButton);
		rows[0].add(deleteButton);
		
		// 2nd row:
		rows[1].add(numButton[7]);
		rows[1].add(numButton[8]);
		rows[1].add(numButton[9]);
		rows[1].add(multButton);
		
		// 3rd row:
		rows[2].add(numButton[4]);
		rows[2].add(numButton[5]);
		rows[2].add(numButton[6]);
		rows[2].add(addButton);
				
		// 4th row:
		rows[3].add(numButton[1]);
		rows[3].add(numButton[2]);
		rows[3].add(numButton[3]);
		rows[3].add(subButton);
		
		// 5th row:
		rows[4].add(dotButton);
		rows[4].add(numButton[0]);
		rows[4].add(equalsButton);
		rows[4].add(divButton);
		
		// Create a box layout object to hold the buttons
		BoxLayout box_layout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
		// Set the layout for the main panel and add the subpanels (rows)
		
		
		mainPanel.setBackground(Color.cyan);
		mainPanel.setLayout(box_layout);
		mainPanel.add(output);
		mainPanel.add(Box.createRigidArea(new Dimension(0,5)));
		mainPanel.setBackground(background);
		
		
		
		for(int i = 0; i < num_rows; i++)
		{
			mainPanel.add(rows[i]);
		}
		
		// In order to show the main panel:
		this.getContentPane().setBackground(Color.black);
		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.setSize(448, 375);
	}
	
	// This displays integers correctly, without a .0 
	public void processOutputNumber()
	{
		if (current.length() > 0)
		{
			// Split the string by the .
			// Example 45.667 -> 45 is the integer part, .667 is the decimal part
			String integerPart = current.split("\\.")[0];
			String decimalPart = current.split("\\.")[1];
			
			if(decimalPart.equals("0"))
			{
				current = integerPart;
			}
		}
	}
	
	// Methods for the calculator
	public void calculate()
	{
		// If the previous or current output has a length less than 0, its empty and dont calculate
		if(previous.length() < 1 || current.length() < 1)
		{
			return;
		}
		
		double result = 0.0; 
		double num1 = Double.parseDouble(previous);
		double num2 = Double.parseDouble(current);
		
		switch(operator)
		{
			case "*":
				result = num1 * num2;
				break;
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1-num2;
				break;
			case "/":
				result = num1 / num2;
				break;
			default:
				break;
		}
		current = String.valueOf(result);
		operator = null;
		previous = "";
		
		// Display integers and strings correctly 
		processOutputNumber();
		
	}
	
	public void selectOperator(String operator)
	{
		// No number entered: keep the operator and return
		if(current.isEmpty())
		{
			this.operator = operator;
			return;
		}
		// If numbers are on the output
		if(!previous.isEmpty())
		{
			calculate();
		}
		
		// Old operator = new operator
		// Previous number is the current and current is now blank unless a new
		// number is entered
		this.operator = operator;
		previous = current;
		current = "";
	}
	
	public void appendToOutput(String num)
	{
		// If we are appending a dot but already have one, then don't append another
		if(num.equals(".") && current.contains("."))
		{
			return;
		}
		current += num;
	}
	
	public void updateOutput()
	{
		output.setText(current);
	}
	
	public void clear()
	{
		// Reset the previous and current operands
		current = "";
		previous = "";
		operator = null;
		
	}
	
	public void delete()
	{
		if(current.length() > 0)
		{
			current = current.substring(0, current.length() - 1);
		}
		
	}
	
	
	
	
	// Private inner classes to handle events and actions

	// Event handler #1: number buttons
	private class NumberHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			CalculatorButton selected = (CalculatorButton)e.getSource();
			
			// Check what number the button clicked is
			for (CalculatorButton btn : numButton)
			{
				if(selected == btn)
				{
					appendToOutput(btn.getNum());
					updateOutput();
				}
			}
			
		}

	}
	
	// Event handler #2: operator buttons
	private class OperatorHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			CalculatorButton selected = (CalculatorButton)e.getSource();
			
			// Check which operator was selected
			if (selected == multButton)
			{
				selectOperator("*");
			}
			else if (selected == addButton)
			{
				selectOperator("+");
			}
			else if (selected == divButton)
			{
				selectOperator("/");
			}
			else if (selected == subButton)
			{
				selectOperator("-");
			}
			
		}
		
	}
	
	// Handles delete, clear, and equals
	private class OtherBtnHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			CalculatorButton selected = (CalculatorButton)e.getSource();
			
			if(selected == deleteButton)
			{
				delete();
			}
			else if (selected == clearButton)
			{
				clear();
			}
			else if (selected == equalsButton)
			{
				calculate();
			}
			
			updateOutput();
			
		}
	}
	
	
	
}











