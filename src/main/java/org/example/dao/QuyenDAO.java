package org.example.dao;

//import com.example.fashionshop.model.DanhMuc;
//import com.example.fashionshop.model.Quyen;
//import com.example.fashionshop.utils.DBUtils;
//import com.example.fashionshop.utils.HibernateUtlis;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import org.example.model.DanhMuc;
import org.example.model.Quyen;
import org.example.utlis.DBUtils;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuyenDAO {

    private static String className = Quyen.class.getName();

    public  List<Quyen> getAllQuyen() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<Quyen> dsQuyen = null;
        try {
            transaction.begin();
            String selectQuery = "select q from " + className + " q";
            Query<Quyen> query = session.createQuery(selectQuery, Quyen.class);
            dsQuyen = new ArrayList(query.getResultList());
//                    FXCollections.observableArrayList(query.getResultList());
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsQuyen;
    }

    public  Quyen getQuyen(String maQuyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        Quyen quyen = null;
        try {
            transaction.begin();
            String selectQuery = "select q from " + className + " q where q.maQuyen='" + maQuyen + "'";
            Query<Quyen> query = session.createQuery(selectQuery, Quyen.class);
            quyen = query.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return quyen;
    }

    public  boolean addQuyen(Quyen quyen) {
//        quyen.setMaQuyen(IDUtils.());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(quyen);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public  boolean updateQuyen(Quyen quyen) {

        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.update(quyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public  boolean mergeQuyen(Quyen quyen) {
//        if (quyen.getMaQuyen()== null || quyen.getMaQuyen().isEmpty() == true)
//            quyen.setMaQuyen(IDUtils.createMaQuyen());
        quyen.setMaQuyen(quyen.getMaQuyen());
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(quyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public  boolean removeQuyen(Quyen quyen) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.delete(quyen);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

//    public  List<Quyen> getAllQuyenFromDanhMuc(DanhMuc danhMuc, int top) {
//        List<String> dsMaQuyen = new ArrayList<>();
//        String selectQuery = "select top " + top + " q.maQuyen from Quyen q where q.maDanhMuc='" + danhMuc.getMaDanhMuc() + "'";
//        try {
//            ResultSet rs = DBUtils.executeQuery(selectQuery);
//            while(rs.next()) {
//                dsMaQuyen.add(rs.getString(1));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        List<Quyen> dsQuyen = new ArrayList();
//        dsMaQuyen.forEach(maQuyen -> { dsQuyen.add(getQuyen(maQuyen)); });
//
//        return dsQuyen;
//    }
//
//    public  List<Quyen> getAllQuyenFromDanhMuc(DanhMuc danhMuc) {
//        List<String> dsMaQuyen = new ArrayList<>();
//        String selectQuery = "select q.maQuyen from Quyen q where q.maDanhMuc='" + danhMuc.getMaDanhMuc() + "'";
//        try {
//            ResultSet rs = DBUtils.executeQuery(selectQuery);
//            while(rs.next()) {
//                dsMaQuyen.add(rs.getString(1));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        List<Quyen> dsQuyen = new ArrayList();
//        dsMaQuyen.forEach(maQuyen -> { dsQuyen.add(getQuyen(maQuyen)); });
//
//        return dsQuyen;
//    }
}
