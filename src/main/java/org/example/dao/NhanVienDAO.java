package org.example.dao;

//import com.example.fashionshop.model.NhanVien;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.NhanVien;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {

    private static String CLASS_NAME = NhanVien.class.getName();

//    public static ObservableList<NhanVien> getAllNhanVien() {
//        Session session = HibernateUtlis.getSession();
//        Transaction transaction = session.getTransaction();
//        String sql = "select nv form " + CLASS_NAME + " nv";
//        ObservableList<NhanVien> dsNhanVien = null;
//        try {
//            transaction.begin();
//            Query<NhanVien> query = session.createQuery(sql, NhanVien.class);
//            dsNhanVien = FXCollections.observableArrayList(query.getResultList());
//            transaction.commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            transaction.rollback();
//        }
//        return dsNhanVien;
//    }

    public List<NhanVien> getAllNhanVien() {

        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<NhanVien> dsNhanVien = null;
        String sql = "select nv from " + NhanVien.class.getName() + " nv";
        try {
            transaction.begin();
            Query<NhanVien> query = session.createQuery(sql, NhanVien.class);
            dsNhanVien = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsNhanVien;
    }

    public NhanVien getNhanVien(String maNhanVien) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        String sql = "select nv form " + CLASS_NAME + " nv where maNhanVien='" + maNhanVien + "'";
        NhanVien nhanVien = null;
        try {
            transaction.begin();
            Query<NhanVien> query = session.createQuery(sql, NhanVien.class);
            nhanVien = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }

    public boolean addNhanVien(NhanVien nhanVien) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }

    }

    public boolean updateNhanVien(NhanVien nhanVien) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean deleteNhanVien(NhanVien nhanVien) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.remove(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
}
