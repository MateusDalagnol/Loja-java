package implementations_dao;


import db.DB;
import interface_dao.ClienteDao;

public class DaoFactory {

    public static ClienteDao createClienteDao(){
        return new ClienteDaoJDBC(DB.getConnection());

    }
}
