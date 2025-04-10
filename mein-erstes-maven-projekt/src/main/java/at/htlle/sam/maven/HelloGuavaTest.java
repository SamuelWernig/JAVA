package at.htlle.sam.maven;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HelloGuavaTest {

    @Test
    public void testSortList() {
        // Erstelle eine neue ArrayList mit Guava
        List<String> names = Lists.newArrayList("Samuel", "Jonas", "Bob", "Michael");

        // Sortiere die Liste
        names.sort(String::compareTo);

        // Erstelle die erwartete sortierte Liste
        List<String> expectedList = Lists.newArrayList("Bob", "Jonas", "Michael", "Samuel");

        // Vergleiche die erwartete und die tatsächliche Liste
        assertEquals("Die Liste wurde nicht korrekt sortiert!", expectedList, names);
    }
}
