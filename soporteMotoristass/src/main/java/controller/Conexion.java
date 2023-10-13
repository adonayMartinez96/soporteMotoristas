package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection con;

    //ESTADO: PRODUCCIOn
    //UAT
   /* private static  final String user = "root";
    private static  final String pass = "alianza96";
    private static  final String url = "jdbc:mysql://localhost/impadi";*/

    //PRODUCCION
   private static  final String user = "silverposfx";
    private static  final String pass = "Sistemas1504@$";
    private static  final String url = "jdbc:mysql://localhost/silverpos";

    public Connection conectar(){
        con = null;
        try{
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("conectado");
            if(con!=null){
                System.out.println("conexion establecida");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

}
