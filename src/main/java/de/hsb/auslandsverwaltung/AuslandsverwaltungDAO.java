package de.hsb.auslandsverwaltung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
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
	public List<UniversitaetEntity> findAllUniversitaeten() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from universitaet").list();
	}

	@Transactional
	public StudentEntity findByUsernameAndPassword(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from student S where S.username = :username AND S.password = :password";
		org.hibernate.Query query1 = session.createQuery(hql);
		query1.setParameter("username",username);
		query1.setParameter("password",password);
		return (StudentEntity)query1.list().get(0);
	}



}
