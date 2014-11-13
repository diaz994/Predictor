/***
 * This is the object that represents a job and all its properties
 * @author Victor Diaz
 */
public class Job {
    private Integer JobId;
    private String Title;
    private String Description;
    private String Requirements;
    private String City;
    private String State;
    private String Country;
    private String ZipCode;
    private String StartDate;
    private String EndDate;
    
    private Integer rank;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getJobId() {
        return JobId;
    }

    public void setJobId(Integer jobId) {
        JobId = jobId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRequirements() {
        return Requirements;
    }

    public void setRequirements(String requirements) {
        Requirements = requirements;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    @Override
    public String toString() {
        return "Job{" + "JobId=" + JobId + ", Title=" + Title + ", Description=" 
                + Description + ", Requirements=" + Requirements + ", City=" + City 
                + ", State=" + State + ", Country=" + Country + ", ZipCode=" + ZipCode 
                + ", StartDate=" + StartDate + ", EndDate=" + EndDate + '}';
    }
    
    
}
