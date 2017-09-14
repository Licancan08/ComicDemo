package licancan.com.comicdemo.bean;

import java.util.List;

/**
 * Created by robot on 2017/8/21.
 */

public class Img {

    /**
     * error_code : 200
     * reason : 请求成功！
     * result : {"comicName":"灵神考试","chapterId":227898,"imageList":[{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/0-MjI3ODk4MA==.jpg","id":1},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/1-MjI3ODk4MQ==.jpg","id":2},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/2-MjI3ODk4Mg==.jpg","id":3},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/3-MjI3ODk4Mw==.jpg","id":4},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/4-MjI3ODk4NA==.jpg","id":5},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/5-MjI3ODk4NQ==.jpg","id":6},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/6-MjI3ODk4Ng==.jpg","id":7},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/7-MjI3ODk4Nw==.jpg","id":8},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/8-MjI3ODk4OA==.jpg","id":9},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/9-MjI3ODk4OQ==.jpg","id":10},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/10-MjI3ODk4MTA=.jpg","id":11},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/11-MjI3ODk4MTE=.jpg","id":12},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/12-MjI3ODk4MTI=.jpg","id":13},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/13-MjI3ODk4MTM=.jpg","id":14},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/14-MjI3ODk4MTQ=.jpg","id":15},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/15-MjI3ODk4MTU=.jpg","id":16},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/16-MjI3ODk4MTY=.jpg","id":17},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/17-MjI3ODk4MTc=.jpg","id":18},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/18-MjI3ODk4MTg=.jpg","id":19},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/19-MjI3ODk4MTk=.jpg","id":20},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/20-MjI3ODk4MjA=.jpg","id":21},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/21-MjI3ODk4MjE=.jpg","id":22},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/22-MjI3ODk4MjI=.jpg","id":23},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/23-MjI3ODk4MjM=.jpg","id":24},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/24-MjI3ODk4MjQ=.jpg","id":25}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * comicName : 灵神考试
         * chapterId : 227898
         * imageList : [{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/0-MjI3ODk4MA==.jpg","id":1},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/1-MjI3ODk4MQ==.jpg","id":2},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/2-MjI3ODk4Mg==.jpg","id":3},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/3-MjI3ODk4Mw==.jpg","id":4},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/4-MjI3ODk4NA==.jpg","id":5},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/5-MjI3ODk4NQ==.jpg","id":6},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/6-MjI3ODk4Ng==.jpg","id":7},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/7-MjI3ODk4Nw==.jpg","id":8},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/8-MjI3ODk4OA==.jpg","id":9},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/9-MjI3ODk4OQ==.jpg","id":10},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/10-MjI3ODk4MTA=.jpg","id":11},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/11-MjI3ODk4MTE=.jpg","id":12},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/12-MjI3ODk4MTI=.jpg","id":13},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/13-MjI3ODk4MTM=.jpg","id":14},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/14-MjI3ODk4MTQ=.jpg","id":15},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/15-MjI3ODk4MTU=.jpg","id":16},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/16-MjI3ODk4MTY=.jpg","id":17},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/17-MjI3ODk4MTc=.jpg","id":18},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/18-MjI3ODk4MTg=.jpg","id":19},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/19-MjI3ODk4MTk=.jpg","id":20},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/20-MjI3ODk4MjA=.jpg","id":21},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/21-MjI3ODk4MjE=.jpg","id":22},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/22-MjI3ODk4MjI=.jpg","id":23},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/23-MjI3ODk4MjM=.jpg","id":24},{"imageUrl":"http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/24-MjI3ODk4MjQ=.jpg","id":25}]
         */

        private String comicName;
        private int chapterId;
        private List<ImageListBean> imageList;

        public String getComicName() {
            return comicName;
        }

        public void setComicName(String comicName) {
            this.comicName = comicName;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public List<ImageListBean> getImageList() {
            return imageList;
        }

        public void setImageList(List<ImageListBean> imageList) {
            this.imageList = imageList;
        }

        public static class ImageListBean {
            /**
             * imageUrl : http://imgs.juheapi.com/comic_xin/wenJ8b%2B8ytQ=/227898/0-MjI3ODk4MA==.jpg
             * id : 1
             */

            private String imageUrl;
            private int id;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}

