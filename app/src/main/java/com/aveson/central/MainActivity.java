package com.aveson.central;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final int BG = Color.rgb(7, 7, 18);
    private final int CARD = Color.rgb(20, 17, 38);
    private final int BORDER = Color.rgb(70, 55, 120);
    private final int PURPLE = Color.rgb(145, 80, 245);
    private final int TEXT_SECONDARY = Color.rgb(175, 170, 200);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showCentral();
    }

    // =========================================================
    // AVESON CENTRAL HOME
    // =========================================================

    private void showCentral() {
        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView menu = createButton("☰  MENU");

        LinearLayout.LayoutParams menuParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        dp(44)
                );

        menuParams.gravity = Gravity.START;
        menuParams.setMargins(0, dp(18), 0, dp(20));

        menu.setLayoutParams(menuParams);
        menu.setOnClickListener(v -> showMenu());
        root.addView(menu);

        TextView title = createTitle("AVESON CENTRAL");
        root.addView(title);

        TextView subtitle = createSubtitle(
                "CONTROL CENTER\n\nGLOBAL MUSIC ECOSYSTEM"
        );
        root.addView(subtitle);

        addRoom(
                root,
                "🎵",
                "AVESON ARTIST CONTROL",
                "Artist management and artist operations"
        );

        addRoom(
                root,
                "🎼",
                "AVESON MUSIC CONTROL",
                "Music catalog and release management"
        );

        addRoom(
                root,
                "🌍",
                "AVESON DISTRIBUTION CONTROL",
                "Global music distribution management"
        );

        addRoom(
                root,
                "🎙️",
                "AVESON STUDIO CONTROL",
                "Studio and production management"
        );

        addRoom(
                root,
                "📰",
                "AVESON MAGAZINE CONTROL",
                "Magazine and editorial management"
        );

        addRoom(
                root,
                "🎬",
                "AVESON FILMS",
                "Film and video management"
        );

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // =========================================================
    // CENTRAL MENU
    // =========================================================

    private void showMenu() {
        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showCentral());
        root.addView(back);

        TextView title = createTitle("☰  AVESON CENTRAL MENU");
        root.addView(title);

        TextView subtitle = createSubtitle(
                "GLOBAL CENTRAL MANAGEMENT"
        );
        root.addView(subtitle);

        addMenuItem(
                root,
                "📊",
                "ANALYTICS",
                "Central system statistics"
        );

        addMenuItem(
                root,
                "💰",
                "ROYALTY CONTROL",
                "Royalty and financial management"
        );

        addMenuItem(
                root,
                "🔐",
                "SECURITY",
                "System security and access control"
        );

        addMenuItem(
                root,
                "⚙️",
                "PARAMETERS",
                "Central system parameters"
        );

        addMenuItem(
                root,
                "🛡️",
                "SYSTEM STATUS",
                "AVESON Central system status"
        );

        addMenuItem(
                root,
                "ℹ️",
                "AVESON CENTRAL INFO",
                "Information about AVESON Central"
        );

        scrollView.addView(root);
        setContentView(scrollView);
    }

    private void addMenuItem(
            LinearLayout root,
            String icon,
            String name,
            String description
    ) {
        LinearLayout card = createCard();

        TextView iconView = new TextView(this);
        iconView.setText(icon);
        iconView.setTextSize(27);
        iconView.setTextColor(Color.WHITE);
        card.addView(iconView);

        TextView title = new TextView(this);
        title.setText(name);
        title.setTextSize(17);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams titleParams =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        titleParams.setMargins(
                0,
                dp(6),
                0,
                dp(2)
        );

        title.setLayoutParams(titleParams);
        card.addView(title);

        TextView desc = new TextView(this);
        desc.setText(description);
        desc.setTextSize(13);
        desc.setTextColor(TEXT_SECONDARY);
        card.addView(desc);

        card.setOnClickListener(v -> openMenuItem(name));

        root.addView(card);
    }

    private void openMenuItem(String name) {

        if (name.equals("ANALYTICS")) {
            showAnalytics();

        } else if (name.equals("ROYALTY CONTROL")) {
            showRoyaltyControl();

        } else if (name.equals("SECURITY")) {
            showSecurity();

        } else if (name.equals("PARAMETERS")) {
            showParameters();

        } else if (name.equals("SYSTEM STATUS")) {
            showSystemStatus();

        } else if (name.equals("AVESON CENTRAL INFO")) {
            showCentralInfo();
        }
    }

    // =========================================================
    // ANALYTICS
    // =========================================================

    private void showAnalytics() {
        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showMenu());
        root.addView(back);

        root.addView(createTitle("📊 ANALYTICS"));

        root.addView(createSubtitle(
                "AVESON CENTRAL SYSTEM ANALYTICS"
        ));

        // -----------------------------------------------------
        // GENERAL ANALYTICS
        // -----------------------------------------------------

        root.addView(createSectionTitle(
                "📊 GENERAL ANALYTICS"
        ));

        addAnalyticsCard(
                root,
                "👤",
                "TOTAL ARTISTS",
                "0"
        );

        addAnalyticsCard(
                root,
                "🎵",
                "TOTAL RELEASES",
                "0"
        );

        addAnalyticsCard(
                root,
                "🎧",
                "TOTAL STREAMS",
                "0"
        );

        addAnalyticsCard(
                root,
                "👁️",
                "TOTAL VIEWS",
                "0"
        );

        addAnalyticsCard(
                root,
                "💿",
                "TOTAL ALBUMS",
                "0"
        );

        addAnalyticsCard(
                root,
                "🌍",
                "ACTIVE DISTRIBUTION",
                "0"
        );

        // -----------------------------------------------------
        // AVESON USERS
        // -----------------------------------------------------

        root.addView(createSectionTitle(
                "👥 AVESON USERS"
        ));

        addAnalyticsCard(
                root,
                "🎵",
                "AVESON ARTIST",
                "0 Artists"
        );

        addAnalyticsCard(
                root,
                "🌍",
                "AVESON DISTRIBUTION",
                "0 Users"
        );

        addAnalyticsCard(
                root,
                "🎬",
                "AVESON FILMS",
                "0 Users"
        );

        addAnalyticsCard(
                root,
                "🎙️",
                "AVESON STUDIO",
                "0 Users"
        );

        addAnalyticsCard(
                root,
                "📰",
                "AVESON MAGAZINE",
                "0 Users"
        );

        addAnalyticsCard(
                root,
                "🎼",
                "AVESON MUSIC",
                "0 Users"
        );

        addAnalyticsCard(
                root,
                "👥",
                "TOTAL USERS",
                "0 Users"
        );

        // -----------------------------------------------------
        // REVENUE OVERVIEW
        // -----------------------------------------------------

        root.addView(createSectionTitle(
                "💰 REVENUE OVERVIEW"
        ));

        addAnalyticsCard(
                root,
                "💵",
                "TOTAL REVENUE",
                "$0"
        );

        addAnalyticsCard(
                root,
                "📈",
                "REVENUE GROWTH",
                "0%"
        );

        // -----------------------------------------------------
        // REVENUE SOURCES
        // -----------------------------------------------------

        root.addView(createSectionTitle(
                "💰 REVENUE SOURCES"
        ));

        addAnalyticsCard(
                root,
                "🎵",
                "MUSIC REVENUE",
                "$0"
        );

        addAnalyticsCard(
                root,
                "🌍",
                "DISTRIBUTION REVENUE",
                "$0"
        );

        addAnalyticsCard(
                root,
                "🎬",
                "FILMS REVENUE",
                "$0"
        );

        addAnalyticsCard(
                root,
                "🎙️",
                "STUDIO REVENUE",
                "$0"
        );

        addAnalyticsCard(
                root,
                "📰",
                "MAGAZINE REVENUE",
                "$0"
        );

        addAnalyticsCard(
                root,
                "💳",
                "OTHER REVENUE",
                "$0"
        );

        addAnalyticsCard(
                root,
                "💰",
                "TOTAL REVENUE",
                "$0"
        );

        // -----------------------------------------------------
        // STATISTICS
        // -----------------------------------------------------

        root.addView(createSectionTitle(
                "📈 STATISTICS"
        ));

        addAnalyticsCard(
                root,
                "📈",
                "GROWTH STATISTICS",
                "No data yet"
        );

        addAnalyticsCard(
                root,
                "🌐",
                "GLOBAL ACTIVITY",
                "No activity yet"
        );

        scrollView.addView(root);
        setContentView(scrollView);
    }

    private void addAnalyticsCard(
            LinearLayout root,
            String icon,
            String name,
            String value
    ) {
        LinearLayout card = createCard();

        TextView iconView = new TextView(this);
        iconView.setText(icon);
        iconView.setTextSize(25);
        iconView.setTextColor(Color.WHITE);

        card.addView(iconView);

        TextView nameView = new TextView(this);
        nameView.setText(name);
        nameView.setTextSize(14);
        nameView.setTextColor(TEXT_SECONDARY);

        LinearLayout.LayoutParams nameParams =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        nameParams.setMargins(
                0,
                dp(6),
                0,
                dp(2)
        );

        nameView.setLayoutParams(nameParams);
        card.addView(nameView);

        TextView valueView = new TextView(this);
        valueView.setText(value);
        valueView.setTextSize(22);
        valueView.setTypeface(null, Typeface.BOLD);
        valueView.setTextColor(Color.WHITE);

        card.addView(valueView);

        root.addView(card);
    }

    private TextView createSectionTitle(String text) {
        TextView title = new TextView(this);

        title.setText(text);
        title.setTextSize(19);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.START);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(22),
                0,
                dp(6)
        );

        title.setLayoutParams(params);

        return title;
    }

    // =========================================================
    // ROYALTY CONTROL
    // =========================================================

    private void showRoyaltyControl() {

        showMenuSection(
                "💰 ROYALTY CONTROL",
                "ROYALTY MANAGEMENT",
                new String[]{
                        "💵 Royalty Overview",
                        "💳 Payments",
                        "📄 Royalty Reports",
                        "👤 Artist Earnings",
                        "🌍 Distribution Earnings"
                }
        );
    }

    // =========================================================
    // SECURITY
    // =========================================================

    private void showSecurity() {

        showMenuSection(
                "🔐 SECURITY",
                "AVESON CENTRAL SECURITY",
                new String[]{
                        "🔑 Access Control",
                        "📱 Authorized Devices",
                        "🕒 Login Activity",
                        "🛡️ Security Protection",
                        "🚨 Security Events"
                }
        );
    }

    // =========================================================
    // PARAMETERS
    // =========================================================

    private void showParameters() {

        showMenuSection(
                "⚙️ PARAMETERS",
                "CENTRAL SYSTEM PARAMETERS",
                new String[]{
                        "🌐 LANGUAGES",
                        "🎨 APPEARANCE",
                        "🔔 NOTIFICATIONS",
                        "🎵 MUSIC PARAMETERS",
                        "🌍 DISTRIBUTION PARAMETERS"
                }
        );
    }

    // =========================================================
    // SYSTEM STATUS
    // =========================================================

    private void showSystemStatus() {

        showMenuSection(
                "🛡️ SYSTEM STATUS",
                "AVESON CENTRAL SYSTEM STATUS",
                new String[]{
                        "🟢 Central System",
                        "🟢 Database",
                        "🟢 API Services",
                        "🟢 Distribution Services",
                        "🟢 Storage",
                        "🟢 Security Services"
                }
        );
    }

    // =========================================================
    // CENTRAL INFO
    // =========================================================

    private void showCentralInfo() {

        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showMenu());
        root.addView(back);

        root.addView(createTitle(
                "ℹ️ AVESON CENTRAL INFO"
        ));

        root.addView(createSubtitle(
                "AVESON GLOBAL MUSIC ECOSYSTEM"
        ));

        addInfoCard(
                root,
                "SYSTEM NAME",
                "AVESON CENTRAL"
        );

        addInfoCard(
                root,
                "SYSTEM TYPE",
                "Global Management & Control Platform"
        );

        addInfoCard(
                root,
                "PLATFORM",
                "AVESON Global Music Ecosystem"
        );

        addInfoCard(
                root,
                "VERSION",
                "1.0"
        );

        addInfoCard(
                root,
                "STATUS",
                "ACTIVE"
        );

        scrollView.addView(root);
        setContentView(scrollView);
    }

    private void addInfoCard(
            LinearLayout root,
            String title,
            String value
    ) {
        LinearLayout card = createCard();

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextSize(13);
        titleView.setTextColor(TEXT_SECONDARY);

        card.addView(titleView);

        TextView valueView = new TextView(this);
        valueView.setText(value);
        valueView.setTextSize(17);
        valueView.setTypeface(null, Typeface.BOLD);
        valueView.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams valueParams =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        valueParams.setMargins(
                0,
                dp(5),
                0,
                0
        );

        valueView.setLayoutParams(valueParams);

        card.addView(valueView);

        root.addView(card);
    }

    // =========================================================
    // CENTRAL MENU SECTION
    // =========================================================

    private void showMenuSection(
            String titleText,
            String subtitleText,
            String[] items
    ) {
        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showMenu());
        root.addView(back);

        root.addView(createTitle(titleText));

        root.addView(createSubtitle(subtitleText));

        for (String item : items) {

            LinearLayout card = createCard();

            TextView text = new TextView(this);
            text.setText(item);
            text.setTextSize(16);
            text.setTypeface(null, Typeface.BOLD);
            text.setTextColor(Color.WHITE);
            text.setGravity(Gravity.CENTER_VERTICAL);

            card.addView(text);

            card.setOnClickListener(v -> {

                if (item.equals("🌐 LANGUAGES")) {
                    showLanguages();
                } else {
                    showMessage(item);
                }
            });

            root.addView(card);
        }

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // =========================================================
    // LANGUAGES
    // =========================================================

    private void showLanguages() {

        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showParameters());
        root.addView(back);

        root.addView(createTitle(
                "🌐 LANGUAGES"
        ));

        root.addView(createSubtitle(
                "SELECT AVESON CENTRAL LANGUAGE"
        ));

        addLanguage(root, "English");
        addLanguage(root, "O'zbek");
        addLanguage(root, "Русский");
        addLanguage(root, "Español");
        addLanguage(root, "Français");
        addLanguage(root, "Deutsch");
        addLanguage(root, "Türkçe");
        addLanguage(root, "العربية");
        addLanguage(root, "中文");
        addLanguage(root, "한국어");

        scrollView.addView(root);
        setContentView(scrollView);
    }

    private void addLanguage(
            LinearLayout root,
            String language
    ) {
        LinearLayout card = createCard();

        TextView text = new TextView(this);
        text.setText("🌐  " + language);
        text.setTextSize(16);
        text.setTypeface(null, Typeface.BOLD);
        text.setTextColor(Color.WHITE);

        card.addView(text);

        card.setOnClickListener(v ->
                Toast.makeText(
                        this,
                        language + " selected",
                        Toast.LENGTH_SHORT
                ).show()
        );

        root.addView(card);
    }

    // =========================================================
    // ROOMS
    // =========================================================

    private void addRoom(
            LinearLayout root,
            String icon,
            String name,
            String description
    ) {
        LinearLayout card = createCard();

        TextView iconView = new TextView(this);
        iconView.setText(icon);
        iconView.setTextSize(28);
        iconView.setTextColor(Color.WHITE);

        card.addView(iconView);

        TextView title = new TextView(this);
        title.setText(name);
        title.setTextSize(17);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.WHITE);

        LinearLayout.LayoutParams titleParams =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        titleParams.setMargins(
                0,
                dp(6),
                0,
                dp(2)
        );

        title.setLayoutParams(titleParams);

        card.addView(title);

        TextView desc = new TextView(this);
        desc.setText(description);
        desc.setTextSize(13);
        desc.setTextColor(TEXT_SECONDARY);

        card.addView(desc);

        card.setOnClickListener(v ->
                openRoom(name)
        );

        root.addView(card);
    }

    private void openRoom(String name) {

        if (name.equals("AVESON ARTIST CONTROL")) {

            showRoomMenu(
                    "🎵 AVESON ARTIST CONTROL",
                    "ARTIST MANAGEMENT",
                    new String[]{
                            "👤 Artists",
                            "🎵 Artist Submissions",
                            "📄 Release Review",
                            "📊 Artist Analytics",
                            "⚙️ Artist Settings"
                    }
            );

        } else if (name.equals("AVESON MUSIC CONTROL")) {

            showRoomMenu(
                    "🎼 AVESON MUSIC CONTROL",
                    "MUSIC MANAGEMENT",
                    new String[]{
                            "🎵 Music Catalog",
                            "💿 Albums & Releases",
                            "📋 Playlists",
                            "👥 Music Users",
                            "📊 Music Analytics",
                            "⚙️ Music Settings"
                    }
            );

        } else if (name.equals("AVESON DISTRIBUTION CONTROL")) {

            showRoomMenu(
                    "🌍 AVESON DISTRIBUTION CONTROL",
                    "GLOBAL DISTRIBUTION MANAGEMENT",
                    new String[]{
                            "🌍 Distribution Platforms",
                            "📦 Distribution Releases",
                            "🚀 Release Delivery",
                            "📊 Distribution Analytics",
                            "⚙️ Distribution Settings"
                    }
            );

        } else if (name.equals("AVESON STUDIO CONTROL")) {

            showRoomMenu(
                    "🎙️ AVESON STUDIO CONTROL",
                    "STUDIO MANAGEMENT",
                    new String[]{
                            "🎙️ Studio Projects",
                            "🎚️ Audio Production",
                            "🎧 Sessions",
                            "📁 Studio Files",
                            "📊 Studio Analytics",
                            "⚙️ Studio Settings"
                    }
            );

        } else if (name.equals("AVESON MAGAZINE CONTROL")) {

            showRoomMenu(
                    "📰 AVESON MAGAZINE CONTROL",
                    "MAGAZINE MANAGEMENT",
                    new String[]{
                            "📰 Articles",
                            "✍️ Editorial",
                            "📸 Media",
                            "👥 Writers",
                            "📊 Magazine Analytics",
                            "⚙️ Magazine Settings"
                    }
            );

        } else if (name.equals("AVESON FILMS")) {

            showRoomMenu(
                    "🎬 AVESON FILMS",
                    "FILM & VIDEO MANAGEMENT",
                    new String[]{
                            "🎬 Projects",
                            "🎥 Videos",
                            "🎞️ Productions",
                            "📁 Film Library",
                            "📊 Film Analytics",
                            "⚙️ Film Settings"
                    }
            );
        }
    }

    // =========================================================
    // ROOM MENU
    // =========================================================

    private void showRoomMenu(
            String titleText,
            String subtitleText,
            String[] items
    ) {
        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showCentral());
        root.addView(back);

        root.addView(createTitle(titleText));

        root.addView(createSubtitle(subtitleText));

        for (String item : items) {

            LinearLayout card = createCard();

            TextView text = new TextView(this);
            text.setText(item);
            text.setTextSize(16);
            text.setTypeface(null, Typeface.BOLD);
            text.setTextColor(Color.WHITE);

            card.addView(text);

            card.setOnClickListener(v ->
                    showMessage(item)
            );

            root.addView(card);
        }

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // =========================================================
    // CARD
    // =========================================================

    private LinearLayout createCard() {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(
                LinearLayout.VERTICAL
        );

        card.setPadding(
                dp(18),
                dp(16),
                dp(18),
                dp(16)
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(18));
        background.setStroke(
                dp(1),
                BORDER
        );

        card.setBackground(background);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(7),
                0,
                dp(7)
        );

        card.setLayoutParams(params);

        return card;
    }

    // =========================================================
    // BUTTON
    // =========================================================

    private TextView createButton(String text) {

        TextView button = new TextView(this);

        button.setText(text);
        button.setTextSize(15);
        button.setTypeface(null, Typeface.BOLD);
        button.setTextColor(Color.WHITE);
        button.setGravity(Gravity.CENTER);

        button.setPadding(
                dp(18),
                0,
                dp(18),
                0
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(PURPLE);
        background.setCornerRadius(dp(18));

        button.setBackground(background);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        dp(44)
                );

        params.setMargins(
                0,
                dp(12),
                0,
                dp(8)
        );

        button.setLayoutParams(params);

        return button;
    }

    // =========================================================
    // TITLE
    // =========================================================

    private TextView createTitle(String text) {

        TextView title = new TextView(this);

        title.setText(text);
        title.setTextSize(25);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(10),
                0,
                dp(8)
        );

        title.setLayoutParams(params);

        return title;
    }

    // =========================================================
    // SUBTITLE
    // =========================================================

    private TextView createSubtitle(String text) {

        TextView subtitle = new TextView(this);

        subtitle.setText(text);
        subtitle.setTextSize(13);
        subtitle.setTextColor(TEXT_SECONDARY);
        subtitle.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        -1,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                0,
                0,
                dp(18)
        );

        subtitle.setLayoutParams(params);

        return subtitle;
    }

    // =========================================================
    // ROOT
    // =========================================================

    private LinearLayout createRoot() {

        LinearLayout root =
                new LinearLayout(this);

        root.setOrientation(
                LinearLayout.VERTICAL
        );

        root.setPadding(
                dp(24),
                dp(24),
                dp(24),
                dp(36)
        );

        root.setBackgroundColor(BG);

        return root;
    }

    // =========================================================
    // SCROLL VIEW
    // =========================================================

    private ScrollView createScrollView() {

        ScrollView scrollView =
                new ScrollView(this);

        scrollView.setFillViewport(true);
        scrollView.setClipToPadding(false);
        scrollView.setBackgroundColor(BG);

        scrollView.setPadding(
                0,
                0,
                0,
                dp(36)
        );

        return scrollView;
    }

    // =========================================================
    // MESSAGE
    // =========================================================

    private void showMessage(String message) {

        Toast.makeText(
                this,
                message + " — module ready",
                Toast.LENGTH_SHORT
        ).show();
    }

    // =========================================================
    // DP
    // =========================================================

    private int dp(int value) {

        return (int) (
                value *
                getResources()
                        .getDisplayMetrics()
                        .density
        );
    }
    }
