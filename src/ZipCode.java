/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diaz994
 */
public class ZipCode {
    private String zipCode;
    private String city;
    private String state;
    private Double Latitude;
    private Double Longitude;

    public ZipCode() {
    }

    public ZipCode(String zipCode, String city, String state, Double Latitude, Double Longitude) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }
    
    

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double Latitude) {
        this.Latitude = Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }
    
    
    
    
}
