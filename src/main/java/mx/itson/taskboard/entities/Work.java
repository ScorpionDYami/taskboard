/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.taskboard.entities;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author yato_
 */

@Entity
public class Work {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Time date;
    private String file_name;
    
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;

    /**
     * @return the assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * @param assignment the assignment to set
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Time getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Time date) {
        this.date = date;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return file_name;
    }

    /**
     * @param file_name the fileName to set
     */
    public void setFileName(String file_name) {
        this.file_name = file_name;
    }
}
