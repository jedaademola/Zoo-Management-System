package edu.mum.mpp.util;

@FunctionalInterface
public interface TriFunction<S, T, U, R> {
    R apply(S s, T t, U u);
}


