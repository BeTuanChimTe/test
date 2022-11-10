package org.example.impl;

import org.example.service.IDService;
import org.example.utlis.IDUtils;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IDServiceImpl extends UnicastRemoteObject implements IDService, Serializable {
    private IDUtils id;

    public IDServiceImpl() throws RemoteException {
        id = new IDUtils();
    }

    @Override
    public String createMaSanPham() throws RemoteException {
        return id.createMaSanPham();
    }

    @Override
    public String createMaDanhMuc() throws RemoteException {
        return id.createMaDanhMuc();
    }

    @Override
    public String createMaPhieuKiemKe() throws RemoteException {
        return id.createMaPhieuKiemKe();
    }

    @Override
    public String createMaDonNhapHang() throws RemoteException {
        return id.createMaDonNhapHang();
    }

    @Override
    public String createMaPhieuNhapHang() throws RemoteException {
        return id.createMaPhieuNhapHang();
    }

    @Override
    public String createMaDonHang() throws RemoteException {
        return id.createMaDonHang();
    }

    @Override
    public String createMaNhanVien() throws RemoteException {
        return id.createMaNhanVien();
    }
}
