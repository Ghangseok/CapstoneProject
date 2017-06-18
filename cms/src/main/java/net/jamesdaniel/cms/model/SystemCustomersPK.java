package net.jamesdaniel.cms.model;


import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the system_customers database table.
 * 
 */
@Embeddable
public class SystemCustomersPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="system_id")
	private String systemId;

	@Column(name="customer_id")
	private String customerId;

	public SystemCustomersPK() {
	}
	public String getSystemId() {
		return this.systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SystemCustomersPK)) {
			return false;
		}
		SystemCustomersPK castOther = (SystemCustomersPK)other;
		return 
			this.systemId.equals(castOther.systemId)
			&& this.customerId.equals(castOther.customerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.systemId.hashCode();
		hash = hash * prime + this.customerId.hashCode();
		
		return hash;
	}
}
