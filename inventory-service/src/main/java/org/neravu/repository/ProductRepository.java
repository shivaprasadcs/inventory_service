package org.neravu.repository;

import java.util.List;

import org.neravu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	List<Product> findByCategory(String category);

}
