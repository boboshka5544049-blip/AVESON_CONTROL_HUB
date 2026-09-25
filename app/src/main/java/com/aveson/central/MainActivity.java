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
    // BASIC HELPERS
    // =========================================================

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private LinearLayout createRoot() {

        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setPadding(
                dp(18),
                dp(24),
                dp(18),
                dp(56)
        );

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

        title.setPadding(
                dp(4),
                dp(4),
                dp(4),
                dp(8)
        );

        return title;
    }

    private TextView createSubtitle(String text) {

        TextView subtitle = new TextView(this);

        subtitle.setText(text);
        subtitle.setTextColor(TEXT_GRAY);
        subtitle.setTextSize(14);

        subtitle.setGravity(Gravity.CENTER);

        subtitle.setPadding(
                dp(4),
                0,
                dp(4),
                dp(18)
        );

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

        button.setPadding(
                dp(8),
                0,
                dp(8),
                0
        );

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

        params.setMargins(
                0,
                dp(6),
                0,
                dp(6)
        );

        layout.addView(button, params);
    }

    private LinearLayout createCard() {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);

        card.setPadding(
                dp(16),
                dp(16),
                dp(16),
                dp(16)
        );

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

        info.setText(
                label + "\n" + value
        );

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

        Button button = createButton(
                title + "\n" + description
        );

        button.setGravity(
                Gravity.CENTER_VERTICAL |
                Gravity.LEFT
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

    // =========================================================
    // AVESON CENTRAL HOME
    // =========================================================

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

    // =========================================================
    // GLOBAL MENU
    // =========================================================

    private void showGlobalMenu() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("☰ AVESON CENTRAL MENU")
        );

        layout.addView(
                createSubtitle(
                        "Global Central Management"
                )
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

    // =========================================================
    // GLOBAL ANALYTICS
    // =========================================================

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

        addInfo(card, "Active Artists", "1,248");
        addInfo(card, "Music Releases", "3,842");
        addInfo(card, "Distribution Platforms", "18");
        addInfo(card, "Studio Projects", "486");
        addInfo(card, "Magazine Articles", "274");
        addInfo(card, "Film Projects", "52");

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

    // =========================================================
    // ROYALTY CONTROL
    // =========================================================

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

        addInfo(card, "Total Revenue", "$48,230");
        addInfo(card, "Available", "$31,840");
        addInfo(card, "Pending", "$16,390");
        addInfo(card, "Artists With Earnings", "1,024");

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

    // =========================================================
    // SECURITY
    // =========================================================

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

        addInfo(card, "Central Administrator", "Full Central control");
        addInfo(card, "Artist Control", "Artist and release management");
        addInfo(card, "Music Control", "Music system management");
        addInfo(card, "Distribution Control", "Distribution management");
        addInfo(card, "Studio Control", "Studio management");
        addInfo(card, "Magazine Control", "Editorial management");
        addInfo(card, "Films", "Film and video management");

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

        addInfo(card, "Artist Control", "Management permissions");
        addInfo(card, "Music Control", "Catalog permissions");
        addInfo(card, "Distribution Control", "Delivery permissions");
        addInfo(card, "Studio Control", "Production permissions");
        addInfo(card, "Magazine Control", "Editorial permissions");
        addInfo(card, "Films", "Content permissions");

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

        addInfo(card, "Device Management", "Enabled");
        addInfo(card, "Current Device", "Authorized");
        addInfo(card, "Device Verification", "Enabled");
        addInfo(card, "Unknown Devices", "Blocked");

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

        addInfo(card, "Last Login", "Central administrator");
        addInfo(card, "Activity Status", "MONITORED");
        addInfo(card, "Failed Attempts", "0");
        addInfo(card, "Audit", "Enabled");

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

        addInfo(card, "Access Protection", "ACTIVE");
        addInfo(card, "Session Protection", "ACTIVE");
        addInfo(card, "Device Protection", "ACTIVE");
        addInfo(card, "API Protection", "ACTIVE");
        addInfo(card, "Audit Monitoring", "ACTIVE");

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

        addInfo(card, "System Events", "MONITORED");
        addInfo(card, "Access Events", "MONITORED");
        addInfo(card, "Permission Changes", "MONITORED");
        addInfo(card, "Suspicious Activity", "0");

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

        addInfo(card, "Authentication", "ACTIVE");
        addInfo(card, "Password Protection", "ACTIVE");
        addInfo(card, "Session Verification", "ACTIVE");
        addInfo(card, "Multi-Factor Authentication", "READY");

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

        addInfo(card, "HTTPS", "Required");
        addInfo(card, "API Authentication", "Protected");
        addInfo(card, "API Access", "Controlled");
        addInfo(card, "Network Monitoring", "ACTIVE");

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

        addInfo(card, "Audit Logging", "ACTIVE");
        addInfo(card, "Access Logs", "ACTIVE");
        addInfo(card, "Security Logs", "ACTIVE");
        addInfo(card, "Retention", "Configured");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showSecurity()
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // PARAMETERS
    // =========================================================

    private void showParameters() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("⚙️ PARAMETERS")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central configuration"
                )
        );

        addSectionButton(
                layout,
                "🌐 Languages",
                "System language settings",
                v -> showLanguages()
        );

        addSectionButton(
                layout,
                "🎨 Appearance",
                "Interface appearance",
                v -> showAppearance()
        );

        addSectionButton(
                layout,
                "🔔 Notifications",
                "System notifications",
                v -> showNotifications()
        );

        addSectionButton(
                layout,
                "🎵 Music Parameters",
                "Music standards and settings",
                v -> showMusicParameters()
        );

        addSectionButton(
                layout,
                "🌍 Distribution Parameters",
                "Distribution standards and settings",
                v -> showDistributionParameters()
        );

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(createScroll(layout));
    }

    private void showLanguages() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🌐 LANGUAGES")
        );

        LinearLayout card = createCard();

        addInfo(card, "Primary Language", "English");
        addInfo(card, "Available", "English / Uzbek / Russian");
        addInfo(card, "Language System", "READY");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showAppearance() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🎨 APPEARANCE")
        );

        LinearLayout card = createCard();

        addInfo(card, "Theme", "Dark");
        addInfo(card, "Style", "Futuristic Neon");
        addInfo(card, "Primary Accent", "Purple / Blue");
        addInfo(card, "Interface", "AVESON Central");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showNotifications() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🔔 NOTIFICATIONS")
        );

        LinearLayout card = createCard();

        addInfo(card, "System Notifications", "Enabled");
        addInfo(card, "Security Alerts", "Enabled");
        addInfo(card, "Release Alerts", "Enabled");
        addInfo(card, "Distribution Alerts", "Enabled");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showMusicParameters() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🎵 MUSIC PARAMETERS")
        );

        addSectionButton(
                layout,
                "🎧 Audio Standards",
                "Audio file requirements",
                v -> showAudioStandards()
        );

        addSectionButton(
                layout,
                "🖼️ Cover Standards",
                "Artwork requirements",
                v -> showCoverStandards()
        );

        addSectionButton(
                layout,
                "📅 Release Standards",
                "Release requirements",
                v -> showReleaseStandards()
        );

        addSectionButton(
                layout,
                "📝 Metadata Standards",
                "Metadata requirements",
                v -> showMetadataStandards()
        );

        addSectionButton(
                layout,
                "📁 Music File Formats",
                "Supported music formats",
                v -> showMusicFileFormats()
        );

        addSectionButton(
                layout,
                "🎚️ Music Quality",
                "Quality standards",
                v -> showMusicQuality()
        );

        addButton(
                layout,
                "← BACK",
                v -> showParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showAudioStandards() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🎧 AUDIO STANDARDS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Preferred", "WAV");
        addInfo(card, "Accepted", "WAV / FLAC");
        addInfo(card, "Bit Depth", "24-bit preferred");
        addInfo(card, "Sample Rate", "44.1 / 48 kHz");
        addInfo(card, "Channels", "Stereo");
        addInfo(card, "Quality", "No clipping or distortion");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showMusicParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showCoverStandards() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🖼️ COVER STANDARDS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Ratio", "1:1");
        addInfo(card, "Recommended", "3000 × 3000 px or larger");
        addInfo(card, "Format", "JPG / PNG");
        addInfo(card, "Color", "RGB");
        addInfo(card, "Quality", "High resolution");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showMusicParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showReleaseStandards() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📅 RELEASE STANDARDS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Release Type", "Single / EP / Album");
        addInfo(card, "Release Date", "Calendar supported");
        addInfo(card, "Metadata", "Required");
        addInfo(card, "Audio", "Required");
        addInfo(card, "Cover", "Required");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showMusicParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showMetadataStandards() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📝 METADATA STANDARDS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Title", "Required");
        addInfo(card, "Artist", "Required");
        addInfo(card, "Genre", "Required");
        addInfo(card, "Language", "Required");
        addInfo(card, "Release Date", "Required");
        addInfo(card, "Explicit Status", "When applicable");
        addInfo(card, "ISRC", "When available");
        addInfo(card, "UPC", "When available");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showMusicParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showMusicFileFormats() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📁 MUSIC FILE FORMATS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Primary Master", "WAV");
        addInfo(card, "Lossless", "FLAC");
        addInfo(card, "Preview", "MP3");
        addInfo(card, "Preferred Master", "WAV");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showMusicParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showMusicQuality() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🎚️ MUSIC QUALITY")
        );

        LinearLayout card = createCard();

        addInfo(card, "Master Quality", "High quality");
        addInfo(card, "Clipping", "Not allowed");
        addInfo(card, "Distortion", "Not allowed");
        addInfo(card, "Corrupt Files", "Not allowed");
        addInfo(card, "Stereo", "Recommended");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showMusicParameters()
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // DISTRIBUTION PARAMETERS
    // =========================================================

    private void showDistributionParameters() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🌍 DISTRIBUTION PARAMETERS")
        );

        addSectionButton(
                layout,
                "📋 Distribution Standards",
                "Global distribution rules",
                v -> showDistributionStandards()
        );

        addSectionButton(
                layout,
                "🌐 Platform Settings",
                "Platform configuration",
                v -> showPlatformSettings()
        );

        addSectionButton(
                layout,
                "🚚 Release Delivery Settings",
                "Delivery configuration",
                v -> showReleaseDeliverySettings()
        );

        addSectionButton(
                layout,
                "🗺️ Territory Settings",
                "Territory configuration",
                v -> showTerritorySettings()
        );

        addSectionButton(
                layout,
                "🎵 Distribution Formats",
                "Delivery formats",
                v -> showDistributionFormats()
        );

        addSectionButton(
                layout,
                "📦 Delivery Rules",
                "Distribution delivery rules",
                v -> showDeliveryRules()
        );

        addButton(
                layout,
                "← BACK",
                v -> showParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showDistributionStandards() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📋 DISTRIBUTION STANDARDS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Master", "High quality WAV / FLAC");
        addInfo(card, "Metadata", "Complete");
        addInfo(card, "Artwork", "Square high resolution");
        addInfo(card, "Rights", "Must be authorized");
        addInfo(card, "Delivery", "Platform compatible");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showDistributionParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showPlatformSettings() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🌐 PLATFORM SETTINGS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Platform Connections", "Configured");
        addInfo(card, "Delivery Status", "Monitored");
        addInfo(card, "Platform Mapping", "Enabled");
        addInfo(card, "Reporting", "Enabled");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showDistributionParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showReleaseDeliverySettings() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🚚 RELEASE DELIVERY SETTINGS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Automatic Delivery", "READY");
        addInfo(card, "Delivery Tracking", "ACTIVE");
        addInfo(card, "Error Monitoring", "ACTIVE");
        addInfo(card, "Status Updates", "ACTIVE");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showDistributionParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showTerritorySettings() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🗺️ TERRITORY SETTINGS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Global Territories", "Enabled");
        addInfo(card, "Country Restrictions", "Configurable");
        addInfo(card, "Regional Delivery", "Supported");
        addInfo(card, "Territory Rights", "Controlled");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showDistributionParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showDistributionFormats() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🎵 DISTRIBUTION FORMATS")
        );

        LinearLayout card = createCard();

        addInfo(card, "Audio Master", "WAV / FLAC");
        addInfo(card, "Artwork", "JPG / PNG");
        addInfo(card, "Metadata", "Structured");
        addInfo(card, "Delivery Package", "Platform-specific");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showDistributionParameters()
        );

        setScreen(createScroll(layout));
    }

    private void showDeliveryRules() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("📦 DELIVERY RULES")
        );

        LinearLayout card = createCard();

        addInfo(card, "Validation", "Required");
        addInfo(card, "Rights Check", "Required");
        addInfo(card, "Metadata Check", "Required");
        addInfo(card, "Audio Check", "Required");
        addInfo(card, "Artwork Check", "Required");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showDistributionParameters()
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // SYSTEM STATUS
    // =========================================================

    private void showSystemStatus() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🛡️ SYSTEM STATUS")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central system overview"
                )
        );

        LinearLayout card = createCard();

        addInfo(card, "Central System", "ONLINE");
        addInfo(card, "Artist Control", "READY");
        addInfo(card, "Music Control", "READY");
        addInfo(card, "Distribution Control", "READY");
        addInfo(card, "Studio Control", "READY");
        addInfo(card, "Magazine Control", "READY");
        addInfo(card, "AVESON Films", "READY");

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // CENTRAL INFO
    // =========================================================

    private void showAvesonCentralInfo() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("ℹ️ AVESON CENTRAL")
        );

        layout.addView(
                createSubtitle(
                        "Global Management & Control Platform"
                )
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "System",
                "AVESON CENTRAL"
        );

        addInfo(
                card,
                "Purpose",
                "Unified global management system"
        );

        addInfo(
                card,
                "Artist",
                "AVESON ARTIST CONTROL"
        );

        addInfo(
                card,
                "Music",
                "AVESON MUSIC CONTROL"
        );

        addInfo(
                card,
                "Distribution",
                "AVESON DISTRIBUTION CONTROL"
        );

        addInfo(
                card,
                "Studio",
                "AVESON STUDIO CONTROL"
        );

        addInfo(
                card,
                "Magazine",
                "AVESON MAGAZINE CONTROL"
        );

        addInfo(
                card,
                "Films",
                "AVESON FILMS"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // ROOMS
    // =========================================================

    private void openRoom(String room) {

        LinearLayout layout = createRoot();

        // =====================================================
        // ARTIST CONTROL
        // =====================================================

        if (room.equals("ARTIST")) {

            layout.addView(
                    createTitle("🎵 AVESON ARTIST CONTROL")
            );

            layout.addView(
                    createSubtitle(
                            "Artist Management & Release Control"
                    )
            );

            addSectionButton(
                    layout,
                    "👤 Artists",
                    "Artist profiles and management",
                    v -> showArtistMessage("Artists")
            );

            addSectionButton(
                    layout,
                    "📥 Artist Submissions",
                    "Incoming artist submissions",
                    v -> showArtistMessage("Artist Submissions")
            );

            addSectionButton(
                    layout,
                    "🔍 Release Review",
                    "Review and approve releases",
                    v -> showArtistMessage("Release Review")
            );

            addSectionButton(
                    layout,
                    "🎵 Artist Releases",
                    "Releases, albums and singles",
                    v -> showArtistMessage("Artist Releases")
            );

            addSectionButton(
                    layout,
                    "🎬 Artist Videos",
                    "Videos and clips management",
                    v -> showArtistMessage("Artist Videos")
            );

            addSectionButton(
                    layout,
                    "📊 Artist Analytics",
                    "Artist performance statistics",
                    v -> showArtistMessage("Artist Analytics")
            );

            addSectionButton(
                    layout,
                    "💰 Artist Earnings",
                    "Royalties and earnings",
                    v -> showArtistMessage("Artist Earnings")
            );

            addSectionButton(
                    layout,
                    "🌍 Distribution",
                    "Artist distribution management",
                    v -> showArtistMessage("Distribution")
            );

            addSectionButton(
                    layout,
                    "🎧 Audio Standards",
                    "Audio submission standards",
                    v -> showArtistAudioStandards()
            );

            addSectionButton(
                    layout,
                    "🖼️ Cover Standards",
                    "Cover artwork requirements",
                    v -> showArtistCoverStandards()
            );

            addSectionButton(
                    layout,
                    "🔐 Rights & Copyright",
                    "Rights, ownership and copyright",
                    v -> showArtistRights()
            );

            addSectionButton(
                    layout,
                    "📄 Artist Documents",
                    "Contracts and artist documents",
                    v -> showArtistMessage("Artist Documents")
            );

            addSectionButton(
                    layout,
                    "📣 Marketing",
                    "Artist promotion and campaigns",
                    v -> showArtistMessage("Marketing")
            );

            addSectionButton(
                    layout,
                    "👥 Audience",
                    "Audience and listener information",
                    v -> showArtistMessage("Audience")
            );

            addSectionButton(
                    layout,
                    "🔑 Access & Permissions",
                    "Artist access and permissions",
                    v -> showArtistMessage("Access & Permissions")
            );

            addSectionButton(
                    layout,
                    "⚙️ Artist Settings",
                    "Artist control settings",
                    v -> showArtistMessage("Artist Settings")
            );

            addButton(
                    layout,
                    "← BACK",
                    v -> showCentralHome()
            );

            setScreen(createScroll(layout));

            return;
        }

        // =====================================================
        // MUSIC CONTROL
        // =====================================================

        if (room.equals("MUSIC")) {

            layout.addView(
                    createTitle("🎼 AVESON MUSIC CONTROL")
            );

            layout.addView(
                    createSubtitle(
                            "Music Catalog & Content Control"
                    )
            );

            addSectionButton(
                    layout,
                    "🎵 Music Catalog",
                    "Global music catalog",
                    v -> showMessage("Music Catalog")
            );

            addSectionButton(
                    layout,
                    "💿 Albums & Releases",
                    "Albums, EPs and singles",
                    v -> showMessage("Albums & Releases")
            );

            addSectionButton(
                    layout,
                    "📋 Playlists",
                    "Playlist management",
                    v -> showMessage("Playlists")
            );

            addSectionButton(
                    layout,
                    "👥 Music Users",
                    "Music platform users",
                    v -> showMessage("Music Users")
            );

            addSectionButton(
                    layout,
                    "📊 Music Analytics",
                    "Music statistics",
                    v -> showMessage("Music Analytics")
            );

            addSectionButton(
                    layout,
                    "⚙️ Music Settings",
                    "Music control settings",
                    v -> showMessage("Music Settings")
            );

            addButton(
                    layout,
                    "← BACK",
                    v -> showCentralHome()
            );

            setScreen(createScroll(layout));

            return;
        }

        // =====================================================
        // DISTRIBUTION CONTROL
        // =====================================================

        if (room.equals("DISTRIBUTION")) {

            layout.addView(
                    createTitle("🌍 AVESON DISTRIBUTION CONTROL")
            );

            layout.addView(
                    createSubtitle(
                            "Global Distribution & Platform Management"
                    )
            );

            addSectionButton(
                    layout,
                    "🌐 Distribution Platforms",
                    "Global platform connections",
                    v -> showMessage("Distribution Platforms")
            );

            addSectionButton(
                    layout,
                    "📦 Distribution Releases",
                    "Releases in distribution",
                    v -> showMessage("Distribution Releases")
            );

            addSectionButton(
                    layout,
                    "🚚 Release Delivery",
                    "Delivery and tracking",
                    v -> showMessage("Release Delivery")
            );

            addSectionButton(
                    layout,
                    "📊 Distribution Analytics",
                    "Distribution statistics",
                    v -> showMessage("Distribution Analytics")
            );

            addSectionButton(
                    layout,
                    "⚙️ Distribution Settings",
                    "Distribution settings",
                    v -> showMessage("Distribution Settings")
            );

            addButton(
                    layout,
                    "← BACK",
                    v -> showCentralHome()
            );

            setScreen(createScroll(layout));

            return;
        }

        // =====================================================
        // STUDIO CONTROL
        // =====================================================

        if (room.equals("STUDIO")) {

            layout.addView(
                    createTitle("🎙️ AVESON STUDIO CONTROL")
            );

            layout.addView(
                    createSubtitle(
                            "Studio Projects & Production"
                    )
            );

            addSectionButton(
                    layout,
                    "🎙️ Studio Projects",
                    "Studio projects",
                    v -> showMessage("Studio Projects")
            );

            addSectionButton(
                    layout,
                    "🎚️ Audio Production",
                    "Audio production management",
                    v -> showMessage("Audio Production")
            );

            addSectionButton(
                    layout,
                    "🎧 Sessions",
                    "Studio sessions",
                    v -> showMessage("Sessions")
            );

            addSectionButton(
                    layout,
                    "📁 Studio Files",
                    "Studio files",
                    v -> showMessage("Studio Files")
            );

            addSectionButton(
                    layout,
                    "📊 Studio Analytics",
                    "Studio statistics",
                    v -> showMessage("Studio Analytics")
            );

            addSectionButton(
                    layout,
                    "⚙️ Studio Settings",
                    "Studio settings",
                    v -> showMessage("Studio Settings")
            );

            addButton(
                    layout,
                    "← BACK",
                    v -> showCentralHome()
            );

            setScreen(createScroll(layout));

            return;
        }

        // =====================================================
        // MAGAZINE CONTROL
        // =====================================================

        if (room.equals("MAGAZINE")) {

            layout.addView(
                    createTitle("📰 AVESON MAGAZINE CONTROL")
            );

            layout.addView(
                    createSubtitle(
                            "Articles, Editorial & Media"
                    )
            );

            addSectionButton(
                    layout,
                    "📝 Articles",
                    "Magazine articles",
                    v -> showMessage("Articles")
            );

            addSectionButton(
                    layout,
                    "✍️ Editorial",
                    "Editorial management",
                    v -> showMessage("Editorial")
            );

            addSectionButton(
                    layout,
                    "🖼️ Media",
                    "Magazine media",
                    v -> showMessage("Media")
            );

            addSectionButton(
                    layout,
                    "👤 Writers",
                    "Writer management",
                    v -> showMessage("Writers")
            );

            addSectionButton(
                    layout,
                    "📊 Magazine Analytics",
                    "Magazine statistics",
                    v -> showMessage("Magazine Analytics")
            );

            addSectionButton(
                    layout,
                    "⚙️ Magazine Settings",
                    "Magazine settings",
                    v -> showMessage("Magazine Settings")
            );

            addButton(
                    layout,
                    "← BACK",
                    v -> showCentralHome()
            );

            setScreen(createScroll(layout));

            return;
        }

        // =====================================================
        // FILMS
        // =====================================================

        if (room.equals("FILMS")) {

            layout.addView(
                    createTitle("🎬 AVESON FILMS")
            );

            layout.addView(
                    createSubtitle(
                            "Films, Videos & Original Content"
                    )
            );

            addSectionButton(
                    layout,
                    "🎬 Projects",
                    "Film projects",
                    v -> showMessage("Film Projects")
            );

            addSectionButton(
                    layout,
                    "🎥 Videos",
                    "Video management",
                    v -> showMessage("Videos")
            );

            addSectionButton(
                    layout,
                    "🎞️ Productions",
                    "Production management",
                    v -> showMessage("Productions")
            );

            addSectionButton(
                    layout,
                    "📁 Film Library",
                    "Film content library",
                    v -> showMessage("Film Library")
            );

            addSectionButton(
                    layout,
                    "📊 Film Analytics",
                    "Film statistics",
                    v -> showMessage("Film Analytics")
            );

            addSectionButton(
                    layout,
                    "⚙️ Film Settings",
                    "Film settings",
                    v -> showMessage("Film Settings")
            );

            addButton(
                    layout,
                    "← BACK",
                    v -> showCentralHome()
            );

            setScreen(createScroll(layout));

            return;
        }
    }

    // =========================================================
    // ARTIST GENERIC MODULE
    // =========================================================

    private void showArtistMessage(String name) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle(name)
        );

        layout.addView(
                createSubtitle(
                        "AVESON ARTIST CONTROL"
                )
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Section",
                name
        );

        addInfo(
                card,
                "Status",
                "AVAILABLE"
        );

        addInfo(
                card,
                "System",
                "AVESON CENTRAL"
        );

        addInfo(
                card,
                "Connection",
                "Not connected"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK TO ARTIST CONTROL",
                v -> openRoom("ARTIST")
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // ARTIST AUDIO STANDARDS
    // =========================================================

    private void showArtistAudioStandards() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🎧 AUDIO STANDARDS")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Artist submission requirements"
                )
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Preferred Format",
                "WAV"
        );

        addInfo(
                card,
                "Accepted",
                "WAV / FLAC"
        );

        addInfo(
                card,
                "Bit Depth",
                "24-bit preferred"
        );

        addInfo(
                card,
                "Sample Rate",
                "44.1 kHz / 48 kHz"
        );

        addInfo(
                card,
                "Channels",
                "Stereo"
        );

        addInfo(
                card,
                "Quality",
                "No clipping or distortion"
        );

        addInfo(
                card,
                "File",
                "Complete and non-corrupted"
        );

        layout.addView(card);

        layout.addView(
                createSubtitle("METADATA")
        );

        LinearLayout metadata = createCard();

        addInfo(metadata, "Title", "Required");
        addInfo(metadata, "Artist", "Required");
        addInfo(metadata, "Genre", "Required");
        addInfo(metadata, "Language", "Required");
        addInfo(metadata, "Release Date", "Required");
        addInfo(metadata, "Explicit Content", "When applicable");
        addInfo(metadata, "Contributors", "Recommended");
        addInfo(metadata, "ISRC", "When available");
        addInfo(metadata, "UPC", "When available");

        layout.addView(metadata);

        addButton(
                layout,
                "← BACK",
                v -> openRoom("ARTIST")
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // ARTIST COVER STANDARDS
    // =========================================================

    private void showArtistCoverStandards() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🖼️ COVER STANDARDS")
        );

        layout.addView(
                createSubtitle(
                        "AVESON release artwork requirements"
                )
        );

        LinearLayout card = createCard();

        addInfo(card, "Format", "JPG / PNG");
        addInfo(card, "Ratio", "1:1 square");
        addInfo(card, "Recommended Size", "3000 × 3000 px or larger");
        addInfo(card, "Color", "RGB");
        addInfo(card, "Quality", "High resolution");
        addInfo(card, "Artwork", "Professional and genre appropriate");

        layout.addView(card);

        layout.addView(
                createSubtitle("NOT ALLOWED")
        );

        LinearLayout restrictions = createCard();

        addInfo(restrictions, "Platform Logos", "Not allowed");
        addInfo(restrictions, "QR Codes", "Not allowed");
        addInfo(restrictions, "Prices", "Not allowed");
        addInfo(restrictions, "Advertising", "Not allowed");
        addInfo(restrictions, "Contact Information", "Not allowed");
        addInfo(restrictions, "Misleading Text", "Not allowed");
        addInfo(restrictions, "Low Quality Screenshots", "Not allowed");

        layout.addView(restrictions);

        addButton(
                layout,
                "← BACK",
                v -> openRoom("ARTIST")
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // ARTIST RIGHTS
    // =========================================================

    private void showArtistRights() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🔐 RIGHTS & COPYRIGHT")
        );

        layout.addView(
                createSubtitle(
                        "Artist ownership and rights control"
                )
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Master Rights",
                "Ownership information"
        );

        addInfo(
                card,
                "Publishing",
                "Publishing rights"
        );

        addInfo(
                card,
                "Copyright",
                "Copyright ownership"
        );

        addInfo(
                card,
                "Splits",
                "Revenue / ownership splits"
        );

        addInfo(
                card,
                "Songwriters",
                "Songwriter information"
        );

        addInfo(
                card,
                "Contributors",
                "Contributor information"
        );

        addInfo(
                card,
                "Documents",
                "Rights documentation"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> openRoom("ARTIST")
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // GENERIC CENTRAL MESSAGE
    // =========================================================

    private void showMessage(String name) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle(name)
        );

        layout.addView(
                createSubtitle(
                        "AVESON CENTRAL"
                )
        );

        LinearLayout card = createCard();

        addInfo(
                card,
                "Section",
                name
        );

        addInfo(
                card,
                "Status",
                "AVAILABLE"
        );

        addInfo(
                card,
                "System",
                "AVESON CENTRAL"
        );

        addInfo(
                card,
                "Data",
                "Not connected"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showGlobalMenu()
        );

        setScreen(createScroll(layout));
    }

    // =========================================================
    // EXTRA INFO HELPER
    // =========================================================

    private void addInfoToLayout(
            LinearLayout layout,
            String label,
            String value
    ) {

        LinearLayout card = createCard();

        addInfo(
                card,
                label,
                value
        );

        layout.addView(card);
    }
            }
