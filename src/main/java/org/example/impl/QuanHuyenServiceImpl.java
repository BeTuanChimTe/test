package org.example.impl;

import org.example.dao.QuanHuyenDAO;
import org.example.model.QuanHuyen;
import org.example.service.QuanHuyenService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class QuanHuyenServiceImpl extends UnicastRemoteObject implements QuanHuyenService, Serializable {

    private QuanHuyenDAO quanHuyenDAO;

    public QuanHuyenServiceImpl() throws RemoteException {
        quanHuyenDAO = new QuanHuyenDAO();
    }

    @Override
    public boolean addQuanHuyen(QuanHuyen quanHuyen) throws RemoteException {
        return quanHuyenDAO.addQuanHuyen(quanHuyen);
    }

    @Override
    public List<QuanHuyen> getAllQuanHuyen() throws RemoteException {
        return quanHuyenDAO.getAllQuanHuyen();
    }

    @Override
    public List<QuanHuyen> getQuanHuyenInTinhTP(String maTinhTP) throws RemoteException {
        return quanHuyenDAO.getQuanHuyenInTinhTP(maTinhTP);
    }

    @Override
    public QuanHuyen getQuanHuyenById(String id) throws RemoteException {
        return quanHuyenDAO.getQuanHuyenById(id);
    }
}
