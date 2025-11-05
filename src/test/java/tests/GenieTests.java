package tests;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GenieChatPage;
import pages.LoginPage;
import pages.UserGuidePage;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, listener.iTestListener.class})
public class GenieTests extends TestBase {

  LoginPage loginPage;
  GenieChatPage genieChatPage;
  UserGuidePage userGuidePage;

  //  @BeforeMethod(groups = {"smoke", "fileUpload", "generateResponse","regenerateResponse"})
  @BeforeMethod(alwaysRun = true)
  public void startUp() {
    TestBase.initialization();
    loginPage = new LoginPage();
    loginPage.login();
    genieChatPage = new GenieChatPage();
    genieChatPage.clickOnSkipIntroButton();
    genieChatPage.verifyGenieDashboard();
    userGuidePage = new UserGuidePage();
  }

  @Test(groups = "smoke")
  public void verifyModelsDropdown() {
    genieChatPage.clickOnModelDropdown();
  }

  @Test(groups = "smoke")
  public void verifySettingsIcon() {
    genieChatPage.clickOnSettingsIcon();
  }

  @Test(groups = "smoke")
  public void verifyUserGuideMenuOption() {
    genieChatPage.clickOnUserGuide();
  }

  @Test(groups = "smoke")
  public void verifyWordsmithButton() {
    genieChatPage.mouseHoveredOnWordsmith();
    genieChatPage.clickOnWordsmith();
  }

  @Test(groups = "smoke")
  public void verifyAgronomicaButton() {
    genieChatPage.mouseHoveredOnAgronomica();
    genieChatPage.clickOnAgronomica();
  }

  @Test(groups = "smoke")
  public void verifyRegulatrixButton() {
    genieChatPage.mouseHoveredOnRegulatrix();
    genieChatPage.clickOnRegulatrix();
  }

  @Test(groups = "smoke")
  public void verifyAddNewChatButton() {
    genieChatPage.clickOnAddNewChatButton();
  }

  @Test(groups = "smoke")
  public void verifyLogoutPopup() {
    genieChatPage.clickOnLogoutMenuOption();
  }

  @Test(groups = "smoke")
  public void verifyResponseForSuspiciousQuery() {
    genieChatPage.checkResponseForSuspiciousQuery();
  }

  @Test(groups = "smoke")
  public void verifyLikeResponseFeature() {
    genieChatPage.clickOnResponseLikeButton();
  }

  @Test(groups = "smoke")
  public void verifyDislikeResponseFeature() {
    genieChatPage.clickOnResponseDisLikeButton();
  }

  @Test(groups = "smoke")
  public void verifyCopyResponseFeature() {
    genieChatPage.clickOnResponseCopyButton();
  }

  @Test(groups = "smoke")
  public void verifyEndChatPopupForWordsmith() {
    genieChatPage.clickOnWordsmith();
    genieChatPage.clickOnEndChatButton();
    genieChatPage.verifyEndChatPopupForWordsmith();
  }

  @Test(groups = "smoke")
  public void verifyEndChatPopupForAgronomica() {
    genieChatPage.clickOnAgronomica();
    genieChatPage.clickOnEndChatButton();
    genieChatPage.verifyEndChatPopupForAgronomica();
  }

  @Test(groups = "smoke")
  public void verifyEndChatPopupForRegulatrix() {
    genieChatPage.clickOnRegulatrix();
    genieChatPage.clickOnEndChatButton();
    genieChatPage.verifyEndChatPopupForRegulatrix();
  }

  @Test(groups = "smoke")
  public void verifyRenameThreadForClearTitle() {
    genieChatPage.verifyRenameWarningAlert();
  }

  @Test(groups = "smoke")
  public void verifyUpdateQuery() {
    genieChatPage.renameQuery();
  }

  @Test(groups = "smoke")
  public void verifyFeedBackFormLink() {
    genieChatPage.clickOnFeedback();
  }

  @Test(groups = "smoke")
  public void verifyUserGuidePage() {
    genieChatPage.clickOnUserGuide();
    genieChatPage.clickOnVideoTutorialsOption();
    userGuidePage.verifyUserGuidePage();
  }

  @Test(groups = "smoke")
  public void verifyUserGuideDocument() {
    genieChatPage.clickOnUserGuide();
    genieChatPage.clickOnVideoTutorialsOption();
    userGuidePage.clickOnUserGuideButton();
  }

