package louis.live.client.service;

import louis.live.client.mapper.LiveMapper;
import louis.live.client.uitls.Tools;
import louis.live.client.vo.Live;
import louis.live.client.vo.LiveInfo;
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

    public void add(Map params) {
        String id = Tools.generateUUID();
        String streamCode = Tools.generateUUID();
        Live live = new Live();
        live.setId(id);
        live.setLiveName(params.get("liveName").toString());
        live.setUserId(params.get("userId").toString());
        live.setStreamCode(streamCode);
        liveMapper.add(live);
    }

    public void delete(Map params){
        liveMapper.delete(params);
    }

    public void end(Map params){
        liveMapper.end(params);
    }

    public LiveInfo getActiveLiveOfUser(Map params){
        return liveMapper.getActiveLiveOfUser(params);
    }

    public List<Live> getHistoryLivesOfUser(Map params){
        return liveMapper.getHistoryLivesOfUser(params);
    }

    public List<Live> getLiveByName(Map params){
        return liveMapper.getLiveByName(params);
    }

    public void updateLiveName(Map params){
        liveMapper.updateLiveName(params);
    }

    public void updateLivePassword(Map params){
        liveMapper.updateLivePassword(params);
    }
}
