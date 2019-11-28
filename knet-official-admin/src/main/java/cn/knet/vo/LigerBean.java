package cn.knet.vo;

import java.util.List;

/**
 * @author dcx
 * @create 2019-11-26 9:18
 */
public class LigerBean {
    int total;
    List<?> rows;

    public LigerBean(int Total, List<?> Rows) {
        this.rows = Rows;
        this.total = Total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }


}
