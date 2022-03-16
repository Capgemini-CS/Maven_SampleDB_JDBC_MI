package com.capgemini.repository;

import com.capgemini.connection.ConnectionManager;
import com.capgemini.exception.InvalidQuery;
import com.capgemini.model.OrderDetail;
import com.capgemini.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryInterface<T> {
    List<T> readFromDatabase() throws SQLException, InvalidQuery;

    void deleteRow(String inputFromUser) throws InvalidQuery;

    void updateRow(String inputFromUser) throws InvalidQuery;

    void insertRow() throws InvalidQuery;

    List<OrderDetail> showOrdersAndProducts(String inputProductCode) throws InvalidQuery;

    void addRecord(T t, ConnectionManager conn) throws InvalidQuery;

    void executeInsertProduct_Order(Product product, OrderDetail orderDetail, ConnectionManager conn) throws InvalidQuery;

}

