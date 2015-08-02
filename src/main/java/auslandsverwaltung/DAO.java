package auslandsverwaltung;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        return session.createQuery("from StudentEntity").list();
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
        String sql = "SELECT sg.* " +
                "FROM studiengang AS sg " +
                "INNER JOIN student_has_studiengang AS sm ON sg.id = sm.Studiengang " +
                "INNER JOIN student AS s ON sm.Student = s.id " +
                "INNER JOIN universitaet AS u ON sg.universitaet_id = u.id " +
                "WHERE s.id = :studentId " +
                "ORDER BY sg.id";
        SQLQuery query = session.createSQLQuery(sql);
        query.setInteger("studentId", studentId);
        query.addEntity(StudiengangEntity.class);
        return query.list();
    }

    @Transactional
    public List<StudentEntity> findStudentByUniversityId(int uniId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT s.id, s.MatrikelNummer, s.Vorname, s.Nachname, s.Email, s.Username, s.Password " +
                "FROM student AS s " +
                "INNER JOIN student_has_studiengang AS sm ON s.id = sm.student " +
                "INNER JOIN studiengang AS sg ON sm.Studiengang = sg.id " +
                "INNER JOIN universitaet AS u ON sg.universitaet_id = u.id " +
                "WHERE u.id = :uniId " +
                "ORDER BY s.id";
        SQLQuery query = session.createSQLQuery(sql);
        query.setInteger("uniId", uniId);
        query.addEntity(StudentEntity.class);
        return query.list();
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


    @Transactional
    public List<UniversitaetEntity> findUniversityByStudentId(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        String sql= "SELECT u.* FROM universitaet AS u " +
                "INNER JOIN studiengang AS sg ON u.id = sg.universitaet_id " +
                "INNER JOIN student_has_studiengang AS sm ON sg.id = sm.Studiengang " +
                "INNER JOIN student AS s ON sm.Student = s.id " +
                "WHERE s.id = :studentId " +
                "ORDER BY u.id";
        SQLQuery query = session.createSQLQuery(sql);
        query.setInteger("studentId", studentId);
        query.addEntity(UniversitaetEntity.class);
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
        return query.list();
    }
    @Transactional
    public List<StudentMappingEntity> findStudentMappingByStudiengangId(int studiengangId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudentMappingEntity AS SM WHERE SM.Studiengang = :studiengangId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("studiengangId",studiengangId);
        return query.list();
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
        return (studienplatzliste.isEmpty() ? null : studienplatzliste.get(0));
    }


    @Transactional
    public List<StudienplatzEntity> findStudeienplatzByStudentId(int student_id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from StudienplatzEntity AS SP WHERE SP.studentId = :student_id";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("student_id",student_id);
        return query.list();
    }
    @Transactional
    public List<StudienplatzEntity> findAllStudienplaetze() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM StudienplatzEntity").list();
    }

    @Transactional
    public StudienplatzEntity updateStudienplatz(int studienplatzId, int studentId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "UPDATE studienplatz SET Student_id = :studentId, Verfuegbarkeit = 0 WHERE id = :studienplatzId";
        SQLQuery query = session.createSQLQuery(sql);
        query.setInteger("studentId", studentId);
        query.setInteger("studienplatzId", studienplatzId);
        query.executeUpdate();
        StudienplatzEntity sp = findStudeienplatzById(studienplatzId);
        //session.persist(sp);
        session.save(sp);

        return sp;
    }


    //---Erfahrungsbericht DAO---
    @Transactional
    public ErfahrungsberichtEntity findEhrfahrungsberichtById(int erfahrungsberichtId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from ErfahrungsberichtEntity AS EB WHERE EB.id = :erfahrungsberichtId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("erfahrungsberichtId",erfahrungsberichtId);
        List<ErfahrungsberichtEntity> erfahrungsberichtliste = query.list();
        return (erfahrungsberichtliste.isEmpty() ? null : erfahrungsberichtliste.get(0));
    }
    @Transactional
    public List<ErfahrungsberichtEntity> findAllEhrfahrungsbericht() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM ErfahrungsberichtEntity").list();
    }
    @Transactional
    public List<ErfahrungsberichtEntity> findEhrfahrungsberichtByStudentId(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from ErfahrungsberichtEntity AS EB WHERE EB.studentId = :studentId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("studentId",studentId);

        return query.list();
    }

    @Transactional
    public Integer BerichtToDB(String betreff, String link, String inhalt, int studentid){
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            ErfahrungsberichtEntity eb = new ErfahrungsberichtEntity();
            eb.setBetreff(betreff);
            eb.setInhalt(inhalt);
            eb.setLink(link);
            eb.setStudentId(studentid);
            employeeID = (Integer) session.save(eb);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }


    @Transactional
    public ErfahrungsberichtEntity createErfahrungsbericht(String betreff, String link, String inhalt, int studentid) {
        Session session = sessionFactory.getCurrentSession();
        ErfahrungsberichtEntity eb = new ErfahrungsberichtEntity();
        eb.setBetreff(betreff);
        eb.setInhalt(inhalt);
        eb.setLink(link);
        eb.setStudentId(studentid);
        session.persist(eb);

        return eb;


    }

}