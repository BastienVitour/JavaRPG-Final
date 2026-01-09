package main.java.rpg.controllers;

import main.java.rpg.core.Guild;
import main.java.rpg.dao.GuildDAO;
import main.java.rpg.settings.DatabaseConnection;
import main.java.rpg.validators.GuildValidator;

import java.sql.Connection;
import java.util.List;

public class GuildController implements Controller<Guild> {

    private GuildDAO guildDAO;

    public GuildController() {
        Connection connection = DatabaseConnection.getConnection();
        this.guildDAO = new GuildDAO(connection);
    }

    @Override
    public List<Guild> findAll() {
        return this.guildDAO.findAll();
    }

    @Override
    public boolean save(Guild guild) {
        boolean creationValid = false;

        GuildValidator guildValidator = new GuildValidator(this.guildDAO);
        if(guildValidator.validateGuild(guild)) {
            return this.guildDAO.save(guild);
        }

        return creationValid;
    }
}
