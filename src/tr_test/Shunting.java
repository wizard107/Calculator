package tr_test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Shunting {
	String input;
	String output = "";
	//Queue<String>outqueue = new LinkedList<String>();	//outputqueue
	Stack<String>opstack = new Stack<>();			//operatorstack
	public void UserInput(String input) {
		this.input = input;
	}
	public int Precedence(String precedence) {
		switch(precedence) {
		case "(" : return 0;
		case ")" : return 1;
		case "+" : return 2;
		case "-" : return 2;
		case "x" : return 3;
		case "/" : return 3;
		case "^" : return 4;
		default: return 0;
		}
		
	}
	public String Conversion() {
		while(input.length()>0) {
			String input_0 = Character.toString(input.charAt(0));
			if(Character.isDigit(input.charAt(0))) {
				//outqueue.add(Character.toString(input.charAt(0)));
				output += input_0;
				System.out.println(output);
			}
			else {
				int precedence = Precedence(input_0);
				if(opstack.isEmpty()) opstack.push(input_0);
				else if(precedence==4 && Precedence(opstack.peek())==4){	//if pow follows pow
					System.out.println("Two power Operators"); //I dont know how it works for the power operator
				}
				else if(precedence == 0) opstack.push(input_0);
				else if(precedence == 1) {
					while(opstack.peek()!="(") {
						output += opstack.pop();	//Pop everything till (
					}
					//Discard paranthesis, because not needed
				}
				else{
					System.out.println(opstack.peek());
					while(precedence<=Precedence(opstack.peek())) {	//while inputpred is <= stackpred pop stack
						output+=opstack.pop();
						if(opstack.isEmpty()) break;
					}
					opstack.push(input_0);
					
				}
			}
			input = input.substring(1);
			System.out.println("Hello");
		}
		while(!opstack.isEmpty()) {
			output+=opstack.pop();
		}
		
		return output;
	}
}
