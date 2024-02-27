package web.response.me;

import com.google.gson.Gson;

/**
 * POJO class for auth/me API
 */
public class MeResponse {
    public int id;
    public String firstName;
    public String lastName;
    public String maidenName;
    public int age;
    public String gender;
    public String email;
    public String phone;
    public String username;
    public String password;
    public String birthDate;
    public String image;
    public String bloodGroup;
    public int height;
    public double weight;
    public String eyeColor;
    public Hair hair;
    public String domain;
    public String ip;
    public Address address;
    public String macAddress;
    public String university;
    public Bank bank;
    public Company company;
    public String ein;
    public String ssn;
    public String userAgent;
    public Crypto crypto;

    /**
     * Function that is used to parse json string into an instance of MeResponse
     * @param json - string to be parsed
     * @return parsed instance of MeResponse
     */
    public static MeResponse parseJson(String json) {
        return new Gson().fromJson(json, MeResponse.class);
    }
}

