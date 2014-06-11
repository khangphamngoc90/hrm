/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.com.hr.hrm.entities;

import java.util.Date;

/**
 *
 * @author khangpn
 */
public class Employee implements IEntity {
    private Long id;
    private Person person;
    private Date dateActive;
    private float coefficient;//He so luong
    private Department department;
    private Quanlification quanlification;//Trinh do chuyen mon

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDateActive() {
        return dateActive;
    }

    public void setDateActive(Date dateActive) {
        this.dateActive = dateActive;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Quanlification getQuanlification() {
        return quanlification;
    }

    public void setQuanlification(Quanlification quanlification) {
        this.quanlification = quanlification;
    }

    @Override
    public String toString() {
        return person.getName();
    }
    
}
