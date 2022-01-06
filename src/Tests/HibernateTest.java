package Tests;

import Domain.Author;
import Domain.Book;
import Domain.Editor;
import Domain.Publisher;
import Tools.HibernateUtils;
import bootstrap.HibernateBootstrap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HibernateTest {

    //TESTS COMMIT DATA TO DATABASE
    //IF TESTS SHOULDNT BE COMMITTED CHANGE
    //session.getTransaction().commit();
    //to
    //session.getTransaction().rollback();
    //for each test

    @Test
    /**
     * Save Publisher object to MySQL database using session.save() API
     *
     * @throws ParseException
     */

    public void testHibernate1() throws ParseException {

        // configures settings from hibernate.cfg.xml and then build a registry
        /*
         * First we build a StandardServiceRegistry instance which incorporates
         * configuration information into a working set of Services for use by the
         * SessionFactory. In this project we defined all configuration information in
         * hibernate.cfg.xml so there is not much interesting to see here.
         */
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        /*
         * Using the StandardServiceRegistry we create the
         * org.hibernate.boot.MetadataSources which is the start point for telling
         * Hibernate about your domain model. Again, since we defined that in
         * hibernate.cfg.xml so there is not much interesting to see here.
         *
         * Metadata (returned from buildMetadata method) represents the complete,
         * partially validated view of the application domain model which the
         * SessionFactory will be based on.
         *
         * Finally, a SessionFactory is then set up once for an application!The
         * SessionFactory is a thread-safe object that is instantiated once to serve the
         * entire application.
         */
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        /*
         * The SessionFactory acts as a factory for org.hibernate.Session instances,
         * which should be thought of as a corollary to a "unit of work".
         */
        /*
         * a session is created by session factory,you can think of a Hibernate session as a JDBC Connection
         * Hibernate session is not thread safe, which means it can only be used by one thread.
         */
        Session session = sessionFactory.openSession();

        session.beginTransaction(); // a session is used to open and commit a transaction

        //add publisher
         Publisher p1 = new Publisher();
         p1.setName("Tyler's Pub");
         p1.setPhone("8175689542");
         p1.setCity("Fort Worth");

        // We can directly save an object into DB, Hibernate will generate corresponding
        // SQL for us
        Object id = session.save(p1);// save is one API provided by Session, it is used to persist the Employee
        // object
        System.out.println("The returned publisher id is " + id);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    /**
     * In this example, we create an object from each domain.
     *
     * @throws ParseException
     */
    public void testHibernate2() throws ParseException {
        /*
         * Session class: The main runtime interface between a Java application and
         * Hibernate. This is the central API class abstracting the notion of a
         * persistence service. The life-cycle of a Session is bounded by the beginning
         * and end of a logical transaction. (Long transactions might span several
         * database transactions.) The main function of the Session is to offer CRUD
         * operations for instances of mapped entity classes.
         */
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        //add publisher
        Publisher p1 = new Publisher();
        p1.setName("McGraw Hill");
        p1.setPhone("8175689542");
        p1.setCity("Fort Worth");

        //add author
        Author a1 = new Author();
        a1.setSSN("123456789");
        a1.setFirst_name("John");
        a1.setLast_name("Smith");
        a1.setAddress("address 1");
        a1.setIncome(20000.5);

        //add editor
        Editor e1 = new Editor();
        e1.setSSN("913746825");
        e1.setFirst_name("Ming");
        e1.setLast_name("Yao");
        e1.setAddress("address 11");
        e1.setSalary(52369.5);
        p1.addEditor(e1);
        e1.setBook_count(8);

        //add book
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
        a1.addBook(b1);
        e1.addBook(b1);

        //commit and close session
        session.getTransaction().commit();
        session.close();
    }

    @Test
    /**
     * In this test case, we call the loadCompanyData method in class
     * HibernateBootstrap to populate the database. Then, we query this DB
     * to get a book object and change the price
     *
     */
    public void testHibernate3() {

        // prepare data
        try {
            HibernateBootstrap.loadCompanyData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        // We are going to set price of book to 16.0
        // Step 1, retrieve book using get method
        Book book = session.get(Book.class, "0321122267");// session.get method is used to retrieve one
        // record
        System.out.println(book.toString());
        // Step 2, set salary to a new value
        book.setPrice(16.0);// set Book's price to 16.0 from 15.5
        // that's it, DB will capture this change and update the corresponding record automatically.

        session.getTransaction().commit();
        session.close();
    }

    @Test
    /**
     * In this test case, we call the loadCompanyData method in class
     * HibernateBootstrap to populate the database. Then, we query this DB
     * for a book with PK equal to 0133970779. Then we delete this book.
     */
    public void testHibernate4() {

        // prepare data
        // if running tests individually with empty database each time uncomment code below
        try {
            HibernateBootstrap.loadCompanyData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Session session = HibernateUtils.openSession();
        session.beginTransaction();
        // We are going to delete Machine Learning 2
        // Step 1, retrieve Machine Learning 2 using get method
        Book book = session.get(Book.class, "0806666613");// get API is used to retrieve one record
        System.out.println(book.toString());
        // Step 2, delete!!!
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    /**
     * In this test case, we show the power of cascading in Hibernate. We will first
     * query the DB for an editor with PK equal to 999111555 then find his/her
     * publisher information then find the Books he/she is involved.
     *
     */
    public void testHibernate5() {

        // prepare data
        // if running tests individually with empty database each time uncomment code below
        try {
            HibernateBootstrap.loadCompanyData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        Editor editor = session.get(Editor.class, "999111555");// get API is used to retrieve one record

        System.out.println(editor.toString());

        Publisher p = editor.getWorks_for();
        System.out.println(p.toString());

        List<Book> books = editor.getBook();
        for (Book book : books) {
            System.out.println(book.toString());
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    /**
     * In this test case, we want to see a list of editors that work for Addison Wesley
     */
    public void testHibernate6() {

        // prepare data
        // if running tests individually with empty database each time uncomment code below
        try {
            HibernateBootstrap.loadCompanyData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        Publisher p = session.get(Publisher.class, "Addison Wesley");// get API is used to retrieve one record

        List<Editor> listOfEditors = p.getEditors();
        for (Editor editor : listOfEditors) {
            System.out.println(editor.toString());
        }

        session.getTransaction().commit();
        session.close();
    }

}
