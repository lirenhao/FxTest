package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.model.GpBuy;
import sample.model.GpSell;

import java.util.Map;

public class Controller {

    private Service service = new Service();

    @FXML
    private TextField host;
    @FXML
    private TextField gpId;
    @FXML
    private TextField id;
    @FXML
    private TextField pwd;
    @FXML
    private TextField zkId;
    @FXML
    private TextField zkNum;
    @FXML
    private TextField buy;
    @FXML
    private TextField sell;
    @FXML
    private TextField sleep;
    @FXML
    private TextField time;
    @FXML
    private TextArea logs;
    @FXML
    private Button start;

    @FXML
    public void onStartClick() {
        GpBuy gpBuy = new GpBuy();
        gpBuy.setId(gpId.getText());
        gpBuy.setHuiyuan_pass_two(pwd.getText());
        gpBuy.setZhekou(zkId.getText());
        gpBuy.setShuliang(zkNum.getText());

        GpSell gpSell = new GpSell();
        gpSell.setZhekou(zkId.getText());
        gpSell.setSell_zhekou("");
        gpSell.setSell_zhekoua("");
        gpSell.setSell_num(zkNum.getText());
        gpSell.setPass_two(pwd.getText());
        gpSell.setGp_id(gpId.getText());
        gpSell.setJiage("");

        String hostName = host.getText();
        String huiyuanId = id.getText();
        String sleepTime = sleep.getText();
        String timeout = time.getText();

        logs.appendText("--------------------秒杀开始--------------------" + System.lineSeparator());
        service.start(logs, hostName, huiyuanId, gpBuy, gpSell, sleepTime, Integer.parseInt(timeout));
        start.setDisable(true);
    }

    @FXML
    public void onStopClick() {
        service.close();
        start.setDisable(false);
        logs.appendText("--------------------秒杀停止--------------------" + System.lineSeparator());
    }

    @FXML
    public void onClearClick() {
        logs.setText("");
    }
}
