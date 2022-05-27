package cn.medigical.publish.xmlUtil;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


public class HttpNetClient {
	private static Logger logger = Logger.getLogger("HttpNetClient");

	public static String HttpClientGet(String url, String content) {
		String response = null;
		logger.info("this send to PingTai xml is " + "\n" + content);
		try {
			CloseableHttpClient httpclient = null;
			CloseableHttpResponse httpresponse = null;
			try {
				httpclient = HttpClients.createDefault();
				HttpPost httppost = new HttpPost(url);
				httppost.addHeader("Content-Type", "text/html;charset=UTF-8");
				StringEntity stringentity = new StringEntity(content, ContentType.create("text/xml", "UTF-8"));
				httppost.setEntity(stringentity);
				httpresponse = httpclient.execute(httppost);
				response = EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
			} finally {
				if (httpclient != null) {
					httpclient.close();
				}
				if (httpresponse != null) {
					httpresponse.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("the PingTai return xml is " + response);
		return response;
	}
}