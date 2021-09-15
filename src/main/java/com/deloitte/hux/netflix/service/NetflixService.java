package com.deloitte.hux.netflix.service;


import org.springframework.web.multipart.MultipartFile;

import com.deloitte.hux.netflix.entity.NetflixShow;

public interface NetflixService {

	public void addCsvToNetflixShow(MultipartFile file);
	public void addARecordToNetflixShow(NetflixShow netflixShow, String storageType);

}
