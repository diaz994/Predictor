/***
 * The UserHistory object and all of its properties
 * @author Victor Diaz
 */
public class UserHistory {
    private Integer UserId;
    private Integer Sequence;
    private String JobTitle;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getSequence() {
        return Sequence;
    }

    public void setSequence(Integer sequence) {
        Sequence = sequence;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }
}
