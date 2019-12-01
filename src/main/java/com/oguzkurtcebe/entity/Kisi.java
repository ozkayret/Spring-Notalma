package com.oguzkurtcebe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kisiler")
public class Kisi {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@Column(length=9999,name="adi")
private String ad;
private String soyad;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}
public String getSoyad() {
	return soyad;
}
public void setSoyad(String soyad) {
	this.soyad = soyad;
}


}
