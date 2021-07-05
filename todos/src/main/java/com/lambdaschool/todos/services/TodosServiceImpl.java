package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodoRepository todorepos;

    @Transactional
    @Override
    public Todo markComplete(long todoid)
    {
        Todo currenttodo = todorepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo " + todoid + " Not Found!"));

        currenttodo.setCompleted(true);

        return todorepos.save(currenttodo);
    }

    @Override
    public Todo save(Todo todo)
    {
        Todo newTodo = new Todo();

        newTodo.setUser(todo.getUser());
        newTodo.setDescription(todo.getDescription());
        newTodo.setCompleted(todo.isCompleted());

        return todorepos.save(newTodo);
    }
}
