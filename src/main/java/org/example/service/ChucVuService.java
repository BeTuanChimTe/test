package org.example.service;

import org.example.model.ChucVu;
import org.example.model.KhachHang;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChucVuService extends Remote {
    public List<ChucVu> getAllChucVu() throws RemoteException;;

    public boolean addChucVu(ChucVu chucVu) throws RemoteException;;

    public boolean updateChucVu(ChucVu chucVu) throws RemoteException;;

    public boolean removeChucVu(ChucVu chucVu) throws RemoteException;;


}
