package com.mockproject.ManagerRestaurant.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mockproject.ManagerRestaurant.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
	
	@Query(value = "select c.user_name from user c inner join order_table o on o.customer_o_id = c.user_id inner join bill b on b.order_table_b_id = o.order_table_id where b.order_table_b_id = :id", nativeQuery = true)
	String getName(Integer id);
	
	@Query(value = "Select b.* from bill b inner join order_table o on o.order_table_id = b.order_table_b_id inner join user c on c.user_id = o.customer_o_id where c.user_name like %:name%",nativeQuery = true)
	List<Bill> getListBill(String name);
	
	@Query(value = "Select distinct b.bill_status from bill b", nativeQuery = true)
	List<String>  getStatus();
	@Query(value = "select * from bill b where b.bill_status = :billStatus", nativeQuery = true)
	List<Bill> findByBillStatus(String billStatus);
	@Query(value = "select * from bill b where b.bill_id = :billId", nativeQuery = true)
	Bill findByBillId(int billId);
	@Query(value = "select * from detail_order d where d.order_table_id = :id",nativeQuery = true)
	List<String> findProduct(int id);
	@Query(value = "Select * from product p where p.product_id =:id",nativeQuery = true)
	String getProductById(int id);
}
