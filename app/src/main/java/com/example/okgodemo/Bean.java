package com.example.okgodemo;

import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Bean {
    /**
     * response : {"13208927286":{"detail":{"area":[{"city":"海口"}],"province":"海南","type":"domestic","operator":"联通"},"location":"海南海口联通"}}
     * responseHeader : {"status":200,"time":1562925032779,"version":"1.1.0"}
     */

    private ResponseBean response;
    private ResponseHeaderBean responseHeader;

    public static Bean objectFromData(String str) {

        return new Gson().fromJson(str, Bean.class);
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public ResponseHeaderBean getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeaderBean responseHeader) {
        this.responseHeader = responseHeader;
    }

    public static class ResponseBean {
        /**
         * 13208927286 : {"detail":{"area":[{"city":"海口"}],"province":"海南","type":"domestic","operator":"联通"},"location":"海南海口联通"}
         */
        @SerializedName("13208927286")
        private _$13208927286Bean _$13208927286;

        public static ResponseBean objectFromData(String str) {

            return new Gson().fromJson(str, ResponseBean.class);
        }

        public   _$13208927286Bean get_$13208927286() {
            return _$13208927286;
        }

        public void set_$13208927286(_$13208927286Bean _$13208927286) {
            this._$13208927286 = _$13208927286;
        }

        public static class _$13208927286Bean {
            /**
             * detail : {"area":[{"city":"海口"}],"province":"海南","type":"domestic","operator":"联通"}
             * location : 海南海口联通
             */

            private DetailBean detail;
            private String location;

            public static _$13208927286Bean objectFromData(String str) {

                return new Gson().fromJson(str, _$13208927286Bean.class);
            }

            public DetailBean getDetail() {
                return detail;
            }

            public void setDetail(DetailBean detail) {
                this.detail = detail;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public static class DetailBean {
                /**
                 * area : [{"city":"海口"}]
                 * province : 海南
                 * type : domestic
                 * operator : 联通
                 */

                private String province;
                private String type;
                private String operator;
                private List<AreaBean> area;

                public static DetailBean objectFromData(String str) {

                    return new Gson().fromJson(str, DetailBean.class);
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getOperator() {
                    return operator;
                }

                public void setOperator(String operator) {
                    this.operator = operator;
                }

                public List<AreaBean> getArea() {
                    return area;
                }

                public void setArea(List<AreaBean> area) {
                    this.area = area;
                }

                public static class AreaBean {
                    /**
                     * city : 海口
                     */

                    private String city;

                    public static AreaBean objectFromData(String str) {

                        return new Gson().fromJson(str, AreaBean.class);
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }
                }
            }
        }
    }

    public static class ResponseHeaderBean {
        /**
         * status : 200
         * time : 1562925032779
         * version : 1.1.0
         */

        private int status;
        private long time;
        private String version;

        public static ResponseHeaderBean objectFromData(String str) {

            return new Gson().fromJson(str, ResponseHeaderBean.class);
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
