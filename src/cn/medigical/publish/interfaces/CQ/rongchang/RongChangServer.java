package cn.medigical.publish.interfaces.CQ.rongchang;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class RongChangServer {

    @WebMethod
    public void getTest(){
        int a = 0;
        a++;
    }

    public static void main(String[] args) {
//        Object implementor = new RongChangServer();
//        String address = Constants.HOST_RONGCHANGSERVER + "/RongChangServer";
//        Endpoint.publish(address, implementor);
    }

}