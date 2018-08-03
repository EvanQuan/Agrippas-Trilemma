package game.menu;

import game.system.input.PlayerCommand;
import game.system.output.IPrintBuffer;

/**
 * Mediates post-game decisions
 * Asks to save before returning to MainMenu
 * Asks player to load or restart after death/victory
 */
public class GameOverMenu extends Menu {

    public static final int LOSE = 0;
    public static final int WIN = 1;
    private static GameOverMenu instance;

    private String title;

    /**
     * Default GameOverMenu constructor
     */
    private GameOverMenu() {
        setMode(LOSE);
    }

    /**
     * Process a {@link PlayerCommand} as receiveInput. This will set some corresponding output to this menu's currently set
     * {@link IPrintBuffer}.
     *
     * @param playerCommand to processInput
     */
    @Override
    public void processInput(PlayerCommand playerCommand) {
        // TODO
    }

    /**
     * Create all valid commands for this menu. Use addCommand().
     */
    @Override
    protected void initializeCommands() {
        // TODO
    }

    public static GameOverMenu getInstance() {
        if (instance == null) {
            instance = new GameOverMenu();
        }
        return instance;
    }

    public void appendPrompt() {
//        printTitleln(title);
//
//        printPlayer("Restart");
//        append(" or ");
//        printPlayer("Load");
//        append(" a game save, or ");
//        printPlayer("Return");
//        append(" to the ");
//        printLocation(" Main Menu");
//        println(".");
    }

    /**
     * Mode detemines appendPrompt text and decisions???
     * @param  int mode          of menu
     */
    public void setMode(int mode) {
        switch(mode) {
            case LOSE:
                title = "Oh no, you died!";
                break;
            case WIN:
                title = "Hooray, you won!";
                break;
        }
    }
    public void setWin() {
        setMode(WIN);
    }
    public void setLose() {
        setMode(LOSE);
    }

}
