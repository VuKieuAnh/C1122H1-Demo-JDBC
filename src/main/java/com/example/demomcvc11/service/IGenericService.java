package com.example.demomcvc11.service;

import com.example.demomcvc11.model.Customer;

import java.util.List;

public interface IGenericService<T> {
        List<T> findAll();

        void save(T customer);

        T findById(int id);

        void update(int id, T customer);

        void remove(int id);
}
