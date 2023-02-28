package s1.pda.service;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s1.pda.dao.omcDAO;

@Service
public class omcService {
    private static final Logger logger = LoggerFactory.getLogger(omcService.class);

    @Autowired
    omcDAO omcdao;

    public List<Map<String, Object>> selectOMC1122() throws Exception {
        return omcdao.selectOMC1122();
    }
}
