// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3 = 5
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,7));  // 2 - 7 = -5
 		System.out.println(times(3,4));  // 3 * 4 =12
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
   		System.out.println(div(12,3));   // 12 / 3 = 4 
   		System.out.println(div(5,5));    // 5 / 5  = 1
   		System.out.println(div(25,7));   // 25 / 7 = 3
   		System.out.println(mod(25,7));   // 25 % 7 = 4
   		System.out.println(mod(120,6));  // 120 % 6 = 0   
   		System.out.println(sqrt(36)); //6
		System.out.println(sqrt(263169)); //513
   		System.out.println(sqrt(76123)); //275
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
    if (x2 > 0) {
        for (int i = 0; i < x2; i++) {
            x1++;
        }
    } else if (x2 < 0) {
        for (int i = 0; i < -x2; i++) {
            x1--;
        }
    }
    return x1;
}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		    if (x2 > 0) {
        for (int i = 0; i < x2; i++) {
            x1--; 
        }
    } else if (x2 < 0) {
        for (int i = 0; i < -x2; i++) {
            x1++; 
        }
    }
    return x1;
}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
    	boolean negative = false;

    if (x1 < 0) { 
		x1 = minus(0, x1); negative = !negative; 
	}
    if (x2 < 0) { 
		x2 = minus(0, x2); negative = !negative; 
	}

    for (int i = 0; i < x1; i++) {
        result = plus(result, x2);
    }

    if (negative){
		result = minus(0, result);
	} 
    return result;
}


	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		for(int i = 0; i < n; i++){
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;
    	boolean negative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);
		int a = x1;
    	if (a < 0) {
        	int temp = 0;
        	while (a < 0) {
            a = plus(a, 1);
            temp = plus(temp, 1);
        	}
        	a = temp;
    	}

    	int b = x2;
    	if (b < 0) {
        int temp = 0;
        while (b < 0) {
            b = plus(b, 1);
            temp = plus(temp, 1);
        }
        b = temp;
    }

    while (a >= b) {
        a = minus(a, b);
        result = plus(result, 1);
    }

    if (negative) {
        int temp = 0;
        while (result > 0) {
            temp = minus(temp, 1);
            result = minus(result, 1);
        }
        result = temp;
    }

    return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		    int divResult = div(x1, x2);
    int product = times(divResult, x2);
    int result = x1;
    while (product > 0) {
        result = minus(result, 1);
        product = minus(product, 1);
    }
    while (product < 0) {
        result = plus(result, 1);
        product = plus(product, 1);
    }
    return result;
}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
    int result = 0;
    for(int i = 1; times(i,i) <= x; i++){
        result = i;  
    }
    return result;
	}	  
}