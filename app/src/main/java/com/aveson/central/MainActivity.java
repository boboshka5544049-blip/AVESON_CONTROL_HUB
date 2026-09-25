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
    // BASIC HELPERS
    // =========================================================

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
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
        ScrollView scrollView = new ScrollView(this);

        scrollView.setFillViewport(true);
        scrollView.setClipToPadding(false);
        scrollView.setPadding(0, 0, 0, dp(10));

        scrollView.addView(content);

        setContentView(scrollView);
    }

    private TextView createTitle(String text) {
        TextView title = new TextView(this);

        title.setText(text);
        title.setTextColor(Color.WHITE);
        title.setTextSize(23);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, android.graphics.Typeface.BOLD);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 0, 0, dp(8));

        title.setLayoutParams(params);

        return title;
    }

    private TextView createSubtitle(String text) {
        TextView subtitle = new TextView(this);

        subtitle.setText(text);
        subtitle.setTextColor(TEXT_GRAY);
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 0, 0, dp(20));

        subtitle.setLayoutParams(params);

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

        GradientDrawable background = new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(14));
        background.setStroke(dp(1), PURPLE);

        button.setBackground(background);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(52)
                );

        params.setMargins(0, dp(6), 0, dp(6));

        button.setLayoutParams(params);

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

        GradientDrawable background = new GradientDrawable();

        background.setColor(Color.rgb(18, 18, 35));
        background.setCornerRadius(dp(14));
        background.setStroke(dp(1), BLUE);

        button.setBackground(background);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
                (LinearLayout.LayoutParams) button.getLayoutParams();

        params.setMargins(0, dp(18), 0, dp(6));

        button.setLayoutParams(params);

        layout.addView(button);
    }

    private LinearLayout createCard(String title) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));

        GradientDrawable background = new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(16));
        background.setStroke(dp(1), PURPLE);

        card.setBackground(background);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(0, dp(7), 0, dp(7));

        card.setLayoutParams(cardParams);

        TextView titleView = new TextView(this);

        titleView.setText(title);
        titleView.setTextColor(Color.WHITE);
        titleView.setTextSize(17);
        titleView.setTypeface(null, android.graphics.Typeface.BOLD);
        titleView.setGravity(Gravity.CENTER_VERTICAL);

        card.addView(titleView);

        return card;
    }

    private void addStat(LinearLayout card, String name) {

        TextView text = new TextView(this);

        text.setText(name + "\n0");
        text.setTextColor(TEXT_GRAY);
        text.setTextSize(14);
        text.setPadding(0, dp(7), 0, dp(7));

        card.addView(text);
    }

    // =========================================================
    // CENTRAL HOME
    // =========================================================

    private void showCentralHome() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("AVESON CENTRAL"));
        layout.addView(
                createSubtitle("Global Management & Control Platform")
        );

        addButton(
                layout,
                "☰  MENU",
                v -> showGlobalMenu()
        );

        addButton(
                layout,
                "🎵  AVESON ARTIST CONTROL",
                v -> openRoom("ARTIST")
        );

        addButton(
                layout,
                "🎼  AVESON MUSIC CONTROL",
                v -> openRoom("MUSIC")
        );

        addButton(
                layout,
                "🌍  AVESON DISTRIBUTION CONTROL",
                v -> openRoom("DISTRIBUTION")
        );

        addButton(
                layout,
                "🎙️  AVESON STUDIO CONTROL",
                v -> openRoom("STUDIO")
        );

        addButton(
                layout,
                "📰  AVESON MAGAZINE CONTROL",
                v -> openRoom("MAGAZINE")
        );

        addButton(
                layout,
                "🎬  AVESON FILMS",
                v -> openRoom("FILMS")
        );

        setScreen(layout);
    }

    // =========================================================
    // GLOBAL MENU
    // =========================================================

    private void showGlobalMenu() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("☰ MENU"));
        layout.addView(
                createSubtitle("AVESON Central Global Management")
        );

        addButton(
                layout,
                "📊  Analytics",
                v -> showAnalytics()
        );

        addButton(
                layout,
                "💰  Royalty Control",
                v -> showRoyaltyControl()
        );

        addButton(
                layout,
                "🔐  Security",
                v -> showSecurity()
        );

        addButton(
                layout,
                "⚙️  Parameters",
                v -> showParameters()
        );

        addButton(
                layout,
                "🛡️  System Status",
                v -> showSystemStatus()
        );

        addButton(
                layout,
                "ℹ️  AVESON Central Info",
                v -> showCentralInfo()
        );

        addBackButton(
                layout,
                v -> showCentralHome()
        );

        setScreen(layout);
    }

    // =========================================================
    // ANALYTICS
    // =========================================================

    private void showAnalytics() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("📊 ANALYTICS"));
        layout.addView(
                createSubtitle("AVESON Central Analytics")
        );

        LinearLayout artist = createCard("🎵 AVESON ARTIST");

        addStat(artist, "Total Artists");
        addStat(artist, "Registered Artists");
        addStat(artist, "Active Artists");
        addStat(artist, "Inactive Artists");
        addStat(artist, "Song Submissions");
        addStat(artist, "Video Submissions");

        layout.addView(artist);

        LinearLayout music = createCard("🎼 AVESON MUSIC");

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

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // =========================================================
    // ROYALTY CONTROL
    // =========================================================

    private void showRoyaltyControl() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("💰 ROYALTY CONTROL"));
        layout.addView(
                createSubtitle("Revenue & Royalty Management")
        );

        addRoyaltyCard(
                layout,
                "💵 TOTAL REVENUE",
                "Total Revenue",
                "Current Month Revenue",
                "Previous Month Revenue",
                "Revenue Growth"
        );

        addRoyaltyCard(
                layout,
                "🎵 MUSIC REVENUE",
                "Music Revenue",
                "Streaming Revenue",
                "Download Revenue",
                "Other Music Revenue"
        );

        addRoyaltyCard(
                layout,
                "🌍 DISTRIBUTION REVENUE",
                "Distribution Revenue",
                "Platform Revenue",
                "Distribution Fees",
                "Other Distribution Revenue"
        );

        addRoyaltyCard(
                layout,
                "🎬 FILMS REVENUE",
                "Films Revenue",
                "Streaming Revenue",
                "Licensing Revenue",
                "Other Film Revenue"
        );

        addRoyaltyCard(
                layout,
                "🎙️ STUDIO REVENUE",
                "Studio Revenue",
                "Recording Revenue",
                "Production Revenue",
                "Mixing / Mastering Revenue"
        );

        addRoyaltyCard(
                layout,
                "📰 MAGAZINE REVENUE",
                "Magazine Revenue",
                "Advertising Revenue",
                "Subscription Revenue",
                "Other Magazine Revenue"
        );

        addRoyaltyCard(
                layout,
                "💳 PAYMENTS",
                "Completed Payments",
                "Pending Payments",
                "Failed Payments",
                "Payment History"
        );

        addRoyaltyCard(
                layout,
                "👤 ARTIST EARNINGS",
                "Total Artist Earnings",
                "Pending Artist Earnings",
                "Paid Artist Earnings",
                "Artist Royalty Reports"
        );

        addRoyaltyCard(
                layout,
                "🌍 DISTRIBUTION EARNINGS",
                "Total Distribution Earnings",
                "Pending Earnings",
                "Paid Earnings",
                "Distribution Reports"
        );

        addRoyaltyCard(
                layout,
                "📄 ROYALTY REPORTS",
                "Monthly Reports",
                "Artist Reports",
                "Distribution Reports",
                "Revenue Reports"
        );

        addRoyaltyCard(
                layout,
                "📈 REVENUE GROWTH",
                "Monthly Growth",
                "Yearly Growth",
                "Revenue Trends"
        );

        addRoyaltyCard(
                layout,
                "💼 REVENUE SOURCES",
                "Music",
                "Distribution",
                "Films",
                "Studio",
                "Magazine"
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    private void addRoyaltyCard(
            LinearLayout layout,
            String title,
            String... items
    ) {

        LinearLayout card = createCard(title);

        for (String item : items) {
            addStat(card, item + "  $0.00");
        }

        layout.addView(card);
    }

    // =========================================================
    // SECURITY MAIN
    // =========================================================

    private void showSecurity() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🔐 SECURITY"));
        layout.addView(
                createSubtitle("AVESON Central Security")
        );

        addButton(
                layout,
                "👤  ACCESS CONTROL",
                v -> showAccessControl()
        );

        addButton(
                layout,
                "📱  AUTHORIZED DEVICES",
                v -> showAuthorizedDevices()
        );

        addButton(
                layout,
                "📋  LOGIN & ACCESS ACTIVITY",
                v -> showLoginActivity()
        );

        addButton(
                layout,
                "🛡️  SECURITY PROTECTION",
                v -> showSecurityProtection()
        );

        addButton(
                layout,
                "🚨  SECURITY EVENTS",
                v -> showSecurityEvents()
        );

        addButton(
                layout,
                "🔒  PASSWORD & AUTHENTICATION",
                v -> showPasswordAuthentication()
        );

        addButton(
                layout,
                "🌐  NETWORK & API SECURITY",
                v -> showNetworkApiSecurity()
        );

        addButton(
                layout,
                "📋  SECURITY LOGS",
                v -> showSecurityLogs()
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // =========================================================
    // ACCESS CONTROL
    // =========================================================

    private void showAccessControl() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("👤 ACCESS CONTROL"));
        layout.addView(
                createSubtitle("Access & Permission Management")
        );

        addButton(layout, "Administrator Access",
                v -> showAccessRole("ADMINISTRATOR"));

        addButton(layout, "Staff Access",
                v -> showAccessRole("STAFF"));

        addButton(layout, "Artist Control Access",
                v -> showAccessRole("ARTIST"));

        addButton(layout, "Music Control Access",
                v -> showAccessRole("MUSIC"));

        addButton(layout, "Distribution Control Access",
                v -> showAccessRole("DISTRIBUTION"));

        addButton(layout, "Studio Control Access",
                v -> showAccessRole("STUDIO"));

        addButton(layout, "Magazine Control Access",
                v -> showAccessRole("MAGAZINE"));

        addButton(layout, "Films Control Access",
                v -> showAccessRole("FILMS"));

        addButton(layout, "Permission Management",
                v -> showPermissionManagement());

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    private void showAccessRole(String role) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("👤 " + role + " ACCESS")
        );

        layout.addView(
                createSubtitle("Access Management")
        );

        String prefix = role.substring(0, 1)
                + role.substring(1).toLowerCase();

        addButton(
                layout,
                prefix + " Accounts",
                v -> showMessage(prefix + " Accounts")
        );

        addButton(
                layout,
                prefix + " Permissions",
                v -> showMessage(prefix + " Permissions")
        );

        addButton(
                layout,
                prefix + " Sessions",
                v -> showMessage(prefix + " Sessions")
        );

        addButton(
                layout,
                prefix + " Activity",
                v -> showMessage(prefix + " Activity")
        );

        addButton(
                layout,
                prefix + " Security",
                v -> showMessage(prefix + " Security")
        );

        addBackButton(
                layout,
                v -> showAccessControl()
        );

        setScreen(layout);
    }

    private void showPermissionManagement() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🛡️ PERMISSION MANAGEMENT")
        );

        layout.addView(
                createSubtitle("Permission Configuration")
        );

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

        addBackButton(
                layout,
                v -> showAccessControl()
        );

        setScreen(layout);
    }

    // =========================================================
    // AUTHORIZED DEVICES
    // =========================================================

    private void showAuthorizedDevices() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("📱 AUTHORIZED DEVICES"));

        addButton(layout, "Authorized Devices",
                v -> showMessage("Authorized Devices"));

        addButton(layout, "Active Devices",
                v -> showMessage("Active Devices"));

        addButton(layout, "Device Management",
                v -> showMessage("Device Management"));

        addButton(layout, "Add Device",
                v -> showMessage("Add Device"));

        addButton(layout, "Remove Device",
                v -> showMessage("Remove Device"));

        addButton(layout, "Device History",
                v -> showMessage("Device History"));

        addButton(layout, "Blocked Devices",
                v -> showMessage("Blocked Devices"));

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // =========================================================
    // LOGIN ACTIVITY
    // =========================================================

    private void showLoginActivity() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("📋 LOGIN & ACCESS ACTIVITY"));

        addButton(layout, "Login Activity",
                v -> showMessage("Login Activity"));

        addButton(layout, "Successful Logins",
                v -> showMessage("Successful Logins"));

        addButton(layout, "Failed Login Attempts",
                v -> showMessage("Failed Login Attempts"));

        addButton(layout, "Active Sessions",
                v -> showMessage("Active Sessions"));

        addButton(layout, "Session History",
                v -> showMessage("Session History"));

        addButton(layout, "Logout Activity",
                v -> showMessage("Logout Activity"));

        addButton(layout, "Access History",
                v -> showMessage("Access History"));

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // =========================================================
    // SECURITY PROTECTION
    // =========================================================

    private void showSecurityProtection() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🛡️ SECURITY PROTECTION"));

        addButton(layout, "Account Protection",
                v -> showMessage("Account Protection"));

        addButton(layout, "Session Protection",
                v -> showMessage("Session Protection"));

        addButton(layout, "Device Protection",
                v -> showMessage("Device Protection"));

        addButton(layout, "API Protection",
                v -> showMessage("API Protection"));

        addButton(layout, "Data Protection",
                v -> showMessage("Data Protection"));

        addButton(layout, "Encryption Status",
                v -> showMessage("Encryption Status"));

        addButton(layout, "Security Configuration",
                v -> showMessage("Security Configuration"));

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // =========================================================
    // SECURITY EVENTS
    // =========================================================

    private void showSecurityEvents() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🚨 SECURITY EVENTS"));

        addButton(layout, "Security Events",
                v -> showMessage("Security Events"));

        addButton(layout, "Suspicious Activity",
                v -> showMessage("Suspicious Activity"));

        addButton(layout, "Access Violations",
                v -> showMessage("Access Violations"));

        addButton(layout, "Blocked Attempts",
                v -> showMessage("Blocked Attempts"));

        addButton(layout, "Security Alerts",
                v -> showMessage("Security Alerts"));

        addButton(layout, "Critical Events",
                v -> showMessage("Critical Events"));

        addButton(layout, "Event History",
                v -> showMessage("Event History"));

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // =========================================================
    // PASSWORD & AUTHENTICATION
    // =========================================================

    private void showPasswordAuthentication() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🔒 PASSWORD & AUTHENTICATION")
        );

        addButton(layout, "Password Management",
                v -> showMessage("Password Management"));

        addButton(layout, "Authentication Settings",
                v -> showMessage("Authentication Settings"));

        addButton(layout, "Two-Factor Authentication",
                v -> showMessage("Two-Factor Authentication"));

        addButton(layout, "Recovery Settings",
                v -> showMessage("Recovery Settings"));

        addButton(layout, "Authentication History",
                v -> showMessage("Authentication History"));

        addButton(layout, "Password History",
                v -> showMessage("Password History"));

        addButton(layout, "Recovery Activity",
                v -> showMessage("Recovery Activity"));

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // =========================================================
    // NETWORK & API SECURITY
    // =========================================================

    private void showNetworkApiSecurity() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🌐 NETWORK & API SECURITY")
        );

        addButton(layout, "API Security",
                v -> showMessage("API Security"));

        addButton(layout, "API Access",
                v -> showMessage("API Access"));

        addButton(layout, "API Keys",
                v -> showMessage("API Keys"));

        addButton(layout, "HTTPS Status",
                v -> showMessage("HTTPS Status"));

        addButton(layout, "Network Access",
                v -> showMessage("Network Access"));

        addButton(layout, "Request Monitoring",
                v -> showMessage("Request Monitoring"));

        addButton(layout, "API Activity",
                v -> showMessage("API Activity"));

        addButton(layout, "Blocked Requests",
                v -> showMessage("Blocked Requests"));

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // =========================================================
    // SECURITY LOGS
    // =========================================================

    private void showSecurityLogs() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("📋 SECURITY LOGS"));

        addButton(layout, "System Security Logs",
                v -> showMessage("System Security Logs"));

        addButton(layout, "Access Logs",
                v -> showMessage("Access Logs"));

        addButton(layout, "API Logs",
                v -> showMessage("API Logs"));

        addButton(layout, "Device Logs",
                v -> showMessage("Device Logs"));

        addButton(layout, "Authentication Logs",
                v -> showMessage("Authentication Logs"));

        addButton(layout, "Security Event Logs",
                v -> showMessage("Security Event Logs"));

        addButton(layout, "Export Logs",
                v -> showMessage("Export Logs"));

        addButton(layout, "Log History",
                v -> showMessage("Log History"));

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // =========================================================
    // PARAMETERS
    // =========================================================

    private void showParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("⚙️ PARAMETERS"));
        layout.addView(
                createSubtitle("AVESON Central Parameters")
        );

        addButton(
                layout,
                "🌐  Languages",
                v -> showLanguages()
        );

        addButton(
                layout,
                "🎨  Appearance",
                v -> showAppearance()
        );

        addButton(
                layout,
                "🔔  Notifications",
                v -> showNotifications()
        );

        addButton(
                layout,
                "🎵  Music Parameters",
                v -> showMusicParameters()
        );

        addButton(
                layout,
                "🌍  Distribution Parameters",
                v -> showDistributionParameters()
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // =========================================================
    // LANGUAGES
    // =========================================================

    private void showLanguages() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🌐 LANGUAGES"));
        layout.addView(
                createSubtitle("Language Management")
        );

        addButton(
                layout,
                "System Language",
                v -> showMessage("System Language")
        );

        addButton(
                layout,
                "Default Language",
                v -> showMessage("Default Language")
        );

        addButton(
                layout,
                "Available Languages",
                v -> showMessage("Available Languages")
        );

        addButton(
                layout,
                "Language Management",
                v -> showMessage("Language Management")
        );

        addBackButton(
                layout,
                v -> showParameters()
        );

        setScreen(layout);
    }

    // =========================================================
    // APPEARANCE
    // =========================================================

    private void showAppearance() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🎨 APPEARANCE"));
        layout.addView(
                createSubtitle("Interface Appearance Settings")
        );

        addButton(
                layout,
                "Theme",
                v -> showMessage("Theme")
        );

        addButton(
                layout,
                "Dark Mode",
                v -> showMessage("Dark Mode")
        );

        addButton(
                layout,
                "Light Mode",
                v -> showMessage("Light Mode")
        );

        addButton(
                layout,
                "Accent Color",
                v -> showMessage("Accent Color")
        );

        addButton(
                layout,
                "Interface Style",
                v -> showMessage("Interface Style")
        );

        addBackButton(
                layout,
                v -> showParameters()
        );

        setScreen(layout);
    }

    // =========================================================
    // NOTIFICATIONS
    // =========================================================

    private void showNotifications() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🔔 NOTIFICATIONS"));
        layout.addView(
                createSubtitle("AVESON Notification Settings")
        );

        addButton(
                layout,
                "Notifications",
                v -> showMessage("Notifications")
        );

        addButton(
                layout,
                "Push Notifications",
                v -> showMessage("Push Notifications")
        );

        addButton(
                layout,
                "Security Notifications",
                v -> showMessage("Security Notifications")
        );

        addButton(
                layout,
                "System Notifications",
                v -> showMessage("System Notifications")
        );

        addButton(
                layout,
                "Artist Notifications",
                v -> showMessage("Artist Notifications")
        );

        addButton(
                layout,
                "Distribution Notifications",
                v -> showMessage("Distribution Notifications")
        );

        addBackButton(
                layout,
                v -> showParameters()
        );

        setScreen(layout);
    }

    // =========================================================
    // MUSIC PARAMETERS
    // =========================================================

    private void showMusicParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🎵 MUSIC PARAMETERS"));
        layout.addView(
                createSubtitle("Music Standards & Configuration")
        );

        addButton(
                layout,
                "Audio Standards",
                v -> showMessage("Audio Standards")
        );

        addButton(
                layout,
                "Cover Standards",
                v -> showMessage("Cover Standards")
        );

        addButton(
                layout,
                "Release Standards",
                v -> showMessage("Release Standards")
        );

        addButton(
                layout,
                "Metadata Standards",
                v -> showMessage("Metadata Standards")
        );

        addButton(
                layout,
                "Music File Formats",
                v -> showMessage("Music File Formats")
        );

        addButton(
                layout,
                "Music Quality",
                v -> showMessage("Music Quality")
        );

        addBackButton(
                layout,
                v -> showParameters()
        );

        setScreen(layout);
    }

    // =========================================================
    // DISTRIBUTION PARAMETERS
    // =========================================================

    private void showDistributionParameters() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🌍 DISTRIBUTION PARAMETERS")
        );

        layout.addView(
                createSubtitle(
                        "Distribution Standards & Configuration"
                )
        );

        addButton(
                layout,
                "Distribution Standards",
                v -> showMessage("Distribution Standards")
        );

        addButton(
                layout,
                "Platform Settings",
                v -> showMessage("Platform Settings")
        );

        addButton(
                layout,
                "Release Delivery Settings",
                v -> showMessage("Release Delivery Settings")
        );

        addButton(
                layout,
                "Territory Settings",
                v -> showMessage("Territory Settings")
        );

        addButton(
                layout,
                "Distribution Formats",
                v -> showMessage("Distribution Formats")
        );

        addButton(
                layout,
                "Delivery Rules",
                v -> showMessage("Delivery Rules")
        );

        addBackButton(
                layout,
                v -> showParameters()
        );

        setScreen(layout);
    }

    // =========================================================
    // SYSTEM STATUS
    // =========================================================

    private void showSystemStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("🛡️ SYSTEM STATUS"));
        layout.addView(
                createSubtitle("AVESON Central System Status")
        );

        addStatusCard(
                layout,
                "🟢 Central System",
                "ONLINE"
        );

        addStatusCard(
                layout,
                "🟢 Application",
                "RUNNING"
        );

        addStatusCard(
                layout,
                "🟡 Database",
                "NOT CONNECTED"
        );

        addStatusCard(
                layout,
                "🟡 Backend",
                "NOT CONNECTED"
        );

        addStatusCard(
                layout,
                "🟡 HTTPS",
                "NOT CONFIGURED"
        );

        addStatusCard(
                layout,
                "🟡 API",
                "NOT CONNECTED"
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    private void addStatusCard(
            LinearLayout layout,
            String title,
            String status
    ) {

        LinearLayout card = createCard(title);

        TextView statusText = new TextView(this);

        statusText.setText(status);
        statusText.setTextColor(Color.WHITE);
        statusText.setTextSize(15);
        statusText.setPadding(0, dp(8), 0, 0);

        card.addView(statusText);

        layout.addView(card);
    }

    // =========================================================
    // CENTRAL INFO
    // =========================================================

    private void showCentralInfo() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("ℹ️ AVESON CENTRAL INFO"));

        layout.addView(
                createSubtitle(
                        "AVESON Central Global Management Platform"
                )
        );

        LinearLayout card = createCard("AVESON CENTRAL");

        addStat(card, "System: AVESON Central");
        addStat(card, "Platform: Global Music & Media");
        addStat(card, "Management: Centralized");
        addStat(card, "Version: 1.0");
        addStat(card, "Backend: Not Connected");
        addStat(card, "Database: Not Connected");

        layout.addView(card);

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // =========================================================
    // ROOMS
    // =========================================================

    private void openRoom(String room) {

        LinearLayout layout = createRoot();

        String title = "";

        if (room.equals("ARTIST")) {
            title = "🎵 AVESON ARTIST CONTROL";
        } else if (room.equals("MUSIC")) {
            title = "🎼 AVESON MUSIC CONTROL";
        } else if (room.equals("DISTRIBUTION")) {
            title = "🌍 AVESON DISTRIBUTION CONTROL";
        } else if (room.equals("STUDIO")) {
            title = "🎙️ AVESON STUDIO CONTROL";
        } else if (room.equals("MAGAZINE")) {
            title = "📰 AVESON MAGAZINE CONTROL";
        } else if (room.equals("FILMS")) {
            title = "🎬 AVESON FILMS";
        }

        layout.addView(createTitle(title));
        layout.addView(
                createSubtitle("Control Room")
        );

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

        addBackButton(
                layout,
                v -> showCentralHome()
        );

        setScreen(layout);
    }

    // =========================================================
    // GENERIC MESSAGE
    // =========================================================

    private void showMessage(String name) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle(name)
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central Module"
                )
        );

        LinearLayout card =
                createCard("SYSTEM MODULE");

        addStat(
                card,
                "Status: Ready for backend integration"
        );

        addStat(
                card,
                "Database: Not connected"
        );

        addStat(
                card,
                "API: Not connected"
        );

        layout.addView(card);

        addBackButton(
                layout,
                v -> showCentralHome()
        );

        setScreen(layout);
    }
            }
