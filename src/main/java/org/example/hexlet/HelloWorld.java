package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;

public class HelloWorld {
    public static void main(String[] args) {
        var app = getJavalin();
        app.start(7070);
    }

    public static Javalin getJavalin() {
        var app = Javalin.create((JavalinConfig config) -> config.plugins.enableDevLogging());

        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));

        app.get("/hello", ctx -> {
            var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });

        return app;
    }
}