package main.java.rpg.validators;

import main.java.rpg.core.Guild;
import main.java.rpg.dao.GuildDAO;

public class GuildValidator {

    private GuildDAO guildDao;

    public GuildValidator(GuildDAO guildDao) {
        this.guildDao = guildDao;
    }

    public boolean validateGuild(Guild guild) {
        try {
            return this.guildDao.findByName(guild.getName()) == null;
        }
        catch(Exception e) {
            return false;
        }
    }

}
