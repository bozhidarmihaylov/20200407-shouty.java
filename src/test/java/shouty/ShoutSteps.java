package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.*;

public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";

    @Autowired
    private ShoutyHelper shoutyHelper;

    @When("{word} shouts")
    public void person_shouts(String person) {
        shoutyHelper.shout(person, ARBITRARY_MESSAGE);
    }

    @Then("{word} should hear Sean")
    public void listener_should_hear_sean(String listener) {
        assertEquals(1, shoutyHelper.getShoutsHeardBy(listener).size());
    }

    @Then("{word} should hear nothing")
    public void person_should_hear_nothing(String person) {
        assertEquals(emptyMap(), shoutyHelper.getShoutsHeardBy(person));
    }

    @Then("{word} should not hear {word}")
    public void listener_should_hear_shouter(String listener, String shouter) {
        assertFalse(shoutyHelper.getShoutsHeardBy(listener).containsValue(shouter));
    }

    @Then("{word} should hear {int} shouts from {word}")
    public void listenerShouldHearShoutsFromShouter(String listener, Integer shoutCount, String shouter) {
        List<String> shoutsHeardFromShouter = shoutyHelper.getShoutsHeardBy(listener).get(shouter);
        assertEquals(shoutCount.intValue(), shoutsHeardFromShouter.size());
    }
}
