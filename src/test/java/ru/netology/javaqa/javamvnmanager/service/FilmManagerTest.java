package ru.netology.javaqa.javamvnmanager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    @Test
    public void testAddNoFilms() {
        FilmManager manager = new FilmManager();

        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testAddOneFilm() {
        FilmManager manager = new FilmManager();
        manager.add("Film I");

        String[] actual = manager.findAll();
        String[] expected = {"Film I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddFilms() {
        FilmManager manager = new FilmManager();
        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");

        String[] actual = manager.findAll();
        String[] expected = {"Film I", "Film II", "Film III"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLowLimit() {
        FilmManager manager = new FilmManager();
        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");

        String[] actual = manager.findLast();
        String[] expected = {"Film III", "Film II", "Film I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLimit() {
        FilmManager manager = new FilmManager();
        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");
        manager.add("Film V");

        String[] actual = manager.findLast();
        String[] expected = {"Film V", "Film IV", "Film III", "Film II", "Film I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastLimitAboveLimit() {
        FilmManager manager = new FilmManager();
        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");
        manager.add("Film V");
        manager.add("Film VI");

        String[] actual = manager.findLast();
        String[] expected = {"Film VI", "Film V", "Film IV", "Film III", "Film II"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testChangedLimit() {
        FilmManager manager = new FilmManager();

        manager.setLimit(7);

        int expected = 7;
        int actual = manager.getLimit();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindLastBelowChangedLimit() {
        FilmManager manager = new FilmManager(7);

        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");
        manager.add("Film V");
        manager.add("Film VI");

        String[] actual = manager.findLast();
        String[] expected = {"Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastChangedLimit() {
        FilmManager manager = new FilmManager(7);

        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");
        manager.add("Film V");
        manager.add("Film VI");
        manager.add("Film VII");

        String[] actual = manager.findLast();
        String[] expected = {"Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastAboveChangedLimit() {
        FilmManager manager = new FilmManager(7);

        manager.add("Film I");
        manager.add("Film II");
        manager.add("Film III");
        manager.add("Film IV");
        manager.add("Film V");
        manager.add("Film VI");
        manager.add("Film VII");
        manager.add("Film VIII");

        String[] actual = manager.findLast();
        String[] expected = {"Film VIII", "Film VII", "Film VI", "Film V", "Film IV", "Film III", "Film II"};
        Assertions.assertArrayEquals(expected, actual);
    }
}

