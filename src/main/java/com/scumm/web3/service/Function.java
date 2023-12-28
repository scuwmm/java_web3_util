package com.scumm.web3.service;

public interface Function<T, R> {
    R run(T t);
}
