package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;

public interface TodosService
{
    Todo markComplete(Todo todo, long todoid);

    Todo save(Todo todo);
}
