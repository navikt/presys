module.exports = {
    'Test fremside' : function (browser) {
        browser
            .url(browser.launchUrl)
            .assert.containsText('body', 'Brukernavn:')
            .assert.containsText('body', 'Passord:')
            .end();
    }
};