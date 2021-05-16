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

import com.example.employee.entity.Department;
import com.example.employee.repository.DepartmentRepository;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public DepartmentRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void insert(Department d) {
		Session session=sessionFactory.getCurrentSession();
		session.persist(d);
	}
	@Override
	public void update(Department d) {
		Session session=sessionFactory.getCurrentSession();
		session.update(d);
	}
	@Override
	public Department findById(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		return session.find(Department.class, id);
	}
	@Override
	public List<Department> findAllDepartment() {
		Session session =sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Department> criteriaQuery=criteriaBuilder.createQuery(Department.class);
		Root<Department> root=criteriaQuery.from(Department.class);
		criteriaQuery.select(root);
		Query<Department> query =session.createQuery(criteriaQuery);
		List<Department> results=query.getResultList();
		return results;
	}

}
