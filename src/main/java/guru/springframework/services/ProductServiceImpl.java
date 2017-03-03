package guru.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired // to inject an instance of the Spring Data JPA repository into the implementation of our product service
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll(); //it is defined in CrudRepository (implemented for us by Spring Data JPA)
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id); //To fetch a product by its id value (implemented for us by Spring Data JPA)
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product); //Spring Data JPA also provides us an implementation of a save method for saving entities
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.delete(id); //Spring Data JPA provides us an implementation of a delete method.
    }

}
