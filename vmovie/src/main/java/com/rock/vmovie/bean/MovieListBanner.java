package com.rock.vmovie.bean;

import java.util.List;

/**
 * Created by Rock on 16/12/5.
 */

public class MovieListBanner {

    private String status;

    private String msg;

    private List<MovieBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<MovieBean> getData() {
        return data;
    }

    public void setData(List<MovieBean> data) {
        this.data = data;
    }

    public static class MovieBean {

        private String bannerid;

        private String type;

        private String object_id;

        private String title;

        private String image;

        private ExtraDataBean extra_data;

        public String getBannerid() {
            return bannerid;
        }

        public void setBannerid(String bannerid) {
            this.bannerid = bannerid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public ExtraDataBean getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(ExtraDataBean extra_data) {
            this.extra_data = extra_data;
        }

        public static class ExtraDataBean {

            private String app_banner_type;

            private String app_banner_param;

            private String is_album;

            public String getApp_banner_type() {
                return app_banner_type;
            }

            public void setApp_banner_type(String app_banner_type) {
                this.app_banner_type = app_banner_type;
            }

            public String getApp_banner_param() {
                return app_banner_param;
            }

            public void setApp_banner_param(String app_banner_param) {
                this.app_banner_param = app_banner_param;
            }

            public String getIs_album() {
                return is_album;
            }

            public void setIs_album(String is_album) {
                this.is_album = is_album;
            }
        }
    }

}
