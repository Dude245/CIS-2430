package assignmentwo;

/**
 *
 * @author Nathan
 */
public class Journal {

    private String callNum;
    /**
     * <p>Call number</p>
     */
    private String title;
    /**
     *  * <p>Title.</p>
     */
    private String year;
    /**
     *  * <p>Year</p>
     */
    private String org;

    /**
     *  * <p>Organization</p>
     * @param str Sets the year
     */
    public void setYear(String str) {
        if (str == null) {
            str = "";
        }
        this.year = str;
    }

    /**
     * Sets the Year for this element
     * @param str
     */
    public void setOrg(String str) {
        if (str == null) {
            str = "";
        }
        this.org = str;
    }

    /**
     * Sets the organization for this element
     * @param str
     */
    public void setTitle(String str) {
        if (str == null) {
            str = "";
        }
        this.title = str;
    }

    /**
     * Sets the title for this element
     * @param str
     */
    public void setCallN(String str) {
        if (str == null) {
            str = "";
        }
        this.callNum = str;
    }

    /**
     * Gets the current title
     * @return current title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the current organization
     * @return the current organization
     */
    public String getOrg() {
        return this.org;
    }

    /**
     * Gets the current year
     * @return the current Year
     */
    public String getYear() {
        return this.year;
    }

    /**
     * Gets the current call number
     * @return the current Call number
     */
    public String getCallN() {
        return this.callNum;
    }
    /**
     * Prints the arrayList
     * @return prints the arrayList
     */
    @Override
    public String toString() {
        return "Call Number: " + callNum + "\n" + "Title : " + title + " \n"+"Orginization: "+org+ "\n"+"Year: "+year+"\n";
        
    }
}
