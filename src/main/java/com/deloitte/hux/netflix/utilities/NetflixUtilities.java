package com.deloitte.hux.netflix.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deloitte.hux.netflix.entity.NetflixShow;

public class NetflixUtilities {

	/*
	 * Utility method to return list of fields data fetched from a record in csv
	 */
	public static List<String> splitString(String inputString) {

		List<String> resultList = new ArrayList<String>();

		StringBuilder stringBuilder = new StringBuilder();
		boolean isLastSeenQuote = false;

		for (int i = 0; i < inputString.length(); i++) {

			if (inputString.charAt(i) == '"') {
				isLastSeenQuote = isLastSeenQuote == false ? true : false;
			}
			if (!isLastSeenQuote && (inputString.charAt(i) == ',' || i == inputString.length() - 1)) {

				resultList.add(stringBuilder.toString());
				stringBuilder.delete(0, stringBuilder.length());
			} else {
				stringBuilder.append(inputString.charAt(i));
			}
		}
		return resultList;
	}

	public static String getDateStringInStandardFormat(String inputString) {

		String[] dateStringArray = inputString.replaceAll("\"", "").split("\\s*,\\s*");
		String year = dateStringArray[1];
		String dayAndMonth = dateStringArray[0];

		String[] dayAndMonthArray = dayAndMonth.split(" ");

		String dateString = dayAndMonthArray[1] + "-" + dayAndMonthArray[0].substring(0, 3) + "-" + year;
		System.out.println("dateString " + dateString);

		return dateString;
	}
	
	public static NetflixShow populateNetflixShow(List<String> dataFields, Map<String, Integer>keyToIndexMap) {
		
		try {
			System.out.println("keyToIndexMap "+keyToIndexMap);
			System.out.println("dataFields.get(keyToIndexMap.get(\"show_id\")) "+dataFields.get(keyToIndexMap.get("show_id")));
			if(dataFields.get(keyToIndexMap.get("show_id")) !=null && !dataFields.get(keyToIndexMap.get("show_id")).isEmpty()) {
				
				NetflixShow netflixShow = new NetflixShow();
				netflixShow.setShowId(dataFields.get(keyToIndexMap.get("show_id")));
				netflixShow.setType(dataFields.get(keyToIndexMap.get("type")));
				netflixShow.setTitle(dataFields.get(keyToIndexMap.get("title")));
				netflixShow.setDirector(dataFields.get(keyToIndexMap.get("director")));
				netflixShow.setCast(dataFields.get(keyToIndexMap.get("cast")));
				netflixShow.setCountry(dataFields.get(keyToIndexMap.get("country")));
				netflixShow.setDateAdded(dataFields.get(keyToIndexMap.get("date_added")));
				netflixShow.setReleaseYear(dataFields.get(keyToIndexMap.get("release_year")));
				netflixShow.setRating(dataFields.get(keyToIndexMap.get("rating")));
				netflixShow.setDuration(dataFields.get(keyToIndexMap.get("duration")));   
				netflixShow.setListedIn(dataFields.get(keyToIndexMap.get("listed_in")));
				netflixShow.setDescription(dataFields.get(keyToIndexMap.get("descriptio")));
				
				return netflixShow;
			}
			
			return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
