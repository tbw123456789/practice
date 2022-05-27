package cn.medigical.publish.interfaces.his.hishezhouguangji.message;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v24.segment.PV1;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.Z01;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.Z02;

public class ZDM_Z01 extends AbstractMessage {
    public ZDM_Z01() {
        this(new DefaultModelClassFactory());
    }

    public ZDM_Z01(ModelClassFactory factory) {
        super(factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(MSH.class, true, false);
            this.add(PID.class, true, false);
            this.add(PV1.class, false, false);
            this.add(Z01.class, false, false);
            this.add(Z02.class, true, true);
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

    public PID getPID() {
        return (PID)this.getTyped("PID", PID.class);
    }

    public PV1 getPV1() {
        return (PV1)this.getTyped("PV1", PV1.class);
    }

    public Z01 getZ01() {
        return (Z01)this.getTyped("Z01", Z01.class);
    }

    public Z02 getZ02() {
        return (Z02)this.getTyped("Z02", Z02.class);
    }

}
