package com.company.tp2;

public interface CalculRmi extends java.rmi.Remote {
    public int plus(int un,int deux) throws java.rmi.RemoteException;
    public int mult(int un,int deux) throws java.rmi.RemoteException;

}
