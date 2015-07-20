package de.hsb.auslandsverwaltung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class AuslandsverwaltungDAO {
	
	@Autowired private SessionFactory sessionFactory;
	
	/**
	 * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
	 * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
	 */

	@Transactional
	public List<student> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from student").list();
	}

	@Transactional
	public StudentEntity findBy() {
		Session session = sessionFactory.getCurrentSession();

		return (student)session.createQuery("from student").list().get(0);
	}



}
