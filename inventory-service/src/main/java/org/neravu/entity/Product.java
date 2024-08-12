package org.neravu.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String decsription;
	private Integer stock;
	private Double price;
	private String category;
	

	public Product(String name, String decsription, Integer stock, Double price, String category) {
		super();
		this.name = name;
		this.decsription = decsription;
		this.stock = stock;
		this.price = price;
		this.category = category;
	}
}
