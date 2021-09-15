package com.deloitte.hux.netflix.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deloitte.hux.netflix.entity.NetflixShow;

@Repository
public class NetflixDaoImpl implements NetflixDao {
	
	private EntityManager entityManager;
		
	@Autowired
	public NetflixDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
 
	@Override
	public void addARecordToNetflixShow(NetflixShow netflixShow) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(netflixShow);
		
	}

}
