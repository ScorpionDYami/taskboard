/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.taskboard.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author yato_
 */
@Entity
public class Assignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private Date due_date;
    
    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Work> submissions = new ArrayList<>();

    /**
     * @return the submissions
     */
    public List<Work> getSubmissions() {
        return submissions;
    }

    /**
     * @param submissions the submissions to set
     */
    public void setSubmissions(List<Work> submissions) {
        this.submissions = submissions;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return due_date;
    }

    /**
     * @param due_date the dueDate to set
     */
    public void setDueDate(Date due_date) {
        this.due_date = due_date;
    }
}
