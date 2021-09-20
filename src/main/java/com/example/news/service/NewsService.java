package com.example.news.service;

import com.example.news.model.News;
import com.example.news.repo.NewsRepo;
import com.example.news.exeption.NewsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NewsService {
    private final NewsRepo newsRepo;

    @Autowired
    public NewsService(NewsRepo newsRepo) { this.newsRepo = newsRepo; }

    //    Methods of create news
    public News addNews(News news) { return newsRepo.save(news); }

    //     Methods of read all news
    public List<News> findAllNews() { return newsRepo.findAll(); }

    //     Methods of write news
    public News updateNews(News news) {
        return newsRepo.save(news);
    }

    //     Methods of search news by id
    public News findNewsById(Long id) {
        return newsRepo.findNewsById(id)
                .orElseThrow(() -> new NewsNotFoundException("News by id " + id + " was not found"));
    }

    //     Methods of terminate news by id
    public void deleteNewsById(Long id){
        newsRepo.deleteNewsById(id);
    }

}
