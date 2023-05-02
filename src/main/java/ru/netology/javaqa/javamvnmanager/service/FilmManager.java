package ru.netology.javaqa.javamvnmanager.service;

public class FilmManager {
    private String[] movie = new String[0];
    private int limit;

    public FilmManager() {
        this.limit = 5;
    }

    public FilmManager(int limit) {
        this.limit = limit;
    }

    public void add(String film) {

        String[] tmp = new String[movie.length + 1];
        for (int i = 0; i < movie.length; i++) {
            tmp[i] = movie[i];
        }
        tmp[tmp.length - 1] = film;
        this.movie = tmp;
    }

    public String[] findAll() {

        return movie;
    }

    public String[] findLast() {
        int resultLength;
        if (movie.length < limit) {
            resultLength = movie.length;
        } else {
            resultLength = limit;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movie[movie.length - 1 - i];

        }
        return tmp;
    }

    public int getLimit() {
        return limit;
    }

    public int setLimit(int limit) {
        this.limit = limit;
        return limit;
    }
}

