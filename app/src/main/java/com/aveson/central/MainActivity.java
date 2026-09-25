package com.aveson.central;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final int PURPLE = Color.rgb(185, 100, 255);
    private final int BLUE = Color.rgb(80, 150, 255);
    private final int DARK = Color.rgb(8, 8, 18);
    private final int CARD = Color.rgb(15, 15, 30);
    private final int TEXT_GRAY = Color.rgb(165, 165, 185);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(DARK);
        getWindow().setNavigationBarColor(DARK);

        showCentralHome();
    }

    // =========================================================
    // HELPERS
    // =========================================================

    private int dp(int value) {
        return (int) (value *
                getResources().getDisplayMetrics().density + 0.5f);
    }

    private LinearLayout createRoot() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.TOP);
        root.setPadding(dp(18), dp(24), dp(18), dp(36));
        root.setBackgroundColor(DARK);
        return root;
    }

    private void setScreen(LinearLayout content) {
        ScrollView scroll = new ScrollView(this);

        scroll.setFillViewport(true);
        scroll.setClipToPadding(false);
        scroll.setPadding(0, 0, 0, dp(10));

        scroll.addView(content);

        setContentView(scroll);
    }

    private TextView createTitle(String text) {
        TextView title = new TextView(this);

        title.setText(text);
        title.setTextColor(Color.WHITE);
        title.setTextSize(23);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, android.graphics.Typeface.BOLD);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(0, 0, 0, dp(8));
        title.setLayoutParams(p);

        return title;
    }

    private TextView createSubtitle(String text) {
        TextView subtitle = new TextView(this);

        subtitle.setText(text);
        subtitle.setTextColor(TEXT_GRAY);
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(0, 0, 0, dp(20));
        subtitle.setLayoutParams(p);

        return subtitle;
    }

    private Button createButton(String text) {
        Button button = new Button(this);

        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(15);
        button.setAllCaps(false);
        button.setGravity(Gravity.CENTER);
        button.setPadding(dp(10), 0, dp(10), 0);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(CARD);
        bg.setCornerRadius(dp(14));
        bg.setStroke(dp(1), PURPLE);

        button.setBackground(bg);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(-1, dp(52));

        p.setMargins(0, dp(6), 0, dp(6));
        button.setLayoutParams(p);

        return button;
    }

    private void addButton(
            LinearLayout layout,
            String text,
            View.OnClickListener listener
    ) {
        Button button = createButton(text);
        button.setOnClickListener(listener);
        layout.addView(button);
    }

    private void addBackButton(
            LinearLayout layout,
            View.OnClickListener listener
    ) {
        Button button = createButton("←  BACK");

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(18, 18, 35));
        bg.setCornerRadius(dp(14));
        bg.setStroke(dp(1), BLUE);

        button.setBackground(bg);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams p =
                (LinearLayout.LayoutParams) button.getLayoutParams();

        p.setMargins(0, dp(18), 0, dp(6));
        button.setLayoutParams(p);

        layout.addView(button);
    }

    private LinearLayout createCard(String title) {
        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(CARD);
        bg.setCornerRadius(dp(16));
        bg.setStroke(dp(1), PURPLE);

        card.setBackground(bg);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(-1,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        p.setMargins(0, dp(7), 0, dp(7));
        card.setLayoutParams(p);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextColor(Color.WHITE);
        titleView.setTextSize(17);
        titleView.setTypeface(null,
                android.graphics.Typeface.BOLD);

        card.addView(titleView);

        return card;
    }

    private void addInfo(
            LinearLayout card,
            String name,
            String value
    ) {
        TextView text = new TextView(this);

        text.setText(name + "\n" + value);
        text.setTextColor(TEXT_GRAY);
        text.setTextSize(14);
        text.setPadding(0, dp(8), 0, dp(8));

        card.addView(text);
    }

    private void addStat(
            LinearLayout card,
            String name
    ) {
        addInfo(card, name, "0");
    }

    // =========================================================
    // CENTRAL HOME
    // =========================================================

    private void showCentralHome() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("AVESON CENTRAL"));
        layout.addView(createSubtitle(
                "Global Management & Control Platform"
        ));

        addButton(layout, "☰  MENU",
                v -> showGlobalMenu());

        addButton(layout, "🎵  AVESON ARTIST CONTROL",
                v -> openRoom("ARTIST"));

        addButton(layout, "🎼  AVESON MUSIC CONTROL",
                v -> openRoom("MUSIC"));

        addButton(layout, "🌍  AVESON DISTRIBUTION CONTROL",
                v -> openRoom("DISTRIBUTION"));

        addButton(layout, "🎙️  AVESON STUDIO CONTROL",
                v -> openRoom("STUDIO"));

        addButton(layout, "📰  AVESON MAGAZINE CONTROL",
                v -> openRoom("MAGAZINE"));

        addButton(layout, "🎬  AVESON FILMS",
                v -> openRoom("FILMS"));

        setScreen(layout);
    }

    // =========================================================
    // GLOBAL MENU
    // =========================================================

    private void showGlobalMenu() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("☰ MENU"));
        layout.addView(createSubtitle(
                "AVESON Central Global Management"
        ));

        addButton(layout, "📊  Analytics",
                v -> showAnalytics());

        addButton(layout, "💰  Royalty Control",
                v -> showRoyaltyControl());

        addButton(layout, "🔐  Security",
                v -> showSecurity());

        addButton(layout, "⚙️  Parameters",
                v -> showParameters());

        addButton(layout, "🛡️  System Status",
                v -> showSystemStatus());

        addButton(layout, "ℹ️  AVESON Central Info",
                v -> showCentralInfo());

        addBackButton(layout,
                v -> showCentralHome());

        setScreen(layout);
    }

    // =========================================================
    // ANALYTICS
    // =========================================================

    private void showAnalytics() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("📊 ANALYTICS"));
        layout.addView(createSubtitle(
                "AVESON Central Analytics"
        ));

        LinearLayout artist =
                createCard("🎵 AVESON ARTIST");

        addStat(artist, "Total Artists");
        addStat(artist, "Registered Artists");
        addStat(artist, "Active Artists");
        addStat(artist, "Inactive Artists");
        addStat(artist, "Song Submissions");
        addStat(artist, "Video Submissions");

        layout.addView(artist);

        LinearLayout music =
                createCard("🎼 AVESON MUSIC");

        addStat(music, "Total Users");
        addStat(music, "Registered Users");
        addStat(music, "Active Users");
        addStat(music, "Total Tracks");
        addStat(music, "Total Albums");
        addStat(music, "Total Streams");

        layout.addView(music);

        LinearLayout distribution =
                createCard("🌍 AVESON DISTRIBUTION");

        addStat(distribution, "Total Users");
        addStat(distribution, "Registered Users");
        addStat(distribution, "Total Releases");
        addStat(distribution, "Connected Platforms");
        addStat(distribution, "Delivered Releases");
        addStat(distribution, "Pending Releases");

        layout.addView(distribution);

        LinearLayout studio =
                createCard("🎙️ AVESON STUDIO");

        addStat(studio, "Total Users");
        addStat(studio, "Registered Users");
        addStat(studio, "Active Users");
        addStat(studio, "Studio Projects");
        addStat(studio, "Audio Projects");
        addStat(studio, "Studio Files");

        layout.addView(studio);

        LinearLayout magazine =
                createCard("📰 AVESON MAGAZINE");

        addStat(magazine, "Total Users");
        addStat(magazine, "Registered Users");
        addStat(magazine, "Total Articles");
        addStat(magazine, "Total Views");
        addStat(magazine, "Writers");
        addStat(magazine, "Published Articles");

        layout.addView(magazine);

        LinearLayout films =
                createCard("🎬 AVESON FILMS");

        addStat(films, "Total Users");
        addStat(films, "Registered Users");
        addStat(films, "Active Users");
        addStat(films, "Total Projects");
        addStat(films, "Total Films");
        addStat(films, "Total Views");

        layout.addView(films);

        addBackButton(layout,
                v -> showGlobalMenu());

        setScreen(layout);
    }

    // =========================================================
    // ROYALTY
    // =========================================================

    private void showRoyaltyControl() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("💰 ROYALTY CONTROL"));
        layout.addView(createSubtitle(
                "Revenue & Royalty Management"
        ));

        addRoyaltyCard(layout,
                "💵 TOTAL REVENUE",
                "Total Revenue",
                "Current Month Revenue",
                "Previous Month Revenue",
                "Revenue Growth");

        addRoyaltyCard(layout,
                "🎵 MUSIC REVENUE",
                "Music Revenue",
                "Streaming Revenue",
                "Download Revenue",
                "Other Music Revenue");

        addRoyaltyCard(layout,
                "🌍 DISTRIBUTION REVENUE",
                "Distribution Revenue",
                "Platform Revenue",
                "Distribution Fees",
                "Other Distribution Revenue");

        addRoyaltyCard(layout,
                "🎬 FILMS REVENUE",
                "Films Revenue",
                "Streaming Revenue",
                "Licensing Revenue",
                "Other Film Revenue");

        addRoyaltyCard(layout,
                "🎙️ STUDIO REVENUE",
                "Studio Revenue",
                "Recording Revenue",
                "Production Revenue",
                "Mixing / Mastering Revenue");

        addRoyaltyCard(layout,
                "📰 MAGAZINE REVENUE",
                "Magazine Revenue",
                "Advertising Revenue",
                "Subscription Revenue",
                "Other Magazine Revenue");

        addRoyaltyCard(layout,
                "💳 PAYMENTS",
                "Completed Payments",
                "Pending Payments",
                "Failed Payments",
                "Payment History");

        addRoyaltyCard(layout,
                "👤 ARTIST EARNINGS",
                "Total Artist Earnings",
                "Pending Artist Earnings",
                "Paid Artist Earnings",
                "Artist Royalty Reports");

        addRoyaltyCard(layout,
                "🌍 DISTRIBUTION EARNINGS",
                "Total Distribution Earnings",
                "Pending Earnings",
                "Paid Earnings",
                "Distribution Reports");

        addRoyaltyCard(layout,
                "📄 ROYALTY REPORTS",
                "Monthly Reports",
                "Artist Reports",
                "Distribution Reports",
                "Revenue Reports");

        addRoyaltyCard(layout,
                "📈 REVENUE GROWTH",
                "Monthly Growth",
                "Yearly Growth",
                "Revenue Trends");

        addRoyaltyCard(layout,
                "💼 REVENUE SOURCES",
                "Music",
                "Distribution",
                "Films",
                "Studio",
                "Magazine");

        addBackButton(layout,
                v -> showGlobalMenu());

        setScreen(layout);
    }

    private void addRoyaltyCard(
            LinearLayout layout,
            String title,
            String... items
    ) {

        LinearLayout card = createCard(title);

        for (String item : items) {
            addInfo(card, item, "$0.00");
        }

        layout.addView(card);
    }

    // =========================================================
    // SECURITY
    // =========================================================

    private void showSecurity() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🔐 SECURITY"));
        layout.addView(createSubtitle(
                "AVESON Central Security"
        ));

        addButton(layout, "👤  ACCESS CONTROL",
                v -> showAccessControl());

        addButton(layout, "📱  AUTHORIZED DEVICES",
                v -> showAuthorizedDevices());

        addButton(layout, "📋  LOGIN & ACCESS ACTIVITY",
                v -> showLoginActivity());

        addButton(layout, "🛡️  SECURITY PROTECTION",
                v -> showSecurityProtection());

        addButton(layout, "🚨  SECURITY EVENTS",
                v -> showSecurityEvents());

        addButton(layout, "🔒  PASSWORD & AUTHENTICATION",
                v -> showPasswordAuthentication());

        addButton(layout, "🌐  NETWORK & API SECURITY",
                v -> showNetworkApiSecurity());

        addButton(layout, "📋  SECURITY LOGS",
                v -> showSecurityLogs());

        addBackButton(layout,
                v -> showGlobalMenu());

        setScreen(layout);
    }

    private void showAccessControl() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("👤 ACCESS CONTROL"));

        addButton(layout, "Administrator Access",
                v -> showAccessRole("Administrator"));

        addButton(layout, "Staff Access",
                v -> showAccessRole("Staff"));

        addButton(layout, "Artist Control Access",
                v -> showAccessRole("Artist"));

        addButton(layout, "Music Control Access",
                v -> showAccessRole("Music"));

        addButton(layout, "Distribution Control Access",
                v -> showAccessRole("Distribution"));

        addButton(layout, "Studio Control Access",
                v -> showAccessRole("Studio"));

        addButton(layout, "Magazine Control Access",
                v -> showAccessRole("Magazine"));

        addButton(layout, "Films Control Access",
                v -> showAccessRole("Films"));

        addButton(layout, "Permission Management",
                v -> showPermissionManagement());

        addBackButton(layout,
                v -> showSecurity());

        setScreen(layout);
    }

    private void showAccessRole(String role) {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "👤 " + role.toUpperCase() + " ACCESS"
        ));

        addButton(layout, role + " Accounts",
                v -> showMessage(role + " Accounts"));

        addButton(layout, role + " Permissions",
                v -> showMessage(role + " Permissions"));

        addButton(layout, role + " Sessions",
                v -> showMessage(role + " Sessions"));

        addButton(layout, role + " Activity",
                v -> showMessage(role + " Activity"));

        addButton(layout, role + " Security",
                v -> showMessage(role + " Security"));

        addBackButton(layout,
                v -> showAccessControl());

        setScreen(layout);
    }

    private void showPermissionManagement() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🛡️ PERMISSION MANAGEMENT"
        ));

        addButton(layout, "Permission Groups",
                v -> showMessage("Permission Groups"));

        addButton(layout, "Permission Rules",
                v -> showMessage("Permission Rules"));

        addButton(layout, "Role Management",
                v -> showMessage("Role Management"));

        addButton(layout, "Access Policies",
                v -> showMessage("Access Policies"));

        addButton(layout, "Permission History",
                v -> showMessage("Permission History"));

        addBackButton(layout,
                v -> showAccessControl());

        setScreen(layout);
    }

    private void showAuthorizedDevices() {
        showSimpleList(
                "📱 AUTHORIZED DEVICES",
                new String[]{
                        "Authorized Devices",
                        "Active Devices",
                        "Device Management",
                        "Add Device",
                        "Remove Device",
                        "Device History",
                        "Blocked Devices"
                },
                () -> showSecurity()
        );
    }

    private void showLoginActivity() {
        showSimpleList(
                "📋 LOGIN & ACCESS ACTIVITY",
                new String[]{
                        "Login Activity",
                        "Successful Logins",
                        "Failed Login Attempts",
                        "Active Sessions",
                        "Session History",
                        "Logout Activity",
                        "Access History"
                },
                () -> showSecurity()
        );
    }

    private void showSecurityProtection() {
        showSimpleList(
                "🛡️ SECURITY PROTECTION",
                new String[]{
                        "Account Protection",
                        "Session Protection",
                        "Device Protection",
                        "API Protection",
                        "Data Protection",
                        "Encryption Status",
                        "Security Configuration"
                },
                () -> showSecurity()
        );
    }

    private void showSecurityEvents() {
        showSimpleList(
                "🚨 SECURITY EVENTS",
                new String[]{
                        "Security Events",
                        "Suspicious Activity",
                        "Access Violations",
                        "Blocked Attempts",
                        "Security Alerts",
                        "Critical Events",
                        "Event History"
                },
                () -> showSecurity()
        );
    }

    private void showPasswordAuthentication() {
        showSimpleList(
                "🔒 PASSWORD & AUTHENTICATION",
                new String[]{
                        "Password Management",
                        "Authentication Settings",
                        "Two-Factor Authentication",
                        "Recovery Settings",
                        "Authentication History",
                        "Password History",
                        "Recovery Activity"
                },
                () -> showSecurity()
        );
    }

    private void showNetworkApiSecurity() {
        showSimpleList(
                "🌐 NETWORK & API SECURITY",
                new String[]{
                        "API Security",
                        "API Access",
                        "API Keys",
                        "HTTPS Status",
                        "Network Access",
                        "Request Monitoring",
                        "API Activity",
                        "Blocked Requests"
                },
                () -> showSecurity()
        );
    }

    private void showSecurityLogs() {
        showSimpleList(
                "📋 SECURITY LOGS",
                new String[]{
                        "System Security Logs",
                        "Access Logs",
                        "API Logs",
                        "Device Logs",
                        "Authentication Logs",
                        "Security Event Logs",
                        "Export Logs",
                        "Log History"
                },
                () -> showSecurity()
        );
    }

    // =========================================================
    // PARAMETERS MAIN
    // =========================================================

    private void showParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("⚙️ PARAMETERS"));
        layout.addView(createSubtitle(
                "AVESON Central Parameters"
        ));

        addButton(layout, "🌐  Languages",
                v -> showLanguages());

        addButton(layout, "🎨  Appearance",
                v -> showAppearance());

        addButton(layout, "🔔  Notifications",
                v -> showNotifications());

        addButton(layout, "🎵  Music Parameters",
                v -> showMusicParameters());

        addButton(layout, "🌍  Distribution Parameters",
                v -> showDistributionParameters());

        addBackButton(layout,
                v -> showGlobalMenu());

        setScreen(layout);
    }

    // =========================================================
    // LANGUAGES
    // =========================================================

    private void showLanguages() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🌐 LANGUAGES"));
        layout.addView(createSubtitle(
                "Language Management"
        ));

        addButton(layout, "System Language",
                v -> showSystemLanguage());

        addButton(layout, "Default Language",
                v -> showDefaultLanguage());

        addButton(layout, "Available Languages",
                v -> showAvailableLanguages());

        addButton(layout, "Language Management",
                v -> showLanguageManagement());

        addBackButton(layout,
                v -> showParameters());

        setScreen(layout);
    }

    private void showSystemLanguage() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("SYSTEM LANGUAGE"));
        layout.addView(createSubtitle(
                "Select AVESON Central system language"
        ));

        addButton(layout, "English",
                v -> showMessage("English selected"));

        addButton(layout, "Uzbek",
                v -> showMessage("Uzbek selected"));

        addButton(layout, "Russian",
                v -> showMessage("Russian selected"));

        addButton(layout, "Turkish",
                v -> showMessage("Turkish selected"));

        addButton(layout, "Spanish",
                v -> showMessage("Spanish selected"));

        addButton(layout, "French",
                v -> showMessage("French selected"));

        addButton(layout, "German",
                v -> showMessage("German selected"));

        addButton(layout, "Arabic",
                v -> showMessage("Arabic selected"));

        addBackButton(layout,
                v -> showLanguages());

        setScreen(layout);
    }

    private void showDefaultLanguage() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("DEFAULT LANGUAGE"));

        LinearLayout card =
                createCard("DEFAULT LANGUAGE");

        addInfo(card, "Current Default", "English");
        addInfo(card, "Status", "Configured");

        layout.addView(card);

        addButton(layout, "Change Default Language",
                v -> showSystemLanguage());

        addBackButton(layout,
                v -> showLanguages());

        setScreen(layout);
    }

    private void showAvailableLanguages() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("AVAILABLE LANGUAGES"));

        String[] languages = {
                "English",
                "Uzbek",
                "Russian",
                "Turkish",
                "Spanish",
                "French",
                "German",
                "Arabic",
                "Portuguese",
                "Italian",
                "Chinese",
                "Japanese",
                "Korean"
        };

        for (String language : languages) {
            addButton(layout, language,
                    v -> showMessage(language));
        }

        addBackButton(layout,
                v -> showLanguages());

        setScreen(layout);
    }

    private void showLanguageManagement() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("LANGUAGE MANAGEMENT"));

        addButton(layout, "Add Language",
                v -> showMessage("Add Language"));

        addButton(layout, "Remove Language",
                v -> showMessage("Remove Language"));

        addButton(layout, "Edit Language",
                v -> showMessage("Edit Language"));

        addButton(layout, "Set Default",
                v -> showDefaultLanguage());

        addButton(layout, "Language Order",
                v -> showMessage("Language Order"));

        addBackButton(layout,
                v -> showLanguages());

        setScreen(layout);
    }

    // =========================================================
    // APPEARANCE
    // =========================================================

    private void showAppearance() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🎨 APPEARANCE"));
        layout.addView(createSubtitle(
                "Interface Appearance Settings"
        ));

        addButton(layout, "Theme",
                v -> showTheme());

        addButton(layout, "Dark Mode",
                v -> showDarkMode());

        addButton(layout, "Light Mode",
                v -> showLightMode());

        addButton(layout, "Accent Color",
                v -> showAccentColor());

        addButton(layout, "Interface Style",
                v -> showInterfaceStyle());

        addBackButton(layout,
                v -> showParameters());

        setScreen(layout);
    }

    private void showTheme() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("THEME"));

        addButton(layout, "AVESON Dark",
                v -> showMessage("AVESON Dark Theme"));

        addButton(layout, "AVESON Neon",
                v -> showMessage("AVESON Neon Theme"));

        addButton(layout, "AVESON Cinema",
                v -> showMessage("AVESON Cinema Theme"));

        addButton(layout, "Custom Theme",
                v -> showMessage("Custom Theme"));

        addBackButton(layout,
                v -> showAppearance());

        setScreen(layout);
    }

    private void showDarkMode() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("DARK MODE"));

        LinearLayout card =
                createCard("DARK MODE");

        addInfo(card, "Status", "Enabled");
        addInfo(card, "Interface", "Dark");
        addInfo(card, "Background", "AVESON Dark");

        layout.addView(card);

        addButton(layout, "Enable Dark Mode",
                v -> showMessage("Dark Mode Enabled"));

        addBackButton(layout,
                v -> showAppearance());

        setScreen(layout);
    }

    private void showLightMode() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("LIGHT MODE"));

        LinearLayout card =
                createCard("LIGHT MODE");

        addInfo(card, "Status", "Available");
        addInfo(card, "Interface", "Light");

        layout.addView(card);

        addButton(layout, "Enable Light Mode",
                v -> showMessage("Light Mode Enabled"));

        addBackButton(layout,
                v -> showAppearance());

        setScreen(layout);
    }

    private void showAccentColor() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("ACCENT COLOR"));

        addButton(layout, "AVESON Purple",
                v -> showMessage("Purple Accent"));

        addButton(layout, "AVESON Blue",
                v -> showMessage("Blue Accent"));

        addButton(layout, "Purple / Blue",
                v -> showMessage("Purple / Blue Accent"));

        addButton(layout, "Custom Color",
                v -> showMessage("Custom Accent Color"));

        addBackButton(layout,
                v -> showAppearance());

        setScreen(layout);
    }

    private void showInterfaceStyle() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("INTERFACE STYLE"));

        addButton(layout, "Compact",
                v -> showMessage("Compact Interface"));

        addButton(layout, "Standard",
                v -> showMessage("Standard Interface"));

        addButton(layout, "Premium",
                v -> showMessage("Premium Interface"));

        addButton(layout, "Cinematic",
                v -> showMessage("Cinematic Interface"));

        addBackButton(layout,
                v -> showAppearance());

        setScreen(layout);
    }

    // =========================================================
    // NOTIFICATIONS
    // =========================================================

    private void showNotifications() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🔔 NOTIFICATIONS"));

        addButton(layout, "Notifications",
                v -> showNotificationGeneral());

        addButton(layout, "Push Notifications",
                v -> showPushNotifications());

        addButton(layout, "Security Notifications",
                v -> showSecurityNotifications());

        addButton(layout, "System Notifications",
                v -> showSystemNotifications());

        addButton(layout, "Artist Notifications",
                v -> showArtistNotifications());

        addButton(layout, "Distribution Notifications",
                v -> showDistributionNotifications());

        addBackButton(layout,
                v -> showParameters());

        setScreen(layout);
    }

    private void showNotificationGeneral() {

        showSettingsPage(
                "NOTIFICATIONS",
                new String[]{
                        "Enable Notifications",
                        "Notification Sound",
                        "Notification Badge",
                        "Notification Preview",
                        "Notification History"
                },
                () -> showNotifications()
        );
    }

    private void showPushNotifications() {

        showSettingsPage(
                "PUSH NOTIFICATIONS",
                new String[]{
                        "Enable Push Notifications",
                        "Push Sound",
                        "Push Vibration",
                        "Push Badge",
                        "Push Priority"
                },
                () -> showNotifications()
        );
    }

    private void showSecurityNotifications() {

        showSettingsPage(
                "SECURITY NOTIFICATIONS",
                new String[]{
                        "Security Alerts",
                        "Login Alerts",
                        "New Device Alerts",
                        "Access Alerts",
                        "Critical Security Alerts"
                },
                () -> showNotifications()
        );
    }

    private void showSystemNotifications() {

        showSettingsPage(
                "SYSTEM NOTIFICATIONS",
                new String[]{
                        "System Alerts",
                        "System Updates",
                        "Maintenance Alerts",
                        "Service Alerts",
                        "System Errors"
                },
                () -> showNotifications()
        );
    }

    private void showArtistNotifications() {

        showSettingsPage(
                "ARTIST NOTIFICATIONS",
                new String[]{
                        "New Artist Submission",
                        "Submission Review",
                        "Release Approval",
                        "Release Rejection",
                        "Artist Activity"
                },
                () -> showNotifications()
        );
    }

    private void showDistributionNotifications() {

        showSettingsPage(
                "DISTRIBUTION NOTIFICATIONS",
                new String[]{
                        "Delivery Completed",
                        "Delivery Failed",
                        "Platform Update",
                        "Release Status",
                        "Distribution Alerts"
                },
                () -> showNotifications()
        );
    }

    // =========================================================
    // MUSIC PARAMETERS
    // =========================================================

    private void showMusicParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🎵 MUSIC PARAMETERS"));
        layout.addView(createSubtitle(
                "Music Standards & Configuration"
        ));

        addButton(layout, "Audio Standards",
                v -> showAudioStandards());

        addButton(layout, "Cover Standards",
                v -> showCoverStandards());

        addButton(layout, "Release Standards",
                v -> showReleaseStandards());

        addButton(layout, "Metadata Standards",
                v -> showMetadataStandards());

        addButton(layout, "Music File Formats",
                v -> showMusicFileFormats());

        addButton(layout, "Music Quality",
                v -> showMusicQuality());

        addBackButton(layout,
                v -> showParameters());

        setScreen(layout);
    }

    private void showAudioStandards() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("AUDIO STANDARDS"));
        layout.addView(createSubtitle(
                "AVESON Music Audio Requirements"
        ));

        LinearLayout card =
                createCard("RECOMMENDED STANDARD");

        addInfo(card, "Preferred Format", "WAV");
        addInfo(card, "Preferred Quality", "Lossless");
        addInfo(card, "Sample Rate", "44.1 kHz / 48 kHz");
        addInfo(card, "Bit Depth", "24-bit preferred");
        addInfo(card, "MP3", "Supported
