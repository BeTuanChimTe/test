package org.example.impl;

//import com.example.fashionshop.dao.DanhMucDAO;
//import com.example.fashionshop.model.DanhMuc;
//import com.example.fashionshop.service.DanhMucService;
//import javafx.collections.ObservableList;
import org.example.dao.DanhMucDAO;
import org.example.dao.TaiKhoanDAO;
import org.example.model.DanhMuc;
import org.example.model.TaiKhoan;
import org.example.service.DanhMucService;
import org.example.service.TaiKhoanService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class TaiKhoanServiceImpl extends UnicastRemoteObject implements TaiKhoanService, Serializable {

    private TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanServiceImpl() throws RemoteException {
        taiKhoanDAO= new TaiKhoanDAO();
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoan() throws RemoteException {
        return taiKhoanDAO.getAllTaiKhoan();
    }

    @Override
    public boolean addTaiKhoan(TaiKhoan taiKhoan)throws RemoteException {
        return taiKhoanDAO.addTaiKhoan(taiKhoan);
    }

    @Override
    public boolean updateTaiKhoan(TaiKhoan taiKhoan)throws RemoteException {
        return taiKhoanDAO.updateTaiKhoan(taiKhoan);
    }

    @Override
    public boolean removeTaiKhoan(TaiKhoan taiKhoan)throws RemoteException {
        return taiKhoanDAO.deleteTaiKhoan(taiKhoan);
    }

    @Override
    public TaiKhoan getTaiKhoanById(String category_id)throws RemoteException {
        return taiKhoanDAO.getTaiKhoan(category_id);
    }

    @Override
    public boolean mergeTaiKhoan(TaiKhoan taiKhoan) throws RemoteException {
        return taiKhoanDAO.mergeTaiKhoan(taiKhoan);
    }
}
