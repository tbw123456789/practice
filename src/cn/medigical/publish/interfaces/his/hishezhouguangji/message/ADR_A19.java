package cn.medigical.publish.interfaces.his.hishezhouguangji.message;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.segment.MSA;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v24.segment.PV1;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ADR_A19 extends AbstractMessage {

    public ADR_A19() {
        this(new DefaultModelClassFactory());
    }

    public ADR_A19(ModelClassFactory factory) {
        super(factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(MSH.class, true, false);
            this.add(MSA.class, true, false);
            this.add(PID.class, true, false);
            this.add(PV1.class, true, false);
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating ZDM_Z01 - this is probably a bug in the source code generator.", var3);
        }

    }

    @Override
    public String getVersion() {
        return "2.4";
    }

    public MSH getMSH() {
        return this.getTyped("MSH", MSH.class);
    }

    public MSA getMSA() {
        return this.getTyped("MSA", MSA.class);
    }

    public PID getPID() {
        return this.getTyped("PID", PID.class);
    }

    public PV1 getPV1() {
        return this.getTyped("PV1", PV1.class);
    }

}