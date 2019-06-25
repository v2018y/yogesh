package com.vany.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "employee_tabel")
public class Bar {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer item_id;

	@Column(name = "item_name")
	private String item_name;

	@Column(name = "item_qty")
	private Long item_qty;

	@Column(name = "item_price")
	private Double item_price;

	@Column(name = "item_cretated")
	private Date created;

	@Column(name = "item_updated")
	private Date updated;

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	/**
	 * @return the item_id
	 */
	public Integer getItem_id() {
		return item_id;
	}

	/**
	 * @param item_id the item_id to set
	 */
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}

	/**
	 * @return the item_name
	 */
	public String getItem_name() {
		return item_name;
	}

	/**
	 * @param item_name the item_name to set
	 */
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	/**
	 * @return the item_qty
	 */
	public Long getItem_qty() {
		return item_qty;
	}

	/**
	 * @param item_qty the item_qty to set
	 */
	public void setItem_qty(Long item_qty) {
		this.item_qty = item_qty;
	}

	/**
	 * @return the item_price
	 */
	public Double getItem_price() {
		return item_price;
	}

	/**
	 * @param item_price the item_price to set
	 */
	public void setItem_price(Double item_price) {
		this.item_price = item_price;
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

	
	
	
}
