package com.cgd.test;

import com.cgd.util.WebClientUtil;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class TestHttpUnit {
    private static String url="http://h5ssl3.1sapp.com/qukan_new2/dest/zmt_home/read/zmt_home/index.html?id=143165";
    public static void main(String[] args) throws IllegalArgumentException,Exception {

        /*Document htmlPage = WebClientUtil.getHtmlPage("http://h5ssl3.1sapp.com/qukan_new2/dest/zmt_home/read/zmt_home/index.html?id=143165", 10000);
        String htmlStr = htmlPage.toString();
        System.out.println(htmlStr);*/

        //crawlPageWithAnalyseJs(url);
        test1();
    }


    /**
     * 功能描述：抓取页面时并解析页面的js
     * @param url
     * @throws Exception
     */
    private static  void crawlPageWithAnalyseJs(String url) throws Exception{
        //1.创建连接client
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //2.设置连接的相关选项
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);  //需要解析js
        webClient.getOptions().setThrowExceptionOnScriptError(false);  //解析js出错时不抛异常
        webClient.getOptions().setTimeout(10000);  //超时时间  ms
        //3.抓取页面
        HtmlPage page = webClient.getPage(url);
        //4.将页面转成指定格式
        webClient.waitForBackgroundJavaScript(10000);   //等侍js脚本执行完成
        System.out.println(page.asXml());
        //5.关闭模拟的窗口
        webClient.close();
    }

    private static void test1() throws IOException {
        // 得到浏览器对象，直接New一个就能得到，现在就好比说你得到了一个浏览器了
        WebClient webclient = new WebClient();

        // 这里是配置一下不加载css和javaScript，因为httpunit对javascript兼容性不太好
        webclient.getOptions().setCssEnabled(false);
        webclient.getOptions().setJavaScriptEnabled(false);

        // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
        HtmlPage htmlpage = webclient.getPage(url);
        System.out.println(htmlpage.asText());
        // 根据名字得到一个表单，查看上面这个网页的源代码可以发现表单的名字叫“f”
        //final HtmlForm form = htmlpage.getFormByName("f");
        // 同样道理，获取”百度一下“这个按钮
        //final HtmlSubmitInput button = form.getInputByValue("百度一下");
        // 得到搜索框
        //final HtmlTextInput textField = form.getInputByName("q1");
        //搜索我的id
        //textField.setValueAttribute("th是个小屁孩");
        // 输入好了，我们点一下这个按钮
        //final HtmlPage nextPage = button.click();
        // 我把结果转成String
        //String result = nextPage.asXml();

        //System.out.println(result);  //得到的是点击后的网页
    }


}
