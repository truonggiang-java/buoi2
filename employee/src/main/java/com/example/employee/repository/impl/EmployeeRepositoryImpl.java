package com.example.employee.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.entity.Groups;
import com.example.employee.page.EmployeePage;
import com.example.employee.page.EmployeeSearchCriteria;
import com.example.employee.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(e);
	}

	@Override
	public void update(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.update(e);
	}

	@Override
	public Employee findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Employee.class, id);
	}

	@Override
	public Page<Employee> findAllEmployees(EmployeePage employeePage, EmployeeSearchCriteria employeeSearchCriteria) {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
		Predicate predicate = getPredicate(employeeSearchCriteria, employeeRoot);
		criteriaQuery.where(predicate);
		setOrder(employeePage, criteriaQuery, employeeRoot);
		
		TypedQuery<Employee> typedQuery=session.createQuery(criteriaQuery);
		typedQuery.setFirstResult(employeePage.getPageNumber() * employeePage.getPageSize());
		typedQuery.setMaxResults(employeePage.getPageSize());
		
		Pageable pageable=getPageable(employeePage);
		
		Long employeesCount= getEmployeesCount(predicate);
		return new PageImpl<>(typedQuery.getResultList(),pageable,employeesCount);

	}
	

	private Predicate getPredicate(EmployeeSearchCriteria employeeSearchCriteria, Root<Employee> employeeRoot) {
		List<Predicate> predicates = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		if (Objects.nonNull(employeeSearchCriteria.getFirstName())) { // .nonNull la object co gia tri
			predicates.add(criteriaBuilder.like(employeeRoot.get("firstName"),
					"%" + employeeSearchCriteria.getFirstName() + "%"));
		}
		if (Objects.nonNull(employeeSearchCriteria.getLastName())) { // .nonNull la object co gia tri
			predicates.add(criteriaBuilder.like(employeeRoot.get("lastName"),
					"%" + employeeSearchCriteria.getLastName() + "%"));
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

	private void setOrder(EmployeePage employeePage, CriteriaQuery<Employee> criteriaQuery,
			Root<Employee> employeeRoot) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		if(employeePage.getSortDirection().equals(Sort.Direction.ASC)) {
			criteriaQuery.orderBy(criteriaBuilder.asc(employeeRoot.get(employeePage.getSortBy())));
		}else {
			criteriaQuery.orderBy(criteriaBuilder.desc(employeeRoot.get(employeePage.getSortBy())));
		}

	}
	
	
	private Pageable getPageable(EmployeePage employeePage) {
		Sort sort=Sort.by(employeePage.getSortDirection(),employeePage.getSortBy());
				
		return PageRequest.of(employeePage.getPageNumber(), employeePage.getPageSize(),sort);
	}

	private Long getEmployeesCount(Predicate predicate) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery= criteriaBuilder.createQuery(Long.class);
		Root<Employee> countRoot=countQuery.from(Employee.class);
		countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
		return sessionFactory.createEntityManager().createQuery(countQuery).getSingleResult();
	}
}
