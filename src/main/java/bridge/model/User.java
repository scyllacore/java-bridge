package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userMap;

    public User(){
        userMap = new ArrayList<>();
    }

    public void markPosition(String direction) {
        userMap.add(direction);
    }

    public int getMovingDistance() {
        return userMap.size();
    }

    public List<String> getUserMap() {
        return userMap;
    }
}
