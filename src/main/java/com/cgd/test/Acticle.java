package com.cgd.test;

import java.util.List;

/**
 * Created by Dark on 2018/6/19.
 */

public class Acticle {

    /**
     * errno : 0
     * errmsg :
     * data : {"start":0,"count":1,"dspcnt":1,"total":1,"errno":0,"retry":0,"query_footprint":"","query_intent":1,"result":[{"md5":"8d1fc0ed6ff9b627","content":"<b>鸡蛋<\/b>吧。\"我看见了说:\"我现在也不缺你这点东西,脏死了,你快回去吧,一会让人家看见了不好说。\"我就把母亲给哄走了。又过了<b>半年<\/b>左右吧,爸爸... 我害怕他也回来找我,我就关机了,第二天父亲依旧给我打了好多电话,我意识到出事了,就买了车票回了家,回到家后,<b>我说不出话<\/b>!我看到家门口挂...","site":"www.toutiao.com","rptid":"9d989d81c217069a","rptid1":"9d989d81","tag":"情感 婆婆","newsrank":"0","i":"http://p0.qhimgs4.com/t01228bbc6e5bafc1b4.jpg|http://p2.qhimgs4.com/t01ada413f398c52fe4.jpg|http://p0.qhimgs4.com/t017ad2c053f517be45.jpg","sgif":"","f":"","r":"b58ca6dfd4ad44c3","c":"social","a":"h","s":"t","style":"6","rawurl":"https://www.toutiao.com/a6518245672817263112/","cmt_num":"0","zan_num":"0","cai_num":"0","pnum":"3","zm_qid":"","zm_avatar":"","crflag":"0","delflag":"0","url_footprint":"CAAQABgAKJXf4NMFMAE=","vertical info":"","se":{"prefix":1,"docId":20594754,"sort0":1842},"t":"<b>坐月子婆婆给2万,妈给2鸡蛋,怒赶妈走,半年后回家我说不出话<\/b>","p":"1517825941","u":"http://m.news.so.com/transcoding?url=https%3A//www.toutiao.com/a6518245672817263112/&check=adf70b3f504eca7b&templectl=7&360newsdetail=1","pcurl":"https://sh.qihoo.com/2s22uxd9u71?sign=look&uid=test_zm","gnid":"2s22uxd9u71"}],"consume":4,"sid":"b348237c03c05dd8ffecb6377b305362"}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * start : 0
         * count : 1
         * dspcnt : 1
         * total : 1
         * errno : 0
         * retry : 0
         * query_footprint :
         * query_intent : 1
         * result : [{"md5":"8d1fc0ed6ff9b627","content":"<b>鸡蛋<\/b>吧。\"我看见了说:\"我现在也不缺你这点东西,脏死了,你快回去吧,一会让人家看见了不好说。\"我就把母亲给哄走了。又过了<b>半年<\/b>左右吧,爸爸... 我害怕他也回来找我,我就关机了,第二天父亲依旧给我打了好多电话,我意识到出事了,就买了车票回了家,回到家后,<b>我说不出话<\/b>!我看到家门口挂...","site":"www.toutiao.com","rptid":"9d989d81c217069a","rptid1":"9d989d81","tag":"情感 婆婆","newsrank":"0","i":"http://p0.qhimgs4.com/t01228bbc6e5bafc1b4.jpg|http://p2.qhimgs4.com/t01ada413f398c52fe4.jpg|http://p0.qhimgs4.com/t017ad2c053f517be45.jpg","sgif":"","f":"","r":"b58ca6dfd4ad44c3","c":"social","a":"h","s":"t","style":"6","rawurl":"https://www.toutiao.com/a6518245672817263112/","cmt_num":"0","zan_num":"0","cai_num":"0","pnum":"3","zm_qid":"","zm_avatar":"","crflag":"0","delflag":"0","url_footprint":"CAAQABgAKJXf4NMFMAE=","vertical info":"","se":{"prefix":1,"docId":20594754,"sort0":1842},"t":"<b>坐月子婆婆给2万,妈给2鸡蛋,怒赶妈走,半年后回家我说不出话<\/b>","p":"1517825941","u":"http://m.news.so.com/transcoding?url=https%3A//www.toutiao.com/a6518245672817263112/&check=adf70b3f504eca7b&templectl=7&360newsdetail=1","pcurl":"https://sh.qihoo.com/2s22uxd9u71?sign=look&uid=test_zm","gnid":"2s22uxd9u71"}]
         * consume : 4
         * sid : b348237c03c05dd8ffecb6377b305362
         */

