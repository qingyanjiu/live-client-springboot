package louis.live.client.controller;

import louis.live.client.service.LiveService;
import louis.live.client.vo.Live;
import louis.live.client.vo.LiveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/live")
public class LiveController {

    @Autowired
    LiveService liveService;

    @Value("${live.server.snapshoturl}")
    private String snapshotUrl;

    @Value("${live.server.streamUrl}")
    private String streamUrl;

    @RequestMapping("/")
    @ResponseBody
    public List<LiveInfo> getAll() {
        return liveService.getAll();
    }

    @RequestMapping("/toList")
    public String toList(Model model) {
        List<LiveInfo> lives = new ArrayList();
        lives = liveService.getAll();
        String title = "直播列表";
        model.addAttribute("lives", lives);
        model.addAttribute("title", title);
        model.addAttribute("snapshotUrl", snapshotUrl);
        return "live_list";
    }

    @RequestMapping("/userpage")
    public String myroom(Model model, HttpServletRequest request) {
        Map params = new HashMap();
        LiveInfo live = new LiveInfo();
        String userName = request.getUserPrincipal().getName();
        params.put("userName", userName);
        live = liveService.getActiveLiveOfUser(params);
        String title = "我的房间";
        model.addAttribute("live", live);
        model.addAttribute("title", title);
        model.addAttribute("streamUrl", streamUrl);
        return "user_page";
    }

    @RequestMapping("/show")
    public String toLive(Model model, String userName, String password) {
        String result = "live_room";
        Map params = new HashMap();
        params.put("userName", userName);
        LiveInfo live = new LiveInfo();
        live = liveService.getActiveLiveOfUser(params);
        if (live == null) {
            result = "noLive";
        } else {
            if (password != null) {
                if (password.equals(live.getPassword()))
                    model.addAttribute("pass", true);
                else
                    model.addAttribute("pass", false);
            }
            else
                model.addAttribute("pass", true);
            model.addAttribute("live", live);
            model.addAttribute("streamUrl", streamUrl);
        }
        return result;
    }

    @RequestMapping("/add")
    public void add(String userId, String liveName) {
        Map params = new HashMap();
        params.put("userId", userId);
        params.put("liveName", liveName);
        liveService.add(params);
    }

//    @RequestMapping("/delete")
//    public void delete(Map params){
//        liveService.delete(params);
//    }

    @RequestMapping("/end")
    public void end(String streamCode) {
        Map params = new HashMap();
        params.put("streamCode", streamCode);
        liveService.end(params);
    }

    @RequestMapping("/history")
    @ResponseBody
    public List<Live> getHistoryLivesOfUser(String userId) {
        Map params = new HashMap();
        params.put("userId", userId);
        return liveService.getHistoryLivesOfUser(params);
    }

    @RequestMapping("/findByName/{liveName}")
    @ResponseBody
    public List<Live> getLiveByName(@PathVariable("liveName") String liveName) {
        Map params = new HashMap();
        params.put("liveName", liveName);
        return liveService.getLiveByName(params);
    }

    @RequestMapping("/updateName")
    public void updateLiveName(String streamCode, String liveName) {
        Map params = new HashMap();
        params.put("streamCode", streamCode);
        params.put("liveName", liveName);
        liveService.updateLiveName(params);
    }

    @RequestMapping("/updatePassword")
    public void updateLivePassword(String streamCode, String password) {
        Map params = new HashMap();
        params.put("streamCode", streamCode);
        params.put("password", password);
        liveService.updateLivePassword(params);
    }


}
