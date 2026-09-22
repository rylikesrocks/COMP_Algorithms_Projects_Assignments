import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Project4_Braithwaite {
    public static abstract class Shape implements Comparable<Shape>{
        protected String color;

        public Shape(){
            color = null;
        }

        public Shape(String color){
            this.color = color;
        }

        public abstract double area();
        public abstract double perimeter();

        @Override
        public String toString(){
            return "The area is " + area() + " and the perimeter is " + perimeter();
        }

        @Override 
        public int compareTo(Shape o){
            if(o == null){
                throw new NullPointerException("The input is null!");
            }
            if(area() < o.area()){
                return (int) area();
            } else {
                return (int) o.area();
            }
        }
    }

    public static class Circle extends Shape{
        protected double radius;

        public Circle(){
            color = null;
            radius = 0.0;
        }

        public Circle(String color, double radius){
            super(color);
            this.radius = radius;
        }

        public Circle(double radius){
            color = null;
            this.radius = radius;
        }

        @Override
        public double area() {
            return ((radius * 3.14159) * (radius * 3.14159));
        }

        @Override
        public double perimeter() {
            return (3.14159 * (radius * radius));
        }
    }

    public static class Rectangle extends Shape{
        protected double width;
        protected double height;

        public Rectangle(){
            width = 0.0;
            height = 0.0;
        }

        public Rectangle(String color, double width, double height){
            super(color);
            this.width = width;
            this.height = height;
        }

        public Rectangle(double width, double height){
            color = null;
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public double perimeter() {
            return ((2 * height) + (2 * width));
        }
    }

    public static class Triangle extends Shape{
        protected double sideA;
        protected double sideB;
        protected double sideC;

        public Triangle(String color, double sideA, double sideB, double sideC){
            super(color);
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        
        public Triangle(double sideA, double sideB, double sideC){
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        @Override
        public double area() {
            double semiPerimeter = ((sideA + sideB + sideC) / 2);
            double area = Math.sqrt(semiPerimeter * ((semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC))); 
            return area;
        }

        @Override
        public double perimeter() {
            return sideA + sideB + sideC;
        }
    }
    
    public interface Taxable{
        public double getTax();
    }

    public static class TaxableRectangle extends Rectangle implements Taxable{
        public TaxableRectangle(){
            width = 0.0;
            height = 0.0;
        }

        public TaxableRectangle(String color, double width, double height){
            super(color, width, height);
        }

        public TaxableRectangle(double width, double height){
            super(width, height);
        }
        @Override 
        public double getTax(){
            double propertyTaxRateMN = 0.01;
            double propertyTaxMN = (area() * propertyTaxRateMN);
            return propertyTaxMN;
        }
    }

    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        Shape taxableRectangle1 = new TaxableRectangle(12.5, 20.92);
        Shape taxableRectangle2 = new TaxableRectangle(30.7, 15.3342);
        Shape triangle1 = new Triangle(10.5, 7.2, 12.4);
        Shape triangle2 = new Triangle(8.5, 13.0, 4.67);
        Shape rectangle1 = new Rectangle("blue", 10, 12);
        Shape rectangle2 = new Rectangle("red", 14, 17);
        Shape circle1 = new Circle(17);
        Shape circle2 = new Circle(33);
        shapeList.add(taxableRectangle1);
        shapeList.add(taxableRectangle2);
        shapeList.add(rectangle1);
        shapeList.add(rectangle2);
        shapeList.add(circle1);
        shapeList.add(circle2);
        shapeList.add(triangle1);
        shapeList.add(triangle2);
//Before Sorting
        System.out.println(shapeList);
//After Sorting
        Collections.sort(shapeList, Comparator.comparing(Shape::area));
        System.out.println(shapeList);
//Sorting based on Perimeter
        Collections.sort(shapeList, Comparator.comparing(Shape::perimeter));
        System.out.println(shapeList);

        for(int i = 0; i < shapeList.size(); i++){
            System.out.println("Index " + i + " Taxable? ");
            System.out.println(shapeList.get(i) instanceof Taxable);
        }
    }
}
//https://www.geeksforgeeks.org/java/collections-sort-java-examples/ used for help understanding Comparators and Collections.sort() more.
//Textbook also used for help with understanding some code (comparators, lambdas, and collections).