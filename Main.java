/**
 * Main class if for starting the BMI calculator.
 * 
 * @author      Anu Malm <anu.m.malm(at)gmail.com>
 * @version     2019.0117
 * @since       2018.0918
 */
class Main {

    /**
     * main-method makes a new BMIWindow and starts the software.
     * 
     * @param args  command line parameters
     */
    public static void main (String[] args) {
        
        String title = "BMI calculator";
        BMIWindow w = new BMIWindow(title, 400, 400);

    }
}