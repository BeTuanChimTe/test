package org.example.impl;

//import com.example.fashionshop.dao.NhanVienDAO;
//import com.example.fashionshop.model.NhanVien;
//import com.example.fashionshop.service.NhanVienService;
//import javafx.collections.ObservableList;
import org.example.dao.NhanVienDAO;
import org.example.model.NhanVien;
import org.example.service.NhanVienService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NhanVienServiceImpl extends UnicastRemoteObject implements NhanVienService, Serializable {


    private final NhanVienDAO nhanVienDAO;

    public NhanVienServiceImpl() throws RemoteException {
        nhanVienDAO = new NhanVienDAO();
    }

    @Override
    public List<NhanVien> getAllNhanVien() throws RemoteException{
        return nhanVienDAO.getAllNhanVien();
    }

    @Override
    public NhanVien getNhanVien(String maNhanVien) throws RemoteException{
        return nhanVienDAO.getNhanVien(maNhanVien);
    }

    @Override
    public boolean addNhanVien(NhanVien nhanVien) throws RemoteException {
        return nhanVienDAO.addNhanVien(nhanVien);
    }

    @Override
    public boolean updateNhanVien(NhanVien nhanVien) throws RemoteException {
        return nhanVienDAO.updateNhanVien(nhanVien);
    }

    @Override
    public boolean deleteNhanVien(NhanVien nhanVien) throws RemoteException {
        return nhanVienDAO.deleteNhanVien(nhanVien);
    }
}
