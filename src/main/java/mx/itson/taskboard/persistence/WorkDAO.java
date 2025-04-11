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
    
    /**
    * Retrieves all Work entities from the database.
    * <p>
    * This method opens a Hibernate session and creates a CriteriaQuery to fetch all Work objects.
    * The query is executed to obtain the result list which is then returned.
    * If an exception occurs, an error message is printed and an empty list is returned.
    * </p>
    * @return a List containing all Work entities, or an empty list if an error occurs
    */
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
    
    /**
    * Retrieves a Work entity from the database using its ID.
    * <p>
    * This method opens a Hibernate session and uses the {@code session.get()} method
    * to fetch the Work object corresponding to the provided ID. If the Work is not found,
    * {@code session.get()} returns {@code null}. Any exceptions encountered during the process
    * are caught, and an error message is printed to the error stream.
    * </p>
    *
    * @param id the ID of the Work to retrieve
    * @return the Work object with the specified ID, or {@code null} if not found or an error occurs
    */
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
    
    /**
    * Saves the specified Work entity to the database.
    * <p>
    * This method opens a Hibernate session and begins a transaction.
    * It then saves the provided Work object and commits the transaction.
    * After committing, it checks if the Work's ID is non-zero to confirm that the save operation was successful.
    * If an exception occurs during the process, an error message is printed and the method returns false.
    * </p>
    * @param w the Work entity to save
    * @return true if the Work was saved successfully (its ID is non-zero); false otherwise
    */
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
    
    /**
    * Updates the specified Work entity in the database.
    * <p>
    * This method opens a Hibernate session and begins a transaction.
    * It then updates the provided Work object and commits the transaction.
    * After committing, it checks if the Work's ID is non-zero to confirm that the update operation was successful.
    * If an exception occurs during the process, an error message is printed and the method returns false.
    * </p>
    * @param w the Work entity to update
    * @return true if the Work was updated successfully (its ID is non-zero); false otherwise
    */
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
    
    /**
    * Deletes the specified Work entity from the database.
    * <p>
    * This method opens a Hibernate session and begins a transaction.
    * It then deletes the provided Work object and commits the transaction.
    * After committing, it checks if the Work's ID is non-zero to confirm that the delete operation was successful.
    * If an exception occurs during the process, an error message is printed and the method returns false.
    * </p>
    * @param w the Work entity to delete
    * @return true if the Work was deleted successfully (its ID is non-zero); false otherwise
    */
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
