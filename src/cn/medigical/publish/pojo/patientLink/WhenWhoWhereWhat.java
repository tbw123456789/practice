package cn.medigical.publish.pojo.patientLink;

import java.util.Date;

/**
 * Created by 2018-06-07.
 *
 */
public class WhenWhoWhereWhat {
    private Date When;
    private String Who;
    private String Where;
    private String What;

    public WhenWhoWhereWhat(Date when, String who, String where, String what) {
        this.When = when;
        this.Who = who;
        this.Where = where;
        this.What = what;
    }

    public Date getWhen() {
        return When;
    }

    public void setWhen(Date when) {
        this.When = when;
    }

    public String getWho() {
        return Who;
    }

    public void setWho(String who) {
        this.Who = who;
    }

    public String getWhere() {
        return Where;
    }

    public void setWhere(String where) {
        this.Where = where;
    }

    public String getWhat() {
        return What;
    }

    public void setWhat(String what) {
        this.What = what;
    }

   
}
