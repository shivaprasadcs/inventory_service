package org.neravu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication {

	/*
	 * @Autowired private ProductRepository productRepository;
	 * 
	 * @PostConstruct public void initDB() { List<Product> products= Stream.of( new
	 * Product("Laptop","DELL INSPIRON",100, 75000.00 , "Electronics" ) , new
	 * Product("Mobile","SAMSUNG S24",80, 75000.00 , "Electronics" ) , new
	 * Product("TABLET","APPLE",100, 175000.00 , "Electronics" ) , new
	 * Product("NoteBook","Furniture",1000, 75.00 , "Furniture" ) , new
	 * Product("Desk Lamp","Furniture",900, 250.00 , "Furniture" )
	 * ).collect(Collectors.toList());
	 * 
	 * productRepository.saveAll(products); }
	 */
	
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
