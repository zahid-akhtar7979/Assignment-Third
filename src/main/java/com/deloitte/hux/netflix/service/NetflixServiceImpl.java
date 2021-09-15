package com.deloitte.hux.netflix.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.hux.netflix.dao.NetflixDao;
import com.deloitte.hux.netflix.entity.NetflixShow;
import com.deloitte.hux.netflix.utilities.NetflixUtilities;

@Service
public class NetflixServiceImpl implements NetflixService {
	
	private NetflixDao netflixDao;
	
	@Autowired
	public NetflixServiceImpl(NetflixDao netflixDao) {
		this.netflixDao = netflixDao;
	}

	@Override
	@Transactional
	public void addCsvToNetflixShow(MultipartFile file) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
			
			Map<String, Integer>keyToIndexMap = new HashMap<String, Integer>();
			String firstLine = br.readLine();;
			List<String> dataFields = NetflixUtilities.splitString(firstLine);
			
			for(int i = 0; i < dataFields.size(); i++) {
				keyToIndexMap.put(dataFields.get(i), i);
			}
			
			String line = null;
			while ((line = br.readLine()) != null) {

				List<String> dataList = NetflixUtilities.splitString(line);
				System.out.println("dataList is "+dataList);
				NetflixShow netflixShow = NetflixUtilities.populateNetflixShow(dataList, keyToIndexMap);
				System.out.println("netflixShow is "+netflixShow);
				
				if(netflixShow != null) {
					netflixDao.addARecordToNetflixShow(netflixShow);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void addARecordToNetflixShow(NetflixShow netflixShow, String storageType) {
		
		try {
			
			if(storageType.equals("csv")) {
				
				//add to csv
				Resource resource = new ClassPathResource("/static/netflix_titles_new.csv");
				
				FileWriter csvWriter = new FileWriter(resource.getURI().getPath(),true); 
				csvWriter.append(netflixShow.getShowId() + ",");
				csvWriter.append(netflixShow.getType() + ",");
				csvWriter.append(netflixShow.getTitle() + ",");
				csvWriter.append(netflixShow.getDirector() + ",");
				csvWriter.append(netflixShow.getCast() + ",");
				csvWriter.append(netflixShow.getCountry() + ",");
				csvWriter.append(netflixShow.getDateAdded() + ",");
				csvWriter.append(netflixShow.getReleaseYear() + ",");
				csvWriter.append(netflixShow.getRating() + ",");
				csvWriter.append(netflixShow.getDuration() + ",");
				csvWriter.append(netflixShow.getListedIn() + ",");
				csvWriter.append(netflixShow.getDescription());
				csvWriter.append("\n");

				csvWriter.flush();
				csvWriter.close();
				
				//sync the data to database
				netflixDao.addARecordToNetflixShow(netflixShow);

			}
			else {
				netflixDao.addARecordToNetflixShow(netflixShow);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
