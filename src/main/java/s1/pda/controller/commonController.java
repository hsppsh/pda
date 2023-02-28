package s1.pda.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import s1.pda.service.commonService;

@RestController
public class commonController {
    private static final Logger logger = LoggerFactory.getLogger(commonController.class);

    @Autowired
    commonService commonservice;

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, path = "/login.do", produces = "application/json; charset=UTF-8")
    public Object login(HttpServletRequest req, @RequestBody Map<String, Object> map) {
        req.getSession().invalidate();
        HttpSession session = req.getSession();

        JSONObject obj = new JSONObject();

        if (!map.containsKey("id") || !map.containsKey("pw")) {
            obj.put("rtn", "false");
            obj.put("msg", "입력 데이터를 확인하시기 바랍니다.");
            logger.info("입력 데이터를 확인하시기 바랍니다.");
            return obj;
        }

        List<Map<String, Object>> login_list = commonservice.login(map);

        if (login_list.size() == 0) {
            obj.put("rtn", "false");
            obj.put("msg", "시스템 접속 아이디를 확인하시기 바랍니다.");
            logger.info("시스템 접속 아이디를 확인하시기 바랍니다.");
            return obj;
        }

        if (login_list.get(0).get("pwd_chk").equals("")) {
            obj.put("rtn", "false");
            obj.put("msg", "비밀번호를 확인하시기 바랍니다.");
            logger.info("비밀번호를 확인하시기 바랍니다.");
            return obj;
        }

        session.setAttribute("login_session", session.getId());
        session.setAttribute("login_addr"   , req.getRemoteAddr());
        session.setAttribute("login_id"     , login_list.get(0).get("user_id"));
        session.setAttribute("login_nm"     , login_list.get(0).get("com_loc_nm"));
        session.setAttribute("com_cd"       , login_list.get(0).get("com_cd"));
        session.setAttribute("div_cd"       , login_list.get(0).get("div_cd"));

        Enumeration<?> em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            String key = em.nextElement().toString();
            logger.info("key : " + key + ", value : " + session.getAttribute(key));
        }

        obj.put("rtn", "true");
        obj.put("msg", "");

        return obj;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, path = "/login", produces = "application/json; charset=UTF-8")
    public Object login_hidden(HttpServletRequest req) {
        req.getSession().invalidate();
        HttpSession session = req.getSession();

        JSONObject obj = new JSONObject();

        if (req.getParameter("id") == null || req.getParameter("pw") == null) {
            obj.put("rtn", "false");
            obj.put("msg", "입력 데이터를 확인하시기 바랍니다.");
            logger.info("입력 데이터를 확인하시기 바랍니다.");
            return obj;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", req.getParameter("id"));
        map.put("pw", req.getParameter("pw"));

        List<Map<String, Object>> login_list = commonservice.login(map);

        if (login_list.size() == 0) {
            obj.put("rtn", "false");
            obj.put("msg", "시스템 접속 아이디를 확인하시기 바랍니다.");
            logger.info("시스템 접속 아이디를 확인하시기 바랍니다.");
            return obj;
        }

        if (login_list.get(0).get("pwd_chk").equals("")) {
            obj.put("rtn", "false");
            obj.put("msg", "비밀번호를 확인하시기 바랍니다.");
            logger.info("비밀번호를 확인하시기 바랍니다.");
            return obj;
        }

        session.setAttribute("login_session", session.getId());
        session.setAttribute("login_addr"   , req.getRemoteAddr());
        session.setAttribute("login_id"     , login_list.get(0).get("user_id"));
        session.setAttribute("login_nm"     , login_list.get(0).get("com_loc_nm"));
        session.setAttribute("com_cd"       , login_list.get(0).get("com_cd"));
        session.setAttribute("div_cd"       , login_list.get(0).get("div_cd"));

        Enumeration<?> em = session.getAttributeNames();
        while (em.hasMoreElements()) {
            String key = em.nextElement().toString();
            logger.info("key : " + key + ", value : " + session.getAttribute(key));
        }

        obj.put("rtn", "true");
        obj.put("msg", "");

        return obj;
    }
}
