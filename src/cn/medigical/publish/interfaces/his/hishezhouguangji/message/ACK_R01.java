package cn.medigical.publish.interfaces.his.hishezhouguangji.message;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.v24.segment.MSA;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ACK_R01  extends AbstractMessage {

    public ACK_R01() {
        this(new DefaultModelClassFactory());
    }

    public ACK_R01(ModelClassFactory factory) {
        super(factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(MSH.class, true, false);
            this.add(MSA.class, true, false);
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating ADR_A19 - this is probably a bug in the source code generator.", var3);
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

}
