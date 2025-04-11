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
 * @author Ivan Arce
 */
public class StudentDAO {
    
    /**
    * Retrieves all Student entities from the database.
    * <p>
    * This method opens a Hibernate session and creates a CriteriaQuery to fetch all Student objects.
    * The query is executed to obtain the result list which is then returned.
    * If an exception occurs, an error message is printed and an empty list is returned.
    * </p>
    * @return a List containing all Student entities, or an empty list if an error occurs
    */
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
    
    /**
    * Persists the given Student entity in the database.
    * <p>
    * This method opens a Hibernate session and begins a transaction.
    * It then saves the provided Student object to the database, committing the transaction afterwards.
    * Finally, it checks if the Student's ID is non-zero to confirm that the save operation was successful.
    * If an exception is thrown during the process, an error message is printed and the method returns false.
    * </p>
    * @param s the Student entity to save
    * @return true if the Student was saved successfully (its ID is non-zero); false otherwise
    */
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
    
    /**
    * Updates the specified Student entity in the database.
    * <p>
    * This method opens a Hibernate session and begins a transaction.
    * It then updates the provided Student object and commits the transaction.
    * After committing, it checks if the Student's ID is non-zero to confirm that the update operation was successful.
    * If an exception occurs during the process, an error message is printed and the method returns false.
    * </p>
    * @param s the Student entity to update
    * @return true if the Student was updated successfully (its ID is non-zero); false otherwise
    */
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
    
    /**
    * Deletes the specified Student entity from the database.
    * <p>
    * This method opens a Hibernate session and begins a transaction.
    * It then deletes the provided Student object and commits the transaction.
    * After committing, it checks if the Student's ID is non-zero to confirm that the delete operation was successful.
    * If an exception occurs during the process, an error message is printed and the method returns false.
    * </p>
    * @param s the Student entity to delete
    * @return true if the Student was deleted successfully (its ID is non-zero); false otherwise
    */
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
    
    /**
    * Retrieves a Student entity from the database using its ID.
    * <p>
    * This method opens a Hibernate session and uses the {@code session.get()} method
    * to fetch the Student object corresponding to the provided ID. If the Student is not found,
    * {@code session.get()} returns {@code null}. Any exceptions encountered during the process
    * are caught, and an error message is printed to the error stream.
    * </p>
    *
    * @param id the ID of the Student to retrieve
    * @return the Student object with the specified ID, or {@code null} if not found or an error occurs
    */
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

    public static List<Student> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
