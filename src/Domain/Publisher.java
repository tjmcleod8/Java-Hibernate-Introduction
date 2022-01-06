package Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    private String name;
    private String phone;
    private String city;

    @OneToMany(mappedBy = "published_by")
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "works_for")
    private List<Editor> editors = new ArrayList<>();

    public Publisher() { super(); }

    public Publisher(String name, String phone, String city, List<Book> books, List<Editor> editors) {
        super();
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.books = books;
        this.editors = editors;
    }

    public void addEditor(Editor e) {
        this.editors.add(e);
        e.setWorks_for(this);
    }

    public void removeEditor(Editor e) {
        this.editors.remove(e);
        e.setWorks_for(null);
    }

    public void addBook(Book b) {
        this.books.add(b);
        b.setPublished_by(this);
    }

    public void removeBook(Book b) {
        this.books.remove(b);
        b.setPublished_by(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Editor> getEditors() {
        return editors;
    }

    public void setEditors(List<Editor> editors) {
        this.editors = editors;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
