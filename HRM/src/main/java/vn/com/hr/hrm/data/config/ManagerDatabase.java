package vn.com.hr.hrm.data.config;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 *
 * @author khangpn
 */
public class ManagerDatabase {

    private static ManagerDatabase instance;

    public static final String DB_URL = "hrm.db4o";
    private ObjectContainer db = null;

    public static ManagerDatabase getInstance() {
        if (instance == null) {
            instance = new ManagerDatabase();
        }
        return instance;
    }

    private void open() {
        if (this.db == null || db.close()) {
            db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB_URL);
        }
    }

    public ObjectContainer getDB() {
        open();
        return this.db;
    }

    private ManagerDatabase() {

    }

    public void close() {
        if (db != null) {
            db.close();
        }
    }

}
