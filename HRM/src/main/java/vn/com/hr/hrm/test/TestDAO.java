/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.com.hr.hrm.test;

import java.util.List;

import vn.com.hr.hrm.dao.CityDAO;
import vn.com.hr.hrm.entities.City;

/**
 * 
 * @author khangpn
 */
public class TestDAO {
	public static void main(String[] args) {
		City c = new City();
		c.setId(2L);
		c.setCode("TEST2");
		c.setName("TEST2");
		CityDAO cityDAO = new CityDAO();

		cityDAO.save(c);

		City id = new City();
		id.setId(2L);

		c = cityDAO.getById(id);
		List<City> cities = cityDAO.selectAll(new City());

		System.out.println(cities);
		System.out.println("===========> " + c.getName());

	}
}
