package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.pages.base.ViewDetailBase;

/**
 * This class will be used to represent Account view details and its options.
 *
 * @author Carlos Orellana.
 */
public class AccountViewDetail extends ViewDetailBase {

    @Override
    protected AccountView clickEditLnk() {
        clickEditLink();
        return new AccountView();
    }

    @Override
    public ViewDetailBase clickDeleteLnk() {
        clickDeleteLink();
        return this;
    }
}
