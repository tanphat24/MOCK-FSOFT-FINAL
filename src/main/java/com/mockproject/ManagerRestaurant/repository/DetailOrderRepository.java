package com.mockproject.ManagerRestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mockproject.ManagerRestaurant.model.DetailOrder;

@Repository
public interface DetailOrderRepository extends JpaRepository<DetailOrder, Integer>{
	@Query(value = "select * from detail_order d  where d.ORDER_TABLE_ID=:id and d.STATUS=0", nativeQuery = true)
	List<DetailOrder> getListDetailOrderByOrderTableId(@Param("id")Integer id);
	
	@Query(value = "select d.* from detail_order d  where d.ORDER_TABLE_ID=:idOrderTable and d.PRODUCT_ID=:idProduct and d.STATUS=0", nativeQuery = true)
	List<DetailOrder> checkDetailOrder(int idOrderTable, int idProduct);
}
