package cn.medigical.publish.udp;
import org.apache.log4j.Logger;
public class UdpRunning implements Runnable {
    private static Logger logger = Logger.getLogger("UdpRunning");

    @Override
    public void run() {
        synchronized (this) {
        	logger.info("UDP接收消息中····");
        	UdpHelper.ReceiveMsg();
            UdpHelper.sendMsg("1111111111111");
            //logger.info("接收消息为：" + UdpHelper.result);
        }
    }
}
