package vn.com.hr.hrm.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import java.util.List;
import vn.com.hr.hrm.data.config.ManagerDatabase;
import vn.com.hr.hrm.entities.IEntity;

/**
 *
 * @author khangpn
 */
public class AbstractDAO<E> {

    public ObjectContainer getDb() {
        ObjectContainer db = ManagerDatabase.getInstance().getDB();
        return db;
    }

    public boolean save(E data) {
        ObjectContainer container = getDb();
        try {
            container.store(data);
            container.commit();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            container.close();
        } finally {
            container.close();
        }
        return false;
    }

    public E getById(E entity) {
        ObjectContainer container = getDb();
        try {
            if (entity instanceof IEntity) {
                if (((IEntity) entity).getId() > 0) {
                    ObjectSet<E> objects = container.queryByExample(entity);
                    if (objects != null && !objects.isEmpty()) {
                        return objects.next();
                    }
                } else {
                    return null;
                }
            }
        } catch (Db4oIOException | DatabaseClosedException e) {
        } finally {
            container.close();
        }
        return null;
    }
    
    public List<E> getByEntityQuery(E entity) {
        ObjectContainer container = getDb();
        try {
            if (entity instanceof IEntity) {
                if (((IEntity) entity).getId() > 0) {
                    ObjectSet<E> objects = container.queryByExample(entity);
                    if (objects != null && !objects.isEmpty()) {
                        return objects;
                    }
                } else {
                    return null;
                }
            }
        } catch (Db4oIOException | DatabaseClosedException e) {
        } finally {
            container.close();
        }
        return null;
    }
}
