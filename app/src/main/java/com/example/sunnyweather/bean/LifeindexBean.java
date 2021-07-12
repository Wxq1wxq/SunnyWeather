package com.example.sunnyweather.bean;

import com.google.gson.annotations.SerializedName;



public class LifeindexBean {

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private ResultDTO result;
    @SerializedName("error_code")
    private Integer errorCode;

 
    public static class ResultDTO {
        @SerializedName("city")
        private String city;
        @SerializedName("life")
        private LifeDTO life;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LifeDTO getLife() {
            return life;
        }

        public void setLife(LifeDTO life) {
            this.life = life;
        }

        
        
        public static class LifeDTO {
            @SerializedName("kongtiao")
            private KongtiaoDTO kongtiao;
            @SerializedName("guomin")
            private GuominDTO guomin;
            @SerializedName("shushidu")
            private ShushiduDTO shushidu;
            @SerializedName("chuanyi")
            private ChuanyiDTO chuanyi;

            public KongtiaoDTO getKongtiao() {
                return kongtiao;
            }

            public void setKongtiao(KongtiaoDTO kongtiao) {
                this.kongtiao = kongtiao;
            }

            public GuominDTO getGuomin() {
                return guomin;
            }

            public void setGuomin(GuominDTO guomin) {
                this.guomin = guomin;
            }

            public ShushiduDTO getShushidu() {
                return shushidu;
            }

            public void setShushidu(ShushiduDTO shushidu) {
                this.shushidu = shushidu;
            }

            public ChuanyiDTO getChuanyi() {
                return chuanyi;
            }

            public void setChuanyi(ChuanyiDTO chuanyi) {
                this.chuanyi = chuanyi;
            }

            public DiaoyuDTO getDiaoyu() {
                return diaoyu;
            }

            public void setDiaoyu(DiaoyuDTO diaoyu) {
                this.diaoyu = diaoyu;
            }

            public GanmaoDTO getGanmao() {
                return ganmao;
            }

            public void setGanmao(GanmaoDTO ganmao) {
                this.ganmao = ganmao;
            }

            public ZiwaixianDTO getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(ZiwaixianDTO ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public XicheDTO getXiche() {
                return xiche;
            }

            public void setXiche(XicheDTO xiche) {
                this.xiche = xiche;
            }

            public YundongDTO getYundong() {
                return yundong;
            }

            public void setYundong(YundongDTO yundong) {
                this.yundong = yundong;
            }

            public DaisanDTO getDaisan() {
                return daisan;
            }

            public void setDaisan(DaisanDTO daisan) {
                this.daisan = daisan;
            }

            @SerializedName("diaoyu")
            private DiaoyuDTO diaoyu;
            @SerializedName("ganmao")
            private GanmaoDTO ganmao;
            @SerializedName("ziwaixian")
            private ZiwaixianDTO ziwaixian;
            @SerializedName("xiche")
            private XicheDTO xiche;
            @SerializedName("yundong")
            private YundongDTO yundong;
            @SerializedName("daisan")
            private DaisanDTO daisan;

            
            
            public static class KongtiaoDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class GuominDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class ShushiduDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class ChuanyiDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class DiaoyuDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class GanmaoDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class ZiwaixianDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class XicheDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class YundongDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }

            
            
            public static class DaisanDTO {
                @SerializedName("v")
                private String v;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                @SerializedName("des")
                private String des;
            }
        }
    }
}
