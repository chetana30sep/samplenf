package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.NetworkFunctionInstance;
import com.example.entity.NfService;
import com.example.interceptors.RecordNotFoundException;
import com.example.repository.NetworkFunctionInstanceRepo;

@Service
public class NetworkFunctionInstanceServiceImpl implements NetworkFunctionInstanceService {

	@Autowired
	NetworkFunctionInstanceRepo networkFunctionInstanceRepo;

	public NetworkFunctionInstance saveNfInstance(NetworkFunctionInstance nfInstance) {
		return networkFunctionInstanceRepo.save(nfInstance);
	}

	public NetworkFunctionInstance getByID(String id) {
		return networkFunctionInstanceRepo.findById(id).get();
	}

	public NetworkFunctionInstance updateNfInstance(NetworkFunctionInstance nfInstance, String nfInstanceId) {
		if (networkFunctionInstanceRepo.existsById(nfInstanceId)) {
			NetworkFunctionInstance existing = networkFunctionInstanceRepo.findById(nfInstanceId).get();
			if (nfInstance.getNetworkFunctionInstanceType() != null) {
				existing.setNetworkFunctionInstanceType(nfInstance.getNetworkFunctionInstanceType());
			}
			if (nfInstance.getHeartBeatTimer() > 0) {
				existing.setHeartBeatTimer(nfInstance.getHeartBeatTimer());
			}
			if (nfInstance.getNfProfile().getIpV4Addresses() != null) {
				existing.getNfProfile().setIpV4Addresses(nfInstance.getNfProfile().getIpV4Addresses());//192.123.123.123 ---> 192.111.111.111
			}
			List<NfService> nfServices = nfInstance.getNfProfile().getNfService();//request
			List<NfService> existingNfServices = existing.getNfProfile().getNfService();
			if (nfInstance.getNfProfile().getNfService() != null) {

				for (int i = 0; i < nfServices.size(); i++) {
					if (nfServices.get(i).getNfServiceName() != null) {
						existingNfServices.get(i).setNfServiceName(nfServices.get(i).getNfServiceName());
					}
					if (nfServices.get(i).getNfServiceStatus() != null) {
						existingNfServices.get(i).setNfServiceStatus(nfServices.get(i).getNfServiceStatus());
					}
					if (nfServices.get(i).getApiFullVersion() != null) {
						existingNfServices.get(i).setApiFullVersion(nfServices.get(i).getApiFullVersion());
					}
					if (nfServices.get(i).getScheme() != null) {
						existingNfServices.get(i).setScheme(nfServices.get(i).getScheme());
					}
				}
			}
			existing.getNfProfile().setNfService(existingNfServices);
			return networkFunctionInstanceRepo.save(existing);
		} else {
			return null;
		}
	}

	@Override
	public void deleteNfInstance(String id) {
		Optional<NetworkFunctionInstance> nf = networkFunctionInstanceRepo.findById(id);

		if (nf.isPresent()) {
			networkFunctionInstanceRepo.deleteById(id);// getbyid
		} else {
			throw new RecordNotFoundException();
		}

	}

	@Override
	public List<NetworkFunctionInstance> getAllNetworkFunctionInstance() {
		// TODO Auto-generated method stub
		return networkFunctionInstanceRepo.findAll();
	}

}
