package com.avla_test.avla_test.service;

import com.avla_test.avla_test.model.Producto;
import com.avla_test.avla_test.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto get(Integer id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }
}
