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
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        p.setMargins(0, dp(7), 0, dp(7));
        card.setLayoutParams(p);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextColor(Color.WHITE);
        titleView.setTextSize(17);
        titleView.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );

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

        layout.addView(createTitle(
                "👤 ACCESS CONTROL"
        ));

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
    // PARAMETERS
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

        String[] languages = {
                "English",
                "Uzbek",
                "Russian",
                "Turkish",
                "Spanish",
                "French",
                "German",
                "Arabic"
        };

        for (String language : languages) {
            addButton(layout, language,
                    v -> showMessage(language + " selected"));
        }

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

        layout.addView(createTitle(
                "LANGUAGE MANAGEMENT"
        ));

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

        layout.addView(createTitle(
                "🎵 MUSIC PARAMETERS"
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

        LinearLayout card =
                createCard("RECOMMENDED STANDARD");

        addInfo(card, "Preferred Format", "WAV");
        addInfo(card, "Preferred Quality", "Lossless");
        addInfo(card, "Sample Rate", "44.1 kHz / 48 kHz");
        addInfo(card, "Bit Depth", "24-bit preferred");
        addInfo(card, "MP3", "Supported where applicable");

        layout.addView(card);

        addButton(layout, "WAV Standards",
                v -> showMessage("WAV Standards"));

        addButton(layout, "MP3 Standards",
                v -> showMessage("MP3 Standards"));

        addButton(layout, "Sample Rate",
                v -> showMessage("Sample Rate"));

        addButton(layout, "Bit Depth",
                v -> showMessage("Bit Depth"));

        addButton(layout, "Audio Validation",
                v -> showMessage("Audio Validation"));

        addBackButton(layout,
                v -> showMusicParameters());

        setScreen(layout);
    }

    private void showCoverStandards() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("COVER STANDARDS"));

        LinearLayout card =
                createCard("AVESON COVER STANDARD");

        addInfo(card, "Minimum Size",
                "3000 × 3000 px");

        addInfo(card, "Recommended",
                "3000 × 3000 px or larger");

        addInfo(card, "Format",
                "JPG / PNG");

        addInfo(card, "Quality",
                "High Resolution");

        addInfo(card, "Content",
                "Genre appropriate");

        layout.addView(card);

        addButton(layout, "Cover Dimensions",
                v -> showMessage("Cover Dimensions"));

        addButton(layout, "Cover Format",
                v -> showMessage("Cover Format"));

        addButton(layout, "Cover Quality",
                v -> showMessage("Cover Quality"));

        addButton(layout, "Cover Validation",
                v -> showMessage("Cover Validation"));

        addButton(layout, "Content Rules",
                v -> showMessage("Content Rules"));

        addBackButton(layout,
                v -> showMusicParameters());

        setScreen(layout);
    }

    private void showReleaseStandards() {

        showSettingsPage(
                "RELEASE STANDARDS",
                new String[]{
                        "Release Title",
                        "Artist Name",
                        "Release Type",
                        "Release Date",
                        "Copyright Information",
                        "Label Information",
                        "Genre",
                        "Language",
                        "Explicit Content",
                        "Release Validation"
                },
                () -> showMusicParameters()
        );
    }

    private void showMetadataStandards() {

        showSettingsPage(
                "METADATA STANDARDS",
                new String[]{
                        "Track Title",
                        "Artist Metadata",
                        "Album Metadata",
                        "Genre Metadata",
                        "Copyright Metadata",
                        "ISRC",
                        "UPC / EAN",
                        "Composer",
                        "Producer",
                        "Metadata Validation"
                },
                () -> showMusicParameters()
        );
    }

    private void showMusicFileFormats() {

        showSettingsPage(
                "MUSIC FILE FORMATS",
                new String[]{
                        "WAV",
                        "FLAC",
                        "MP3",
                        "AAC",
                        "Supported Formats",
                        "Format Validation"
                },
                () -> showMusicParameters()
        );
    }

    private void showMusicQuality() {

        showSettingsPage(
                "MUSIC QUALITY",
                new String[]{
                        "Standard Quality",
                        "High Quality",
                        "Lossless Quality",
                        "Master Quality",
                        "Quality Validation"
                },
                () -> showMusicParameters()
        );
    }

    // =========================================================
    // DISTRIBUTION PARAMETERS
    // =========================================================

    private void showDistributionParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🌍 DISTRIBUTION PARAMETERS"
        ));

        addButton(layout, "Distribution Standards",
                v -> showDistributionStandards());

        addButton(layout, "Platform Settings",
                v -> showPlatformSettings());

        addButton(layout, "Release Delivery Settings",
                v -> showReleaseDeliverySettings());

        addButton(layout, "Territory Settings",
                v -> showTerritorySettings());

        addButton(layout, "Distribution Formats",
                v -> showDistributionFormats());

        addButton(layout, "Delivery Rules",
                v -> showDeliveryRules());

        addBackButton(layout,
                v -> showParameters());

        setScreen(layout);
    }

    private void showDistributionStandards() {

        showSettingsPage(
                "DISTRIBUTION STANDARDS",
                new String[]{
                        "Release Requirements",
                        "Audio Requirements",
                        "Cover Requirements",
                        "Metadata Requirements",
                        "Copyright Requirements",
                        "Artist Requirements",
                        "Content Requirements",
                        "Validation Rules"
                },
                () -> showDistributionParameters()
        );
    }

    private void showPlatformSettings() {

        showSettingsPage(
                "PLATFORM SETTINGS",
                new String[]{
                        "Platform List",
                        "Platform Connections",
                        "Platform Status",
                        "Platform Credentials",
                        "Platform Rules",
                        "Platform Mapping"
                },
                () -> showDistributionParameters()
        );
    }

    private void showReleaseDeliverySettings() {

        showSettingsPage(
                "RELEASE DELIVERY SETTINGS",
                new String[]{
                        "Automatic Delivery",
                        "Manual Delivery",
                        "Delivery Schedule",
                        "Delivery Priority",
                        "Delivery Retry",
                        "Delivery Status",
                        "Delivery Confirmation"
                },
                () -> showDistributionParameters()
        );
    }

    private void showTerritorySettings() {

        showSettingsPage(
                "TERRITORY SETTINGS",
                new String[]{
                        "Worldwide",
                        "Country Management",
                        "Territory Groups",
                        "Restricted Territories",
                        "Territory Rules"
                },
                () -> showDistributionParameters()
        );
    }

    private void showDistributionFormats() {

        showSettingsPage(
                "DISTRIBUTION FORMATS",
                new String[]{
                        "Audio Distribution",
                        "Video Distribution",
                        "Streaming Format",
                        "Download Format",
                        "Master Format",
                        "Platform Format Mapping"
                },
                () -> showDistributionParameters()
        );
    }

    private void showDeliveryRules() {

        showSettingsPage(
                "DELIVERY RULES",
                new String[]{
                        "Automatic Approval",
                        "Manual Approval",
                        "Quality Check",
                        "Metadata Check",
                        "Copyright Check",
                        "Platform Check",
                        "Delivery Validation",
                        "Failure Handling"
                },
                () -> showDistributionParameters()
        );
    }

    // =========================================================
    // SYSTEM STATUS
    // =========================================================

    private void showSystemStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🛡️ SYSTEM STATUS"));

        layout.addView(createSubtitle(
                "AVESON Central System Monitoring"
        ));

        addButton(layout, "🖥️  Central System",
                v -> showCentralSystemStatus());

        addButton(layout, "📱  Application",
                v -> showApplicationStatus());

        addButton(layout, "🗄️  Database",
                v -> showDatabaseStatus());

        addButton(layout, "⚙️  Backend",
                v -> showBackendStatus());

        addButton(layout, "🔐  HTTPS",
                v -> showHttpsStatus());

        addButton(layout, "🔌  API",
                v -> showApiStatus());

        addButton(layout, "🌐  Network",
                v -> showNetworkStatus());

        addButton(layout, "💾  Storage",
                v -> showStorageStatus());

        addButton(layout, "⚡  Performance",
                v -> showPerformanceStatus());

        addButton(layout, "🔄  Services",
                v -> showServicesStatus());

        addButton(layout, "🧩  System Version",
                v -> showSystemVersion());

        addButton(layout, "🛠️  Maintenance",
                v -> showMaintenanceStatus());

        addButton(layout, "📋  System Logs",
                v -> showSystemLogs());

        addBackButton(layout,
                v -> showGlobalMenu());

        setScreen(layout);
    }

    private void showCentralSystemStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🖥️ CENTRAL SYSTEM"
        ));

        LinearLayout card =
                createCard("CENTRAL SYSTEM STATUS");

        addInfo(card, "System", "AVESON Central");
        addInfo(card, "Status", "ONLINE");
        addInfo(card, "Control Layer", "ACTIVE");
        addInfo(card, "Management", "CENTRALIZED");

        layout.addView(card);

        addButton(layout, "System Configuration",
                v -> showMessage("System Configuration"));

        addButton(layout, "System Services",
                v -> showMessage("System Services"));

        addButton(layout, "System Health",
                v -> showMessage("System Health"));

        addButton(layout, "System Monitoring",
                v -> showMessage("System Monitoring"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showApplicationStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "📱 APPLICATION"
        ));

        LinearLayout card =
                createCard("APPLICATION STATUS");

        addInfo(card, "Application", "AVESON Central");
        addInfo(card, "Status", "RUNNING");
        addInfo(card, "Version", "1.0");
        addInfo(card, "Environment", "Production Ready");

        layout.addView(card);

        addButton(layout, "Application Health",
                v -> showMessage("Application Health"));

        addButton(layout, "Application Configuration",
                v -> showMessage("Application Configuration"));

        addButton(layout, "Application Services",
                v -> showMessage("Application Services"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showDatabaseStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🗄️ DATABASE"
        ));

        LinearLayout card =
                createCard("DATABASE STATUS");

        addInfo(card, "Status", "NOT CONNECTED");
        addInfo(card, "Database", "Not Configured");
        addInfo(card, "Connection", "Unavailable");
        addInfo(card, "Tables", "0");
        addInfo(card, "Records", "0");

        layout.addView(card);

        addButton(layout, "Database Connection",
                v -> showMessage("Database Connection"));

        addButton(layout, "Database Configuration",
                v -> showMessage("Database Configuration"));

        addButton(layout, "Database Health",
                v -> showMessage("Database Health"));

        addButton(layout, "Database Backup",
                v -> showMessage("Database Backup"));

        addButton(layout, "Database Logs",
                v -> showMessage("Database Logs"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showBackendStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "⚙️ BACKEND"
        ));

        LinearLayout card =
                createCard("BACKEND STATUS");

        addInfo(card, "Status", "NOT CONNECTED");
        addInfo(card, "Server", "Not Configured");
        addInfo(card, "Environment", "Not Configured");
        addInfo(card, "Connection", "Unavailable");

        layout.addView(card);

        addButton(layout, "Backend Connection",
                v -> showMessage("Backend Connection"));

        addButton(layout, "Server Configuration",
                v -> showMessage("Server Configuration"));

        addButton(layout, "Backend Health",
                v -> showMessage("Backend Health"));

        addButton(layout, "Backend Services",
                v -> showMessage("Backend Services"));

        addButton(layout, "Backend Logs",
                v -> showMessage("Backend Logs"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showHttpsStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🔐 HTTPS"
        ));

        LinearLayout card =
                createCard("HTTPS STATUS");

        addInfo(card, "Status", "NOT CONFIGURED");
        addInfo(card, "Protocol", "HTTPS");
        addInfo(card, "Certificate", "Not Configured");
        addInfo(card, "Secure Connection", "Unavailable");

        layout.addView(card);

        addButton(layout, "HTTPS Configuration",
                v -> showMessage("HTTPS Configuration"));

        addButton(layout, "SSL Certificate",
                v -> showMessage("SSL Certificate"));

        addButton(layout, "TLS Configuration",
                v -> showMessage("TLS Configuration"));

        addButton(layout, "Secure Connection Test",
                v -> showMessage("Secure Connection Test"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showApiStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🔌 API"
        ));

        LinearLayout card =
                createCard("API STATUS");

        addInfo(card, "Status", "NOT CONNECTED");
        addInfo(card, "API Endpoint", "Not Configured");
        addInfo(card, "Authentication", "Not Configured");
        addInfo(card, "Requests", "0");

        layout.addView(card);

        addButton(layout, "API Configuration",
                v -> showMessage("API Configuration"));

        addButton(layout, "API Endpoints",
                v -> showMessage("API Endpoints"));

        addButton(layout, "API Authentication",
                v -> showMessage("API Authentication"));

        addButton(layout, "API Health",
                v -> showMessage("API Health"));

        addButton(layout, "API Logs",
                v -> showMessage("API Logs"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showNetworkStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🌐 NETWORK"
        ));

        LinearLayout card =
                createCard("NETWORK STATUS");

        addInfo(card, "Status", "AVAILABLE");
        addInfo(card, "Internet", "Available");
        addInfo(card, "Connection", "Active");
        addInfo(card, "Monitoring", "Enabled");

        layout.addView(card);

        addButton(layout, "Network Configuration",
                v -> showMessage("Network Configuration"));

        addButton(layout, "Connection Test",
                v -> showMessage("Connection Test"));

        addButton(layout, "Network Monitoring",
                v -> showMessage("Network Monitoring"));

        addButton(layout, "Network Logs",
                v -> showMessage("Network Logs"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showStorageStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "💾 STORAGE"
        ));

        LinearLayout card =
                createCard("STORAGE STATUS");

        addInfo(card, "Status", "AVAILABLE");
        addInfo(card, "Application Storage", "Available");
        addInfo(card, "Media Storage", "Not Configured");
        addInfo(card, "Cloud Storage", "Not Connected");

        layout.addView(card);

        addButton(layout, "Storage Configuration",
                v -> showMessage("Storage Configuration"));

        addButton(layout, "Media Storage",
                v -> showMessage("Media Storage"));

        addButton(layout, "Cloud Storage",
                v -> showMessage("Cloud Storage"));

        addButton(layout, "Storage Monitoring",
                v -> showMessage("Storage Monitoring"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showPerformanceStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "⚡ PERFORMANCE"
        ));

        LinearLayout card =
                createCard("PERFORMANCE STATUS");

        addInfo(card, "Application", "RUNNING");
        addInfo(card, "CPU Monitoring", "Available");
        addInfo(card, "Memory Monitoring", "Available");
        addInfo(card, "Response Monitoring", "Available");

        layout.addView(card);

        addButton(layout, "CPU Usage",
                v -> showMessage("CPU Usage"));

        addButton(layout, "Memory Usage",
                v -> showMessage("Memory Usage"));

        addButton(layout, "Response Time",
                v -> showMessage("Response Time"));

        addButton(layout, "Performance Monitoring",
                v -> showMessage("Performance Monitoring"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showServicesStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🔄 SERVICES"
        ));

        addButton(layout, "Artist Service",
                v -> showMessage("Artist Service"));

        addButton(layout, "Music Service",
                v -> showMessage("Music Service"));

        addButton(layout, "Distribution Service",
                v -> showMessage("Distribution Service"));

        addButton(layout, "Studio Service",
                v -> showMessage("Studio Service"));

        addButton(layout, "Magazine Service",
                v -> showMessage("Magazine Service"));

        addButton(layout, "Films Service",
                v -> showMessage("Films Service"));

        addButton(layout, "Royalty Service",
                v -> showMessage("Royalty Service"));

        addButton(layout, "Security Service",
                v -> showMessage("Security Service"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showSystemVersion() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🧩 SYSTEM VERSION"
        ));

        LinearLayout card =
                createCard("VERSION INFORMATION");

        addInfo(card, "System", "AVESON Central");
        addInfo(card, "Version", "1.0");
        addInfo(card, "Build", "Debug");
        addInfo(card, "Platform", "Android");
        addInfo(card, "Architecture", "Centralized");

        layout.addView(card);

        addButton(layout, "Version Information",
                v -> showMessage("Version Information"));

        addButton(layout, "Build Information",
                v -> showMessage("Build Information"));

        addButton(layout, "Update Status",
                v -> showMessage("Update Status"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showMaintenanceStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "🛠️ MAINTENANCE"
        ));

        LinearLayout card =
                createCard("MAINTENANCE STATUS");

        addInfo(card, "Status", "READY");
        addInfo(card, "Maintenance Mode", "OFF");
        addInfo(card, "Scheduled Maintenance", "NONE");
        addInfo(card, "System Updates", "No Updates");

        layout.addView(card);

        addButton(layout, "Maintenance Mode",
                v -> showMessage("Maintenance Mode"));

        addButton(layout, "Scheduled Maintenance",
                v -> showMessage("Scheduled Maintenance"));

        addButton(layout, "System Updates",
                v -> showMessage("System Updates"));

        addButton(layout, "Maintenance Logs",
                v -> showMessage("Maintenance Logs"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    private void showSystemLogs() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "📋 SYSTEM LOGS"
        ));

        addButton(layout, "Application Logs",
                v -> showMessage("Application Logs"));

        addButton(layout, "System Logs",
                v -> showMessage("System Logs"));

        addButton(layout, "Database Logs",
                v -> showMessage("Database Logs"));

        addButton(layout, "Backend Logs",
                v -> showMessage("Backend Logs"));

        addButton(layout, "API Logs",
                v -> showMessage("API Logs"));

        addButton(layout, "Security Logs",
                v -> showMessage("Security Logs"));

        addButton(layout, "Network Logs",
                v -> showMessage("Network Logs"));

        addButton(layout, "Error Logs",
                v -> showMessage("Error Logs"));

        addButton(layout, "Log History",
                v -> showMessage("Log History"));

        addBackButton(layout,
                v -> showSystemStatus());

        setScreen(layout);
    }

    // =========================================================
    // CENTRAL INFO
    // =========================================================

    private void showCentralInfo() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(
                "ℹ️ AVESON CENTRAL INFO"
        ));

        layout.addView(createSubtitle(
                "Global Music & Media Management"
        ));

        LinearLayout card =
                createCard("AVESON CENTRAL");

        addInfo(card, "System", "AVESON Central");
        addInfo(card, "Platform", "Global Music & Media");
        addInfo(card, "Management", "Centralized");
        addInfo(card, "Version", "1.0");
        addInfo(card, "Backend", "Not Connected");
        addInfo(card, "Database", "Not Connected");

        layout.addView(card);

        addBackButton(layout,
                v -> showGlobalMenu());

        setScreen(layout);
    }

    // =========================================================
    // ROOMS
    // =========================================================

    private void openRoom(String room) {

        LinearLayout layout = createRoot();

        String title = "";
        String subtitle = "";

        if (room.equals("ARTIST")) {
            title = "🎵 AVESON ARTIST CONTROL";
            subtitle = "Artist Management";
        } else if (room.equals("MUSIC")) {
            title = "🎼 AVESON MUSIC CONTROL";
            subtitle = "Music Management";
        } else if (room.equals("DISTRIBUTION")) {
            title = "🌍 AVESON DISTRIBUTION CONTROL";
            subtitle = "Distribution Management";
        } else if (room.equals("STUDIO")) {
            title = "🎙️ AVESON STUDIO CONTROL";
            subtitle = "Studio Management";
        } else if (room.equals("MAGAZINE")) {
            title = "📰 AVESON MAGAZINE CONTROL";
            subtitle = "Magazine Management";
        } else if (room.equals("FILMS")) {
            title = "🎬 AVESON FILMS";
            subtitle = "Film Management";
        }

        layout.addView(createTitle(title));
        layout.addView(createSubtitle(subtitle));

        if (room.equals("ARTIST")) {

            addButton(layout, "Artists",
                    v -> showMessage("Artists"));

            addButton(layout, "Artist Submissions",
                    v -> showMessage("Artist Submissions"));

            addButton(layout, "Release Review",
                    v -> showMessage("Release Review"));

            addButton(layout, "Artist Analytics",
                    v -> showMessage("Artist Analytics"));

            addButton(layout, "Artist Settings",
                    v -> showMessage("Artist Settings"));

        } else if (room.equals("MUSIC")) {

            addButton(layout, "Music Catalog",
                    v -> showMessage("Music Catalog"));

            addButton(layout, "Albums & Releases",
                    v -> showMessage("Albums & Releases"));

            addButton(layout, "Playlists",
                    v -> showMessage("Playlists"));

            addButton(layout, "Music Users",
                    v -> showMessage("Music Users"));

            addButton(layout, "Music Analytics",
                    v -> showMessage("Music Analytics"));

            addButton(layout, "Music Settings",
                    v -> showMessage("Music Settings"));

        } else if (room.equals("DISTRIBUTION")) {

            addButton(layout, "Distribution Platforms",
                    v -> showMessage("Distribution Platforms"));

            addButton(layout, "Distribution Releases",
                    v -> showMessage("Distribution Releases"));

            addButton(layout, "Release Delivery",
                    v -> showMessage("Release Delivery"));

            addButton(layout, "Distribution Analytics",
                    v -> showMessage("Distribution Analytics"));

            addButton(layout, "Distribution Settings",
                    v -> showMessage("Distribution Settings"));

        } else if (room.equals("STUDIO")) {

            addButton(layout, "Studio Projects",
                    v -> showMessage("Studio Projects"));

            addButton(layout, "Audio Production",
                    v -> showMessage("Audio Production"));

            addButton(layout, "Sessions",
                    v -> showMessage("Sessions"));

            addButton(layout, "Studio Files",
                    v -> showMessage("Studio Files"));

            addButton(layout, "Studio Analytics",
                    v -> showMessage("Studio Analytics"));

            addButton(layout, "Studio Settings",
                    v -> showMessage("Studio Settings"));

        } else if (room.equals("MAGAZINE")) {

            addButton(layout, "Articles",
                    v -> showMessage("Articles"));

            addButton(layout, "Editorial",
                    v -> showMessage("Editorial"));

            addButton(layout, "Media",
                    v -> showMessage("Media"));

            addButton(layout, "Writers",
                    v -> showMessage("Writers"));

            addButton(layout, "Magazine Analytics",
                    v -> showMessage("Magazine Analytics"));

            addButton(layout, "Magazine Settings",
                    v -> showMessage("Magazine Settings"));

        } else if (room.equals("FILMS")) {

            addButton(layout, "Projects",
                    v -> showMessage("Projects"));

            addButton(layout, "Videos",
                    v -> showMessage("Videos"));

            addButton(layout, "Productions",
                    v -> showMessage("Productions"));

            addButton(layout, "Film Library",
                    v -> showMessage("Film Library"));

            addButton(layout, "Film Analytics",
                    v -> showMessage("Film Analytics"));

            addButton(layout, "Film Settings",
                    v -> showMessage("Film Settings"));
        }

        addBackButton(layout,
                v -> showCentralHome());

        setScreen(layout);
    }

    // =========================================================
    // GENERIC SETTINGS PAGE
    // =========================================================

    private void showSettingsPage(
            String title,
            String[] items,
            final Runnable backAction
    ) {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(title));

        for (String item : items) {

            addButton(layout, item,
                    v -> showMessage(item));
        }

        addBackButton(layout,
                v -> backAction.run());

        setScreen(layout);
    }

    // =========================================================
    // SIMPLE LIST
    // =========================================================

    private void showSimpleList(
            String title,
            String[] items,
            final Runnable backAction
    ) {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(title));

        for (String item : items) {

            addButton(layout, item,
                    v -> showMessage(item));
        }

        addBackButton(layout,
                v -> backAction.run());

        setScreen(layout);
    }

    // =========================================================
    // MESSAGE / MODULE PAGE
    // =========================================================

    private void showMessage(String name) {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(name));

        layout.addView(createSubtitle(
                "AVESON Central Module"
        ));

        LinearLayout card =
                createCard("MODULE");

        addInfo(card, "Status",
                "Ready for configuration");

        addInfo(card, "Database",
                "Not connected");

        addInfo(card, "Backend",
                "Not connected");

        addInfo(card, "API",
                "Not connected");

        layout.addView(card);

        addBackButton(layout,
                v -> showCentralHome());

        setScreen(layout);
    }
                    }
