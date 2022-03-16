package com.capgemini.repository;

import com.capgemini.connection.ConnectionManager;
import com.capgemini.connection.MySQLConnectionManager;
import com.capgemini.exception.InvalidQuery;
import com.capgemini.model.Customer;
import com.capgemini.model.OrderDetail;
import com.capgemini.model.Product;
import org.tinylog.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements RepositoryInterface<Customer> {

    ConnectionManager connectionManager = new MySQLConnectionManager();

    @Override
    public void deleteRow(String inputFromUser) throws InvalidQuery {
        try {
            String query = "delete from customers where customerNumber = ?";
            PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
            statement.setString(1, inputFromUser);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Your delete is done with success!");
            }
        } catch (SQLException e) {
            Logger.warn("Check you query or your parameters.");
            throw new InvalidQuery("You didn't enter a valid customer ID or the customer does not exist.");
        }
    }

    @Override
    public void updateRow(String inputFromUser) throws InvalidQuery {
        try {
            String query = "update customers set phone = '0712345678' where city = ?";
            PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
            statement.setString(1, inputFromUser);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Your update is done with success!");
            }
        } catch (SQLException e) {
            Logger.warn("Check you query or your parameters.");
            throw new InvalidQuery("You didn't enter a valid city or the city does not exist.");
        }
    }

    @Override
    public void insertRow() throws InvalidQuery {
        try {
            String query = "insert into customers values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
            statement.setString(1, "569");
            statement.setString(2, "Ribiana Petshop");
            statement.setString(3, "Muse");
            statement.setString(4, "John");
            statement.setString(5, "0739879871");
            statement.setString(6, "8489 Strong St.");
            statement.setString(7, "There is no other address");
            statement.setString(8, "San Rafael");
            statement.setString(9, "CA");
            statement.setString(10, "97562");
            statement.setString(11, "USA");
            statement.setString(12, "1165");
            statement.setString(13, "210500.00");
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("Your insert is done with success!");
            }
        } catch (SQLException e) {
            Logger.warn("Check you query or your parameters.");
            throw new InvalidQuery("You didn't enter the correct parameters or the object entered already exists.");
        }
    }

    @Override
    public List<OrderDetail> showOrdersAndProducts(String inputProductCode) {
        System.out.println("bin");
        return null;
    }

    @Override
    public void addRecord(Customer customer, ConnectionManager conn) throws InvalidQuery {

    }

    @Override
    public void executeInsertProduct_Order(Product product, OrderDetail orderDetail, ConnectionManager conn) throws InvalidQuery {

    }

    @Override
    public List<Customer> readFromDatabase() throws SQLException, InvalidQuery {
        List<Customer> customers;
        try {
            customers = new ArrayList<>();
            String query = "select * from customers;";
            PreparedStatement statement = connectionManager.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerNumber(resultSet.getString("customerNumber"));
                customer.setCustomerName(resultSet.getString("customerName"));
                customer.setContactLastName(resultSet.getString("contactLastName"));
                customer.setContactFirstName(resultSet.getString("contactFirstName"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setCity(resultSet.getString("city"));
                customers.add(customer);
            }
            for (Customer ods : customers) {
                System.out.println(ods.toString());
            }
        } catch (SQLException e) {
            Logger.warn("Check you query or your parameters.");
            throw new InvalidQuery("Your query is incorrect or could not be performed.");
        }
        return customers;
    }


}
