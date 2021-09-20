package com.example.news.service;

import com.example.news.exeption.TypeNewsNotFoundException;
import com.example.news.model.TypeNews;
import com.example.news.repo.TypeNewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeNewsService {
    private final TypeNewsRepo typeNewsRepo;

    @Autowired
    public TypeNewsService(TypeNewsRepo typeNewsRepo) {
        this.typeNewsRepo = typeNewsRepo;
    }

    //    Methods of create news and create type news
    public TypeNews addTypeNews(TypeNews typeNews) { return typeNewsRepo.save(typeNews); }

    //     Methods of read all news and read all type news
    public List<TypeNews> findAllTypeNews() { return typeNewsRepo.findAll(); }

    //     Methods of write news and write type news by id
    public TypeNews updateTypeNews(TypeNews typeNews) { return typeNewsRepo.save(typeNews); }

    //     Methods of search news and search type news by id
    public  TypeNews findTypeNewsById(Long id) {
        return typeNewsRepo.findTypeNewsById(id)
                .orElseThrow(()-> new TypeNewsNotFoundException("Type News by id " + id + " was not found"));
    }

    //     Methods of terminate news and terminate type news for id
    public void deleteTypeNewsById(Long id) { typeNewsRepo.deleteTypeNewsById(id); }

}
