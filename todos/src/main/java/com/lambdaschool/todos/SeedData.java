package com.lambdaschool.todos;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.services.TodosService;
import com.lambdaschool.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    @Autowired
    TodosService todoService;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws Exception
    {

        User u1 = new User("admin",
                           "password",
                           "admin@lambdaschool.local");

        u1 = userService.save(u1);

        Todo t1 = new Todo(u1,
                "Give Joe access rights", false);
        Todo t2 = new Todo(u1, "Change the color of the home page", false);

        t1 = todoService.save(t1);
        t2 = todoService.save(t2);

        u1.getTodos()
                .add(t1);
        u1.getTodos()
                .add(t2);

        User u2 = new User("cinnamon",
                           "1234567",
                           "cinnamon@lambdaschool.local");

        u2 = userService.save(u2);

        Todo t3 = new Todo(u2, "Take a nap", false);
        Todo t4 = new Todo(u2, "Rearrange my hutch", false);
        Todo t5 = new Todo(u2, "Groom my fur", false);

        t3 = todoService.save(t3);
        t4 = todoService.save(t4);
        t5 = todoService.save(t5);

        u2.getTodos()
                .add(t3);
        u2.getTodos()
                .add(t4);
        u2.getTodos()
                .add(t5);

        // user
        User u3 = new User("barnbarn",
                           "ILuvM4th!",
                           "barnbarn@lambdaschool.local");

        u3 =userService.save(u3);

        Todo t6 = new Todo(u3, "Rearrange my Hutch", false);

        t6 = todoService.save(t6);

        u3.getTodos()
                .add(t6);

        User u4 = new User("puttat",
                           "password",
                           "puttat@school.lambda");

        u4 = userService.save(u4);

        User u5 = new User("misskitty",
                           "password",
                           "misskitty@school.lambda");

        u5 = userService.save(u5);
    }
}