import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * The is the tsv file parser for each file
 * @author Victor Diaz
 */
public class TsvFileParser {
    /***
     * This method will take in the applications file and read it
     * It will create a new application object for each row in the applications
     * file.
     * @param appsFile
     * @return applications
     */
    public List<Application> ReadApplicationTsvFile(File appsFile) {
        int lineCount = 0;
        List<Application> applications = null;

        try {
            lineCount = countLines(appsFile.getAbsolutePath());

            InputStream inputStream = new FileInputStream(Constants.appsFile);
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(inputStream));

            applications = new ArrayList<Application>(lineCount-1);
            Constants.numberOfApplications = lineCount - 1;

            String fileLine = "";

            while((fileLine = reader.readLine()) != null) {

                String[] columns = fileLine.split("\t");

                if (columns[0].equals("UserID") == true) {
                    continue;
                }

                Application application = new Application();

                application.setUserId(Integer.parseInt(columns[0]));

                if(columns[1] == null){
                    application.setApplicationDate(null);
                } else {
                    application.setApplicationDate(columns[1]);
                }

                application.setJobId(Integer.parseInt(columns[2]));

                applications.add(application);

            }
            reader.close();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }

        return applications;
    }

    /***
     * This method will take in the users file, read it, and store each
     * user in a new user object and add that to a list.
     * @param usersFile
     * @return users
     */
    public List<User> ReadUsersTsvFile(File usersFile) {
        int lineCount = 0;
        List<User> users = null;

        try {
            lineCount = countLines(usersFile.getAbsolutePath());

            InputStream inputStream = new FileInputStream(Constants.usersFile);
            BufferedReader reader;
            reader = new BufferedReader(new InputStreamReader(inputStream));

            users = new ArrayList<User>(lineCount-1);

            String fileLine = "";

            while((fileLine = reader.readLine()) != null) {

                String[] columns = fileLine.split("\t");

                if (columns[0].equals("UserID") == true) {
                    continue;
                }

                User user = new User();

                if(columns[0].equals("") == false) {
                    user.setUserId(Integer.parseInt(columns[0]));
                } else {
                    user.setUserId(null);
                }

                user.setCity(columns[1]);
                user.setState(columns[2]);
                user.setCountry(columns[3]);

                if(columns[4].equals("") == false) {
                    user.setZipCode(columns[4]);
                } else {
                    user.setZipCode(null);
                }

                user.setDegreeType(columns[5]);
                user.setMajor(columns[6]);

                if(columns[7].equals("") == false) {
                    user.setGraduationDate(columns[7]);
                } else {
                    user.setGraduationDate(null);
                }

                if(columns[8].equals("") == false) {
                    user.setWorkHistoryCount(Integer.parseInt(columns[8]));
                } else {
                    user.setWorkHistoryCount(null);
                }


                if(columns[9].equals("") == false ) {
                    user.setTotalYearsExperience(Integer.parseInt(columns[9]));
                } else {
                    user.setTotalYearsExperience(null);
                }

                if(columns[10].equals("Yes")) {
                    user.setCurrentlyEmployed(true);
                } else if(columns[10].equals("No")) {
                    user.setCurrentlyEmployed(false);
                } else {
                    user.setCurrentlyEmployed(null);
                }

                if(columns[11].equals("Yes")) {
                    user.setManagedOthers(true);
                } else if(columns[11].equals("No")) {
                    user.setManagedOthers(false);
                } else {
                    user.setManagedOthers(null);
                }

                if(columns[12].equals("") == false) {
                    user.setManagedHowMany(Integer.parseInt(columns[12]));
                } else {
                    user.setManagedHowMany(null);
                }

                users.add(user);
            }
            reader.close();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e2) {
            System.err.println(e2.getMessage());
        }



        return users;
    }

    /***
     * This method will read the jobs file store each jobTitle and JobId
     * into a new Job object and add it to a list.
     * @param jobsFile
     * @return jobs
     */
    public List<Job> ReadJobsTsvFile(File jobsFile){
        int lineCount = 0;
        List<Job> jobs = null;
        
        try {   
            BufferedReader reader = new BufferedReader(new FileReader(Constants.jobsFile));
            
            int lineNumber = 0;
            
            lineCount = countLines(jobsFile.getAbsolutePath());
            jobs = new ArrayList<Job>(lineCount-1);
            String fileLine = "";
            
            while((fileLine = reader.readLine()) != null) {
                
                String[] columns = fileLine.split("\t");  
                
                if (columns[0].equals("JobID") == true) {
                    continue;
                }
                
                if(lineNumber == 1704) {
                    System.out.println("Hi");
                }
                
                Job job = new Job();
                
                job.setJobId(Integer.parseInt(columns[0]));
                job.setTitle(columns[1]);
                
                jobs.add(job);
            }  
        } catch (IOException ex) {
            Logger.getLogger(TsvFileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
         return jobs;
    }
    
    public List<User> ReadUsersTwoFile(File usersTwoFile) {
        List<User> usersTwo = new ArrayList<User>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(usersTwoFile));
            
            String fileLine = "";
            
            while((fileLine = reader.readLine()) != null) {
                String[] columns = fileLine.split("\t");
                User user = new User();
                user.setUserId(Integer.parseInt(columns[0]));
                usersTwo.add(user);
            }

        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        
        return usersTwo;
    }
    
    public List<ZipCode> ReadZipCodesFile(File zipCodeFile) {
        List<ZipCode> zipCodes = new ArrayList<ZipCode>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.zipCodeMappingFile));
            
            String fileLine = "";
            
            while((fileLine = reader.readLine()) != null) {
                String cleanedLine = fileLine.replace("\"", "");
                String[] columns = cleanedLine.split(",");
                
                
                
                if(columns[0].equals("Zipcode") == true) {
                    continue;
                }
                //String zipCode, String city, String state, Double Latitude, Double Longitude
                //"Zipcode","ZipCodeType","City","State","LocationType","Lat","Long","Location","Decommisioned","TaxReturnsFiled","EstimatedPopulation","TotalWages"
                ZipCode zipCode = new ZipCode();
                
                zipCode.setZipCode(columns[0]);
                zipCode.setCity(columns[2]);
                zipCode.setState(columns[3]);
                
                if(columns[5].equals("") == false) {
                    zipCode.setLatitude(Double.parseDouble(columns[5]));
                } else {
                    zipCode.setLatitude(0.0);
                }
                
                if(columns[6].equals("") == false) {
                    zipCode.setLongitude(Double.parseDouble(columns[6]));
                } else {
                    zipCode.setLongitude(0.0);
                }
                
                zipCodes.add(zipCode);
            }
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        
        return zipCodes;
    }

    /***
     * This method will count the lines in the file
     * It will be used to determine the size of the arraylist and initialize
     * to that size rather than dynamically adding it.
     * @param filename
     * @return int lineCount
     * @throws IOException 
     */
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean endsWithoutNewLine = false;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n')
                        ++count;
                }
                endsWithoutNewLine = (c[readChars - 1] != '\n');
            }
            if(endsWithoutNewLine) {
                ++count;
            }
            return count;
        } finally {
            is.close();
        }
    }
}
