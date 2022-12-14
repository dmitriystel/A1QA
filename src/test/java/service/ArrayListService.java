package service;

import entity.User;

import java.util.List;

public class ArrayListService {
    public int validateUserHaveIdAndName(List<User> userList) {
        int result = 0;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() != 0 && userList.get(i).getName() != null) {
                result++;
            }
        }
        return result;
    }

    public int validateAllUsersInJsonIncludedUsersFromYaml(List<User> userListJson, List<User> userListYaml ){
        int result = 0;
        for (int i = 0; i < userListJson.size(); i++) {
            if (userListJson.get(i).getId() != 0 && userListJson.get(i).getName() != null){
                for (int j = 0; j < userListYaml.size(); j++) {
                    if (userListJson.get(i).getId() == userListYaml.get(j).getId() &&
                            userListJson.get(i).getName().equals(userListYaml.get(j).getName())){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
