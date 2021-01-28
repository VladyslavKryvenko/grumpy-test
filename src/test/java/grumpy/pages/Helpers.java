package grumpy.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Helpers {

  ElementsCollection button = $$("button");

  public void button(String nameButton) {
    button.find(exactText(nameButton)).click();
  }

  public void shouldHaveText(String text) {
    $(".post_body").find("p").shouldHave(Condition.text(text));
  }

  public void shouldHaveDelete() {
    $(".loader").shouldHave(Condition.attribute("class"));
  }

}
