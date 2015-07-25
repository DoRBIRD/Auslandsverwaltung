package auslandsverwaltung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class DAO {

    @Autowired private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */
    //---Student DAO---
    @Transactional
    public List<StudentEntity> findAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        List studenten = session.createQuery("from StudentEntity").list();
        return studenten;
    }
    @Transactional //noch nicht getestet
    public StudentEntity findStudentByUserPass(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM StudentEntity as S WHERE S.Username = :username AND S.Password = :password";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);

        List students = query.list();
        return (students.isEmpty() ? null : (StudentEntity) students.get(0));
    }
    @Transactional
    public StudentEntity findStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM StudentEntity as S WHERE S.id = :id";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List students = query.list();
        return (students.isEmpty() ? null : (StudentEntity) students.get(0));
    }
    //---University DAO---
    @Transactional
    public List<UniversitaetEntity> findAllUniversities() {
        Session session = sessionFactory.getCurrentSession();
        List universities = session.createQuery("from UniversitaetEntity").list();
        return universities;
    }

    //---Land DAO
    @Transactional
    public List<LandEntity> findAllLands() {
        Session session = sessionFactory.getCurrentSession();
        List lands = session.createQuery("from LandEntity").list();
        return lands;
    }

}