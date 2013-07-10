package com.Dao;

/**
 * ResultId entity. @author MyEclipse Persistence Tools
 */

public class ResultId implements java.io.Serializable {

	// Fields

	private String tid;
	private String did;

	// Constructors

	/** default constructor */
	public ResultId() {
	}

	/** full constructor */
	public ResultId(String tid, String did) {
		this.tid = tid;
		this.did = did;
	}

	// Property accessors

	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ResultId))
			return false;
		ResultId castOther = (ResultId) other;

		return ((this.getTid() == castOther.getTid()) || (this.getTid() != null
				&& castOther.getTid() != null && this.getTid().equals(
				castOther.getTid())))
				&& ((this.getDid() == castOther.getDid()) || (this.getDid() != null
						&& castOther.getDid() != null && this.getDid().equals(
						castOther.getDid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTid() == null ? 0 : this.getTid().hashCode());
		result = 37 * result
				+ (getDid() == null ? 0 : this.getDid().hashCode());
		return result;
	}

}