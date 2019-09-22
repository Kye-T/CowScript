package dreambot.main;

import dreambot.data.Configuration;
import dreambot.guis.Welcome;
import dreambot.libs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * Copyright (C) <2019>  <Kye-T>
 * See dtohh.main.Main for GNU license.
 */

public class Loader {
    public static Reference<Main> script;

    public ArrayList<Class<? extends Library>> libs = new ArrayList<>(Arrays.asList(
            Walker.class,
            Fighting.class,
            Cooking.class,
            Banking.class
    ));

    public ArrayList<Library> libInstances = new ArrayList<>();

    private Configuration configuration;

    public Loader(dreambot.main.Reference<Main> mainReference) {
        script = mainReference;

        // Generate the Welcome GUI
        Welcome gui = new Welcome();

        // Waits for the GUI to notify us the user is ready to start
        synchronized (gui) {
            try {
                gui.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        configuration = gui.getConfig();

        // Lets build the libs we want to use in the script
        initLibs();
    }

    public void setConfiguration(Configuration c) {
        configuration = c;
    }

    /**
     * gets the configuration obtained by the welcome GUI
     * @return Configuration
     */

    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Returns the helper wrapper containing all helpers
     * @return HelperWrapper
     */

    /**
     * Returns the Library instance based on the class
     * @param lib
     * @return Library
     */

    public <Library> Library getLibInstance(Class<? extends Library> lib) {
        Optional<Object> library;
        return (library = Arrays.stream(libInstances.toArray()).filter(o -> o.getClass() == lib).findFirst()).isPresent() ? lib.cast(library.get()) : null;
    }

    /**
     * Creates and stores an instance for each script dependency
     */

    private void initLibs() {
        libs.forEach(o -> {
            try {
                // Create a new instance for the GUI, store it in ArrayList
                libInstances.add(o.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
