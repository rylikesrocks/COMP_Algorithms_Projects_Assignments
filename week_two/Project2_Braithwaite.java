import java.util.ArrayList;
import java.util.Objects;

public class Project2_Braithwaite {
    public static class Author{
        public String name;
        public int birthYear;

        public Author(String name, int birthYear){
            this.name = name;
            this.birthYear = birthYear;
        }
        @Override 
        public String toString(){
            return "Author: " + name + " \nYear of Birth: " + birthYear;
        }

        @Override 
        public boolean equals(Object o){
            if(this.name == o) { return true; }
            else if(o == null || getClass() != o.getClass()){ return false; }
            Author author = (Author) o;
            return false;
        }

        }

    //The Book-Author Relationship is composition and not aggregation because the constructor is composed of author information for the book. Without author information, a book wouldn't be able to exist, which is why a no-arg constructor doesn't exist.

    public static class Book{
        String title;
        int yearPublished;
        String isbn;
        Author author;

        public Book(String title, int yearPublished, String isbn, String authorName, int authorYear){
            this.title = title;
            this.yearPublished = yearPublished;
            this.isbn = isbn;
            this.author = new Author(authorName, authorYear);
        }

        @Override 
        public String toString(){
            return "Title: " + title + " Year Published: " + yearPublished + " ISBN: " + isbn + " " + author;
        }
        @Override 
        public boolean equals(Object o){
            if(this == o){ return true; 
            }else if(o == null || getClass() != o.getClass()){ return false; }
            Book book = (Book) o;
            return isbn.equals(book.isbn);
        }

    //The hashCode contract requires that both hashCode and equals output the same value if equals is true. I resolve this by aligning the two parameters (isbn) for both hashCode and equals, so they are looking at the same bit of data and hashCode doesn't break.

        @Override 
        public int hashCode(){
            return Objects.hash(isbn);
        }

        public String getIsbn(){ return isbn; }
    }

    //The Library-Book Relationship is aggregation and not composition because the library interacts and owns books, but can exist without them. An empty ArrayList of books would still work fine, you just wouldn't be able to retrieve anything.

    public static class Library{
        String name;
        String location;
        ArrayList<Book> books;

        public Library(String name, String location, ArrayList<Book> books){
            this.name = name;
            this.location = location;
            this.books = books;
        }

        public void addBook(Book b){
            books.add(b);
        }

        public void removeBook(String isbn){
                books.removeIf(book -> book.isbn.equals(isbn));
            }
        public void findByAuthor(String authorName){
            for(Book book : books){
                if(book.author.name.equals(authorName)){
                    System.out.println(book);
                }
            }
        }
        public void findByTitle(String titleName){
            for(Book book : books){
                if(book.title.equals(titleName)){
                    System.out.println(book);
                }
            }
        }
        public void printCatalog(){
            System.out.println(books);
        }

    }

    //Testing 

    public static void main(String[] args) {
        ArrayList<Book> cool = new ArrayList<>();
        Author a1 = new Author("Jim Beam", 1999);
        Author a2 = new Author("Jim Bean", 1999);
        Book book1 = new Book("Beauty and the Beast", 1876, "2332836218", "Danny Devito", 1967);
        Book book2 = new Book("Over the Garden Wall", 2015, "2332836219", "George Harold", 1967);
        Book book3 = new Book("Berserk Volume 1", 1990, "9781593070205", "Kentaro Miura", 1966);
        Book book4 = new Book("Dune", 2017, "9780441013593", "Frank Herbert", 1965);
        Book book5 = new Book("Crying in H Mart: A Memoir", 2023, "9781984898951", "Michelle Zauner", 1989);
        Library awesome = new Library("Tri State Library", "Tri State Area", cool);
        awesome.addBook(book1);
        awesome.addBook(book2);
        awesome.addBook(book3);
        awesome.addBook(book4);
        awesome.addBook(book5);
        awesome.findByTitle("Berserk Volume 1");
        awesome.findByAuthor("Michelle Zauner");
        //awesome.printCatalog();
        //awesome.removeBook("9780441013593");
        awesome.printCatalog();
        System.out.println("\nUnrelated Author: \n" + a1);
        System.out.println(a1.equals(a2));

    }
}
//Credit for help with Aggregation Setup: https://www.youtube.com/watch?v=6MYaUdSuW24
//Credit for help with understanding override hashCode and equals: https://www.geeksforgeeks.org/java/equals-hashcode-methods-java/
//Used integrated Claude (on the right) for help with debugging and explaining behind logic iterating through findByTitle, BookName, and removeBook.

