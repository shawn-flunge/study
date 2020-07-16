package exam;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Calculator calc = new Calculator();
//		//calc = new Calculator();				
//		calc.setOperand(10, 2);
//		System.out.println(calc.getOp1() + "," + calc.getOp2());
//		//calc.operand1=10;
//		//calc.operand2=2;
		
		
//		calc.operator="더하기";
//		
//		if(calc.operator == "더하기") {
//			System.out.println(calc.add());
//		}
//		
//		calc.operator="빼기";
//		if(calc.operator == "빼기") {
//			System.out.println(calc.subtract());
//		}
//		
//		calc.operator="곱하기";
//		if(calc.operator == "곱하기") {
//			System.out.println(calc.multiply());
//		}
//		
//		calc.operator="나누기";
//		if(calc.operator == "나누기") {
//			System.out.println(calc.divide());
//		}
		
		
		ExpandedCalc eCalc = new ExpandedCalc();
		
		eCalc.setOperand(8, 2);
		
		System.out.println(eCalc.add());
		System.out.println(eCalc.RShift(1));
		
		firstapp fa = new firstapp();

	}

}


