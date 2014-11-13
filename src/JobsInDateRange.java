
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diaz994
 */
public class JobsInDateRange {
    private List<Job> jobsInDateRangeT1 = new ArrayList<Job>();
    private List<Job> jobsInDateRangeT2 = new ArrayList<Job>();

    public List<Job> getJobsInDateRangeT1() {
        return jobsInDateRangeT1;
    }

    public void setJobsInDateRangeT1(List<Job> jobsInDateRangeT1) {
        this.jobsInDateRangeT1 = jobsInDateRangeT1;
    }

    public List<Job> getJobsInDateRangeT2() {
        return jobsInDateRangeT2;
    }

    public void setJobsInDateRangeT2(List<Job> jobsInDateRangeT2) {
        this.jobsInDateRangeT2 = jobsInDateRangeT2;
    }    
}
