public class Exercise12_01_Braithwaite{
    public static class Person{
        protected String name;
        protected String address;
        protected String phoneNumber;
        protected String email;

        public Person(){
            name = null;
            address = null;
            phoneNumber = null;
            email = null;
        }

        public Person(String name, String address, String phoneNumber, String email){
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        @Override 
        public String toString(){
            return "Hello my name is " + name + ", I live at " + address + ", my phone number is " + phoneNumber + ", and my email is " + email;
        }

    }
    public static class Employee extends Person{

        public Employee(){
            name = null;
            address = null;
            phoneNumber = null;
            email = null;
        }

        public Employee(String name, String address, String phoneNumber, String email){
            super(name, address, phoneNumber, email);
        }

        @Override 
        public String toString(){
            return "Hello, I am an Employee, my name is " + name + ", I live at " + address + ", my phone number is " + phoneNumber + ", and my email is " + email;
        }
    }
    public static class Student extends Person{

        public Student(){
            name = null;
            address = null;
            phoneNumber = null;
            email = null;
        }

        public Student(String name, String address, String phoneNumber, String email){
            super(name, address, phoneNumber, email);
        }

        @Override 
        public String toString(){
            return "Hello, I am a Student, my name is " + name + ", I live at " + address + ", my phone number is " + phoneNumber + ", and my email is " + email;
        }
    }
    public static class Faculty extends Employee{

        @Override 
        public String toString(){
            return "Hello, I am a Faculty member, my name is " + name + ", I live at " + address + ", my phone number is " + phoneNumber + ", and my email is " + email;
        }

        public Faculty(){
            name = null;
            address = null;
            phoneNumber = null;
            email = null;
        }

        public Faculty(String name, String address, String phoneNumber, String email){
            super(name, address, phoneNumber, email);
        }
    }
    // Staff class extending employee, inheriting its variables and methods.

    public static class Staff extends Employee{
        @Override 
        public String toString(){
            return "Hello, I am a Staff member, my name is " + name + ", I live at " + address + ", my phone number is " + phoneNumber + ", and my email is " + email;
        }
        public Staff(){
            name = null;
            address = null;
            phoneNumber = null;
            email = null;
        }

        public Staff(String name, String address, String phoneNumber, String email){
            super(name, address, phoneNumber, email);
        }
    }

    public static void main(String[] args) {
        Person employee = new Faculty("Hannah", "321 West Frontage Street", "(887) 423 6845", "hannahrewolinksi@gmail.com" );
        Person employee2 = new Person("Walter White", "3828 Piermont Dr NE", "(335) 568 0091", "walterhwhite@yahoo.com" );
        Person employee3 = new Employee("John Doe", "322 16th St SW", "(242) 801 5401", "johndoeisreal@hotmail.com" );
        Person employee4 = new Staff("Josh", "482 North Bandwagon Street", "(507) 764 2839", "joshcarpenter@outlook.com" );
        Person employee5 = new Student("Gustavo", "1213 Jefferson St NE", "(335) 602 0901", "lospolloshermanos@icloud.com");
        System.out.println(employee);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
        System.out.println(employee5);
    }
}
/* 
Even though each of the employees are declared as a Person object, their runtime is what really counts when java decides to print out.
This is because each variable is passed through each instance of polymorphism, or through the classes, but changes based on what is defined when declaring the object.
A person is directly called when declaring an object, but points to the actual class (for example faculty) in order to figure out what exactly needs to be printed, and what override makes sense.
*/