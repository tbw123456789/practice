package cn.medigical.publish.interfaces.his.hishezhouguangji.message;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.SJ01;

public class ZDM_Z23 extends AbstractMessage {

    public ZDM_Z23() {
        this(new DefaultModelClassFactory());
    }

    public ZDM_Z23(ModelClassFactory factory) {
        super(factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(MSH.class, true, false);
            this.add(SJ01.class, true, false);
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

    public SJ01 getSJ01() {
        return (SJ01)this.getTyped("SJ01", SJ01.class);
    }

}