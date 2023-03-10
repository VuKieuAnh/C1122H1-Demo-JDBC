package com.example.demomcvc11.service.customer;

import com.example.demomcvc11.connection.ConnectionCMS;
import com.example.demomcvc11.model.Customer;
import com.example.demomcvc11.model.Province;
import com.example.demomcvc11.service.province.IProvinceService;
import com.example.demomcvc11.service.province.ProvinceService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceMySql implements CustomerService {
//    IProvinceService provinceService = new ProvinceService();


    @Override
    public List<Customer> findAll() {
        Connection connection = ConnectionCMS.getConnection();
        //b1:lay du lieu tu db
        if (
                connection != null
        ) {
            //chay query
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("select * from users");
                //luu lai ket qua
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Customer> customers = new ArrayList<>();
                //phan tich ket qua -> cau truc du lieu
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    Customer customer = new Customer(id, name, email, address);
                    customers.add(customer);
                }
                return customers;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void remove(int id) {

    }


}
