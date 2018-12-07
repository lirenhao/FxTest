package sample.model;

public class GpBuy {

    private String id;
    private String huiyuan_pass_two;
    private String shuliang;
    private String zhekou;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHuiyuan_pass_two() {
        return huiyuan_pass_two;
    }

    public void setHuiyuan_pass_two(String huiyuan_pass_two) {
        this.huiyuan_pass_two = huiyuan_pass_two;
    }

    public String getShuliang() {
        return shuliang;
    }

    public void setShuliang(String shuliang) {
        this.shuliang = shuliang;
    }

    public String getZhekou() {
        return zhekou;
    }

    public void setZhekou(String zhekou) {
        this.zhekou = zhekou;
    }

    @Override
    public String toString() {
        return "id=" + id + '&' +
                "huiyuan_pass_two=" + huiyuan_pass_two + '&' +
                "shuliang=" + shuliang + '&' +
                "zhekou=" + zhekou;
    }
}
