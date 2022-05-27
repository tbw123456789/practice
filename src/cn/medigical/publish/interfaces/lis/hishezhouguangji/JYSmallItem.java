package cn.medigical.publish.interfaces.lis.hishezhouguangji;
public class JYSmallItem {
	  public String no;
	  public String vlueType;
	  public String code;
	  public String eName;
	  public String cName;
	  public String vlue;
	  public String unit;
	  public String referRange;
	  public String abnormalFlags;
	  public String resultStatus;
	  public String analysisDate;
	  public String time;
	public String abb02;
	  public String toString()
	  {
	    return "JYSmallItem{no='" + this.no + '\'' + ", vlueType='" + this.vlueType + '\'' + ", code='" + this.code + '\'' + ", eName='" + this.eName + '\'' + ", cName='" + this.cName + '\'' + ", vlue='" + this.vlue + '\'' + ", unit='" + this.unit + '\'' + ", referRange='" + this.referRange + '\'' + ", abnormalFlags='" + this.abnormalFlags + '\'' + ", resultStatus='" + this.resultStatus + '\'' + ", analysisDate='" + this.analysisDate +  '\''  + ", time='" + this.time+ '\'' + ", abb02='" + this.abb02 + '\''+ '}';
	  }


	  public boolean equals(Object o)
	  {
	    if (this == o) {
	      return true;
	    }
	    if ((o == null) || (getClass() != o.getClass())) {
	      return false;
	    }
	    JYSmallItem that = (JYSmallItem)o;
	    
	    return this.code != null ? this.code.equals(that.code) : that.code == null;
	  }
	  
	  public int hashCode()
	  {
	    return this.code != null ? this.code.hashCode() : 0;
	  }

}
