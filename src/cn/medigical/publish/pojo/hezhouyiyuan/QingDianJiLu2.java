package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QingDianJiLu2 {
    /**器械*/
    private StringProperty qx;
    /**敷料*/
    private StringProperty fl;
    /**条形码*/
    private StringProperty txm;

    public String getQx() {

        return qx.get();
    }

    public StringProperty qxProperty() {
        if(qx==null){
            qx=new SimpleStringProperty();
        }
        return qx;
    }

    public void setQx(String qx) {
        this.qx.set(qx);
    }

    public String getFl() {
        return fl.get();
    }

    public StringProperty flProperty() {
        if(fl==null){
            fl = new SimpleStringProperty();
        }
        return fl;
    }

    public void setFl(String fl) {
        this.fl.set(fl);
    }

    public String getTxm() {
        return txm.get();
    }

    public StringProperty txmProperty() {
        if(txm==null){
            txm=new SimpleStringProperty();
        }
        return txm;
    }

    public void setTxm(String txm) {
        this.txm.set(txm);
    }
}
