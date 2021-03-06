package game.object;

import util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * All objects in the game. Have names and descriptions.
 *
 * @author Evan Quan
 * @since March 5, 2018
 */
public abstract class GameObject implements Serializable {

    public static final int DEFAULT = 0;
    private static final long serialVersionUID = 1L;
    private ArrayList<String> singleNames;
    private ArrayList<String> pluralNames;
    private ArrayList<String> descriptions;
    private int descriptionIndex;

    /**
     * Empty initialization constructor only used for subclasses
     */
    protected GameObject() {
        singleNames = new ArrayList<String>();
        pluralNames = new ArrayList<String>();
        descriptions = new ArrayList<String>();
        descriptionIndex = DEFAULT;
    }

    /**
     * @param description to add
     */
    public void addDescription(String description) {
        descriptions.add(description);
    }

    /**
     * @param descriptions to add
     */
    public void addDescriptions(String[] descriptions) {
        CollectionUtils.addArrayToList(descriptions, this.descriptions);
    }

    /**
     * @param pluralName to add
     */
    public void addPluralName(String pluralName) {
        pluralNames.add(pluralName);
    }

    /**
     * @param pluralNames to add
     */
    public void addPluralNames(String[] pluralNames) {
        CollectionUtils.addArrayToList(pluralNames, this.pluralNames);
    }

    /**
     * @param singleName to add
     */
    public void addSingleName(String singleName) {
        singleNames.add(singleName);
    }

    /**
     * @param singleNames to add
     */
    public void addSingleNames(String[] singleNames) {
        CollectionUtils.addArrayToList(singleNames, this.singleNames);
    }

    /**
     * Compares if other game object is identical to this one
     *
     * @param otherGameObject to compare
     * @return true if GameObjects are the same
     */
    public boolean equals(GameObject otherGameObject) {
        return this.singleNames.equals(otherGameObject.getSingleNames())
                && this.pluralNames.equals(otherGameObject.getPluralNames())
                && this.descriptions.equals(otherGameObject.getDescriptions());
    }

    /**
     * @return get description of object
     */
    public String getDescription() {
        return getDescription(descriptionIndex);
    }

    public String getDescription(int index) {
        return this.descriptions.get(index);
    }

    /**
     * @return all descriptions of object
     */
    public ArrayList<String> getDescriptions() {
        return this.descriptions;
    }

    /**
     * Set descriptions
     */
    public void setDescriptions(String[] descriptions) {
        CollectionUtils.setArrayToList(descriptions, this.descriptions);
    }

    /**
     * @return primary plural name
     */
    public String getPluralName() {
        return getPluralName(DEFAULT);
    }

    /**
     * @param index of plural name
     * @return plural name of index
     */
    public String getPluralName(int index) {
        return this.pluralNames.get(index);
    }

    /**
     * @return all plural names
     */
    public ArrayList<String> getPluralNames() {
        return this.pluralNames;
    }

    public void setPluralNames(String[] pluralNames) {
        CollectionUtils.setArrayToList(pluralNames, this.pluralNames);
    }

    /**
     * @return primary single name of object
     */
    public String getSingleName() {
        return getSingleName(DEFAULT);
    }

    public String getSingleName(int index) {
        return this.singleNames.get(index);
    }

    public ArrayList<String> getSingleNames() {
        return this.singleNames;
    }

    public void setSingleNames(String[] singleNames) {
        CollectionUtils.setArrayToList(singleNames, this.singleNames);
    }

    /**
     * Set description to the next available one if it exists
     */
    public void setNextDescription() {
        if (descriptionIndex < descriptions.size() - 1) {
            descriptionIndex++;
        }
    }

    /**
     * Plural names by default are identical to single names with appended 's'
     * character
     */
    public void setPluralNamesDefault() {
        pluralNames.clear();
        for (int i = 0; i < singleNames.size(); i++) {
            pluralNames.add(i, singleNames.get(i) + "s");
        }
    }

    /**
     * Set description to the previous available one if it exists
     */
    public void setPreviousDescription() {
        if (descriptionIndex > DEFAULT) {
            descriptionIndex--;
        }
    }

    /**
     * Create string representation of GameObject for printing
     *
     * @return
     */
    @Override
    public String toString() {
        return (getSingleName());
    }
}
