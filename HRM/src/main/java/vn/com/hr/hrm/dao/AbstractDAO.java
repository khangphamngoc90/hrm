package vn.com.hr.hrm.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;

import java.util.ArrayList;
import java.util.List;

import vn.com.hr.hrm.data.config.ManagerDatabase;
import vn.com.hr.hrm.entities.IEntity;

/**
 *
 * @author khangpn
 */
public class AbstractDAO<E> {

    protected static ObjectContainer db;

    public void openDB() {
        if (this.db == null) {
            this.db = ManagerDatabase.getInstance().getDB();
            System.out.println("created...");
        }
    }

    public boolean save(E data) {
        try {
            getDb().store(data);
            getDb().commit();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            getDb().close();
        }
        return false;
    }

    public <T extends IEntity> T getById(IEntity id, Class<T> clzz) {
        try {
            if (id instanceof IEntity) {
                if (id.getId() > 0) {
                    ObjectSet<E> objects = getDb().queryByExample(id);
                    if (objects != null && !objects.isEmpty()) {
                        return (T)objects.next();
                    }
                } else {
                    return null;
                }
            }
        } catch (Db4oIOException | DatabaseClosedException e) {
        }
        return null;
    }

    public List<E> getByEntityQuery(E entity) {
        try {
            if (entity instanceof IEntity) {
                List<E> list = new ArrayList<>();
                ObjectSet<E> objects = getDb().queryByExample(entity);
                if (objects != null && !objects.isEmpty()) {
                    while (objects.hasNext()) {
                        list.add(objects.next());
                    }
                    return list;
                }
            }
        } catch (Db4oIOException | DatabaseClosedException e) {
        }
        return null;
    }

    public List<E> selectAll(E entity) {
        try {
            if (entity instanceof IEntity) {
                List<E> list = new ArrayList<>();
                ObjectSet<? extends Object> set = getDb().query(entity
                        .getClass());
                while (set.hasNext()) {
                    list.add((E) set.next());
                }
                return list;
            }
        } catch (Db4oIOException | DatabaseClosedException e) {
        }
        return null;
    }
    
    public ObjectContainer getDb() {
        openDB();
        return this.db;
    }

    public void setDb(ObjectContainer db) {
        this.db = db;
    } 
    
    public void close() {
        if(db != null){
            db.close();
            db = null;
        }
    }
}
