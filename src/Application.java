/***
 * The Application Object and all its properties
 * @author Victor Diaz
 */
public class Application  implements Comparable<Application> {
    private Integer UserId;
    private String ApplicationDate;
    private Integer JobId;
    public static Integer numberOfApps;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getApplicationDate() {
        return ApplicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        ApplicationDate = applicationDate;
    }

    public Integer getJobId() {
        return JobId;
    }

    public void setJobId(Integer jobId) {
        JobId = jobId;
    }

    @Override
    public int compareTo(Application application) {
        int comparedUserId = ((Application) application).getUserId();

        return comparedUserId - this.UserId;
    }

    @Override
    public String toString() {
        return "Application{" +
                "UserId=" + UserId +
                ", ApplicationDate='" + ApplicationDate + '\'' +
                ", JobId=" + JobId +
                '}';
    }
}
