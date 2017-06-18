package net.jamesdaniel.cms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the system_customers database table.
 * 
 */
@Entity
@Table(name="system_customers")
public class SystemCustomers implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SystemCustomersPK id;

	@Column(name="create_dt")
	private String createDt;

	@Column(name="join_dt")
	private String joinDt;

	@Column(name="update_dt")
	private String updateDt;

	@Column(name="withdraw_dt")
	private String withdrawDt;

	public SystemCustomers() {
	}

	public SystemCustomersPK getId() {
		return this.id;
	}

	public void setId(SystemCustomersPK id) {
		this.id = id;
	}

	public String getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getJoinDt() {
		return this.joinDt;
	}

	public void setJoinDt(String joinDt) {
		this.joinDt = joinDt;
	}

	public String getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public String getWithdrawDt() {
		return this.withdrawDt;
	}

	public void setWithdrawDt(String withdrawDt) {
		this.withdrawDt = withdrawDt;
	}

}