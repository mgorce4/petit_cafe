package cafetoeil.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cafetoeil.model.cafedebase.Colombia;
import cafetoeil.model.cafedebase.Deca;
import cafetoeil.model.cafedebase.Espresso;
import cafetoeil.model.supplement.Caramel;
import cafetoeil.model.supplement.Chantilly;
import cafetoeil.model.supplement.Chocolat;

class BoissonTest {

    @Test
    void testColombiaDescription() {
        Boisson boisson = new Colombia();
        assertEquals("Pur Colombia", boisson.description());
    }

    @Test
    void testColombiaPrix() {
        Boisson boisson = new Colombia();
        assertEquals(0.89, boisson.prix());
    }

    @Test
    void testEspressoDescription() {
        Boisson boisson = new Espresso();
        assertEquals("Espresso", boisson.description());
    }

    @Test
    void testEspressoPrix() {
        Boisson boisson = new Espresso();
        assertEquals(1.99, boisson.prix());
    }

    @Test
    void testDecaDescription() {
        Boisson boisson = new Deca();
        assertEquals("Café déca", boisson.description());
    }

    @Test
    void testDecaPrix() {
        Boisson boisson = new Deca();
        assertEquals(1.05, boisson.prix());
    }

    @Test
    void testCaramelDescription() {
        Boisson boisson = new Colombia(); // Base boisson
        boisson = new Caramel(boisson);
        assertEquals("Pur Colombia, Caramel", boisson.description());
    }

    @Test
    void testCaramelPrix() {
        Boisson boisson = new Colombia(); // Base boisson
        boisson = new Caramel(boisson);
        assertEquals(0.89 + 0.15, boisson.prix());
    }

    @Test
    void testChantillyDescription() {
        Boisson boisson = new Espresso(); // Base boisson
        boisson = new Chantilly(boisson);
        assertEquals("Espresso, Chantilly", boisson.description());
    }

    @Test
    void testChantillyPrix() {
        Boisson boisson = new Espresso(); // Base boisson
        boisson = new Chantilly(boisson);
        assertEquals(1.99 + 0.10, boisson.prix());
    }

    @Test
    void testChocolatDescription() {
        Boisson boisson = new Deca(); // Base boisson
        boisson = new Chocolat(boisson);
        assertEquals("Café déca, Chocolat", boisson.description());
    }

    @Test
    void testChocolatPrix() {
        Boisson boisson = new Deca(); // Base boisson
        boisson = new Chocolat(boisson);
        assertEquals(1.05 + 0.20, boisson.prix());
    }

    // Test with multiple decorations
    @Test
    void testMultipleDecorationsDescription() {
        Boisson boisson = new Colombia(); // Base boisson
        boisson = new Chocolat(boisson);
        boisson = new Chantilly(boisson);
        boisson = new Caramel(boisson);
        assertEquals("Pur Colombia, Chocolat, Chantilly, Caramel", boisson.description());
    }

    @Test
    void testMultipleDecorationsPrix() {
        Boisson boisson = new Colombia(); // Base boisson
        boisson = new Chocolat(boisson);
        boisson = new Chantilly(boisson);
        boisson = new Caramel(boisson);
        assertEquals(0.89 + 0.20 + 0.10 + 0.15, boisson.prix());
    }
}