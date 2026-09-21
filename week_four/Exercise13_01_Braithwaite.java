
public class Exercise13_01_Braithwaite{
//Declaration of an abstract version of GeometricObject
    public static abstract class GeometricObjectAbstract{
        String color;
        boolean filled;
        String dateCreated;
//Constructors
        public GeometricObjectAbstract(){
            color = null;
            filled = false;
            dateCreated = null;
        }

        public GeometricObjectAbstract(String color, boolean filled, String dateCreated){
            this.color = color;
            this.filled = filled;
            this.dateCreated = dateCreated;
        }
//Declaration of abstract version of getArea and getPerimiter for overriding
        protected abstract double getArea();
        protected abstract double getPerimeter();
    }
    static class GeometricObject{
        String color;
        boolean filled;
        String dateCreated;
//Constructors
        public GeometricObject(){
            color = null;
            filled = false;
            dateCreated = null;
        }

        public GeometricObject(String color, boolean filled, String dateCreated){
            this.color = color;
            this.filled = filled;
            this.dateCreated = dateCreated;
        }
//Declaration of getArea and getPerimiter for overriding
        protected double getArea(){
            return 0.0;
        }
        protected double getPerimeter(){
            return 0.0;
        }

    }
//Inheritence of Triangle class from the GeometricObject class
    static class Triangle extends GeometricObject{
        double sideA;
        double sideB;
        double sideC;
//Constructors
        public Triangle(){
            sideA = 0;
            sideB = 0;
            sideC = 0;
        }
        public Triangle(double sideA, double sideB, double sideC, String color, boolean filled, String dateCreated){
            super(color, filled, dateCreated);
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        public Triangle(double sideA, double sideB, double sideC){
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
//Overriding getArea() from GeometricObject and replacing it with Heron's formula
        @Override
        protected double getArea(){
            double semiPerimeter = ((sideA + sideB + sideC) / 2);
            double area = Math.sqrt(semiPerimeter * ((semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC)));
            return area;
        }
//Overriding getPerimiter() from GeometricObject parent to replace it with perimeter formula
        @Override 
        protected double getPerimeter(){
            return (sideA + sideB + sideC);
        }
//Override of toString() to return the side lengths when print object is called
        @Override
        public String toString(){
            super.toString();
            return "Side length of A = " + sideA + " \nSide length of B = " + sideB + " \nSide length of C = " + sideC;
        }
    }
//Declaration of reworked Triangle class, extending the abstract GeometricObject class
    public static class TriangleNew extends GeometricObjectAbstract{
        protected double sideA;
        protected double sideB;
        protected double sideC;


        public TriangleNew(double sideA, double sideB, double sideC, String color, boolean filled, String dateCreated){
            super(color, filled, dateCreated);
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

//Overriding getPerimiter declared in the abstract class
        @Override       
        protected double getPerimeter() {
            return (sideA + sideB + sideC);
        }
//Overriding getArea declared in the abstract class
        @Override
        protected double getArea() {
            double semiPerimeter = ((sideA + sideB + sideC) / 2);
            double area = Math.sqrt(semiPerimeter * ((semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC)));
            return area;   
        }
//toString override
        @Override
        public String toString() {
            super.toString();
            return "Side length of A = " + sideA + " \nSide length of B = " + sideB + " \nSide length of C = " + sideC;
        }
    }

//Main method and Testing
    public static void main(String[] args) {
        GeometricObjectAbstract scaleneTriangleNew = new TriangleNew(9.3, 4.6, 12.7, "Blue", false, "9/21/2026");
        System.out.println("The area of the Scalene Triangle is: " + scaleneTriangleNew.getArea());
        System.out.println("The perimeter of the Scalene Triangle is: " + scaleneTriangleNew.getPerimeter());
        System.out.println(scaleneTriangleNew);
        System.out.println("Filled = " + scaleneTriangleNew.filled);
        System.out.println("The color of the Scalene Triangle is " + scaleneTriangleNew.color);
        System.err.println("The Scalene Triangle was created on " + scaleneTriangleNew.dateCreated);
    }
}

//Analysis:
//If I were to change GeometricObjectAbstract to GeometricObject type, I would get an incompatible types error, stating that TriangleNew wouldn't be able to be converted. This is because TriangleNew inherites GeometricObjectAbstract, and not GeometricObject.