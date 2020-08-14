package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;

public interface TodosService
{
    Todo markComplete(long todoid);

    Todo save(Todo todo);
}
