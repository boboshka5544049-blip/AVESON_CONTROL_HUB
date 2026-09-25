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

    private static final int PURPLE = Color.rgb(185, 100, 255);
    private static final int BLUE = Color.rgb(80, 150, 255);
    private static final int DARK = Color.rgb(8, 8, 18);
    private static final int CARD = Color.rgb(15, 15, 30);
    private static final int TEXT = Color.WHITE;
    private static final int TEXT_GRAY = Color.rgb(165, 165, 185);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showCentralHome();
    }

    // ============================================================
    // HELPERS
    // ============================================================

    private int dp(float value) {
        return (int) (value *
                getResources().getDisplayMetrics().density + 0.5f);
    }

    private LinearLayout createRoot() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setPadding(
                dp(12),
                dp(24),
                dp(12),
                dp(36)
        );

        layout.setBackgroundColor(DARK);

        return layout;
    }

    private void setScreen(LinearLayout content) {

        ScrollView scrollView = new ScrollView(this);

        scrollView.setFillViewport(true);
        scrollView.setClipToPadding(false);

        scrollView.setPadding(
                0,
                0,
                0,
                dp(24)
        );

        scrollView.addView(content);

        setContentView(scrollView);
    }

    private TextView createTitle(String text) {

        TextView title = new TextView(this);

        title.setText(text);
        title.setTextColor(TEXT);
        title.setTextSize(25);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, android.graphics.Typeface.BOLD);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                dp(12),
                dp(10),
                dp(12),
                dp(8)
        );

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

        params.setMargins(
                dp(16),
                0,
                dp(16),
                dp(16)
        );

        subtitle.setLayoutParams(params);

        return subtitle;
    }

    private Button createButton(String text) {

        Button button = new Button(this);

        button.setText(text);
        button.setTextColor(TEXT);
        button.setTextSize(15);
        button.setAllCaps(false);
        button.setGravity(Gravity.CENTER);

        button.setPadding(
                dp(10),
                0,
                dp(10),
                0
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(18));
        background.setStroke(dp(1), PURPLE);

        button.setBackground(background);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(52)
                );

        params.setMargins(
                dp(12),
                dp(6),
                dp(12),
                dp(6)
        );

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
            final View.OnClickListener listener
    ) {

        Button back = createButton("←  BACK");

        LinearLayout.LayoutParams params =
                (LinearLayout.LayoutParams) back.getLayoutParams();

        params.height = dp(44);

        params.setMargins(
                dp(12),
                dp(12),
                dp(12),
                dp(8)
        );

        back.setLayoutParams(params);

        back.setOnClickListener(listener);

        layout.addView(back);
    }

    private LinearLayout createCard() {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);

        card.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(8)
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(18));
        background.setStroke(
                dp(1),
                Color.rgb(65, 45, 95)
        );

        card.setBackground(background);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                dp(8),
                dp(8),
                dp(8),
                dp(8)
        );

        card.setLayoutParams(params);

        return card;
    }

    // ============================================================
    // CENTRAL HOME
    // ============================================================

    private void showCentralHome() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("AVESON CENTRAL")
        );

        layout.addView(
                createSubtitle(
                        "Global Management & Control Platform"
                )
        );

        addButton(
                layout,
                "☰  MENU",
                v -> showGlobalMenu()
        );

        addButton(
                layout,
                "🎵  AVESON ARTIST CONTROL",
                v -> openRoom("AVESON ARTIST CONTROL")
        );

        addButton(
                layout,
                "🎼  AVESON MUSIC CONTROL",
                v -> openRoom("AVESON MUSIC CONTROL")
        );

        addButton(
                layout,
                "🌍  AVESON DISTRIBUTION CONTROL",
                v -> openRoom("AVESON DISTRIBUTION CONTROL")
        );

        addButton(
                layout,
                "🎙️  AVESON STUDIO CONTROL",
                v -> openRoom("AVESON STUDIO CONTROL")
        );

        addButton(
                layout,
                "📰  AVESON MAGAZINE CONTROL",
                v -> openRoom("AVESON MAGAZINE CONTROL")
        );

        addButton(
                layout,
                "🎬  AVESON FILMS",
                v -> openRoom("AVESON FILMS")
        );

        setScreen(layout);
    }

    // ============================================================
    // GLOBAL MENU
    // ============================================================

    private void showGlobalMenu() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("☰ MENU"));

        layout.addView(
                createSubtitle(
                        "AVESON CENTRAL Management"
                )
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

    // ============================================================
    // ANALYTICS
    // ============================================================

    private void showAnalytics() {

        LinearLayout layout = createRoot();

        layout.addView(createTitle("📊 ANALYTICS"));

        layout.addView(
                createSubtitle(
                        "AVESON Central Analytics"
                )
        );

        addAnalyticsCard(
                layout,
                "🎵 AVESON ARTIST",
                new String[]{
                        "Total Artists: 0",
                        "Registered Artists: 0",
                        "Active Artists: 0",
                        "Inactive Artists: 0",
                        "Song Submissions: 0",
                        "Video Submissions: 0"
                }
        );

        addAnalyticsCard(
                layout,
                "🎼 AVESON MUSIC",
                new String[]{
                        "Total Users: 0",
                        "Registered Users: 0",
                        "Active Users: 0",
                        "Total Tracks: 0",
                        "Total Albums: 0",
                        "Total Streams: 0"
                }
        );

        addAnalyticsCard(
                layout,
                "🌍 AVESON DISTRIBUTION",
                new String[]{
                        "Total Users: 0",
                        "Registered Users: 0",
                        "Total Releases: 0",
                        "Connected Platforms: 0",
                        "Delivered Releases: 0",
                        "Pending Releases: 0"
                }
        );

        addAnalyticsCard(
                layout,
                "🎙️ AVESON STUDIO",
                new String[]{
                        "Total Users: 0",
                        "Registered Users: 0",
                        "Active Users: 0",
                        "Studio Projects: 0",
                        "Audio Projects: 0",
                        "Studio Files: 0"
                }
        );

        addAnalyticsCard(
                layout,
                "📰 AVESON MAGAZINE",
                new String[]{
                        "Total Users: 0",
                        "Registered Users: 0",
                        "Total Articles: 0",
                        "Total Views: 0",
                        "Writers: 0",
                        "Published Articles: 0"
                }
        );

        addAnalyticsCard(
                layout,
                "🎬 AVESON FILMS",
                new String[]{
                        "Total Users: 0",
                        "Registered Users: 0",
                        "Active Users: 0",
                        "Total Projects: 0",
                        "Total Films: 0",
                        "Total Views: 0"
                }
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    private void addAnalyticsCard(
            LinearLayout parent,
            String title,
            String[] items
    ) {

        LinearLayout card = createCard();

        TextView titleView = new TextView(this);

        titleView.setText(title);
        titleView.setTextColor(PURPLE);
        titleView.setTextSize(18);
        titleView.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );

        titleView.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(10)
        );

        card.addView(titleView);

        for (String item : items) {

            TextView value = new TextView(this);

            value.setText(item);
            value.setTextColor(TEXT_GRAY);
            value.setTextSize(14);

            value.setPadding(
                    dp(8),
                    dp(4),
                    dp(8),
                    dp(4)
            );

            card.addView(value);
        }

        parent.addView(card);
    }

    // ============================================================
    // ROYALTY CONTROL
    // ============================================================

    private void showRoyaltyControl() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("💰 ROYALTY CONTROL")
        );

        layout.addView(
                createSubtitle(
                        "Revenue & Royalty Management"
                )
        );

        addRoyaltyCard(
                layout,
                "💵 TOTAL REVENUE",
                "Total Revenue: $0.00",
                "Current Month Revenue: $0.00",
                "Previous Month Revenue: $0.00",
                "Revenue Growth: 0%"
        );

        addRoyaltyCard(
                layout,
                "🎵 MUSIC REVENUE",
                "Music Revenue: $0.00",
                "Streaming Revenue: $0.00",
                "Download Revenue: $0.00",
                "Other Music Revenue: $0.00"
        );

        addRoyaltyCard(
                layout,
                "🌍 DISTRIBUTION REVENUE",
                "Distribution Revenue: $0.00",
                "Platform Revenue: $0.00",
                "Distribution Fees: $0.00",
                "Other Distribution Revenue: $0.00"
        );

        addRoyaltyCard(
                layout,
                "🎬 FILMS REVENUE",
                "Films Revenue: $0.00",
                "Streaming Revenue: $0.00",
                "Licensing Revenue: $0.00",
                "Other Film Revenue: $0.00"
        );

        addRoyaltyCard(
                layout,
                "🎙️ STUDIO REVENUE",
                "Studio Revenue: $0.00",
                "Recording Revenue: $0.00",
                "Production Revenue: $0.00",
                "Mixing / Mastering Revenue: $0.00"
        );

        addRoyaltyCard(
                layout,
                "📰 MAGAZINE REVENUE",
                "Magazine Revenue: $0.00",
                "Advertising Revenue: $0.00",
                "Subscription Revenue: $0.00",
                "Other Magazine Revenue: $0.00"
        );

        addRoyaltyCard(
                layout,
                "💳 PAYMENTS",
                "Completed Payments: 0",
                "Pending Payments: 0",
                "Failed Payments: 0",
                "Payment History: 0"
        );

        addRoyaltyCard(
                layout,
                "👤 ARTIST EARNINGS",
                "Total Artist Earnings: $0.00",
                "Pending Artist Earnings: $0.00",
                "Paid Artist Earnings: $0.00",
                "Artist Royalty Reports: 0"
        );

        addRoyaltyCard(
                layout,
                "🌍 DISTRIBUTION EARNINGS",
                "Total Distribution Earnings: $0.00",
                "Pending Earnings: $0.00",
                "Paid Earnings: $0.00",
                "Distribution Reports: 0"
        );

        addRoyaltyCard(
                layout,
                "📄 ROYALTY REPORTS",
                "Monthly Reports: 0",
                "Artist Reports: 0",
                "Distribution Reports: 0",
                "Revenue Reports: 0"
        );

        addRoyaltyCard(
                layout,
                "📈 REVENUE GROWTH",
                "Monthly Growth: 0%",
                "Yearly Growth: 0%",
                "Revenue Trends: 0"
        );

        addRoyaltyCard(
                layout,
                "💼 REVENUE SOURCES",
                "Music: $0.00",
                "Distribution: $0.00",
                "Films: $0.00",
                "Studio: $0.00",
                "Magazine: $0.00"
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    private void addRoyaltyCard(
            LinearLayout parent,
            String title,
            String... items
    ) {

        LinearLayout card = createCard();

        TextView titleView = new TextView(this);

        titleView.setText(title);
        titleView.setTextColor(PURPLE);
        titleView.setTextSize(18);
        titleView.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );

        titleView.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(10)
        );

        card.addView(titleView);

        for (String item : items) {

            TextView text = new TextView(this);

            text.setText(item);
            text.setTextColor(TEXT_GRAY);
            text.setTextSize(14);

            text.setPadding(
                    dp(8),
                    dp(4),
                    dp(8),
                    dp(4)
            );

            card.addView(text);
        }

        parent.addView(card);
    }

    // ============================================================
    // SECURITY
    // ============================================================

    private void showSecurity() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🔐 SECURITY")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central Security Management"
                )
        );

        addButton(
                layout,
                "👤  ACCESS CONTROL",
                v -> showAccessControl()
        );

        addButton(
                layout,
                "📱  AUTHORIZED DEVICES",
                v -> showSecuritySubSection(
                        "📱 AUTHORIZED DEVICES",
                        new String[]{
                                "Authorized Devices",
                                "Active Devices",
                                "Device Management",
                                "Add Device",
                                "Remove Device",
                                "Device History",
                                "Blocked Devices"
                        }
                )
        );

        addButton(
                layout,
                "📋  LOGIN & ACCESS ACTIVITY",
                v -> showSecuritySubSection(
                        "📋 LOGIN & ACCESS ACTIVITY",
                        new String[]{
                                "Login Activity",
                                "Successful Logins",
                                "Failed Login Attempts",
                                "Active Sessions",
                                "Session History",
                                "Logout Activity",
                                "Access History"
                        }
                )
        );

        addButton(
                layout,
                "🛡️  SECURITY PROTECTION",
                v -> showSecuritySubSection(
                        "🛡️ SECURITY PROTECTION",
                        new String[]{
                                "Account Protection",
                                "Session Protection",
                                "Device Protection",
                                "API Protection",
                                "Data Protection",
                                "Encryption Status",
                                "Security Configuration"
                        }
                )
        );

        addButton(
                layout,
                "🚨  SECURITY EVENTS",
                v -> showSecuritySubSection(
                        "🚨 SECURITY EVENTS",
                        new String[]{
                                "Security Events",
                                "Suspicious Activity",
                                "Access Violations",
                                "Blocked Attempts",
                                "Security Alerts",
                                "Critical Events",
                                "Event History"
                        }
                )
        );

        addButton(
                layout,
                "🔒  PASSWORD & AUTHENTICATION",
                v -> showSecuritySubSection(
                        "🔒 PASSWORD & AUTHENTICATION",
                        new String[]{
                                "Password Management",
                                "Authentication Settings",
                                "Two-Factor Authentication",
                                "Recovery Settings",
                                "Authentication History",
                                "Password History",
                                "Recovery Activity"
                        }
                )
        );

        addButton(
                layout,
                "🌐  NETWORK & API SECURITY",
                v -> showSecuritySubSection(
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
                        }
                )
        );

        addButton(
                layout,
                "📋  SECURITY LOGS",
                v -> showSecuritySubSection(
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
                        }
                )
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // ============================================================
    // ACCESS CONTROL
    // ============================================================

    private void showAccessControl() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("👤 ACCESS CONTROL")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central Access Management"
                )
        );

        addAccessButton(
                layout,
                "👑  Administrator Access"
        );

        addAccessButton(
                layout,
                "👥  Staff Access"
        );

        addAccessButton(
                layout,
                "🎵  Artist Control Access"
        );

        addAccessButton(
                layout,
                "🎼  Music Control Access"
        );

        addAccessButton(
                layout,
                "🌍  Distribution Control Access"
        );

        addAccessButton(
                layout,
                "🎙️  Studio Control Access"
        );

        addAccessButton(
                layout,
                "📰  Magazine Control Access"
        );

        addAccessButton(
                layout,
                "🎬  Films Control Access"
        );

        addAccessButton(
                layout,
                "🛡️  Permission Management"
        );

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    private void addAccessButton(
            LinearLayout layout,
            String text
    ) {

        addButton(
                layout,
                text,
                v -> {

                    String clean = text;

                    if (clean.contains("  ")) {
                        clean = clean.substring(
                                clean.indexOf("  ") + 2
                        );
                    }

                    showAccessSubSection(clean);
                }
        );
    }

    private void showAccessSubSection(
            String title
    ) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🛡️ " + title)
        );

        layout.addView(
                createSubtitle(
                        "Access Control Management"
                )
        );

        String[] items;

        if (title.contains("Administrator")) {

            items = new String[]{
                    "Administrator Accounts",
                    "Administrator Permissions",
                    "Administrator Sessions",
                    "Administrator Activity",
                    "Administrator Security"
            };

        } else if (title.contains("Staff")) {

            items = new String[]{
                    "Staff Accounts",
                    "Staff Permissions",
                    "Staff Sessions",
                    "Staff Activity",
                    "Staff Security"
            };

        } else if (title.contains("Artist")) {

            items = new String[]{
                    "Artist Control Access",
                    "Artist Permissions",
                    "Artist Sessions",
                    "Artist Activity",
                    "Artist Security"
            };

        } else if (title.contains("Music")) {

            items = new String[]{
                    "Music Control Access",
                    "Music Permissions",
                    "Music Sessions",
                    "Music Activity",
                    "Music Security"
            };

        } else if (title.contains("Distribution")) {

            items = new String[]{
                    "Distribution Control Access",
                    "Distribution Permissions",
                    "Distribution Sessions",
                    "Distribution Activity",
                    "Distribution Security"
            };

        } else if (title.contains("Studio")) {

            items = new String[]{
                    "Studio Control Access",
                    "Studio Permissions",
                    "Studio Sessions",
                    "Studio Activity",
                    "Studio Security"
            };

        } else if (title.contains("Magazine")) {

            items = new String[]{
                    "Magazine Control Access",
                    "Magazine Permissions",
                    "Magazine Sessions",
                    "Magazine Activity",
                    "Magazine Security"
            };

        } else if (title.contains("Films")) {

            items = new String[]{
                    "Films Control Access",
                    "Films Permissions",
                    "Films Sessions",
                    "Films Activity",
                    "Films Security"
            };

        } else {

            items = new String[]{
                    "Permission Groups",
                    "Permission Rules",
                    "Role Management",
                    "Access Policies",
                    "Permission History"
            };
        }

        for (String item : items) {

            final String selectedItem = item;

            addButton(
                    layout,
                    selectedItem,
                    v -> showMessage(selectedItem)
            );
        }

        addBackButton(
                layout,
                v -> showAccessControl()
        );

        setScreen(layout);
    }

    // ============================================================
    // SECURITY SUBSECTION
    // ============================================================

    private void showSecuritySubSection(
            String title,
            String[] items
    ) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle(title)
        );

        layout.addView(
                createSubtitle(
                        "Security Management"
                )
        );

        for (String item : items) {

            final String selectedItem = item;

            addButton(
                    layout,
                    selectedItem,
                    v -> showMessage(selectedItem)
            );
        }

        addBackButton(
                layout,
                v -> showSecurity()
        );

        setScreen(layout);
    }

    // ============================================================
    // PARAMETERS
    // ============================================================

    private void showParameters() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("⚙️ PARAMETERS")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central Parameters"
                )
        );

        addButton(
                layout,
                "🌐  Languages",
                v -> showMessage("Languages")
        );

        addButton(
                layout,
                "🎨  Appearance",
                v -> showMessage("Appearance")
        );

        addButton(
                layout,
                "🔔  Notifications",
                v -> showMessage("Notifications")
        );

        addButton(
                layout,
                "🎵  Music Parameters",
                v -> showMessage("Music Parameters")
        );

        addButton(
                layout,
                "🌍  Distribution Parameters",
                v -> showMessage(
                        "Distribution Parameters"
                )
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    // ============================================================
    // SYSTEM STATUS
    // ============================================================

    private void showSystemStatus() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("🛡️ SYSTEM STATUS")
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central System Status"
                )
        );

        addStatusCard(
                layout,
                "Central System",
                "ONLINE"
        );

        addStatusCard(
                layout,
                "Artist Control",
                "ONLINE"
        );

        addStatusCard(
                layout,
                "Music Control",
                "ONLINE"
        );

        addStatusCard(
                layout,
                "Distribution Control",
                "ONLINE"
        );

        addStatusCard(
                layout,
                "Studio Control",
                "ONLINE"
        );

        addStatusCard(
                layout,
                "Magazine Control",
                "ONLINE"
        );

        addStatusCard(
                layout,
                "Films Control",
                "ONLINE"
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    private void addStatusCard(
            LinearLayout parent,
            String title,
            String status
    ) {

        LinearLayout card = createCard();

        TextView titleView = new TextView(this);

        titleView.setText(title);
        titleView.setTextColor(PURPLE);
        titleView.setTextSize(17);
        titleView.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );

        titleView.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(4)
        );

        card.addView(titleView);

        TextView statusView = new TextView(this);

        statusView.setText("● " + status);
        statusView.setTextColor(BLUE);
        statusView.setTextSize(14);

        statusView.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(8)
        );

        card.addView(statusView);

        parent.addView(card);
    }

    // ============================================================
    // CENTRAL INFO
    // ============================================================

    private void showCentralInfo() {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle("ℹ️ AVESON CENTRAL")
        );

        layout.addView(
                createSubtitle(
                        "Global Management & Control Platform"
                )
        );

        addInfoCard(
                layout,
                "Platform",
                "AVESON CENTRAL"
        );

        addInfoCard(
                layout,
                "System",
                "Unified Central Management System"
        );

        addInfoCard(
                layout,
                "Artist",
                "AVESON ARTIST CONTROL"
        );

        addInfoCard(
                layout,
                "Music",
                "AVESON MUSIC CONTROL"
        );

        addInfoCard(
                layout,
                "Distribution",
                "AVESON DISTRIBUTION CONTROL"
        );

        addInfoCard(
                layout,
                "Studio",
                "AVESON STUDIO CONTROL"
        );

        addInfoCard(
                layout,
                "Magazine",
                "AVESON MAGAZINE CONTROL"
        );

        addInfoCard(
                layout,
                "Films",
                "AVESON FILMS"
        );

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }

    private void addInfoCard(
            LinearLayout parent,
            String title,
            String value
    ) {

        LinearLayout card = createCard();

        TextView titleView = new TextView(this);

        titleView.setText(title);
        titleView.setTextColor(PURPLE);
        titleView.setTextSize(16);
        titleView.setTypeface(
                null,
                android.graphics.Typeface.BOLD
        );

        titleView.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(4)
        );

        card.addView(titleView);

        TextView valueView = new TextView(this);

        valueView.setText(value);
        valueView.setTextColor(TEXT_GRAY);
        valueView.setTextSize(14);

        valueView.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(8)
        );

        card.addView(valueView);

        parent.addView(card);
    }

    // ============================================================
    // ROOMS
    // ============================================================

    private void openRoom(String room) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle(room)
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central Room Control"
                )
        );

        if (room.equals("AVESON ARTIST CONTROL")) {

            addRoomButton(layout, "Artists");
            addRoomButton(layout, "Artist Submissions");
            addRoomButton(layout, "Release Review");
            addRoomButton(layout, "Artist Analytics");
            addRoomButton(layout, "Artist Settings");

        } else if (room.equals("AVESON MUSIC CONTROL")) {

            addRoomButton(layout, "Music Catalog");
            addRoomButton(layout, "Albums & Releases");
            addRoomButton(layout, "Playlists");
            addRoomButton(layout, "Music Users");
            addRoomButton(layout, "Music Analytics");
            addRoomButton(layout, "Music Settings");

        } else if (room.equals(
                "AVESON DISTRIBUTION CONTROL")) {

            addRoomButton(
                    layout,
                    "Distribution Platforms"
            );

            addRoomButton(
                    layout,
                    "Distribution Releases"
            );

            addRoomButton(
                    layout,
                    "Release Delivery"
            );

            addRoomButton(
                    layout,
                    "Distribution Analytics"
            );

            addRoomButton(
                    layout,
                    "Distribution Settings"
            );

        } else if (room.equals(
                "AVESON STUDIO CONTROL")) {

            addRoomButton(
                    layout,
                    "Studio Projects"
            );

            addRoomButton(
                    layout,
                    "Audio Production"
            );

            addRoomButton(
                    layout,
                    "Sessions"
            );

            addRoomButton(
                    layout,
                    "Studio Files"
            );

            addRoomButton(
                    layout,
                    "Studio Analytics"
            );

            addRoomButton(
                    layout,
                    "Studio Settings"
            );

        } else if (room.equals(
                "AVESON MAGAZINE CONTROL")) {

            addRoomButton(
                    layout,
                    "Articles"
            );

            addRoomButton(
                    layout,
                    "Editorial"
            );

            addRoomButton(
                    layout,
                    "Media"
            );

            addRoomButton(
                    layout,
                    "Writers"
            );

            addRoomButton(
                    layout,
                    "Magazine Analytics"
            );

            addRoomButton(
                    layout,
                    "Magazine Settings"
            );

        } else if (room.equals("AVESON FILMS")) {

            addRoomButton(
                    layout,
                    "Projects"
            );

            addRoomButton(
                    layout,
                    "Videos"
            );

            addRoomButton(
                    layout,
                    "Productions"
            );

            addRoomButton(
                    layout,
                    "Film Library"
            );

            addRoomButton(
                    layout,
                    "Film Analytics"
            );

            addRoomButton(
                    layout,
                    "Film Settings"
            );
        }

        addBackButton(
                layout,
                v -> showCentralHome()
        );

        setScreen(layout);
    }

    private void addRoomButton(
            LinearLayout layout,
            String text
    ) {

        final String selectedItem = text;

        addButton(
                layout,
                selectedItem,
                v -> showMessage(selectedItem)
        );
    }

    // ============================================================
    // MESSAGE
    // ============================================================

    private void showMessage(String message) {

        LinearLayout layout = createRoot();

        layout.addView(
                createTitle(message)
        );

        layout.addView(
                createSubtitle(
                        "AVESON Central"
                )
        );

        LinearLayout card = createCard();

        TextView info = new TextView(this);

        info.setText(
                message +
                "\n\nStatus: Ready\n\n" +
                "This section is prepared for " +
                "backend and database integration."
        );

        info.setTextColor(TEXT_GRAY);
        info.setTextSize(15);
        info.setGravity(Gravity.CENTER);

        info.setPadding(
                dp(12),
                dp(20),
                dp(12),
                dp(20)
        );

        card.addView(info);

        layout.addView(card);

        addBackButton(
                layout,
                v -> showGlobalMenu()
        );

        setScreen(layout);
    }
}
