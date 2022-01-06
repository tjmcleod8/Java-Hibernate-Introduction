package Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Editor {
    @Id
    private String SSN;
    private String first_name;
    private String last_name;
    private String address;
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "works_for")
    private Publisher works_for;

    @ManyToMany(mappedBy = "editor")
    private List<Book> book = new ArrayList<>();

    private Integer book_count;

    public Editor() { super(); }

    public Editor(String SSN, String first_name, String last_name, String address, Double salary, Publisher works_for, Integer book_count, List<Book> book) {
        super();
        this.SSN = SSN;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.salary = salary;
        this.works_for = works_for;
        this.book_count = book_count;
        this.book= book;
    }

    public void addBook(Book b) {
        this.book.add(b);
    }

    public void removeBook(Book b) {
        this.book.remove(b);
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Publisher getWorks_for() {
        return works_for;
    }

    public void setWorks_for(Publisher works_for) {
        this.works_for = works_for;
    }

    public Integer getBook_count() {
        return book_count;
    }

    public void setBook_count(Integer book_count) {
        this.book_count = book_count;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "SSN='" + SSN + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", book_count=" + book_count +
                '}';
    }
}
