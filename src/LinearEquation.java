

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
        return distance;
    }

    public double yIntercept(){
        yIntercept = y1 - slope() * x1;
        return roundedToHundredth(yIntercept);
    }

    public double slope(){
        double rise = y2 - y1;
        double run = x2 - x1;
        double slope = rise / run;
        return slope;
    }

    public String equation() {
        if (slope() > 0 || slope() < 0){
            if (yIntercept() > 0) {
                return "y = " + slope() + "x + " + yIntercept();
            } else if (yIntercept() < 0) {
                return "y = " + slope() + "x - " + (yIntercept * -1.0);
            } else {
                return "y = " + slope() + "x";
            }
        } else {
            return "y = " + yIntercept;
        }
    }

    public String coordinateForX (double x) {
        double a = (slope() * x) + yIntercept();
        return "(" + x + ", " + a + ")";
    }

    private double roundedToHundredth (double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}
