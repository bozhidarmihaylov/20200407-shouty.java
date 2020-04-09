package shouty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("cucumber-glue")
public class ShoutyHelper {
    private final Shouty shouty = new Shouty();

    public void setLocation(String person, Coordinate location) {
        shouty.setLocation(person, location);
    }

    public void shout(String shouter, String shout) {
        shouty.shout(shouter, shout);
    }

    public Map<String, List<String>> getShoutsHeardBy(String listener) {
        return shouty.getShoutsHeardBy(listener);
    }
}
