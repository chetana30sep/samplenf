package com.example.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
public class NetworkFunctionInstance {

	@Id
	private String networkFunctionInstanceId;

	@Enumerated(EnumType.STRING)
	private NetworkFunctionInstanceType networkFunctionInstanceType;

	// @NotNull(message = "The full name is required.")
	@NotEmpty(message = "The test is required.")
	
	//@Max(10)
	private String test;

	@Enumerated(EnumType.STRING)

	private NfStatus status;

	@Min(5)
	
	private int heartBeatTimer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_nfProfileId")
	@Valid
	private NfProfile nfProfile;

	public NfProfile getNfProfile() {
		return nfProfile;
	}

	public void setNfProfile(NfProfile nfProfile) {
		this.nfProfile = nfProfile;
	}

	public NetworkFunctionInstance() {
		super();
	}

	public NetworkFunctionInstance(String networkFunctionInstanceId,
			NetworkFunctionInstanceType networkFunctionInstanceType, NfStatus status, int heartBeatTimer,
			NfProfile nfProfile) {
		super();
		this.networkFunctionInstanceId = networkFunctionInstanceId;
		this.networkFunctionInstanceType = networkFunctionInstanceType;
		this.status = status;
		this.heartBeatTimer = heartBeatTimer;
		this.nfProfile = nfProfile;
	}

	public String getNetworkFunctionInstanceId() {
		return networkFunctionInstanceId;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public void setNetworkFunctionInstanceId(String networkFunctionInstanceId) {
		this.networkFunctionInstanceId = networkFunctionInstanceId;
	}

	public NetworkFunctionInstanceType getNetworkFunctionInstanceType() {
		return networkFunctionInstanceType;
	}

	public void setNetworkFunctionInstanceType(NetworkFunctionInstanceType networkFunctionInstanceType) {
		this.networkFunctionInstanceType = networkFunctionInstanceType;
	}

	public NfStatus getStatus() {
		return status;
	}

	public void setStatus(NfStatus status) {
		this.status = status;
	}

	public int getHeartBeatTimer() {
		return heartBeatTimer;
	}

	public void setHeartBeatTimer(int heartBeatTimer) {
		this.heartBeatTimer = heartBeatTimer;
	}

	@Override
	public String toString() {
		return "NetworkFunctionInstance [networkFunctionInstanceId=" + networkFunctionInstanceId
				+ ", networkFunctionInstanceType=" + networkFunctionInstanceType + ", status=" + status
				+ ", heartBeatTimer=" + heartBeatTimer + "]";
	}

}
