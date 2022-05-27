package cn.medigical.publish.interfaces.his.hisLink;


import cn.medigical.publish.pojo.patientLink.PatientLink;

public abstract interface HisPatInfoImpl
{
  public abstract PatientLink getBasicPatInfoOperation(String paramString);
}

