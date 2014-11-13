/***
 * This is the user object with all of its properties for each user
 * @author Victor Diaz
 */
public class User implements Comparable<User>{
    private Integer UserId;
    private String City;
    private String State;
    private String Country;
    private String ZipCode;
    private String DegreeType;
    private String Major;
    private String GraduationDate;
    private Integer WorkHistoryCount;
    private Integer TotalYearsExperience;
    private Boolean CurrentlyEmployed;
    private Boolean ManagedOthers;
    private Integer ManagedHowMany;

    public User() {
        super();
    }

    public User(Integer userId) {
        super();
        this.UserId = userId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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

    public String getDegreeType() {
        return DegreeType;
    }

    public void setDegreeType(String degreeType) {
        DegreeType = degreeType;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getGraduationDate() {
        return GraduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        GraduationDate = graduationDate;
    }

    public Integer getWorkHistoryCount() {
        return WorkHistoryCount;
    }

    public void setWorkHistoryCount(Integer workHistoryCount) {
        WorkHistoryCount = workHistoryCount;
    }

    public Integer getTotalYearsExperience() {
        return TotalYearsExperience;
    }

    public void setTotalYearsExperience(Integer totalYearsExperience) {
        TotalYearsExperience = totalYearsExperience;
    }

    public Boolean isCurrentlyEmployed() {
        return CurrentlyEmployed;
    }

    public void setCurrentlyEmployed(Boolean currentlyEmployed) {
        CurrentlyEmployed = currentlyEmployed;
    }

    public Boolean isManagedOthers() {
        return ManagedOthers;
    }

    public void setManagedOthers(Boolean managedOthers) {
        ManagedOthers = managedOthers;
    }

    public Integer getManagedHowMany() {
        return ManagedHowMany;
    }

    public void setManagedHowMany(Integer managedHowMany) {
        ManagedHowMany = managedHowMany;
    }

    @Override
    public int compareTo(User user) {
        int comparedUserId = ((User) user).getUserId();

        return comparedUserId - this.UserId;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", DegreeType='" + DegreeType + '\'' +
                ", Major='" + Major + '\'' +
                ", GraduationDate='" + GraduationDate + '\'' +
                ", WorkHistoryCount=" + WorkHistoryCount +
                ", TotalYearsExperience=" + TotalYearsExperience +
                ", CurrentlyEmployed=" + CurrentlyEmployed +
                ", ManagedOthers=" + ManagedOthers +
                ", ManagedHowMany=" + ManagedHowMany +
                '}';
    }
}
