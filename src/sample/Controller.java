package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private Service service = new Service();

    @FXML
    private TextField id;
    @FXML
    private TextField pwd;
    @FXML
    private Button start;
    @FXML
    private TextField one;
    @FXML
    private TextField two;
    @FXML
    private TextField three;
    @FXML
    private TextField four;
    @FXML
    private TextField five;
    @FXML
    private TextField sleep;
    @FXML
    private TextField gpId;
    @FXML
    private TextArea gps;
    @FXML
    private TextArea logs;

    @FXML
    public void onCheck(ActionEvent event) {
    }

    @FXML
    public void onGetGpsClick() {
        String huiyuanId = id.getText();
        gpId.setText(service.getGps(gps, huiyuanId));
    }

    @FXML
    public void onStartClick() {
        String huiyuanId = id.getText();
        String huiyuanPassTwo = pwd.getText();
        Map<String, String> cbs = getCbs(one, two, three, four, five);
        String sleepTime = sleep.getText();
        logs.appendText("--------------------秒杀开始--------------------" + System.lineSeparator());
        logs.appendText(String.format("秒杀的折扣数量参数是%s", cbs.toString()) + System.lineSeparator());
        service.start(logs, huiyuanId, huiyuanPassTwo, cbs, sleepTime);
        start.setDisable(true);
    }

    private Map<String, String> getCbs(TextField... array) {
        Map<String, String> cbs = new HashMap<>();
        for(TextField v: array) {
            if (!"".equals(v.getText())) {
                cbs.put(v.getId(), v.getText());
            }
        }
        return cbs;
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
