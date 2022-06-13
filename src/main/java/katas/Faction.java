package katas;

import java.util.ArrayList;
import java.util.List;

public class Faction {
    public String getFactionName() {
        return factionName;
    }

    String factionName;

    public Faction(String name) {
        this.factionName = name;
    }

    public void join(Character character) {
        character.addFaction(this);
    }

    public void leave(Character character) {
        character.removeFaction(this);
    }
}