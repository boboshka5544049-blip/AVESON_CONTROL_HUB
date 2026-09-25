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

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private LinearLayout createRoot() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(dp(18), dp(24), dp(18), dp(56));
        layout.setBackgroundColor(DARK);
        return layout;
    }

    private ScrollView createScroll(LinearLayout layout) {
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setClipToPadding(false);
        scroll.setBackgroundColor(DARK);
        scroll.addView(layout);
        return scroll;
    }

    private void setScreen(ScrollView scroll) {
        setContentView(scroll);
    }

    private TextView createTitle(String text) {
        TextView title = new TextView(this);
        title.setText(text);
        title.setTextColor(TEXT);
        title.setTextSize(25);
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
        button.setMinHeight(0);
        button.setMinimumHeight(0);
        button.setPadding(dp(8), 0, dp(8), 0);

        GradientDrawable background = new GradientDrawable();
        background.setColor(CARD);
        background.setCornerRadius(dp(18));
        background.setStroke(dp(1), PURPLE);
        button.setBackground(background);

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

        params.setMargins(0, dp(6), 0, dp(6));
        layout.addView(button, params);
    }

    private LinearLayout createCard() {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(16), dp(16), dp(16));

        GradientDrawable background = new GradientDrawable();
        background.setColor(CARD);
        background.setCornerRadius(dp(18));
        background.setStroke(dp(1), Color.rgb(70, 55, 120));
        card.setBackground(background);

        return card;
    }

    private void addInfo(
            LinearLayout card,
            String label,
            String value
    ) {
        TextView info = new TextView(this);
        info.setText(label + "\n" + value);
        info.setTextColor(TEXT);
        info.setTextSize(14);
        info.setPadding(
                dp(4),
                dp(8),
                dp(4),
                dp(8)
        );
        card.addView(info);
    }

    private void addSectionButton(
            LinearLayout layout,
            String title,
            String description,
            View.OnClickListener listener
    ) {
        Button button =
                createButton(title + "\n" + description);

        button.setGravity(
                Gravity.CENTER_VERTICAL | Gravity.LEFT
        );

        button.setTextSize(14);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(62)
                );

        params.setMargins(
                0,
                dp(5),
                0,
                dp(5)
        );

        layout.addView(button, params);
    }

    private void showCentralHome() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("AVESON CENTRAL")
        );

        TextView homeSubtitle =
                createSubtitle(
                        "Global Management & Control Platform"
                );

        homeSubtitle.setPadding(
                dp(4),
                0,
                dp(4),
                dp(6)
        );

        layout.addView(homeSubtitle);

        addButton(
                layout,
                "☰ MENU",
                v -> showGlobalMenu()
        );

        addSectionButton(
                layout,
                "🎵 AVESON ARTIST CONTROL",
                "Artist Management & Release Control",
                v -> openRoom("ARTIST")
        );

        addSectionButton(
                layout,
                "🎼 AVESON MUSIC CONTROL",
                "Music Catalog & Content Control",
                v -> openRoom("MUSIC")
        );

        addSectionButton(
                layout,
                "🌍 AVESON DISTRIBUTION CONTROL",
                "Global Distribution & Platform Management",
                v -> openRoom("DISTRIBUTION")
        );

        addSectionButton(
                layout,
                "🎙️ AVESON STUDIO CONTROL",
                "Studio Projects & Production",
                v -> openRoom("STUDIO")
        );

        addSectionButton(
                layout,
                "📰 AVESON MAGAZINE CONTROL",
                "Articles, Editorial & Media",
                v -> openRoom("MAGAZINE")
        );

        addSectionButton(
                layout,
                "🎬 AVESON FILMS",
                "Films, Videos & Original Content",
                v -> openRoom("FILMS")
        );

        setScreen(createScroll(layout));
    }

    private void showGlobalMenu() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("☰ AVESON CENTRAL MENU")
        );

        layout.addView(
                createSubtitle("Global Central Management")
        );

        addSectionButton(
                layout,
                "📊 Analytics",
                "Global statistics and insights",
                v -> showAnalytics()
        );

        addSectionButton(
                layout,
                "💰 Royalty Control",
                "Revenue, royalties and reports",
                v -> showRoyaltyControl()
        );

        addSectionButton(
                layout,
                "🔐 Security",
                "Access, protection and security",
                v -> showSecurity()
        );

        addSectionButton(
                layout,
                "⚙️ Parameters",
                "Global system parameters",
                v -> showParameters()
        );

        addSectionButton(
                layout,
                "🛡️ System Status",
                "AVESON Central system status",
                v -> showSystemStatus()
        );

        addSectionButton(
                layout,
                "ℹ️ AVESON Central Info",
                "Information about AVESON Central",
                v -> showAvesonCentralInfo()
        );

        addButton(
                layout,
                "← BACK TO AVESON CENTRAL",
                v -> showCentralHome()
        );

        setScreen(createScroll(layout));
    }

    private void showAnalytics() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📊 ANALYTICS")
        );

        layout.addView(
                createSubtitle(
                        "Global AVESON statistics and insights"
                )
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Active Artists",
                "1,248"
        );

        addInfo(
                card,
                "Music Releases",
                "3,842"
        );

        addInfo(
                card,
                "Distribution Platforms",
                "18"
        );

        addInfo(
                card,
                "Studio Projects",
                "486"
        );

        addInfo(
                card,
                "Magazine Articles",
                "274"
        );

        addInfo(
                card,
                "Film Projects",
                "52"
        );

        layout.addView(card);

        layout.addView(
                createSubtitle("ROOM ANALYTICS")
        );

        addSectionButton(
                layout,
                "🎵 Artist Analytics",
                "Artists, submissions and releases",
                v -> showMessage("Artist Analytics")
        );

        addSectionButton(
                layout,
                "🎼 Music Analytics",
                "Catalog, users and playlists",
                v -> showMessage("Music Analytics")
        );

        addSectionButton(
                layout,
                "🌍 Distribution Analytics",
                "Platforms and delivery",
                v -> showMessage("Distribution Analytics")
        );

        addSectionButton(
                layout,
                "🎙️ Studio Analytics",
                "Projects and production",
                v -> showMessage("Studio Analytics")
        );

        addSectionButton(
                layout,
                "📰 Magazine Analytics",
                "Editorial and audience",
                v -> showMessage("Magazine Analytics")
        );

        addSectionButton(
                layout,
                "🎬 Film Analytics",
                "Film and video performance",
                v -> showMessage("Film Analytics")
        );

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(createScroll(layout));
    }

    private void showRoyaltyControl() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("💰 ROYALTY CONTROL")
        );

        layout.addView(
                createSubtitle(
                        "Revenue, royalty and payment management"
                )
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Total Revenue",
                "$48,230"
        );

        addInfo(
                card,
                "Available",
                "$31,840"
        );

        addInfo(
                card,
                "Pending",
                "$16,390"
        );

        addInfo(
                card,
                "Artists With Earnings",
                "1,024"
        );

        layout.addView(card);

        addSectionButton(
                layout,
                "📄 Royalty Reports",
                "Statements and financial reports",
                v -> showMessage("Royalty Reports")
        );

        addSectionButton(
                layout,
                "💵 Artist Earnings",
                "Artist-level earnings",
                v -> showMessage("Artist Earnings")
        );

        addSectionButton(
                layout,
                "🌍 Platform Earnings",
                "Revenue by platform",
                v -> showMessage("Platform Earnings")
        );

        addSectionButton(
                layout,
                "📅 Payment History",
                "Previous royalty payments",
                v -> showMessage("Payment History")
        );

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(createScroll(layout));
    }

    private void showSecurity() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🔐 SECURITY")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central security management"
                )
        );

        addSectionButton(
                layout,
                "👥 Access Control",
                "Users and access levels",
                v -> showAccessControl()
        );

        addSectionButton(
                layout,
                "🛡️ Security Protection",
                "System protection controls",
                v -> showSecurityProtection()
        );

        addSectionButton(
                layout,
                "📱 Authorized Devices",
                "Connected authorized devices",
                v -> showAuthorizedDevices()
        );

        addSectionButton(
                layout,
                "📋 Login Activity",
                "Recent access activity",
                v -> showLoginActivity()
        );

        addSectionButton(
                layout,
                "⚠️ Security Events",
                "Security event monitoring",
                v -> showSecurityEvents()
        );

        addSectionButton(
                layout,
                "🔑 Password & Authentication",
                "Authentication settings",
                v -> showPasswordAuthentication()
        );

        addSectionButton(
                layout,
                "🌐 Network & API Security",
                "Network and API protection",
                v -> showNetworkApiSecurity()
        );

        addSectionButton(
                layout,
                "📜 Security Logs",
                "Security audit logs",
                v -> showSecurityLogs()
        );

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(createScroll(layout));
    }

    private void showAccessControl() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("👥 ACCESS CONTROL")
        );

        addSectionButton(
                layout,
                "🔑 Role Details",
                "Central access roles",
                v -> showRoleDetails()
        );

        addSectionButton(
                layout,
                "🛡️ Permission Management",
                "Permissions by role",
                v -> showPermissionManagement()
        );

        addInfoToLayout(
                layout,
                "Access Status",
                "Private Central Management"
        );

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    private void showRoleDetails() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🔑 ROLE DETAILS")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Central Administrator",
                "Full Central control"
        );

        addInfo(
                card,
                "Artist Control",
                "Artist and release management"
        );

        addInfo(
                card,
                "Music Control",
                "Music system management"
        );

        addInfo(
                card,
                "Distribution Control",
                "Distribution management"
        );

        addInfo(
                card,
                "Studio Control",
                "Studio management"
        );

        addInfo(
                card,
                "Magazine Control",
                "Editorial management"
        );

        addInfo(
                card,
                "Films",
                "Film and video management"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showAccessControl()
        );

        setScreen(createScroll(layout));
    }

    private void showPermissionManagement() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🛡️ PERMISSION MANAGEMENT")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Artist Control",
                "Management permissions"
        );

        addInfo(
                card,
                "Music Control",
                "Catalog permissions"
        );

        addInfo(
                card,
                "Distribution Control",
                "Delivery permissions"
        );

        addInfo(
                card,
                "Studio Control",
                "Production permissions"
        );

        addInfo(
                card,
                "Magazine Control",
                "Editorial permissions"
        );

        addInfo(
                card,
                "Films",
                "Content permissions"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showAccessControl()
        );

        setScreen(createScroll(layout));
    }

    private void showAuthorizedDevices() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📱 AUTHORIZED DEVICES")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Device Management",
                "Enabled"
        );

        addInfo(
                card,
                "Current Device",
                "Authorized"
        );

        addInfo(
                card,
                "Device Verification",
                "Enabled"
        );

        addInfo(
                card,
                "Unknown Devices",
                "Blocked"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    private void showLoginActivity() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📋 LOGIN ACTIVITY")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Last Login",
                "Central administrator"
        );

        addInfo(
                card,
                "Activity Status",
                "MONITORED"
        );

        addInfo(
                card,
                "Failed Attempts",
                "0"
        );

        addInfo(
                card,
                "Audit",
                "Enabled"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    private void showSecurityProtection() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🛡️ SECURITY PROTECTION")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Access Protection",
                "ACTIVE"
        );

        addInfo(
                card,
                "Session Protection",
                "ACTIVE"
        );

        addInfo(
                card,
                "Device Protection",
                "ACTIVE"
        );

        addInfo(
                card,
                "API Protection",
                "ACTIVE"
        );

        addInfo(
                card,
                "Audit Monitoring",
                "ACTIVE"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    private void showSecurityEvents() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("⚠️ SECURITY EVENTS")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "System Events",
                "MONITORED"
        );

        addInfo(
                card,
                "Access Events",
                "MONITORED"
        );

        addInfo(
                card,
                "Permission Changes",
                "MONITORED"
        );

        addInfo(
                card,
                "Suspicious Activity",
                "0"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    private void showPasswordAuthentication() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🔑 PASSWORD & AUTHENTICATION")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Authentication",
                "ACTIVE"
        );

        addInfo(
                card,
                "Password Protection",
                "ACTIVE"
        );

        addInfo(
                card,
                "Session Verification",
                "ACTIVE"
        );

        addInfo(
                card,
                "Multi-Factor Authentication",
                "READY"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    private void showNetworkApiSecurity() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🌐 NETWORK & API SECURITY")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "HTTPS",
                "Required"
        );

        addInfo(
                card,
                "API Authentication",
                "Protected"
        );

        addInfo(
                card,
                "API Access",
                "Controlled"
        );

        addInfo(
                card,
                "Network Monitoring",
                "ACTIVE"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    private void showSecurityLogs() {
        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📜 SECURITY LOGS")
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Audit Logging",
                "ACTIVE"
        );

        addInfo(
                card,
                "Access Logs",
                "ACTIVE"
        );

        addInfo(
                card,
                "Security Logs",
                "ACTIVE"
        );

        addInfo(
                card,
                "System Logs",
                "ACTIVE"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
            }
                    "Previous royalty payments",
                v -> showMessage("Payment History"));

        addButton(layout, "← BACK", v -> showGlobalMenu());
        setScreen(createScroll(layout));
    }

    private void showSecurity() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🔐 SECURITY"));
        layout.addView(createSubtitle("AVESON Central security management"));

        addSectionButton(layout, "👥 Access Control",
                "Users and access levels",
                v -> showAccessControl());

        addSectionButton(layout, "🛡️ Security Protection",
                "System protection controls",
                v -> showSecurityProtection());

        addSectionButton(layout, "📱 Authorized Devices",
                "Connected authorized devices",
                v -> showAuthorizedDevices());

        addSectionButton(layout, "📋 Login Activity",
                "Recent access activity",
                v -> showLoginActivity());

        addSectionButton(layout, "⚠️ Security Events",
                "Security event monitoring",
                v -> showSecurityEvents());

        addSectionButton(layout, "🔑 Password & Authentication",
                "Authentication settings",
                v -> showPasswordAuthentication());

        addSectionButton(layout, "🌐 Network & API Security",
                "Network and API protection",
                v -> showNetworkApiSecurity());

        addSectionButton(layout, "📜 Security Logs",
                "Security audit logs",
                v -> showSecurityLogs());

        addButton(layout, "← BACK", v -> showGlobalMenu());
        setScreen(createScroll(layout));
    }

    private void showAccessControl() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("👥 ACCESS CONTROL"));

        addSectionButton(layout, "🔑 Role Details",
                "Central access roles",
                v -> showRoleDetails());

        addSectionButton(layout, "🛡️ Permission Management",
                "Permissions by role",
                v -> showPermissionManagement());

        addInfoToLayout(layout, "Access Status", "Private Central Management");

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showRoleDetails() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🔑 ROLE DETAILS"));

        LinearLayout card = createCard();
        addInfo(card, "Central Administrator", "Full Central control");
        addInfo(card, "Artist Control", "Artist and release management");
        addInfo(card, "Music Control", "Music system management");
        addInfo(card, "Distribution Control", "Distribution management");
        addInfo(card, "Studio Control", "Studio management");
        addInfo(card, "Magazine Control", "Editorial management");
        addInfo(card, "Films", "Film and video management");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showAccessControl());
        setScreen(createScroll(layout));
    }

    private void showPermissionManagement() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🛡️ PERMISSION MANAGEMENT"));

        LinearLayout card = createCard();
        addInfo(card, "Artist Control", "Management permissions");
        addInfo(card, "Music Control", "Catalog permissions");
        addInfo(card, "Distribution Control", "Delivery permissions");
        addInfo(card, "Studio Control", "Production permissions");
        addInfo(card, "Magazine Control", "Editorial permissions");
        addInfo(card, "Films", "Content permissions");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showAccessControl());
        setScreen(createScroll(layout));
    }

    private void showAuthorizedDevices() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("📱 AUTHORIZED DEVICES"));

        LinearLayout card = createCard();
        addInfo(card, "Device Management", "Enabled");
        addInfo(card, "Current Device", "Authorized");
        addInfo(card, "Device Verification", "Enabled");
        addInfo(card, "Unknown Devices", "Blocked");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showLoginActivity() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("📋 LOGIN ACTIVITY"));

        LinearLayout card = createCard();
        addInfo(card, "Last Login", "Central administrator");
        addInfo(card, "Activity Status", "MONITORED");
        addInfo(card, "Failed Attempts", "0");
        addInfo(card, "Audit", "Enabled");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showSecurityProtection() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🛡️ SECURITY PROTECTION"));

        LinearLayout card = createCard();
        addInfo(card, "Access Protection", "ACTIVE");
        addInfo(card, "Session Protection", "ACTIVE");
        addInfo(card, "Device Protection", "ACTIVE");
        addInfo(card, "API Protection", "ACTIVE");
        addInfo(card, "Audit Monitoring", "ACTIVE");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showSecurityEvents() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("⚠️ SECURITY EVENTS"));

        LinearLayout card = createCard();
        addInfo(card, "System Events", "MONITORED");
        addInfo(card, "Access Events", "MONITORED");
        addInfo(card, "Permission Changes", "MONITORED");
        addInfo(card, "Suspicious Activity", "0");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showPasswordAuthentication() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🔑 PASSWORD & AUTHENTICATION"));

        LinearLayout card = createCard();
        addInfo(card, "Authentication", "ACTIVE");
        addInfo(card, "Password Protection", "ACTIVE");
        addInfo(card, "Session Verification", "ACTIVE");
        addInfo(card, "Multi-Factor Authentication", "READY");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showNetworkApiSecurity() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🌐 NETWORK & API SECURITY"));

        LinearLayout card = createCard();
        addInfo(card, "HTTPS", "Required");
        addInfo(card, "API Authentication", "Protected");
        addInfo(card, "API Access", "Controlled");
        addInfo(card, "Network Monitoring", "ACTIVE");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showSecurityLogs() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("📜 SECURITY LOGS"));

        LinearLayout card = createCard();
        addInfo(card, "Audit Logging", "ACTIVE");
        addInfo(card, "Access Logs", "ACTIVE");
        addInfo(card, "Security Logs", "ACTIVE");
        addInfo(card, "Retention", "Configured");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showSecurity());
        setScreen(createScroll(layout));
    }

    private void showParameters() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("⚙️ PARAMETERS"));
        layout.addView(createSubtitle("AVESON Central configuration"));

        addSectionButton(layout, "🌐 Languages",
                "System language settings",
                v -> showLanguages());

        addSectionButton(layout, "🎨 Appearance",
                "Interface appearance",
                v -> showAppearance());

        addSectionButton(layout, "🔔 Notifications",
                "System notifications",
                v -> showNotifications());

        addSectionButton(layout, "🎵 Music Parameters",
                "Music standards and settings",
                v -> showMusicParameters());

        addSectionButton(layout, "🌍 Distribution Parameters",
                "Distribution standards and settings",
                v -> showDistributionParameters());

        addButton(layout, "← BACK", v -> showGlobalMenu());
        setScreen(createScroll(layout));
    }

    private void showLanguages() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🌐 LANGUAGES"));

        LinearLayout card = createCard();
        addInfo(card, "Primary Language", "English");
        addInfo(card, "Available", "English / Uzbek / Russian");
        addInfo(card, "Language System", "READY");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showParameters());
        setScreen(createScroll(layout));
    }

    private void showAppearance() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🎨 APPEARANCE"));

        LinearLayout card = createCard();
        addInfo(card, "Theme", "Dark");
        addInfo(card, "Style", "Futuristic Neon");
        addInfo(card, "Primary Accent", "Purple / Blue");
        addInfo(card, "Interface", "AVESON Central");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showParameters());
        setScreen(createScroll(layout));
    }

    private void showNotifications() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🔔 NOTIFICATIONS"));

        LinearLayout card = createCard();
        addInfo(card, "System Notifications", "Enabled");
        addInfo(card, "Security Alerts", "Enabled");
        addInfo(card, "Release Alerts", "Enabled");
        addInfo(card, "Distribution Alerts", "Enabled");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showParameters());
        setScreen(createScroll(layout));
    }

    private void showMusicParameters() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🎵 MUSIC PARAMETERS"));

        addSectionButton(layout, "🎧 Audio Standards",
                "Audio file requirements",
                v -> showAudioStandards());

        addSectionButton(layout, "🖼️ Cover Standards",
                "Artwork requirements",
                v -> showCoverStandards());

        addSectionButton(layout, "📅 Release Standards",
                "Release requirements",
                v -> showReleaseStandards());

        addSectionButton(layout, "📝 Metadata Standards",
                "Metadata requirements",
                v -> showMetadataStandards());

        addSectionButton(layout, "💾 Music File Formats",
                "Supported music formats",
                v -> showMusicFileFormats());

        addSectionButton(layout, "🎚️ Music Quality",
                "Audio quality standards",
                v -> showMusicQuality());

        addButton(layout, "← BACK", v -> showParameters());
        setScreen(createScroll(layout));
    }

    private void showAudioStandards() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🎧 AUDIO STANDARDS"));

        LinearLayout card = createCard();
        addInfo(card, "Preferred Format", "WAV / FLAC");
        addInfo(card, "Bit Depth", "24-bit preferred");
        addInfo(card, "Sample Rate", "44.1 / 48 kHz");
        addInfo(card, "Channels", "Stereo");
        addInfo(card, "Quality", "No clipping / distortion");
        addInfo(card, "Master", "High-quality master required");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showMusicParameters());
        setScreen(createScroll(layout));
    }

    private void showCoverStandards() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🖼️ COVER STANDARDS"));

        LinearLayout card = createCard();
        addInfo(card, "Shape", "Square 1:1");
        addInfo(card, "Preferred Size", "3000 × 3000 or larger");
        addInfo(card, "Formats", "JPG / PNG");
        addInfo(card, "Color", "RGB");
        addInfo(card, "Quality", "High resolution");
        addInfo(card, "Restrictions", "No logos / QR / prices / ads");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showMusicParameters());
        setScreen(createScroll(layout));
    }

    private void showReleaseStandards() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("📅 RELEASE STANDARDS"));

        LinearLayout card = createCard();
        addInfo(card, "Release Date", "Calendar + manual entry");
        addInfo(card, "Title", "Required");
        addInfo(card, "Artist", "Required");
        addInfo(card, "Genre", "Required");
        addInfo(card, "Language", "Required");
        addInfo(card, "Explicit Content", "Required");
        addInfo(card, "Rights", "Required");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showMusicParameters());
        setScreen(createScroll(layout));
    }

    private void showMetadataStandards() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("📝 METADATA STANDARDS"));

        LinearLayout card = createCard();
        addInfo(card, "Track Title", "Required");
        addInfo(card, "Version", "Required when applicable");
        addInfo(card, "Primary Artist", "Required");
        addInfo(card, "Featured Artist", "When applicable");
        addInfo(card, "Genre", "Required");
        addInfo(card, "Language", "Required");
        addInfo(card, "ISRC", "When available");
        addInfo(card, "UPC", "Release identifier");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showMusicParameters());
        setScreen(createScroll(layout));
    }

    private void showMusicFileFormats() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("💾 MUSIC FILE FORMATS"));

        LinearLayout card = createCard();
        addInfo(card, "WAV", "Preferred");
        addInfo(card, "FLAC", "Supported");
        addInfo(card, "MP3", "Supported");
        addInfo(card, "AAC", "Supported");
        addInfo(card, "Master Upload", "Lossless preferred");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showMusicParameters());
        setScreen(createScroll(layout));
    }

    private void showMusicQuality() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🎚️ MUSIC QUALITY"));

        LinearLayout card = createCard();
        addInfo(card, "Master Quality", "High quality");
        addInfo(card, "Clipping", "Not accepted");
        addInfo(card, "Distortion", "Not accepted");
        addInfo(card, "Corrupt Files", "Not accepted");
        addInfo(card, "Stereo", "Preferred");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showMusicParameters());
        setScreen(createScroll(layout));
    }

    private void showDistributionParameters() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🌍 DISTRIBUTION PARAMETERS"));

        addSectionButton(layout, "📋 Distribution Standards",
                "Distribution requirements",
                v -> showDistributionStandards());

        addSectionButton(layout, "🌐 Platform Settings",
                "Distribution platform configuration",
                v -> showPlatformSettings());

        addSectionButton(layout, "🚚 Release Delivery",
                "Delivery configuration",
                v -> showReleaseDeliverySettings());

        addSectionButton(layout, "🗺️ Territory Settings",
                "Territory configuration",
                v -> showTerritorySettings());

        addSectionButton(layout, "💾 Distribution Formats",
                "Delivery file formats",
                v -> showDistributionFormats());

        addSectionButton(layout, "📦 Delivery Rules",
                "Distribution delivery rules",
                v -> showDeliveryRules());

        addButton(layout, "← BACK", v -> showParameters());
        setScreen(createScroll(layout));
    }

    private void showDistributionStandards() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("📋 DISTRIBUTION STANDARDS"));

        LinearLayout card = createCard();
        addInfo(card, "Metadata", "Required");
        addInfo(card, "Audio Quality", "Verified");
        addInfo(card, "Cover", "Verified");
        addInfo(card, "Rights", "Required");
        addInfo(card, "Release Data", "Verified");
        layout.addView(card);

        addButton(layout, "← BACK", v -> showDistributionParameters());
        setScreen(createScroll(layout));
    }

    private void showPlatformSettings() {
        LinearLayout layout = createRoot();
        layout.addView(createTitle("🌐 PLATFORM SETTINGS"));

        LinearLayout card = createCard();
        addInfo(card, "Platform Management", "Enabled");
        addInfo(card, "Platform Delivery", "Enabled");
        addInfo(card, "Platform
                        addSectionButton(layout, "📄 Artist Documents",
                "Artist legal documents",
                v -> showArtistDocuments());

        addSectionButton(layout, "📣 Marketing",
                "Artist marketing management",
                v -> showArtistMarketing());

        addSectionButton(layout, "👥 Audience",
                "Artist audience management",
                v -> showArtistAudience());

        addSectionButton(layout, "🔑 Access & Permissions",
                "Artist access control",
                v -> showArtistAccess());

        addSectionButton(layout, "⚙️ Artist Settings",
                "Artist system settings",
                v -> showArtistSettings());

        addButton(layout, "← BACK", v -> showCentralHome());
        setScreen(createScroll(layout));
        }

        else if (room.equals("MUSIC")) {
            layout.addView(createTitle("🎼 AVESON MUSIC CONTROL"));
            layout.addView(createSubtitle("Independent Music Management System"));

            addSectionButton(layout, "🎵 Music Catalog",
                    "Global music catalog",
                    v -> showMusicCatalog());

            addSectionButton(layout, "💿 Albums & Releases",
                    "Albums, EPs and singles",
                    v -> showMusicReleases());

            addSectionButton(layout, "📋 Playlists",
                    "Music playlists management",
                    v -> showMusicPlaylists());

            addSectionButton(layout, "👥 Music Users",
                    "Music platform users",
                    v -> showMusicUsers());

            addSectionButton(layout, "📊 Music Analytics",
                    "Music performance analytics",
                    v -> showMusicAnalytics());

            addSectionButton(layout, "⚙️ Music Settings",
                    "Music system settings",
                    v -> showMusicSettings());

            addButton(layout, "← BACK", v -> showCentralHome());
            setScreen(createScroll(layout));
        }

        else if (room.equals("DISTRIBUTION")) {
            layout.addView(createTitle("🌍 AVESON DISTRIBUTION CONTROL"));
            layout.addView(createSubtitle("Independent Distribution Management System"));

            addSectionButton(layout, "🌐 Distribution Platforms",
                    "Connected distribution platforms",
                    v -> showDistributionPlatforms());

            addSectionButton(layout, "📦 Distribution Releases",
                    "Distributed releases",
                    v -> showDistributionReleases());

            addSectionButton(layout, "🚚 Release Delivery",
                    "Release delivery management",
                    v -> showDistributionDelivery());

            addSectionButton(layout, "📊 Distribution Analytics",
                    "Distribution performance",
                    v -> showDistributionAnalytics());

            addSectionButton(layout, "⚙️ Distribution Settings",
                    "Distribution system settings",
                    v -> showDistributionSettings());

            addButton(layout, "← BACK", v -> showCentralHome());
            setScreen(createScroll(layout));
        }

        else if (room.equals("STUDIO")) {
            layout.addView(createTitle("🎙️ AVESON STUDIO CONTROL"));
            layout.addView(createSubtitle("Independent Studio Management System"));

            addSectionButton(layout, "🎚️ Studio Projects",
                    "Studio projects",
                    v -> showStudioProjects());

            addSectionButton(layout, "🎧 Audio Production",
                    "Audio production management",
                    v -> showAudioProduction());

            addSectionButton(layout, "🎙️ Sessions",
                    "Recording sessions",
                    v -> showStudioSessions());

            addSectionButton(layout, "📁 Studio Files",
                    "Studio files and assets",
                    v -> showStudioFiles());

            addSectionButton(layout, "📊 Studio Analytics",
                    "Studio performance analytics",
                    v -> showStudioAnalytics());

            addSectionButton(layout, "⚙️ Studio Settings",
                    "Studio system settings",
                    v -> showStudioSettings());

            addButton(layout, "← BACK", v -> showCentralHome());
            setScreen(createScroll(layout));
        }

        else if (room.equals("MAGAZINE")) {
            layout.addView(createTitle("📰 AVESON MAGAZINE CONTROL"));
            layout.addView(createSubtitle("Independent Magazine Management System"));

            addSectionButton(layout, "📝 Articles",
                    "Magazine articles",
                    v -> showMagazineArticles());

            addSectionButton(layout, "✍️ Editorial",
                    "Editorial management",
                    v -> showMagazineEditorial());

            addSectionButton(layout, "🖼️ Media",
                    "Magazine media",
                    v -> showMagazineMedia());

            addSectionButton(layout, "👤 Writers",
                    "Writer management",
                    v -> showMagazineWriters());

            addSectionButton(layout, "📊 Magazine Analytics",
                    "Magazine performance analytics",
                    v -> showMagazineAnalytics());

            addSectionButton(layout, "⚙️ Magazine Settings",
                    "Magazine system settings",
                    v -> showMagazineSettings());

            addButton(layout, "← BACK", v -> showCentralHome());
            setScreen(createScroll(layout));
        }

        else if (room.equals("FILMS")) {
            layout.addView(createTitle("🎬 AVESON FILMS"));
            layout.addView(createSubtitle("Independent Film Management System"));

            addSectionButton(layout, "🎬 Projects",
                    "Film projects",
                    v -> showFilmProjects());

            addSectionButton(layout, "🎥 Videos",
                    "Film and video content",
                    v -> showFilmVideos());

            addSectionButton(layout, "🎞️ Productions",
                    "Production management",
                    v -> showFilmProductions());

            addSectionButton(layout, "📁 Film Library",
                    "Film content library",
                    v -> showFilmLibrary());

            addSectionButton(layout, "📊 Film Analytics",
                    "Film performance analytics",
                    v -> showFilmAnalytics());

            addSectionButton(layout, "⚙️ Film Settings",
                    "Film system settings",
                    v -> showFilmSettings());

            addButton(layout, "← BACK", v -> showCentralHome());
            setScreen(createScroll(layout));
        }
    }

    // =========================================================
    // AVESON ARTIST CONTROL
    // =========================================================

    private void showArtistArtists() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("👤 ARTISTS"));
        layout.addView(createSubtitle("AVESON Artist Control"));

        LinearLayout card = createCard();

        addInfo(card, "Artist Profiles", "Managed");
        addInfo(card, "Artist Registration", "Available");
        addInfo(card, "Artist Verification", "Controlled");
        addInfo(card, "Artist Status", "Managed");
        addInfo(card, "Artist Documents", "Available");

        layout.addView(card);

        addButton(layout, "➕ ADD ARTIST",
                v -> showMessage("Add Artist"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistSubmissions() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("📥 ARTIST SUBMISSIONS"));
        layout.addView(createSubtitle("Incoming submissions"));

        LinearLayout card = createCard();

        addInfo(card, "Music Submissions", "Managed");
        addInfo(card, "Video Submissions", "Managed");
        addInfo(card, "Pending Review", "Available");
        addInfo(card, "Accepted", "Tracked");
        addInfo(card, "Rejected", "Tracked");

        layout.addView(card);

        addButton(layout, "🔍 REVIEW SUBMISSIONS",
                v -> showArtistReleaseReview());

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistReleaseReview() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🔍 RELEASE REVIEW"));
        layout.addView(createSubtitle("Review and release approval"));

        LinearLayout card = createCard();

        addInfo(card, "Release Review", "ACTIVE");
        addInfo(card, "Audio Verification", "Required");
        addInfo(card, "Cover Verification", "Required");
        addInfo(card, "Metadata Verification", "Required");
        addInfo(card, "Rights Verification", "Required");
        addInfo(card, "Final Decision", "Administrator");

        layout.addView(card);

        addButton(layout, "✅ ACCEPT RELEASE",
                v -> showMessage("Release Accepted"));

        addButton(layout, "❌ REJECT RELEASE",
                v -> showMessage("Release Rejected"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistReleases() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🎵 ARTIST RELEASES"));
        layout.addView(createSubtitle("Artist albums, EPs and singles"));

        LinearLayout card = createCard();

        addInfo(card, "Singles", "Managed");
        addInfo(card, "EPs", "Managed");
        addInfo(card, "Albums", "Managed");
        addInfo(card, "Release Dates", "Managed");
        addInfo(card, "Release Status", "Tracked");
        addInfo(card, "Distribution Status", "Tracked");

        layout.addView(card);

        addButton(layout, "➕ NEW RELEASE",
                v -> showMessage("Create New Release"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistVideos() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🎬 ARTIST VIDEOS"));
        layout.addView(createSubtitle("Videos and clips management"));

        LinearLayout card = createCard();

        addInfo(card, "Music Videos", "Managed");
        addInfo(card, "Short Clips", "Managed");
        addInfo(card, "Video Uploads", "Available");
        addInfo(card, "Processing", "Tracked");
        addInfo(card, "Distribution", "Managed");
        addInfo(card, "Video Analytics", "Available");

        layout.addView(card);

        addButton(layout, "📤 UPLOAD VIDEO",
                v -> showMessage("Upload Video"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistAnalytics() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("📊 ARTIST ANALYTICS"));
        layout.addView(createSubtitle("Artist performance data"));

        LinearLayout card = createCard();

        addInfo(card, "Streams", "Tracked");
        addInfo(card, "Listeners", "Tracked");
        addInfo(card, "Followers", "Tracked");
        addInfo(card, "Top Platform", "Tracked");
        addInfo(card, "Top Country", "Tracked");
        addInfo(card, "Release Performance", "Tracked");

        layout.addView(card);

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistEarnings() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("💰 ARTIST EARNINGS"));
        layout.addView(createSubtitle("Artist revenue management"));

        LinearLayout card = createCard();

        addInfo(card, "Total Earnings", "Tracked");
        addInfo(card, "Available", "Tracked");
        addInfo(card, "Pending", "Tracked");
        addInfo(card, "Release Earnings", "Tracked");
        addInfo(card, "Platform Earnings", "Tracked");
        addInfo(card, "Statements", "Available");
        addInfo(card, "Payout History", "Available");

        layout.addView(card);

        addButton(layout, "📄 STATEMENTS",
                v -> showMessage("Artist Statements"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistDistribution() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🌍 ARTIST DISTRIBUTION"));
        layout.addView(createSubtitle("Artist distribution management"));

        LinearLayout card = createCard();

        addInfo(card, "Distribution Platforms", "Managed");
        addInfo(card, "Release Delivery", "Managed");
        addInfo(card, "Distribution Status", "Tracked");
        addInfo(card, "Territories", "Managed");
        addInfo(card, "Delivery Reports", "Available");

        layout.addView(card);

        addButton(layout, "🌐 PLATFORMS",
                v -> showMessage("Distribution Platforms"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistAudioStandards() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🎧 ARTIST AUDIO STANDARDS"));
        layout.addView(createSubtitle("Artist submission requirements"));

        LinearLayout card = createCard();

        addInfo(card, "Preferred", "WAV");
        addInfo(card, "Accepted", "WAV / FLAC");
        addInfo(card, "Bit Depth", "24-bit preferred");
        addInfo(card, "Sample Rate", "44.1 / 48 kHz");
        addInfo(card, "Channels", "Stereo");
        addInfo(card, "Quality", "No clipping / distortion");
        addInfo(card, "Master", "High-quality master");

        layout.addView(card);

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistCoverStandards() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🖼️ ARTIST COVER STANDARDS"));
        layout.addView(createSubtitle("Artist artwork requirements"));

        LinearLayout card = createCard();

        addInfo(card, "Shape", "Square 1:1");
        addInfo(card, "Size", "3000 × 3000 px or larger");
        addInfo(card, "Format", "JPG / PNG");
        addInfo(card, "Color", "RGB");
        addInfo(card, "Quality", "High resolution");
        addInfo(card, "Restrictions", "No logos / QR / prices / ads");

        layout.addView(card);

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistRights() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🔐 RIGHTS & COPYRIGHT"));
        layout.addView(createSubtitle("Artist rights management"));

        LinearLayout card = createCard();

        addInfo(card, "Master Rights", "Managed");
        addInfo(card, "Publishing", "Managed");
        addInfo(card, "Copyright Ownership", "Required");
        addInfo(card, "Splits", "Managed");
        addInfo(card, "Songwriters", "Managed");
        addInfo(card, "Contributors", "Managed");
        addInfo(card, "Documents", "Available");

        layout.addView(card);

        addButton(layout, "📄 DOCUMENTS",
                v -> showArtistDocuments());

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistDocuments() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("📄 ARTIST DOCUMENTS"));
        layout.addView(createSubtitle("Artist legal documents"));

        LinearLayout card = createCard();

        addInfo(card, "Contracts", "Managed");
        addInfo(card, "Copyright Documents", "Managed");
        addInfo(card, "Rights Documents", "Managed");
        addInfo(card, "Artist Agreements", "Managed");
        addInfo(card, "Document Status", "Tracked");

        layout.addView(card);

        addButton(layout, "📤 UPLOAD DOCUMENT",
                v -> showMessage("Upload Document"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistMarketing() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("📣 MARKETING"));
        layout.addView(createSubtitle("Artist marketing management"));

        LinearLayout card = createCard();

        addInfo(card, "Campaigns", "Managed");
        addInfo(card, "Release Promotion", "Managed");
        addInfo(card, "Social Media", "Managed");
        addInfo(card, "Promotional Assets", "Managed");
        addInfo(card, "Campaign Analytics", "Available");

        layout.addView(card);

        addButton(layout, "➕ NEW CAMPAIGN",
                v -> showMessage("New Marketing Campaign"));

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistAudience() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("👥 AUDIENCE"));
        layout.addView(createSubtitle("Artist audience management"));

        LinearLayout card = createCard();

        addInfo(card, "Listeners", "Tracked");
        addInfo(card, "Followers", "Tracked");
        addInfo(card, "Countries", "Tracked");
        addInfo(card, "Top Markets", "Tracked");
        addInfo(card, "Audience Growth", "Tracked");

        layout.addView(card);

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistAccess() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("🔑 ACCESS & PERMISSIONS"));
        layout.addView(createSubtitle("Artist access control"));

        LinearLayout card = createCard();

        addInfo(card, "Artist Access", "Controlled");
        addInfo(card, "Profile Permissions", "Managed");
        addInfo(card, "Release Permissions", "Managed");
        addInfo(card, "Distribution Permissions", "Managed");
        addInfo(card, "Document Permissions", "Managed");

        layout.addView(card);

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
    }

    private void showArtistSettings() {
        LinearLayout layout = createRoot();

        layout.addView(createTitle("⚙️ ARTIST SETTINGS"));
        layout.addView(createSubtitle("Artist Control settings"));

        LinearLayout card = createCard();

        addInfo(card, "Artist System", "Active");
        addInfo(card, "Submission Settings", "Configured");
        addInfo(card, "Release Settings", "Configured");
        addInfo(card, "Distribution Settings", "Configured");
        addInfo(card, "Notification Settings", "Configured");

        layout.addView(card);

        addButton(layout, "← BACK",
                v -> openRoom("ARTIST"));

        setScreen(createScroll(layout));
            }
// =============================
// 4-QISM
// =============================

// MUSIC CONTROL
private void openMusicControl() {
    showPanel(
            "AVESON MUSIC CONTROL",
            "Music Management",
            new String[]{
                    "RELEASES",
                    "TRACKS",
                    "ALBUMS",
                    "GENRES",
                    "BACK"
            }
    );
}

// DISTRIBUTION CONTROL
private void openDistributionControl() {
    showPanel(
            "AVESON DISTRIBUTION CONTROL",
            "Distribution Management",
            new String[]{
                    "SUBMISSIONS",
                    "DISTRIBUTION STATUS",
                    "PLATFORMS",
                    "DELIVERIES",
                    "BACK"
            }
    );
}

// ARTIST SUBMISSIONS
private void openArtistSubmissions() {
    showPanel(
            "ARTIST SUBMISSIONS",
            "Incoming Artist Releases",
            new String[]{
                    "PENDING",
                    "APPROVED",
                    "REJECTED",
                    "REVIEW",
                    "BACK"
            }
    );
}

// RELEASE REVIEW
private void openReleaseReview() {
    showPanel(
            "RELEASE REVIEW",
            "Review submitted music",
            new String[]{
                    "OPEN SUBMISSION",
                    "APPROVE",
                    "REJECT",
                    "REQUEST CHANGES",
                    "BACK"
            }
    );
}

// GENERIC PANEL
private void showPanel(
        String title,
        String subtitle,
        String[] buttons
) {

    mainLayout.removeAllViews();

    TextView titleView = new TextView(this);
    titleView.setText(title);
    titleView.setTextColor(Color.WHITE);
    titleView.setTextSize(25);
    titleView.setGravity(Gravity.CENTER);
    titleView.setTypeface(null, Typeface.BOLD);

    LinearLayout.LayoutParams titleParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    titleParams.setMargins(20, 35, 20, 10);
    mainLayout.addView(titleView, titleParams);


    TextView subtitleView = new TextView(this);
    subtitleView.setText(subtitle);
    subtitleView.setTextColor(Color.LTGRAY);
    subtitleView.setTextSize(14);
    subtitleView.setGravity(Gravity.CENTER);

    LinearLayout.LayoutParams subtitleParams =
            new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    subtitleParams.setMargins(20, 0, 20, 30);
    mainLayout.addView(subtitleView, subtitleParams);


    for (String buttonText : buttons) {

        Button button = createControlButton(buttonText);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        58
                );

        params.setMargins(24, 8, 24, 8);

        mainLayout.addView(button, params);


        if (buttonText.equals("BACK")) {
            button.setOnClickListener(v -> showControlCenter());
        }

        if (buttonText.equals("RELEASES")) {
            button.setOnClickListener(v -> openArtistSubmissions());
        }

        if (buttonText.equals("SUBMISSIONS")) {
            button.setOnClickListener(v -> openArtistSubmissions());
        }

        if (buttonText.equals("PENDING")) {
            button.setOnClickListener(v -> openReleaseReview());
        }

        if (buttonText.equals("OPEN SUBMISSION")) {
            button.setOnClickListener(v -> openReleaseReview());
        }
    }
}


// CONTROL BUTTON
private Button createControlButton(String text) {

    Button button = new Button(this);

    button.setText(text);
    button.setTextColor(Color.WHITE);
    button.setTextSize(15);
    button.setAllCaps(false);

    button.setGravity(Gravity.CENTER);

    GradientDrawable background =
            new GradientDrawable();

    background.setColor(
            Color.rgb(20, 20, 40)
    );

    background.setCornerRadius(30);

    background.setStroke(
            2,
            Color.rgb(100, 70, 255)
    );

    button.setBackground(background);

    button.setPadding(10, 0, 10, 0);

    return button;
}


// =============================
// END OF 4-QISM
// =============================
