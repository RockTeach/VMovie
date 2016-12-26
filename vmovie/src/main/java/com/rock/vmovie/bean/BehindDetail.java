package com.rock.vmovie.bean;

import java.util.List;

/**
 * Created by Rock on 2016/12/26.
 */

public class BehindDetail {


    /**
     * status : 0
     * msg : OK
     * data : {"postid":"49435","title":"【电影自习室】 番外篇-绿幕搭建和拍摄技巧 上海温哥华电影学院","app_fu_title":"","intro":"","count_comment":"31","is_album":"0","is_collect":"0","content":{"video":[{"image":"http://cs.vmoiver.com/Uploads/cover/2016-06-28/577265fb08758_cut.jpeg","title":"【电影自习室】 番外篇-绿幕搭建和拍摄技巧 上海温哥华电影学院","duration":"1049","filesize":"330530831","source_link":"http://v.youku.com/v_show/id_XMTYyNDExOTkyNA==.html?from=y1.7-1.2","qiniu_url":"http://qiniu.vmovier.vmoviercdn.com/57726dcf6644b.mp4"}]},"image":"http://cs.vmoiver.com/Uploads/cover/2016-06-28/577265fb08758_cut.jpeg","rating":"0.0","publish_time":"1467169220","count_like":"414","count_share":"613","cate":["电影自习室"],"share_link":{"sweibo":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_qq"},"tags":"","share_sub_title":"本期我们请到了上海温哥华电影学院Shawn Tilling老师给大家详细的讲一下关于绿幕搭建和拍摄的核心知识。","weibo_share_image":"http://service.vmoiver.com/h5/Imagick/vmovier_weibo_share?id=49435"}
     */

    private String status;
    private String msg;
    private DetailBean data;

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

    public DetailBean getData() {
        return data;
    }

    public void setData(DetailBean data) {
        this.data = data;
    }

    public static class DetailBean {
        /**
         * postid : 49435
         * title : 【电影自习室】 番外篇-绿幕搭建和拍摄技巧 上海温哥华电影学院
         * app_fu_title :
         * intro :
         * count_comment : 31
         * is_album : 0
         * is_collect : 0
         * content : {"video":[{"image":"http://cs.vmoiver.com/Uploads/cover/2016-06-28/577265fb08758_cut.jpeg","title":"【电影自习室】 番外篇-绿幕搭建和拍摄技巧 上海温哥华电影学院","duration":"1049","filesize":"330530831","source_link":"http://v.youku.com/v_show/id_XMTYyNDExOTkyNA==.html?from=y1.7-1.2","qiniu_url":"http://qiniu.vmovier.vmoviercdn.com/57726dcf6644b.mp4"}]}
         * image : http://cs.vmoiver.com/Uploads/cover/2016-06-28/577265fb08758_cut.jpeg
         * rating : 0.0
         * publish_time : 1467169220
         * count_like : 414
         * count_share : 613
         * cate : ["电影自习室"]
         * share_link : {"sweibo":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_sweibo","weixin":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_weixin","qzone":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_qzone","qq":"http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_qq"}
         * tags :
         * share_sub_title : 本期我们请到了上海温哥华电影学院Shawn Tilling老师给大家详细的讲一下关于绿幕搭建和拍摄的核心知识。
         * weibo_share_image : http://service.vmoiver.com/h5/Imagick/vmovier_weibo_share?id=49435
         */

        private String postid;
        private String title;
        private String app_fu_title;
        private String intro;
        private String count_comment;
        private String is_album;
        private String is_collect;
        private ContentBean content;
        private String image;
        private String rating;
        private String publish_time;
        private String count_like;
        private String count_share;
        private ShareLinkBean share_link;
        private String tags;
        private String share_sub_title;
        private String weibo_share_image;
        private List<String> cate;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getApp_fu_title() {
            return app_fu_title;
        }

        public void setApp_fu_title(String app_fu_title) {
            this.app_fu_title = app_fu_title;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getCount_comment() {
            return count_comment;
        }

        public void setCount_comment(String count_comment) {
            this.count_comment = count_comment;
        }

        public String getIs_album() {
            return is_album;
        }

        public void setIs_album(String is_album) {
            this.is_album = is_album;
        }

        public String getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(String is_collect) {
            this.is_collect = is_collect;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getCount_like() {
            return count_like;
        }

        public void setCount_like(String count_like) {
            this.count_like = count_like;
        }

        public String getCount_share() {
            return count_share;
        }

        public void setCount_share(String count_share) {
            this.count_share = count_share;
        }

        public ShareLinkBean getShare_link() {
            return share_link;
        }

        public void setShare_link(ShareLinkBean share_link) {
            this.share_link = share_link;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getShare_sub_title() {
            return share_sub_title;
        }

        public void setShare_sub_title(String share_sub_title) {
            this.share_sub_title = share_sub_title;
        }

        public String getWeibo_share_image() {
            return weibo_share_image;
        }

        public void setWeibo_share_image(String weibo_share_image) {
            this.weibo_share_image = weibo_share_image;
        }

        public List<String> getCate() {
            return cate;
        }

        public void setCate(List<String> cate) {
            this.cate = cate;
        }

        public static class ContentBean {
            private List<VideoBean> video;

            public List<VideoBean> getVideo() {
                return video;
            }

            public void setVideo(List<VideoBean> video) {
                this.video = video;
            }

            public static class VideoBean {
                /**
                 * image : http://cs.vmoiver.com/Uploads/cover/2016-06-28/577265fb08758_cut.jpeg
                 * title : 【电影自习室】 番外篇-绿幕搭建和拍摄技巧 上海温哥华电影学院
                 * duration : 1049
                 * filesize : 330530831
                 * source_link : http://v.youku.com/v_show/id_XMTYyNDExOTkyNA==.html?from=y1.7-1.2
                 * qiniu_url : http://qiniu.vmovier.vmoviercdn.com/57726dcf6644b.mp4
                 */

                private String image;
                private String title;
                private String duration;
                private String filesize;
                private String source_link;
                private String qiniu_url;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getFilesize() {
                    return filesize;
                }

                public void setFilesize(String filesize) {
                    this.filesize = filesize;
                }

                public String getSource_link() {
                    return source_link;
                }

                public void setSource_link(String source_link) {
                    this.source_link = source_link;
                }

                public String getQiniu_url() {
                    return qiniu_url;
                }

                public void setQiniu_url(String qiniu_url) {
                    this.qiniu_url = qiniu_url;
                }
            }
        }

        public static class ShareLinkBean {
            /**
             * sweibo : http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_sweibo
             * weixin : http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_weixin
             * qzone : http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_qzone
             * qq : http://www.vmovier.com/49435?debug=1&_vfrom=VmovierApp_qq
             */

            private String sweibo;
            private String weixin;
            private String qzone;
            private String qq;

            public String getSweibo() {
                return sweibo;
            }

            public void setSweibo(String sweibo) {
                this.sweibo = sweibo;
            }

            public String getWeixin() {
                return weixin;
            }

            public void setWeixin(String weixin) {
                this.weixin = weixin;
            }

            public String getQzone() {
                return qzone;
            }

            public void setQzone(String qzone) {
                this.qzone = qzone;
            }

            public String getQq() {
                return qq;
            }

            public void setQq(String qq) {
                this.qq = qq;
            }
        }
    }
}
