package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

@Entity
public class NfProfile {

	@Id
	private String nfProfileId;

	@NotBlank(message = "The ip address is required.")
	@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$", message = "The ip address is invalid.")
	private String ipV4Addresses;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nfProfile")
	private List<NfService> nfService;

	public List<NfService> getNfService() {
		return nfService;
	}

	public void setNfService(List<NfService> nfService) {
		this.nfService = nfService;
	}

	public NfProfile() {
		super();
	}

	public NfProfile(String nfProfileId, String ipV4Addresses) {
		super();
		this.nfProfileId = nfProfileId;
		this.ipV4Addresses = ipV4Addresses;
	}

	public String getNfProfileId() {
		return nfProfileId;
	}

	public void setNfProfileId(String nfProfileId) {
		this.nfProfileId = nfProfileId;
	}

	public String getIpV4Addresses() {
		return ipV4Addresses;
	}

	public void setIpV4Addresses(String ipV4Addresses) {
		this.ipV4Addresses = ipV4Addresses;
	}

	@Override
	public String toString() {
		return "NfProfile [nfProfileId=" + nfProfileId + ", ipV4Addresses=" + ipV4Addresses + "]";
	}

}
