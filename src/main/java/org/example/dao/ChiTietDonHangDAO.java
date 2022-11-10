package org.example.dao;

//import com.example.fashionshop.model.ChiTietDonHang;
//import com.example.fashionshop.utils.HibernateUtlis;
import org.example.model.ChiTietDonHang;
import org.example.model.ChiTietDonHang;
import org.example.utlis.HibernateUtlis;
import org.example.utlis.IDUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ChiTietDonHangDAO {

    private static String CLASS_NAME = ChiTietDonHang.class.getName();

    public boolean addChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(chiTietDonHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean addAllChiTietDonHang(List<ChiTietDonHang> chiTietDonHangs) {
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            for(ChiTietDonHang chiTietDonHang : chiTietDonHangs)
                session.merge((ChiTietDonHang)chiTietDonHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        return false;
    }
    public  boolean mergeChiTietDonHang(ChiTietDonHang chiTietDonHang) {
//        try {
//            if (chiTietDonHang.getDonHang().getMaDonHang()== null || chiTietDonHang.getDonHang().getMaDonHang().isEmpty() == true)
//                chiTietDonHang.set(IDUtils.createMaChiTietDonHang());
//        }catch (Exception exception){
//            exception.printStackTrace();
//        }
        Session session = HibernateUtlis.getSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.merge(chiTietDonHang);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
