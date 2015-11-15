package hotelpossystem.dao;

/**
 *
 * @author lingyanjiang
 */
public class DAOFactory {
    public static UserDAO getUserDAOInstance() {
        return new UserDAOImplement();
    }
}
