package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import game.system.*;

public abstract class FileObject {
    public static final int MAXIMUM_SAVES = 5;
    public static final String SAVE_DIRECTORY = "saves";
    public static final String FILE_EXTENTION = "txt";
    public static final String FILE_NAME = "World";
    private int saveNum;
    private File directory;
    private File save;
    protected ArrayList<String> existingSaves = new ArrayList<String>();

    /**
     * Checks if save file exists within valid saves
     */
    public void determineExistingSaves() {
        existingSaves.clear();
        ReadObject reader = ReadObject.getInstance();
        for (int i = 1; i <= MAXIMUM_SAVES; i++) {
            reader.setSaveNum(i);
            if (reader.saveExists()) {
                existingSaves.add(Integer.toString(i));
            }
        }
    }

    /**
     * Returns if existingSaves is not empty
     */
    public boolean hasExistingSaves() {
        return existingSaves.size() > 0;
    }

    /**
     * Returns value of saveNum
     * @return
     */
    public int getSaveNum() {
        return this.saveNum;
    }

    /**
     * Returns value of directory
     * @return
     */
    public File getDirectory() {
        return this.directory;
    }

    /**
     * Returns value of save
     * @return
     */
    public File getSave() {
        return this.save;
    }

    /**
     * Sets new value of saveNum
     * @param int saveNum
     */
    public void setSaveNum(int saveNum) {
        this.saveNum = saveNum;
        this.directory = new File(SAVE_DIRECTORY + "/" + saveNum);
        this.save = new File(SAVE_DIRECTORY + "/" + saveNum + "/" + FILE_NAME + "." + FILE_EXTENTION);
    }

    /**
     * Checks if save directory exists
     * @param  int saveNum       [description]
     * @return     [description]
     */
    public boolean directoryExists() {
        return directory.exists();
    }

    /**
     * Checks if save file exists
     * @param  int saveNum       [description]
     * @return     [description]
     */
    public boolean saveExists() {
        return save.exists();
    }

}
