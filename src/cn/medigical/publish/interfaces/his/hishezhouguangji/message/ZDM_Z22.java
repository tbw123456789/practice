package cn.medigical.publish.interfaces.his.hishezhouguangji.message;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.ZM01;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.ZM02;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.ZM03;

public class ZDM_Z22 extends AbstractMessage {

    public ZDM_Z22() {
        this(new DefaultModelClassFactory());
    }

    public ZDM_Z22(ModelClassFactory factory) {
        super(factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(MSH.class, true, false);
            this.add(ZM01.class, false, false);
            this.add(ZM02.class, false, true);
            this.add(ZM03.class,false,true);
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating ZDM_Z01 - this is probably a bug in the source code generator.", var3);
        }

    }

    @Override
    public String getVersion() {
        return "2.4";
    }

    public MSH getMSH() {
        return (MSH)this.getTyped("MSH", MSH.class);
    }

    public ZM01 getZM01() {
        return (ZM01)this.getTyped("ZM01", ZM01.class);
    }

    public ZM02 getZM02() {
        return (ZM02)this.getTyped("ZM02", ZM02.class);
    }

    public ZM03 getZM03() {
        return (ZM03)this.getTyped("ZM03", ZM03.class);
    }

}

