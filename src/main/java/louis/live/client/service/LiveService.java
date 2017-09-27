package louis.live.client.service;

import louis.live.client.mapper.LiveMapper;
import louis.live.client.mapper.UserMapper;
import louis.live.client.vo.LiveInfo;
import louis.live.client.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LiveService {
    @Autowired
    LiveMapper liveMapper;

    public List<LiveInfo> getAll(){
        return liveMapper.getAll();
    }


}
