package com.vany.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name = "MainBar")
public class Bar {

	@Id
	@Column(name = "itemId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;

	@Column(name = "itemName")
	private String itemName;

	@Column(name = "itemQty")
	private Long itemQty;

	@Column(name ="itemPrice")
	private Double itemPrice;

	@Column(name = "itemCretated")
	private Date created;

	@Column(name = "itemUpdated")
	private Date updated;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	
	//Foregin Key 
	
	@OneToMany(mappedBy = "bar")
	private Set<OpenSateBar> openState =new HashSet<OpenSateBar>();
	
	@OneToMany(mappedBy = "bar")
	private Set<SalesStateBar> salesSateBar =new HashSet<SalesStateBar>();

	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemQty
	 */
	public Long getItemQty() {
		return itemQty;
	}

	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(Long itemQty) {
		this.itemQty = itemQty;
	}

	/**
	 * @return the itemPrice
	 */
	public Double getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<OpenSateBar> getOpenState() {
		return openState;
	}

	public void setOpenState(Set<OpenSateBar> openState) {
		this.openState = openState;
	}

	public Set<SalesStateBar> getSalesSateBar() {
		return salesSateBar;
	}

	public void setSalesSateBar(Set<SalesStateBar> salesSateBar) {
		this.salesSateBar = salesSateBar;
	}


	
		
	
}
