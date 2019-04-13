import edu.duke.*;
/**
 * Write a description of PerimeterAssignmentRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PerimeterAssignmentRunner {
    public int getNumPoints (Shape s){
        int totalPoint = 0;
        for (Point onePoint: s.getPoints()){
            totalPoint = totalPoint + 1;
        }
        return totalPoint;
    }
    public double getPerimeter (Shape s){
        // start with totalPerim = 0
        double totalPerim = 0;
        // start with prevPt = the last point
        Point PrevPt = s.getLastPoint();
        for (Point CurrPt: s.getPoints()){
            double currDist = PrevPt.distance(CurrPt);
            totalPerim = totalPerim + currDist;
            PrevPt = CurrPt;
        }
        return totalPerim;
    }
    
    public void testPerimeter(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        System.out.println("totalPoint = " + points);
    }
    
    public static void main (String[] args){
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
