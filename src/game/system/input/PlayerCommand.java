package game.system.input;

import util.FuncUtils;

import java.util.ArrayList;

/**
 * Represents a command that the player has issued to the game in a form of a
 * {@link String}. A player command is composed of a series of
 * {@link PlayerAction}s that are sequentially ordered.
 *
 * @author Evan Quan
 *
 */
public class PlayerCommand {

    /**
     * Represents the player command directly as a string, unaltered.
     */
    private String string;

    /**
     * Series of playerActions in the order they were issued.
     */
    ArrayList<PlayerAction> playerActions;

    /**
     * Creates a Player Command instance.
     *
     * @param string
     */
    public PlayerCommand(String string) {
        this.string = string;
        playerActions = new ArrayList<>();
    }

    /**
     * Add a single playerAction to this stringCommands list of playerActions.
     * 
     * @param playerAction
     */
    public void addAction(PlayerAction playerAction) {
        this.playerActions.add(playerAction);
    }

    public boolean contains(PlayerAction playerAction) {
        return this.playerActions.contains(playerAction);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof PlayerCommand) {
            return hasSameString((PlayerCommand) other)
                    && hasSameActions((PlayerCommand) other);
        }
        return false;
    }

    /**
     *
     * @return true if this command represents an empty string.
     */
    public boolean isEmpty() {
        return this.string.isEmpty();
    }

    public ArrayList<PlayerAction> getPlayerActions() {
        return this.playerActions;
    }

    public String getString() {
        return this.string;
    }

    public boolean hasActions() {
        return this.playerActions != null && !this.playerActions.isEmpty();
    }

    public boolean hasSameActions(PlayerCommand other) {
        return FuncUtils.nullablesEqual(this.playerActions, other.getPlayerActions());
    }

    public boolean hasSameString(PlayerCommand other) {
        return FuncUtils.nullablesEqual(this.string, other.getString());
    }

    public void setPlayerActions(ArrayList<PlayerAction> playerActions) {
        this.playerActions = playerActions;
    }

    @Override
    public String toString() {
        StringBuilder actions = new StringBuilder();
        if (hasActions()) {
            for (PlayerAction playerAction : this.playerActions) {
                actions.append("\t\t" + playerAction + System.lineSeparator());
            }
        }
        return "[string: " + string + System.lineSeparator() +
                "\tplayerActions[" + playerActions.size() + "]" + System.lineSeparator()
                + actions + "]";
    }
}
