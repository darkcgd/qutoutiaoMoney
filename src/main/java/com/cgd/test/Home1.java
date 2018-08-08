package com.cgd.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Home1 {
    private static String pathName = "G:/自媒体/test.html";


    private static String daoyus[] = {
            "（导语：都说清官难断家务事，谁对谁错，大家都来发表一下意见吧！）",
            "（导语：老话说得好，清官难断家务事，什么事情都是有原因)",
            "（导语：请大家来帮我分析下，这件事谁对谁错！)",
            //"（导语：常言道，家家有本难念的经，我是情感温酒，倾听你的情感故事！）",
            //"（导语：原来，爱比不爱更寂寞！欲了解更多婚姻生活、情感故事、恋爱秘籍和婆媳相处等情感话题，请关注“情感温酒”！)",
            "(导语：有时我们的选择，只有等待，没有结果，只能黯然离开;有时我们的放弃，迫于无奈，含泪转身，却心有不甘;所以，有些曾经，关于幸福或苦痛，只能深埋心底;有些希冀，关于现在或将来，只能逐步遗忘!)"
    };

    private static String zhongjians[] = {"<p>（PS：感谢您的阅读！谢谢！）</p>",
            "<p>（结语：后来，我觉得生活不止只有诗和远方，还有面前的苟且！）</p>",
            "<p>（结语：后来，我觉得生活不止只有诗和远方，还有面前的苟且！）</p>",
    };

    private static String jieyus[] = {"（结语：欢迎大家关注本趣头条号，我会把大家的故事给写出来，同时欢迎大家可以私信我，把你的故事与我们分享！）<br>",
            "（PS：感谢大家的阅读，欢迎关注本趣头条号，你我的故事皆可共享！谢谢！)",
            //"（结语：欲了解更多婚姻生活、情感故事、恋爱秘籍和婆媳相处等情感话题，请关注“情感温酒”，谢谢！)",
            //"（结语：感谢您关注“情感温酒”，每天为您分享一些走心的情感小故事!）",
            "（结语：欢迎关注本趣头条号，还望各位看官给个赞，收藏评论一番，谢谢！)"
    };

    public static void main(String[] args) throws IllegalArgumentException, Exception {
        List<ZhuangZaiData> acticleList = getActicleList();
        //System.out.println(acticleList.size());
        for (int i = 0; i < acticleList.size(); i++) {
            ZhuangZaiData zhuangZaiData = acticleList.get(i);
            ParseHtml(zhuangZaiData.getTitle(), zhuangZaiData.getHrefData());
            System.out.println(i * 100 / acticleList.size() + "%");
        }
        System.out.println("100%");

    }

    public static List<ZhuangZaiData> getActicleList() throws IOException {
        List<ZhuangZaiData> list = new ArrayList<ZhuangZaiData>();
        File input = new File(pathName);
        Document doc = Jsoup.parse(input, "UTF-8", "");
        Elements elementsByClass = doc.getElementsByClass("list imgList");
        for (Element element : elementsByClass) {

            ZhuangZaiData zhuangZaiData = new ZhuangZaiData();
            zhuangZaiData.setTitle(element.getElementsByTag("h1").text());
            zhuangZaiData.setHrefData(element.select("a").first().attr("href"));
            list.add(zhuangZaiData);

        }
        return list;
    }

    private static void ParseHtml(String title, String url) {
        try {

            Document doc = Jsoup.connect(url)
                    .data("query", "Java")   // 请求参数
                    .userAgent("I ’ m jsoup") // 设置 User-Agent
                    .cookie("auth", "token") // 设置 cookie
                    .timeout(3000)           // 设置连接超时时间
                    .get();                 // 使用 POST 方法访问 URL
            doc.getElementsByClass("info").remove();

            if (doc.getElementsByTag("p").size() >= 2) {
                String text1 = doc.getElementsByTag("p").get(0).text();
                String text2 = doc.getElementsByTag("p").get(1).text();
                if (text1.contains("都市现场") || text1.contains("jxtvdsxc")) {
                    doc.getElementsByTag("p").get(0).remove();
                }
                if (text2.contains("请注明所有来源")) {
                    doc.getElementsByTag("p").get(0).remove();
                }
            }
            String docStr = doc.toString();
            if (docStr.contains("var s = 'http:';")) {
                docStr = docStr.replace("var s = 'http:';", "var s = 'httpss:';");
            }


            Elements content = doc.getElementsByClass("content");
            for (int i = 0; i < content.size(); i++) {
                Elements p = content.get(0).getElementsByTag("p");
                String text = p.text();
                
            }


            String[] arys = docStr.split("。");


            int length = arys.length;
            StringBuilder sb= new StringBuilder();
            int daoyuRandomInt =(int)(0+Math.random()*(daoyus.length));
            sb.append(daoyus[daoyuRandomInt]);
            //10 3 6
            for (int i = 0; i < length; i++) {
                if(length/3==i||length*2/3==i){
                    sb.append(arys[i]+"。");
                    int zhongjianRandomInt =(int)(0+Math.random()*(zhongjians.length));
                    sb.append(zhongjians[zhongjianRandomInt]);
                }else{
                    if(i==length-1){
                        sb.append(arys[i]);
                    }else{
                        sb.append(arys[i]+"。");
                    }

                }
            }

            int jieyuRandomInt =(int)(0+Math.random()*(jieyus.length));
            sb.append(jieyus[jieyuRandomInt]);
            docStr=sb.toString();

            docStr = docStr.replaceAll("。","。</p><p>");
            docStr = docStr.replaceAll("</p><p>”</p>","</p><p>");


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

            writeFile(title, docStr);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //注意：上面的例子由于写入的文本很少，使用FileWrite类就可以了。但如果需要写入的
    //内容很多，就应该使用更为高效的缓冲器流类BufferedWriter。

    /**
     * 使用BufferedWriter类写文本文件
     */
    private static void writeFile(String title, String docStr) {
        String basePath = "C:/Users/Administrator/Desktop/test/";
        //String basePath="C:/Users/Administrator/Desktop/test/";
        String fileName = basePath + title + ".html";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(docStr);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}