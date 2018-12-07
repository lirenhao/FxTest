package sample.model;

public class GpSell {

    private String zhekou;
    private String sell_zhekou;
    private String sell_zhekoua;
    private String sell_num;
    private String pass_two;
    private String gp_id;
    private String jiage;

    public String getZhekou() {
        return zhekou;
    }

    public void setZhekou(String zhekou) {
        this.zhekou = zhekou;
    }

    public String getSell_zhekou() {
        return sell_zhekou;
    }

    public void setSell_zhekou(String sell_zhekou) {
        this.sell_zhekou = sell_zhekou;
    }

    public String getSell_zhekoua() {
        return sell_zhekoua;
    }

    public void setSell_zhekoua(String sell_zhekoua) {
        this.sell_zhekoua = sell_zhekoua;
    }

    public String getSell_num() {
        return sell_num;
    }

    public void setSell_num(String sell_num) {
        this.sell_num = sell_num;
    }

    public String getPass_two() {
        return pass_two;
    }

    public void setPass_two(String pass_two) {
        this.pass_two = pass_two;
    }

    public String getGp_id() {
        return gp_id;
    }

    public void setGp_id(String gp_id) {
        this.gp_id = gp_id;
    }

    public String getJiage() {
        return jiage;
    }

    public void setJiage(String jiage) {
        this.jiage = jiage;
    }

    @Override
    public String toString() {
        return "zhekou=" + zhekou + '&' +
                "sell_zhekou=" + sell_zhekou + '&' +
                "sell_zhekoua=" + sell_zhekoua + '&' +
                "sell_num=" + sell_num + '&' +
                "pass_two=" + pass_two + '&' +
                "action=%C8%B7%C8%CF%B3%F6%CA%DB&" +
                "gp_id=" + gp_id + '&' +
                "jiage=" + jiage;
    }
}
