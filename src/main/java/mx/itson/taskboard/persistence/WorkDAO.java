/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.taskboard.persistence;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.taskboard.entities.Work;
import mx.itson.taskboard.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Ivan Arce
 */
public class WorkDAO {
    
    public static List <Work> GetAll(){
        List <Work> student = new ArrayList<>();
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Work> criteriaQuerry = session.getCriteriaBuilder().createQuery(Work.class);
            criteriaQuerry.from(Work.class);
            
            student = session.createQuery(criteriaQuerry).getResultList();
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return student;
    }
    
    public static Work getById(int id) {
        Work work = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            work = session.get(Work.class, id);
        } catch(Exception ex) {
            System.err.println("An error occurred" + ex.getMessage());
        }
        return work;
    }
    
    public static boolean save(Work w){
        boolean result = false;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(w);
            session.beginTransaction().commit();
            
            result = w.getId() != 0;
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return result;
    }
    
    public static boolean edit(Work w){
        boolean result = false;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.update(w);
            session.beginTransaction().commit();
            
            result = w.getId() != 0;
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return result;
    }
    
    public static boolean delete(Work w){
        boolean result = false;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.delete(w);
            session.beginTransaction().commit();
            
            result = w.getId() != 0;
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return result;
    }
}
