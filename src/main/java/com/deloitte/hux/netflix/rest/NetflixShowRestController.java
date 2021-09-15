package com.deloitte.hux.netflix.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.hux.netflix.entity.NetflixShow;
import com.deloitte.hux.netflix.service.NetflixService;

@RestController
@RequestMapping("/api")
public class NetflixShowRestController {

	@Autowired
	private NetflixService netflixService ;
	
	@PostMapping("/shows")
	public NetflixShow addShow(@RequestBody NetflixShow netflixShow, @RequestParam String storageType) {
		netflixService.addARecordToNetflixShow(netflixShow, storageType);
		return netflixShow;
	}
	
	@PostMapping("/shows/import/csv")
	public void importCSV(@RequestParam("file") MultipartFile file) {
		netflixService.addCsvToNetflixShow(file);
	}

}
