package com.example.news.controller;

import com.example.news.model.TypeNews;
import com.example.news.service.TypeNewsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type_news")
public class TypeNewsController {

    private final TypeNewsService typenewsService;

    public TypeNewsController(TypeNewsService typenewsService) {
        this.typenewsService = typenewsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TypeNews>> findAllTypeNews () {

        HttpHeaders headers = new HttpHeaders();

        List<TypeNews> typenewses = this.typenewsService.findAllTypeNews();

        if(typenewses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(typenewses, headers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TypeNews> findTypeNewsById (@PathVariable("id") Long id) {

        HttpHeaders headers = new HttpHeaders();

        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        TypeNews typenews = this.typenewsService.findTypeNewsById(id);

        if(typenews == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(typenews, headers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TypeNews> addTypeNews(@RequestBody TypeNews typenews) {

        HttpHeaders headers = new HttpHeaders();

        if(typenews == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //this.newsService.addNews(news);
        TypeNews newTypeNews = typenewsService.addTypeNews(typenews);

        return new ResponseEntity<>(newTypeNews, headers, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TypeNews> updateTypeNews(@RequestBody TypeNews typenews) {

        HttpHeaders headers = new HttpHeaders();

        if(typenews == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //this.newsService.updateNews(news);
        TypeNews updateTypeNews = typenewsService.updateTypeNews(typenews);

        return new ResponseEntity<>(updateTypeNews, headers, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTypeNewsById(@PathVariable("id") Long id) {

        //News news = this.newsService.findNewsById(id);

//        if(news == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        this.typenewsService.deleteTypeNewsById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
