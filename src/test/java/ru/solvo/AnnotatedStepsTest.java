package ru.solvo;

import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 68;

    @Test
    public void testRepositoryIssue() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepo(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssue();
        steps.checkIssueWithNumber(ISSUE_NUMBER);
    }
}
