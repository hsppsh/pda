package s1.pda.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class commonDAO {
    private static final Logger logger = LoggerFactory.getLogger(commonDAO.class);

    @Autowired
    public SqlSession sqlSession;

    public List<Map<String, Object>> login(Map<String, Object> map) {
        return sqlSession.selectList("mes.mapper.sys.common_mapper.login", map);
    }
}
