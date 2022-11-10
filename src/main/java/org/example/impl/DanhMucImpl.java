package org.example.impl;

//import com.example.fashionshop.dao.DanhMucDAO;
//import com.example.fashionshop.model.DanhMuc;
//import com.example.fashionshop.service.DanhMucService;
//import javafx.collections.ObservableList;
import org.example.dao.DanhMucDAO;
import org.example.model.DanhMuc;
import org.example.service.DanhMucService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DanhMucImpl extends UnicastRemoteObject implements DanhMucService , Serializable {

    private DanhMucDAO danhMucDAO;

    public DanhMucImpl() throws RemoteException {
        danhMucDAO= new DanhMucDAO();
    }

    @Override
    public List<DanhMuc> getAllCategory() throws RemoteException {
        return danhMucDAO.getAllCategory();
    }

    @Override
    public boolean addCategory(DanhMuc danhMuc)throws RemoteException {
        return danhMucDAO.addCategory(danhMuc);
    }

    @Override
    public boolean updateCategory(DanhMuc danhMuc)throws RemoteException {
        return danhMucDAO.updateCategory(danhMuc);
    }

    @Override
    public boolean removeCategory(DanhMuc danhMuc)throws RemoteException {
        return danhMucDAO.updateCategory(danhMuc);
    }

    @Override
    public DanhMuc getCategoryById(String category_id)throws RemoteException {
        return danhMucDAO.getCategoryById(category_id);
    }
}
