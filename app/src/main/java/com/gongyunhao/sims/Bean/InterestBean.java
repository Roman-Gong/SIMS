package com.gongyunhao.sims.Bean;

//    ┏┓　   ┏┓  
// ┏━━┛┻━━━━━┛┻ ┓ 
// ┃　　　　　　 ┃  
// ┃　　　━　    ┃  
// ┃　＞　　＜　 ┃  
// ┃　　　　　　 ┃  
// ┃... ⌒ ...  ┃  
// ┃　　　　　 　┃  
// ┗━━━┓　　　┏━┛  
//     ┃　　　┃　  
//     ┃　　　┃  
//     ┃　　　┃  神兽保佑  
//     ┃　　　┃  代码无bug　　  
//     ┃　　　┃  
//     ┃　　　┗━━━━━━━━━┓
//     ┃　　　　　　　    ┣┓
//     ┃　　　　         ┏┛
//     ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//       ┃ ┫ ┫   ┃ ┫ ┫
//       ┗━┻━┛   ┗━┻━┛
//
//  作者：棒棒小糖
//  來源：简书
//
//  Creste by GongYunHao on 2018/3/19
// 
public class InterestBean {//该类为可选的兴趣项

    private int TAG=-1;//标识位，与兴趣小项对应

    public int getTAG() {
        return TAG;
    }

    public void setTAG(int TAG) {
        this.TAG = TAG;
    }

    private String interestName;//兴趣类名称,如：球类
    private String[] interestDetailList;//兴趣类中的兴趣项,如：网球，排球，足球......

    public InterestBean(int Tag,String interestName, String[] interestDetailList) {
        this.TAG=Tag;
        this.interestName = interestName;
        this.interestDetailList = interestDetailList;
    }

    public String getInterestName() {

        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public String[] getInterestDetailList() {
        return interestDetailList;
    }

    public void setInterestDetailList(String[] interestDetailList) {
        this.interestDetailList = interestDetailList;
    }
}
