package licancan.com.comicdemo.bean;

import java.util.List;

/**
 * Created by robot on 2017/8/18.
 */

public class Book {


    public String reason;
    public Result result;

    public class Result{
        public List<BookList> bookList;
        public String limit;
        public class BookList{
            public String name;
            public String area;
            public String coverImg;

        }
    }
}
