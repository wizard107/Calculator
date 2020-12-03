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
		one.UserInput("3+4+2");
		//String eins = "Hello";
		//eins = eins.substring(1);
		System.out.println(one.Conversion());
		//System.out.println(eins);
	}

}
