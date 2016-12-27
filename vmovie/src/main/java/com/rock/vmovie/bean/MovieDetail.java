package com.rock.vmovie.bean;

import java.util.List;

/**
 * Created by Rock on 2016/12/27.
 */

public class MovieDetail {


    /**
     * status : 0
     * msg : ok
     * data : {"postid":"50772","title":"GoPro激燃年度混剪《2016环球大赏》","is_collect":0,"content":"看了这支GoPro年度混剪，范范觉得BGM很重要！之前GoPro新品Hero 5推出的时候，那支《出逃大自然》选用的是Jai Wolf的Indian Summer，整体风格有种让人放飞自我的冲动。这次的年终盘点，BGM选择了Morillo的Polar Bear。从激荡空灵的Jai Wolf变成动感急促的Morillo，范范有点飞不起来了。\n回顾这一年，GoPro还是带给了大家很多值得铭记的瞬间。比如潜水专家Ocean Ramsey大秀身材的《与鲸鲨共舞》，创意十足的《一只手的旅行》还有一镜到底创意佳作《街头行走》等等。\n而截至今年，GoPro的历史已经经历了十多年的时间。回溯过去，这种便携式相机的想法是2002年由美国人尼克·伍德曼在澳洲冲浪的时候，一拍脑袋冒出来的。看来为运动带来无限精彩的小相机，的确有着一颗放飞自我拥抱自然的心啊！\n2017，我要放飞自我！！","image":"http://cs.vmoiver.com/Uploads/cover/2016-12-27/5861ca17c5439_cut.jpeg","duration":"228","rating":"7.4","publish_time":"1482768240","cate":["混剪"],"video_link":"http://v.youku.com/v_show/id_XMTg4NDIzMjEyNA==.html","vmovier_url":"http://www.vmovier.com/50772?app_inner=1&_vfrom=android_app_to_web","share_link":{"sweibo":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","tweibo":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","renren":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","weixin":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","qzone":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","qq":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1"},"download_link":{"mp4":["http://7rflo2.com2.z0.glb.qiniucdn.com/5860d831be68d.mp4"]},"play_link":{"mp4":["http://7rflo2.com2.z0.glb.qiniucdn.com/5860d831be68d.mp4"]},"mult":1,"is_xpc":0,"is_xpc_zp":0,"is_xpc_cp":0,"is_xpc_fx":0,"is_promote":0,"recent_hot":0,"discussion":0,"editor":{"username":"范范蒙太奇"}}
     */

    private int status;
    private String msg;
    private MovieDetailBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MovieDetailBean getData() {
        return data;
    }

    public void setData(MovieDetailBean data) {
        this.data = data;
    }

    public static class MovieDetailBean {
        /**
         * postid : 50772
         * title : GoPro激燃年度混剪《2016环球大赏》
         * is_collect : 0
         * content : 看了这支GoPro年度混剪，范范觉得BGM很重要！之前GoPro新品Hero 5推出的时候，那支《出逃大自然》选用的是Jai Wolf的Indian Summer，整体风格有种让人放飞自我的冲动。这次的年终盘点，BGM选择了Morillo的Polar Bear。从激荡空灵的Jai Wolf变成动感急促的Morillo，范范有点飞不起来了。
         * 回顾这一年，GoPro还是带给了大家很多值得铭记的瞬间。比如潜水专家Ocean Ramsey大秀身材的《与鲸鲨共舞》，创意十足的《一只手的旅行》还有一镜到底创意佳作《街头行走》等等。
         * 而截至今年，GoPro的历史已经经历了十多年的时间。回溯过去，这种便携式相机的想法是2002年由美国人尼克·伍德曼在澳洲冲浪的时候，一拍脑袋冒出来的。看来为运动带来无限精彩的小相机，的确有着一颗放飞自我拥抱自然的心啊！
         * 2017，我要放飞自我！！
         * image : http://cs.vmoiver.com/Uploads/cover/2016-12-27/5861ca17c5439_cut.jpeg
         * duration : 228
         * rating : 7.4
         * publish_time : 1482768240
         * cate : ["混剪"]
         * video_link : http://v.youku.com/v_show/id_XMTg4NDIzMjEyNA==.html
         * vmovier_url : http://www.vmovier.com/50772?app_inner=1&_vfrom=android_app_to_web
         * share_link : {"sweibo":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","tweibo":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","renren":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","weixin":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","qzone":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1","qq":"http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1"}
         * download_link : {"mp4":["http://7rflo2.com2.z0.glb.qiniucdn.com/5860d831be68d.mp4"]}
         * play_link : {"mp4":["http://7rflo2.com2.z0.glb.qiniucdn.com/5860d831be68d.mp4"]}
         * mult : 1
         * is_xpc : 0
         * is_xpc_zp : 0
         * is_xpc_cp : 0
         * is_xpc_fx : 0
         * is_promote : 0
         * recent_hot : 0
         * discussion : 0
         * editor : {"username":"范范蒙太奇"}
         */

