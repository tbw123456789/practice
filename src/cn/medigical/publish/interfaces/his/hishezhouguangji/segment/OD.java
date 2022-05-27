package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.primitive.AbstractTextPrimitive;

public class OD  extends AbstractTextPrimitive {
    public OD(Message message) {
        super(message);
    }

    public String getVersion() {
        return "2.4";
    }
}
