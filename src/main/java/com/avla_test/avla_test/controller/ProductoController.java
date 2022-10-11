package com.avla_test.avla_test.controller;

import com.avla_test.avla_test.model.Producto;
import com.avla_test.avla_test.service.ProductoService;
import com.avla_test.avla_test.service.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/add")
    public String add(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return "Nuevo producto agregado";
    }

    @GetMapping("/getAll")
    public List<Producto> getAllProductos(){
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable Integer id){
        try{
            Producto producto=productoService.get(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Integer id){
        try{
            Producto existingProducto=productoService.get(id);
            productoService.saveProducto(producto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        productoService.delete(id);
        return "Producto con id (" + id + "), eliminado";
    }
}
