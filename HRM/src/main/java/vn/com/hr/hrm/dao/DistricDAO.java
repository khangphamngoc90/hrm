package vn.com.hr.hrm.dao;

import vn.com.hr.hrm.entities.District;

/**
 *
 * @author khangpn
 */
public class DistricDAO extends AbstractDAO<District>{

    @Override
    public boolean save(District data) {
        if(data.getIdCity() <= 0){
            return false;
        }
        return super.save(data);
    }
    
}
