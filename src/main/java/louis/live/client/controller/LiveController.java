package louis.live.client.controller;

import louis.live.client.service.LiveService;
import louis.live.client.vo.Live;
import louis.live.client.vo.LiveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/live")
public class LiveController {

    @Autowired
    LiveService liveService;

    @RequestMapping("/toList")
    public String toList(Model model) {
        List<LiveInfo> lives = new ArrayList();
        lives = liveService.getAll();
        model.addAttribute("lives",lives);
        return "live_list";
    }

    @RequestMapping("/toLive")
    public String toLive(Model model,String userId){
        Map params = new HashMap();
        params.put("userId",userId);
        Live live = new Live();
        live = liveService.getActiveLiveOfUser(params);
        model.addAttribute("live",live);
        return "live_room";
    }

    @RequestMapping("/")
    @ResponseBody
    public List<LiveInfo> getAll() {
        return liveService.getAll();
    }

    @RequestMapping("/add")
    public void add(String userId,String liveName) {
        Map params = new HashMap();
        params.put("userId",userId);
        params.put("liveName",liveName);
        liveService.add(params);
    }

//    @RequestMapping("/delete")
//    public void delete(Map params){
//        liveService.delete(params);
//    }

    @RequestMapping("/end")
    public void end(String streamCode){
        Map params = new HashMap();
        params.put("streamCode",streamCode);
        liveService.end(params);
    }

    @RequestMapping("/history")
    @ResponseBody
    public List<Live> getHistoryLivesOfUser(String userId){
        Map params = new HashMap();
        params.put("userId",userId);
        return liveService.getHistoryLivesOfUser(params);
    }

    @RequestMapping("/findByName/{liveName}")
    @ResponseBody
    public List<Live> getLiveByName(@PathVariable("liveName") String liveName){
        Map params = new HashMap();
        params.put("liveName",liveName);
        return liveService.getLiveByName(params);
    }

    @RequestMapping("/updateName")
    public void updateLiveName(String streamCode,String liveName){
        Map params = new HashMap();
        params.put("streamCode",streamCode);
        params.put("liveName",liveName);
        liveService.updateLiveName(params);
    }

    @RequestMapping("/updatePassword")
    public void updateLivePassword(String streamCode,String password){
        Map params = new HashMap();
        params.put("streamCode",streamCode);
        params.put("password",password);
        liveService.updateLivePassword(params);
    }


}
