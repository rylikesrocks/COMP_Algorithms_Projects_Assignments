

public class Exercise11_01_Braithwaite {
//Parent Class declaration to extend the child classes;
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


//Testing

    public static void main(String[] args) {
        Triangle scaleneTriangle = new Triangle(4.3, 9.6, 10.5, "Yellow", true, "9/14/2026");
        System.out.println("The area of the Scalene Triangle is: " + scaleneTriangle.getArea());
        System.out.println("The perimeter of the Scalene Triangle is: " + scaleneTriangle.getPerimeter());
        System.out.println(scaleneTriangle);
        System.out.println("Filled = " + scaleneTriangle.filled);
        System.out.println("The color of the Scalene Triangle is " + scaleneTriangle.color);
        System.err.println("The Scalene Triangle was created on " + scaleneTriangle.dateCreated);
    }
}
