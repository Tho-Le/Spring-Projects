package com.example.thole.webdeom.Bootstrap;

import com.example.thole.webdeom.model.Author;
import com.example.thole.webdeom.model.Book;
import com.example.thole.webdeom.model.Publisher;
import com.example.thole.webdeom.repositories.AuthorRepository;
import com.example.thole.webdeom.repositories.BookRepository;
import com.example.thole.webdeom.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher penguin = new Publisher("Penguin", "Amarillo");
        publisherRepository.save(penguin);
        Book lastOfUs = new Book("Last Of Us", "4444", penguin);
        eric.getBooks().add(lastOfUs);
        lastOfUs.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(lastOfUs);


        Author grim = new Author("Da", "Wild");
        Publisher vantos = new Publisher("Vantos", "Dallas");
        publisherRepository.save(vantos);
        Book coolOrCruel = new Book("Cool Or Cruel", "2123", vantos);
        grim.getBooks().add(coolOrCruel);
        coolOrCruel.getAuthors().add(grim);



        authorRepository.save(grim);
        bookRepository.save(coolOrCruel);

    }
}
