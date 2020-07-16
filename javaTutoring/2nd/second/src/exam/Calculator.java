package exam;

public class Calculator {
	
	private int operand1;
	private int operand2;
	String operator;
	
	public void setOperand(int a, int b) {
		operand1 = a;
		operand2 = b;
	}
	
	public int getOp1() {
		return operand1;
	}
	public int getOp2() {
		return operand2;
	}
	
	public Calculator() {
		System.out.println("Calculator°´Ã¼ »ı¼º");
	}
	
	public int add() {
		//do something;
		return operand1+operand2;
	}
	
	public int subtract() {
		//do something;
		int result;
		result = operand1-operand2;
		return result;
	}
	
	public int multiply() {
		return operand1*operand2;
	}
	
	public int divide() {
		return operand1/operand2;
	}
	
	
}
