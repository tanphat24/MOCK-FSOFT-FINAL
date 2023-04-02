package com.example.taywebapplication.repository;

import com.example.taywebapplication.model.Product;
import com.example.taywebapplication.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select s from product as s where s.typeProduct =:id",nativeQuery = false)
    List<Product> getProductByIdTypeProduct(TypeProduct id);
    List<Product> findAllByTypeProduct(TypeProduct id);

    @Query(value = "select s from product as s where s.productName like %:productName%",nativeQuery = false)
    List<Product> findAllByNameProduct(@Param("productName") String productName);

}
