package com.example.news.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "type_news")
public class TypeNews implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(name = "nametype", nullable = false)
    private String nameType;

    @Column(name = "colortype", nullable = false)
    private String colorType;

    public TypeNews() {}

    public TypeNews(Long id, String nameType, String colorType) {
        this.id = id;
        this.nameType = nameType;
        this.colorType = colorType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    @Override
    public String toString() {
        return "typeNews{" +
                "id=" + id +
                ", nameType='" + nameType + '\'' +
                ", colorType='" + colorType + '\'' +
                '}';
    }
}
