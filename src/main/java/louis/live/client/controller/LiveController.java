package louis.live.client.controller;

import louis.live.client.service.LiveService;
import louis.live.client.service.UserService;
import louis.live.client.vo.LiveInfo;
import louis.live.client.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lives")
public class LiveController {

    @Autowired
    LiveService liveService;

    @RequestMapping("/")
    @ResponseBody
    public List<LiveInfo> getAll() {
        return liveService.getAll();
    }


}
