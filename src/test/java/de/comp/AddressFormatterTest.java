package de.comp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class AddressFormatterTest {

    private final String inputString;
    private final String expectedString;

    AddressFormatter app;

    @Before
    public void initialize() {
        app = new AddressFormatter();
    }

    public AddressFormatterTest(String inputString, String expectedString) {
        this.inputString = inputString;
        this.expectedString = expectedString;
    }

    @Parameterized.Parameters(name = "Format address \"{0}\"")
    public static Collection addresses() {
        return Arrays.asList(new Object[][] {
                { "Winterallee 3",              "{“Winterallee”, “3”}"},
                { "Musterstrasse 45",           "{“Musterstrasse”, “45”}"},
                { "Blaufeldweg 123B",           "{“Blaufeldweg”, “123B”}"},
                { "Am Bächle 23",               "{“Am Bächle”, “23”}"},
                { "Auf der Vogelwiese 23 b",    "{“Auf der Vogelwiese”, “23 b”}"},
                { "4, rue de la revolution",    "{“rue de la revolution”, “4”}"},
                { "200 Broadway Av",            "{“Broadway Av”, “200”}"},
                { "Calle Aduana, 29",           "{“Calle Aduana”, “29”}"},
                { "Calle 39 No 1540",           "{“Calle 39”, “No 1540”}"}
        });
    }

    @Test
    public void AppTest(){
        assertThat(app.formatAddress(inputString)).isEqualTo(expectedString);
    }
}