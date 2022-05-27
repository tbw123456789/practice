package cn.medigical.publish.interfaces.his.hishezhouguangji.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sky
 */
public class EmrPngMapMapAdapter extends XmlAdapter<EmrPngMap[], Map<String, byte[]>> {

    /**
     * 适配转换 MyRole[] -> Map<String, List<Role>>
     */
    @Override
    public EmrPngMap[] marshal(Map<String, byte[]> roleMap) {
        EmrPngMap[] roles = new EmrPngMap[roleMap.size()];
        int i = 0;
        for (String key : roleMap.keySet()) {
            roles[i] = new EmrPngMap();
            roles[i].setKey(key);
            roles[i].setValue(roleMap.get(key));
            i++;
        }
        return roles;
    }

    /**
     * 适配转换 Map<String, List<Role>> -> MyRole[]
     */
    @Override
    public Map<String, byte[]> unmarshal(EmrPngMap[] roles) {
        Map<String, byte[]> map = new HashMap<>();
        for (EmrPngMap role : roles) {
            map.put(role.getKey(), role.getValue());
        }
        return map;
    }

}
