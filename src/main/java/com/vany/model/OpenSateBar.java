package com.vany.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "OpeningSatatement")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class OpenSateBar {
	
	@Id
	@Column(name = "openId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer openId;
	
	@Column(name = "openQty")
	private Long openQty;
	
	@Column(name = "OpeningDate")
	private Date createdAt;
	
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bar_item_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Bar bar;

	/**
	 * @return the openId
	 */
	public Integer getOpenId() {
		return openId;
	}

	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(Integer openId) {
		this.openId = openId;
	}

	
	public Long getOpenQty() {
		return openQty;
	}

	public void setOpenQty(Long openQty) {
		this.openQty = openQty;
	}

	/**
	 * @return the bar
	 */
	public Bar getBar() {
		return bar;
	}

	/**
	 * @param bar the bar to set
	 */
	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	

}
