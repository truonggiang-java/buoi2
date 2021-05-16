package com.example.employee.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Users;
import com.example.employee.repository.UserRepository;

@Repository
public class UsersRepositoryImpl implements UserRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UsersRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}
	@Override
	public void insert(Users u) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(u);
	}
	@Override
	public void update(Users u) {
		Session session=sessionFactory.getCurrentSession();
		session.update(u);
	}
	@Override
	public Users findByUserName(String name) {
		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Users> criteriaQuery=criteriaBuilder.createQuery(Users.class);
		Root<Users> root= criteriaQuery.from(Users.class);
		Predicate equal=criteriaBuilder.equal(root.get("name"), name);
		criteriaQuery.select(root).where(equal);
		Query<Users> query=session.createQuery(criteriaQuery);
		List<Users> users=query.getResultList();
		if(users.size() >0 && users.get(0) != null) {
			return users.get(0);
		}
		throw new RuntimeException("User not found");
	}
	
}
