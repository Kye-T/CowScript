package dreambot.libs;

import dreambot.main.Loader;
import dreambot.main.Provider;

/**
 * Copyright (C) <2019>  <Kye-T>
 * See dtohh.main.Main for GNU license.
 */

abstract public class Library {

    protected Provider getProvider() {
        return Loader.script;
    }

}
