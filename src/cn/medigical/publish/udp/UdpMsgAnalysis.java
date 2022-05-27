package cn.medigical.publish.udp;

import java.io.Serializable;

public class UdpMsgAnalysis implements Serializable {

    //唯一标识
    public String SessionID;

    //系统类型 麻醉or重症
    public String SystemType ;

    //方法ID
    public String MethodId ;

    //自定义内容 对应 方法id
    public String CustomContent ;

    //超时字段
    public String TimeOut ;

  //超时字段
    public String SendIp ;
    
    public String getSendIp() {
		return SendIp;
	}

	public void setSendIp(String sendIp) {
		SendIp = sendIp;
	}

	public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public String getSystemType() {
        return SystemType;
    }

    public void setSystemType(String systemType) {
        SystemType = systemType;
    }

    public String getMethodId() {
        return MethodId;
    }

    public void setMethodId(String methodId) {
        MethodId = methodId;
    }

    public String getCustomContent() {
        return CustomContent;
    }

    public void setCustomContent(String customContent) {
        CustomContent = customContent;
    }

    public String getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(String timeOut) {
        TimeOut = timeOut;
    }
}
