package net.jamesdaniel.cms.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the systems database table.
 * 
 */
@Entity
@Table(name="systems")
public class Systems implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="system_id")
	private String systemId;

	@Column(name="create_dt")
	private String createDt;

	@Column(name="system_desc")
	private String systemDesc;

	@Column(name="system_name")
	private String systemName;

	@Column(name="update_dt")
	private String updateDt;

	public Systems() {
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getSystemDesc() {
		return this.systemDesc;
	}

	public void setSystemDesc(String systemDesc) {
		this.systemDesc = systemDesc;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

}