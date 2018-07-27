package game.menu;

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

    public static GameOverMenu getInstance() {
        if (instance == null) {
            instance = new GameOverMenu();
        }
        return instance;
    }

    public void outputPrompt() {
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
     * Mode detemines outputPrompt text and decisions???
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
