package org.example.service;

import org.example.model.VaiTroNhomQuyen;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VaiTroNhomQuyenService extends Remote {
    public List<VaiTroNhomQuyen> getAllVaiTroNhomQuyen() throws RemoteException;;

    public boolean addVaiTroNhomQuyen(VaiTroNhomQuyen vaiTro) throws RemoteException;;
    public  boolean mergeVaiTroNhomQuyen(VaiTroNhomQuyen vaiTroNhomQuyen)throws RemoteException;;
//
//    public boolean updateVaiTroNhomQuyen(VaiTroNhomQuyen vaiTro) throws RemoteException;;
//
//    public boolean removeVaiTroNhomQuyen(VaiTroNhomQuyen vaiTro) throws RemoteException;;


}
