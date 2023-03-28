package ru.perm.v.animals.java8;

@FunctionalInterface
interface FunctionalInterfaceSimple<F, T> {
    T convertFromTo(F from);
}
