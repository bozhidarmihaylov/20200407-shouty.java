package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.*;

public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("{word} is at {int}, {int}")
    public void user_is_at(String person, int xCoord, int yCoord) {
        shouty.setLocation(person, new Coordinate(xCoord, yCoord));
    }

    @When("{word} shouts")
    public void person_shouts(String person) {
        shouty.shout(person, ARBITRARY_MESSAGE);
    }

    @Then("{word} should hear Sean")
    public void listener_should_hear_sean(String listener) {
        assertEquals(1, shouty.getShoutsHeardBy(listener).size());
    }

    @Then("{word} should hear nothing")
    public void person_should_hear_nothing(String person) {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy(person));
    }

    @Then("{word} should not hear {word}")
    public void listener_should_hear_shouter(String listener, String shouter) {
        assertFalse(shouty.getShoutsHeardBy(listener).containsValue(shouter));
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> personLocationList) {
        for (PersonLocation personLocation: personLocationList) {
            shouty.setLocation(personLocation.getName(), new Coordinate(personLocation.getX(), personLocation.getY()));
        }
    }
}
