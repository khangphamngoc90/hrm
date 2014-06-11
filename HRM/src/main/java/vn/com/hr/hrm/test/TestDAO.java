/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hr.hrm.test;

import java.util.Date;
import java.util.List;
import vn.com.hr.hrm.dao.AbstractDAO;
import vn.com.hr.hrm.entities.Person;

/**
 *
 * @author khangpn
 */
public class TestDAO {

    public static void main(String[] args) {

        //Mo ket noi toi DB
        AbstractDAO<Person> abstractDAO = new AbstractDAO<>();
        Person person = new Person();
        person.setAddress("Ha Noi");
        person.setId(1L);
        person.setBirth(new Date());
        person.setEthnic("ABC");
        person.setIdentityNo("10398594854");
        person.setName("Nguyen Van A");
        person.setPlaceBirth("Ha Noi");
        abstractDAO.save(person);
        
        List<Person> persons = abstractDAO.selectAll(new Person());
        for(Person p:persons) {
            System.out.println("============> " + p.getName());
        }
        //Dong ket noi
        abstractDAO.close();
    }
}
