package org.example.dao;

//import com.example.fashionshop.model.ChucVu;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.ChucVu;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ChucVuDAO {

    private static String className = ChucVu.class.getName();

    public List<ChucVu> getAllCChucVu() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<ChucVu> dsChucVu = null;
        try {
            transaction.begin();
            String selectQuery = "select dm from " + className + " dm";
            Query<ChucVu> query = session.createQuery(selectQuery, ChucVu.class);
            dsChucVu = new ArrayList<>(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsChucVu;
    }

    public boolean addChucVu(ChucVu chucVu){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(chucVu);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean removeChucVu(ChucVu chucVu){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(chucVu);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateChucVu(ChucVu chucVu){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(chucVu);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
