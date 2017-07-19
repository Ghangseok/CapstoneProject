package net.jamesdaniel.cms.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="Customers")
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="password")
	private String password;

	@Column(name="address_detailed")
	private String addressDetailed;

	private String city;

	@Column(name="contact_no")
	private String contactNo;

	private String country;

	@Column(name="create_dt")
	private String createDt;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="postal_code")
	private String postalCode;

	private String province;
	
	@Column(name="current_flag")
	private String currentFlag;

	public String getCurrentFlag() {
		return currentFlag;
	}

	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}

	@Column(name="update_dt")
	private String updateDt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "system_customers",
			joinColumns = { @JoinColumn(name = "customer_id") },
			inverseJoinColumns = { @JoinColumn(name="system_id")}
	)
	private Set<Systems> systems = new HashSet<Systems>();

	public Set<Systems> getSystems() {
		return systems;
	}

	public void setSystems(Set<Systems> systems) {
		this.systems = systems;
	}

	public Customers() {
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddressDetailed() {
		return this.addressDetailed;
	}

	public void setAddressDetailed(String addressDetailed) {
		this.addressDetailed = addressDetailed;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

}