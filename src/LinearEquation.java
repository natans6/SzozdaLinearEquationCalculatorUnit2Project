

public class LinearEquation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private double distance;
    private double yIntercept;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        distance = 0.0;
        yIntercept = 0.0;
    }

    public double distance() {
        double x = Math.pow(x2 - x1, 2);
        double y = Math.pow(y2 - y1, 2);
        distance = Math.sqrt(x + y);
        return roundedToHundredth(distance);
    }

    public double yIntercept(){
        yIntercept = y1 - slopeValue() * x1;
        return roundedToHundredth(yIntercept);
    }

    public String slope(){
        int rise = y2 - y1;
        int run = x2 - x1;
        if (rise < 0 && run < 0) {
            return (rise * -1) + "/" + (run * -1);
        } else if (run < 0 && rise > 0){
            return "-" + rise + "/" + (run *  -1);
        }
        return rise + "/" + run;
    }

    public double slopeValue(){
        double rise1 = y2 - y1;
        double run1 = x2 - x1;
        return roundedToHundredth(rise1 / run1);
    }

    public String equation() {
        if (slopeValue() == 1) {
            return "y = x" + " + " + yIntercept();
        } else if (slopeValue() == -1) {
            return "y = -x";
        } else if (slopeValue() % 1 == 0) {
            return "y = " + (int) slopeValue() + "x " + yIntercept();
        } else {
            return "y = " + slope() + "x + " + yIntercept();
        }
    }

    public String coordinateForX (double x) {
        double a = (slopeValue() * x) + yIntercept();
        return "(" + x + ", " + a + ")";
    }


    public String lineInfo() {
        if (x1 != x2) {
            String finalStatement = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
            finalStatement += "The equation of the line between these points is: " + equation() + "\n";
            finalStatement += "The slope of this line is: " + slopeValue() + "\n";
            finalStatement += "The y-intercept of this line is: " + yIntercept() + "\n";
            finalStatement += "The distance between these points is " + distance();
            return finalStatement;
        } else {
            return "The points are on a vertical line: x = " + x1;
        }
    }

    private double roundedToHundredth (double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
