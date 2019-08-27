package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "recommend")
public class Recommend {
	
	 @Id
	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id", updatable = false, nullable = false)
	 private int id;
	 
	 @Column(name = "name")
	    private String name;
	    
	    @Column(name = "url")
	    private String url;
	 
	    public Recommend(int id) {
		super();
		this.id = id;
	}

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return "Recommend [name=" + name + ", url=" + url + "]";
		}

		public Recommend(String name, String url) {
			super();
			this.name = name;
			this.url = url;
		}

		public Recommend() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
 

}
