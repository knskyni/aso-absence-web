package absence.beans;

import java.io.Serializable;
import java.util.Date;

public class AbsenceBeans implements Serializable {
    private String absenceId;
    private String userId;
    private Date absenceDate;
    private String companyName;
    private String reason;

    public String getAbsenceId() {
        return absenceId;
    }

    public void setAbsenceId(String absenceId) {
        this.absenceId = absenceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(Date absenceDate) {
        this.absenceDate = absenceDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
