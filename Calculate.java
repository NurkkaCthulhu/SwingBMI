public class Calculate {

    private static double result;

    public static double bmiOldFormula(double kg, double height) {
        result = kg/(height*height);

        return result;
    }
    
    public static double bmiNewFormula(double kg, double height) {
        result = 1.3*kg/(Math.pow(height, 2.5));

        return result;
    }

    private static void roundResult() {

    }

}