package uk.TableLight;


enum SwitchPosition{
    ON,OFF
}
enum Light{
    ON,OFF
}
public class TableLight {
    private Light tableLightOn;
    private boolean pluggedIn=false;
    private TimeMachine timeMachine=new TimeMachine();
    private SwitchPosition switchPosition;

    public void isTableLightOn(Light tableLightOn){
        this.tableLightOn=tableLightOn;
    }
    public void isPluggedIn(boolean pluggedIn){
        this.pluggedIn=pluggedIn;
    }
    public void flickSwitchPosition(SwitchPosition switchPosition) throws InterruptedException {
        this.switchPosition=switchPosition;

    }
    public Light getTableLightState(){
        return tableLightOn;
    }
    public SwitchPosition getSwitchPosition(){
        return switchPosition;
    }
}











