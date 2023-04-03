package DAOImplements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;

public class ClienteDAOimp implements ClienteDAO {
    Conexion jdbc = new Conexion();
    final String INSERT="INSERT INTO Clientes(NumCliente, NombreCliente) VALUES(?,?)";
    final String DELETE="DELETE FROM Clientes WHERE NumCliente=?";
    final String UPDATE="UPDATE Clientes SET NombreCliente=? WHERE NumCliente=?";
    final String GETALL="SELECT NumCliente,NombreCliente FROM Clientes";
    final String GETONE="SELECT NumCliente,NombreCliente FROM Clientes WHERE NumCliente=?";

    /* (non-Javadoc)
     * @see ModeloDAO.DAO#agregar(java.lang.Object)
     */
    @Override
    public void agregar(Cliente cliente) throws DAOException {
        PreparedStatement statement=null;
        try {
           statement = jdbc.conectar().prepareStatement(INSERT);
           statement.setLong(1,cliente.getNumeroCliente());
           statement.setString(2, cliente.getNombreCliente());
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
    public void eliminar(Cliente cliente) throws DAOException {
        PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(DELETE);
            statement.setLong(1,cliente.getNumeroCliente());
           
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
    public void modificar(Cliente cliente) throws DAOException {
        PreparedStatement statement=null;
        try {
            statement = jdbc.conectar().prepareStatement(UPDATE);
            statement.setString(1,cliente.getNombreCliente());
            statement.setLong(2, cliente.getNumeroCliente());
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
    public Cliente obtener(Integer id) throws DAOException {
        PreparedStatement statement=null;
        ResultSet rs =null;
        Cliente clienteEncontrado=null;
        try {
            statement = jdbc.conectar().prepareStatement(GETONE);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            
            if(rs.next()){
                clienteEncontrado = convertir(rs);
            }else{
                System.out.println("No se encuentra el elemento en la base de datos");
                clienteEncontrado=null;
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
        return clienteEncontrado;
    }

    @Override
    public List<Cliente> obtenerTodos() throws DAOException {
        PreparedStatement statement=null;
        ResultSet rs =null;
        List<Cliente> clientesEncontrados= new ArrayList<>();
        try {
            statement = jdbc.conectar().prepareStatement(GETALL);
            rs = statement.executeQuery();
            while(rs.next()){
                clientesEncontrados.add(convertir(rs));
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
        return clientesEncontrados;
    }

    private Cliente convertir(ResultSet rs) throws SQLException{
        long NumCliente = rs.getLong("NumCliente");
        String nombreCliente = rs.getString("NombreCliente");
        Cliente cliente = new Cliente();
        cliente.setNumeroCliente(NumCliente);
        cliente.setNombreCliente(nombreCliente);
        return cliente;
    }
    
}
