
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diaz994
 */
public class Predictor {
    
    public static Map<Integer, Job> jobIdToJobMap = new HashMap<Integer, Job>();
    public static Map<Integer, User> userIdToUserMap = new HashMap<Integer, User>();
    public static Map<User, List<Job>> userToJobAppliedMap = new HashMap<User, List<Job>>();
    public static Map<Integer, User> userTwoIdToUserTwo = new HashMap<Integer, User>();
    public static Map<Integer, User> userOneIdToUserOne = new HashMap<Integer, User>();
    public static Map<Integer, Application> jobIdToApplication = new HashMap<Integer, Application>();
    public static Map<String, ZipCode> zipcodeToLatLong = new HashMap<String, ZipCode>();
    
    public static List<Job> jobs;
    public static List<User> users;
    public static List<Application> applications;
    
    public static final int K = 5;

    /**
     * A method that will iterate the zip codes provided by zips.tsv 
     * to map them to its lat lng values that will be used later to calculate
     * distances between two zip codes
     * @param zipCodes
     * @return a map that holds the zip code as a string with a zip code object.
     * This will be used as the mapping between zipcode and zip code object to
     * extract the lat lng values for that zip code.
     */
    private static Map<String, ZipCode> MapZipCodeToLatLng(List<ZipCode> zipCodes) {
        Map<String, ZipCode> zipCodeMap = new HashMap<String, ZipCode>();
        
        for(ZipCode zipCode : zipCodes ) {
            String zipcode = zipCode.getZipCode();
            zipCodeMap.put(zipcode, zipCode);
        }
        
        return zipCodeMap;
    }
    
    public Predictor() {
    }

    public Predictor(List<Job> jobs, List<User> users, List<Application> applications) {
        this.jobs = jobs;
        this.users = users;
        this.applications = applications;
    }
    
    /**
     * A method that will populate a hashmap based off the applications list
     * populated from apps.tsv using the job id as the key and application object
     * as the value
     * @param applications
     * @return map that will contain jobid to application 
     */
    public static Map<Integer, Application> JobIdToApplicationMap(List<Application> applications) {
        // local map to represent jobid to a certain application
        Map<Integer, Application> applicationMap = new HashMap<Integer, Application>();
        for(Application application : applications) {
            int jobId = application.getJobId();
            applicationMap.put(jobId, application);
        }
        
        return applicationMap;
    }
    
    public static Map<Integer, Job> JobIdToJobMap(List<Job> jobs) {
        Map<Integer, Job> jobMap = new HashMap<Integer, Job>();
        for(Job job : jobs) {
            int jobId = job.getJobId();
            jobMap.put(jobId, job);
        }
        
        return jobMap;
    }
    
    /**
     * A method that will iterate through the users list populated by users.tsv
     * and then it will populate a hash map with the userid as the key and the
     * user object as a value
     * @param users
     * @return a map that holds all users from users.tsv userId to user map
     */
    public static Map<Integer, User> UserIdToUserMap(List<User> users) {
        // local map that represents all users from users.tsv
        // we will subtract userstwo.tsv - users.tsv to determine the batch of
        // users one.
        Map<Integer, User> userMap = new HashMap<Integer, User>();
        for(User user : users) {
            userMap.put(user.getUserId(), user);
        }
        
        return userMap;
    }
    
    /**
     * A method that will iterate through the users list populated by user2.tsv
     * it will then populate a hash map with the userId as the key and the user
     * object as a value
     * @param usersTwo
     * @return a map that holds all users from users2.tsv userId to user map
     */
    public static Map<Integer, User> UserTwoIdToUserTwoMap(List<User> usersTwo) {
        // local map that represents a user from
        // user two file, userId to User
        // this is used to later index the user ids in 
        // the users two file to determine the subset U1
        Map<Integer, User> userTwoMap = new HashMap<Integer, User>();
        for(User userTwo : usersTwo) {
            int userId = userTwo.getUserId();
            User user = 
            userTwoMap.put(userId, userTwo);
        }
        
        return userTwoMap;
        
    }
    
