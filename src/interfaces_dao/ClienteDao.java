package interfaces_dao;

import model.Cliente;
import java.util.List;

public interface ClienteDao {

    void insert(Cliente obj);
    void updateNome(String nome, int id);
    void updateEmail(String email, int id);
    void deleteById(Integer id);
    Cliente findById(Integer id);
    List<Cliente> findAll();
    List<Cliente> findByName(String nome);
}
