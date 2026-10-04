package com.girlhacks.buildertools;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Javalin app = Javalin.create(cfg -> cfg.staticFiles.add("/public"));

        // Open the home address and get your page (no need to rename it)
        //app.get("/", ctx -> ctx.redirect("/GirlHacks26.html"));

        // The chat sends commands here
        app.post("/command", ctx -> ctx.result(game.handle(ctx.body())));

        app.start(8080);
    }
}

class Game {
    int day = 1, forestHealth = 30, energy = 5, blight = 20;

    String handle(String input) {
        String cmd = input.trim().toLowerCase();
        switch (cmd) {
            case "look":
                return "Day " + day + ". Forest health: " + forestHealth + "/100. Blight: " + blight + "%.\nEnergy: " + energy;
            case "help":
                return "Commands: look, help";
            default:
                return "The forest rustles, but nothing happens. (try 'help')";
        }
    }
}