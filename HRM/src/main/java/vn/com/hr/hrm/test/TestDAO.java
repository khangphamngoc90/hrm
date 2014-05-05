/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.com.hr.hrm.test;

import vn.com.hr.hrm.dao.CityDAO;
import vn.com.hr.hrm.entities.City;

/**
 *
 * @author khangpn
 */
public class TestDAO {
    public static void main(String[] args) {
        City c = null;
//        c.setId(1L);
//        c.setCode("TEST");
//        c.setName("TEST");
        
        CityDAO cityDAO = new CityDAO();
        
        City id = new City();
        id.setId(1L);
        
        c = cityDAO.getById(id);
        
        System.out.println("===========> "+c);
        
    }
}