  @Test(groups = "smoke")
  public void verifyFaqsDocument() {
    genieChatPage.clickOnUserGuide();
    genieChatPage.clickOnVideoTutorialsOption();
    userGuidePage.clickOnFaqsButton();
  }

  @Test(groups = "smoke")
  public void verifyBackButton() {
    genieChatPage.clickOnUserGuide();
    genieChatPage.clickOnVideoTutorialsOption();
    userGuidePage.clickOnBackButton();
  }

  @Test(groups = "smoke")
  public void verifyModelSelectionGuidePopup() {
    genieChatPage.verifyModelSelectionGuidePopup();
  }

  @Test(groups = "smoke")
  public void verifyAIUsagePolicyPopup() {
    genieChatPage.verifyAIUsagePolicyPopup();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFilesForDocFile() {
    genieChatPage.uploadDocFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFilesForGifFile() {
    genieChatPage.uploadGifFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFilesForCorruptedFile() {
    genieChatPage.uploadCorruptedFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFilesForExeFile() {
    genieChatPage.uploadExeFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFilesForJpegFile() {
    genieChatPage.uploadJpegFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFilesForXlsFile() {
    genieChatPage.uploadXlsFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyMaxFileUploadFailedToasterMessage() {
    genieChatPage.uploadMaxFileSupportedFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForPDFWithoutQuery() {
    genieChatPage.editQueryForPDFDoc();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForPDFWithQuery() {
    genieChatPage.editQueryForPdfFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForDocxWithoutQuery() {
    genieChatPage.editQueryForDocxFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForDocxWithQuery() {
    genieChatPage.editQuestionForDocxFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForTxtWithoutQuery() {
    genieChatPage.editQueryForTxtFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForTxtWithQuery() {
    genieChatPage.editQuestionForTxtFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForPptxWithoutQuery() {
    genieChatPage.editQueryForPptxFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForPptxWithQuery() {
    genieChatPage.editQuestionForPptxFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForHtmlWithoutQuery() {
    genieChatPage.editQueryForHtmlFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForHtmlWithQuery() {
    genieChatPage.editQuestionForHtmlFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForCsvWithoutQuery() {
    genieChatPage.editQueryForCsvFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForCsvWithQuery() {
    genieChatPage.editQuestionForCsvFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForXlsxWithoutQuery() {
    genieChatPage.editQueryForXlsxFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForXlsxWithQuery() {
    genieChatPage.editQuestionForXlsxFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForJsonWithoutQuery() {
    genieChatPage.editQueryForJsonFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForJsonWithQuery() {
    genieChatPage.editQuestionForJsonFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForXmlWithoutQuery() {
    genieChatPage.editQueryForXmlFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForXmlWithQuery() {
    genieChatPage.editQuestionForXmlFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForJpgWithoutQuery() {
    genieChatPage.editQueryForJpgFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForJpgWithQuery() {
    genieChatPage.editQuestionForJpgFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForPngWithoutQuery() {
    genieChatPage.editQueryForPngFile();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyEditQueryFeatureForPngWithQuery() {
    genieChatPage.editQuestionForPngFile();
  }

//  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFeatureFor10Files() {
    genieChatPage.uploadTenFiles();
  }

//  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFeatureFor10FilesWithQuery() {
    genieChatPage.uploadTenFilesWithQuery();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFeatureForFiveFiles() {
    genieChatPage.uploadFiveFiles();
  }

  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFeatureForFiveFilesWithQuery() {
    genieChatPage.uploadFiveFilesWithQuery();
  }

//  @Test(groups = {"fileUpload", "smoke"})
  public void verifyUploadFeatureForMoreThan10Files() {
    genieChatPage.uploadMoreThanTenFiles();
  }

  @Test(groups = {"regenerateResponse", "smoke"})
  public void verifyRegenerateResponseUsingGPT4o() {
    genieChatPage.regenerateResponseUsingGPT4o();
  }

  @Test(groups = {"regenerateResponse", "smoke"})
  public void verifyRegenerateResponseUsingGPT4oMini() {
    genieChatPage.regenerateResponseUsingGPT4omini();
  }

  @Test(groups = {"regenerateResponse", "smoke"})
  public void verifyRegenerateResponseUsingGPT5() {
    genieChatPage.regenerateResponseUsingGPT5();
  }

  @Test(groups = {"regenerateResponse", "smoke"})
  public void verifyRegenerateResponseUsingGPTo3Mini() {
    genieChatPage.regenerateResponseUsingGPTo3Mini();
  }

  @Test(groups = {"regenerateResponse", "smoke"})
  public void verifyRegenerateResponseUsingAutoSelect() {
    genieChatPage.regenerateResponseUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "smoke"})
  public void verifyGenerateResponseUsingGPT4o() {
    genieChatPage.generateResponseUsingGPT4o();
  }

  @Test(groups = {"generateResponse", "smoke"})
  public void verifyGenerateResponseUsingGPT4oMini() {
    genieChatPage.generateResponseUsingGPT4omini();
  }

  @Test(groups = {"generateResponse", "smoke"})
  public void verifyGenerateResponseUsingGPT5() {
    genieChatPage.generateResponseUsingGPT5();
  }

  @Test(groups = {"generateResponse", "smoke"})
  public void verifyGenerateResponseUsingGPTo3Mini() {
    genieChatPage.generateResponseUsingGPTo3Mini();
  }

  @Test(groups = {"generateResponse", "smoke"})
  public void verifyGenerateResponseUsingAutoSelect() {
    genieChatPage.generateResponseUsingAutoSelect();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingAutoSelectWithQuery() {
    genieChatPage.regenerateQueryForTenFilesWithQueryUsingAutoSelect();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingAutoSelectWithoutQuery() {
    genieChatPage.regenerateQueryForTenFilesWithoutQueryUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingAutoSelectWithQuery() {
    genieChatPage.regenerateQueryForFiveFilesWithQuery();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingAutoSelectWithoutQuery() {
    genieChatPage.regenerateQueryForFiveFiles();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPdfFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForPdfFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPdfFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForPdfFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForDocxFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForDocxFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForDocxFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForDocxFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForTxtFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForTxtFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForTxtFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForTxtFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPptxFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForPptxFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPptxFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForPptxFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForHtmlFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForHtmlFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForHtmlFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForHtmlFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForCsvFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForCsvFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForCsvFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForCsvFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXlsxFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForXlsxFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXlsxFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForXlsxFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJsonFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForJsonFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJsonFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForJsonFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXmlFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForXmlFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXmlFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForXmlFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJpgFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForJpgFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJpgFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForJpgFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPngFileUsingAutoSelect() {
    genieChatPage.regenerateQueryForPngFileUsingAutoSelect();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPngFileUsingAutoSelect() {
    genieChatPage.regenerateQuestionForPngFileUsingAutoSelect();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingAutoSelectWithQuery() {
    genieChatPage.generateQueryForTenFilesWithQueryUsingAutoSelect();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingAutoSelectWithoutQuery() {
    genieChatPage.generateQueryForTenFilesWithoutQueryUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingAutoSelectWithQuery() {
    genieChatPage.generateQueryForFiveFilesWithQuery();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingAutoSelectWithoutQuery() {
    genieChatPage.generateQueryForFiveFiles();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPdfFileUsingAutoSelect() {
    genieChatPage.generateQueryForPdfFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPdfFileUsingAutoSelect() {
    genieChatPage.generateQuestionForPdfFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForDocxFileUsingAutoSelect() {
    genieChatPage.generateQueryForDocxFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForDocxFileUsingAutoSelect() {
    genieChatPage.generateQuestionForDocxFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForTxtFileUsingAutoSelect() {
    genieChatPage.generateQueryForTxtFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForTxtFileUsingAutoSelect() {
    genieChatPage.generateQuestionForTxtFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPptxFileUsingAutoSelect() {
    genieChatPage.generateQueryForPptxFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPptxFileUsingAutoSelect() {
    genieChatPage.generateQuestionForPptxFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForHtmlFileUsingAutoSelect() {
    genieChatPage.generateQueryForHtmlFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForHtmlFileUsingAutoSelect() {
    genieChatPage.generateQuestionForHtmlFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForCsvFileUsingAutoSelect() {
    genieChatPage.generateQueryForCsvFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForCsvFileUsingAutoSelect() {
    genieChatPage.generateQuestionForCsvFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXlsxFileUsingAutoSelect() {
    genieChatPage.generateQueryForXlsxFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXlsxFileUsingAutoSelect() {
    genieChatPage.generateQuestionForXlsxFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJsonFileUsingAutoSelect() {
    genieChatPage.generateQueryForJsonFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJsonFileUsingAutoSelect() {
    genieChatPage.generateQuestionForJsonFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXmlFileUsingAutoSelect() {
    genieChatPage.generateQueryForXmlFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXmlFileUsingAutoSelect() {
    genieChatPage.generateQuestionForXmlFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJpgFileUsingAutoSelect() {
    genieChatPage.generateQueryForJpgFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJpgFileUsingAutoSelect() {
    genieChatPage.generateQuestionForJpgFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPngFileUsingAutoSelect() {
    genieChatPage.generateQueryForPngFileUsingAutoSelect();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPngFileUsingAutoSelect() {
    genieChatPage.generateQuestionForPngFileUsingAutoSelect();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpt5WithQuery() {
    genieChatPage.regenerateQueryForTenFilesWithQueryUsingGpt5();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpt5WithoutQuery() {
    genieChatPage.regenerateQueryForTenFilesWithoutQueryUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpt5WithQuery() {
    genieChatPage.regenerateQueryForFiveFilesWithQueryUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpt5WithoutQuery() {
    genieChatPage.regenerateQueryForFiveFilesUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPdfFileUsingGpt5() {
    genieChatPage.regenerateQueryForPdfFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPdfFileUsingGpt5() {
    genieChatPage.regenerateQuestionForPdfFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForDocxFileUsingGpt5() {
    genieChatPage.regenerateQueryForDocxFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForDocxFileUsingGpt5() {
    genieChatPage.regenerateQuestionForDocxFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForTxtFileUsingGpt5() {
    genieChatPage.regenerateQueryForTxtFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForTxtFileUsingGpt5() {
    genieChatPage.regenerateQuestionForTxtFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPptxFileUsingGpt5() {
    genieChatPage.regenerateQueryForPptxFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPptxFileUsingGpt5() {
    genieChatPage.regenerateQuestionForPptxFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForHtmlFileUsingGpt5() {
    genieChatPage.regenerateQueryForHtmlFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForHtmlFileUsingGpt5() {
    genieChatPage.regenerateQuestionForHtmlFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForCsvFileUsingGpt5() {
    genieChatPage.regenerateQueryForCsvFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForCsvFileUsingGpt5() {
    genieChatPage.regenerateQuestionForCsvFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXlsxFileUsingGpt5() {
    genieChatPage.regenerateQueryForXlsxFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXlsxFileUsingGpt5() {
    genieChatPage.regenerateQuestionForXlsxFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJsonFileUsingGpt5() {
    genieChatPage.regenerateQueryForJsonFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJsonFileUsingGpt5() {
    genieChatPage.regenerateQuestionForJsonFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXmlFileUsingGpt5() {
    genieChatPage.regenerateQueryForXmlFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXmlFileUsingGpt5() {
    genieChatPage.regenerateQuestionForXmlFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJpgFileUsingGpt5() {
    genieChatPage.regenerateQueryForJpgFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJpgFileUsingGpt5() {
    genieChatPage.regenerateQuestionForJpgFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPngFileUsingGpt5() {
    genieChatPage.regenerateQueryForPngFileUsingGpt5();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPngFileUsingGpt5() {
    genieChatPage.regenerateQuestionForPngFileUsingGpt5();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpt4oWithQuery() {
    genieChatPage.regenerateQueryForTenFilesWithQueryUsingGpt4o();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpt4oWithoutQuery() {
    genieChatPage.regenerateQueryForTenFilesWithoutQueryUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpt4oWithQuery() {
    genieChatPage.regenerateQueryForFiveFilesWithQueryUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpt4oWithoutQuery() {
    genieChatPage.regenerateQueryForFiveFilesUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPdfFileUsingGpt4o() {
    genieChatPage.regenerateQueryForPdfFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPdfFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForPdfFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForDocxFileUsingGpt4o() {
    genieChatPage.regenerateQueryForDocxFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForDocxFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForDocxFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForTxtFileUsingGpt4o() {
    genieChatPage.regenerateQueryForTxtFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForTxtFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForTxtFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPptxFileUsingGpt4o() {
    genieChatPage.regenerateQueryForPptxFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPptxFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForPptxFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForHtmlFileUsingGpt4o() {
    genieChatPage.regenerateQueryForHtmlFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForHtmlFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForHtmlFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForCsvFileUsingGpt4o() {
    genieChatPage.regenerateQueryForCsvFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForCsvFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForCsvFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXlsxFileUsingGpt4o() {
    genieChatPage.regenerateQueryForXlsxFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXlsxFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForXlsxFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJsonFileUsingGpt4o() {
    genieChatPage.regenerateQueryForJsonFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJsonFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForJsonFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXmlFileUsingGpt4o() {
    genieChatPage.regenerateQueryForXmlFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXmlFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForXmlFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJpgFileUsingGpt4o() {
    genieChatPage.regenerateQueryForJpgFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJpgFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForJpgFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPngFileUsingGpt4o() {
    genieChatPage.regenerateQueryForPngFileUsingGpt4o();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPngFileUsingGpt4o() {
    genieChatPage.regenerateQuestionForPngFileUsingGpt4o();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpt4oMiniWithQuery() {
    genieChatPage.regenerateQueryForTenFilesWithQueryUsingGpt4oMini();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpt4oMiniWithoutQuery() {
    genieChatPage.regenerateQueryForTenFilesWithoutQueryUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpt4oMiniWithQuery() {
    genieChatPage.regenerateQueryForFiveFilesWithQueryUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpt4oMiniWithoutQuery() {
    genieChatPage.regenerateQueryForFiveFilesUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPdfFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForPdfFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPdfFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForPdfFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForDocxFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForDocxFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForDocxFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForDocxFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForTxtFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForTxtFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForTxtFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForTxtFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPptxFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForPptxFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPptxFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForPptxFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForHtmlFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForHtmlFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForHtmlFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForHtmlFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForCsvFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForCsvFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForCsvFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForCsvFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXlsxFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForXlsxFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXlsxFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForXlsxFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJsonFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForJsonFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJsonFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForJsonFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXmlFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForXmlFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXmlFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForXmlFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJpgFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForJpgFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJpgFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForJpgFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPngFileUsingGpt4oMini() {
    genieChatPage.regenerateQueryForPngFileUsingGpt4oMini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPngFileUsingGpt4oMini() {
    genieChatPage.regenerateQuestionForPngFileUsingGpt4oMini();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpto3MiniWithQuery() {
    genieChatPage.regenerateQueryForTenFilesWithQueryUsingGpto3Mini();
  }

//  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForTenFilesUsingGpto3MiniWithoutQuery() {
    genieChatPage.regenerateQueryForTenFilesWithoutQueryUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpto3MiniWithQuery() {
    genieChatPage.regenerateQueryForFiveFilesWithQueryUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateResponseForFiveFilesUsingGpto3MiniWithoutQuery() {
    genieChatPage.regenerateQueryForFiveFilesUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPdfFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForPdfFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPdfFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForPdfFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForDocxFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForDocxFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForDocxFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForDocxFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForTxtFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForTxtFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForTxtFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForTxtFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPptxFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForPptxFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPptxFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForPptxFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForHtmlFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForHtmlFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForHtmlFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForHtmlFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForCsvFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForCsvFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForCsvFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForCsvFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXlsxFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForXlsxFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXlsxFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForXlsxFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJsonFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForJsonFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJsonFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForJsonFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForXmlFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForXmlFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForXmlFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForXmlFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForJpgFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForJpgFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForJpgFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForJpgFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQueryForPngFileUsingGpto3Mini() {
    genieChatPage.regenerateQueryForPngFileUsingGpto3Mini();
  }

  @Test(groups = {"regenerateResponse", "fileUpload"})
  public void verifyRegenerateQuestionForPngFileUsingGpto3Mini() {
    genieChatPage.regenerateQuestionForPngFileUsingGpto3Mini();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpt5WithQuery() {
    genieChatPage.generateQueryForTenFilesWithQueryUsingGpt5();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpt5WithoutQuery() {
    genieChatPage.generateQueryForTenFilesWithoutQueryUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpt5WithQuery() {
    genieChatPage.generateQueryForFiveFilesWithQueryUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpt5WithoutQuery() {
    genieChatPage.generateQueryForFiveFilesUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPdfFileUsingGpt5() {
    genieChatPage.generateQueryForPdfFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPdfFileUsingGpt5() {
    genieChatPage.generateQuestionForPdfFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForDocxFileUsingGpt5() {
    genieChatPage.generateQueryForDocxFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForDocxFileUsingGpt5() {
    genieChatPage.generateQuestionForDocxFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForTxtFileUsingGpt5() {
    genieChatPage.generateQueryForTxtFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForTxtFileUsingGpt5() {
    genieChatPage.generateQuestionForTxtFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPptxFileUsingGpt5() {
    genieChatPage.generateQueryForPptxFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPptxFileUsingGpt5() {
    genieChatPage.generateQuestionForPptxFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForHtmlFileUsingGpt5() {
    genieChatPage.generateQueryForHtmlFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForHtmlFileUsingGpt5() {
    genieChatPage.generateQuestionForHtmlFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForCsvFileUsingGpt5() {
    genieChatPage.generateQueryForCsvFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForCsvFileUsingGpt5() {
    genieChatPage.generateQuestionForCsvFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXlsxFileUsingGpt5() {
    genieChatPage.generateQueryForXlsxFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXlsxFileUsingGpt5() {
    genieChatPage.generateQuestionForXlsxFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJsonFileUsingGpt5() {
    genieChatPage.generateQueryForJsonFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJsonFileUsingGpt5() {
    genieChatPage.generateQuestionForJsonFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXmlFileUsingGpt5() {
    genieChatPage.generateQueryForXmlFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXmlFileUsingGpt5() {
    genieChatPage.generateQuestionForXmlFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJpgFileUsingGpt5() {
    genieChatPage.generateQueryForJpgFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJpgFileUsingGpt5() {
    genieChatPage.generateQuestionForJpgFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPngFileUsingGpt5() {
    genieChatPage.generateQueryForPngFileUsingGpt5();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPngFileUsingGpt5() {
    genieChatPage.generateQuestionForPngFileUsingGpt5();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpt4oWithQuery() {
    genieChatPage.generateQueryForTenFilesWithQueryUsingGpt4o();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpt4oWithoutQuery() {
    genieChatPage.generateQueryForTenFilesWithoutQueryUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpt4oWithQuery() {
    genieChatPage.generateQueryForFiveFilesWithQueryUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpt4oWithoutQuery() {
    genieChatPage.generateQueryForFiveFilesUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPdfFileUsingGpt4o() {
    genieChatPage.generateQueryForPdfFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPdfFileUsingGpt4o() {
    genieChatPage.generateQuestionForPdfFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForDocxFileUsingGpt4o() {
    genieChatPage.generateQueryForDocxFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForDocxFileUsingGpt4o() {
    genieChatPage.generateQuestionForDocxFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForTxtFileUsingGpt4o() {
    genieChatPage.generateQueryForTxtFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForTxtFileUsingGpt4o() {
    genieChatPage.generateQuestionForTxtFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPptxFileUsingGpt4o() {
    genieChatPage.generateQueryForPptxFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPptxFileUsingGpt4o() {
    genieChatPage.generateQuestionForPptxFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForHtmlFileUsingGpt4o() {
    genieChatPage.generateQueryForHtmlFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForHtmlFileUsingGpt4o() {
    genieChatPage.generateQuestionForHtmlFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForCsvFileUsingGpt4o() {
    genieChatPage.generateQueryForCsvFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForCsvFileUsingGpt4o() {
    genieChatPage.generateQuestionForCsvFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXlsxFileUsingGpt4o() {
    genieChatPage.generateQueryForXlsxFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXlsxFileUsingGpt4o() {
    genieChatPage.generateQuestionForXlsxFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJsonFileUsingGpt4o() {
    genieChatPage.generateQueryForJsonFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJsonFileUsingGpt4o() {
    genieChatPage.generateQuestionForJsonFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXmlFileUsingGpt4o() {
    genieChatPage.generateQueryForXmlFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXmlFileUsingGpt4o() {
    genieChatPage.generateQuestionForXmlFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJpgFileUsingGpt4o() {
    genieChatPage.generateQueryForJpgFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJpgFileUsingGpt4o() {
    genieChatPage.generateQuestionForJpgFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPngFileUsingGpt4o() {
    genieChatPage.generateQueryForPngFileUsingGpt4o();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPngFileUsingGpt4o() {
    genieChatPage.generateQuestionForPngFileUsingGpt4o();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpt4oMiniWithQuery() {
    genieChatPage.generateQueryForTenFilesWithQueryUsingGpt4oMini();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpt4oMiniWithoutQuery() {
    genieChatPage.generateQueryForTenFilesWithoutQueryUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpt4oMiniWithQuery() {
    genieChatPage.generateQueryForFiveFilesWithQueryUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpt4oMiniWithoutQuery() {
    genieChatPage.generateQueryForFiveFilesUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPdfFileUsingGpt4oMini() {
    genieChatPage.generateQueryForPdfFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPdfFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForPdfFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForDocxFileUsingGpt4oMini() {
    genieChatPage.generateQueryForDocxFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForDocxFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForDocxFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForTxtFileUsingGpt4oMini() {
    genieChatPage.generateQueryForTxtFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForTxtFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForTxtFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPptxFileUsingGpt4oMini() {
    genieChatPage.generateQueryForPptxFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPptxFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForPptxFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForHtmlFileUsingGpt4oMini() {
    genieChatPage.generateQueryForHtmlFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForHtmlFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForHtmlFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForCsvFileUsingGpt4oMini() {
    genieChatPage.generateQueryForCsvFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForCsvFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForCsvFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXlsxFileUsingGpt4oMini() {
    genieChatPage.generateQueryForXlsxFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXlsxFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForXlsxFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJsonFileUsingGpt4oMini() {
    genieChatPage.generateQueryForJsonFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJsonFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForJsonFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXmlFileUsingGpt4oMini() {
    genieChatPage.generateQueryForXmlFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXmlFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForXmlFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJpgFileUsingGpt4oMini() {
    genieChatPage.generateQueryForJpgFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJpgFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForJpgFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPngFileUsingGpt4oMini() {
    genieChatPage.generateQueryForPngFileUsingGpt4oMini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPngFileUsingGpt4oMini() {
    genieChatPage.generateQuestionForPngFileUsingGpt4oMini();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpto3MiniWithQuery() {
    genieChatPage.generateQueryForTenFilesWithQueryUsingGpto3Mini();
  }

//  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForTenFilesUsingGpto3MiniWithoutQuery() {
    genieChatPage.generateQueryForTenFilesWithoutQueryUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpto3MiniWithQuery() {
    genieChatPage.generateQueryForFiveFilesWithQueryUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateResponseForFiveFilesUsingGpto3MiniWithoutQuery() {
    genieChatPage.generateQueryForFiveFilesUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPdfFileUsingGpto3Mini() {
    genieChatPage.generateQueryForPdfFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPdfFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForPdfFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForDocxFileUsingGpto3Mini() {
    genieChatPage.generateQueryForDocxFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForDocxFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForDocxFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForTxtFileUsingGpto3Mini() {
    genieChatPage.generateQueryForTxtFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForTxtFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForTxtFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPptxFileUsingGpto3Mini() {
    genieChatPage.generateQueryForPptxFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPptxFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForPptxFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForHtmlFileUsingGpto3Mini() {
    genieChatPage.generateQueryForHtmlFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForHtmlFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForHtmlFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForCsvFileUsingGpto3Mini() {
    genieChatPage.generateQueryForCsvFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForCsvFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForCsvFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXlsxFileUsingGpto3Mini() {
    genieChatPage.generateQueryForXlsxFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXlsxFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForXlsxFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJsonFileUsingGpto3Mini() {
    genieChatPage.generateQueryForJsonFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJsonFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForJsonFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForXmlFileUsingGpto3Mini() {
    genieChatPage.generateQueryForXmlFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForXmlFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForXmlFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForJpgFileUsingGpto3Mini() {
    genieChatPage.generateQueryForJpgFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForJpgFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForJpgFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQueryForPngFileUsingGpto3Mini() {
    genieChatPage.generateQueryForPngFileUsingGpto3Mini();
  }

  @Test(groups = {"generateResponse", "fileUpload"})
  public void verifyGenerateQuestionForPngFileUsingGpto3Mini() {
    genieChatPage.generateQuestionForPngFileUsingGpto3Mini();
  }

  @Test(groups = "smoke")
  public void verifyReadAloudUsingJavascriptExecutor() {
    genieChatPage.verifyReadAloudUsingJavascriptExecutor();
  }

  @Test(groups = "smoke")
  public void verifyReadAloudUsinConsoleLog() {
    genieChatPage.verifyReadAloudUsingConsoleLog();
  }

  //  @AfterMethod(groups = {"smoke", "fileUpload", "generateResponse", "regenerateResponse"})
  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    TestBase.quitDriver();
  }
}
