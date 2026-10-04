package io.github.dhairyagrid.sample;

/**
 * Builds greetings. Exists only to give the Maven Central sample something to publish.
 */
public final class Greeter {

    private Greeter() {}

    /**
     * Returns a greeting for the given name.
     *
     * @param name who to greet; blank or {@code null} greets the world
     * @return the greeting, for example {@code "Hello, Ada!"}
     */
    public static String greet(String name) {
        String who = name == null || name.trim().isEmpty() ? "world" : name.trim();
        return "Hello, " + who + "!";
    }
}
