package com.xiaofu.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Author")
@Entity
public class Author {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Integer id;
	@Column(name="name")
	private String name;
	@OneToMany
	private List<Article> articleList;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Integer id, String name, List<Article> articleList) {
		super();
		this.id = id;
		this.name = name;
		this.articleList = articleList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	
}
