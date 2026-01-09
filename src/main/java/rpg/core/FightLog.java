package main.java.rpg.core;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class FightLog {

    private String character1;
    private String character2;
    private Timestamp dateTime;
    private String actionLog;
    private String winner;

    public FightLog(FightLogBuilder fightLogBuilder) {
        this.character1 = fightLogBuilder.character1;
        this.character2 = fightLogBuilder.character2;
        this.dateTime = fightLogBuilder.dateTime;
        this.actionLog = fightLogBuilder.actionLog;
        this.winner = fightLogBuilder.winner;
    }

    public String getCharacter1() {
        return character1;
    }

    public void setCharacter1(String character1) {
        this.character1 = character1;
    }

    public String getCharacter2() {
        return character2;
    }

    public void setCharacter2(String character2) {
        this.character2 = character2;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getActionLog() {
        return actionLog;
    }

    public void setActionLog(String actionLog) {
        this.actionLog = actionLog;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public static class FightLogBuilder {
        private String character1;
        private String character2;
        private Timestamp dateTime;
        private String actionLog;
        private String winner;

        public FightLogBuilder() {}

        public FightLogBuilder setCharacter1(String character1) {
            this.character1 = character1;
            return this;
        }

        public FightLogBuilder setCharacter2(String character2) {
            this.character2 = character2;
            return this;
        }

        public FightLogBuilder setTimestamp(Timestamp datetime) {
            this.dateTime = datetime;
            return this;
        }

        public FightLogBuilder setWinner(String winner) {
            this.winner = winner;
            return this;
        }

        public FightLogBuilder setActionLog(String actionLog) {
            this.actionLog = actionLog;
            return this;
        }

        public FightLog build() {
            return new FightLog(this);
        }
    }

    public void getBriefDescription() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String dateTimeString = this.dateTime.toLocalDateTime().format(formatter);
        System.out.println("Combat entre " + this.character1 + " et " + this.character2 + " du " + dateTimeString);
    }
}
