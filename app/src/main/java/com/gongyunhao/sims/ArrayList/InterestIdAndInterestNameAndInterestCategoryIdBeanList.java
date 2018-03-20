package com.gongyunhao.sims.ArrayList;

import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.Bean.StudentAndInterestBean;

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

public class InterestIdAndInterestNameAndInterestCategoryIdBeanList {

    InterestIdAndInterestNameAndInterestCategoryIdBean head = null;

    public void addInterestIdAndInterestNameAndInterestCategoryIdBean(int interestId, String interestName, int interestCategoryId){

        InterestIdAndInterestNameAndInterestCategoryIdBean interestIdAndInterestNameAndInterestCategoryIdBean = new InterestIdAndInterestNameAndInterestCategoryIdBean(interestId,interestName,interestCategoryId);

        if (head == null) {
            head = interestIdAndInterestNameAndInterestCategoryIdBean;
            return;
        }

        InterestIdAndInterestNameAndInterestCategoryIdBean temp = head;

        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next = interestIdAndInterestNameAndInterestCategoryIdBean;


    }

}
