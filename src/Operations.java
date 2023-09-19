// Author: Gines Moratalla
// Student ID: 38879816

public class Operations {

    // result variable (access on child class (Calculator))
    protected double result;

    // Different methods that perform operations for the calculator

    protected double factorial(double first) {                  // Custom method used exclusively for the factorial operation (x!)
        if(first == 0) {                                        //
            return 1;                                           //
        }                                                       //
        else                                                    //
            return first * factorial(first - 1);                // Uses recursion
    }
    protected double sum(double first, double second) {
        result = first + second;
        return result;
    }
    protected double sub(double first, double second) {
        result = first - second;
        return result;
    }
    protected double mult(double first, double second) {
        result = first * second;
        return result;
    }
    protected double div(double first, double second) {
        result = first / second;
        return result;
    }
    protected double rem(double first, double second) {
        result = first % second;
        return result;
    }
    protected double XtoY(double first, double second) {
        result = Math.pow(first, second);
        return result;
    }
    protected double etoX(double first) {
        result = Math.exp(first);
        return result;
    }
    protected double log(double first) {
        result = Math.log10(first);
        return result;
    }
    protected double Sin(double first) {
        result = Math.sin(first);
        return result;
    }
    protected double cos(double first) {
        result = Math.cos(first);
        return result;
    }
    protected double Tan(double first) {
        result = Math.tan(first);
        return result;
    }
    protected double In(double first) {
        result = Math.log(first);
        return result;
    }
    protected double xto2(double first) {
        result = Math.pow(first, 2.0);
        return result;
    }
    protected double xto3(double first) {
        result = Math.pow(first, 3.0);
        return result;
    }
    protected double root(double first) {
        result = Math.sqrt(first);
        return result;
    }
}
