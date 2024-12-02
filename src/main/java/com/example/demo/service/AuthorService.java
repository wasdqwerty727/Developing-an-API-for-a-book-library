package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(authorDetails.getName());
            author.setBirthDate(authorDetails.getBirthDate());
            return authorRepository.save(author);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}