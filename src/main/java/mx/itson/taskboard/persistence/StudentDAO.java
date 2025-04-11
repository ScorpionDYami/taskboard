/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.taskboard.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.taskboard.entities.Student;
import mx.itson.taskboard.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author yato_
 */
public class StudentDAO {
    
    public static List <Student> GetAll(){
        List <Student> student = new ArrayList<>();
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Student> criteriaQuerry = session.getCriteriaBuilder().createQuery(Student.class);
            criteriaQuerry.from(Student.class);
            
            student = session.createQuery(criteriaQuerry).getResultList();
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return student;
    }
    
    public static boolean save(Student s){
        boolean result = false;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.save(s);
            session.beginTransaction().commit();
            
            result = s.getId() != 0;
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return result;
    }
    
    public static boolean edit(Student s){
        boolean result = false;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.update(s);
            session.beginTransaction().commit();
            
            result = s.getId() != 0;
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return result;
    }
    
    public static boolean delete(Student s){
        boolean result = false;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.delete(s);
            session.beginTransaction().commit();
            
            result = s.getId() != 0;
        }catch(Exception ex){
            System.err.println("An error occurred" + ex.getMessage());
        }
        return result;
    }
    
    public static Student getById(int id) {
        Student student = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            student = session.get(Student.class, id);
        } catch(Exception ex) {
            System.err.println("An error occurred" + ex.getMessage());
        }
        return student;
    }
}
