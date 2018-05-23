package com.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Survey")
public class Surveys {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SurveySequence")
	@SequenceGenerator(allocationSize=1,name="SurveySequence",sequenceName="SQ_Survey_PK")
	@Column(name="Survey_ID")
	private int id;
	
	@Column(name="NAME")
	private String title;

	public Surveys(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public Surveys(String title) {
		super();
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Surveys [id=" + id + ", title=" + title + "]";
	}

}
