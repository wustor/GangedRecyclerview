package com.feiyu.rv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SortBean implements Serializable {

  private String name;
  private String tag;
  private boolean isTitle;

  private String titleName;


  private String title;


  public SortBean(String name) {
    this.name = name;
  }

  private ArrayList<CategoryOneArrayBean> categoryOneArray;


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


  public static class CategoryOneArrayBean implements Serializable {

    /**
     * categoryTwoArray : [{"name":"处方药(RX)","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_chufangyao.png","cacode":"chufangyao"},{"name":"非处方(OTC)","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_feichufang.png","cacode":"feichufang"},{"name":"抗生素","imgsrc":"https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_kangshengsu.png","cacode":"kangshengsu"}]
     * name : 通俗分类 imgsrc : https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_0.png
     * cacode : tongsufenlei
     */

    private String name;
    private List<CategoryTwoArrayBean> categoryTwoArray;



    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }


    public List<CategoryTwoArrayBean> getCategoryTwoArray() {
      return categoryTwoArray;
    }

    public void setCategoryTwoArray(List<CategoryTwoArrayBean> categoryTwoArray) {
      this.categoryTwoArray = categoryTwoArray;
    }

    public static class CategoryTwoArrayBean implements Serializable {

      /**
       * name : 处方药(RX) imgsrc : https://121.10.217.171:9002/_ui/desktop/common/cmyy/image/app_tongsufenlei_chufangyao.png
       * cacode : chufangyao
       */

      private String name;



      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }


    }
  }


}
