public class HeaderSection implements Page
{
    @Override
    public String getUrl()
    {
        return "/secure/Dashboard.jspa";
    }
        @ElementBy(partialLinkText = "Issues")
    private PageElement issuesTab;
    @ElementBy(partialLinkText = "Wiki")
    private PageElement wikiTab;
    @ElementBy(partialLinkText = "Source")
    private PageElement sourceTab;
    @ElementBy(partialLinkText = "Reviews")
    private PageElement reviewsTab;
    @ElementBy(partialLinkText = "Builds")
    private PageElement buildsTab;
        @ElementBy(cssSelector = "li.current a")
    private PageElement currentTab;
        @ElementBy(partialLinkText = "Administrator")
    private PageElement studioUserMenu;
    @ElementBy(className = "logout-link")
    private PageElement logoutMenu;
    @ElementBy(id = "confirm-logout-submit")
    private PageElement confirmLogout;
    public TimedCondition isIssuesAvailable()
    {
        issuesTab.click();
        return currentTab.timed().hasText(issuesTab.getText());
    }
    public TimedCondition isWikiAvailable()
    {
        wikiTab.click();
        return currentTab.timed().hasText(wikiTab.getText());
    }
    public TimedCondition isSourceAvailable()
    {
        sourceTab.click();
        return currentTab.timed().hasText(sourceTab.getText());
    }
    public TimedCondition isReviewAvailable()
    {
        reviewsTab.click();
        return currentTab.timed().hasText(reviewsTab.getText());
    }
    public TimedCondition isBuildAvailable()
    {
        buildsTab.click();
        return currentTab.timed().hasText(buildsTab.getText());
    }
    public void logout()
    {
        if (studioUserMenu.isPresent())
        {
            studioUserMenu.click();
            logoutMenu.click();
            confirmLogout.click();
        }
    }
}