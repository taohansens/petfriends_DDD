package com.taohansen.petfriends_pedido.domain.commandEvent;

import lombok.Getter;

@Getter
public abstract class BaseEvent<T> {
    private final T id;

    protected BaseEvent(T id) {
        this.id = id;
    }

}