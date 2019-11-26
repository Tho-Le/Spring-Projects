package com.example.thole.webdeom.repositories;

import com.example.thole.webdeom.model.Books;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Books, Long> {

}
