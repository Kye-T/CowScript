package dreambot.libs;

import dreambot.main.Loader;
import dreambot.main.Main;

/**
 * Copyright (C) <2019>  <Kye-T>
 * See dtohh.main.Main for GNU license.
 */

abstract public class Library {

    protected Main getProvider() {
        return Loader.script.get();
    }

}
