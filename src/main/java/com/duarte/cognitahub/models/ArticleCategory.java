/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duarte.cognitahub.models;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;


@Entity
@Table(name = "Articles_has_category")
public class ArticleCategory {

    @EmbeddedId
    private ArticleCategoryId id = new ArticleCategoryId();

    @ManyToOne
    @MapsId("articleId")
    @JoinColumn(name = "idArticles")
    private Article article;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "idCategory")
    private Category category;

    
    public ArticleCategory() {}

    public ArticleCategory(Article article, Category category) {
        this.article = article;
        this.category = category;
        this.id = new ArticleCategoryId(article.getIdArticles(), category.getIdcategory());
    }
    
    public ArticleCategoryId getId() {
        return id;
    }

    public void setId(ArticleCategoryId id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
        this.id.setArticleId(article.getIdArticles());
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.id.setCategoryId(category.getIdcategory());
    }
    

}