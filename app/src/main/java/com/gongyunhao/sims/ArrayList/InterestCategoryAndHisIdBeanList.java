package com.gongyunhao.sims.ArrayList;

import com.gongyunhao.sims.Bean.InterestCategoryAndHisIdBean;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;

/**
 * _oo0oo_
 * 08888888o
 * 88" . "88
 * (| -_- |)
 * 0\  =  /0
 * <p>
 * 佛祖保佑代码无bug
 * <p>
 * <p>
 * Created by yuanlai on 2018/3/20.
 */

public class InterestCategoryAndHisIdBeanList {

    InterestCategoryAndHisIdBean head = null;

    public void addInterestCategoryAndHisIdBean(String interestCategoryName,int interestCategoryId){

        InterestCategoryAndHisIdBean interestCategoryAndHisIdBean = new InterestCategoryAndHisIdBean(interestCategoryName,interestCategoryId);


        if (head == null) {
            head = interestCategoryAndHisIdBean;
            return;
        }

        InterestCategoryAndHisIdBean temp = head;

        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next = interestCategoryAndHisIdBean;



    }

}
