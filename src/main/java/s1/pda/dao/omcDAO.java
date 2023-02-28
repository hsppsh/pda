package s1.pda.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class omcDAO {
    private static final Logger logger = LoggerFactory.getLogger(omcDAO.class);

    @Autowired
    public SqlSession sqlSession;

    public List<Map<String, Object>> selectOMC1122() {
        return sqlSession.selectList("mes.mapper.prod.omc_mapper.selectOMC1122");
    }
}
