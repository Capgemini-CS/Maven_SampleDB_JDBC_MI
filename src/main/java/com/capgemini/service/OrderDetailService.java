package com.capgemini.service;
import com.capgemini.connection.ConnectionManager;
import com.capgemini.exception.InvalidQuery;
import com.capgemini.model.OrderDetail;
import com.capgemini.repository.OrderDetailRepository;
import com.capgemini.repository.RepositoryInterface;
import com.capgemini.service.dto.OrderDetailDTO;
import com.capgemini.service.mapper.OrderDetailsMapper;
import org.tinylog.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailService {

    RepositoryInterface<OrderDetail> orderDetailRepositoryInterface;

    public OrderDetailService(RepositoryInterface<OrderDetail> orderDetailRepositoryInterface) {
        this.orderDetailRepositoryInterface = orderDetailRepositoryInterface;
    }

    public List<OrderDetailDTO> showAllOrdersWithPriceHigherThan100() throws InvalidQuery {
        try {
            return orderDetailRepositoryInterface.readFromDatabase().stream().map(OrderDetailsMapper::fromOrderDetailToOrderDetailDTO).collect(Collectors.toList());
        } catch (SQLException e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void insertOneOrderDetails() throws InvalidQuery {
        try {
            orderDetailRepositoryInterface.insertRow();
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void updateOnOrdersTable(String inputFromUser) throws InvalidQuery {
        try {
            orderDetailRepositoryInterface.updateRow(inputFromUser);
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void deleteOnOrdersTable(String inputFromUser) throws InvalidQuery {
        try {
            orderDetailRepositoryInterface.deleteRow(inputFromUser);
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void showOrdersByIdAndHisProducts(String inputProductCode) throws InvalidQuery {
        orderDetailRepositoryInterface.showOrdersAndProducts(inputProductCode);
    }

    public void insertOneOrderDetail(OrderDetailDTO orderDetailDTO, ConnectionManager conn) throws InvalidQuery {
        OrderDetail orderDetail = OrderDetailsMapper.fromOrderDetDTOtoOrderDetail(orderDetailDTO);
        try {
            orderDetailRepositoryInterface.addRecord(orderDetail, conn);
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }
}

