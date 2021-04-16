package com.lonelydutchhound.adoptation.web.services;

public interface ResponseService<T,E> {
    T getResponseBody(E entity);
}
