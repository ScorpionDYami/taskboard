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
    
    /**
 * Retrieves all assignments from the database.
 * <p>
 * This method opens a Hibernate session and creates a CriteriaQuery to select all Assignment entities.
 * It executes the query and collects the results in a list. If an error occurs during the process,
 * an error message is printed and an empty list is returned.
 * </p>
 * @return a List containing all Assignment entities, or an empty list if an error occurs.
 */
    public static List<Assignment> getAll() {
        List<Assignment> assignments = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Assignment> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Assignment.class);
            criteriaQuery.from(Assignment.class);
            
            assignments = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){
            System.out.println("An error ocurred: " + ex.getMessage());
        }
        return assignments;
    }
    
    /**
    * Saves the given Assignment to the database.
    * <p>
    * This method opens a Hibernate session and begins a transaction.
    * It then saves the provided Assignment entity and commits the transaction.
    * After committing, it verifies whether the Assignment was successfully saved
    * by checking if its ID is not zero. If an exception occurs during the process,
    * an error message is printed to the console.
    * </p>
    * @param a the Assignment object to be saved
    * @return true if the Assignment was saved successfully (its ID is not zero), false otherwise
    */
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
    
    /**
    * Updates the given Assignment in the database.
    * <p>
    * This method opens a Hibernate session and initiates a transaction.
    * It then updates the provided Assignment entity in the database and commits the transaction.
    * After committing, it checks whether the Assignment has a valid ID (not zero)
    * to determine if the update was successful. In case of an exception, an error message is printed.
    * </p>
    * @param a the Assignment object to be updated
    * @return true if the update was successful (its ID is not zero), false otherwise
    */
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
    
    /**
    * Deletes the specified Assignment from the database.
    * <p>
    * This method opens a Hibernate session and starts a transaction.
    * It then deletes the given Assignment entity and commits the transaction.
    * After committing, it checks if the Assignment still has a valid ID (not zero) to determine
    * if the deletion process resulted in a proper state. In case of an error, an error message is printed.
    * </p>
    * @param a the Assignment object to be deleted
    * @return true if the deletion was processed such that the Assignment's ID remains non-zero, false otherwise
    */
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
    
    /**
    * Retrieves an Assignment entity by its ID from the database.
    * <p>
    * This method opens a Hibernate session and fetches the Assignment
    * object corresponding to the specified ID using the session's get() method.
    * If an exception occurs during the process, an error message is printed to the error stream.
    * </p>
    * @param id the ID of the Assignment to retrieve
    * @return the Assignment object with the specified ID, or null if not found or an error occurs
    */
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