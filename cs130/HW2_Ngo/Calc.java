// Calculator program that accepts input like:  123+456=
// Supports addition subtraction and clear display

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calc extends JFrame implements ActionListener
{
	private JTextField display;
	private String operand1 = "";
	private String operand2 = "";
	private String operation;
	
	public Calc()
	{
		Container c = this.getContentPane();
		c.setLayout( new BorderLayout() );
		c.add( "North", display = new JTextField() );
		JPanel keys = new JPanel();
		keys.setLayout( new GridLayout( 6, 3) );
		JButton temp;
		for( int i = 1; i <=9; i++ )
		{
			keys.add( temp = new JButton(""+i) );
			temp.addActionListener( this );
		}
		keys.add( temp = new JButton( "0" ));
			temp.addActionListener( this );
		keys.add( temp = new JButton( "+" ));
			temp.addActionListener( this );
		keys.add( temp = new JButton( "-" ));
			temp.addActionListener( this );
        keys.add( temp = new JButton( "C" ));
            temp.addActionListener( this );
		keys.add( temp = new JButton( "*" ));
            temp.addActionListener( this );
		keys.add( temp = new JButton( "/" ));
            temp.addActionListener( this );
		keys.add( temp = new JButton( "" ));
			temp.addActionListener( this );
		keys.add( temp = new JButton( "" ));
			temp.addActionListener( this );
		keys.add( temp = new JButton( "=" ));
			temp.addActionListener( this );
		c.add( "Center", keys );

		// ends program when window close icon is pressed
        addWindowListener(new WindowAdapter()
        {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
	}
    
    public enum Status 
    {
        START, READINGOP1, READINGOP2, OPERATORREAD
    }

	private Status status = Status.START;

	public void actionPerformed( ActionEvent ae )
	{
		JButton b = (JButton) ae.getSource();
		String textOnButton = b.getText();
		boolean isDigit = "1234567890".indexOf( textOnButton ) != -1; // if buttonpressed is a digit
		if (status == Status.START)
		{
			if (isDigit)
			{
				operand1 = textOnButton;
				display.setText( textOnButton );
				status = Status.READINGOP1;
			}
			else
			{
				operand1 = "";
				operand2 = "";
				display.setText("");
				status = Status.START;
			}
		}
		else if (status == Status.READINGOP1)
		{
			if (isDigit)
			{
				operand1 += textOnButton;
				display.setText( display.getText() + textOnButton );
			}
			else if ( textOnButton.equals("+") || textOnButton.equals("-") ||  textOnButton.equals("*") || textOnButton.equals("/"))
			{
				operation = textOnButton;
				status = Status.OPERATORREAD;
			}
			else if ( textOnButton.equals("C") )
			{
				display.setText("");
				status = Status.START;
			}
			else // =
			{
				display.setText("Start Over");
				status = Status.START;
			}
		}
		else if (status == Status.OPERATORREAD)
		{
			if (isDigit)
			{
				operand2 = textOnButton;
				display.setText( textOnButton );
				status = Status.READINGOP2; 
			}
			else if ( textOnButton.equals("C") )
			{
				display.setText("");
				status = Status.START;
			}
			else // +, -, =
			{
				display.setText("Start Over");
				status = Status.START;
			}
		}
		else if (status == Status.READINGOP2)
		{
			if (isDigit)
			{
				operand2 += textOnButton;
				display.setText( display.getText() + textOnButton );
			}
			else if ( textOnButton.equals("=") )
			{
				if ( operation.equals("+") )
				{
					int result = Integer.parseInt( operand1 ) + Integer.parseInt( operand2 );
					display.setText(""+result);
				}
				else if ( operation.equals("-") )
				{
					int result = Integer.parseInt( operand1 ) - Integer.parseInt( operand2 );
					display.setText(""+result);
                }
                else if(operation.equals("*"))
                {
                    int result = Integer.parseInt( operand1 ) * Integer.parseInt( operand2 );
					display.setText(""+result);
                }
                else if(operation.equals("/"))
                {
                    int result = Integer.parseInt( operand1 ) / Integer.parseInt( operand2 );
					display.setText(""+result);
                }
				status = Status.START; 
			}
			else if ( textOnButton.equals("C") )
			{
				display.setText("");
				status = Status.START; 
			}
			else // +, -
			{
				display.setText("Start Over");
				status = Status.START; 
			}
		}
	}
	
	// driver program
	
	public static void main( String args[] )
	{
		Calc c = new Calc();
		c.setSize( 150, 300 );
		c.setVisible( true );
	}
}