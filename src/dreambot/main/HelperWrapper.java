package dreambot.main;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.Arrays.asList;

public class HelperWrapper {
    private ArrayList<Helper> helpers = new ArrayList<>(asList(

    ));

    public <Library> Library getLibrary(Class<? extends Library> lib) {
        Optional<Object> c;
        return (c = Optional.of(helpers.stream().filter(x -> ((Helper) x).getName().equals(lib)).findFirst())).isPresent() ? lib.cast(((Helper) c.get()).getLib()) : null;
    }

    public HelperWrapper addLibrary(Helper h) {
        helpers.add(h);
        return this;
    }
}
