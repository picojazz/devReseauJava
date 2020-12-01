package com.company.tp2;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ObjServeurRmi extends UnicastRemoteObject implements CalculRmi {
    private String nom0bjServeur;
    public ObjServeurRmi(String s) throws RemoteException {
        super();
        nom0bjServeur = s;
    }
    public String getNomObjServeur() {
        return nom0bjServeur;
    }
    @Override
    public int plus(int a,int b) throws RemoteException{
        return a+b;
    }
    @Override
    public int mult(int a,int b) throws RemoteException{
        return a*b;
    }
    static public void main(String arg[]) {
        System.setSecurityManager(new SecurityManager());

        try {
            LocateRegistry.createRegistry(1099);
            ObjServeurRmi srmi = new ObjServeurRmi("Calculateur");
            Naming.rebind("//localhost/Calculateur", srmi);
            System.out.println("Enregistrement objet-serv OK");
        }catch(Exception e) {
            System.out.println("Pb enregistrement service: " + e.getMessage());
            System.exit(1);
        }
    }
}