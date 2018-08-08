package com.cgd.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Home {
	private static String pathName="G:/自媒体/test.html";
	 public static void main(String[] args) throws IllegalArgumentException,Exception {
		 List<ZhuangZaiData> acticleList = getActicleList();
		 System.out.println(acticleList.size());
		 for (int i = 0; i < acticleList.size(); i++) {

				 ZhuangZaiData zhuangZaiData = acticleList.get(i);
				 isHadExist(zhuangZaiData);
				 //zhuangZaiData.setIsHadExist(isHadExist);
			 System.out.println(i*100/acticleList.size()+"%");
		}
		 System.out.println("100%");
		 //updateElements(acticleList);

		 //String json = new Gson().toJson(acticleList);
		 //System.out.println(json);
	 }
	 
	 public static List<ZhuangZaiData> getActicleList() throws IOException {
		    List<ZhuangZaiData> list=new ArrayList<ZhuangZaiData>();
			File input = new File(pathName);
			Document doc = Jsoup.parse(input, "UTF-8", "");
			Elements elementsByClass = doc.getElementsByClass("list imgList");
			for (Element element : elementsByClass) {

				ZhuangZaiData zhuangZaiData=new ZhuangZaiData();
				zhuangZaiData.setTitle(element.getElementsByTag("h1").text());
				zhuangZaiData.setHrefData(element.select("a").first().attr("href"));
				list.add(zhuangZaiData);

			}
			return list;
	}
	 
	 
	 public static void updateElements(List<ZhuangZaiData> list) throws IOException, InterruptedException {
			File input = new File(pathName);
			Document doc = Jsoup.parse(input, "UTF-8", "");
			Elements elementsByClass = doc.getElementsByClass("list imgList");
			
			int size = elementsByClass.size();
			for (int i = 0; i < elementsByClass.size(); i++) {

					 Boolean isHadExist = list.get(i).getIsHadExist();
					 Element first = elementsByClass.get(i).getElementsByClass("left").get(0).getElementsByTag("h1").first(); ;
						if(isHadExist) {
							//first.html(list.get(i).getTitle()+"(该文章已被搬运)"); // 清空所有文本输入框中的文本
							elementsByClass.get(i).remove();
						}else {
							//first.html(list.get(i).getTitle()+"(该文章可以搬)"); // 清空所有文本输入框中的文本
						}

			}

		 /*
		  * Jsoup只是解析，不能保存修改，所以要在这里保存修改。
		  */
		 FileOutputStream fos = new FileOutputStream(pathName, false);
		 OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		 osw.write(doc.html());
		 osw.close();
			
	}
	 
	 public static boolean isHadExist(ZhuangZaiData zhuangZaiData){
		 try{

		 String searchUrl="http://m.look.360.cn/s?q=";
		 String params="&f=jsonp&sign=look&pn=0&uid=test_zm&scheme=https&callback=jQuery191005605343690687681_1529393300244&_=1529393300249";
		 String requestUrl=searchUrl+zhuangZaiData.getTitle()+params;
		 System.out.println(requestUrl);
		 String result = HttpClient4.doGet(requestUrl);
		 //真狠心 对满头鲜血的好友弃之不顾 致其死亡后还冷静抛尸 上
			 System.out.println(""+result);
		 result = result.substring(result.indexOf("(")+1,result.lastIndexOf(")"));

		 Acticle Acticle=new Gson().fromJson(result, Acticle.class);
		 com.cgd.test.Acticle.DataBean data = Acticle.getData();
		 if(data!=null) {
			 int count = data.getCount();
			 if(count>0) {
				 return true;//已经存在该文章
			 }
		 }
		 ParseHtml(zhuangZaiData.getTitle(),zhuangZaiData.getHrefData());
		 }catch (Exception e){
			e.printStackTrace();
		 }
		 return false;//还没该文章呢
	 }



    private static void ParseHtml(String title,String url){
	 	try{

        Document doc = Jsoup.connect(url)
                .data("query", "Java")   // 请求参数
                .userAgent("I ’ m jsoup") // 设置 User-Agent
                .cookie("auth", "token") // 设置 cookie
                .timeout(3000)           // 设置连接超时时间
                .get();                 // 使用 POST 方法访问 URL
        doc.getElementsByClass("info").remove();

        if(doc.getElementsByTag("p").size()>=2){
			String text1=doc.getElementsByTag("p").get(0).text();
			String text2=doc.getElementsByTag("p").get(1).text();
			if(text1.contains("都市现场")||text1.contains("jxtvdsxc")){
				doc.getElementsByTag("p").get(0).remove();
			}
			if(text2.contains("请注明所有来源")){
				doc.getElementsByTag("p").get(0).remove();
			}
		}
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

        writeFile(title,docStr);

		}catch (Exception e){
			e.printStackTrace();
		}

    }


    //注意：上面的例子由于写入的文本很少，使用FileWrite类就可以了。但如果需要写入的
    //内容很多，就应该使用更为高效的缓冲器流类BufferedWriter。
    /**
     * 使用BufferedWriter类写文本文件
     */
    private static void writeFile(String title,String docStr)
    {
        String basePath="C:/Users/Administrator/Desktop/article/";
		//String basePath="C:/Users/Administrator/Desktop/test/";
        String fileName=basePath+title+".html";
        try
        {
            BufferedWriter out=new BufferedWriter(new FileWriter(fileName));
            out.write(docStr);
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
	 

}