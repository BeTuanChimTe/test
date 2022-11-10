package org.example.impl;

import org.example.dao.XaPhuongDAO;
import org.example.model.XaPhuong;
import org.example.service.XaPhuongService;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class XaPhuongServiceImpl extends UnicastRemoteObject implements XaPhuongService, Serializable {

    private XaPhuongDAO xaPhuongDAO;

    public XaPhuongServiceImpl() throws RemoteException {
        xaPhuongDAO = new XaPhuongDAO();
    }

    @Override
    public boolean addXaPhuong(XaPhuong xaPhuong) throws RemoteException {
        return xaPhuongDAO.addXaPhuong(xaPhuong);
    }

    @Override
    public List<XaPhuong> getAllXaPhuong() throws RemoteException {
        return xaPhuongDAO.getAllXaPhuong();
    }

    @Override
    public List<XaPhuong> getXaPhuongInQuanHuyen(String maQuanHuyen) throws RemoteException {
        return xaPhuongDAO.getXaPhuongInQuanHuyen(maQuanHuyen);
    }

    @Override
    public XaPhuong getXaPhuongById(String id) throws RemoteException {
        return xaPhuongDAO.getXaPhuongById(id);
    }
}
