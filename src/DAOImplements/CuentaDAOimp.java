package DAOImplements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Cuenta;
import ModeloDAO.CuentaDAO;

public class CuentaDAOimp implements CuentaDAO {
    Conexion jdbc = new Conexion();
    final String INSERT="INSERT INTO Cuentas(NumCliente,NumCuenta,Saldo) VALUES(?,?,?)";
    final String DELETE="DELETE FROM Cuentas WHERE NumCuenta=?";
    final String UPDATE="UPDATE Cuentas SET Saldo=? WHERE NumCuenta=?";
    final String GETALL="SELECT NumCliente,NumCuenta,Saldo FROM Cuentas";
    final String GETONE="SELECT NumCliente,NumCuenta,Saldo FROM Cuentas WHERE NumCuenta=?";
    @Override
    public void agregar(Cuenta e) throws DAOException {
        PreparedStatement statement=null;
        try {
           statement = jdbc.conectar().prepareStatement(INSERT);
           statement.setLong(1, e.getNumeroCliente());
           statement.setLong(2, e.getNumeroCuenta());
           statement.setDouble(3, e.getSaldo());
           if(statement.executeUpdate()==0){
            throw new DAOException("No se pudo guardar");
           }
              
        }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        }finally {
            if(statement != null){
                try {
                  statement.close();
                  jdbc.desconectar();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Cuenta e) throws DAOException {
        PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(DELETE);
            statement.setLong(1,e.getNumeroCuenta());
           
            if(statement.executeUpdate()==0){
                throw new DAOException("No se pudo eliminar");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                   jdbc.desconectar();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL",ex);
                }
            }
        }
    }

    @Override
    public void modificar(Cuenta e) throws DAOException {
        PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(UPDATE);
            statement.setDouble(1,e.getSaldo());
            statement.setLong(2, e.getNumeroCuenta());
            if(statement.executeUpdate()==0){
                throw new DAOException("No se pudo modificar");
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                    jdbc.desconectar();
                } catch (SQLException ex) {
                    throw new DAOException("Error SQL",ex);
                }
            }
        }
    }

    @Override
    public Cuenta obtener(Integer id) throws DAOException {
        PreparedStatement statement=null;
        ResultSet rs =null;
        Cuenta cuentaEncontrado=null;
        try {
            statement = jdbc.conectar().prepareStatement(GETONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            if(rs.next()){
                cuentaEncontrado = convertir(rs);
            }else{
                System.out.println("No se encuentra el elemento en la base de datos");
                cuentaEncontrado=null;
            }
            
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(rs !=null){
                try {
                    rs.close();
                   
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
            if(statement != null){
                try {
                    statement.close();
                    jdbc.desconectar();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return cuentaEncontrado;
    }

    @Override
    public List<Cuenta> obtenerTodos() throws DAOException {
        PreparedStatement statement=null;
        ResultSet rs =null;
        List<Cuenta> cuentasEncontrados= new ArrayList<>();
        try {
            statement = jdbc.conectar().prepareStatement(GETALL);
            rs = statement.executeQuery();
            while(rs.next()){
                cuentasEncontrados.add(convertir(rs));
            }      
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
        }finally{
            if(rs !=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
            if(statement != null){
                try {
                    statement.close();
                    jdbc.desconectar();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL",ex);
                }
            }
        }
        return cuentasEncontrados;
    }

    private Cuenta convertir(ResultSet rs) throws SQLException{
        long NumCliente = rs.getLong("NumCliente");
        long NumCuenta = rs.getLong("NumCuenta"); 
         double Saldo = rs.getDouble("Saldo");
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCliente(NumCliente);
        cuenta.setNumeroCuenta(NumCuenta);
        cuenta.setSaldo(Saldo);
        return cuenta ;
    }
    
}
