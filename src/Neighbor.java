
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diaz994
 */
public class Neighbor implements Comparable<Neighbor>{
    private User user;
    private Integer distance;
    
    public Neighbor() {
        setUser(new User());
        setDistance(0);
    }

    public Neighbor(User user, Integer distance) {
        this.setUser(user);
        this.setDistance(distance);
    }

    public static final Comparator<Neighbor> DESCENDING_COMPARATOR = new Comparator<Neighbor>() {

        @Override
        public int compare(Neighbor neighbor1, Neighbor neighbor2) {
            return neighbor1.distance.compareTo(neighbor2.distance);
        }
        
    };
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Neighbor{" + "user=" + user + ", distance=" + distance + '}';
    }

    @Override
    public int compareTo(Neighbor neighbor) {
        return (this.distance).compareTo(neighbor.distance);
    }
    
    
}
