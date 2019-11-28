package cn.knet.vo;

/**
 * @author dcx
 * @create 2019-11-26 9:32
 */
public class ResultBean {
    private boolean flag;
    private String msg;
    private Object context;
    private int code;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
