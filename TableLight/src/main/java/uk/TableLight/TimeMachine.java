package uk.TableLight;

import java.time.*;

public class TimeMachine {
    private static Clock clock = Clock.fixed(Instant.ofEpochMilli(0),ZoneId.systemDefault());
    private int tick_delay=1000;

    private LocalTime myClock=now();
    public LocalTime now() {
        return LocalTime.now(getClock());
    }
    public void setClockForTesting(){
        tick_delay=0;
    }


    public void tick() throws InterruptedException {
        myClock=myClock.plusSeconds(1);
        Thread.sleep(tick_delay);
    }
    public void forward(long duration,TableLight light) throws InterruptedException {
        int counter=0;
        while(true){
            if (counter<duration){
                tick();
                counter++;
            }
            if (counter==duration){
                light.isTableLightOn(Light.OFF);
                light.flickSwitchPosition(SwitchPosition.OFF);
                return;
            }
        }
    }

    private Clock getClock() {
        return clock ;
    }

}


