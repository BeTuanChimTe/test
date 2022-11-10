package org.example.service;

import org.example.model.QuanHuyen;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuanHuyenService extends Remote {

    public boolean addQuanHuyen(QuanHuyen quanHuyen) throws RemoteException;
    public List<QuanHuyen> getAllQuanHuyen() throws RemoteException;
    public List<QuanHuyen> getQuanHuyenInTinhTP(String maTinhTP) throws RemoteException;
    public QuanHuyen getQuanHuyenById(String id) throws RemoteException;

}
