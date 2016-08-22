package org.fundacionjala.sfdc.chatter;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainPage;
import org.fundacionjala.sfdc.pages.base.NavigationBar;
import org.fundacionjala.sfdc.pages.chatter.ChatterHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * This class wil be used to test the creation of a post.
 *
 * @author  Monica Pardo.
 * @since 6/13/2015.
 */
public class CreatePost {

    private NavigationBar navigationBar;
    private ChatterHome chatterHome;

    @BeforeMethod(groups = {"Acceptance"})
    public void setUp() {
        MainPage mainPage = LoginPage.loginAsPrimaryUser();
        navigationBar = mainPage.gotoNavBar();
    }

    @Test(groups = {"Acceptance"})
    public void createPostAndComment() {
        final String post = "Post test";
        final String comment = "new comment";
        chatterHome = navigationBar.goToChatterHome()
                .clickPost()
                .setPost(post)
                .clickShareBtn()
                .clickCommentForPost(post)
                .setComment(comment)
                .clickCommentBtn();
        assertTrue(chatterHome.verifyPostCreated(post), "Post Was not Created");
        assertTrue(chatterHome.verifyCommentCreated(comment), "Comment Was not Created");
    }

    @AfterMethod(groups = {"Acceptance"})
    public void tearDown() {
        chatterHome.deletePost();
    }
}
