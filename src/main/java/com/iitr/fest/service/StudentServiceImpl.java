package com.iitr.fest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.iitr.fest.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {
	
	private SessionFactory sessionFactory;
	private Session session;

	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session= this.sessionFactory.openSession();

		}
	}
	
	@Transactional
	@Override
	public List<Student> viewAll() {
		List<Student> studentList = session.createQuery("from Student").list();
		return studentList;
	}
	
	@Transactional
	@Override
	public void registerStudent(Student student) {
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(student);
		tr.commit();
		
	}
	
	@Transactional
	@Override
	public void deleteById(Integer studentId)
	{	
		Student student = null;
		student=session.get(Student.class, studentId);
		Transaction tr = session.beginTransaction();
		session.delete(student);
		tr.commit();
		
	}

	@Transactional
	@Override
	public Student findStudent(Integer studentId)
	{
		Student student = session.get(Student.class, studentId);
		return student;
		
	}

	

	

}
