package controller;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;*/

import java.sql.*;
import Model.expresiones.ExpresionRelacional;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * @author gmc_2
 */

public class Controller {
    static private Connection conexion;
    static private ArrayList<String> tablasTemporales;
    
    // Inicializa la conexion con la base de datos.
    public static void inicializar(String usuario, String pass) throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;"
                    + "user=" +
                    usuario + ";password=" +  pass;
            conexion = DriverManager.getConnection(connectionUrl);
            conexion.setCatalog("RESERVACIONESDB");
            conexion.setSchema("dbo");
            
            tablasTemporales = new ArrayList<String>();
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ExpresionRelacional obtenerOperacion(String tipo, String tabla, String tabla2,
            String predicado, String tablaResultante) throws Exception{
        return Factory.crearExpresion(tipo, tabla, tabla2, predicado, tablaResultante);
    }
    
    // Metodo encargado de crear una expresion algebraica
    public static ResultSet realizarOperacion(ExpresionRelacional relacion) throws Exception{
        
        try{
            ResultSet res = realizarOperacionAux(relacion);
            return res;
        }catch(SQLException e){
            
            // Cuando hay una tabla resultante inicialmente no da conjunto de resultados
            // Se hace un query seleccionando todo de la tabla resultante
            if(e.getErrorCode() == 0){
                try{
                    tablasTemporales.add(relacion.obtenerTablaResultante());
                    String query = "SELECT * FROM " + relacion.obtenerTablaResultante();
                    Statement stmt = conexion.createStatement();
                    return stmt.executeQuery(query);
                }catch(Exception e2){
                    throw e2;
                }
            }
            else{
                throw e;
            }
        }
    }
    
    public static ResultSet realizarOperacionAux(ExpresionRelacional expresion)throws Exception{
        Statement stmt = null;
        
        try {
            stmt = conexion.createStatement();
            String query = expresion.obtenerQuery();
            ResultSet res = stmt.executeQuery(query);
            return res;
            
        } catch (Exception e ) {
            throw e;
        }
    }
    
    public static ArrayList<String> obtenerNombreDeTablas() throws Exception{
        try{
            //Obtiene la info de la BD
            DatabaseMetaData metaDatos = conexion.getMetaData();
            ArrayList<String> resultados = new ArrayList<>();
            String[] types = {"TABLE", "VIEW"};
            ResultSet tablas = metaDatos.getTables("RESERVACIONESDB", "dbo", null, types);
            
            //Itera las tablas obteniendo la info de cada tabla
            while(tablas.next()){
                try{
                    resultados.add(tablas.getString(3));
                }catch(Exception e){
                    // do nothing
                }
            }
            return resultados;
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<ResultSet> obtenerTodaInformacion() throws Exception{
        try{
            //Obtiene la info de la BD
            DatabaseMetaData metaDatos = conexion.getMetaData();
            ArrayList<ResultSet> resultados = new ArrayList<>();
            String[] types = {"TABLE", "VIEW"};
            ResultSet tablas = metaDatos.getTables(null, null, null, types);
            
            //Itera las tablas obteniendo la info de cada tabla
            while(tablas.next()){
                try{
                    Statement stmt = conexion.createStatement();
                    String query = "SELECT * FROM " + tablas.getString(3);
                    ResultSet res = stmt.executeQuery(query);
                    resultados.add(res);
                }catch(Exception e){
                    // do nothing
                }
            }
            return resultados;
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<String> obtenerColumnas(String tabla) throws Exception{
        try{
            // Obtiene info de la base
            DatabaseMetaData metaDatos = conexion.getMetaData();
            ResultSet result = metaDatos.getColumns(
                    null, null, tabla, null);
            ArrayList<String> columnas = new ArrayList<>();
            
            // Itera por cada columna en la tabla
            while(result.next())
                columnas.add(result.getString(4)); // Escribe el nombre de la columna a la lista
            
            return columnas;
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<String> obtenerColumnasQuery(ResultSet res) throws Exception{
        try{
            ArrayList<String> columnas = new ArrayList<>();
            ResultSetMetaData metaDatos = res.getMetaData();
            
            for(int i = 1; i <= metaDatos.getColumnCount(); i++){
                columnas.add(metaDatos.getColumnLabel(i));
            }
            
            return columnas;
            
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<String> obtenerLlavePrimaria(String tabla) throws Exception{
        try{
            // Obtiene info de la base
            DatabaseMetaData metaDatos = conexion.getMetaData();
            ResultSet result = metaDatos.getPrimaryKeys(
                null, null, tabla);
            ArrayList<String> columnasPrimarias = new ArrayList<>();
            
            // Itera por cada columna que forma parte de la PK
            while(result.next())
                columnasPrimarias.add(result.getString(4)); // Escribe el nombre de la columna a la lista
            
            return columnasPrimarias;
        }catch(Exception e){
            throw e;
        }
    }
    
    public static Connection getConexion(){
        return conexion;
    }
    
    public static void cerrarConexion() throws Exception{
        try{
            
            // Borra las tablas "temporales"
            for(String tabla : tablasTemporales){
                String query = "DROP TABLE IF EXISTS " + tabla;
                Statement stmt = conexion.createStatement();
                stmt.executeQuery(query);
            }
            
            if(!conexion.isClosed())
                conexion.close();
            
        }catch(SQLException e){
            // Hay una excepcion ya que el query no da un resultado
            if(e.getErrorCode() != 0)
                throw e;
        }
    }
    
    /*
    Metodos relacionados con interfaz
    */
    
    public static void mostrarMensaje(JFrame parent, Exception e){
        JOptionPane.showMessageDialog(parent, 
                manejarExcepcion(e), "Alerta!", 0);
    }
    
    private static String manejarExcepcion(Exception e){
        if(e instanceof SQLException){
            switch(((SQLException) e).getErrorCode()){
                //Nombre de atributo incorrecto o no existe
                case 207:
                    return "ERROR: NO EXISTE EL ATRIBUTO" 
                            + obtenerValorConflictivo(e.getMessage());
                            
                // Tabla no existe
                case 208:
                    return "ERROR: NO EXISTE LA TABLA" 
                            + obtenerValorConflictivo(e.getMessage());
                //Nombre de atributo ambiguo
                case 209:
                    return "ERROR: EL ATRIBUTO ES AMBIGUO" 
                            + obtenerValorConflictivo(e.getMessage());
                
                case 205:
                    return "ERROR: TABLAS CON DIFERENTE ARIDAD.";
                    
                default:
                    return "Ha ocurrido un error en la ultima operacion.\n"
                            + e.getMessage();
            }
        }
        else{
            return e.getMessage();
        }
    }
    
    private static String obtenerValorConflictivo(String mensaje){
        return mensaje.split("\'")[1].split("\'")[0];
    }
    
    
}
