package com.lgm.backend.service.favorite;

import java.util.List;

public interface IfavoriteService<T>{

    public List<T> getAll(Integer userId,Integer elementId);
    public T remove(Integer userId,Integer elementId);
    public List<T> removeAll(Integer userId, List<Integer> elementsId);
    public T add(Integer userId, Integer elementId);
    public T addAll(Integer userId, List<Integer> elementsId);

}
