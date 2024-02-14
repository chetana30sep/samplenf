package com.example.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NfService {

	@Id
	private String nfServiceId;

	@Enumerated(EnumType.STRING)
	private Scheme scheme;

	private String apiFullVersion;

	@Enumerated(EnumType.STRING)
	private NFServiceStatus nfServiceStatus;

	@Enumerated(EnumType.STRING)
	private NFServiceName nfServiceName;

	@JsonIgnore
	@JoinColumn(name = "nfProfileId", insertable = false, updatable = false)
	@ManyToOne
	private NfProfile nfProfile;

	@Column(name = "nfProfileId")
	private String nfProfileId;

	public NfProfile getNfProfile() {
		return nfProfile;
	}

	public void setNfProfile(NfProfile nfProfile) {
		this.nfProfile = nfProfile;
	}

	public String getNfProfileId() {
		return nfProfileId;
	}

	public void setNfProfileId(String nfProfileId) {
		this.nfProfileId = nfProfileId;
	}

	public NfService() {
		super();
	}

	public NfService(String nfServiceId, Scheme scheme, String apiFullVersion, NFServiceStatus nfServiceStatus,
			NFServiceName nfServiceName) {
		super();
		this.nfServiceId = nfServiceId;
		this.scheme = scheme;
		this.apiFullVersion = apiFullVersion;
		this.nfServiceStatus = nfServiceStatus;
		this.nfServiceName = nfServiceName;
	}

	public String getNfServiceId() {
		return nfServiceId;
	}

	public void setNfServiceId(String nfServiceId) {
		this.nfServiceId = nfServiceId;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public String getApiFullVersion() {
		return apiFullVersion;
	}

	public void setApiFullVersion(String apiFullVersion) {
		this.apiFullVersion = apiFullVersion;
	}

	public NFServiceStatus getNfServiceStatus() {
		return nfServiceStatus;
	}

	public void setNfServiceStatus(NFServiceStatus nfServiceStatus) {
		this.nfServiceStatus = nfServiceStatus;
	}

	public NFServiceName getNfServiceName() {
		return nfServiceName;
	}

	public void setNfServiceName(NFServiceName nfServiceName) {
		this.nfServiceName = nfServiceName;
	}

	@Override
	public String toString() {
		return "NfService [nfServiceId=" + nfServiceId + ", scheme=" + scheme + ", apiFullVersion=" + apiFullVersion
				+ ", nfServiceStatus=" + nfServiceStatus + ", nfServiceName=" + nfServiceName + "]";
	}

}
