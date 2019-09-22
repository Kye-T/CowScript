package dreambot.main;

import dreambot.data.Configuration;
import dreambot.libs.Cooking;
import dreambot.libs.Fighting;
import dreambot.libs.Walker;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

/**
 * Copyright (C) <2019>  <Kye-T>
 * See dtohh.main.Main for GNU license.
 */

public abstract class Provider extends AbstractScript {
    private Loader provider;
    private Configuration c;

    public Configuration getConfiguration() {
        return c;
    }

    private HelperWrapper helper      = new HelperWrapper();
    private ScriptPosition position   = ScriptPosition.WAITING;

    public void setProvider(Loader provider) {
        this.provider = provider;
        c = provider.getConfiguration();
        init();
    }

    private void init() {
        /* Add all of the helpers */
        helper.addLibrary(new Helper<>(getProvider().getLibInstance(Walker.class)));
        helper.addLibrary(new Helper<>(getProvider().getLibInstance(Fighting.class)));
        helper.addLibrary(new Helper<>(getProvider().getLibInstance(Cooking.class)));
    }

    public HelperWrapper getHelper() {
        return helper;
    }

    /**
     * Returns the current scripts position
     * @return ScriptPosition
     */

    public ScriptPosition getPosition() {
        return position;
    }

    /**
     * Sets the current position of the Main
     * @param p
     */

    public void setScriptPosition(ScriptPosition p) {
        position = p;
    }

    /**
     * Allows the dependency libs to access the instance
     * @return Main
     */

    public Provider getInstance() {
        return this;
    }

    /**
     * Retrieves the provider for the Main to access instanced dependencies
     * @return Loader
     */

    public Loader getProvider() {
        return provider;
    }
}