import java.io.File;
import java.util.Date;

/***
 * Constants file to hold different values used throughout the program
 * @author Victor Diaz
 */
public class Constants {
    public static File usersFile = new File("C:\\Users\\diaz994.VictorDiazJr\\Documents\\data\\users.tsv");

    public static File userHistoryFile = new File("C:\\Users\\diaz994.VictorDiazJr\\Documents\\data\\user_history.tsv");

    public static File jobsFile = new File("C:\\Users\\diaz994.VictorDiazJr\\Documents\\data\\jobs.tsv");

    public static File appsFile = new File("C:\\Users\\diaz994.VictorDiazJr\\Documents\\data\\apps.tsv");
    
    public static File usersTwoFile = new File("C:\\Users\\diaz994.VictorDiazJr\\Documents\\data\\users_two.tsv");
    
    public static File zipCodeMappingFile = new File("C:\\Users\\diaz994.VictorDiazJr\\Documents\\data\\zips.csv");
    
    // T1 is denoted by a time before this;
    public static String timeOne = "2014-04-09 00:00:00";
    
    // T2 is denoted by a time after this.
    public static String timeTwo = "2014-04-09 00:00:00";

    public static Integer numberOfApplications;

    final public static int HowManyApps = 5;

    public static boolean DEBUG = true;
}
