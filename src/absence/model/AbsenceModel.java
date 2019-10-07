package absence.model;

import java.util.List;

import absence.beans.AbsenceBeans;
import absence.model.dao.AbsenceDao;

public class AbsenceModel {
    public List<AbsenceBeans> getList(String userId) {
        AbsenceDao absenceDao = new AbsenceDao();
        List<AbsenceBeans> list = null;

        try {
            absenceDao.connect();
            list = absenceDao.getList(userId);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            absenceDao.close();
        }

        return list;
    }

    public void insert(AbsenceBeans absenceBeans) {
        AbsenceDao absenceDao = new AbsenceDao();

        try {
            absenceDao.connect();
            absenceDao.insert(absenceBeans);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            absenceDao.close();
        }
    }

    public AbsenceBeans getAbsence(String userId, int absenceId) {
        AbsenceDao absenceDao = new AbsenceDao();
        AbsenceBeans absenceBeans = null;

        try {
            absenceDao.connect();
            absenceBeans = absenceDao.getAbsence(userId, absenceId);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            absenceDao.close();
        }

        return absenceBeans;
    }
}
