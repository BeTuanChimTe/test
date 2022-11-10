package org.example.impl;

import org.example.dao.DonHangDAO;
import org.example.dao.DonNhapHangDAO;
import org.example.model.DonHang;
import org.example.service.DonHangService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DonHangServiceImpl extends UnicastRemoteObject implements DonHangService, Serializable {
    private DonHangDAO donHangDAO;

    public DonHangServiceImpl() throws RemoteException {
        donHangDAO = new DonHangDAO();
    }

    @Override
    public List<DonHang> getAllDonHang() throws RemoteException {
        return donHangDAO.getAllDonHang();
    }

    @Override
    public boolean addDonHang(DonHang donHang) throws RemoteException {
        return donHangDAO.addDonHang(donHang);
    }

    @Override
    public boolean updateDonHang(DonHang donHang) throws RemoteException {
        return donHangDAO.updateDonHang(donHang);
    }

    @Override
    public boolean deleteDonHang(DonHang donHang) throws RemoteException {
        return donHangDAO.removeDonHang(donHang);
    }
}
