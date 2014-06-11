package vn.com.hr.hrm.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khangpn
 */
public class City implements IEntity {

    private long id;
    private String code;
    private String name;
    private List<District> districts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public void addDistrict(District district) {
        if (this.districts == null) {
            districts = new ArrayList<>();
        }
        districts.add(district);
    }
}
