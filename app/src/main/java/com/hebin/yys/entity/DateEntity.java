package com.hebin.yys.entity;


import java.util.List;

public class DateEntity {

    /**
     * results : [{"name":"name","info":"info"}]
     */

    private List<ResultsEntity> results;

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        /**
         * name : name
         * info : info
         */

        private String name;
        private String info;
        private int img;
        /**
         * link : link
         */

        private String link;


        public void setName(String name) {
            this.name = name;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public String getInfo() {
            return info;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public int getImg() {
            return img;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLink() {
            return link;
        }
    }
}
