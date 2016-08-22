package org.fundacionjala.sfdc.chatter;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.dto.Chatter;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterHome;
import org.fundacionjala.sfdc.pages.chatter.EditPost;

import static org.fundacionjala.sfdc.framework.utils.JSONMapper.getGeneric;

/**
 * This class will be used to test the edition of a post chatter.
 *
 * @author Veronica Prado.
 * @author Bruno Barrios.
 * @since 9/3/2015
 */
public class EditPostChatter {

    private ChatterHome chatterHome;

    private Chatter createChatter;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        createChatter = getChatter("Chatter.json");
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        NavigationBar navigationBar = mainPage.gotoNavBar();
        chatterHome = navigationBar.goToChatterHome();
        chatterHome.clickPost()
                .setPost(createChatter.getPost())
                .clickShareBtn();
    }

    @Test(groups = {"Acceptance"})
    public void createPostAndComment() {
        Chatter chatter = getChatter("EditChatter.json");
        EditPost editPost = chatterHome.editPost(createChatter.getPost());
        editPost.setEditTextBox(chatter.getPost());
        chatterHome = editPost.clickSaveEditBtn();
        Assert.assertTrue(chatterHome.verifyPostCreated(chatter.getPost()), "Post has not been Updated");
    }

    private Chatter getChatter(String fileJson) {
        return getGeneric(Chatter.class,fileJson);
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        chatterHome.deletePost();
    }
}
