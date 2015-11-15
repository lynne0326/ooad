package hotelpossystem.dao;

/**
 *
 * @author lingyanjiang
 */
public class DAOFactory {

    /**
     *
     * @return
     */
    public static UserDAO getUserDAOInstance() {
        return new UserDAOImplement();
    }
}
