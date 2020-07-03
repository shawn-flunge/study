package exam;



public class main {

	static final String static_final_int ="static_final_string";
	static {
		String str ="static_str";
		System.out.println(str + "/////// " + static_final_int);
	}
	
	static class internal_class{
		
		public internal_class() {
			// TODO Auto-generated constructor stub
			System.out.println("abc »ý¼º");
		}
		
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		internal_class ic = new internal_class();
		
		System.out.println("hello world");
			
	}

	
}





