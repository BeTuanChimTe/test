package org.example.impl;

import org.example.dao.KhachHangDAO;
import org.example.dao.QuanHuyenDAO;
import org.example.model.KhachHang;
import org.example.service.KhachHangService;
import org.example.service.QuanHuyenService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class KhachHangServiceImpl extends UnicastRemoteObject implements KhachHangService, Serializable {
    private KhachHangDAO khachHangDAO;
    public KhachHangServiceImpl() throws RemoteException {
        khachHangDAO = new KhachHangDAO();
    }

    @Override
    public List<KhachHang> getAllCustomer() throws RemoteException {
        return khachHangDAO.getAllCustomer();
    }

    @Override
    public boolean addCustomer(KhachHang khachHang) throws RemoteException {
        return khachHangDAO.addCustomer(khachHang);

    }

    @Override
    public boolean updateCustomer(KhachHang khachHang) throws RemoteException {
        return khachHangDAO.updateCustomer(khachHang);
    }

    @Override
    public boolean removeCustomer(KhachHang khachHang) throws RemoteException {
        return khachHangDAO.removeCustomer(khachHang);
    }
}
