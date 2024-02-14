package com.example.service;

import java.util.List;

import com.example.entity.NetworkFunctionInstance;

public interface NetworkFunctionInstanceService {
	public NetworkFunctionInstance saveNfInstance(NetworkFunctionInstance nfInstance);
	public NetworkFunctionInstance getByID(String id);
	public NetworkFunctionInstance updateNfInstance(NetworkFunctionInstance nfInstance, String nfInstanceId) ;
	public void deleteNfInstance(String id);
	public List<NetworkFunctionInstance> getAllNetworkFunctionInstance();
}
