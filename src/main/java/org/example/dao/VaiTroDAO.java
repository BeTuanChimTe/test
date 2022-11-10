package org.example.dao;


import org.example.model.VaiTro;
import org.example.model.VaiTro;
import org.example.utlis.HibernateUtlis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class VaiTroDAO {

    private static String className = VaiTro.class.getName();

    public  List<VaiTro> getAllRoles() {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        List<VaiTro> dsVaiTro = null;
        try {
            transaction.begin();
            String selectQuery = "select vt from " + className + " vt";
            Query<VaiTro> query = session.createQuery(selectQuery, VaiTro.class);
            dsVaiTro = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return dsVaiTro;
    }
    public  boolean addVaiTro(VaiTro vaiTro){
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(vaiTro);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public  VaiTro getRoleById(int roleId) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        VaiTro vaiTro = null;
        try {
            transaction.begin();
            String selectQuery = "select vt from " + className + " vt where vt.maVaiTro=" + roleId;
            Query<VaiTro> query = session.createQuery(selectQuery, VaiTro.class);
            vaiTro = query.getSingleResult();
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return vaiTro;
    }

}
