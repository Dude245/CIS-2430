package assignmentwo;

/**
 *
 * @author Nathan
 */
public class Book {

    private String callNum;
    /**
     * <p>Call number</p>
     */
    private String author;
    /**
     *  * <p>Author .</p>
     */
    private String title;
    /**
     *  * <p>Title.</p>
     */
    private String publish;
    /**
     *  * <p>Publisher</p>
     */
    private String year;

    /**
     *  
     * @param str sets the author
     */
    public void setAuthor(String str) {
        if(str == null)
        {
            str="";
        }
        this.author = str;
    }

    /**
     * Sets the author for this element
     * @param str sets the publisher
     */
    public void setPublish(String str) {
           if(str == null)
        {
            str="";
        }
        this.publish = str;
    }

    /**
     * Sets the PUblisher for this element
     * @param str sets the year
     */
    public void setYear(String str) {
        if(str==null)
        {
            str="";
        }
            this.year = str;
    }

    /**
     * Sets the Title for this element
     * @param str sets the title
     */
    public void setTitle(String str) {
           if(str == null)
        {
            str="";
        }
        this.title = str;
    }

    /**
     * Sets the Call  number for this element
     * @param str sets the call number
     */
    public void setCallN(String str) {
           if(str == null)
        {
            str="";
        }
        this.callNum = str;
    }

    /**
     * Sets the call Number for this element
     * @return gets the current title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @return gets the current call number
     */
    public String getCallN() {
        return this.callNum;
    }

    /**
     *
     * @return gets the current Year
     */
    public String getYear() {
        return this.year;
    }

    /**
     *
     * @return gets the current publisher
     */
    public String getPub() {
        return this.publish;
    }

    /**
     *
     * @return gets the current author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     *
     * @return Prints out the arrayList
     */
    @Override
    public String toString() {
        return "Call Number: " + callNum + "\n" + "Author(s): " + author + " \n"
                + "Title : " + title + " \n"+"Publisher: "+publish+ "\n"+"Year: "+year+"\n";
        
    }

}
