package absence.model;

import absence.beans.LoginInfoBeans;
import absence.model.dao.UserDao;

public class LoginModel {
    public LoginInfoBeans login(String userId, String password) {
        UserDao userDao = new UserDao();

        userDao.connect();
        LoginInfoBeans loginInfoBeans = userDao.getBy(userId, password);

        return loginInfoBeans;
    }
}
