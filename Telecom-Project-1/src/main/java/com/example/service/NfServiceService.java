package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.NfService;
import com.example.repository.NfServiceRepo;

@Service
public class NfServiceService {

	@Autowired
	NfServiceRepo nfServiceRepo;
	
	
	/*
	 * public NfService saveNfService(NfService nfService) { return
	 * ResponseEntity.created(null).body(nfService); }
	 */
	public NfService saveNfService(NfService nfService) {
		return nfServiceRepo.save(nfService);
}
}
