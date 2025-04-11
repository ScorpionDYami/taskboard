/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.taskboard.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.taskboard.entities.Assignment;
import mx.itson.taskboard.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author PROPIETARIO
 */
public class AssignmentDAO {
    
    public static List<Assignment> getAll() {
        List<Assignment> assigments = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Assignment> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Assignment.class);
            criteriaQuery.from(Assignment.class);
            
            assigments = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.out.println("An error ocurred: " + ex.getMessage());
        }
        return assigments;
    }
    
    public static boolean Save(Assignment a){
        boolean result = false;
        try {
            Session session = HibernateUtil.getSessionFactory() .openSession();
            session.beginTransaction();
            
            session.save(a);
            session.getTransaction().commit();
            
            result = a.getId() != 0;
        }catch(Exception ex){
            System.out.println("An error ocurred: " + ex.getMessage());
        }
        return result;
        
    }
    
    public static boolean edit(Assignment a){
        boolean result = false;
        try {
            Session session = HibernateUtil.getSessionFactory() .openSession();
            session.beginTransaction();
            
            session.update(a);
            session.getTransaction().commit();
            
            result = a.getId() != 0;
        }catch(Exception ex){
            System.out.println("An error ocurred: " + ex.getMessage());
        }
        return result;
    
    }
    
    public static boolean delete(Assignment a){
        boolean result = false;
        try {
            Session session = HibernateUtil.getSessionFactory() .openSession();
            session.beginTransaction();
            
            session.delete(a);
            session.getTransaction().commit();
            
            result = a.getId() != 0;
        }catch(Exception ex){
            System.out.println("An error ocurred: " + ex.getMessage());
        }
        return result;
    
    }
    
    public static Assignment getById(int id) {
        Assignment assignment = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            assignment = session.get(Assignment.class, id);
        } catch(Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return assignment;
    }
}