package shouty;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationSteps {
    @Autowired
    private ShoutyHelper shoultyHelper;

    @Given("{word} is at {int}, {int}")
    public void user_is_at(String person, int xCoord, int yCoord) {
        shoultyHelper.setLocation(person, new Coordinate(xCoord, yCoord));
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> personLocationList) {
        for (PersonLocation personLocation: personLocationList) {
            shoultyHelper.setLocation(personLocation.getName(), new Coordinate(personLocation.getX(), personLocation.getY()));
        }
    }
}
