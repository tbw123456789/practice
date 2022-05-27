package cn.medigical.publish.dao.impl.wjzyy;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.lis.JianYan;

public class JianYanDao extends BaseDao<JianYan> {

    public boolean addUpdate(JianYan jianYan) {
        return save(jianYan);
    }

//    public boolean
}