        private String postid;
        private String title;
        private int is_collect;
        private String content;
        private String image;
        private String duration;
        private String rating;
        private String publish_time;
        private String video_link;
        private String vmovier_url;
        private ShareLinkBean share_link;
        private DownloadLinkBean download_link;
        private PlayLinkBean play_link;
        private int mult;
        private int is_xpc;
        private int is_xpc_zp;
        private int is_xpc_cp;
        private int is_xpc_fx;
        private int is_promote;
        private int recent_hot;
        private int discussion;
        private EditorBean editor;
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

        public int getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
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

        public String getVideo_link() {
            return video_link;
        }

        public void setVideo_link(String video_link) {
            this.video_link = video_link;
        }

        public String getVmovier_url() {
            return vmovier_url;
        }

        public void setVmovier_url(String vmovier_url) {
            this.vmovier_url = vmovier_url;
        }

        public ShareLinkBean getShare_link() {
            return share_link;
        }

        public void setShare_link(ShareLinkBean share_link) {
            this.share_link = share_link;
        }

        public DownloadLinkBean getDownload_link() {
            return download_link;
        }

        public void setDownload_link(DownloadLinkBean download_link) {
            this.download_link = download_link;
        }

        public PlayLinkBean getPlay_link() {
            return play_link;
        }

        public void setPlay_link(PlayLinkBean play_link) {
            this.play_link = play_link;
        }

        public int getMult() {
            return mult;
        }

        public void setMult(int mult) {
            this.mult = mult;
        }

        public int getIs_xpc() {
            return is_xpc;
        }

        public void setIs_xpc(int is_xpc) {
            this.is_xpc = is_xpc;
        }

        public int getIs_xpc_zp() {
            return is_xpc_zp;
        }

        public void setIs_xpc_zp(int is_xpc_zp) {
            this.is_xpc_zp = is_xpc_zp;
        }

        public int getIs_xpc_cp() {
            return is_xpc_cp;
        }

        public void setIs_xpc_cp(int is_xpc_cp) {
            this.is_xpc_cp = is_xpc_cp;
        }

        public int getIs_xpc_fx() {
            return is_xpc_fx;
        }

        public void setIs_xpc_fx(int is_xpc_fx) {
            this.is_xpc_fx = is_xpc_fx;
        }

        public int getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(int is_promote) {
            this.is_promote = is_promote;
        }

        public int getRecent_hot() {
            return recent_hot;
        }

        public void setRecent_hot(int recent_hot) {
            this.recent_hot = recent_hot;
        }

        public int getDiscussion() {
            return discussion;
        }

        public void setDiscussion(int discussion) {
            this.discussion = discussion;
        }

        public EditorBean getEditor() {
            return editor;
        }

        public void setEditor(EditorBean editor) {
            this.editor = editor;
        }

        public List<String> getCate() {
            return cate;
        }

        public void setCate(List<String> cate) {
            this.cate = cate;
        }

        public static class ShareLinkBean {
            /**
             * sweibo : http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1
             * tweibo : http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1
             * renren : http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1
             * weixin : http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1
             * qzone : http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1
             * qq : http://www.vmovier.com/50772?_vfrom=VmovierApp&debug=1
             */

            private String sweibo;
            private String tweibo;
            private String renren;
            private String weixin;
            private String qzone;
            private String qq;

            public String getSweibo() {
                return sweibo;
            }

            public void setSweibo(String sweibo) {
                this.sweibo = sweibo;
            }

            public String getTweibo() {
                return tweibo;
            }

            public void setTweibo(String tweibo) {
                this.tweibo = tweibo;
            }

            public String getRenren() {
                return renren;
            }

            public void setRenren(String renren) {
                this.renren = renren;
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

        public static class DownloadLinkBean {
            private List<String> mp4;

            public List<String> getMp4() {
                return mp4;
            }

            public void setMp4(List<String> mp4) {
                this.mp4 = mp4;
            }
        }

        public static class PlayLinkBean {
            private List<String> mp4;

            public List<String> getMp4() {
                return mp4;
            }

            public void setMp4(List<String> mp4) {
                this.mp4 = mp4;
            }
        }

        public static class EditorBean {
            /**
             * username : 范范蒙太奇
             */

            private String username;

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
