package s1.pda.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import s1.pda.service.omcService;

@RestController
public class omcController {
    private static final Logger logger = LoggerFactory.getLogger(omcController.class);

    @Autowired
    omcService omcservice;

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, path = "/selectOMC1122.do", produces = "application/json; charset=UTF-8")
    public Object selectOMC1122(HttpSession session, HttpServletRequest req) {
        JSONObject obj = new JSONObject();

        if (session.getAttribute("login_id") == null) {
            obj.put("rtn", "false");
            obj.put("msg", "Authentication failure");
            logger.info("Authentication failure");

            return obj;
        }

        List<Map<String, Object>> selectOMC1122_list = null;
        try {
            selectOMC1122_list = omcservice.selectOMC1122();
        } catch (Exception e) {
            e.printStackTrace();
        }

        obj.put("rtn", selectOMC1122_list);
        obj.put("msg", "");
        logger.info("selectOMC1122_list");
        return obj;
    }
}
