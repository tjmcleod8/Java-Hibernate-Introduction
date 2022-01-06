package Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    private String SSN;
    private String first_name;
    private String last_name;
    private String address;
    private Double income;

    @ManyToMany(mappedBy = "author")
    private List<Book> writes = new ArrayList<>();

    public Author() { super(); }

    public Author(String SSN, String first_name, String last_name, String address, Double income, List<Book> writes) {
        super();
        this.SSN = SSN;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.income = income;
        this.writes = writes;
    }

    public void addBook(Book b) {
        this.writes.add(b);
    }

    public void removeBook(Book b) {
        this.writes.remove(b);
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

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public List<Book> getWrites() {
        return writes;
    }

    public void setWrites(List<Book> writes) {
        this.writes = writes;
    }

    @Override
    public String toString() {
        return "Author{" +
                "SSN='" + SSN + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", income=" + income +
                '}';
    }
}
