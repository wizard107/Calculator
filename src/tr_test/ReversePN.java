package tr_test;

import java.util.Stack;

public class ReversePN {
	Stack<Double>stack = new Stack<>();
	double output;
	int count = 0;
	/*
	 * Calculation of input string with reverse polish noation: scans string for number then pushes num to stack
	 * If operations follows first two stackpositions will be calculated and returned to stack
	 */
	public double calculate(String input) {
		while(input.length()>0) {
			String input_0 = Character.toString(input.charAt(0));
			if(Character.isDigit(input.charAt(0))) {
				input = input.substring(1);
				String input_next = Character.toString(input.charAt(0));
				while(!input_next.contains("$")) {
					input_0 += input_next;
					input = input.substring(1);
					input_next = Character.toString(input.charAt(0));
				}
				double currnum = Double.parseDouble(input_0);
				stack.push(currnum);
			}
			else {
				double y = stack.pop();
				double x = stack.pop();
				switch(input_0) {
				case "-": stack.push(x-y);break;
				case "+": stack.push(x+y);break;
				case "*": stack.push(x*y);break;
				case "/": stack.push(x/y);break;
				case "^": stack.push(Math.pow(x,y));break;
				//default: System.out.println("Error at result calculation");
				//System.out.println(++count);
				}
			}
			System.out.println(stack.peek());
			input = input.substring(1);
			System.out.println("Length of String: " + input.length());
		}
		output = stack.pop();
		return output;
	}
}
