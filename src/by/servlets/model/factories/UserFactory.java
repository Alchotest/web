package by.servlets.model.factories;

import by.servlets.consts.ConstantsJSP;
import by.servlets.exceptions.InitException;
import by.servlets.ifaces.UserDAO;
import by.servlets.model.impl.UserImplDb;

import java.util.ResourceBundle;

public class UserFactory {
    private static UserDAO userImpl;

    private enum Sources{
        DB{
            UserDAO getImpl()throws InitException {
                return new UserImplDb();
            }
        };
        abstract UserDAO getImpl() throws InitException;
    }

    public static void init(ResourceBundle resourceBundle) throws InitException{
        Sources sources = Sources.valueOf(resourceBundle.getString(ConstantsJSP.USER_SOURCE).toUpperCase());
        userImpl = sources.getImpl();
    }

    public static UserDAO getClassFromFactory(){
        return  userImpl;
    }
}
