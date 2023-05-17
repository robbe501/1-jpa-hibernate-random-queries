package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Store.getNumStaffPerStore", query = "SELECT a.address, COUNT(st.firstName) FROM Store s JOIN s.staffs st JOIN s.address a GROUP BY a.address"),
		@NamedQuery(name = "Store.getStorePerCustomerInCountry", query = "SELECT s.storeId FROM Store s JOIN s.customers c JOIN c.address a JOIN a.city ci JOIN ci.country co WHERE co.country = :country"), })

public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Integer storeId;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	@Column(name = "manager_staff_id")
	private byte managerStaffId;

	// bi-directional many-to-one association to Staff
	@OneToMany(mappedBy = "store")
	private List<Staff> staffs;

	// bi-directional many-to-one association to Staff
	@OneToMany(mappedBy = "store")
	private List<Customer> customers;

	// bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;

	public Store() {
	}

	public Store(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public byte getManagerStaffId() {
		return this.managerStaffId;
	}

	public void setManagerStaffId(byte managerStaffId) {
		this.managerStaffId = managerStaffId;
	}

	public List<Staff> getStaffs() {
		return this.staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public Staff addStaff(Staff staff) {
		getStaffs().add(staff);
		staff.setStore(this);

		return staff;
	}

	public Staff removeStaff(Staff staff) {
		getStaffs().remove(staff);
		staff.setStore(null);

		return staff;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}