package com.rock.vmovie.bean;

import java.util.List;

/**
 * Created by Rock on 16/12/5.
 */

public class ChannelList {


    private List<ChannelBean> data;

    public List<ChannelBean> getData() {
        return data;
    }

    public void setData(List<ChannelBean> data) {
        this.data = data;
    }

    public static class ChannelBean {
        /**
         * cate_type : 0
         * orderid : 1
         * cateid : 6
         * catename : 创意
         * alias : Idea
         * icon : http://cs.vmoiver.com/Uploads/Series/2016-04-12/570c9f3d1bc2d.jpg
         */

        private String cate_type;
        private String orderid;
        private String cateid;
        private String catename;
        private String alias;
        private String icon;

        public String getCate_type() {
            return cate_type;
        }

        public void setCate_type(String cate_type) {
            this.cate_type = cate_type;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getCateid() {
            return cateid;
        }

        public void setCateid(String cateid) {
            this.cateid = cateid;
        }

        public String getCatename() {
            return catename;
        }

        public void setCatename(String catename) {
            this.catename = catename;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
