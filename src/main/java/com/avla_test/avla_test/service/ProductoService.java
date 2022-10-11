package com.avla_test.avla_test.service;

import com.avla_test.avla_test.model.Producto;

import java.util.List;

public interface ProductoService {
    public Producto saveProducto(Producto producto);
    public List<Producto> getAllProductos();
    public Producto get(Integer id);
    public void delete(Integer id);
}
