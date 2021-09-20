package com.example.news.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "namenews", nullable = false)
    private String nameNews;

    @Column(name = "prenews", nullable = false)
    private String preNews;
    @Column(name = "fullnews", nullable = false)
    private String fullNews;

    public News() {}

    public News(Long id, String nameNews, String preNews, String fullNews) {
        this.id = id;
        this.nameNews = nameNews;
        this.preNews = preNews;
        this.fullNews = fullNews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameNews() {
        return nameNews;
    }

    public void setNameNews(String nameNews) {
        this.nameNews = nameNews;
    }

    public String getPreNews() {
        return preNews;
    }

    public void setPreNews(String preNews) {
        this.preNews = preNews;
    }

    public String getFullNews() {
        return fullNews;
    }

    public void setFullNews(String fullNews) {
        this.fullNews = fullNews;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", nameNews='" + nameNews + '\'' +
                ", preNews='" + preNews + '\'' +
                ", fullNews='" + fullNews + '\'' +
                '}';
    }
}
