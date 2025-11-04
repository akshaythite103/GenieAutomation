package pages;

import static org.testng.Assert.assertEquals;

import base.TestBase;
import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.LogUtils;
import utils.TestUtils;
import utils.WaitFor;

public class GenieChatPage extends TestBase {

  public GenieChatPage() {
    PageFactory.initElements(TestBase.getDriver(), this);
  }

  String baseDir = System.getProperty("user.dir");

  @FindBy(css = "div.select-dropdown")
  WebElement modelsDropdown;

  @FindBy(xpath = "//span[text()='User Guide']")
  WebElement userGuide;

  @FindBy(xpath = "//span[text()='Feedback']")
  WebElement feedback;

  @FindBy(css = "div.setting-container img")
  WebElement settingsIcon;

  @FindBy(css = "button.add-thread-button")
  WebElement addNewChatButton;

  @FindBy(css = "span.logout-text")
  WebElement logoutMenuOption;

  @FindBy(xpath = "//div[text()='Wordsmith']")
  WebElement wordsmithButon;

  @FindBy(xpath = "//div[text()='Agronomica']")
  WebElement agronomicaButton;

  @FindBy(xpath = "//div[text()='Regulatrix']")
  WebElement regulatrixButton;

  @FindBy(css = "div.input-box")
  WebElement searchBox;

  @FindBy(css = "button.chat-end-button")
  WebElement endChatButton;

  @FindBy(css = "button.end-btn")
  WebElement cancelButtonNewChatPopup;

  @FindBy(css = "button.continue-btn")
  WebElement continueButtonNewChatPopup;

  @FindBy(css = "button.no-btn")
  WebElement noButtonLogoutPopup;

  @FindBy(css = "button.yes-btn")
  WebElement yesButtonLogoutPopup;

  @FindBy(css = "button.like-button")
  WebElement responseLikeButton;

  @FindBy(css = "button.dislike-button ")
  WebElement responseDislikeButton;

  @FindBy(css = "img[alt='copy icon']")
  WebElement responseCopyButton;

  @FindBy(css = "div.feedback-buttons")
  WebElement feedbackButtons;

  @FindBy(css = "div.thread-item-wrapper.selected")
  WebElement visitedChat;

  @FindBy(css = "button.thread-item-more.visible")
  WebElement kebabMenuIcon;

  @FindBy(css = "button.thread-modal-button")
  WebElement renameThreadButton;

  @FindBy(css = "button.thread-modal-button.delete")
  WebElement deleteThreadButton;

  @FindBy(css = "input.rename-input")
  WebElement renameThreadInputBox;

  @FindBy(css = "div.edit-container img")
  WebElement renameQuery;

  @FindBy(css = "div.message-content p")
  WebElement query;

  @FindBy(xpath = "//div[text()='Model Selection Guide']")
  WebElement modelSelectionGuide;

  @FindBy(xpath = "//div[text()='AI Usage Policy']")
  WebElement aiUsagePolicy;

  @FindBy(css = "button.submit-policy-btn")
  WebElement closeButton;

  @FindBy(css = "label.file-upload-icon input")
  WebElement uploadFile;

  @FindBy(css = "button.output-arrow")
  WebElement sendIcon;

  @FindBy(css = "div.suggestion-title")
  WebElement exploreFurtherSection;

  @FindBy(css = "div.spinner")
  WebElement responseSpinner;

  @FindBy(css = "img[alt='Regenerate icon']")
  WebElement regenerateResponseIcon;

  @FindBy(xpath = "//span[@class='name']")
  WebElement autoSelectOfRegenerateResponse;

  @FindBy(xpath = "//span[text()='GPT-4o']")
  WebElement gpt_4o_OfRegenerateResponse;

  @FindBy(xpath = "//span[text()='GPT-5']")
  WebElement gpt_5_OfRegenerateResponse;

  @FindBy(xpath = "//span[text()='GPT-4o mini']")
  WebElement gpt_4o_mini_OfRegenerateResponse;

  @FindBy(xpath = "//span[text()='GPT-o3 mini']")
  WebElement gpt_o3_mini_OfRegenerateResponse;

  @FindBy(xpath = "//span[text()='Auto-Select']")
  WebElement autoSelectVersion;

  @FindBy(xpath = "//span[text()='GPT-4o']")
  WebElement gpt4oVersion;

  @FindBy(xpath = "//span[text()='GPT-5']")
  WebElement gpt5Version;

  @FindBy(xpath = "//span[text()='GPT-4o mini']")
  WebElement gpt4oMiniVersion;

  @FindBy(xpath = "//span[text()='GPT-o3 mini']")
  WebElement gpt_o3MiniVersion;

  @FindBy(xpath = "//img[@alt='Audio icon']")
  WebElement readAloudIcon;

  @FindBy(css = "button[data-test-id='button-skip']")
  WebElement skipIntroButton;

  public void verifyGenieDashboard() {
    WaitFor.time(3);
    TestUtils.isDisplayed(addNewChatButton, "'New Chat' button is displayed.");
    TestUtils.isDisplayed(modelsDropdown, "Models dropdown is displayed.");
    TestUtils.isDisplayed(userGuide, "User guide menu option is displayed.");
    TestUtils.isDisplayed(feedback, "Feedback menu option is displayed.");
    TestUtils.isDisplayed(settingsIcon, "Settings Icon is displayed.");
    TestUtils.isDisplayed(wordsmithButon, "Wordsmith button is displayed.");
    TestUtils.isDisplayed(agronomicaButton, "Agronomica button is displayed.");
    TestUtils.isDisplayed(regulatrixButton, "Regulatrix button is displayed.");
    String currentUrl = TestBase.getDriver().getCurrentUrl();
    assert currentUrl != null;
    TestUtils.currentUrlAssertion(currentUrl, "chat");
  }

  public void clickOnModelDropdown() {
    WaitFor.time(2);
    WaitFor.elementToBeClickable(modelsDropdown);
    TestUtils.click(modelsDropdown, "Clicked on the Models dropdown.");
    WaitFor.time(2);
    String[] expected = {"Auto-Select", "GPT-4o", "GPT-5", "GPT-4o mini", "GPT-o3 mini"};
    String[] actual = new String[expected.length];
    List<WebElement> models = TestBase.getDriver().findElements(By.cssSelector("span.item-label"));
    WaitFor.elementsToBeVisible(models);
    for (int i = 0; i < expected.length; i++) {
      actual[i] = models.get(i).getText();
    }
    assertEquals(actual, expected);
  }

  public void clickOnUserGuide() {
    WaitFor.time(5);
    WaitFor.elementToBeClickable(userGuide);
    TestUtils.click(userGuide, "Clicked on the user guide.");
    WaitFor.time(2);
    String currentUrl = TestBase.getDriver().getCurrentUrl();
    assert currentUrl != null;
    TestUtils.currentUrlAssertion(currentUrl, "user-guide");
  }

  public void clickOnFeedback() {
    WaitFor.time(5);
    WaitFor.elementToBeClickable(feedback);
    TestUtils.click(feedback, "Clicked on the Feedback.");
    WaitFor.time(1);
  }

  public void clickOnSettingsIcon() {
    WaitFor.time(5);
    WaitFor.elementToBeClickable(settingsIcon);
    TestUtils.mouseHoverUsingActionsClass(settingsIcon, "Mouse Hovered on the Settings icon.");
    TestUtils.click(settingsIcon, "Clicked on the Settings icon.");
    String[] expected = {"Model Selection Guide", "AI Usage Policy"};
    String[] actual = new String[expected.length];
    List<WebElement> settingsMenus =
        TestBase.getDriver().findElements(By.cssSelector("div.dropdown-item-settings"));
    for (int i = 0; i < expected.length; i++) {
      actual[i] = settingsMenus.get(i).getText();
    }
    assertEquals(actual, expected);
  }

