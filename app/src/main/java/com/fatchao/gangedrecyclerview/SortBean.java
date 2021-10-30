package com.fatchao.gangedrecyclerview;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class SortBean implements Parcelable  {
    private String name;
    private String tag;
    private boolean isTitle;
    private String imgsrc;

    private String titleName;


    public static final Creator<SortBean> CREATOR = new Creator<SortBean>() {
        @Override
        public SortBean createFromParcel(Parcel in) {
            return new SortBean(in);
        }

        @Override
        public SortBean[] newArray(int size) {
            return new SortBean[size];
        }
    };

    public String getTitle() {
        return title;
    }
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    private String title;



    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }


    public SortBean(String name) {
        this.name = name;
    }

    private ArrayList<CategoryOneArrayBean> categoryOneArray;

    protected SortBean(Parcel in) {
        name = in.readString();
        tag = in.readString();
        isTitle = in.readByte() != 0;
    }


    public ArrayList<CategoryOneArrayBean> getCategoryOneArray() {
        return categoryOneArray;
    }

    public void setCategoryOneArray(ArrayList<CategoryOneArrayBean> categoryOneArray) {
        this.categoryOneArray = categoryOneArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(tag);
        dest.writeByte((byte) (isTitle ? 1 : 0));
        dest.writeString(imgsrc);
        dest.writeString(titleName);
        dest.writeString(title);
        dest.writeTypedList(categoryOneArray);
    }


    public static class CategoryOneArrayBean implements Parcelable {
        /**
         * categoryTwoArray : [{"name":"处方药(RX)","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_chufangyao.png","cacode":"chufangyao"},{"name":"非处方(OTC)","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_feichufang.png","cacode":"feichufang"},{"name":"抗生素","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_kangshengsu.png","cacode":"kangshengsu"}]
         * name : 通俗分类
         * imgsrc : https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_0.png
         * cacode : tongsufenlei
         */

        private String name;
        private String imgsrc;
        private String cacode;
        private List<CategoryTwoArrayBean> categoryTwoArray;

        protected CategoryOneArrayBean(Parcel in) {
            name = in.readString();
            imgsrc = in.readString();
            cacode = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(imgsrc);
            dest.writeString(cacode);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<CategoryOneArrayBean> CREATOR = new Creator<CategoryOneArrayBean>() {
            @Override
            public CategoryOneArrayBean createFromParcel(Parcel in) {
                return new CategoryOneArrayBean(in);
            }

            @Override
            public CategoryOneArrayBean[] newArray(int size) {
                return new CategoryOneArrayBean[size];
            }
        };

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getCacode() {
            return cacode;
        }

        public void setCacode(String cacode) {
            this.cacode = cacode;
        }

        public List<CategoryTwoArrayBean> getCategoryTwoArray() {
            return categoryTwoArray;
        }

        public void setCategoryTwoArray(List<CategoryTwoArrayBean> categoryTwoArray) {
            this.categoryTwoArray = categoryTwoArray;
        }

        public static class CategoryTwoArrayBean implements Parcelable {
            /**
             * name : 处方药(RX)
             * imgsrc : https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_chufangyao.png
             * cacode : chufangyao
             */

            private String name;
            private String imgsrc;
            private String cacode;

            protected CategoryTwoArrayBean(Parcel in) {
                name = in.readString();
                imgsrc = in.readString();
                cacode = in.readString();
            }

            public static final Creator<CategoryTwoArrayBean> CREATOR = new Creator<CategoryTwoArrayBean>() {
                @Override
                public CategoryTwoArrayBean createFromParcel(Parcel in) {
                    return new CategoryTwoArrayBean(in);
                }

                @Override
                public CategoryTwoArrayBean[] newArray(int size) {
                    return new CategoryTwoArrayBean[size];
                }
            };

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getCacode() {
                return cacode;
            }

            public void setCacode(String cacode) {
                this.cacode = cacode;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(name);
                dest.writeString(imgsrc);
                dest.writeString(cacode);
            }
        }
    }


}
