package cn.knet.vo;

import cn.knet.domain.entity.KnetOfficialGroup;

/**
 * @author dcx
 * @create 2019-11-26 9:36
 */
public class KnetOffcialNewsGroupVo extends KnetOfficialGroup {

    //文章数量
    private int newstotal;

    public int getNewstotal() {
        return newstotal;
    }

    public void setNewstotal(int newstotal) {
        this.newstotal = newstotal;
    }
}




