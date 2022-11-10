package org.example.impl;

//import com.example.fashionshop.dao.DonNhapHangDAO;
//import com.example.fashionshop.model.DonNhapHang;
//import com.example.fashionshop.service.DonNhapHangService;
//import javafx.collections.ObservableList;
import org.example.dao.DonNhapHangDAO;
import org.example.model.DonNhapHang;
import org.example.service.DonNhapHangService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DonNhapHangImpl extends UnicastRemoteObject implements DonNhapHangService, Serializable {

    private DonNhapHangDAO donNhapHangDAO;

    public DonNhapHangImpl() throws RemoteException {
        donNhapHangDAO = new DonNhapHangDAO();
    }

    @Override
    public List<DonNhapHang> getAllDonNhapHang() throws RemoteException {
        return donNhapHangDAO.getAllDonNhapHang();
    }

    @Override
    public boolean addDonNhapHang(DonNhapHang donNhapHang)throws RemoteException {
        return donNhapHangDAO.addDonNhapHang(donNhapHang);
    }

    @Override
    public boolean updateDonNhapHang(DonNhapHang donNhapHang)throws RemoteException {
        return donNhapHangDAO.updateDonNhapHang(donNhapHang);
    }

    @Override
    public boolean deleteDonNhapHang(DonNhapHang donNhapHang)throws RemoteException {
        return donNhapHangDAO.deleteDonNhapHang(donNhapHang);
    }

}
