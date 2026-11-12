import java.util.*;

public class Capstone_Braithwaite {
    
    class HistoryFullException extends RuntimeException{
        public HistoryFullException(String mes){
            super(mes);
        }
    }

    class HistoryEmptyException extends RuntimeException{
        public HistoryEmptyException(String mes){
            super(mes);
        }
    }

    abstract class LibraryItem implements Comparable<LibraryItem>{
        String title;
        String isbn;
        int year;
        int checkoutCnt;

        public LibraryItem(){
            title = null;
            isbn = null;
            year = -1;
            checkoutCnt = -1;
        }

        public LibraryItem(String title, String isbn, int year, int checkoutCnt){
            this.title = title;
            this.isbn = isbn;
            this.year = year;
            this.checkoutCnt = checkoutCnt;
        }

        abstract int getLoanPeriodDays();

        @Override
        public String toString(){
            return "Loan Period Days: " + getLoanPeriodDays();
        }
    }

    public class Book extends LibraryItem implements Renewable{

        int loanPeriod;
        boolean hardCover;
        Author author;

        public Book(String title, String isbn, Integer year, int checkoutCnt, boolean hardCover, String name, int birthYear){
            super(title, isbn, year, checkoutCnt);
            loanPeriod = 14;
            this.hardCover = hardCover;
            this.author = new Author(name, birthYear);
        }

        public int hardCoverCheck(){
            if(hardCover){
                loanPeriod = loanPeriod + 5;
            }
            return loanPeriod;
        }

        @Override 
        public int getLoanPeriodDays(){
            return loanPeriod;
        }

        @Override
        public int compareTo(LibraryItem obj){
            if(obj == null){
                return 1;
            }
            int comparing = Integer.compare(this.year, obj.year);
            if(comparing != 0) {
                return comparing;
            }

            if(this.isbn == null && obj.isbn == null) return 0;
            if (this.isbn == null) return -1;
            if (obj.isbn == null) return 1;

            return this.isbn.compareTo(obj.isbn);
        }

        @Override
        public boolean equals(Object o){
            if(this == o){ return true; 
            }else if(o == null || getClass() != o.getClass()){ return false; }
            Book book = (Book) o;
            return isbn.equals(book.isbn);
        }

        @Override 
        public int hashCode(){
            return Objects.hash(isbn);
        }

        @Override 
        public boolean renew(){
            return true;
        }
    }

    public class Author{
        String name;
        int birthYear;

        public Author(String name, int birthYear){
            this.name = name;
            this.birthYear = birthYear;
        }
    }

    public class DVD extends LibraryItem{
        int loanPeriod;
        String type;
        String publisher;

        public DVD(String title, String isbn, int year, int checkoutCnt, String type, String publisher){
            super(title, isbn, year, checkoutCnt);
            this.loanPeriod = 15;
            this.type = type;
            this.publisher = publisher;
        }

        @Override
        public int getLoanPeriodDays(){
            return loanPeriod;
        }

        @Override 
            public int compareTo(LibraryItem obj){
            if(obj == null){
                return 1;
            }
            int comparing = Integer.compare(this.year, obj.year);
            if(comparing != 0) {
                return comparing;
            }

            if(this.isbn == null && obj.isbn == null) return 0;
            if (this.isbn == null) return -1;
            if (obj.isbn == null) return 1;

            return this.isbn.compareTo(obj.isbn);
        }
        @Override
        public boolean equals(Object o){
            if(this == o){ return true; 
            }else if(o == null || getClass() != o.getClass()){ return false; }
            DVD dvd = (DVD) o;
            return isbn.equals(dvd.isbn);
        }

        @Override 
        public int hashCode(){
            return Objects.hash(isbn);
        }
    }

    public class AudioBook extends LibraryItem implements Renewable{
        int loanPeriod;
        int lengthMinutes;
        String speaker;

        public AudioBook(String title, String isbn, int year, int checkoutCnt, int lengthMinutes, String speaker){
            super(title, isbn, year, checkoutCnt);
            this.loanPeriod = 14;
            this.lengthMinutes = lengthMinutes;
            this.speaker = speaker;
        }

        @Override
        int getLoanPeriodDays() {
            return loanPeriod;
        }

        public int sampleListen(){
            System.out.println("Now playing " + title + " with speaker " + speaker + ". Length: " + lengthMinutes);
            return lengthMinutes;
        }

        @Override 
        public boolean renew(){
            return false;
        }

        @Override 
            public int compareTo(LibraryItem obj){
            if(obj == null){
                return 1;
            }
            int comparing = Integer.compare(this.year, obj.year);
            if(comparing != 0) {
                return comparing;
            }

            if(this.isbn == null && obj.isbn == null) return 0;
            if (this.isbn == null) return -1;
            if (obj.isbn == null) return 1;

            return this.isbn.compareTo(obj.isbn);
        }
        @Override
        public boolean equals(Object o){
            if(this == o){ return true; 
            }else if(o == null || getClass() != o.getClass()){ return false; }
            DVD dvd = (DVD) o;
            return isbn.equals(dvd.isbn);
        }

        @Override 
        public int hashCode(){
            return Objects.hash(isbn);
        }
    }

    interface Renewable{
        public boolean renew();
    }

    public class Patron{
        String name;
        int age;
        int cardId;

        public Patron(String name, int age, int cardId){
            this.name = name;
            this.age = age;
            this.cardId = cardId;
        }
    }

    // Bounded Checkout Stack

    public class BoundedHistoryStack<T>{
        private T[] history;
        private int top;

        @SuppressWarnings("unchecked")
        public BoundedHistoryStack(int size){
            this.history = (T[]) new Object[size];
            top = -1;
        }

        public void push(T value){
            try{
                history[++top] = value;
            }catch(HistoryFullException e){
                System.out.println("Exception: Attempting to add to a stack that has reached maximum capacity: " + e.getMessage());
            }
        }

        public T pop(){
            try {
                T temp = history[top];
                history[top] = null;
                top--;
                return temp;
            } catch (HistoryEmptyException e) {
                System.out.println("Exception: Attempt to remove an empty stack! " + e.getMessage());
                return null;
            }
        }

        public T peek(){
            try {
                return history[top];
            } catch (HistoryEmptyException e) {
                System.out.println("Exception: Attempt to look at a NULL stack! " + e.getMessage());
                return null;
            }
        }
    }
}
