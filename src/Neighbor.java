/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diaz994
 */
public class Neighbor {
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
    
    
}
