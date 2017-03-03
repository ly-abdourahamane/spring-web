package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.springframework.data.repository.CrudRepository;
 
public interface ProductRepository extends CrudRepository<Product, Integer>{
	//extend the Spring Data JPA CrudRepository to create our Product Repository. 
	//We did not define, nor implement an additional methods. 
	//We’re not declaring transactions. We’re not writing any SQL. 
	//see the simplicity and time saving using tools like Spring Data JPA can bring you.
}
