/**
 * 
 */
package tr_test;

/**
 * @author User
 *
 */
public class GUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shunting one = new Shunting();
		//one.UserInput("3/(4-2)+2*5");
		one.UserInput("1000/1000");
		//String eins = "Hello";
		//eins = eins.substring(1);
		String input = one.Conversion();
		System.out.println(input);
		ReversePN two = new ReversePN();
		double result = two.calculate(input);
		//System.out.println((double)3/4);
		System.out.println("Ergebnis: "+result);
		//System.out.println(eins);
	}

}
