package absence.model;

import java.util.List;

import absence.beans.AbsenceBeans;
import absence.model.dao.AbsenceDao;

public class AbsenceModel {
    public List<AbsenceBeans> getList(String userId) {
        AbsenceDao absenceDao = new AbsenceDao();
        List<AbsenceBeans> absenceList = null;

        try {
            absenceDao.connect();
            absenceList = absenceDao.getList(userId);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            absenceDao.close();
        }

        return absenceList;
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
}
