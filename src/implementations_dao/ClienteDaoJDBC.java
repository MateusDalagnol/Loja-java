package implementations_dao;

import db.DB;
import db.DbException;
import interface_dao.ClienteDao;
import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {


    private Connection conn;

    public ClienteDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO cliente " +
                    "(Nome,Email) " +
                    "VALUES " +
                    "(?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getEmail());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            } else {
                throw new DbException("Unexpected error! No rows affeted!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void updateNome(String nome, int id) {
        PreparedStatement st;
        st = null;

        try{
            st = conn.prepareStatement("UPDATE cliente SET Nome = ? WHERE id = ?");

            st.setString(1, nome);
            st.setInt(2, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void updateEmail(String email, int id) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement("UPDATE cliente SET Email = ? WHERE id = ?");

            st.setString(1, email);
            st.setInt(2, id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Cliente findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM cliente WHERE Id = ?");

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                return instantiateCliente(rs);
            }
            return null;
        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {

            DB.closeStatement(st);
            DB.closeResultSet(rs);

        }
    }

    @Override
    public List<Cliente> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM cliente ORDER BY Nome");

            rs = st.executeQuery();

            List<Cliente> clientes = new ArrayList<>();

            while (rs.next()) {
                Cliente cliente = instantiateCliente(rs);
                clientes.add(cliente);
            }

            return clientes;
        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {

            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Cliente> findByName(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            st = conn.prepareStatement("SELECT * FROM cliente WHERE Nome = ?");

            st.setString(1, nome);
            rs = st.executeQuery();

            while(rs.next()){
                Cliente cliente = instantiateCliente(rs);
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException e) {

            throw new DbException(e.getMessage());

        } finally {

            DB.closeStatement(st);
            DB.closeResultSet(rs);

        }
    }

    private Cliente instantiateCliente(ResultSet rs) throws SQLException {

        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("Id"));
        cliente.setNome(rs.getString("Nome"));
        cliente.setEmail(rs.getString("Email"));

        return cliente;
    }
}
