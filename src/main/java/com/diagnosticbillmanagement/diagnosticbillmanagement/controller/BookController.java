package com.diagnosticbillmanagement.diagnosticbillmanagement.controller;

import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Book;
import com.diagnosticbillmanagement.diagnosticbillmanagement.entity.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @GetMapping("/home")
    public String home() {
        return "admin/test_ajax";
    }

    List<Book> bookStore = new ArrayList<>();

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Book addBook(@RequestBody Book book) {
        bookStore.add(book);
//        ServiceResponse<Book> response = new ServiceResponse<Book>("success", book);
        return book;
    }

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Book> getAllBooks() {
        return bookStore;
    }
}
