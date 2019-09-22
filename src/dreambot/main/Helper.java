package dreambot.main;

import dreambot.libs.Library;

public class Helper<T extends Library> {
    private T lib;

    public Helper(Library lib) { this.lib = (T) lib; }

    public Class<T> getName() { return (Class<T>) lib.getClass(); }
    public T getLib() { return lib; }
}