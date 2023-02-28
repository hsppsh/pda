package s1.pda.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s1.pda.dao.commonDAO;

@Service
public class commonService {
    private static final Logger logger = LoggerFactory.getLogger(commonService.class);

    @Autowired
    commonDAO commondao;

    public List<Map<String, Object>> login(Map<String, Object> map) {
        return commondao.login(map);
    }
}