        private int start;
        private int count;
        private int dspcnt;
        private int total;
        private int errno;
        private int retry;
        private String query_footprint;
        private int query_intent;
        private int consume;
        private String sid;
        private List<ResultBean> result;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getDspcnt() {
            return dspcnt;
        }

        public void setDspcnt(int dspcnt) {
            this.dspcnt = dspcnt;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getErrno() {
            return errno;
        }

        public void setErrno(int errno) {
            this.errno = errno;
        }

        public int getRetry() {
            return retry;
        }

        public void setRetry(int retry) {
            this.retry = retry;
        }

        public String getQuery_footprint() {
            return query_footprint;
        }

        public void setQuery_footprint(String query_footprint) {
            this.query_footprint = query_footprint;
        }

        public int getQuery_intent() {
            return query_intent;
        }

        public void setQuery_intent(int query_intent) {
            this.query_intent = query_intent;
        }

        public int getConsume() {
            return consume;
        }

        public void setConsume(int consume) {
            this.consume = consume;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * md5 : 8d1fc0ed6ff9b627
             * content : <b>鸡蛋</b>吧。"我看见了说:"我现在也不缺你这点东西,脏死了,你快回去吧,一会让人家看见了不好说。"我就把母亲给哄走了。又过了<b>半年</b>左右吧,爸爸... 我害怕他也回来找我,我就关机了,第二天父亲依旧给我打了好多电话,我意识到出事了,就买了车票回了家,回到家后,<b>我说不出话</b>!我看到家门口挂...
             * site : www.toutiao.com
             * rptid : 9d989d81c217069a
             * rptid1 : 9d989d81
             * tag : 情感 婆婆
             * newsrank : 0
             * i : http://p0.qhimgs4.com/t01228bbc6e5bafc1b4.jpg|http://p2.qhimgs4.com/t01ada413f398c52fe4.jpg|http://p0.qhimgs4.com/t017ad2c053f517be45.jpg
             * sgif :
             * f :
             * r : b58ca6dfd4ad44c3
             * c : social
             * a : h
             * s : t
             * style : 6
             * rawurl : https://www.toutiao.com/a6518245672817263112/
             * cmt_num : 0
             * zan_num : 0
             * cai_num : 0
             * pnum : 3
             * zm_qid :
             * zm_avatar :
             * crflag : 0
             * delflag : 0
             * url_footprint : CAAQABgAKJXf4NMFMAE=
             * vertical info :
             * se : {"prefix":1,"docId":20594754,"sort0":1842}
             * t : <b>坐月子婆婆给2万,妈给2鸡蛋,怒赶妈走,半年后回家我说不出话</b>
             * p : 1517825941
             * u : http://m.news.so.com/transcoding?url=https%3A//www.toutiao.com/a6518245672817263112/&check=adf70b3f504eca7b&templectl=7&360newsdetail=1
             * pcurl : https://sh.qihoo.com/2s22uxd9u71?sign=look&uid=test_zm
             * gnid : 2s22uxd9u71
             */

            private String md5;
            private String content;
            private String site;
            private String rptid;
            private String rptid1;
            private String tag;
            private String newsrank;
            private String i;
            private String sgif;
            private String f;
            private String r;
            private String c;
            private String a;
            private String s;
            private String style;
            private String rawurl;
            private String cmt_num;
            private String zan_num;
            private String cai_num;
            private String pnum;
            private String zm_qid;
            private String zm_avatar;
            private String crflag;
            private String delflag;
            private String url_footprint;

            private SeBean se;
            private String t;
            private String p;
            private String u;
            private String pcurl;
            private String gnid;

            public String getMd5() {
                return md5;
            }

            public void setMd5(String md5) {
                this.md5 = md5;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getSite() {
                return site;
            }

            public void setSite(String site) {
                this.site = site;
            }

            public String getRptid() {
                return rptid;
            }

            public void setRptid(String rptid) {
                this.rptid = rptid;
            }

            public String getRptid1() {
                return rptid1;
            }

            public void setRptid1(String rptid1) {
                this.rptid1 = rptid1;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getNewsrank() {
                return newsrank;
            }

            public void setNewsrank(String newsrank) {
                this.newsrank = newsrank;
            }

            public String getI() {
                return i;
            }

            public void setI(String i) {
                this.i = i;
            }

            public String getSgif() {
                return sgif;
            }

            public void setSgif(String sgif) {
                this.sgif = sgif;
            }

            public String getF() {
                return f;
            }

            public void setF(String f) {
                this.f = f;
            }

            public String getR() {
                return r;
            }

            public void setR(String r) {
                this.r = r;
            }

            public String getC() {
                return c;
            }

            public void setC(String c) {
                this.c = c;
            }

            public String getA() {
                return a;
            }

            public void setA(String a) {
                this.a = a;
            }

            public String getS() {
                return s;
            }

            public void setS(String s) {
                this.s = s;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getRawurl() {
                return rawurl;
            }

            public void setRawurl(String rawurl) {
                this.rawurl = rawurl;
            }

            public String getCmt_num() {
                return cmt_num;
            }

            public void setCmt_num(String cmt_num) {
                this.cmt_num = cmt_num;
            }

            public String getZan_num() {
                return zan_num;
            }

            public void setZan_num(String zan_num) {
                this.zan_num = zan_num;
            }

            public String getCai_num() {
                return cai_num;
            }

            public void setCai_num(String cai_num) {
                this.cai_num = cai_num;
            }

            public String getPnum() {
                return pnum;
            }

            public void setPnum(String pnum) {
                this.pnum = pnum;
            }

            public String getZm_qid() {
                return zm_qid;
            }

            public void setZm_qid(String zm_qid) {
                this.zm_qid = zm_qid;
            }

            public String getZm_avatar() {
                return zm_avatar;
            }

            public void setZm_avatar(String zm_avatar) {
                this.zm_avatar = zm_avatar;
            }

            public String getCrflag() {
                return crflag;
            }

            public void setCrflag(String crflag) {
                this.crflag = crflag;
            }

            public String getDelflag() {
                return delflag;
            }

            public void setDelflag(String delflag) {
                this.delflag = delflag;
            }

            public String getUrl_footprint() {
                return url_footprint;
            }

            public void setUrl_footprint(String url_footprint) {
                this.url_footprint = url_footprint;
            }



            public SeBean getSe() {
                return se;
            }

            public void setSe(SeBean se) {
                this.se = se;
            }

            public String getT() {
                return t;
            }

            public void setT(String t) {
                this.t = t;
            }

            public String getP() {
                return p;
            }

            public void setP(String p) {
                this.p = p;
            }

            public String getU() {
                return u;
            }

            public void setU(String u) {
                this.u = u;
            }

            public String getPcurl() {
                return pcurl;
            }

            public void setPcurl(String pcurl) {
                this.pcurl = pcurl;
            }

            public String getGnid() {
                return gnid;
            }

            public void setGnid(String gnid) {
                this.gnid = gnid;
            }

            public static class SeBean {
                /**
                 * prefix : 1
                 * docId : 20594754
                 * sort0 : 1842
                 */

                private int prefix;
                private int docId;
                private int sort0;

                public int getPrefix() {
                    return prefix;
                }

                public void setPrefix(int prefix) {
                    this.prefix = prefix;
                }

                public int getDocId() {
                    return docId;
                }

                public void setDocId(int docId) {
                    this.docId = docId;
                }

                public int getSort0() {
                    return sort0;
                }

                public void setSort0(int sort0) {
                    this.sort0 = sort0;
                }
            }
        }
    }
}
