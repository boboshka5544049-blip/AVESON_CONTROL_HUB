package com.aveson.central;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int PURPLE = Color.rgb(185, 100, 255);
    private int BLUE = Color.rgb(80, 150, 255);
    private int DARK = Color.rgb(8, 8, 18);
    private int CARD = Color.rgb(15, 15, 30);
    private int TEXT_GRAY = Color.rgb(165, 165, 185);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(DARK);
        getWindow().setNavigationBarColor(DARK);

        showCentralHome();
    }

    // ============================================================
    // CENTRAL HOME
    // ============================================================

    private void showCentralHome() {

        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView menu = createButton("☰  MENU");
        menu.setOnClickListener(v -> showMenu());
        root.addView(menu);

        root.addView(createTitle("AVESON CENTRAL"));
        root.addView(createSubtitle(
                "GLOBAL MANAGEMENT & CONTROL PLATFORM"
        ));

        root.addView(createRoomButton(
                "🎵",
                "AVESON ARTIST CONTROL",
                "Artist management and submissions",
                v -> openRoom("AVESON ARTIST CONTROL")
        ));

        root.addView(createRoomButton(
                "🎼",
                "AVESON MUSIC CONTROL",
                "Music catalog and music management",
                v -> openRoom("AVESON MUSIC CONTROL")
        ));

        root.addView(createRoomButton(
                "🌍",
                "AVESON DISTRIBUTION CONTROL",
                "Global music distribution management",
                v -> openRoom("AVESON DISTRIBUTION CONTROL")
        ));

        root.addView(createRoomButton(
                "🎙️",
                "AVESON STUDIO CONTROL",
                "Studio and audio production management",
                v -> openRoom("AVESON STUDIO CONTROL")
        ));

        root.addView(createRoomButton(
                "📰",
                "AVESON MAGAZINE CONTROL",
                "Magazine and editorial management",
                v -> openRoom("AVESON MAGAZINE CONTROL")
        ));

        root.addView(createRoomButton(
                "🎬",
                "AVESON FILMS",
                "Film and video production management",
                v -> openRoom("AVESON FILMS")
        ));

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // ============================================================
    // GLOBAL MENU
    // ============================================================

    private void showMenu() {

        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showCentralHome());
        root.addView(back);

        root.addView(createTitle("☰ MENU"));
        root.addView(createSubtitle(
                "AVESON CENTRAL MANAGEMENT"
        ));

        root.addView(createMenuButton(
                "📊  ANALYTICS",
                "Users, content and system activity",
                v -> showAnalytics()
        ));

        root.addView(createMenuButton(
                "💰  ROYALTY CONTROL",
                "Revenue, payments and artist earnings",
                v -> showRoyaltyControl()
        ));

        root.addView(createMenuButton(
                "🔐  SECURITY",
                "Security and access management",
                v -> showSecurity()
        ));

        root.addView(createMenuButton(
                "⚙️  PARAMETERS",
                "Central system parameters",
                v -> showParameters()
        ));

        root.addView(createMenuButton(
                "🛡️  SYSTEM STATUS",
                "System and service status",
                v -> showSystemStatus()
        ));

        root.addView(createMenuButton(
                "ℹ️  AVESON CENTRAL INFO",
                "System information",
                v -> showCentralInfo()
        ));

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // ============================================================
    // ANALYTICS
    // ============================================================

    private void showAnalytics() {

        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showMenu());
        root.addView(back);

        root.addView(createTitle("📊 ANALYTICS"));
        root.addView(createSubtitle(
                "AVESON CENTRAL • SYSTEM ANALYTICS"
        ));

        // --------------------------------------------------------
        // AVESON ARTIST
        // --------------------------------------------------------

        root.addView(createAnalyticsRoomCard(
                "🎵",
                "AVESON ARTIST",
                "Artist registration and activity analytics",
                new String[]{
                        "👤  Total Artists",
                        "🆕  Registered Artists",
                        "✅  Active Artists",
                        "⏳  Inactive Artists",
                        "📤  Song Submissions",
                        "📹  Video Submissions"
                }
        ));

        // --------------------------------------------------------
        // AVESON MUSIC
        // --------------------------------------------------------

        root.addView(createAnalyticsRoomCard(
                "🎼",
                "AVESON MUSIC",
                "Music users, catalog and listening analytics",
                new String[]{
                        "👥  Total Users",
                        "🆕  Registered Users",
                        "✅  Active Users",
                        "🎵  Total Tracks",
                        "💿  Total Albums",
                        "▶️  Total Streams"
                }
        ));

        // --------------------------------------------------------
        // AVESON DISTRIBUTION
        // --------------------------------------------------------

        root.addView(createAnalyticsRoomCard(
                "🌍",
                "AVESON DISTRIBUTION",
                "Distribution users and release analytics",
                new String[]{
                        "👥  Total Users",
                        "🆕  Registered Users",
                        "📦  Total Releases",
                        "🌐  Connected Platforms",
                        "📤  Delivered Releases",
                        "⏳  Pending Releases"
                }
        ));

        // --------------------------------------------------------
        // AVESON STUDIO
        // --------------------------------------------------------

        root.addView(createAnalyticsRoomCard(
                "🎙️",
                "AVESON STUDIO",
                "Studio users and production analytics",
                new String[]{
                        "👥  Total Users",
                        "🆕  Registered Users",
                        "✅  Active Users",
                        "🎙️  Studio Projects",
                        "🎵  Audio Projects",
                        "📁  Studio Files"
                }
        ));

        // --------------------------------------------------------
        // AVESON MAGAZINE
        // --------------------------------------------------------

        root.addView(createAnalyticsRoomCard(
                "📰",
                "AVESON MAGAZINE",
                "Magazine users and content analytics",
                new String[]{
                        "👥  Total Users",
                        "🆕  Registered Users",
                        "✍️  Total Articles",
                        "👁️  Total Views",
                        "👤  Writers",
                        "📰  Published Articles"
                }
        ));

        // --------------------------------------------------------
        // AVESON FILMS
        // --------------------------------------------------------

        root.addView(createAnalyticsRoomCard(
                "🎬",
                "AVESON FILMS",
                "Film users and production analytics",
                new String[]{
                        "👥  Total Users",
                        "🆕  Registered Users",
                        "✅  Active Users",
                        "🎬  Total Projects",
                        "🎥  Total Films",
                        "👁️  Total Views"
                }
        ));

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // ============================================================
    // ANALYTICS ROOM CARD
    // ============================================================

    private LinearLayout createAnalyticsRoomCard(
            String icon,
            String roomName,
            String description,
            String[] statistics
    ) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);

        GradientDrawable background = new GradientDrawable();
        background.setColor(CARD);
        background.setCornerRadius(dp(18));
        background.setStroke(dp(1), Color.rgb(70, 45, 110));

        card.setBackground(background);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(
                dp(4),
                dp(8),
                dp(4),
                dp(8)
        );

        card.setLayoutParams(cardParams);

        card.setPadding(
                dp(18),
                dp(18),
                dp(18),
                dp(18)
        );

        TextView title = new TextView(this);
        title.setText(icon + "  " + roomName);
        title.setTextColor(Color.WHITE);
        title.setTextSize(20);
        title.setTypeface(null, Typeface.BOLD);

        card.addView(title);

        TextView desc = new TextView(this);
        desc.setText(description);
        desc.setTextColor(TEXT_GRAY);
        desc.setTextSize(13);

        LinearLayout.LayoutParams descParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        descParams.setMargins(
                0,
                dp(6),
                0,
                dp(14)
        );

        desc.setLayoutParams(descParams);

        card.addView(desc);

        for (String stat : statistics) {

            LinearLayout statRow = new LinearLayout(this);
            statRow.setOrientation(LinearLayout.HORIZONTAL);
            statRow.setGravity(Gravity.CENTER_VERTICAL);

            GradientDrawable statBackground = new GradientDrawable();
            statBackground.setColor(Color.rgb(10, 10, 22));
            statBackground.setCornerRadius(dp(12));
            statBackground.setStroke(
                    dp(1),
                    Color.rgb(45, 35, 70)
            );

            statRow.setBackground(statBackground);

            LinearLayout.LayoutParams rowParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            dp(52)
                    );

            rowParams.setMargins(
                    0,
                    dp(4),
                    0,
                    dp(4)
            );

            statRow.setLayoutParams(rowParams);

            TextView statName = new TextView(this);
            statName.setText(stat);
            statName.setTextColor(Color.WHITE);
            statName.setTextSize(14);

            LinearLayout.LayoutParams nameParams =
                    new LinearLayout.LayoutParams(
                            0,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                    );

            statName.setLayoutParams(nameParams);

            statRow.addView(statName);

            TextView value = new TextView(this);
            value.setText("0");
            value.setTextColor(PURPLE);
            value.setTextSize(17);
            value.setTypeface(null, Typeface.BOLD);
            value.setGravity(Gravity.CENTER);

            statRow.addView(value);

            card.addView(statRow);
        }

        return card;
    }

    // ============================================================
    // ROYALTY CONTROL
    // ============================================================

    private void showRoyaltyControl() {

        showMenuSection(
                "💰 ROYALTY CONTROL",
                "REVENUE & ROYALTY MANAGEMENT",
                new String[]{
                        "💵  Total Revenue",
                        "🎵  Music Revenue",
                        "🌍  Distribution Revenue",
                        "🎬  Films Revenue",
                        "🎙️  Studio Revenue",
                        "📰  Magazine Revenue",
                        "💳  Payments",
                        "👤  Artist Earnings",
                        "🌍  Distribution Earnings",
                        "📄  Royalty Reports",
                        "📈  Revenue Growth",
                        "💼  Revenue Sources"
                }
        );
    }

    // ============================================================
    // SECURITY
    // ============================================================

    private void showSecurity() {

        showMenuSection(
                "🔐 SECURITY",
                "AVESON CENTRAL SECURITY",
                new String[]{
                        "🔑  Access Control",
                        "📱  Authorized Devices",
                        "📋  Login Activity",
                        "🛡️  Security Protection",
                        "⚠️  Security Events"
                }
        );
    }

    // ============================================================
    // PARAMETERS
    // ============================================================

    private void showParameters() {

        showMenuSection(
                "⚙️ PARAMETERS",
                "AVESON CENTRAL PARAMETERS",
                new String[]{
                        "🌐  Languages",
                        "🎨  Appearance",
                        "🔔  Notifications",
                        "🎵  Music Parameters",
                        "🌍  Distribution Parameters"
                }
        );
    }

    // ============================================================
    // SYSTEM STATUS
    // ============================================================

    private void showSystemStatus() {

        showMenuSection(
                "🛡️ SYSTEM STATUS",
                "AVESON CENTRAL SYSTEM STATUS",
                new String[]{
                        "🖥️  Central System",
                        "🗄️  Database",
                        "🔌  API Services",
                        "🌍  Distribution Services",
                        "💾  Storage",
                        "🔐  Security Services"
                }
        );
    }

    // ============================================================
    // CENTRAL INFO
    // ============================================================

    private void showCentralInfo() {

        showMenuSection(
                "ℹ️ AVESON CENTRAL INFO",
                "SYSTEM INFORMATION",
                new String[]{
                        "System Name: AVESON CENTRAL",
                        "System Type: Global Management & Control Platform",
                        "Platform: AVESON Global Music Ecosystem",
                        "Version: 1.0",
                        "Status: ACTIVE"
                }
        );
    }

    // ============================================================
    // GENERIC MENU SECTION
    // ============================================================

    private void showMenuSection(
            String title,
            String subtitle,
            String[] items
    ) {

        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showMenu());
        root.addView(back);

        root.addView(createTitle(title));
        root.addView(createSubtitle(subtitle));

        for (String item : items) {

            TextView button = createMenuButton(
                    item,
                    "",
                    v -> showMessage(item)
            );

            root.addView(button);
        }

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // ============================================================
    // ROOM CONTROL
    // ============================================================

    private void openRoom(String roomName) {

        ScrollView scrollView = createScrollView();
        LinearLayout root = createRoot();

        TextView back = createButton("←  BACK");
        back.setOnClickListener(v -> showCentralHome());
        root.addView(back);

        root.addView(createTitle(roomName));
        root.addView(createSubtitle(
                "ROOM MANAGEMENT & CONTROL"
        ));

        if (roomName.equals("AVESON ARTIST CONTROL")) {

            addRoomMenu(root,
                    "👤  Artists",
                    "📤  Artist Submissions",
                    "🔎  Release Review",
                    "📊  Artist Analytics",
                    "⚙️  Artist Settings"
            );

        } else if (roomName.equals("AVESON MUSIC CONTROL")) {

            addRoomMenu(root,
                    "🎵  Music Catalog",
                    "💿  Albums & Releases",
                    "▶️  Playlists",
                    "👥  Music Users",
                    "📊  Music Analytics",
                    "⚙️  Music Settings"
            );

        } else if (roomName.equals("AVESON DISTRIBUTION CONTROL")) {

            addRoomMenu(root,
                    "🌍  Distribution Platforms",
                    "📦  Distribution Releases",
                    "📤  Release Delivery",
                    "📊  Distribution Analytics",
                    "⚙️  Distribution Settings"
            );

        } else if (roomName.equals("AVESON STUDIO CONTROL")) {

            addRoomMenu(root,
                    "🎙️  Studio Projects",
                    "🎵  Audio Production",
                    "🎚️  Sessions",
                    "📁  Studio Files",
                    "📊  Studio Analytics",
                    "⚙️  Studio Settings"
            );

        } else if (roomName.equals("AVESON MAGAZINE CONTROL")) {

            addRoomMenu(root,
                    "📰  Articles",
                    "✍️  Editorial",
                    "🖼️  Media",
                    "👤  Writers",
                    "📊  Magazine Analytics",
                    "⚙️  Magazine Settings"
            );

        } else if (roomName.equals("AVESON FILMS")) {

            addRoomMenu(root,
                    "🎬  Projects",
                    "🎥  Videos",
                    "🎞️  Productions",
                    "📁  Film Library",
                    "📊  Film Analytics",
                    "⚙️  Film Settings"
            );
        }

        scrollView.addView(root);
        setContentView(scrollView);
    }

    // ============================================================
    // ROOM MENU
    // ============================================================

    private void addRoomMenu(
            LinearLayout root,
            String... items
    ) {

        for (String item : items) {

            TextView button = createMenuButton(
                    item,
                    "",
                    v -> showMessage(item)
            );

            root.addView(button);
        }
    }

    // ============================================================
    // ROOM BUTTON
    // ============================================================

    private TextView createRoomButton(
            String icon,
            String title,
            String description,
            View.OnClickListener listener
    ) {

        TextView button = new TextView(this);

        button.setText(
                icon + "  " + title +
                        "\n\n" +
                        description
        );

        button.setTextColor(Color.WHITE);
        button.setTextSize(16);
        button.setTypeface(null, Typeface.BOLD);
        button.setGravity(Gravity.CENTER_VERTICAL);
        button.setPadding(
                dp(20),
                dp(16),
                dp(20),
                dp(16)
        );

        GradientDrawable background = new GradientDrawable();
        background.setColor(CARD);
        background.setCornerRadius(dp(18));
        background.setStroke(
                dp(1),
                Color.rgb(65, 45, 100)
        );

        button.setBackground(background);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(105)
                );

        params.setMargins(
                dp(4),
                dp(7),
                dp(4),
                dp(7)
        );

        button.setLayoutParams(params);

        return button;
    }

    // ============================================================
    // MENU BUTTON
    // ============================================================

    private TextView createMenuButton(
            String text,
            String description,
            View.OnClickListener listener
    ) {

        TextView button = new TextView(this);

        if (description == null || description.isEmpty()) {
            button.setText(text);
        } else {
            button.setText(
                    text + "\n\n" + description
            );
        }

        button.setTextColor(Color.WHITE);
        button.setTextSize(16);
        button.setGravity(Gravity.CENTER_VERTICAL);
        button.setPadding(
                dp(18),
                dp(14),
                dp(18),
                dp(14)
        );

        GradientDrawable background = new GradientDrawable();
        background.setColor(CARD);
        background.setCornerRadius(dp(16));
        background.setStroke(
                dp(1),
                Color.rgb(60, 45, 90)
        );

        button.setBackground(background);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        description == null || description.isEmpty()
                                ? dp(58)
                                : dp(82)
                );

        params.setMargins(
                dp(4),
                dp(6),
                dp(4),
                dp(6)
        );

        button.setLayoutParams(params);

        return button;
    }

    // ============================================================
    // BACK BUTTON
    // ============================================================

    private TextView createButton(String text) {

        TextView button = new TextView(this);

        button.setText(text);
        button.setTextColor(Color.WHITE);
        button.setTextSize(15);
        button.setGravity(Gravity.CENTER);
        button.setTypeface(null, Typeface.BOLD);

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.rgb(25, 18, 40));
        background.setCornerRadius(dp(14));
        background.setStroke(
                dp(1),
                PURPLE
        );

        button.setBackground(background);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
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

    // ============================================================
    // TITLE
    // ============================================================

    private TextView createTitle(String text) {

        TextView title = new TextView(this);

        title.setText(text);
        title.setTextColor(Color.WHITE);
        title.setTextSize(25);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(10),
                0,
                dp(5)
        );

        title.setLayoutParams(params);

        return title;
    }

    // ============================================================
    // SUBTITLE
    // ============================================================

    private TextView createSubtitle(String text) {

        TextView subtitle = new TextView(this);

        subtitle.setText(text);
        subtitle.setTextColor(TEXT_GRAY);
        subtitle.setTextSize(12);
        subtitle.setGravity(Gravity.CENTER);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
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

    // ============================================================
    // ROOT
    // ============================================================

    private LinearLayout createRoot() {

        LinearLayout root = new LinearLayout(this);

        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(
                dp(16),
                dp(24),
                dp(16),
                dp(36)
        );

        root.setBackgroundColor(DARK);

        return root;
    }

    // ============================================================
    // SCROLL VIEW
    // ============================================================

    private ScrollView createScrollView() {

        ScrollView scrollView = new ScrollView(this);

        scrollView.setBackgroundColor(DARK);
        scrollView.setFillViewport(true);
        scrollView.setClipToPadding(false);

        scrollView.setPadding(
                0,
                0,
                0,
                dp(20)
        );

        return scrollView;
    }

    // ============================================================
    // MESSAGE
    // ============================================================

    private void showMessage(String message) {

        Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
        ).show();
    }

    // ============================================================
    // DP
    // ============================================================

    private int dp(int value) {

        return (int) (
                value *
                        getResources()
                                .getDisplayMetrics()
                                .density
        );
    }
}
