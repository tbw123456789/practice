package cn.medigical.publish.utils;

import cn.medigical.publish.pojo.xiandaiyiyuan.JsonPackage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
    private static final CloseableHttpClient httpclient = HttpClients.createDefault();
    private static final String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";

    /**
     * 发送HttpGet请求 * * @param url * 请求地址 * @return 返回字符串
     */
    public static String sendGet(String url) {
        String result = null;
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent", userAgent);
//            httpGet.setHeader("Authorization", "token " + token);
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            log.error("处理失败 {}" + e);
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }

        }
        return result;
    }

    /**
     * 让 Map按key进行排序
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * 发送HttpPost请求，参数为map * * @param url * 请求地址 * @param map * 请求参数 * @return 返回字符串
     */
    public static String sendPost(String url, Map<String, String> map){

        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
        httpPost.addHeader("Content-type","application/x-www-form-urlencoded; charset=utf-8");
        CloseableHttpResponse response = null;
        String result = null;
        try {
            List<NameValuePair> list = new ArrayList<>();
            List<JsonPackage> packageList = new ArrayList<>();
            for(Map.Entry<String,String>  entry: map.entrySet()) {
                JsonPackage jsonPackage = new JsonPackage();
                jsonPackage.setKey(entry.getKey());
                jsonPackage.setValue(entry.getValue());
                packageList.add(jsonPackage);
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            String strGson = new Gson().toJson(packageList);
            String primaryKey = SHa256withRsa.sign(Constants.HIS_CHARGING_PRIMARY_KEY,strGson);
            list.add(new BasicNameValuePair("sign", primaryKey));
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list,"UTF-8");
            httpPost.setEntity(formEntity);
            // 执行post请求
            response = httpclient.execute(httpPost);
            // 得到entity
            HttpEntity entity = response.getEntity();
            // 得到字符串
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return result;
    }

    /**
     * 发送HttpPost请求，参数为map * * @param url * 请求地址 * @param map * 请求参数 * @return 返回字符串
     */



    public static String sendPost(String url, Map<String, String> map,String token) {
        // 设置参数
//        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//        }
//        // 编码
//        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        // 取得HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
        httpPost.setHeader("User-Agent", userAgent);
        httpPost.addHeader("Content-type","application/json; charset=utf-8");
        httpPost.addHeader("Accept", "application/json");
        if(token != null)
        httpPost.addHeader("Token",token);
        // 参数放入Entity
        httpPost.setEntity(new  StringEntity(JSONObject.toJSON(map).toString(), Charset.forName("UTF-8")));
        CloseableHttpResponse response = null;
        String result = null;
        try {
            // 执行post请求
            response = httpclient.execute(httpPost);
            // 得到entity
            HttpEntity entity = response.getEntity();
            // 得到字符串
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return result;
    }


    /**
     * 发送HttpPost请求，参数为json字符串 * * @param url * @param jsonStr * @return
     */
    public static String sendPost(String url, String token) {
        String result = null;
//        // 字符串编码
//        StringEntity entity = new StringEntity(jsonStr, Consts.UTF_8);
//        // 设置content-type
//        entity.setContentType("application/json");
        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
//        httpPost.setHeader("User-Agent", userAgent);
        httpPost.addHeader("Content-type","application/json; charset=utf-8");
        httpPost.addHeader("Token",token);
//        // 接收参数设置
//        httpPost.setHeader("Accept", "application/json");
        //httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
            //HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            // 关闭CloseableHttpResponse
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return result;
    }

    /**
     * 发送不带参数的HttpPost请求 * * @param url * @return
     */
    public static String sendPost(String url) {
        String result = null;
        // 得到一个HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        // 防止被当成攻击添加的
//        httpPost.setHeader("User-Agent", userAgent);
        httpPost.addHeader("Content-type","application/json; charset=utf-8");
//        httpPost.addHeader("Accept", "application/json");
        CloseableHttpResponse response = null;
        try {
            // 执行HttpPost请求，并得到一个CloseableHttpResponse
            response = httpclient.execute(httpPost);
            // 从CloseableHttpResponse中拿到HttpEntity
            HttpEntity entity = response.getEntity();
            // 将HttpEntity转换为字符串
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            // 关闭CloseableHttpResponse
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return result;
    }


}