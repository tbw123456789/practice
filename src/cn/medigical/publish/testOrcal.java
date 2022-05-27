package cn.medigical.publish;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("testOrcal")
public class testOrcal {

    @RequestMapping(value = "zhikong", method = RequestMethod.GET)
    public void orcal() throws SQLException {
        OracleJdbcTest test = new OracleJdbcTest();
        test.query("SELECT * from MED_ANESTHESIA_EVENT where ROWNUM < 10", true);
//        test.close();
    }

}