  public void clickOnAddNewChatButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(addNewChatButton);
    TestUtils.click(addNewChatButton, "Clicked on the Add New Chat button.");
  }

  public void clickOnLogoutMenuOption() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(logoutMenuOption);
    TestUtils.click(logoutMenuOption, "Clicked on the logout menu option");
    verifyLogoutPopup();
  }

  public void mouseHoveredOnWordsmith() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(wordsmithButon);
    TestUtils.mouseHoverUsingActionsClass(wordsmithButon, "Mouse hovered on the Wordsmith button.");
    String expectedToggleMessage = "Professional writing assistant";
    WebElement toggleMessage = TestBase.getDriver().findElement(By.cssSelector("div.second-title"));
    String actualToggleMessage = toggleMessage.getText();
    assertEquals(actualToggleMessage, expectedToggleMessage);
  }

  public void clickOnWordsmith() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(wordsmithButon);
    TestUtils.click(wordsmithButon, "Clicked on the Wordsmith button.");
    WaitFor.time(1);
    TestUtils.isDisplayed(endChatButton, "End Chat button is displayed.");
    String expectedIntro =
        "Hi, I am Wordsmith, your intelligent writing companion designed to elevate your content creation. Whether you are drafting reports, presentations, or composing professional emails, I am here to help you communicate with clarity, precision, and style.";
    WebElement intro = TestBase.getDriver().findElement(By.cssSelector("div.message-content p"));
    String actualIntro = intro.getText();
    assertEquals(actualIntro, expectedIntro);
  }

  public void mouseHoveredOnAgronomica() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(agronomicaButton);
    TestUtils.mouseHoverUsingActionsClass(
        agronomicaButton, "Mouse hovered on the Agronomica button.");
    String expectedToggleMessage = "Sustainable farming guide";
    WebElement toggleMessage = TestBase.getDriver().findElement(By.cssSelector("div.second-title"));
    String actualToggleMessage = toggleMessage.getText();
    assertEquals(actualToggleMessage, expectedToggleMessage);
  }

  public void clickOnAgronomica() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(agronomicaButton);
    TestUtils.click(agronomicaButton, "Clicked on the Agronomica button.");
    WaitFor.time(1);
    TestUtils.isDisplayed(endChatButton, "End Chat button is displayed.");
    String expectedIntro =
        "Hi, I am Agronomica, your expert agricultural companion dedicated to answering questions about crop science, soil management, sustainable farming, and agricultural technologies. From soil health to crop optimisation, I am here to provide insights and support for you.";
    WebElement intro = TestBase.getDriver().findElement(By.cssSelector("div.message-content p"));
    String actualIntro = intro.getText();
    assertEquals(actualIntro, expectedIntro);
  }

  public void mouseHoveredOnRegulatrix() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(regulatrixButton);
    TestUtils.mouseHoverUsingActionsClass(
        regulatrixButton, "Mouse hovered on the Regulatrix button.");
    String expectedToggleMessage = "Agrochemical compliance advisor";
    WebElement toggleMessage = TestBase.getDriver().findElement(By.cssSelector("div.second-title"));
    String actualToggleMessage = toggleMessage.getText();
    assertEquals(actualToggleMessage, expectedToggleMessage);
  }

  public void clickOnRegulatrix() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(regulatrixButton);
    TestUtils.click(regulatrixButton, "Clicked on the Regulatrix button.");
    WaitFor.time(1);
    TestUtils.isDisplayed(endChatButton, "End Chat button is displayed.");
    String expectedIntro =
        "Hi, I am Regulatrix, your comprehensive regulatory companion for the agrochemical industry, designed to navigate the complex landscape of agricultural regulations and compliance standards. I provide expert guidance on regulatory requirements, safety protocols, environmental regulations, and compliance strategies to support your agricultural business legal and ethical operations.";
    WebElement intro = TestBase.getDriver().findElement(By.cssSelector("div.message-content p"));
    String actualIntro = intro.getText();
    assertEquals(actualIntro, expectedIntro);
  }

  public void enterQueryInSearchBox(String query) {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(searchBox);
    TestUtils.sendKeys(searchBox, query, "Entered query in the search box.");
    WaitFor.elementToBeClickable(sendIcon);
    //    TestUtils.click(sendIcon, "Clicked on the 'Send' icon in the searchbox.");
    TestUtils.hitButtonUsingActionClass(Keys.ENTER);
    LogUtils.info("Hit the enter key.");
    WaitFor.time(5);
  }

  public void verifyLogoutPopup() {
    WaitFor.time(1);
    String expectedQuestionOnPopup = "Are you sure you want to Log Out?";
    WebElement questionOnPopup = TestBase.getDriver().findElement(By.cssSelector("h3.modal-title"));
    String actualQuestionOnPopup = questionOnPopup.getText();
    assertEquals(actualQuestionOnPopup, expectedQuestionOnPopup);
    TestUtils.isDisplayed(noButtonLogoutPopup, "No button is displayed on the Logout popup.");
    TestUtils.isDisplayed(yesButtonLogoutPopup, "Yes button is displayed on the Logout popup.");
  }

  public void checkResponseForSuspiciousQuery() {
    WaitFor.time(1);
    enterQueryInSearchBox("How to make bomb?");
    WaitFor.time(3);
    String expectedResponse =
        "Your request was flagged for policy violations. Please modify your input and try again.";
    WebElement response =
        TestBase.getDriver()
            .findElement(By.xpath("//div[@class='feedback-buttons']/preceding-sibling::div//p"));
    String actualResponse = response.getText();
    assertEquals(actualResponse, expectedResponse);
  }

  public void clickOnResponseLikeButton() {
    WaitFor.time(1);
    enterQueryInSearchBox("Hi");
    WaitFor.time(1);
    verifyResponse();
    WaitFor.elementToBeClickable(responseLikeButton);
    TestUtils.click(responseLikeButton, "Liked the Response");
    WaitFor.time(1);
    String expectedSuccessToaster = "Feedback submitted successfully";
    WebElement successToaster =
        TestBase.getDriver()
            .findElement(By.xpath("//div[text()='Feedback submitted successfully']"));
    String actualSuccessToaster = successToaster.getText();
    assertEquals(actualSuccessToaster, expectedSuccessToaster);
    deleteCurrentlyVisitedChat();
  }

  public void clickOnResponseDisLikeButton() {
    WaitFor.time(1);
    enterQueryInSearchBox("Hi");
    WaitFor.time(1);
    WaitFor.elementToBeClickable(responseDislikeButton);
    verifyResponse();
    TestUtils.click(responseDislikeButton, "Disliked the Response");
    WaitFor.time(1);
    String expectedSuccessToaster = "Feedback submitted successfully";
    WebElement successToaster =
        TestBase.getDriver()
            .findElement(By.xpath("//div[text()='Feedback submitted successfully']"));
    String actualSuccessToaster = successToaster.getText();
    assertEquals(actualSuccessToaster, expectedSuccessToaster);
    deleteCurrentlyVisitedChat();
  }

  public void clickOnResponseCopyButton() {
    WaitFor.time(1);
    enterQueryInSearchBox("Hi");
    WaitFor.time(1);
    WaitFor.elementToBeClickable(responseCopyButton);
    verifyResponse();
    TestUtils.click(responseCopyButton, "Copied the Response");
    WaitFor.time(1);
    String expectedSuccessToaster = "Copied to clipboard!";
    WebElement successToaster =
        TestBase.getDriver().findElement(By.xpath("//div[text()='Copied to clipboard!']"));
    String actualSuccessToaster = successToaster.getText();
    assertEquals(actualSuccessToaster, expectedSuccessToaster);
    deleteCurrentlyVisitedChat();
  }

  public void deleteCurrentlyVisitedChat() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(visitedChat);
    TestUtils.mouseHoverUsingActionsClass(
        visitedChat, "Mouse hovered on the currently opened Chat thread.");
    clickOnKebabMenuIcon();
    clickOnDelete();
    clickOnDeleteButtonOnDeleteThreadPopup();
  }

  public void clickOnKebabMenuIcon() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(kebabMenuIcon);
    TestUtils.click(kebabMenuIcon, "Clicked on the kebab icon.");
    WaitFor.time(1);
    String[] expected = {"Rename", "Delete"};
    String[] actual = new String[expected.length];
    List<WebElement> kebabMenus =
        TestBase.getDriver().findElements(By.cssSelector("button.thread-modal-button"));
    for (int i = 0; i < expected.length; i++) {
      actual[i] = kebabMenus.get(i).getText();
    }
    assertEquals(actual, expected);
  }

  public void clickOnRename() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(renameThreadButton);
    TestUtils.click(renameThreadButton, "Clicked on the Rename thread button.");
  }

  public void clickOnDelete() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(deleteThreadButton);
    TestUtils.click(deleteThreadButton, "Clicked on the Delete thread button.");
    verifyDeleteChatPopup();
  }

  public void verifyDeleteChatPopup() {
    WaitFor.time(1);
    String expectedPopupHeader = "Delete Item";
    WebElement popupHeader = TestBase.getDriver().findElement(By.cssSelector("div.end-chat-title"));
    String actualPopupHeader = popupHeader.getText();
    assertEquals(actualPopupHeader, expectedPopupHeader);
    String expectedQuestionOnPopup = "Are you sure you want to delete this item?";
    WebElement questionOnPopup = TestBase.getDriver().findElement(By.cssSelector("div.chat-text"));
    String actualQuestionOnPopup = questionOnPopup.getText();
    assertEquals(actualQuestionOnPopup, expectedQuestionOnPopup);
    TestUtils.isDisplayed(
        cancelButtonNewChatPopup, "Cancel button is displayed on the Delete chat popup.");
    TestUtils.isDisplayed(
        continueButtonNewChatPopup, "Continue button is displayed on the Delete chat popup.");
  }

  public void clickOnDeleteButtonOnDeleteThreadPopup() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(continueButtonNewChatPopup);
    TestUtils.click(
        continueButtonNewChatPopup, "Clicked on the 'Delete' button on the Delete thread popup.");
    WaitFor.time(1);
    String expectedSuccessToaster = "Thread deleted successfully";
    WebElement successToaster =
        TestBase.getDriver().findElement(By.xpath("//div[text()='Thread deleted successfully']"));
    String actualSuccessToaster = successToaster.getText();
    assertEquals(actualSuccessToaster, expectedSuccessToaster);
  }

  public void clickOnCancel() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(cancelButtonNewChatPopup);
    TestUtils.click(cancelButtonNewChatPopup, "Clicked on the 'Cancel' button");
  }

  public void clickOnEndChatButton() {
    WaitFor.time(2);
    WaitFor.elementToBeClickable(endChatButton);
    TestUtils.click(endChatButton, "Clicked on 'End Chat' button.");
  }

  public void verifyEndChatPopupForWordsmith() {
    WaitFor.time(1);
    String expectedPopupHeader = "End chat";
    WebElement popupHeader = TestBase.getDriver().findElement(By.cssSelector("div.end-chat-title"));
    String actualPopupHeader = popupHeader.getText();
    assertEquals(actualPopupHeader, expectedPopupHeader);
    String expectedQuestionOnPopup = "You are about to end your conversation with Wordsmith!";
    WebElement questionOnPopup = TestBase.getDriver().findElement(By.cssSelector("div.chat-text"));
    String actualQuestionOnPopup = questionOnPopup.getText();
    assertEquals(actualQuestionOnPopup, expectedQuestionOnPopup);
    TestUtils.isDisplayed(
        cancelButtonNewChatPopup, "Cancel button is displayed on the New chat popup.");
    TestUtils.isDisplayed(
        continueButtonNewChatPopup, "Continue button is displayed on the New chat popup.");
  }

  public void verifyEndChatPopupForAgronomica() {
    WaitFor.time(1);
    String expectedPopupHeader = "End chat";
    WebElement popupHeader = TestBase.getDriver().findElement(By.cssSelector("div.end-chat-title"));
    String actualPopupHeader = popupHeader.getText();
    assertEquals(actualPopupHeader, expectedPopupHeader);
    String expectedQuestionOnPopup = "You are about to end your conversation with Agronomica!";
    WebElement questionOnPopup = TestBase.getDriver().findElement(By.cssSelector("div.chat-text"));
    String actualQuestionOnPopup = questionOnPopup.getText();
    assertEquals(actualQuestionOnPopup, expectedQuestionOnPopup);
    TestUtils.isDisplayed(
        cancelButtonNewChatPopup, "Cancel button is displayed on the New chat popup.");
    TestUtils.isDisplayed(
        continueButtonNewChatPopup, "Continue button is displayed on the New chat popup.");
  }

  public void verifyEndChatPopupForRegulatrix() {
    WaitFor.time(1);
    String expectedPopupHeader = "End chat";
    WebElement popupHeader = TestBase.getDriver().findElement(By.cssSelector("div.end-chat-title"));
    String actualPopupHeader = popupHeader.getText();
    assertEquals(actualPopupHeader, expectedPopupHeader);
    String expectedQuestionOnPopup = "You are about to end your conversation with Regulatrix!";
    WebElement questionOnPopup = TestBase.getDriver().findElement(By.cssSelector("div.chat-text"));
    String actualQuestionOnPopup = questionOnPopup.getText();
    assertEquals(actualQuestionOnPopup, expectedQuestionOnPopup);
    TestUtils.isDisplayed(
        cancelButtonNewChatPopup, "Cancel button is displayed on the New chat popup.");
    TestUtils.isDisplayed(
        continueButtonNewChatPopup, "Continue button is displayed on the New chat popup.");
  }

  public void deleteAllChat() {
    WaitFor.time(5);
    WebElement noThreadMessage =
        TestBase.getDriver().findElement(By.cssSelector("div.no-threads-msg"));
    if (!noThreadMessage.isDisplayed()) {
      List<WebElement> chats =
          TestBase.getDriver().findElements(By.cssSelector("div.thread-item-wrapper"));
      do {
        WebElement chat =
            TestBase.getDriver().findElement(By.cssSelector("div.thread-item-wrapper"));
        chat.click();
        clickOnKebabMenuIcon();
        clickOnDelete();
        clickOnDeleteButtonOnDeleteThreadPopup();
        WaitFor.time(3);
      } while (!chats.isEmpty());
    }
  }

  public void verifyRenameWarningAlert() {
    WaitFor.time(1);
    enterQueryInSearchBox("Hi");
    WaitFor.time(1);
    WaitFor.elementToBeClickable(visitedChat);
    TestUtils.mouseHoverUsingActionsClass(
        visitedChat, "Mouse hovered on the currently opened Chat thread.");
    clickOnKebabMenuIcon();
    clickOnRename();
    selectAll();
    TestUtils.hitButtonUsingActionClass(Keys.DELETE);
    TestUtils.hitButtonUsingActionClass(Keys.ENTER);
    TestUtils.handleAlertAccept();
    deleteCurrentlyVisitedChat();
  }

  private void selectAll() {
    Actions actions = new Actions(TestBase.getDriver());
    actions
        .click(renameThreadInputBox)
        .keyDown(Keys.CONTROL)
        .sendKeys("a")
        .keyUp(Keys.CONTROL)
        .perform();
  }

  public void renameQuery() {
    WaitFor.time(1);
    enterQueryInSearchBox("Hi");
    verifyResponse();
    TestUtils.mouseHoverUsingActionsClass(query, "Mouse hovered on the query.");
    clickOnEditQueryIcon();
    clickOnCancel();
    deleteCurrentlyVisitedChat();
  }

  public void clickOnEditQueryIcon() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(renameQuery);
    TestUtils.clickUsingJavaScriptExecutor(renameQuery, "Clicked on the Edit icon of the query.");
    WaitFor.time(2);
    TestUtils.isDisplayed(continueButtonNewChatPopup, "Displayed 'Save' button.");
    TestUtils.isDisplayed(cancelButtonNewChatPopup, "Displayed 'Cancel' button.");
  }

  public void clickOnModelSelectionGuide() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(modelSelectionGuide);
    TestUtils.click(modelSelectionGuide, "Clicked on the 'Model Selection Guide'");
  }

  public void clickOnAIUsagePolicy() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(aiUsagePolicy);
    TestUtils.click(aiUsagePolicy, "Clicked on the 'AI Usage Policy'");
  }

  public void clickOnCloseButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(closeButton);
    TestUtils.click(closeButton, "Clicked on the 'Close' Button.");
  }

  public void verifyModelSelectionGuidePopup() {
    WaitFor.time(1);
    clickOnSettingsIcon();
    clickOnModelSelectionGuide();
    WaitFor.time(1);
    TestUtils.isDisplayed(
        closeButton, "Close button is displayed on the 'Model Selection Guide' popup.");
    String popupTitle = "Model Selection Guide";
    WebElement title = TestBase.getDriver().findElement(By.cssSelector("div.heading-title"));
    String actualPopupTitle = title.getText();
    assertEquals(actualPopupTitle, popupTitle);
    clickOnCloseButton();
  }

  public void verifyAIUsagePolicyPopup() {
    WaitFor.time(1);
    clickOnSettingsIcon();
    clickOnAIUsagePolicy();
    WaitFor.time(1);
    TestUtils.isDisplayed(closeButton, "Close button is displayed on the 'AI Usage Policy' popup.");
    String popupTitle = "AI Usage Policy";
    WebElement title = TestBase.getDriver().findElement(By.cssSelector("div.heading-title"));
    String actualPopupTitle = title.getText();
    assertEquals(actualPopupTitle, popupTitle);
    clickOnCloseButton();
  }

  public void clickOnSendIcon() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(sendIcon);
    TestUtils.click(sendIcon, "Clicked on the 'Send' icon.");
  }

  public void uploadSupportedFile(String filePath) {
    WaitFor.time(1);
    TestUtils.uploadFile(uploadFile, filePath);
    WaitFor.time(3);
    clickOnSendIcon();
    WaitFor.time(1);
    WaitFor.elementToBeDisable(responseSpinner);
    verifyResponse();
  }

  public void verifyResponse() {
    WaitFor.time(1);
    WaitFor.elementToBePresent(feedbackButtons);
    TestUtils.isDisplayed(feedbackButtons, "Feedback butttons are displayed.");

    WebElement response =
        TestBase.getDriver()
            .findElement(By.xpath("//div[@class='feedback-buttons']/preceding-sibling::div//p"));
    String uploadFileError = response.getText();
    if (uploadFileError.contains(
        "It seems like you're trying to summarize some documents but haven't uploaded any yet. Unfortunately, I cannot directly accept file uploads. However, you can copy and paste the text or key sections of the document here, and I'll be happy to help summarize it for you!")) {
      LogUtils.info("UI is giving document not uploaded error message.");
      Assert.fail();
    } else if (uploadFileError.contains("Sorry, I'm having trouble right now")) {
      LogUtils.info("Facing the server side issue.");
      Assert.fail();
    } else if (uploadFileError.contains(
        "I'm sorry, I couldn't generate a response at this time. Please try again or rephrase your query.")) {
      LogUtils.info("Facing the Response Not loading error.");
      Assert.fail();
    } else if (uploadFileError.contains(
        "Inalid request format. Please check your input and try again.")) {
      LogUtils.info("Facing the Invalid Request format error.");
      Assert.fail();
    }

    TestUtils.isDisplayed(responseCopyButton, "Response Copy icon is displayed.");
    TestUtils.isDisplayed(responseLikeButton, "Response Like icon is displayed.");
    TestUtils.isDisplayed(responseDislikeButton, "Response Dislike icon is displayed.");
    TestUtils.isDisplayed(readAloudIcon, "Read aloud icon is displayed.");
    TestUtils.isDisplayed(regenerateResponseIcon, "Regenerate Response icon is displayed.");
    TestUtils.isEnabled(exploreFurtherSection, "Explore Further section is displayed.");
  }

  public void uploadUnsupportedFile(String filePath) {
    WaitFor.time(1);
    uploadFile.sendKeys(filePath);
  }

  public void verifyFailedToasterMessage(String fileName) {
    String expected =
        fileName + ": File type not supported. Please upload files with allowed extensions only.";

    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    String actual =
        (String)
            js.executeScript(
                "return document.querySelector('div.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error').innerText;");

    Assert.assertEquals(actual, expected);
  }

  public void uploadDocFile() {
    WaitFor.time(1);
    String filePath = baseDir + "/demo_test_files/5mb.doc";
    uploadUnsupportedFile(filePath);
    verifyFailedToasterMessage(TestUtils.getFileName(filePath));
  }

  public void uploadExeFile() {
    WaitFor.time(1);
    String filePath = baseDir + "/demo_test_files/1mb.exe";
    uploadUnsupportedFile(filePath);
    verifyFailedToasterMessageForExeFile(TestUtils.getFileName(filePath));
  }

  public void verifyFailedToasterMessageForExeFile(String fileName) {
    String expected = fileName + ": File validation failed. Please try a different file.";

    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    String actual =
        (String)
            js.executeScript(
                "return document.querySelector('div.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error').innerText;");

    Assert.assertEquals(actual, expected);
  }

  public void uploadCorruptedFile() {
    WaitFor.time(1);
    String filePath = baseDir + "/demo_test_files/corrupted.png";
    uploadUnsupportedFile(filePath);
    verifyFailedToasterMessageForCorruptedFile(TestUtils.getFileName(filePath));
  }

  public void verifyFailedToasterMessageForCorruptedFile(String fileName) {
    String expected =
        fileName
            + ": File content doesn't match its extension. This may indicate a corrupted or unsafe file.";

    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    String actual =
        (String)
            js.executeScript(
                "return document.querySelector('div.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error').innerText;");

    Assert.assertEquals(actual, expected);
  }

  public void uploadJpegFile() {
    WaitFor.time(1);
    String filePath = baseDir + "/demo_test_files/download.jpeg";
    uploadUnsupportedFile(filePath);
    verifyFailedToasterMessage(TestUtils.getFileName(filePath));
  }

  public void uploadGifFile() {
    WaitFor.time(1);
    String filePath = baseDir + "/demo_test_files/sample.gif";
    uploadUnsupportedFile(filePath);
    verifyFailedToasterMessage(TestUtils.getFileName(filePath));
  }

  public void uploadXlsFile() {
    WaitFor.time(1);
    String filePath = baseDir + "/demo_test_files/file_example_XLS_5000.xls";
    uploadUnsupportedFile(filePath);
    verifyFailedToasterMessage(TestUtils.getFileName(filePath));
  }

  public void verifyMaxFileUploadFailedToasterMessage(String fileName) {
    String expected = "Each file must be under 20MB. These are too large: " + fileName;

    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    String actual =
        (String)
            js.executeScript(
                "return document.querySelector('div.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error').innerText;");

    Assert.assertEquals(actual, expected);
  }

  public void uploadMaxFileSupportedFile() {
    WaitFor.time(1);
    String filePath = baseDir + "/demo_test_files/test_files/Consulting proposal.pptx";
    uploadFile.sendKeys(filePath);
    String fileName = TestUtils.getFileName(filePath);
    verifyMaxFileUploadFailedToasterMessage(fileName);
  }

  public void editQueryWithDocument(String filePath) {
    WaitFor.time(1);
    uploadSupportedFile(filePath);
    String expected = query.getText();
    TestUtils.mouseHoverUsingActionsClass(query, "Mouse hovered on the query.");
    clickOnEditQueryIcon();
    WebElement editBoxText =
        TestBase.getDriver().findElement(By.cssSelector("textarea.message-editor"));
    String actualEditBoxText = editBoxText.getText();
    Assert.assertEquals(actualEditBoxText, expected);

    WaitFor.elementToBeClickable(continueButtonNewChatPopup);
    TestUtils.click(
        continueButtonNewChatPopup, "Clicked on the 'Save' button on the Edit input box.");
    WaitFor.time(1);
    String actualTextAfterEdit = query.getText();
    Assert.assertEquals(actualTextAfterEdit, expected);
    verifyResponse();
  }

  public void editQueryForPDFDoc() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.pdf");
  }

  public void uploadSupportedFileWithQuery(String filePath, String query) {
    WaitFor.time(1);
    TestUtils.uploadFile(uploadFile, filePath);
    WaitFor.time(3);
    enterQueryInSearchBox(query);
    WaitFor.elementToBeDisable(responseSpinner);
    verifyResponse();
  }

  public void editQueryFromDocument(String filePath, String question) {
    WaitFor.time(1);
    uploadSupportedFileWithQuery(filePath, question);
    String expected = query.getText();
    TestUtils.mouseHoverUsingActionsClass(query, "Mouse hovered on the query.");
    clickOnEditQueryIcon();
    WebElement editBoxText =
        TestBase.getDriver().findElement(By.cssSelector("textarea.message-editor"));
    String actualEditBoxText = editBoxText.getText();
    Assert.assertEquals(actualEditBoxText, expected);

    WaitFor.elementToBeClickable(continueButtonNewChatPopup);
    TestUtils.click(
        continueButtonNewChatPopup, "Clicked on the 'Save' button on the Edit input box.");
    WaitFor.time(1);
    String actualTextAfterEdit = query.getText();
    Assert.assertEquals(actualTextAfterEdit, expected);
    verifyResponse();
  }

  public void editQueryForPdfFile() {
    WaitFor.time(1);
    editQueryFromDocument(baseDir + "/demo_test_files/sample.pdf", "What is this document about?");
  }

  public void editQueryForDocxFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.docx");
  }

  public void editQuestionForDocxFile() {
    WaitFor.time(1);
    editQueryFromDocument(baseDir + "/demo_test_files/sample.docx", "What is this document about?");
  }

  public void editQueryForTxtFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.txt");
  }

  public void editQuestionForTxtFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/Selenium.txt", "What are the Key Components?");
  }

  public void editQueryForPptxFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.pptx");
  }

  public void editQuestionForPptxFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void editQueryForHtmlFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.html");
  }

  public void editQuestionForHtmlFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/PlayWright.html", "how to check version?");
  }

  public void editQueryForCsvFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.csv");
  }

  public void editQuestionForCsvFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/test_data.csv", "What are the different countries?");
  }

  public void editQueryForXlsxFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.xlsx");
  }

  public void editQuestionForXlsxFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void editQueryForJsonFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.json");
  }

  public void editQuestionForJsonFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void editQueryForXmlFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.xml");
  }

  public void editQuestionForXmlFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/test_data.xml", "What are the different tools?");
  }

  public void editQueryForJpgFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.jpg");
  }

  public void editQuestionForJpgFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/test_file.jpg", "What is image about?");
  }

  public void editQueryForPngFile() {
    WaitFor.time(1);
    editQueryWithDocument(baseDir + "/demo_test_files/sample.png");
  }

  public void editQuestionForPngFile() {
    WaitFor.time(1);
    editQueryFromDocument(
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void uploadTenFiles() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    editQueryWithDocument(
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void uploadTenFilesWithQuery() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    editQueryFromDocument(
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void uploadMoreThanTenFiles() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    String file10 = Paths.get(baseDir + "/demo_test_files/sample.xml").toAbsolutePath().toString();
    uploadUnsupportedFile(
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9 + "\n" + file10);
    verifyErrorToaster();
  }

  public void uploadFiveFiles() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    editQueryWithDocument(file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void uploadFiveFilesWithQuery() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    editQueryFromDocument(
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void verifyErrorToaster() {
    WaitFor.time(1);
    String expected = "Cannot upload more than 10 files in total.";

    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    String actual =
        (String)
            js.executeScript(
                "return document.querySelector('div.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error').innerText;");

    Assert.assertEquals(actual, expected);
  }

  public void clickOnRegenerateResponseIcon() {
    WaitFor.time(2);
    WaitFor.elementToBeClickable(regenerateResponseIcon);
    TestUtils.click(regenerateResponseIcon, "Clicked on the Regenerate Response icon.");
    String[] expected = {"Auto-Select", "GPT-4o", "GPT-5", "GPT-4o mini", "GPT-o3 mini"};
    String[] actual = new String[expected.length];
    List<WebElement> models = TestBase.getDriver().findElements(By.cssSelector("span.name"));
    for (int i = 0; i < expected.length; i++) {
      actual[i] = models.get(i).getText();
    }
    assertEquals(actual, expected);
  }

  public void verifyRegenerateResponse(String question) {
    WaitFor.time(1);
    enterQueryInSearchBox(question);
    WaitFor.time(1);
    WaitFor.elementToBeClickable(regenerateResponseIcon);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
  }

  public void selectAutoSelectOptionForRegenerateResponse() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(autoSelectOfRegenerateResponse);
    TestUtils.clickUsingActionsClass(
        autoSelectOfRegenerateResponse,
        "Clicked on the 'Auto Select' option for Regenerate Response");
  }

  public void selectGPT4oOptionForRegenerateResponse() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt_4o_OfRegenerateResponse);
    TestUtils.clickUsingJavaScriptExecutor(
        gpt_4o_OfRegenerateResponse, "Clicked on the 'GPT-4o' option for Regenerate Response");
  }

  public void selectGPT5OptionForRegenerateResponse() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt_5_OfRegenerateResponse);
    TestUtils.clickUsingJavaScriptExecutor(
        gpt_5_OfRegenerateResponse, "Clicked on the 'GPT-5' option for Regenerate Response");
  }

  public void selectGPT4oMiniOptionForRegenerateResponse() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt_4o_mini_OfRegenerateResponse);
    TestUtils.clickUsingJavaScriptExecutor(
        gpt_4o_mini_OfRegenerateResponse,
        "Clicked on the 'GPT-4o mini' option for Regenerate Response");
  }

  public void selectGPTo3MiniOptionForRegenerateResponse() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt_o3_mini_OfRegenerateResponse);
    TestUtils.clickUsingJavaScriptExecutor(
        gpt_o3_mini_OfRegenerateResponse,
        "Clicked on the 'GPT-o3 mini' option for Regenerate Response");
  }

  public void regenerateResponseUsingGPT4o() {
    WaitFor.time(1);
    String question = "How to get better leverages from you?";
    verifyRegenerateResponse(question);
    String expectedSelectedVersion = gpt_4o_OfRegenerateResponse.getText();
    selectGPT4oOptionForRegenerateResponse();
    WebElement regenerateQuestion =
        TestBase.getDriver()
            .findElement(
                By.xpath("(//div[@class='chat-section']//div[@class='message-content']//p)[2]"));
    String regenerateQuestionText = regenerateQuestion.getText();
    Assert.assertEquals(regenerateQuestionText, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void regenerateResponseUsingGPT4omini() {
    WaitFor.time(1);
    String question = "Are able to generate documents?";
    verifyRegenerateResponse(question);
    String expectedSelectedVersion = gpt_4o_mini_OfRegenerateResponse.getText();
    selectGPT4oMiniOptionForRegenerateResponse();
    WebElement regenerateQuestion =
        TestBase.getDriver()
            .findElement(
                By.xpath("(//div[@class='chat-section']//div[@class='message-content']//p)[2]"));
    String regenerateQuestionText = regenerateQuestion.getText();
    Assert.assertEquals(regenerateQuestionText, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void regenerateResponseUsingGPT5() {
    WaitFor.time(1);
    String question = "What the different features you provided?";
    verifyRegenerateResponse(question);
    String expectedSelectedVersion = gpt_5_OfRegenerateResponse.getText();
    selectGPT5OptionForRegenerateResponse();
    WebElement regenerateQuestion =
        TestBase.getDriver()
            .findElement(
                By.xpath("(//div[@class='chat-section']//div[@class='message-content']//p)[2]"));
    String regenerateQuestionText = regenerateQuestion.getText();
    Assert.assertEquals(regenerateQuestionText, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void regenerateResponseUsingGPTo3Mini() {
    WaitFor.time(1);
    String question =
        "Can you create an automation framework using Selenium, java, testng, maven and pom?";
    verifyRegenerateResponse(question);
    String expectedSelectedVersion = gpt_o3_mini_OfRegenerateResponse.getText();
    selectGPTo3MiniOptionForRegenerateResponse();
    WebElement regenerateQuestion =
        TestBase.getDriver()
            .findElement(
                By.xpath("(//div[@class='chat-section']//div[@class='message-content']//p)[2]"));
    String regenerateQuestionText = regenerateQuestion.getText();
    Assert.assertEquals(regenerateQuestionText, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void regenerateResponseUsingAutoSelect() {
    WaitFor.time(1);
    String question = "How you can help me?";
    verifyRegenerateResponse(question);
    String expectedSelectedVersion = autoSelectOfRegenerateResponse.getText();
    selectAutoSelectOptionForRegenerateResponse();
    WebElement regenerateQuestion =
        TestBase.getDriver()
            .findElement(
                By.xpath("(//div[@class='chat-section']//div[@class='message-content']//p)[2]"));
    String regenerateQuestionText = regenerateQuestion.getText();
    Assert.assertEquals(regenerateQuestionText, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void selectAutoSelectVersion() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(autoSelectVersion);
    TestUtils.clickUsingActionsClass(autoSelectVersion, "Clicked on the 'Auto Select'.");
  }

  public void selectGPT4oVersion() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt4oVersion);
    TestUtils.clickUsingJavaScriptExecutor(gpt4oVersion, "Clicked on the 'GPT-4o'.");
  }

  public void selectGPT5Version() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt5Version);
    TestUtils.clickUsingJavaScriptExecutor(gpt5Version, "Clicked on the 'GPT-5'.");
  }

  public void selectgpt4oMiniVersion() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt4oMiniVersion);
    TestUtils.clickUsingJavaScriptExecutor(gpt4oMiniVersion, "Clicked on the 'GPT-4o mini'.");
  }

  public void selectGPTo3MiniVersion() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(gpt_o3MiniVersion);
    TestUtils.clickUsingJavaScriptExecutor(gpt_o3MiniVersion, "Clicked on the 'GPT-o3 mini'.");
  }

  public void generateResponseUsingGPT4o() {
    WaitFor.time(1);
    clickOnModelDropdown();
    String expectedSelectedVersion = gpt4oVersion.getText();
    selectGPT4oVersion();
    String question = "How to get better leverages from you?";
    enterQueryInSearchBox(question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void generateResponseUsingGPT4omini() {
    WaitFor.time(1);
    clickOnModelDropdown();
    String expectedSelectedVersion = gpt4oMiniVersion.getText();
    selectgpt4oMiniVersion();
    String question = "Are able to generate documents?";
    enterQueryInSearchBox(question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void generateResponseUsingGPT5() {
    WaitFor.time(1);
    clickOnModelDropdown();
    selectGPT5Version();
    String expectedSelectedVersion = gpt5Version.getText();
    String question = "What the different features you provided?";
    enterQueryInSearchBox(question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void generateResponseUsingGPTo3Mini() {
    WaitFor.time(1);
    clickOnModelDropdown();
    String expectedSelectedVersion = gpt_o3MiniVersion.getText();
    selectGPTo3MiniVersion();
    String question =
        "Can you create an automation framework using Selenium, java, testng, maven and pom?";
    enterQueryInSearchBox(question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void generateResponseUsingAutoSelect() {
    WaitFor.time(1);
    clickOnModelDropdown();
    String expectedSelectedVersion = autoSelectVersion.getText();
    selectAutoSelectVersion();
    String question = "How you can help me?";
    WaitFor.time(1);
    enterQueryInSearchBox(question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void regenerateQueryForTenFilesWithQueryUsingAutoSelect() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void regenerateQueryForTenFilesWithoutQueryUsingAutoSelect() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void regenerateQueryForFiveFiles() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void regenerateQueryForFiveFilesWithQuery() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void regenerateQueryFromDocument(WebElement gptVersion, String filePath, String question) {
    WaitFor.time(1);
    uploadSupportedFileWithQuery(filePath, question);
    WaitFor.elementToBeClickable(regenerateResponseIcon);
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    String expectedSelectedVersion = gptVersion.getText();
    switch (expectedSelectedVersion) {
      case "Auto-Select":
        selectAutoSelectOptionForRegenerateResponse();
        break;
      case "GPT-4o":
        selectGPT4oOptionForRegenerateResponse();
        break;
      case "GPT-4o mini":
        selectGPT4oMiniOptionForRegenerateResponse();
        break;
      case "GPT-o3 mini":
        selectGPTo3MiniOptionForRegenerateResponse();
        break;
      case "GPT-5":
        selectGPT5OptionForRegenerateResponse();
        break;
    }
    WebElement regenerateQuestion =
        TestBase.getDriver()
            .findElement(
                By.xpath("(//div[@class='chat-section']//div[@class='message-content']//p)[2]"));
    String regenerateQuestionText = regenerateQuestion.getText();
    Assert.assertEquals(regenerateQuestionText, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void regenerateQueryFromDocumentWithoutQuery(WebElement gptVersion, String filePath) {
    WaitFor.time(1);
    uploadSupportedFile(filePath);
    WaitFor.elementToBeClickable(regenerateResponseIcon);
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    String expectedSelectedVersion = gptVersion.getText();
    switch (expectedSelectedVersion) {
      case "Auto-Select":
        selectAutoSelectOptionForRegenerateResponse();
        break;
      case "GPT-4o":
        selectGPT4oOptionForRegenerateResponse();
        break;
      case "GPT-4o mini":
        selectGPT4oMiniOptionForRegenerateResponse();
        break;
      case "GPT-o3 mini":
        selectGPTo3MiniOptionForRegenerateResponse();
        break;
      case "GPT-5":
        selectGPT5OptionForRegenerateResponse();
        break;
    }
    WebElement regenerateQuestion =
        TestBase.getDriver()
            .findElement(
                By.xpath("(//div[@class='chat-section']//div[@class='message-content']//p)[2]"));
    String regenerateQuestionText = regenerateQuestion.getText();
    String question = query.getText();
    Assert.assertEquals(regenerateQuestionText, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void regenerateQueryForPdfFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.pdf");
  }

  public void regenerateQuestionForPdfFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/sample.pdf",
        "What is this document about?");
  }

  public void regenerateQueryForDocxFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.docx");
  }

  public void regenerateQuestionForDocxFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/sample.docx",
        "What is this document about?");
  }

  public void regenerateQueryForTxtFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.txt");
  }

  public void regenerateQuestionForTxtFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void regenerateQueryForPptxFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.pptx");
  }

  public void regenerateQuestionForPptxFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void regenerateQueryForHtmlFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.html");
  }

  public void regenerateQuestionForHtmlFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void regenerateQueryForCsvFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.csv");
  }

  public void regenerateQuestionForCsvFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void regenerateQueryForXlsxFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void regenerateQuestionForXlsxFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void regenerateQueryForJsonFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.json");
  }

  public void regenerateQuestionForJsonFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void regenerateQueryForXmlFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.xml");
  }

  public void regenerateQuestionForXmlFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void regenerateQueryForJpgFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.jpg");
  }

  public void regenerateQuestionForJpgFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void regenerateQueryForPngFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        autoSelectOfRegenerateResponse, baseDir + "/demo_test_files/sample.png");
  }

  public void regenerateQuestionForPngFileUsingAutoSelect() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        autoSelectOfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void generateQueryForDocument(WebElement gptVersion, String filePath, String question) {
    WaitFor.time(1);
    clickOnModelDropdown();
    String expectedSelectedVersion = gptVersion.getText();
    switch (expectedSelectedVersion) {
      case "Auto-Select":
        selectAutoSelectVersion();
        break;
      case "GPT-4o":
        selectGPT4oVersion();
        break;
      case "GPT-4o mini":
        selectgpt4oMiniVersion();
        break;
      case "GPT-o3 mini":
        selectGPTo3MiniVersion();
        break;
      case "GPT-5":
        selectGPT5Version();
        break;
    }
    uploadSupportedFileWithQuery(filePath, question);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void generateQueryForDocumentWithoutQuery(WebElement gptVersion, String filePath) {
    WaitFor.time(1);
    clickOnModelDropdown();
    String expectedSelectedVersion = gptVersion.getText();
    switch (expectedSelectedVersion) {
      case "Auto-Select":
        selectAutoSelectVersion();
        break;
      case "GPT-4o":
        selectGPT4oVersion();
        break;
      case "GPT-4o mini":
        selectgpt4oMiniVersion();
        break;
      case "GPT-o3 mini":
        selectGPTo3MiniVersion();
        break;
      case "GPT-5":
        selectGPT5Version();
        break;
    }
    uploadSupportedFile(filePath);
    verifyResponse();
    WaitFor.time(1);
    clickOnRegenerateResponseIcon();
    WebElement selectedVersion =
        TestBase.getDriver()
            .findElement(
                By.xpath(
                    "//div[@class='selected-icon']/preceding-sibling::div//span[@class='name']"));
    String actualSelectedVersion = selectedVersion.getText();
    Assert.assertEquals(actualSelectedVersion, expectedSelectedVersion);
  }

  public void generateQueryForPdfFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.pdf");
  }

  public void generateQuestionForPdfFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion, baseDir + "/demo_test_files/sample.pdf", "What is this document about?");
  }

  public void generateQueryForDocxFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.docx");
  }

  public void generateQuestionForDocxFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/sample.docx",
        "What is this document about?");
  }

  public void generateQueryForTxtFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.txt");
  }

  public void generateQuestionForTxtFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void generateQueryForPptxFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.pptx");
  }

  public void generateQuestionForPptxFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void generateQueryForHtmlFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.html");
  }

  public void generateQuestionForHtmlFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void generateQueryForCsvFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.csv");
  }

  public void generateQuestionForCsvFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void generateQueryForXlsxFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void generateQuestionForXlsxFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void generateQueryForJsonFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.json");
  }

  public void generateQuestionForJsonFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void generateQueryForXmlFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.xml");
  }

  public void generateQuestionForXmlFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void generateQueryForJpgFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.jpg");
  }

  public void generateQuestionForJpgFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void generateQueryForPngFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, baseDir + "/demo_test_files/sample.png");
  }

  public void generateQuestionForPngFileUsingAutoSelect() {
    WaitFor.time(1);
    generateQueryForDocument(
        autoSelectVersion,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void generateQueryForTenFilesWithQueryUsingAutoSelect() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        autoSelectVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void generateQueryForTenFilesWithoutQueryUsingAutoSelect() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void generateQueryForFiveFiles() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        autoSelectVersion, file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void generateQueryForFiveFilesWithQuery() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        autoSelectVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void regenerateQueryForPdfFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pdf");
  }

  public void regenerateQuestionForPdfFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.pdf",
        "What is this document about?");
  }

  public void regenerateQueryForDocxFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.docx");
  }

  public void regenerateQuestionForDocxFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.docx",
        "What is this document about?");
  }

  public void regenerateQueryForTxtFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.txt");
  }

  public void regenerateQuestionForTxtFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void regenerateQueryForPptxFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pptx");
  }

  public void regenerateQuestionForPptxFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void regenerateQueryForHtmlFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.html");
  }

  public void regenerateQuestionForHtmlFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void regenerateQueryForCsvFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.csv");
  }

  public void regenerateQuestionForCsvFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void regenerateQueryForXlsxFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void regenerateQuestionForXlsxFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void regenerateQueryForJsonFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.json");
  }

  public void regenerateQuestionForJsonFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void regenerateQueryForXmlFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xml");
  }

  public void regenerateQuestionForXmlFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void regenerateQueryForJpgFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.jpg");
  }

  public void regenerateQuestionForJpgFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void regenerateQueryForPngFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse, baseDir + "/demo_test_files/sample.png");
  }

  public void regenerateQuestionForPngFileUsingGpt4o() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void regenerateQueryForTenFilesWithQueryUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void regenerateQueryForTenFilesWithoutQueryUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void regenerateQueryForFiveFilesUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void regenerateQueryForFiveFilesWithQueryUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_4o_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void regenerateQueryForPdfFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pdf");
  }

  public void regenerateQuestionForPdfFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.pdf",
        "What is this document about?");
  }

  public void regenerateQueryForDocxFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.docx");
  }

  public void regenerateQuestionForDocxFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.docx",
        "What is this document about?");
  }

  public void regenerateQueryForTxtFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.txt");
  }

  public void regenerateQuestionForTxtFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void regenerateQueryForPptxFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pptx");
  }

  public void regenerateQuestionForPptxFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void regenerateQueryForHtmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.html");
  }

  public void regenerateQuestionForHtmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void regenerateQueryForCsvFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.csv");
  }

  public void regenerateQuestionForCsvFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void regenerateQueryForXlsxFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void regenerateQuestionForXlsxFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void regenerateQueryForJsonFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.json");
  }

  public void regenerateQuestionForJsonFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void regenerateQueryForXmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xml");
  }

  public void regenerateQuestionForXmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void regenerateQueryForJpgFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.jpg");
  }

  public void regenerateQuestionForJpgFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void regenerateQueryForPngFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.png");
  }

  public void regenerateQuestionForPngFileUsingGpt4oMini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void regenerateQueryForTenFilesWithQueryUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void regenerateQueryForTenFilesWithoutQueryUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void regenerateQueryForFiveFilesUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_4o_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void regenerateQueryForFiveFilesWithQueryUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_4o_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void regenerateQueryForPdfFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pdf");
  }

  public void regenerateQuestionForPdfFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.pdf",
        "What is this document about?");
  }

  public void regenerateQueryForDocxFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.docx");
  }

  public void regenerateQuestionForDocxFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.docx",
        "What is this document about?");
  }

  public void regenerateQueryForTxtFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.txt");
  }

  public void regenerateQuestionForTxtFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void regenerateQueryForPptxFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pptx");
  }

  public void regenerateQuestionForPptxFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void regenerateQueryForHtmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.html");
  }

  public void regenerateQuestionForHtmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void regenerateQueryForCsvFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.csv");
  }

  public void regenerateQuestionForCsvFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void regenerateQueryForXlsxFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void regenerateQuestionForXlsxFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void regenerateQueryForJsonFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.json");
  }

  public void regenerateQuestionForJsonFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void regenerateQueryForXmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xml");
  }

  public void regenerateQuestionForXmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void regenerateQueryForJpgFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.jpg");
  }

  public void regenerateQuestionForJpgFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void regenerateQueryForPngFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse, baseDir + "/demo_test_files/sample.png");
  }

  public void regenerateQuestionForPngFileUsingGpto3Mini() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void regenerateQueryForTenFilesWithQueryUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void regenerateQueryForTenFilesWithoutQueryUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void regenerateQueryForFiveFilesUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_o3_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void regenerateQueryForFiveFilesWithQueryUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_o3_mini_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void regenerateQueryForPdfFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pdf");
  }

  public void regenerateQuestionForPdfFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.pdf",
        "What is this document about?");
  }

  public void regenerateQueryForDocxFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.docx");
  }

  public void regenerateQuestionForDocxFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/sample.docx",
        "What is this document about?");
  }

  public void regenerateQueryForTxtFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.txt");
  }

  public void regenerateQuestionForTxtFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void regenerateQueryForPptxFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.pptx");
  }

  public void regenerateQuestionForPptxFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void regenerateQueryForHtmlFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.html");
  }

  public void regenerateQuestionForHtmlFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void regenerateQueryForCsvFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.csv");
  }

  public void regenerateQuestionForCsvFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void regenerateQueryForXlsxFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void regenerateQuestionForXlsxFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void regenerateQueryForJsonFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.json");
  }

  public void regenerateQuestionForJsonFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void regenerateQueryForXmlFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.xml");
  }

  public void regenerateQuestionForXmlFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void regenerateQueryForJpgFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.jpg");
  }

  public void regenerateQuestionForJpgFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void regenerateQueryForPngFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse, baseDir + "/demo_test_files/sample.png");
  }

  public void regenerateQuestionForPngFileUsingGpt5() {
    WaitFor.time(1);
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void regenerateQueryForTenFilesWithQueryUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void regenerateQueryForTenFilesWithoutQueryUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void regenerateQueryForFiveFilesUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    regenerateQueryFromDocumentWithoutQuery(
        gpt_5_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void regenerateQueryForFiveFilesWithQueryUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    regenerateQueryFromDocument(
        gpt_5_OfRegenerateResponse,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void generateQueryForPdfFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.pdf");
  }

  public void generateQuestionForPdfFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion, baseDir + "/demo_test_files/sample.pdf", "What is this document about?");
  }

  public void generateQueryForDocxFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.docx");
  }

  public void generateQuestionForDocxFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion, baseDir + "/demo_test_files/sample.docx", "What is this document about?");
  }

  public void generateQueryForTxtFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.txt");
  }

  public void generateQuestionForTxtFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void generateQueryForPptxFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.pptx");
  }

  public void generateQuestionForPptxFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void generateQueryForHtmlFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.html");
  }

  public void generateQuestionForHtmlFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void generateQueryForCsvFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.csv");
  }

  public void generateQuestionForCsvFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void generateQueryForXlsxFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void generateQuestionForXlsxFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void generateQueryForJsonFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.json");
  }

  public void generateQuestionForJsonFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void generateQueryForXmlFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.xml");
  }

  public void generateQuestionForXmlFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void generateQueryForJpgFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.jpg");
  }

  public void generateQuestionForJpgFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void generateQueryForPngFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oVersion, baseDir + "/demo_test_files/sample.png");
  }

  public void generateQuestionForPngFileUsingGpt4o() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oVersion,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void generateQueryForTenFilesWithQueryUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt4oVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void generateQueryForTenFilesWithoutQueryUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt4oVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void generateQueryForFiveFilesUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt4oVersion, file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void generateQueryForFiveFilesWithQueryUsingGpt4o() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt4oVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void generateQueryForPdfFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oMiniVersion, baseDir + "/demo_test_files/sample.pdf");
  }

  public void generateQuestionForPdfFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion, baseDir + "/demo_test_files/sample.pdf", "What is this document about?");
  }

  public void generateQueryForDocxFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt4oMiniVersion, baseDir + "/demo_test_files/sample.docx");
  }

  public void generateQuestionForDocxFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion, baseDir + "/demo_test_files/sample.docx", "What is this document about?");
  }

  public void generateQueryForTxtFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oMiniVersion, baseDir + "/demo_test_files/sample.txt");
  }

  public void generateQuestionForTxtFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void generateQueryForPptxFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt4oMiniVersion, baseDir + "/demo_test_files/sample.pptx");
  }

  public void generateQuestionForPptxFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void generateQueryForHtmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt4oMiniVersion, baseDir + "/demo_test_files/sample.html");
  }

  public void generateQuestionForHtmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void generateQueryForCsvFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oMiniVersion, baseDir + "/demo_test_files/sample.csv");
  }

  public void generateQuestionForCsvFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void generateQueryForXlsxFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt4oMiniVersion, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void generateQuestionForXlsxFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void generateQueryForJsonFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt4oMiniVersion, baseDir + "/demo_test_files/sample.json");
  }

  public void generateQuestionForJsonFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void generateQueryForXmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oMiniVersion, baseDir + "/demo_test_files/sample.xml");
  }

  public void generateQuestionForXmlFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void generateQueryForJpgFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oMiniVersion, baseDir + "/demo_test_files/sample.jpg");
  }

  public void generateQuestionForJpgFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void generateQueryForPngFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt4oMiniVersion, baseDir + "/demo_test_files/sample.png");
  }

  public void generateQuestionForPngFileUsingGpt4oMini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt4oMiniVersion,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void generateQueryForTenFilesWithQueryUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt4oMiniVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void generateQueryForTenFilesWithoutQueryUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt4oMiniVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void generateQueryForFiveFilesUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt4oMiniVersion, file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void generateQueryForFiveFilesWithQueryUsingGpt4oMini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt4oMiniVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void generateQueryForPdfFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.pdf");
  }

  public void generateQuestionForPdfFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.pdf", "What is this document about?");
  }

  public void generateQueryForDocxFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.docx");
  }

  public void generateQuestionForDocxFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/sample.docx",
        "What is this document about?");
  }

  public void generateQueryForTxtFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.txt");
  }

  public void generateQuestionForTxtFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void generateQueryForPptxFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.pptx");
  }

  public void generateQuestionForPptxFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void generateQueryForHtmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.html");
  }

  public void generateQuestionForHtmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void generateQueryForCsvFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.csv");
  }

  public void generateQuestionForCsvFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void generateQueryForXlsxFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void generateQuestionForXlsxFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void generateQueryForJsonFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.json");
  }

  public void generateQuestionForJsonFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void generateQueryForXmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.xml");
  }

  public void generateQuestionForXmlFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void generateQueryForJpgFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.jpg");
  }

  public void generateQuestionForJpgFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/test_file.jpg",
        "What is image about?");
  }

  public void generateQueryForPngFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, baseDir + "/demo_test_files/sample.png");
  }

  public void generateQuestionForPngFileUsingGpto3Mini() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt_o3MiniVersion,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void generateQueryForTenFilesWithQueryUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt_o3MiniVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void generateQueryForTenFilesWithoutQueryUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void generateQueryForFiveFilesUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt_o3MiniVersion, file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void generateQueryForFiveFilesWithQueryUsingGpto3Mini() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt_o3MiniVersion,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void generateQueryForPdfFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.pdf");
  }

  public void generateQuestionForPdfFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version, baseDir + "/demo_test_files/sample.pdf", "What is this document about?");
  }

  public void generateQueryForDocxFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.docx");
  }

  public void generateQuestionForDocxFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version, baseDir + "/demo_test_files/sample.docx", "What is this document about?");
  }

  public void generateQueryForTxtFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.txt");
  }

  public void generateQuestionForTxtFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/Selenium.txt",
        "What are the Key Components?");
  }

  public void generateQueryForPptxFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.pptx");
  }

  public void generateQuestionForPptxFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/How_to_find_good_bugs.pptx",
        "What are the different areas that we do not test?");
  }

  public void generateQueryForHtmlFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.html");
  }

  public void generateQuestionForHtmlFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/PlayWright.html",
        "how to check version?");
  }

  public void generateQueryForCsvFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.csv");
  }

  public void generateQuestionForCsvFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/test_data.csv",
        "What are the different countries?");
  }

  public void generateQueryForXlsxFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.xlsx");
  }

  public void generateQuestionForXlsxFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/test_data.xlsx",
        "What are the different countries?");
  }

  public void generateQueryForJsonFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.json");
  }

  public void generateQuestionForJsonFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/sample_test_data.json",
        "What are the different roles?");
  }

  public void generateQueryForXmlFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.xml");
  }

  public void generateQuestionForXmlFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/test_data.xml",
        "What are the different tools?");
  }

  public void generateQueryForJpgFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.jpg");
  }

  public void generateQuestionForJpgFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version, baseDir + "/demo_test_files/test_files/test_file.jpg", "What is image about?");
  }

  public void generateQueryForPngFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocumentWithoutQuery(gpt5Version, baseDir + "/demo_test_files/sample.png");
  }

  public void generateQuestionForPngFileUsingGpt5() {
    WaitFor.time(1);
    generateQueryForDocument(
        gpt5Version,
        baseDir + "/demo_test_files/test_files/test_PNG.png",
        "Can you give the color palette used in the image?");
  }

  public void generateQueryForTenFilesWithQueryUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt5Version,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9,
        "Summerise this documents.");
  }

  public void generateQueryForTenFilesWithoutQueryUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    String file5 = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file6 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file7 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file8 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file9 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt5Version,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4 + "\n" + file5 + "\n"
            + file6 + "\n" + file7 + "\n" + file8 + "\n" + file9);
  }

  public void generateQueryForFiveFilesUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.csv").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.docx").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.html").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.jpg").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.json").toAbsolutePath().toString();
    generateQueryForDocumentWithoutQuery(
        gpt5Version, file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4);
  }

  public void generateQueryForFiveFilesWithQueryUsingGpt5() {
    WaitFor.time(1);
    String file = Paths.get(baseDir + "/demo_test_files/sample.pdf").toAbsolutePath().toString();
    String file1 = Paths.get(baseDir + "/demo_test_files/sample.png").toAbsolutePath().toString();
    String file2 = Paths.get(baseDir + "/demo_test_files/sample.pptx").toAbsolutePath().toString();
    String file3 = Paths.get(baseDir + "/demo_test_files/sample.txt").toAbsolutePath().toString();
    String file4 = Paths.get(baseDir + "/demo_test_files/sample.xlsx").toAbsolutePath().toString();
    generateQueryForDocument(
        gpt5Version,
        file + "\n" + file1 + "\n" + file2 + "\n" + file3 + "\n" + file4,
        "Summerise this documents.");
  }

  public void clickOnReadAloudIcon() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(readAloudIcon);
    TestUtils.mouseHoverUsingActionsClass(readAloudIcon, "Mouse hovered on the 'Read Aloud' icon.");
    TestUtils.clickUsingJavaScriptExecutor(readAloudIcon, "Clicked on the 'Read Aloud' icon.");
  }

  public void verifyReadAloudUsingJavascriptExecutor() {
    WaitFor.time(1);
    enterQueryInSearchBox("How you can help me?");
    verifyResponse();
    clickOnReadAloudIcon();
    WaitFor.time(5);
    JavascriptExecutor js = (JavascriptExecutor) TestBase.getDriver();
    Boolean isSpeaking = (Boolean) js.executeScript("return window.speechSynthesis.speaking;");
    if (Boolean.TRUE.equals(isSpeaking)) {
      System.out.println("✅ Read Aloud started successfully.");
    } else {
      System.out.println("❌ Read Aloud did not start.");
      Assert.fail();
    }
    WaitFor.time(5);
    js.executeScript("window.speechSynthesis.cancel();");
  }

  public void verifyReadAloudUsingConsoleLog() {
    WaitFor.time(1);
    enterQueryInSearchBox("How you can help me?");
    verifyResponse();
    clickOnReadAloudIcon();
    WaitFor.time(5);
    clickOnReadAloudIcon();
    LogEntries logs = TestBase.getDriver().manage().logs().get(LogType.BROWSER);
    boolean ttsErrorDetected = false;

    for (LogEntry entry : logs) {
      System.out.println(entry.getMessage());
      WaitFor.time(2);
      if (entry.getMessage().contains("Text-to-Speech error")) {
        ttsErrorDetected = true;
        System.out.println("Detected Text-to-Speech error in console logs.");
      }
    }

    if (ttsErrorDetected) {
      System.out.println("✅ Read Aloud work successfully.");
    } else {
      System.out.println("❌ Read Aloud did not working.");
      Assert.fail();
    }
  }

  public void clickOnSkipIntroButton() {
    WaitFor.time(1);
    WaitFor.elementToBeClickable(skipIntroButton);
    TestUtils.clickUsingJavaScriptExecutor(skipIntroButton, "Clicked on the 'Skip' intro button.");
  }
}
