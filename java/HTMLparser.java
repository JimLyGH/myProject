package com.kayak.lin;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLparser {
    private static final String category = "D:/test/";
    private final static String[] useragent = {"Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0","Mozilla/4.0(compatible;MSIE 8.0;Windows NT 6.0)"};
    public static void main(String[] args) {
        try{

            Document doc = Jsoup.connect("http://blog.csdn.net/nvnnv/article/details/51068319")
          //这是我博客的一篇文章拿来测试用的，请忽略=。=
                    .userAgent(useragent[0])   //这里设置代理 不然有些网站防爬虫
                    .timeout(10000)
                    .get();
            String title = doc.className();
            System.out.println(title);
            Element head = doc.head();
            Element body = doc.body();
            Elements son = body.children();
            List<String> list = new ArrayList<String>(); // 所有图片URL集合
            reseachImg(body, list);
            new HTMLparser.DowanImg(list).start();
        }catch (IOException e){
            // do something on informing
            e.printStackTrace();
        }
    }
    /*
    方法作用：发现有些URL不合法，会自动插入空格，当然也可能插入些别的，这里只处理了空格
     */
    public static String clearBlank(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        int l = stringBuilder.length();
        for(int i=0; i<l;i++){
            if(stringBuilder.charAt(i) == 32){
                stringBuilder.deleteCharAt(i);
                l--;
            }
        }
        return stringBuilder.toString();
    }
    /*
    方法作用：递归搜素body内的所有图片标签，并取出其URL，这里推荐使用jsoup的选择器，功能强大效率高，比递归我多了
     */
    public static void reseachImg(Element root, List list){
        Elements son = root.children();
        if(son == null){
            return;
        }else{
            for (Element e : son){
                reseachImg(e, list);
                if (e.tagName().equals("img")){
                    list.add(clearBlank(e.attr("src")));
                }
            }
        }
    }
    /*
    方法作用：通过URL 下载图片到本地
     */
    static int a = 0;
    public static void newFile(String url) throws MalformedURLException, IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        InputStream input = entity.getContent();
        BufferedInputStream bufferedInput = new BufferedInputStream(input);
        File file = new File(category + a + ".png"); //category是我电脑的一个文件目录， 注意不可全盘照抄 会出错的
        FileOutputStream output = new FileOutputStream(file);
        byte[] imgByte = new byte[1024*2];
        int len = 0;
        while((len = bufferedInput.read(imgByte, 0, imgByte.length)) != -1){
            output.write(imgByte, 0, len);
        }
        input.close();
        output.close();
        System.out.println(url + " 已完成.");
        a++;
    }
    public static class DowanImg extends Thread{
        private List<String> list;
        public DowanImg(List l){
            list = l;
        }
        public void run(){
            for(String s: list){
                try{
                    newFile(s);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
