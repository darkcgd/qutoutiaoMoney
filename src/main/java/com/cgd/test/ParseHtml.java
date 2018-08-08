package com.cgd.test;

import java.io.IOException;
import java.util.Iterator;

import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtml {
    public static void main(String[] args) throws ParseException, IOException {
        String url = "http://html2.qktoutiao.com/detail/2018/07/05/109799816.html?content_id=109799816&key=2dafTnpVxCNpYZeB5SYStMvY7nl5KzBtA8nmHbfhRtkFBOaGsnpYsPLv2fvBB43Wm1vkoOWjEpuOvzwyf3aU7GLtuecvl9ODJ5HOiPM_cmbjSFkU70mVDc_i3hYp386QYw3oOA&pv_id=%7B184A4661-68ED-8251-EA30-A2DC05978F9B%7D&cid=29&cat=29&rss_source=&fr=17&hj=0&mod_id=&o=1&p=1&fqc_flag=0&skip_ad=0";
        Document doc = Jsoup.connect(url)
                .data("query", "Java")   // 请求参数
                .userAgent("I ’ m jsoup") // 设置 User-Agent
                .cookie("auth", "token") // 设置 cookie
                .timeout(3000)           // 设置连接超时时间
                .get();                 // 使用 POST 方法访问 URL
        doc.getElementsByClass("info").remove();
        String docStr = doc.toString();
        if (docStr.contains("var s = 'http:';")) {
            docStr = docStr.replace("var s = 'http:';", "var s = 'httpss:';");
        }

        Elements script = doc.getElementsByClass("script");
        for (Iterator<Element> it = script.iterator(); it.hasNext(); ) {
            Element e = (Element) it.next();
            // 输出其text值和其属性值（可以将href改为其他属性名称，例如src）
            System.out.println(e.text() + "\n");

        }


        String regexStr = "</h1>";
        String regexScriptStr = "</body>";


        String addHtml = "<div id=\"adddiv\">\n" +
                "     <textarea id=\"input\" style=\"width:100px;height:40px;\"></textarea>\n" +
                "    <button type=\"button\" onclick=\"copyText()\" style=\"width:100px;height:40px;\">复制</button>\n" +
                "    <button type=\"button\" onclick=\"clearTitle()\" style=\"width:100px;height:40px;\">清除标题</button>\n" +
                "    </div>";

        String addScript = "<script>\n" +
                "function copyText(){\n" +
                "  var text = document.getElementsByTagName(\"h1\")[0].innerHTML;\n" +
                "  var input = document.getElementById(\"input\");\n" +
                "  input.value = text;input.select(); \n" +
                "  document.execCommand(\"copy\");\n" +
                "};\n" +
                "function clearTitle(){\n" +
                "  document.getElementsByTagName(\"h1\")[0].style.display=\"none\";\n" +
                "  document.getElementById(\"adddiv\").style.display=\"none\";\n" +
                "}\n" +
                "</script> ";


        String[] ary = docStr.split(regexStr);

        docStr = ary[0] + regexStr + addHtml + ary[1];

        String[] aryScript = docStr.split(regexScriptStr);

        docStr = aryScript[0] + addScript + regexScriptStr + aryScript[1];

        System.out.println(docStr);

    }
}
