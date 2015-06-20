

public class TesteDriver {

	public static void main(String[] args) {

		try {
			
			System.out.println(Class.forName("org.postgresql.Driver"));
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}