package Calculator;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CalculatorButton extends JButton
{
	public Image buttonIcon;
	
	// Change the icon size here
	private int icon_width = 96;
	private int icon_height = 48;
	
	private String num_equivalent;
	
	public Color background = new Color(160,47,17);
	
	// Default no-args constructor
	public CalculatorButton()
	{
		
	}
	
	
	public CalculatorButton(String btnPath)
	{
		// Set the image for the button, using the string passed as the .png path
		try
		{
			this.buttonIcon = ImageIO.read(getClass().getResource(btnPath));
			Image newIcon = this.buttonIcon.getScaledInstance(icon_width, icon_height, java.awt.Image.SCALE_SMOOTH);
			this.setIcon(new ImageIcon(newIcon));
			this.setBackground(background);
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		this.setBorderPainted(false);
		this.setOpaque(true);
	}
	
	// Setter for the string equivalent of a number
	public void setNum (int num)
	{
		this.num_equivalent = String.valueOf(num);
	}
	
	public void setNum(String num)
	{
		this.num_equivalent = num;
	}
	
	
	// Getter to access the private string number
	public String getNum()
	{
		return this.num_equivalent;
	}
	
}
