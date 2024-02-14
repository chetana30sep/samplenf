package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.NetworkFunctionInstance;
import com.example.entity.NfProfile;
import com.example.entity.NfService;
import com.example.interceptors.RecordNotFoundException;
import com.example.service.NetworkFunctionInstanceService;
import com.example.service.NetworkFunctionInstanceServiceImpl;
import com.example.service.NfServiceService;
import com.example.util.MappingConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RestController
@RequestMapping(value = MappingConstants.networkFunctionInstanceUri)
public class NetworkFunctionInstanceController {
	

	Logger logger = LogManager.getLogger(NetworkFunctionInstanceController.class);
	@Autowired
	NetworkFunctionInstanceService networkFunctionInstanceService;
	
	@Autowired
	NfServiceService nfServiceService;


	@PostMapping(value = MappingConstants.save)
	public NetworkFunctionInstance saveNfInstance(@RequestBody NetworkFunctionInstance nfInstance) {
		NetworkFunctionInstance nf = networkFunctionInstanceService.saveNfInstance(nfInstance);
		
		NfProfile nfProfile1=nf.getNfProfile();
		
		List<NfService> nfServiceList = nfProfile1.getNfService();
		for(NfService nfs : nfServiceList) {
			nfs.setNfProfileId(nfProfile1.getNfProfileId());
			nfServiceService.saveNfService(nfs);

		}
		
		return nf;

	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<NetworkFunctionInstance> getNfInstance(@PathVariable ("id") String id) {
		NetworkFunctionInstance nf = networkFunctionInstanceService.getByID(id);
		if(nf==null) {
			throw new RecordNotFoundException();
		}else {
		   return ResponseEntity.ok(nf);
		}
	}
	
	@GetMapping("/getAll")
	public List<NetworkFunctionInstance> getAllEmployees() {
		return networkFunctionInstanceService.getAllNetworkFunctionInstance();
	}
	
	@PutMapping("/update/{id}")
	public NetworkFunctionInstance updateNfInstance(@RequestBody NetworkFunctionInstance nfInstance,@PathVariable ("id") String id) {
		return networkFunctionInstanceService.updateNfInstance(nfInstance,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteNfInstance(@PathVariable ("id") String id) {
		networkFunctionInstanceService.deleteNfInstance(id);
	}

}
