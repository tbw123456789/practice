package cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ITEMType", propOrder={"zyh" , "time" , "reportid" , "name" , "sample" , "examid" , "itemname" , "itemshortname" , "result" })
public class ITEMType
{
  @XmlElement(name="Zyh", required=true)
  protected String zyh;

  @XmlElement(name="Time", required=true)
  protected String time;

  @XmlElement(name="Reportid", required=true)
  protected String reportid;

  @XmlElement(name="Name", required=true)
  protected String name;

  @XmlElement(name="Sample", required=true)
  protected String sample;

  @XmlElement(name="Examid", required=true)
  protected String examid;

  @XmlElement(name="Itemname", required=true)
  protected String itemname;

  @XmlElement(name="Itemshortname", required=true)
  protected String itemshortname;

  @XmlElement(name="Result", required=true)
  protected String result;


  public String getZyh() {
    return zyh;
  }

  public void setZyh(String zyh) {
    this.zyh = zyh;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getReportid() {
    return reportid;
  }

  public void setReportid(String reportid) {
    this.reportid = reportid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSample() {
    return sample;
  }

  public void setSample(String sample) {
    this.sample = sample;
  }

  public String getExamid() {
    return examid;
  }

  public void setExamid(String examid) {
    this.examid = examid;
  }

  public String getItemname() {
    return itemname;
  }

  public void setItemname(String itemname) {
    this.itemname = itemname;
  }

  public String getItemshortname() {
    return itemshortname;
  }

  public void setItemshortname(String itemshortname) {
    this.itemshortname = itemshortname;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}