    /**
     * A method that will map all the jobs that a userId applied for from
     * apps.tsv
     * @param users
     * @param applications
     * @param jobs
     * @return A map that will hold a user and the jobs he applied to
     */
    public static Map<User,List<Job>> UserToJobAppliedMap(List<User> users, List<Application> applications, List<Job> jobs) {
        // local map that will hold the users who applied to which job
        Map<User, List<Job>> userToJobAppliedMapping = new HashMap<User, List<Job>>();
        List<Job> jobsAppliedPerUser = new ArrayList<Job>();
        for(Application application : applications) {
            int userId = application.getUserId();
            int jobId = application.getJobId();
            User user = userIdToUserMap.get(userId);
            Job job = jobIdToJobMap.get(jobId);
           
            // checking if the user has been added previously, if so
            // grab its current value and add a new job to the list to the
            // current list of jobs it applied for
            // if not the add a new user with a new array list and a new job
            // added which he applied for
            if(userToJobAppliedMapping.containsKey(user)) {
                List<Job> currentJobsUserAppliedFor = userToJobAppliedMapping.get(user);
                currentJobsUserAppliedFor.add(job);
                userToJobAppliedMapping.put(user, currentJobsUserAppliedFor);
            } else {
                userToJobAppliedMapping.put(user, new ArrayList<Job>());
                userToJobAppliedMapping.get(user).add(job);
            }
            
        }
        
        return userToJobAppliedMapping;
    }
    
    /**
     * 
     * @param userIdToUserMap
     * @param users
     * @param usersTwo
     * @param userTwoIdToUserTwo
     * @return returns a map which will hold user one. 
     */
    public static Map<Integer, User> FindBatchOfUsersOne(Map<Integer, User> userIdToUserMap, List<User> users, 
                                                    List<User> usersTwo, Map<Integer, User> userTwoIdToUserTwo) {
        Map<Integer, User> userOneMap = new HashMap<Integer, User>();
        for(User user : users) {
            int userId = user.getUserId();
            if(userTwoIdToUserTwo.get(userId) == null) {
                userOneMap.put(userId, user);
            }
        }
        
        return userOneMap;
    }
    
    /**
     * This is a simple distance calculation method that calculates the distance 
     * between two Zip Codes in miles by passing the latitude and 
     * longitude coordinates found in zips.csv
     * @param latA
     * @param longA
     * @param latB
     * @param longB
     * @return the distance between two zip codes in miles
     */
    public static int calculateDistanceBetweenTwoZipCodes(double latA, double longA, double latB, double longB)
    {
        double theDistance = (Math.sin(Math.toRadians(latA)) *
                              Math.sin(Math.toRadians(latB)) +
                              Math.cos(Math.toRadians(latA)) *
                              Math.cos(Math.toRadians(latB)) *
                              Math.cos(Math.toRadians(longA - longB)));

        int miles = (int) ((Math.toDegrees(Math.acos(theDistance))) * 69.09);
        
        return miles;
    }   
    
    /**
     * A method that will extract a random user from usersTwo to classify.
     * @param usersTwo
     * @return returns a user to classify and find its nearest neighbors
     */
    private static User extractIndividualInstance(List<User> usersTwo) {
        Random generator = new Random(new Date().getTime());
        int random = generator.nextInt(usersTwo.size() - 1);
        
        User userToClassify = usersTwo.get(random);
        usersTwo.remove(random);
        
        return userToClassify;
        
    }
    
