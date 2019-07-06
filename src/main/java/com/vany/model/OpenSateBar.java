package com.vany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
	private String createdAt;
	
	
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	/**
	 * @param bar the bar to set
	 */
	
	
	
	

}
