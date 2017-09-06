package louis.live.client.service;

import louis.live.client.mapper.UserMapper;
import louis.live.client.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.getAll();
    }

    public User getOne(String userId){
        return userMapper.getOne(userId);
    }
}
