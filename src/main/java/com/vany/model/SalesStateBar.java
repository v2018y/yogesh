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
@Table(name = "SalesStatement")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class SalesStateBar {
	@Id
	@Column(name = "SalesId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer salesId;
	
	@Column(name = "salesQty")
	private Long salesQty;
	
	@Column(name = "salesDate")
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
	 * @return the salesId
	 */
	public Integer getSalesId() {
		return salesId;
	}

	/**
	 * @param salesId the salesId to set
	 */
	public void setSalesId(Integer salesId) {
		this.salesId = salesId;
	}

	/**
	 * @return the salesQty
	 */
	public Long getSalesQty() {
		return salesQty;
	}

	/**
	 * @param salesQty the salesQty to set
	 */
	public void setSalesQty(Long salesQty) {
		this.salesQty = salesQty;
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
