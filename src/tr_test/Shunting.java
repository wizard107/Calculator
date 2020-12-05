package tr_test;


import java.util.Stack;

public class Shunting {
	String input;
	String output = "";
	//Queue<String>outqueue = new LinkedList<String>();	//outputqueue
	Stack<String>opstack = new Stack<>();			//operatorstack
	public void UserInput(String input) {
		String built_input = "";
		//this.input = input;
		for(int i=0;i<input.length();i++) {
			String input_0 = Character.toString(input.charAt(i));
			if(Character.isDigit(input.charAt(i))) {
				built_input += input_0;
			}
			else {
				if(Character.isDigit(built_input.charAt(built_input.length()-1))) built_input+="$";
				built_input += input_0;
			}
		}
		if(Character.isDigit(built_input.charAt(built_input.length()-1))) built_input+="$";
		System.out.println(built_input);
		this.input = built_input;
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
			System.out.println("input0: " + input_0);
			if(Character.isDigit(input.charAt(0))) {
				//outqueue.add(Character.toString(input.charAt(0)));
				output += input_0;
				//System.out.println(output);
			}
			//input=="$" doesnt work
			else if(input_0.contains("$")) output+= "$";
			else {
				int precedence = Precedence(input_0);
				if(opstack.isEmpty()) opstack.push(input_0);
				else if(precedence==4 && Precedence(opstack.peek())==4){	//if pow follows pow
					System.out.println("Two power Operators"); //I dont know how it works for the power operator
				}
				else if(precedence == 0) opstack.push(input_0);
				else if(precedence == 1) {
					while(opstack.peek()!="(") {
						/*if(opstack.peek()=="(") { 
							opstack.pop();
							break;
						}*/
						output += opstack.pop();	//Pop everything till (
						if(opstack.isEmpty()) break;
					}
					//Discard paranthesis, because not needed
				}
				else{
					//System.out.println(opstack.peek());
					while(precedence<=Precedence(opstack.peek())) {	//while inputpred is <= stackpred pop stack
						output+=opstack.pop();
						if(opstack.isEmpty()) break;
					}
					opstack.push(input_0);
					
				}
			}
			input = input.substring(1);
			//System.out.println(output);
		}
		while(!opstack.isEmpty()) {
			output+=opstack.pop();
		}
		output = output.replace("(", "" );
		
		return output;
	}
}
