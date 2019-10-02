package absence.model;

import absence.beans.LoginInfoBeans;
import absence.model.dao.UserDao;

public class LoginModel {
    public LoginInfoBeans login(String userId, String password) {
        UserDao userDao = new UserDao();
        LoginInfoBeans loginInfoBeans = null;

        try {
            userDao.connect();
            loginInfoBeans = userDao.getBy(userId, password);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            userDao.close();
        }

        return loginInfoBeans;
    }
}
