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
    @Transactional //version die gehen w�rde mit beziehungen in den hybernate entitys
    public List<StudentEntity> findStudentByUniversityId(int uniId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT s.id, s.Vorname, s.Username, s.Password, s.MatrikelNummer, s.Email " +
                "FROM StudentEntity AS s " +
                "JOIN s.StudentMappingEntity AS sm " +
                "JOIN sm.StudiengangEntity AS sg " +
                "WHERE sg.universitaet_id = :uniId GROUP BY s.id";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("uniId", uniId);
        return query.list();
    }
    @Transactional //schlechte version version
    public List<StudentEntity> findStudentByUniversityId2(int uniId) {
        Session session = sessionFactory.getCurrentSession();
        List<StudiengangEntity> studiengangListe = findStudeiengangByUniId(uniId);
        List<StudentEntity> studentenliste = new LinkedList<StudentEntity>();
        for(StudiengangEntity studiengang : studiengangListe){
            List<StudentMappingEntity> studentenMappingliste = findStudentMappingByStudiengangId(studiengang.getId());
            for(StudentMappingEntity studentennmap : studentenMappingliste)
                studentenliste.add(findStudentById(studentennmap.getStudent()));
        }
        return studentenliste;
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

    @Transactional
    public  List<UniversitaetEntity> findUniversityByStandort(String standort) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from UniversitaetEntity U WHERE U.Standort = :standort";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("standort",standort);
        return query.list();
    }



    //---Land DAO---
    @Transactional
    public List<LandEntity> findAllLands() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from LandEntity").list();
    }

    @Transactional
    public LandEntity findLandById(String landId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from LandEntity WHERE name = :landId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("landId",landId);
        List laender = query.list();
        return (laender.isEmpty() ? null : (LandEntity) laender.get(0));
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
    @Transactional
    public List<StudentMappingEntity> findStudentMappingByStudiengangId(int studiengangId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudentMappingEntity AS SM WHERE SM.Studiengang = :studiengangId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("studiengangId",studiengangId);
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
    @Transactional
    public List<StudiengangEntity> findAllStudiengaenge() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM StudiengangEntity").list();
    }
    //---Studienplatz DAO---
    @Transactional
    public List<StudienplatzEntity> findStudeienplatzByUniId(int uniId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudienplatzEntity AS SP WHERE SP.universitaet_id = :uniId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("uniId",uniId);
        return query.list();
    }

    @Transactional
    public StudienplatzEntity findStudeienplatzById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudienplatzEntity AS SP WHERE SP.id = :id";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("id",id);
        List<StudienplatzEntity> studienplatzliste = query.list();
        return (studienplatzliste.isEmpty() ? null : (StudienplatzEntity) studienplatzliste.get(0));
    }


    @Transactional
    public StudienplatzEntity findStudeienplatzByStudentId(int student_id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudienplatzEntity AS SP WHERE SP.student_id = :student_id";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("student_id",student_id);
        List<StudienplatzEntity> studienplatzliste = query.list();
        return (studienplatzliste.isEmpty() ? null : (StudienplatzEntity) studienplatzliste.get(0));
    }

    @Transactional
    public List<StudienplatzEntity> findAllStudienplaetze() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM StudienplatzEntity").list();
    }
    //---Erfahrungsbericht DAO---
    @Transactional
    public ErfahrungsberichtEntity findEhrfahrungsberichtById(int erfahrungsberichtId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from ErfahrungsberichtEntity AS EB WHERE EB.id = :erfahrungsberichtId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("erfahrungsberichtId",erfahrungsberichtId);
        List<ErfahrungsberichtEntity> erfahrungsberichtliste = query.list();
        return (erfahrungsberichtliste.isEmpty() ? null : (ErfahrungsberichtEntity) erfahrungsberichtliste.get(0));
    }
    @Transactional
    public List<ErfahrungsberichtEntity> findAllEhrfahrungsbericht() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM ErfahrungsberichtEntity").list();
    }


}