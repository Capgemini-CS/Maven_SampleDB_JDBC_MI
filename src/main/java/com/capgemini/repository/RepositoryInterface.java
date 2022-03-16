package com.capgemini.repository;

import com.capgemini.exception.InvalidQuery;
import com.capgemini.model.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryInterface<T> {
    List<T> readFromDatabase() throws SQLException, InvalidQuery;

    void deleteRow(String inputFromUser) throws InvalidQuery;

    void updateRow(String inputFromUser) throws InvalidQuery;

    void insertRow() throws InvalidQuery;

    List<OrderDetail> showOrdersAndProducts(String inputProductCode) throws InvalidQuery;
}

