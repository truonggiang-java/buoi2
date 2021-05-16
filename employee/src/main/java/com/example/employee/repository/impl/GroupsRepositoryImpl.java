package com.example.employee.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;
import com.example.employee.entity.Groups;
import com.example.employee.repository.GroupsRepository;

@Repository
public class GroupsRepositoryImpl implements GroupsRepository{
	private SessionFactory sessionFactory;
	
	@Autowired
	public GroupsRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<Groups> findAllGroups() {
		Session session=sessionFactory.getCurrentSession();
		String hql="select g from Groups g";
		Query query =session.createQuery(hql);
		List<Groups> listResult=query.list();
		return listResult;
	}
}
