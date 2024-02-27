package support;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import support.entities.User;
import support.entities.Users;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class that is used to get users that would be used in testing
 */
public class UserRepository {

    public ArrayList<User> users;

    public UserRepository() throws FileNotFoundException {
        users = ((Users) new Gson().fromJson(new JsonReader(new FileReader(UserRepository.class.getClassLoader().getResource("users.json").getPath())), Users.class)).users;
    }

    public User getUserByTag(String tag) {
        return users.stream().filter(p -> p.tag.equals(tag)).findFirst().get();
    }

}
