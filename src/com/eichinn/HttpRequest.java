package com.eichinn;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class HttpRequest {

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "gb2312"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String head ="<?xml version='1.0' encoding='GBK'?><PGK><DATA><![CDATA[";
        String body = "<?xml version='1.0' encoding='GB2312'?><CBSERPPGK><INFO><FUNNAM>APPAYSAV</FUNNAM></INFO><APPAYSAVX><BNKTYP>CMB</BNKTYP><BUSTYP>0</BUSTYP><CCYNBR>10</CCYNBR><CLTACC>000110100002</CLTACC><CLTNBR>0003</CLTNBR><EPTDAT>2015-09-24</EPTDAT><EPTTIM>18:16:31</EPTTIM><EXTTX1>摘要信息03</EXTTX1><OPRMOD>3</OPRMOD><OPRTYP>202</OPRTYP><REFNBR>NF0001</REFNBR><REVACC>8512384214654654</REVACC><REVBNK>招商银行科技园支行</REVBNK><REVCIT>深圳市</REVCIT><REVEML></REVEML><REVMOB></REVMOB><REVNAM>招商银行</REVNAM><REVPRV>广东省</REVPRV><TRSAMT>200.00</TRSAMT><TRSUSE>摘要信息01</TRSUSE></APPAYSAVX></CBSERPPGK>";
        String end ="]]></DATA><CHECKCODE>ZBCA3E268</CHECKCODE></PGK>";
        //其中127.1.0.1 是ip地址,1234 是端口号
        String sr= null;
        try {
            sr = HttpRequest.sendPost("http://172.18.0.100:8080", URLEncoder.encode(head+body+end, "gb2312"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(sr);
    }
}