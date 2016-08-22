package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;

/**
 * This class represents the main page of Salesforce.
 *
 * @author Jimmy Vargas.
 */
public class MainPage extends AbstractBasePage {

    private NavigationBar navBar;

    private TopHeader topHeader;

    public MainPage() {
        topHeader = new TopHeader();
        navBar = new NavigationBar();
    }

    /**
     * This method sends to the top header.
     *
     * @return TopHeader.
     */
    public TopHeader gotoTopHeader() {
        return this.topHeader;
    }

    /**
     * Returns the navigation bar where all the HOMEs are located
     */
    public NavigationBar gotoNavBar() {
        return this.navBar;
    }
}
