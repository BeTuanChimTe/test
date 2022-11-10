package org.example.impl;

//import com.example.fashionshop.dao.ChiTietDonHangDAO;
//import com.example.fashionshop.model.ChiTietDonHang;
//import com.example.fashionshop.service.ChiTietDonHangService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.example.dao.ChiTietDonHangDAO;
import org.example.model.ChiTietDonHang;
import org.example.service.ChiTietDonHangService;

import java.io.Serializable;
import java.util.List;

public class ChiTietDonHangServiceImpl  extends UnicastRemoteObject implements ChiTietDonHangService, Serializable {

    private ChiTietDonHangDAO chiTietDonHangDAO;

    public ChiTietDonHangServiceImpl() throws RemoteException {
        chiTietDonHangDAO = new ChiTietDonHangDAO();
    }

    @Override
    public boolean addChiTietDonHang(ChiTietDonHang chiTietDonHang) throws RemoteException{
        return chiTietDonHangDAO.addChiTietDonHang(chiTietDonHang);
    }

    @Override
    public boolean addAllChiTietDonHang(List<ChiTietDonHang> chiTietDonHangs) throws RemoteException {
        return chiTietDonHangDAO.addAllChiTietDonHang(chiTietDonHangs);
    }

    @Override
    public boolean mergerChiTietDonHang(ChiTietDonHang chiTietDonHang) throws RemoteException {
        return chiTietDonHangDAO.mergeChiTietDonHang(chiTietDonHang);
    }
}
