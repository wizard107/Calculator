/**
 * 
 */
package tr_test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author User
 *
 */
public class GUI {
	private JFrame frame;
	private JLabel label;
	private JLabel empty;
	private JPanel panel;
	private String calc = "";
	public GUI(){
		frame = new JFrame();
		label = new JLabel("Calculation: ");
		empty = new JLabel(" ");
		JButton zeroButton = new JButton(new AbstractAction("0") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="0";
				label.setText("Calculation " + calc);
			}
		});
		JButton oneButton = new JButton(new AbstractAction("1") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="1";
				label.setText("Calculation " + calc);
			}
		});
		JButton twoButton = new JButton(new AbstractAction("2") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="2";
				label.setText("Calculation " + calc);
			}
		});
		JButton threeButton = new JButton(new AbstractAction("3") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="3";
				label.setText("Calculation " + calc);
			}
		});
		JButton fourButton = new JButton(new AbstractAction("4") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="4";
				label.setText("Calculation " + calc);
			}
		});
		JButton fiveButton = new JButton(new AbstractAction("5") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="5";
				label.setText("Calculation " + calc);
			}
		});
		JButton sixButton = new JButton(new AbstractAction("6") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="6";
				label.setText("Calculation " + calc);
			}
		});
		JButton sevenButton = new JButton(new AbstractAction("7") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="7";
				label.setText("Calculation " + calc);
			}
		});
		JButton eightButton = new JButton(new AbstractAction("8") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="8";
				label.setText("Calculation " + calc);
			}
		});
		JButton nineButton = new JButton(new AbstractAction("9") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="9";
				label.setText("Calculation " + calc);
			}
		});
		JButton plusButton = new JButton(new AbstractAction("+") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="+";
				label.setText("Calculation " + calc);
			}
		});
		JButton minusButton = new JButton(new AbstractAction("-") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="-";
				label.setText("Calculation " + calc);
			}
		});
		JButton divButton = new JButton(new AbstractAction("/") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="/";
				label.setText("Calculation " + calc);
			}
		});
		JButton multButton = new JButton(new AbstractAction("*") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc+="*";
				label.setText("Calculation " + calc);
			}
		});
		JButton clearButton = new JButton(new AbstractAction("CLEAR") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc = "";
				label.setText("Calculation " + calc);
			}
		});
		JButton parLButton = new JButton(new AbstractAction("(") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc += "(";
				label.setText("Calculation " + calc);
			}
		});
		JButton parRButton = new JButton(new AbstractAction(")") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc += ")";
				label.setText("Calculation " + calc);
			}
		});
		JButton delButton = new JButton(new AbstractAction("DEL") {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc = calc.substring(0,calc.length() -1);
				label.setText("Calculation " + calc);
			}
		});
		JButton resultButton = new JButton(new AbstractAction("=") {
			@Override
			public void actionPerformed(ActionEvent e) {
				Shunting one = new Shunting();
				one.UserInput(calc);
				calc = one.Conversion();				
				ReversePN two = new ReversePN();
				double result = two.calculate(calc);
				label.setText("Calculation " + result);
				calc = "";
			}
		});
		delButton.setBackground(Color.ORANGE);
		delButton.setForeground(Color.BLACK);
		clearButton.setBackground(Color.ORANGE);
		resultButton.setBackground(Color.GREEN);
		parLButton.setBackground(Color.yellow);
		parRButton.setBackground(Color.YELLOW);
		plusButton.setBackground(Color.lightGray);
		minusButton.setBackground(Color.lightGray);
		multButton.setBackground(Color.lightGray);
		divButton.setBackground(Color.lightGray);
		JPanel panel2 = new JPanel();
		panel2.add(label);
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(40,30,10,30));
		panel.setLayout(new GridLayout(0,5));	//top left bottom right
		panel.add(oneButton);
		panel.add(twoButton);
		panel.add(threeButton);
		panel.add(plusButton);
		panel.add(multButton);
		panel.add(fourButton);
		panel.add(fiveButton);
		panel.add(sixButton);
		panel.add(minusButton);
		panel.add(divButton);
		panel.add(sevenButton);
		panel.add(eightButton);
		panel.add(nineButton);
		panel.add(clearButton);
		panel.add(resultButton);
		panel.add(zeroButton);
		panel.add(parLButton);
		panel.add(parRButton);
		panel.add(delButton);
		//frame.add(panel, BorderLayout.CENTER);
		//panel.setLayout(new GridLayout(0,2,0,8));
		//panel.add(label);
		frame.add(panel2,BorderLayout.PAGE_START);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Shunting one = new Shunting();
		one.UserInput("3/(4-2)+2*5");
		//one.UserInput("1000/1000");
		//String eins = "Hello";
		//eins = eins.substring(1);
		String input = one.Conversion();
		System.out.println(input);
		ReversePN two = new ReversePN();
		
		double result = two.calculate(input);
		//System.out.println((double)3/4);
		System.out.println("Ergebnis: "+result);
		//System.out.println(eins);
		 */
		new GUI();
		
	}

}
