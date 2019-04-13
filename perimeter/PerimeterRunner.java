import edu.duke.*;
import java.io.File;
/**
 * Write a description of PerimeterRunner here.
 * 
 * @author Yucheng 
 * @version (a version number or a date)
 */
public class PerimeterRunner {
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
    
    public int getNumPoints (Shape s){
        // start with totalPerim = 0
        int totalPoint = 0;
        // start with prevPt = the last point
        for (Point CurrPt: s.getPoints()){
            totalPoint = totalPoint + 1;
        }
        return totalPoint;
    }
        
    public double getAverageLength (Shape s){
        double averageLength = 0;
        double length = getPerimeter(s);
        int pointNum = getNumPoints(s);
        averageLength = length / pointNum;
        // start with prevPt = the last point
        return averageLength;
    }
        
    public double getLargestSide (Shape s){
        // start with totalPerim = 0
        double LargestSide = 0;
        Point PrevPt = s.getLastPoint();
        // start with prevPt = the last point
        for (Point CurrPt: s.getPoints()){
            double currDist = PrevPt.distance(CurrPt);
            System.out.println(currDist);
            if (currDist > LargestSide){
                LargestSide = currDist;
            }
        }
        return LargestSide;
    }
        
    public double getLargestX (Shape s){
        // start with totalPerim = 0
        double largestX = s.getLastPoint().getX();
        // start with prevPt = the last point
        for (Point CurrPt: s.getPoints()){
            double xValue = CurrPt.getX();
            if (xValue > largestX){
                largestX = xValue;
            }
        }
        return largestX;
    }
    
    public double getLargestPerimeterMultipleFiles (){
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (length > largestPerimeter){
                largestPerimeter = length;
            }
        }
        return largestPerimeter;
    }    

    public String getFileWithLargestPerimeter (){
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        String fileName = "";
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            System.out.println(length);
            if (length > largestPerimeter){
                largestPerimeter = length;
                fileName = f.getName();
            }
        }
        return fileName;
    }
    
    public void testPerimeter(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double averageLength = getAverageLength(s);
        double LargestSide = getLargestSide(s);
        int pointNum = getNumPoints(s);
        double largestX = getLargestX(s);
        System.out.println("perimiter = " + length);
        System.out.println("total point = " + pointNum);
        System.out.println("largest side = " + LargestSide);
        System.out.println("average length = " + averageLength);
        System.out.println("largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles(){
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter = " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter(){
        String largestFileName = getFileWithLargestPerimeter();
        System.out.println("file name with largest perimeter = " + largestFileName);
    }
    
    public static void main (String[] args){
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
    
        public static void main2 (String[] args){
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeterMultipleFiles();
    }
    
    public static void main3 (String[] args){
        PerimeterRunner pr = new PerimeterRunner();
        pr.testFileWithLargestPerimeter();
    }
}
