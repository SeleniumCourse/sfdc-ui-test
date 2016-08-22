package org.fundacionjala.sfdc.pages.contacts;

import org.fundacionjala.sfdc.framework.selenium.CommonOperation;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.ViewDetailBase;

/**
 * This class is used to represent Contact view details and its options.
 *
 * @author Veronica.
 */
public class ContactViewDetail extends ViewDetailBase {

    public ContactViewDetail() {
        CommonOperation.waitForWebElement(viewSelected);
    }

    @Override
    protected ContactView clickEditLnk() {
        clickEditLink();
        return new ContactView();
    }

    @Override
    public ContactViewDetail clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }

    public MainPage gotoMainPage() {
        return new MainPage();
    }

}
