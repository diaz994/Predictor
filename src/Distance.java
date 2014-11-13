/*
A class to represent the distance from the query
set to a training set.
*/

/**
 *
 * @author diaz994
 */
public class Distance {
    enum DistanceRange {
        LessThanTwo,
        TwoToFive,
        FiveToTen,
        TenToTwenty,
        TwentyToFifty,
        FiftyToHundred,
        Unknown
    }
    
    private DistanceRange distance;

    public Distance() {
        super();
    }

    public Distance(DistanceRange distance) {
        super();
        this.distance = distance;
    }

    public DistanceRange getDistance() {
        return distance;
    }

    public void setDistance(DistanceRange distance) {
        this.distance = distance;
    }
    
    public static DistanceRange determineDistance(String distance) {
        if(Integer.parseInt(distance) <= 2) {
                return DistanceRange.LessThanTwo;
        }
        else if(Integer.parseInt(distance) > 2 && Integer.parseInt(distance) <= 5) {
                return DistanceRange.TwoToFive;
        }
        else if(Integer.parseInt(distance) > 5 && Integer.parseInt(distance) <= 10) {
                return DistanceRange.FiveToTen;
        }
        else if(Integer.parseInt(distance) > 10 && Integer.parseInt(distance) <= 20) {
                return DistanceRange.TenToTwenty;
        }
        else if(Integer.parseInt(distance) > 20 && Integer.parseInt(distance) <= 50) {
                return DistanceRange.TwentyToFifty;
        }
        else if(Integer.parseInt(distance) > 50) {
                return DistanceRange.FiftyToHundred;
        }
        else {
                return DistanceRange.Unknown;
        }
    }

    @Override
    public String toString() {
        return "Distance{" + "distance=" + distance + '}';
    }
    
    
}
