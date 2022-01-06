package bootstrap;

import Domain.Author;
import Domain.Book;
import Domain.Editor;
import Domain.Publisher;
import Tools.HibernateUtils;
import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HibernateBootstrap {

    public static void loadCompanyData() throws ParseException {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();


        //insert publishers
        Publisher p1 = new Publisher();
        p1.setName("McGraw Hill");
        p1.setPhone("8175689542");
        p1.setCity("Fort Worth");

        Publisher p2 = new Publisher();
        p2.setName("Pearson");
        p2.setPhone("8175689666");
        p2.setCity("OKC");

        Publisher p3 = new Publisher();
        p3.setName("Addison Wesley");
        p3.setPhone("8175689789");
        p3.setCity("Dallas");

        Publisher p4 = new Publisher();
        p4.setName("O Reiley");
        p4.setPhone("8885961258");
        p4.setCity("Chicago");

        Publisher p5 = new Publisher();
        p5.setName("Oxford Press");
        p5.setPhone("123456789");
        p5.setCity("London");

        Publisher p6 = new Publisher();
        p6.setName("ABC");
        p6.setPhone("123456789");
        p6.setCity("Wichita Falls");

        Publisher p7 = new Publisher();
        p7.setName("Springer");
        p7.setPhone("9852365");
        p7.setCity("New York");

        //insert Authors
        Author a1 = new Author();
        a1.setSSN("123456789");
        a1.setFirst_name("John");
        a1.setLast_name("Smith");
        a1.setAddress("address 1");
        a1.setIncome(20000.5);

        Author a2 = new Author();
        a2.setSSN("987654321");
        a2.setFirst_name("Harry");
        a2.setLast_name("Potter");
        a2.setAddress("address 2");
        a2.setIncome(25000.5);

        Author a3 = new Author();
        a3.setSSN("333444555");
        a3.setFirst_name("Josh");
        a3.setLast_name("Doe");
        a3.setAddress("address 3");
        a3.setIncome(20400.5);

        Author a4 = new Author();
        a4.setSSN("555666888");
        a4.setFirst_name("Ian");
        a4.setLast_name("Goodfellow");
        a4.setAddress("address 4");
        a4.setIncome(70000.5);

        Author a5 = new Author();
        a5.setSSN("999111555");
        a5.setFirst_name("Andrew");
        a5.setLast_name("Ng");
        a5.setAddress("address 5");
        a5.setIncome(90000.5);

        Author a6 = new Author();
        a6.setSSN("222333111");
        a6.setFirst_name("Peter");
        a6.setLast_name("Doe");
        a6.setAddress("address 6");
        a6.setIncome(80000.5);

        Author a7 = new Author();
        a7.setSSN("654987321");
        a7.setFirst_name("Tom");
        a7.setLast_name("Chandler");
        a7.setAddress("address 7");
        a7.setIncome(60000.5);

        //add Editors
        Editor e1 = new Editor();
        e1.setSSN("913746825");
        e1.setFirst_name("Ming");
        e1.setLast_name("Yao");
        e1.setAddress("address 11");
        e1.setSalary(52369.5);
        p1.addEditor(e1);
        e1.setBook_count(8);

        Editor e2 = new Editor();
        e2.setSSN("520898745");
        e2.setFirst_name("Tim");
        e2.setLast_name("Duncan");
        e2.setAddress("address 11");
        e2.setSalary(52369.5);
        p3.addEditor(e2);
        e2.setBook_count(9);

        Editor e3 = new Editor();
        e3.setSSN("313164649");
        e3.setFirst_name("Allen");
        e3.setLast_name("Iverson");
        e3.setAddress("address 11");
        e3.setSalary(59369.5);
        p2.addEditor(e3);
        e3.setBook_count(0);

        Editor e4 = new Editor();
        e4.setSSN("198503719");
        e4.setFirst_name("Ray");
        e4.setLast_name("Allen");
        e4.setAddress("address 11");
        e4.setSalary(52369.5);
        p6.addEditor(e4);
        e4.setBook_count(1);

        Editor e5 = new Editor();
        e5.setSSN("333366996");
        e5.setFirst_name("Kobe");
        e5.setLast_name("Bryant");
        e5.setAddress("address 11");
        e5.setSalary(52369.5);
        p5.addEditor(e5);
        e5.setBook_count(5);

        Editor e6 = new Editor();
        e6.setSSN("123456789");
        e6.setFirst_name("John");
        e6.setLast_name("Smith");
        e6.setAddress("address 1");
        e6.setSalary(3000.0);
        p1.addEditor(e6);
        e6.setBook_count(1);

        Editor e7 = new Editor();
        e7.setSSN("987654321");
        e7.setFirst_name("Harry");
        e7.setLast_name("Potter");
        e7.setAddress("address 2");
        e7.setSalary(3000.0);
        p4.addEditor(e7);
        e7.setBook_count(2);

        Editor e8 = new Editor();
        e8.setSSN("555666888");
        e8.setFirst_name("Ian");
        e8.setLast_name("Goodfellow");
        e8.setAddress("address 4");
        e8.setSalary(3000.0);
        p7.addEditor(e8);
        e8.setBook_count(7);

        Editor e9 = new Editor();
        e9.setSSN("222333111");
        e9.setFirst_name("Peter");
        e9.setLast_name("Doe");
        e9.setAddress("address 6");
        e9.setSalary(3000.0);
        p5.addEditor(e9);
        e9.setBook_count(3);

        Editor e10 = new Editor();
        e10.setSSN("999111555");
        e10.setFirst_name("Andrew");
        e10.setLast_name("Ng");
        e10.setAddress("address 5");
        e10.setSalary(3000.0);
        p3.addEditor(e10);
        e10.setBook_count(5);


        //add Books
        Book b1 = new Book();
        b1.setISBN("9780073376");
        b1.setTitle("OO Software Engineering");
        Integer value = 2014;
        SimpleDateFormat Format = new SimpleDateFormat("yyyy");
        Date date = Format.parse(value.toString());
        b1.setYear(date);
        b1.setPrevious_edition(null);
        b1.setPrice(102.5);
        p1.addBook(b1);
        b1.addAuthor(a1);
        b1.addEditor(e8);


        Book b2 = new Book();
        b2.setISBN("0806666666");
        b2.setTitle("Fundamentals of DB 1");
        value = 1992;
        date = Format.parse(value.toString());
        b2.setYear(date);
        b2.setPrevious_edition(null);
        b2.setPrice(82.5);
        p6.addBook(b2);
        b2.addAuthor(a4);
        b2.addEditor(e7);
        b2.addEditor(e10);
        b2.addEditor(e9);


        Book b3 = new Book();
        b3.setISBN("0805317481");
        b3.setTitle("Fundamentals of DB 2");
        value = 1994;
        date = Format.parse(value.toString());
        b3.setYear(date);
        b3.setPrevious_edition(b2);
        b3.setPrice(87.5);
        p6.addBook(b3);
        b3.addAuthor(a4);
        b3.addEditor(e9);


        Book b4 = new Book();
        b4.setISBN("0805317554");
        b4.setTitle("Fundamentals of DB 3");
        value = 1999;
        date = Format.parse(value.toString());
        b4.setYear(date);
        b4.setPrevious_edition(b3);
        b4.setPrice(12.5);
        p6.addBook(b4);
        b4.addAuthor(a6);
        b4.addAuthor(a3);
        b4.addEditor(e2);


        Book b5 = new Book();
        b5.setISBN("0321122267");
        b5.setTitle("Fundamentals of DB 4");
        value = 2003;
        date = Format.parse(value.toString());
        b5.setYear(date);
        b5.setPrevious_edition(b4);
        b5.setPrice(15.5);
        p3.addBook(b5);
        b5.addAuthor(a4);
        b5.addAuthor(a7);
        b5.addAuthor(a5);
        b5.addAuthor(a3);
        b5.addEditor(e1);
        b5.addEditor(e3);


        Book b6 = new Book();
        b6.setISBN("0321369572");
        b6.setTitle("Fundamentals of DB 5");
        value = 2008;
        date = Format.parse(value.toString());
        b6.setYear(date);
        b6.setPrevious_edition(b5);
        b6.setPrice(162.5);
        p3.addBook(b6);
        b6.addAuthor(a2);
        b6.addEditor(e10);


        Book b7 = new Book();
        b7.setISBN("0136086209");
        b7.setTitle("Fundamentals of DB 6");
        value = 2009;
        date = Format.parse(value.toString());
        b7.setYear(date);
        b7.setPrevious_edition(b6);
        b7.setPrice(172.5);
        p2.addBook(b7);
        b7.addAuthor(a1);
        b7.addEditor(e8);


        Book b8 = new Book();
        b8.setISBN("0133970779");
        b8.setTitle("Fundamentals of DB 7");
        value = 2015;
        date = Format.parse(value.toString());
        b8.setYear(date);
        b8.setPrevious_edition(b7);
        b8.setPrice(98.3);
        p2.addBook(b8);
        b8.addAuthor(a1);
        b8.addEditor(e8);
        b8.addEditor(e10);


        Book b9 = new Book();
        b9.setISBN("0806666611");
        b9.setTitle("Software Requirements");
        value = 2013;
        date = Format.parse(value.toString());
        b9.setYear(date);
        b9.setPrevious_edition(null);
        b9.setPrice(99.5);
        p7.addBook(b9);
        b9.addAuthor(a5);
        b9.addEditor(e10);


        Book b10 = new Book();
        b10.setISBN("0806666612");
        b10.setTitle("UML Modeling");
        value = 2000;
        date = Format.parse(value.toString());
        b10.setYear(date);
        b10.setPrevious_edition(null);
        b10.setPrice(89.5);
        p4.addBook(b10);
        b10.addAuthor(a5);
        b10.addEditor(e3);


        Book b11 = new Book();
        b11.setISBN("0806666614");
        b11.setTitle("Machine Learning 1");
        value = 2000;
        date = Format.parse(value.toString());
        b11.setYear(date);
        b11.setPrevious_edition(null);
        b11.setPrice(109.5);
        p3.addBook(b11);
        b11.addAuthor(a6);
        b11.addEditor(e6);

        Book b12 = new Book();
        b12.setISBN("0806666613");
        b12.setTitle("Machine Learning 2");
        value = 2008;
        date = Format.parse(value.toString());
        b12.setYear(date);
        b12.setPrevious_edition(b11);
        b12.setPrice(109.5);
        p3.addBook(b12);
        b12.addAuthor(a5);
        b12.addEditor(e8);


        Book b13 = new Book();
        b13.setISBN("0806666620");
        b13.setTitle("Big Bang Theory");
        value = 1975;
        date = Format.parse(value.toString());
        b13.setYear(date);
        b13.setPrevious_edition(null);
        b13.setPrice(19.5);
        p5.addBook(b13);
        b13.addAuthor(a7);
        b13.addEditor(e9);


        Book b14 = new Book();
        b14.setISBN("0806666622");
        b14.setTitle("Java Programming");
        value = 2008;
        date = Format.parse(value.toString());
        b14.setYear(date);
        b14.setPrevious_edition(null);
        b14.setPrice(59.5);
        p2.addBook(b14);
        b14.addAuthor(a7);
        b14.addAuthor(a1);
        b14.addAuthor(a6);
        b14.addAuthor(a2);
        b14.addEditor(e10);


        //persist publishers
        session.saveOrUpdate(p1);
        session.saveOrUpdate(p2);
        session.saveOrUpdate(p3);
        session.saveOrUpdate(p4);
        session.saveOrUpdate(p5);
        session.saveOrUpdate(p6);
        session.saveOrUpdate(p7);

        //persist Authors
        session.saveOrUpdate(a1);
        session.saveOrUpdate(a2);
        session.saveOrUpdate(a3);
        session.saveOrUpdate(a4);
        session.saveOrUpdate(a5);
        session.saveOrUpdate(a6);
        session.saveOrUpdate(a7);

        //persist Editors
        session.saveOrUpdate(e1);
        session.saveOrUpdate(e2);
        session.saveOrUpdate(e3);
        session.saveOrUpdate(e4);
        session.saveOrUpdate(e5);
        session.saveOrUpdate(e6);
        session.saveOrUpdate(e7);
        session.saveOrUpdate(e8);
        session.saveOrUpdate(e9);
        session.saveOrUpdate(e10);

        //persist Books
        session.saveOrUpdate(b1);
        session.saveOrUpdate(b2);
        session.saveOrUpdate(b3);
        session.saveOrUpdate(b4);
        session.saveOrUpdate(b5);
        session.saveOrUpdate(b6);
        session.saveOrUpdate(b7);
        session.saveOrUpdate(b8);
        session.saveOrUpdate(b9);
        session.saveOrUpdate(b10);
        session.saveOrUpdate(b11);
        session.saveOrUpdate(b12);
        session.saveOrUpdate(b13);
        session.saveOrUpdate(b14);

        //commit and close session
        session.getTransaction().commit();
        session.close();

    }
}
