import java.io.*;
import java.util.Scanner;

class AddZeroException extends Exception {
	public AddZeroException(String message) {
		super(message);
	}
}
class SubtractZeroException extends Exception {
	public SubtractZeroException(String message) {
		super(message);
	}
}
class OutOfRangeException extends Exception {
	public OutOfRangeException(String message) {
		super(message);
	}
}


public class SimpleCalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String expr = in.nextLine();
		in.close();
		int a, b;
		if(expr.contains("+")) {
			String[] data = expr.split("\\+");
			a = Integer.parseInt(data[0]);
			b = Integer.parseInt(data[1]);
			try {
				print(plus(a, b));
			} catch (AddZeroException | OutOfRangeException e) {
				System.out.println(e.getMessage());
			}
		} else if(expr.contains("-")) {
			String[] data = expr.split("\\-");
			a = Integer.parseInt(data[0]);
			b = Integer.parseInt(data[1]);
			try {
				print(minus(a, b));
			} catch (SubtractZeroException | OutOfRangeException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static int plus(int a, int b) throws AddZeroException, OutOfRangeException {
		if (a == 0 || b == 0) {
			throw new AddZeroException("AddZeroException");
		}
		else if (a < 0 || a > 1000 || b < 0 || b > 1000) {
			throw new OutOfRangeException("OutOfRangeException");
		}
		else return a + b;
	}
	
	public static int minus(int a, int b) throws SubtractZeroException, OutOfRangeException {
		if (a == 0 || b == 0) {
			throw new SubtractZeroException("AddZeroException");
		}
		else if (a < 0 || a > 1000 || b < 0 || b > 1000) {
			throw new OutOfRangeException("OutOfRangeException");
		}
		else return a - b;
	}
	
	public static void print(int result) throws OutOfRangeException {
		if (result < 0 || result > 1000) {
			throw new OutOfRangeException("OutOfRangeException");
		}
		else System.out.println(result);
	}

}
