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
        addStat(f
