package dreambot.main;

import java.util.ArrayList;
import java.util.Optional;

import static java.util.Arrays.asList;

public class HelperWrapper {
    private ArrayList<Helper> helpers = new ArrayList<>(asList(

    ));

    public <Library> Library getLibrary(Class<? extends Library> lib) {
        return lib.cast(helpers.stream().filter(x -> x.getClass().equals(lib)).findFirst().get());
    }

    public HelperWrapper addLibrary(Helper h) {
        helpers.add(h);
        return this;
    }
}
