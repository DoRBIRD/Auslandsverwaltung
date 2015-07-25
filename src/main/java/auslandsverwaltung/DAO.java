package auslandsverwaltung;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.LinkedList;
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
    @Transactional
    public List<StudiengangEntity> findStudeiengangByStudentId(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        List<StudentMappingEntity> studentMapping = findStudentMappingByStudentId(studentId);
        List<StudiengangEntity> studiengaenge = new LinkedList<StudiengangEntity>();
        for(StudentMappingEntity sm : studentMapping)
            studiengaenge.add(findStudeiengangById(sm.getStudiengang()));
        return studiengaenge;
    }


    //---University DAO---
    @Transactional
    public List<UniversitaetEntity> findAllUniversities() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UniversitaetEntity").list();
    }
    @Transactional
    public UniversitaetEntity findUniversityById(int universityId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from UniversitaetEntity U WHERE U.id = :universityId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("universityId",universityId);
        List universitys = query.list();
        return (universitys.isEmpty() ? null : (UniversitaetEntity) universitys.get(0));
    }

    //---Land DAO---
    @Transactional
    public List<LandEntity> findAllLands() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LandEntity").list();
    }

    //---StudentMapping DAO---
    @Transactional
    public List<StudentMappingEntity> findStudentMappingByStudentId(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudentMappingEntity AS SM WHERE SM.Student = :studentId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("studentId",studentId);
        List studentMapping = query.list();
        return studentMapping;
    }

    //---Studiengang DAO---
    @Transactional
    public StudiengangEntity findStudeiengangById(int studiengangId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudiengangEntity AS SG WHERE SG.id = :studiengangId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("studiengangId",studiengangId);
        List studiengaenge = query.list();
        return (studiengaenge.isEmpty() ? null : (StudiengangEntity) studiengaenge.get(0));
    }
    @Transactional
    public List<StudiengangEntity> findStudeiengangByUniId(int uniId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudiengangEntity AS SG WHERE SG.universitaet_id = :uniId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("uniId",uniId);
        return query.list();
    }


}