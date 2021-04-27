package pages.dialogs;

import baseEntities.BasePage;
import core.BrowsersService;

public class ConfirmationDialog extends BasePage {
    public ConfirmationDialog(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public ConfirmationDialog(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
