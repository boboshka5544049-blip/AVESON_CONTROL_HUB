package com.aveson.central;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
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
    private final int TEXT = Color.WHITE;
    private final int TEXT_GRAY = Color.rgb(165, 165, 185);
    private final int GREEN = Color.rgb(70, 220, 130);
    private final int YELLOW = Color.rgb(240, 190, 70);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(DARK);
        getWindow().setNavigationBarColor(DARK);

        showCentralHome();
    }

    // =========================================================
    // BASIC UI
    // =========================================================

    private LinearLayout createRoot() {

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(16), dp(24), dp(16), dp(36));
        root.setBackgroundColor(DARK);

        return root;
    }

    private ScrollView createScroll() {

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setClipToPadding(false);
        scroll.setBackgroundColor(DARK);

        return scroll;
    }

    private void setScreen(LinearLayout layout) {

        ScrollView scroll = createScroll();

        scroll.addView(
                layout,
                new ScrollView.LayoutParams(
                        ScrollView.LayoutParams.MATCH_PARENT,
                        ScrollView.LayoutParams.WRAP_CONTENT
                )
        );

        setContentView(scroll);
    }

    private TextView createTitle(String text) {

        TextView title = new TextView(this);
        title.setText(text);
        title.setTextColor(TEXT);
        title.setTextSize(23);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(dp(4), dp(4), dp(4), dp(8));

        return title;
    }

    private TextView createSubtitle(String text) {

        TextView subtitle = new TextView(this);
        subtitle.setText(text);
        subtitle.setTextColor(TEXT_GRAY);
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(dp(4), 0, dp(4), dp(18));

        return subtitle;
    }

    private Button createButton(String text) {

        Button button = new Button(this);

        button.setText(text);
        button.setTextColor(TEXT);
        button.setTextSize(15);
        button.setAllCaps(false);
        button.setGravity(Gravity.CENTER);
        button.setPadding(dp(10), 0, dp(10), 0);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(CARD);
        bg.setCornerRadius(dp(16));
        bg.setStroke(dp(1), PURPLE);

        button.setBackground(bg);

        return button;
    }

    private void addButton(
            LinearLayout layout,
            String text,
            View.OnClickListener listener
    ) {

        Button button = createButton(text);

        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(52)
                );

        params.setMargins(
                dp(4),
                dp(6),
                dp(4),
                dp(6)
        );

        layout.addView(button, params);
    }

    private LinearLayout createCard(String title) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(CARD);
        bg.setCornerRadius(dp(18));
        bg.setStroke(dp(1), Color.rgb(70, 55, 95));

        card.setBackground(bg);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextColor(PURPLE);
        titleView.setTextSize(16);
        titleView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        titleView.setPadding(0, 0, 0, dp(10));

        card.addView(titleView);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(8),
                0,
                dp(8)
        );

        card.setLayoutParams(params);

        return card;
    }

    private void addInfo(
            LinearLayout card,
            String label,
            String value
    ) {

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);

        TextView left = new TextView(this);
        left.setText(label);
        left.setTextColor(TEXT_GRAY);
        left.setTextSize(14);

        TextView right = new TextView(this);
        right.setText(value);
        right.setTextColor(TEXT);
        right.setTextSize(14);
        right.setGravity(Gravity.RIGHT);

        row.addView(
                left,
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                )
        );

        row.addView(
                right,
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                )
        );

        row.setPadding(0, dp(5), 0, dp(5));

        card.addView(row);
    }

    private void addSectionButton(
            LinearLayout layout,
            String title,
            String subtitle,
            View.OnClickListener listener
    ) {

        Button button = createButton(title + "\n" + subtitle);
        button.setTextSize(14);

        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(62)
                );

        params.setMargins(
                dp(4),
                dp(5),
                dp(4),
                dp(5)
        );

        layout.addView(button, params);
    }

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
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

        addButton(
                layout,
                "☰ MENU",
                v -> showGlobalMenu()
        );

        addButton(
                layout,
                "🎵 AVESON ARTIST CONTROL",
                v -> openRoom("ARTIST")
        );

        addButton(
                layout,
                "🎼 AVESON MUSIC CONTROL",
                v -> openRoom("MUSIC")
        );

        addButton(
                layout,
                "🌍 AVESON DISTRIBUTION CONTROL",
                v -> openRoom("DISTRIBUTION")
        );

        addButton(
                layout,
                "🎙️ AVESON STUDIO CONTROL",
                v -> openRoom("STUDIO")
        );

        addButton(
                layout,
                "📰 AVESON MAGAZINE CONTROL",
                v -> openRoom("MAGAZINE")
        );

        addButton(
                layout,
                "🎬 AVESON FILMS",
                v -> openRoom("FILMS")
        );

        setScreen(layout);
    }

    // =========================================================
    // GLOBAL MENU
    // =========================================================

    private void showGlobalMenu() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("AVESON CENTRAL MENU"));
        layout.addView(createSubtitle(
                "Global Central Management"
        ));

        addButton(
                layout,
                "📊 Analytics",
                v -> showAnalytics()
        );

        addButton(
                layout,
                "💰 Royalty Control",
                v -> showRoyaltyControl()
        );

        addButton(
                layout,
                "🔐 Security",
                v -> showSecurity()
        );

        addButton(
                layout,
                "⚙️ Parameters",
                v -> showParameters()
        );

        addButton(
                layout,
                "🛡️ System Status",
                v -> showSystemStatus()
        );

        addButton(
                layout,
                "ℹ️ AVESON Central Info",
                v -> showAvesonCentralInfo()
        );

        addButton(
                layout,
                "← BACK",
                v -> showCentralHome()
        );

        setScreen(layout);
    }

    // =========================================================
    // ANALYTICS
    // =========================================================

    private void showAnalytics() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("ANALYTICS"));
        layout.addView(createSubtitle(
                "AVESON Central Analytics"
        ));

        LinearLayout artist = createCard("🎵 AVESON ARTIST");

        addInfo(artist, "Total Artists", "0");
        addInfo(artist, "Registered Artists", "0");
        addInfo(artist, "Active Artists", "0");
        addInfo(artist, "Inactive Artists", "0");
        addInfo(artist, "Song Submissions", "0");
        addInfo(artist, "Video Submissions", "0");

        layout.addView(artist);

        LinearLayout music = createCard("🎼 AVESON MUSIC");

        addInfo(music, "Total Users", "0");
        addInfo(music, "Registered Users", "0");
        addInfo(music, "Active Users", "0");
        addInfo(music, "Total Tracks", "0");
        addInfo(music, "Total Albums", "0");
        addInfo(music, "Total Streams", "0");

        layout.addView(music);

        LinearLayout distribution =
                createCard("🌍 AVESON DISTRIBUTION");

        addInfo(distribution, "Total Users", "0");
        addInfo(distribution, "Registered Users", "0");
        addInfo(distribution, "Total Releases", "0");
        addInfo(distribution, "Connected Platforms", "0");
        addInfo(distribution, "Delivered Releases", "0");
        addInfo(distribution, "Pending Releases", "0");

        layout.addView(distribution);

        LinearLayout studio =
                createCard("🎙️ AVESON STUDIO");

        addInfo(studio, "Total Users", "0");
        addInfo(studio, "Registered Users", "0");
        addInfo(studio, "Active Users", "0");
        addInfo(studio, "Studio Projects", "0");
        addInfo(studio, "Audio Projects", "0");
        addInfo(studio, "Studio Files", "0");

        layout.addView(studio);

        LinearLayout magazine =
                createCard("📰 AVESON MAGAZINE");

        addInfo(magazine, "Total Users", "0");
        addInfo(magazine, "Registered Users", "0");
        addInfo(magazine, "Total Articles", "0");
        addInfo(magazine, "Total Views", "0");
        addInfo(magazine, "Writers", "0");
        addInfo(magazine, "Published Articles", "0");

        layout.addView(magazine);

        LinearLayout films =
                createCard("🎬 AVESON FILMS");

        addInfo(films, "Total Users", "0");
        addInfo(films, "Registered Users", "0");
        addInfo(films, "Active Users", "0");
        addInfo(films, "Total Projects", "0");
        addInfo(films, "Total Films", "0");
        addInfo(films, "Total Views", "0");

        layout.addView(films);

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // =========================================================
    // ROYALTY CONTROL
    // =========================================================

    private void showRoyaltyControl() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("ROYALTY CONTROL"));
        layout.addView(createSubtitle(
                "Revenue & Royalty Management"
        ));

        LinearLayout total =
                createCard("💵 TOTAL REVENUE");

        addInfo(total, "Total Revenue", "$0.00");
        addInfo(total, "Current Month Revenue", "$0.00");
        addInfo(total, "Previous Month Revenue", "$0.00");
        addInfo(total, "Revenue Growth", "0%");

        layout.addView(total);

        LinearLayout music =
                createCard("🎵 MUSIC REVENUE");

        addInfo(music, "Music Revenue", "$0.00");
        addInfo(music, "Streaming Revenue", "$0.00");
        addInfo(music, "Download Revenue", "$0.00");
        addInfo(music, "Other Music Revenue", "$0.00");

        layout.addView(music);

        LinearLayout distribution =
                createCard("🌍 DISTRIBUTION REVENUE");

        addInfo(distribution, "Distribution Revenue", "$0.00");
        addInfo(distribution, "Platform Revenue", "$0.00");
        addInfo(distribution, "Distribution Fees", "$0.00");
        addInfo(distribution, "Other Distribution Revenue", "$0.00");

        layout.addView(distribution);

        LinearLayout films =
                createCard("🎬 FILMS REVENUE");

        addInfo(films, "Films Revenue", "$0.00");
        addInfo(films, "Streaming Revenue", "$0.00");
        addInfo(films, "Licensing Revenue", "$0.00");
        addInfo(films, "Other Film Revenue", "$0.00");

        layout.addView(films);

        LinearLayout studio =
                createCard("🎙️ STUDIO REVENUE");

        addInfo(studio, "Studio Revenue", "$0.00");
        addInfo(studio, "Recording Revenue", "$0.00");
        addInfo(studio, "Production Revenue", "$0.00");
        addInfo(studio, "Mixing / Mastering Revenue", "$0.00");

        layout.addView(studio);

        LinearLayout magazine =
                createCard("📰 MAGAZINE REVENUE");

        addInfo(magazine, "Magazine Revenue", "$0.00");
        addInfo(magazine, "Advertising Revenue", "$0.00");
        addInfo(magazine, "Subscription Revenue", "$0.00");
        addInfo(magazine, "Other Magazine Revenue", "$0.00");

        layout.addView(magazine);

        LinearLayout payments =
                createCard("💳 PAYMENTS");

        addInfo(payments, "Completed Payments", "0");
        addInfo(payments, "Pending Payments", "0");
        addInfo(payments, "Failed Payments", "0");
        addInfo(payments, "Payment History", "Available");

        layout.addView(payments);

        LinearLayout artist =
                createCard("👤 ARTIST EARNINGS");

        addInfo(artist, "Total Artist Earnings", "$0.00");
        addInfo(artist, "Pending Artist Earnings", "$0.00");
        addInfo(artist, "Paid Artist Earnings", "$0.00");
        addInfo(artist, "Artist Royalty Reports", "Available");

        layout.addView(artist);

        LinearLayout distributionEarnings =
                createCard("🌍 DISTRIBUTION EARNINGS");

        addInfo(distributionEarnings,
                "Total Distribution Earnings",
                "$0.00");

        addInfo(distributionEarnings,
                "Pending Earnings",
                "$0.00");

        addInfo(distributionEarnings,
                "Paid Earnings",
                "$0.00");

        addInfo(distributionEarnings,
                "Distribution Reports",
                "Available");

        layout.addView(distributionEarnings);

        LinearLayout reports =
                createCard("📄 ROYALTY REPORTS");

        addInfo(reports, "Monthly Reports", "Available");
        addInfo(reports, "Artist Reports", "Available");
        addInfo(reports, "Distribution Reports", "Available");
        addInfo(reports, "Revenue Reports", "Available");

        layout.addView(reports);

        LinearLayout growth =
                createCard("📈 REVENUE GROWTH");

        addInfo(growth, "Monthly Growth", "0%");
        addInfo(growth, "Yearly Growth", "0%");
        addInfo(growth, "Revenue Trends", "No Data");

        layout.addView(growth);

        LinearLayout sources =
                createCard("💼 REVENUE SOURCES");

        addInfo(sources, "Music", "$0.00");
        addInfo(sources, "Distribution", "$0.00");
        addInfo(sources, "Films", "$0.00");
        addInfo(sources, "Studio", "$0.00");
        addInfo(sources, "Magazine", "$0.00");

        layout.addView(sources);

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // =========================================================
    // SECURITY
    // =========================================================

    private void showSecurity() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("SECURITY"));
        layout.addView(createSubtitle(
                "AVESON Central Security Management"
        ));

        addButton(layout,
                "👤 ACCESS CONTROL",
                v -> showAccessControl());

        addButton(layout,
                "📱 AUTHORIZED DEVICES",
                v -> showAuthorizedDevices());

        addButton(layout,
                "📋 LOGIN & ACCESS ACTIVITY",
                v -> showLoginActivity());

        addButton(layout,
                "🛡️ SECURITY PROTECTION",
                v -> showSecurityProtection());

        addButton(layout,
                "🚨 SECURITY EVENTS",
                v -> showSecurityEvents());

        addButton(layout,
                "🔒 PASSWORD & AUTHENTICATION",
                v -> showPasswordAuthentication());

        addButton(layout,
                "🌐 NETWORK & API SECURITY",
                v -> showNetworkApiSecurity());

        addButton(layout,
                "📋 SECURITY LOGS",
                v -> showSecurityLogs());

        addButton(layout,
                "← BACK",
                v -> showGlobalMenu());

        setScreen(layout);
    }

    private void showAccessControl() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("ACCESS CONTROL"));
        layout.addView(createSubtitle(
                "Central roles and access management"
        ));

        addButton(layout, "Administrator Access",
                v -> showRoleDetails("ADMINISTRATOR"));

        addButton(layout, "Staff Access",
                v -> showRoleDetails("STAFF"));

        addButton(layout, "Artist Control Access",
                v -> showRoleDetails("ARTIST CONTROL"));

        addButton(layout, "Music Control Access",
                v -> showRoleDetails("MUSIC CONTROL"));

        addButton(layout, "Distribution Control Access",
                v -> showRoleDetails("DISTRIBUTION CONTROL"));

        addButton(layout, "Studio Control Access",
                v -> showRoleDetails("STUDIO CONTROL"));

        addButton(layout, "Magazine Control Access",
                v -> showRoleDetails("MAGAZINE CONTROL"));

        addButton(layout, "Films Control Access",
                v -> showRoleDetails("FILMS CONTROL"));

        addButton(layout, "Permission Management",
                v -> showPermissionManagement());

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    private void showRoleDetails(String role) {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(role));
        layout.addView(createSubtitle(
                "Role Access Management"
        ));

        LinearLayout card = createCard("ROLE INFORMATION");

        addInfo(card, "Role", role);
        addInfo(card, "Accounts", "Available");
        addInfo(card, "Permissions", "Available");
        addInfo(card, "Sessions", "Available");
        addInfo(card, "Activity", "Available");
        addInfo(card, "Security", "Protected");

        layout.addView(card);

        addButton(layout, "← BACK",
                v -> showAccessControl());

        setScreen(layout);
    }

    private void showPermissionManagement() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("PERMISSION MANAGEMENT"));
        layout.addView(createSubtitle(
                "Roles, rules and access policies"
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

        addButton(layout, "← BACK",
                v -> showAccessControl());

        setScreen(layout);
    }

    private void showAuthorizedDevices() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("AUTHORIZED DEVICES"));

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

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    private void showLoginActivity() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("LOGIN & ACCESS ACTIVITY"));

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

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    private void showSecurityProtection() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("SECURITY PROTECTION"));

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

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    private void showSecurityEvents() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("SECURITY EVENTS"));

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

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    private void showPasswordAuthentication() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("PASSWORD & AUTHENTICATION"));

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

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    private void showNetworkApiSecurity() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("NETWORK & API SECURITY"));

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

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    private void showSecurityLogs() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("SECURITY LOGS"));

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

        addButton(layout, "← BACK",
                v -> showSecurity());

        setScreen(layout);
    }

    // =========================================================
    // PARAMETERS
    // =========================================================

    private void showParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("PARAMETERS"));
        layout.addView(createSubtitle(
                "AVESON Central Configuration"
        ));

        addButton(layout,
                "🌐 Languages",
                v -> showLanguages());

        addButton(layout,
                "🎨 Appearance",
                v -> showAppearance());

        addButton(layout,
                "🔔 Notifications",
                v -> showNotifications());

        addButton(layout,
                "🎵 Music Parameters",
                v -> showMusicParameters());

        addButton(layout,
                "🌍 Distribution Parameters",
                v -> showDistributionParameters());

        addButton(layout,
                "← BACK",
                v -> showGlobalMenu());

        setScreen(layout);
    }

    // =========================================================
    // LANGUAGES
    // =========================================================

    private void showLanguages() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("LANGUAGES"));

        LinearLayout system =
                createCard("SYSTEM LANGUAGE");

        addInfo(system, "English", "Available");
        addInfo(system, "Uzbek", "Available");
        addInfo(system, "Russian", "Available");
        addInfo(system, "Turkish", "Available");
        addInfo(system, "Spanish", "Available");
        addInfo(system, "French", "Available");
        addInfo(system, "German", "Available");
        addInfo(system, "Arabic", "Available");

        layout.addView(system);

        LinearLayout def =
                createCard("DEFAULT LANGUAGE");

        addInfo(def, "Current Default", "English");
        addInfo(def, "Status", "Configured");

        layout.addView(def);

        addButton(layout, "Change Default Language",
                v -> showMessage("Change Default Language"));

        LinearLayout available =
                createCard("AVAILABLE LANGUAGES");

        addInfo(available, "English", "Available");
        addInfo(available, "Uzbek", "Available");
        addInfo(available, "Russian", "Available");
        addInfo(available, "Turkish", "Available");
        addInfo(available, "Spanish", "Available");
        addInfo(available, "French", "Available");
        addInfo(available, "German", "Available");
        addInfo(available, "Arabic", "Available");
        addInfo(available, "Portuguese", "Available");
        addInfo(available, "Italian", "Available");
        addInfo(available, "Chinese", "Available");
        addInfo(available, "Japanese", "Available");
        addInfo(available, "Korean", "Available");

        layout.addView(available);

        addButton(layout, "Add Language",
                v -> showMessage("Add Language"));

        addButton(layout, "Remove Language",
                v -> showMessage("Remove Language"));

        addButton(layout, "Edit Language",
                v -> showMessage("Edit Language"));

        addButton(layout, "Set Default",
                v -> showMessage("Set Default"));

        addButton(layout, "Language Order",
                v -> showMessage("Language Order"));

        addButton(layout, "← BACK",
                v -> showParameters());

        setScreen(layout);
    }

    // =========================================================
    // APPEARANCE
    // =========================================================

    private void showAppearance() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("APPEARANCE"));

        LinearLayout theme =
                createCard("THEME");

        addInfo(theme, "AVESON Dark", "Available");
        addInfo(theme, "AVESON Neon", "Available");
        addInfo(theme, "AVESON Cinema", "Available");
        addInfo(theme, "Custom Theme", "Available");

        layout.addView(theme);

        LinearLayout dark =
                createCard("DARK MODE");

        addInfo(dark, "Status", "Enabled");
        addInfo(dark, "Interface", "Dark");
        addInfo(dark, "Background", "AVESON Dark");

        layout.addView(dark);

        addButton(layout, "Enable Dark Mode",
                v -> showMessage("Dark Mode"));

        LinearLayout light =
                createCard("LIGHT MODE");

        addInfo(light, "Status", "Available");
        addInfo(light, "Interface", "Light");

        layout.addView(light);

        addButton(layout, "Enable Light Mode",
                v -> showMessage("Light Mode"));

        LinearLayout accent =
                createCard("ACCENT COLOR");

        addInfo(accent, "AVESON Purple", "Available");
        addInfo(accent, "AVESON Blue", "Available");
        addInfo(accent, "Purple / Blue", "Available");
        addInfo(accent, "Custom Color", "Available");

        layout.addView(accent);

        LinearLayout style =
                createCard("INTERFACE STYLE");

        addInfo(style, "Compact", "Available");
        addInfo(style, "Standard", "Available");
        addInfo(style, "Premium", "Available");
        addInfo(style, "Cinematic", "Available");

        layout.addView(style);

        addButton(layout, "← BACK",
                v -> showParameters());

        setScreen(layout);
    }

    // =========================================================
    // NOTIFICATIONS
    // =========================================================

    private void showNotifications() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("NOTIFICATIONS"));

        LinearLayout notifications =
                createCard("NOTIFICATIONS");

        addInfo(notifications, "Enable Notifications", "Enabled");
        addInfo(notifications, "Notification Sound", "Enabled");
        addInfo(notifications, "Notification Badge", "Enabled");
        addInfo(notifications, "Notification Preview", "Enabled");
        addInfo(notifications, "Notification History", "Available");

        layout.addView(notifications);

        LinearLayout push =
                createCard("PUSH NOTIFICATIONS");

        addInfo(push, "Enable Push Notifications", "Enabled");
        addInfo(push, "Push Sound", "Enabled");
        addInfo(push, "Push Vibration", "Enabled");
        addInfo(push, "Push Badge", "Enabled");
        addInfo(push, "Push Priority", "Normal");

        layout.addView(push);

        LinearLayout security =
                createCard("SECURITY NOTIFICATIONS");

        addInfo(security, "Security Alerts", "Enabled");
        addInfo(security, "Login Alerts", "Enabled");
        addInfo(security, "New Device Alerts", "Enabled");
        addInfo(security, "Access Alerts", "Enabled");
        addInfo(security, "Critical Security Alerts", "Enabled");

        layout.addView(security);

        LinearLayout system =
                createCard("SYSTEM NOTIFICATIONS");

        addInfo(system, "System Alerts", "Enabled");
        addInfo(system, "System Updates", "Enabled");
        addInfo(system, "Maintenance Alerts", "Enabled");
        addInfo(system, "Service Alerts", "Enabled");
        addInfo(system, "System Errors", "Enabled");

        layout.addView(system);

        LinearLayout artist =
                createCard("ARTIST NOTIFICATIONS");

        addInfo(artist, "New Artist Submission", "Enabled");
        addInfo(artist, "Submission Review", "Enabled");
        addInfo(artist, "Release Approval", "Enabled");
        addInfo(artist, "Release Rejection", "Enabled");
        addInfo(artist, "Artist Activity", "Enabled");

        layout.addView(artist);

        LinearLayout distribution =
                createCard("DISTRIBUTION NOTIFICATIONS");

        addInfo(distribution, "Delivery Completed", "Enabled");
        addInfo(distribution, "Delivery Failed", "Enabled");
        addInfo(distribution, "Platform Update", "Enabled");
        addInfo(distribution, "Release Status", "Enabled");
        addInfo(distribution, "Distribution Alerts", "Enabled");

        layout.addView(distribution);

        addButton(layout, "← BACK",
                v -> showParameters());

        setScreen(layout);
    }

    // =========================================================
    // MUSIC PARAMETERS
    // =========================================================

    private void showMusicParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("MUSIC PARAMETERS"));
        layout.addView(createSubtitle(
                "Music standards and requirements"
        ));

        addButton(layout,
                "🎧 Audio Standards",
                v -> showAudioStandards());

        addButton(layout,
                "🖼️ Cover Standards",
                v -> showCoverStandards());

        addButton(layout,
                "📀 Release Standards",
                v -> showReleaseStandards());

        addButton(layout,
                "🏷️ Metadata Standards",
                v -> showMetadataStandards());

        addButton(layout,
                "📁 Music File Formats",
                v -> showMusicFileFormats());

        addButton(layout,
                "🎚️ Music Quality",
                v -> showMusicQuality());

        addButton(layout, "← BACK",
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

        addButton(layout, "← BACK",
                v -> showMusicParameters());

        setScreen(layout);
    }

    private void showCoverStandards() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("COVER STANDARDS"));

        LinearLayout card =
                createCard("AVESON COVER STANDARD");

        addInfo(card, "Minimum Size", "3000 × 3000 px");
        addInfo(card, "Recommended", "3000 × 3000 px or larger");
        addInfo(card, "Format", "JPG / PNG");
        addInfo(card, "Quality", "High Resolution");
        addInfo(card, "Content", "Genre appropriate");

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

        addButton(layout, "← BACK",
                v -> showMusicParameters());

        setScreen(layout);
    }

    private void showReleaseStandards() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("RELEASE STANDARDS"));

        addButton(layout, "Release Title",
                v -> showMessage("Release Title"));

        addButton(layout, "Artist Name",
                v -> showMessage("Artist Name"));

        addButton(layout, "Release Type",
                v -> showMessage("Release Type"));

        addButton(layout, "Release Date",
                v -> showMessage("Release Date"));

        addButton(layout, "Copyright Information",
                v -> showMessage("Copyright Information"));

        addButton(layout, "Label Information",
                v -> showMessage("Label Information"));

        addButton(layout, "Genre",
                v -> showMessage("Genre"));

        addButton(layout, "Language",
                v -> showMessage("Language"));

        addButton(layout, "Explicit Content",
                v -> showMessage("Explicit Content"));

        addButton(layout, "Release Validation",
                v -> showMessage("Release Validation"));

        addButton(layout, "← BACK",
                v -> showMusicParameters());

        setScreen(layout);
    }

    private void showMetadataStandards() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("METADATA STANDARDS"));

        addButton(layout, "Track Title",
                v -> showMessage("Track Title"));

        addButton(layout, "Artist Metadata",
                v -> showMessage("Artist Metadata"));

        addButton(layout, "Album Metadata",
                v -> showMessage("Album Metadata"));

        addButton(layout, "Genre Metadata",
                v -> showMessage("Genre Metadata"));

        addButton(layout, "Copyright Metadata",
                v -> showMessage("Copyright Metadata"));

        addButton(layout, "ISRC",
                v -> showMessage("ISRC"));

        addButton(layout, "UPC / EAN",
                v -> showMessage("UPC / EAN"));

        addButton(layout, "Composer",
                v -> showMessage("Composer"));

        addButton(layout, "Producer",
                v -> showMessage("Producer"));

        addButton(layout, "Metadata Validation",
                v -> showMessage("Metadata Validation"));

        addButton(layout, "← BACK",
                v -> showMusicParameters());

        setScreen(layout);
    }

    private void showMusicFileFormats() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("MUSIC FILE FORMATS"));

        addButton(layout, "WAV",
                v -> showMessage("WAV"));

        addButton(layout, "FLAC",
                v -> showMessage("FLAC"));

        addButton(layout, "MP3",
                v -> showMessage("MP3"));

        addButton(layout, "AAC",
                v -> showMessage("AAC"));

        addButton(layout, "Supported Formats",
                v -> showMessage("Supported Formats"));

        addButton(layout, "Format Validation",
                v -> showMessage("Format Validation"));

        addButton(layout, "← BACK",
                v -> showMusicParameters());

        setScreen(layout);
    }

    private void showMusicQuality() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("MUSIC QUALITY"));

        addButton(layout, "Standard Quality",
                v -> showMessage("Standard Quality"));

        addButton(layout, "High Quality",
                v -> showMessage("High Quality"));

        addButton(layout, "Lossless Quality",
                v -> showMessage("Lossless Quality"));

        addButton(layout, "Master Quality",
                v -> showMessage("Master Quality"));

        addButton(layout, "Quality Validation",
                v -> showMessage("Quality Validation"));

        addButton(layout, "← BACK",
                v -> showMusicParameters());

        setScreen(layout);
    }

    // =========================================================
    // DISTRIBUTION PARAMETERS
    // =========================================================

    private void showDistributionParameters() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("DISTRIBUTION PARAMETERS"));
        layout.addView(createSubtitle(
                "Distribution configuration and rules"
        ));

        addButton(layout,
                "Distribution Standards",
                v -> showDistributionStandards());

        addButton(layout,
                "Platform Settings",
                v -> showPlatformSettings());

        addButton(layout,
                "Release Delivery Settings",
                v -> showReleaseDeliverySettings());

        addButton(layout,
                "Territory Settings",
                v -> showTerritorySettings());

        addButton(layout,
                "Distribution Formats",
                v -> showDistributionFormats());

        addButton(layout,
                "Delivery Rules",
                v -> showDeliveryRules());

        addButton(layout, "← BACK",
                v -> showParameters());

        setScreen(layout);
    }

    private void showDistributionStandards() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("DISTRIBUTION STANDARDS"));

        addButton(layout, "Release Requirements",
                v -> showMessage("Release Requirements"));

        addButton(layout, "Audio Requirements",
                v -> showMessage("Audio Requirements"));

        addButton(layout, "Cover Requirements",
                v -> showMessage("Cover Requirements"));

        addButton(layout, "Metadata Requirements",
                v -> showMessage("Metadata Requirements"));

        addButton(layout, "Copyright Requirements",
                v -> showMessage("Copyright Requirements"));

        addButton(layout, "Artist Requirements",
                v -> showMessage("Artist Requirements"));

        addButton(layout, "Content Requirements",
                v -> showMessage("Content Requirements"));

        addButton(layout, "Validation Rules",
                v -> showMessage("Validation Rules"));

        addButton(layout, "← BACK",
                v -> showDistributionParameters());

        setScreen(layout);
    }

    private void showPlatformSettings() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("PLATFORM SETTINGS"));

        addButton(layout, "Platform List",
                v -> showMessage("Platform List"));

        addButton(layout, "Platform Connections",
                v -> showMessage("Platform Connections"));

        addButton(layout, "Platform Status",
                v -> showMessage("Platform Status"));

        addButton(layout, "Platform Credentials",
                v -> showMessage("Platform Credentials"));

        addButton(layout, "Platform Rules",
                v -> showMessage("Platform Rules"));

        addButton(layout, "Platform Mapping",
                v -> showMessage("Platform Mapping"));

        addButton(layout, "← BACK",
                v -> showDistributionParameters());

        setScreen(layout);
    }

    private void showReleaseDeliverySettings() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("RELEASE DELIVERY SETTINGS"));

        addButton(layout, "Automatic Delivery",
                v -> showMessage("Automatic Delivery"));

        addButton(layout, "Manual Delivery",
                v -> showMessage("Manual Delivery"));

        addButton(layout, "Delivery Schedule",
                v -> showMessage("Delivery Schedule"));

        addButton(layout, "Delivery Priority",
                v -> showMessage("Delivery Priority"));

        addButton(layout, "Delivery Retry",
                v -> showMessage("Delivery Retry"));

        addButton(layout, "Delivery Status",
                v -> showMessage("Delivery Status"));

        addButton(layout, "Delivery Confirmation",
                v -> showMessage("Delivery Confirmation"));

        addButton(layout, "← BACK",
                v -> showDistributionParameters());

        setScreen(layout);
    }

    private void showTerritorySettings() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("TERRITORY SETTINGS"));

        addButton(layout, "Worldwide",
                v -> showMessage("Worldwide"));

        addButton(layout, "Country Management",
                v -> showMessage("Country Management"));

        addButton(layout, "Territory Groups",
                v -> showMessage("Territory Groups"));

        addButton(layout, "Restricted Territories",
                v -> showMessage("Restricted Territories"));

        addButton(layout, "Territory Rules",
                v -> showMessage("Territory Rules"));

        addButton(layout, "← BACK",
                v -> showDistributionParameters());

        setScreen(layout);
    }

    private void showDistributionFormats() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("DISTRIBUTION FORMATS"));

        addButton(layout, "Audio Distribution",
                v -> showMessage("Audio Distribution"));

        addButton(layout, "Video Distribution",
                v -> showMessage("Video Distribution"));

        addButton(layout, "Streaming Format",
                v -> showMessage("Streaming Format"));

        addButton(layout, "Download Format",
                v -> showMessage("Download Format"));

        addButton(layout, "Master Format",
                v -> showMessage("Master Format"));

        addButton(layout, "Platform Format Mapping",
                v -> showMessage("Platform Format Mapping"));

        addButton(layout, "← BACK",
                v -> showDistributionParameters());

        setScreen(layout);
    }

    private void showDeliveryRules() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("DELIVERY RULES"));

        addButton(layout, "Automatic Approval",
                v -> showMessage("Automatic Approval"));

        addButton(layout, "Manual Approval",
                v -> showMessage("Manual Approval"));

        addButton(layout, "Quality Check",
                v -> showMessage("Quality Check"));

        addButton(layout, "Metadata Check",
                v -> showMessage("Metadata Check"));

        addButton(layout, "Copyright Check",
                v -> showMessage("Copyright Check"));

        addButton(layout, "Platform Check",
                v -> showMessage("Platform Check"));

        addButton(layout, "Delivery Validation",
                v -> showMessage("Delivery Validation"));

        addButton(layout, "Failure Handling",
                v -> showMessage("Failure Handling"));

        addButton(layout, "← BACK",
                v -> showDistributionParameters());

        setScreen(layout);
    }

    // =========================================================
    // SYSTEM STATUS
    // =========================================================

    private void showSystemStatus() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("SYSTEM STATUS"));
        layout.addView(createSubtitle(
                "AVESON Central System Monitoring"
        ));

        LinearLayout central =
                createCard("🖥️ CENTRAL SYSTEM");

        addInfo(central, "Central System", "ONLINE");
        addInfo(central, "Application", "RUNNING");
        addInfo(central, "Runtime", "ACTIVE");
        addInfo(central, "Version", "1.0");
        addInfo(central, "Uptime", "Not available");
        addInfo(central, "Process Status", "RUNNING");

        layout.addView(central);

        LinearLayout database =
                createCard("💾 DATABASE");

        addInfo(database, "Database Status", "NOT CONNECTED");
        addInfo(database, "Connection Status", "NOT CONNECTED");
        addInfo(database, "Database Type", "Not configured");
        addInfo(database, "Database Version", "Not available");
        addInfo(database, "Connection Pool", "Not available");
        addInfo(database, "Last Check", "Not available");

        layout.addView(database);

        LinearLayout backend =
                createCard("🌐 BACKEND");

        addInfo(backend, "Backend Status", "NOT CONNECTED");
        addInfo(backend, "API Server", "NOT CONNECTED");
        addInfo(backend, "Service Status", "NOT CONNECTED");
        addInfo(backend, "Endpoint Status", "NOT CONFIGURED");
        addInfo(backend, "Server Region", "Not configured");
        addInfo(backend, "Last Response", "Not available");

        layout.addView(backend);

        LinearLayout api =
                createCard("🔌 API");

        addInfo(api, "API Status", "NOT CONNECTED");
        addInfo(api, "API Version", "Not configured");
        addInfo(api, "API Endpoint", "Not configured");
        addInfo(api, "Request Status", "Not available");
        addInfo(api, "Response Status", "Not available");
        addInfo(api, "Rate Limit", "Not available");
        addInfo(api, "API Activity", "No data");

        layout.addView(api);

        LinearLayout https =
                createCard("🔐 HTTPS / SSL");

        addInfo(https, "HTTPS Status", "NOT CONFIGURED");
        addInfo(https, "SSL Certificate", "Not configured");
        addInfo(https, "Certificate Expiry", "Not available");
        addInfo(https, "TLS Version", "Not configured");
        addInfo(https, "Secure Connection", "Not configured");

        layout.addView(https);

        LinearLayout services =
                createCard("🛠️ SERVICES");

        addInfo(services, "Music Service", "NOT CONNECTED");
        addInfo(services, "Distribution Service", "NOT CONNECTED");
        addInfo(services, "Studio Service", "NOT CONNECTED");
        addInfo(services, "Magazine Service", "NOT CONNECTED");
        addInfo(services, "Films Service", "NOT CONNECTED");
        addInfo(services, "Notification Service", "NOT CONNECTED");
        addInfo(services, "Authentication Service", "NOT CONNECTED");

        layout.addView(services);

        LinearLayout storage =
                createCard("📦 STORAGE");

        addInfo(storage, "Storage Status", "NOT CONFIGURED");
        addInfo(storage, "File Storage", "Not connected");
        addInfo(storage, "Media Storage", "Not connected");
        addInfo(storage, "Database Storage", "Not connected");
        addInfo(storage, "Available Storage", "Not available");
        addInfo(storage, "Storage Usage", "0%");

        layout.addView(storage);

        LinearLayout monitoring =
                createCard("📊 SYSTEM MONITORING");

        addInfo(monitoring, "CPU Usage", "0%");
        addInfo(monitoring, "Memory Usage", "0%");
        addInfo(monitoring, "Network Status", "NOT CONNECTED");
        addInfo(monitoring, "Request Monitor", "No data");
        addInfo(monitoring, "Error Monitor", "No data");
        addInfo(monitoring, "System Logs", "Available");
        addInfo(monitoring, "Health Check", "Not performed");

        layout.addView(monitoring);

        LinearLayout operations =
                createCard("🔄 SYSTEM OPERATIONS");

        addInfo(operations, "Refresh Status", "Available");
        addInfo(operations, "Run Health Check", "Available");
        addInfo(operations, "Service Restart", "Not connected");
        addInfo(operations, "Maintenance Mode", "Disabled");
        addInfo(operations, "System Update", "Available");
        addInfo(operations, "System Diagnostics", "Available");

        layout.addView(operations);

        addButton(layout,
                "← BACK",
                v -> showGlobalMenu());

        setScreen(layout);
    }

    // =========================================================
    // AVESON CENTRAL INFO
    // =========================================================

    private void showAvesonCentralInfo() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("AVESON CENTRAL INFO"));
        layout.addView(createSubtitle(
                "Information about the AVESON Central management platform"
        ));

        LinearLayout central =
                createCard("🏢 AVESON CENTRAL");

        addInfo(central, "System Name", "AVESON CENTRAL");
        addInfo(central, "Platform Type", "Global Management Platform");
        addInfo(central, "System Version", "1.0");
        addInfo(central, "System Status", "ONLINE");
        addInfo(central, "Platform Status", "RUNNING");

        layout.addView(central);

        LinearLayout ecosystem =
                createCard("🎵 AVESON ECOSYSTEM");

        addInfo(ecosystem,
                "Artist Management",
                "AVESON ARTIST CONTROL");

        addInfo(ecosystem,
                "Music Management",
                "AVESON MUSIC CONTROL");

        addInfo(ecosystem,
                "Distribution Management",
                "AVESON DISTRIBUTION CONTROL");

        addInfo(ecosystem,
                "Studio Management",
                "AVESON STUDIO CONTROL");

        addInfo(ecosystem,
                "Magazine Management",
                "AVESON MAGAZINE CONTROL");

        addInfo(ecosystem,
                "Film Management",
                "AVESON FILMS");

        layout.addView(ecosystem);

        LinearLayout architecture =
                createCard("⚙️ SYSTEM ARCHITECTURE");

        addInfo(architecture,
                "Central Management",
                "Unified AVESON control layer");

        addInfo(architecture,
                "Room Management",
                "Six Central management rooms");

        addInfo(architecture,
                "Global Menu",
                "Central-wide management functions");

        addInfo(architecture,
                "Security Layer",
                "Access and security management");

        addInfo(architecture,
                "Parameters System",
                "Global platform configuration");

        addInfo(architecture,
                "System Status",
                "System health and service monitoring");

        layout.addView(architecture);

        LinearLayout scope =
                createCard("🌍 PLATFORM SCOPE");

        addInfo(scope,
                "Music",
                "Global music management");

        addInfo(scope,
                "Distribution",
                "Global music distribution");

        addInfo(scope,
                "Artists",
                "Artist management and submissions");

        addInfo(scope,
                "Studio",
                "Audio production and studio management");

        addInfo(scope,
                "Magazine",
                "Editorial and media management");

        addInfo(scope,
                "Films",
                "Film and video management");

        layout.addView(scope);

        LinearLayout systemInfo =
                createCard("📋 SYSTEM INFORMATION");

        addInfo(systemInfo,
                "Application",
                "AVESON CENTRAL");

        addInfo(systemInfo,
                "Package",
                "com.aveson.central");

        addInfo(systemInfo,
                "Build Version",
                "1.0");

        addInfo(systemInfo,
                "Development Status",
                "ACTIVE DEVELOPMENT");

        addInfo(systemInfo,
                "Backend",
                "NOT CONNECTED");

        addInfo(systemInfo,
                "Database",
                "NOT CONNECTED");

        addInfo(systemInfo,
                "API",
                "NOT CONNECTED");

        layout.addView(systemInfo);

        LinearLayout security =
                createCard("🛡️ SECURITY & CONTROL");

        addInfo(security,
                "Central Access",
                "Protected");

        addInfo(security,
                "Role Management",
                "Available");

        addInfo(security,
                "Permission Management",
                "Available");

        addInfo(security,
                "Security Monitoring",
                "Available");

        addInfo(security,
                "System Logs",
                "Available");

        layout.addView(security);

        LinearLayout aveson =
                createCard("©️ AVESON");

        addInfo(aveson,
                "Platform",
                "AVESON");

        addInfo(aveson,
                "Product",
                "AVESON CENTRAL");

        addInfo(aveson,
                "Purpose",
                "Unified global management platform");

        addInfo(aveson,
                "Terms & Policies",
                "Available");

        addInfo(aveson,
                "Privacy",
                "Available");

        addInfo(aveson,
                "Copyright",
                "AVESON");

        addInfo(aveson,
                "Contact",
                "AVESON Platform Administration");

        layout.addView(aveson);

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // =========================================================
    // CENTRAL ROOMS
    // =========================================================

    private void openRoom(String room) {

        LinearLayout layout = createRoot();

        if (room.equals("ARTIST")) {

            layout.addView(createTitle(
                    "AVESON ARTIST CONTROL"
            ));

            layout.addView(createSubtitle(
                    "Artist Management"
            ));

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
        }

        else if (room.equals("MUSIC")) {

            layout.addView(createTitle(
                    "AVESON MUSIC CONTROL"
            ));

            layout.addView(createSubtitle(
                    "Music Management"
            ));

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
        }

        else if (room.equals("DISTRIBUTION")) {

            layout.addView(createTitle(
                    "AVESON DISTRIBUTION CONTROL"
            ));

            layout.addView(createSubtitle(
                    "Distribution Management"
            ));

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
        }

        else if (room.equals("STUDIO")) {

            layout.addView(createTitle(
                    "AVESON STUDIO CONTROL"
            ));

            layout.addView(createSubtitle(
                    "Studio Management"
            ));

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
        }

        else if (room.equals("MAGAZINE")) {

            layout.addView(createTitle(
                    "AVESON MAGAZINE CONTROL"
            ));

            layout.addView(createSubtitle(
                    "Magazine Management"
            ));

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
        }

        else if (room.equals("FILMS")) {

            layout.addView(createTitle(
                    "AVESON FILMS"
            ));

            layout.addView(createSubtitle(
                    "Film Management"
            ));

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

        addButton(
                layout,
                "← BACK",
                v -> showCentralHome()
        );

        setScreen(layout);
    }

    // =========================================================
    // MESSAGE
    // =========================================================

    private void showMessage(String name) {

        LinearLayout layout = createRoot();

        layout.addView(createTitle(name));

        LinearLayout card =
                createCard("AVESON CENTRAL");

        addInfo(card, "Section", name);
        addInfo(card, "Status", "AVAILABLE");
        addInfo(card, "Data", "Not connected");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }
            }
