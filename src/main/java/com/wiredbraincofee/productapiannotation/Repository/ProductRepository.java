package com.wiredbraincofee.productapiannotation.Repository;

import com.wiredbraincofee.productapiannotation.Model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}
