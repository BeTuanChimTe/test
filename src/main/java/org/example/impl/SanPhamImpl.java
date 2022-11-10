package org.example.impl;

import org.example.dao.SanPhamDAO;
import org.example.model.DanhMuc;
import org.example.model.SanPham;
import org.example.service.SanPhamService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SanPhamImpl extends UnicastRemoteObject implements SanPhamService , Serializable {


    private SanPhamDAO sanPhamDAO;

    public SanPhamImpl() throws RemoteException {
        sanPhamDAO = new SanPhamDAO();
    }

    @Override
    public List<SanPham> getAllSanPham()throws RemoteException {
        return sanPhamDAO.getAllSanPham();
    }

    @Override
    public SanPham getSanPham(String maSanPham)throws RemoteException {
        return sanPhamDAO.getSanPham(maSanPham);
    }

    @Override
    public boolean addSanPham(SanPham sanPham)throws RemoteException {
        return sanPhamDAO.addSanPham(sanPham);
    }

    @Override
    public boolean updateSanPham(SanPham sanPham)throws RemoteException {
        return sanPhamDAO.updateSanPham(sanPham);
    }

    @Override
    public boolean removeSanPham(SanPham sanPham)throws RemoteException {
        return sanPhamDAO.removeSanPham(sanPham);
    }

    @Override
    public List<SanPham> getAllSanPhamFromDanhMuc(DanhMuc danhMuc, int top) throws RemoteException{
        return sanPhamDAO.getAllSanPhamFromDanhMuc(danhMuc, top);
    }

    @Override
    public List<SanPham> getAllSanPhamFromDanhMuc(DanhMuc danhMuc) throws RemoteException{
        return sanPhamDAO.getAllSanPhamFromDanhMuc(danhMuc);
    }
    @Override
    public  boolean mergeSanPham(SanPham sanPham)throws RemoteException{
        return sanPhamDAO.mergeSanPham(sanPham);
    }
}
