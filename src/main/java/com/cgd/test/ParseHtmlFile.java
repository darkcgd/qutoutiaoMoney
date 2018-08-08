package com.cgd.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseHtmlFile {
	private static List<ZhuangZaiData> list=new ArrayList<ZhuangZaiData>();
	public static void main(String[] args) throws IOException {
		File input = new File("/Users/dark/Desktop/test.html");
		Document doc = Jsoup.parse(input, "UTF-8", "");
		Elements elementsByClass = doc.getElementsByClass("list imgList");
		for (Element element : elementsByClass) {
			ZhuangZaiData zhuangZaiData=new ZhuangZaiData();
			zhuangZaiData.setTitle(element.getElementsByTag("h1").text());
			zhuangZaiData.setHrefData(element.select("a").first().attr("href"));
			list.add(zhuangZaiData);
		}
		System.out.println(list.size());
		System.out.println(list.toString());
	}
}
