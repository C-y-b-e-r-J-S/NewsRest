package com.example.news.controller;

import com.example.news.model.News;
import com.example.news.service.NewsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<News>>findAllNews () {

        HttpHeaders headers = new HttpHeaders();

        List<News> newses = this.newsService.findAllNews();

        if(newses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(newses, headers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<News> findNewsById (@PathVariable("id") Long id) {

        HttpHeaders headers = new HttpHeaders();

        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        News news = this.newsService.findNewsById(id);

        if(news == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(news, headers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<News> addNews(@RequestBody News news) {

        HttpHeaders headers = new HttpHeaders();

        if(news == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //this.newsService.addNews(news);
        News newNews = newsService.addNews(news);

        return new ResponseEntity<>(newNews, headers, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<News> updateNews(@RequestBody News news) {

        HttpHeaders headers = new HttpHeaders();

        if(news == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //this.newsService.updateNews(news);
        News updateNews = newsService.updateNews(news);

        return new ResponseEntity<>(updateNews, headers, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNewsById(@PathVariable("id") Long id) {

        //News news = this.newsService.findNewsById(id);

//        if(news == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        this.newsService.deleteNewsById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
