package com.capgemini.service;

import com.capgemini.connection.ConnectionManager;
import com.capgemini.exception.InvalidQuery;
import com.capgemini.model.OrderDetail;
import com.capgemini.model.Product;
import com.capgemini.repository.ProductRepository;
import com.capgemini.repository.RepositoryInterface;
import com.capgemini.service.dto.ProductDTO;
import com.capgemini.service.mapper.ProductMapper;
import org.tinylog.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    RepositoryInterface<Product> productRepositoryInterface;

    public ProductService(RepositoryInterface<Product> productRepositoryInterface) {
        this.productRepositoryInterface = productRepositoryInterface;
    }

    public List<ProductDTO> showAllProductsByProductLine() throws InvalidQuery {
        try {
            return productRepositoryInterface.readFromDatabase().stream().map(ProductMapper::fromProductToProductDTO).collect(Collectors.toList());
        } catch (SQLException e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void insertOneProduct() throws InvalidQuery {
        try {
            productRepositoryInterface.insertRow();
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void updateProducts(String inputFromUser) throws InvalidQuery {
        try {
            productRepositoryInterface.updateRow(inputFromUser);
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void deleteProducts(String inputFromUser) throws InvalidQuery {
        try {
            productRepositoryInterface.deleteRow(inputFromUser);
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void insertProductToDB(ProductDTO productDTO, ConnectionManager conn) throws InvalidQuery {
        Product product = ProductMapper.fromProductDtoTOProduct(productDTO);
        try {
            productRepositoryInterface.addRecord(product,conn);
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }

    public void insertProductAndOrderDetail(Product product, OrderDetail orderDetail, ConnectionManager conn) throws InvalidQuery {
        try {
            productRepositoryInterface.executeInsertProduct_Order(product, orderDetail, conn);
        } catch (InvalidQuery e) {
            Logger.error("Check you query or your parameters.");
            throw new InvalidQuery("Sorry. Your method didn't work.");
        }
    }


//    public List<Product> showTheAverageValueByProductLine() throws InvalidQuery {
//        return productRepositoryInterface.showTheAverageValue();
//    }
}
