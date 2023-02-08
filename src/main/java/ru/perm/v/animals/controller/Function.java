package ru.perm.v.animals.controller;

public interface Function<F,T> {
    T apply(F from);
}
