package io.github.dhairyagrid.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreeterTest {

    @Test
    void greetsByName() {
        assertEquals("Hello, Ada!", Greeter.greet(" Ada "));
    }

    @Test
    void greetsTheWorldWhenNameIsMissing() {
        assertEquals("Hello, world!", Greeter.greet(null));
        assertEquals("Hello, world!", Greeter.greet("  "));
    }
}
