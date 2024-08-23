package array;

public class FractionAdditionAndSubstraction {

    public static String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        if(expression.charAt(0)!='-'){
            expression = '+' + expression;
        }
        int i = 0;
        while (i < expression.length()){
            int sign = 1;
            if(expression.charAt(i) == '-') sign = -1;
            i++;

            int start = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            int currentNumerator = Integer.parseInt(expression.substring(start, i)) * sign;

            // Skip the '/'
            i++;

            // Extract the denominator
            start = i;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            int currentDenominator = Integer.parseInt(expression.substring(start, i));

            numerator = numerator * currentDenominator + currentNumerator * denominator;
            denominator = denominator * currentDenominator;

            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
        }
        return numerator + "/" + denominator;
    }

    private static int gcd(int n, int d) {
        if(d == 0) return n;
        return gcd(d, n % d);
    }



    public static void main(String[] args) {
        String s = "-1/2+1/2+1/3";
        System.out.println(fractionAddition(s));
    }
}
