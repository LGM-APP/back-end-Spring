package com.lgm.backend.service.favorite;

import java.util.List;

public interface IfavoriteService<T>{

    public List<T> getAll(String token);
    public Integer remove(String token,T elementId);
    public Integer removeAll(String token, List<T> elementsId);
    public T add(String token, T elementId);
    public List<T> addAll(String token, List<T> elementsId);

}
