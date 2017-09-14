package licancan.com.comicdemo.bean;

import java.util.List;

/**
 * Created by robot on 2017/8/21.
 */

public class Reader {


    /**
     * error_code : 200
     * reason : 请求成功！
     * result : {"total":535,"comicName":"火影忍者","chapterList":[{"name":"第01卷","id":139833},{"name":"第02卷","id":139834},{"name":"第03卷","id":139836},{"name":"第04卷","id":139837},{"name":"第05卷","id":139839},{"name":"第06卷","id":139840},{"name":"第09卷","id":139844},{"name":"第10卷","id":139846},{"name":"第11卷","id":139847},{"name":"第12卷","id":139848},{"name":"第13卷","id":139850},{"name":"第14卷","id":139851},{"name":"第15卷","id":139852},{"name":"第16卷","id":139854},{"name":"第17卷","id":139855},{"name":"第18卷","id":139857},{"name":"第19卷","id":139858},{"name":"第20卷","id":139859},{"name":"第21卷","id":139861},{"name":"第22卷","id":139862}],"limit":20}
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
         * total : 535
         * comicName : 火影忍者
         * chapterList : [{"name":"第01卷","id":139833},{"name":"第02卷","id":139834},{"name":"第03卷","id":139836},{"name":"第04卷","id":139837},{"name":"第05卷","id":139839},{"name":"第06卷","id":139840},{"name":"第09卷","id":139844},{"name":"第10卷","id":139846},{"name":"第11卷","id":139847},{"name":"第12卷","id":139848},{"name":"第13卷","id":139850},{"name":"第14卷","id":139851},{"name":"第15卷","id":139852},{"name":"第16卷","id":139854},{"name":"第17卷","id":139855},{"name":"第18卷","id":139857},{"name":"第19卷","id":139858},{"name":"第20卷","id":139859},{"name":"第21卷","id":139861},{"name":"第22卷","id":139862}]
         * limit : 20
         */

        private int total;
        private String comicName;
        private int limit;
        private List<ChapterListBean> chapterList;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getComicName() {
            return comicName;
        }

        public void setComicName(String comicName) {
            this.comicName = comicName;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public List<ChapterListBean> getChapterList() {
            return chapterList;
        }

        public void setChapterList(List<ChapterListBean> chapterList) {
            this.chapterList = chapterList;
        }

        public static class ChapterListBean {
            /**
             * name : 第01卷
             * id : 139833
             */

            private String name;
            private int id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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
