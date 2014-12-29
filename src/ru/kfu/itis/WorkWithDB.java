package ru.kfu.itis;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by mg on 26.12.14.
 */
public class WorkWithDB {
    private static Connection connection;

    public static void initializeConnection(String user, String password) throws ClassNotFoundException, SQLException {
        if(connection == null){
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/BooksDB";
            connection = DriverManager.getConnection(url, user, password);

        }
    }

    public static  ArrayList<String> getBooks() throws SQLException {
        ArrayList<String> books= new ArrayList<String>();



            String query = "SELECT id, Author, Film FROM Books";
            ResultSet res;
            Statement statement = connection.createStatement();

            res = statement.executeQuery(query);
            while(res.next()){
                String book = res.getString("id") + " "
                        + res.getString("Author") + " "
                        + res.getString("Film");
                books.add(book);
            }



        return books;
    }

    public static ArrayList<String> getCustomers() throws SQLException {
        ArrayList<String> customers = new ArrayList<String>();



        String query = "SELECT INNcustomer, Customer FROM Customer";
        ResultSet res;
        Statement statement = connection.createStatement();

        res = statement.executeQuery(query);
        while(res.next()){
            String customer = res.getString("INNcustomer") + " "
                    + res.getString("Customer");
            customers.add(customer);
        }



        return customers;
    }

    public static ArrayList<Invoice> getInvocesByDateAndCount(String date,
                                                              String count,
                                                              String custINN,
                                                              String bookID)
            throws Exception {
        ArrayList<Invoice> listOfInvoices = new ArrayList<Invoice>();

        int countInt = new Integer(count);
        int bookIDInt = new Integer(bookID);
        String[] dateArray = date.split("[.]");
        System.out.println(date + " " + dateArray.length);
        date = dateArray[2]
                + "-"
                + dateArray[1]
                + "-"
                + dateArray[0];
        String query = "SELECT * FROM Invoice WHERE DateStart>? " +
                "AND CustomerINN = ? " +
                "AND CountNumber IN(SELECT CountNumber " +
                "FROM Books_in_invoice WHERE BookID = ?)";

        ResultSet res;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, date);
        statement.setString(2, custINN);
        statement.setInt(3, bookIDInt);
        res = statement.executeQuery();
        while(res.next()){
            System.out.println(res.getInt(1));
            int countNumber = res.getInt("CountNumber");
            String dateStart = res.getString("DateStart");
            double value = res.getDouble("Value");
            String worker = res.getString("Worker");
            double tax = res.getDouble("Tax");
            String plus = res.getString("Plus");
            String customerINN = res.getString("CustomerINN");
            Invoice invoice = new Invoice(countNumber,
                    dateStart,
                    value,
                    worker,
                    tax,
                    plus,
                    customerINN);
            listOfInvoices.add(invoice);

        }
        if(listOfInvoices.size() <= countInt){
            listOfInvoices = new ArrayList<Invoice>();
        }
        return listOfInvoices;
    }

    public static Book getBook(int id) throws Exception {
        Book book = null;
        String query = "SELECT * FROM Books WHERE id = ?";

        ResultSet res;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        res = statement.executeQuery();
        while(res.next()){
            String film = res.getString("Film");
            String author = res.getString("Author");
            String comment = res.getString("Comment");
            int pages = res.getInt("Pages");
            String company = res.getString("Company");
            int year = res.getInt("Year");
            double cost = res.getDouble("Cost");
            boolean cdRom = res.getBoolean("Cdrom");
            String iNNOfProducer = res.getString("Company");
            book = new Book(id,
                    film,
                    author,
                    comment,
                    pages,
                    company,
                    year,
                    cost,
                    cdRom,
                    iNNOfProducer);

        }

        return book;
    }

    public static Customer getCustomer(String iNN) throws Exception {
        Customer customer = null;
        String query = "SELECT * FROM Customer WHERE INNcustomer = ?";

        ResultSet res;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, iNN);
        res = statement.executeQuery();
        while(res.next()){
            String customerName = res.getString("Customer");
            boolean customerSign = res.getBoolean("CustomerSign");
            String addressCust = res.getString("AddressCust");
            String chief = res.getString("Chief");
            String bank = res.getString("BankCustomer");
            String phone = res.getString("Phone");
            String district = res.getString("District");
            String accountCust = res.getString("AccountCust");
            customer = new Customer(iNN,
                    customerName,
                    customerSign,
                    addressCust,
                    chief,
                    bank,
                    phone,
                    district,
                    accountCust);



        }

        return customer;
    }
}
