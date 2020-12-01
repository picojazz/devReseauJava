package com.company.tp2;



import java.rmi.Naming;

public class ClientRmi {
    public static void main(String[] args) {
        int i1=2,i2=4,res = 0;
        String nomHost="192.168.1.17", nomObjServ="Calculateur";
        CalculRmi objserv;
        ;
        try{
            objserv = (CalculRmi) Naming.lookup("rmi://"+nomHost+"/"+nomObjServ);

            res = objserv.mult(i1,i2);


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Resultat appel RMI : "+res);

    }
}
