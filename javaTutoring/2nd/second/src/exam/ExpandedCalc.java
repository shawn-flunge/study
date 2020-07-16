package exam;

public class ExpandedCalc extends Calculator{
	
	public ExpandedCalc() {
		System.out.println("Calculator를 상속받은 expandedCalc객체 생성");
	}

	public int RShift(int x) {
		int result;		
		result = getOp1()>>x;	
		return result;
	}
	
}
