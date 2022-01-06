package Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Book {
    @Id
    private String ISBN;

    private String title;
    private Date year;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "published_by")
    private Publisher published_by;

    @OneToOne
    @JoinColumn(name = "previous_edition")
    private Book previous_edition;

    @ManyToMany
    @JoinTable(
            name="Writes",
            joinColumns = @JoinColumn(name="bISBN"),
            inverseJoinColumns = @JoinColumn(name = "aSSN")
    )
    private List<Author> author = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="Edits",
            joinColumns = @JoinColumn(name="bISBN"),
            inverseJoinColumns = @JoinColumn(name = "eSSN")
    )
    private List<Editor> editor = new ArrayList<>();

    public Book() { super(); }

    public Book(String ISBN, String title, Date year, Double price, Publisher published_by, Book previous_edition, List<Author> author, List<Editor> editor) {
        super();
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
        this.published_by = published_by;
        this.previous_edition = previous_edition;
        this.author = author;
        this.editor = editor;
    }

    public void addAuthor(Author a) {
        this.author.add(a);
        a.addBook(this);
    }

    public void removeAuthor(Author a) {
        this.author.remove(a);
        a.removeBook(this);
    }

    public void addEditor(Editor e) {
        this.editor.add(e);
        e.addBook(this);
    }

    public void removeEditor(Editor e) {
        this.editor.remove(e);
        e.removeBook(this);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Publisher getPublished_by() {
        return published_by;
    }

    public void setPublished_by(Publisher published_by) {
        this.published_by = published_by;
    }

    public Book getPrevious_edition() {
        return previous_edition;
    }

    public void setPrevious_edition(Book previous_edition) {
        this.previous_edition = previous_edition;
    }

    public List<Author> getAuthor() {
        return author;
    }


    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Editor> getEditor() {
        return editor;
    }

    public void setEditor(List<Editor> editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", previous_edition=" + previous_edition +
                ", author=" + author +
                ", editor=" + editor +
                '}';
    }
}
