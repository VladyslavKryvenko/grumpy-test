package grumpy;

import grumpy.pages.Helpers;
import grumpy.pages.Main;
import grumpy.pages.Post;
import grumpy.pages.config.BaseTest;
import org.testng.annotations.Test;



public class GrumpyTest extends BaseTest {
  Post post = new Post();
  Main mainPage = new Main();
  String text = "I added a new post";
  String newText = "I have corrected the text in the post";



  @Test()
  public void grumpyE2ETest() {
    mainPage.open();
    mainPage.addPost();

    post.addPost(text);
    new Helpers().shouldHaveText(text);

    mainPage.editPost();
    post.editTo(newText);
    new Helpers().shouldHaveText(newText);

    post.delete();
    new Helpers().shouldHaveDelete();
  }

//  @Test
//  public void deleteDraft() {
//    mainPage.open();
//    mainPage.addPost();
//    post.deleteDraft(text);
//    new Helpers().shouldHaveDelete();
//  }

}
