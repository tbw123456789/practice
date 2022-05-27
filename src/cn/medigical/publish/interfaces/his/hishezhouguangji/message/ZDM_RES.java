package cn.medigical.publish.interfaces.his.hishezhouguangji.message;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.segment.MSA;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.ZD1;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.ZD2;

public class ZDM_RES extends AbstractMessage {

    public ZDM_RES() {
        this(new DefaultModelClassFactory());
    }

    public ZDM_RES(ModelClassFactory factory) {
        super(factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(MSH.class, true, false);
            this.add(MSA.class, true, false);
            this.add(ZD1.class, false, false);
            this.add(ZD2.class, false, false);
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

    public MSA getMSA() {
        return (MSA)this.getTyped("MSA", MSA.class);
    }

    public ZD1 getZD1() {
        return (ZD1)this.getTyped("ZD1", ZD1.class);
    }

    public ZD2 getZD2() {
        return (ZD2)this.getTyped("ZD2", ZD2.class);
    }

}