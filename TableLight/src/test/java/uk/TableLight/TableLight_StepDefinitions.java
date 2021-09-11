
package uk.TableLight;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Time;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class TableLight_StepDefinitions {
    private TableLight light = new TableLight();
    private TimeMachine timeMachine=new TimeMachine();

    @Given("the table light is plugged in")
    public void the_table_light_is_plugged_in() {
        light.isPluggedIn(true);
    }


    @When("the user flicks the switch to the on position")
    public void the_user_flicks_the_switch_to_the_on_position() throws InterruptedException {
        light.flickSwitchPosition(SwitchPosition.ON);
    }

    @Then("the light will be on")
    public void the_light_will_be_on() {
        Assert.assertEquals(light.getTableLightState(),Light.ON);
    }


    @And("30 seconds have passed")
    public void minutesHavePassed() throws InterruptedException {
        timeMachine.setClockForTesting();
        timeMachine.forward(25,light);

    }

    @Then("the light will be off")
    public void theLightWillBeOff() {
        Assert.assertEquals(light.getTableLightState(),Light.OFF);
    }

    @And("the switch flicks back to the off position")
    public void theSwitchFlicksBackToTheOffPosition() {
        Assert.assertEquals(light.getSwitchPosition(),SwitchPosition.OFF);
    }
}