    /**
     * A method that will calculate distances from a classification user instance compared
     * to all the other users
     * @param usersTwoCopy
     * @param classificationUser
     * @return a list of all the distances from the classification instance
     * to all the other ones
     */
    private static List<Neighbor> calculateDistances(List<User> users, User classificationUser) {
        List<Neighbor> distances = new ArrayList<Neighbor>();
        Neighbor neighbor = null;
        int distance = 0;
        String zipCodeUserTwo = "";
        String zipCodeUser = "";
        ZipCode zipCodeUserObj = null;
        ZipCode classificationUserZipCodeObj = null;
        User classificationUserObj = null;
        int count = 0;
        double latUser = 0.0;
        double longUser = 0.0;
        double classificationUserLat = 0.0;
        double classificationUserLong = 0.0;
     
        for(User user : users) {
            
            if(count == 28598) {
                 System.out.println("Halting execution at iteration: " + count);
            }
            neighbor = new Neighbor();
            zipCodeUser = user.getZipCode();
            System.out.println(zipCodeUser);
            if(zipCodeUser != null) {
                String cleanedZipCode = "";
                if(zipCodeUser.contains("-")) {
                    cleanedZipCode = zipCodeUser.split("-")[0];
                    zipCodeUserObj = zipcodeToLatLong.get(cleanedZipCode);
                    latUser = zipCodeUserObj.getLatitude();
                    longUser = zipCodeUserObj.getLongitude();
                } else if(zipCodeUser.contains("`")) {
                    cleanedZipCode = zipCodeUser.split("`")[0];
                    zipCodeUserObj = zipcodeToLatLong.get(cleanedZipCode);
                    latUser = zipCodeUserObj.getLatitude();
                    longUser = zipCodeUserObj.getLongitude();
                } else if(zipCodeUser.contains("*")) {
                    cleanedZipCode = zipCodeUser.split("\\*")[0];
                    zipCodeUserObj = zipcodeToLatLong.get(cleanedZipCode);
                    latUser = zipCodeUserObj.getLatitude();
                    longUser = zipCodeUserObj.getLongitude();
                } else if(zipCodeUser.length() > 5) {
                    cleanedZipCode = zipCodeUser.substring(0, 5);
                    zipCodeUserObj = zipcodeToLatLong.get(cleanedZipCode);
                    latUser = zipCodeUserObj.getLatitude();
                    longUser = zipCodeUserObj.getLongitude();
                } else {
                    zipCodeUserObj = zipcodeToLatLong.get(zipCodeUser);
                    latUser = zipCodeUserObj.getLatitude();
                    longUser = zipCodeUserObj.getLongitude();
                }
            }

            int classificationUserId = classificationUser.getUserId();
            classificationUserObj = userIdToUserMap.get(classificationUserId);
            zipCodeUserTwo = classificationUserObj.getZipCode();
            
            if(zipCodeUserTwo != null) {
                classificationUserZipCodeObj = zipcodeToLatLong.get(zipCodeUserTwo);
                classificationUserLat = classificationUserZipCodeObj.getLatitude();
                classificationUserLong = classificationUserZipCodeObj.getLongitude();
                distance = calculateDistanceBetweenTwoZipCodes(latUser, longUser, classificationUserLat, classificationUserLong);
            }

            neighbor.setDistance(distance);
            neighbor.setUser(user);

            distances.add(neighbor);
            
            count++;
            System.out.println("Iteration: " + count);
        }
       
        
        return distances;
    }
    
    /**
     * This method will help in populating the dedicated list of users two
     * since when they are read from the file they are not populated with 
     * all of their values
     * @param usersTwo
     * @return an updated list of users two with all the pertaining values with
     * that userid
     */
    public static List<User> populateUserTwo(List<User> usersTwo) {
        List<User> populatedUsersTwo = new ArrayList<User>();
        for(User user : usersTwo) {
            int userId = user.getUserId();
            User userTwo = userIdToUserMap.get(userId);
            user.setCity(userTwo.getCity());
            user.setCountry(userTwo.getCountry());
            user.setZipCode(userTwo.getZipCode());
        }
        
        return populatedUsersTwo;
    }
    
    public static void main(String[] args) {
        TsvFileParser tsvFileParser = new TsvFileParser();
        List<Application> applications = new ArrayList<Application>();
        List<User> users = new ArrayList<User>();
        List<Job> jobs = new ArrayList<Job>();
        List<User> usersTwo = new ArrayList<User>();
        List<ZipCode> zipCodes = new ArrayList<ZipCode>();
        List<Neighbor> distances = null;
        List<User> populatedUsersTwo = null;
        
        
        User classificationUser = null;
        
        
        
        if(Constants.DEBUG) {
            
            File usersTwoFile = new File("C:\\Users\\diaz994.VictorDiazJr\\Documents\\data\\user_two.tsv");

            if(usersTwoFile.exists() == true) {
                System.out.println("user_two.tsv exists!");
            }
            
            usersTwo = tsvFileParser.ReadUsersTwoFile(usersTwoFile);
            applications = tsvFileParser.ReadApplicationTsvFile(Constants.appsFile);
            users = tsvFileParser.ReadUsersTsvFile(Constants.usersFile);
            zipCodes = tsvFileParser.ReadZipCodesFile(Constants.zipCodeMappingFile);
            jobs = tsvFileParser.ReadJobsTsvFile(Constants.jobsFile);
            
            List<User> usersTwoCopy = new ArrayList<User>(usersTwo);
            
            // mapping all the files
            jobIdToJobMap = JobIdToJobMap(jobs);
            userIdToUserMap = UserIdToUserMap(users);
            userTwoIdToUserTwo = UserTwoIdToUserTwoMap(usersTwo);
            userToJobAppliedMap = UserToJobAppliedMap(users, applications, jobs);
            userOneIdToUserOne = FindBatchOfUsersOne(userIdToUserMap, users, usersTwo, userTwoIdToUserTwo);
            zipcodeToLatLong = MapZipCodeToLatLng(zipCodes);
            populatedUsersTwo = populateUserTwo(usersTwo);
            
            classificationUser = extractIndividualInstance(usersTwoCopy);
            distances = calculateDistances(users, classificationUser);
            
        }
    }
}
