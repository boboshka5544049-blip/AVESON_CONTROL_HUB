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

    private final int DARK = Color.rgb(8, 8, 18);
    private final int CARD = Color.rgb(15, 15, 30);
    private final int PURPLE = Color.rgb(185, 100, 255);
    private final int BLUE = Color.rgb(80, 150, 255);
    private final int TEXT = Color.WHITE;
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
        return (int) (
                value * getResources()
                        .getDisplayMetrics()
                        .density + 0.5f
        );
    }

    private LinearLayout createRoot() {

        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(
                LinearLayout.VERTICAL
        );

        layout.setPadding(
                dp(18),
                dp(24),
                dp(18),
                dp(30)
        );

        layout.setBackgroundColor(DARK);

        return layout;
    }

    private ScrollView createScroll(
            LinearLayout layout
    ) {

        ScrollView scroll = new ScrollView(this);

        scroll.setFillViewport(true);
        scroll.setClipToPadding(false);
        scroll.setBackgroundColor(DARK);

        scroll.addView(layout);

        return scroll;
    }

    private void setScreen(
            ScrollView scroll
    ) {
        setContentView(scroll);
    }

    // =========================================================
    // TITLE
    // =========================================================

    private TextView createTitle(
            String text
    ) {

        TextView title = new TextView(this);

        title.setText(text);
        title.setTextColor(TEXT);
        title.setTextSize(25);
        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setGravity(
                Gravity.CENTER
        );

        title.setPadding(
                dp(4),
                dp(4),
                dp(4),
                dp(8)
        );

        return title;
    }

    private TextView createSubtitle(
            String text
    ) {

        TextView subtitle = new TextView(this);

        subtitle.setText(text);
        subtitle.setTextColor(TEXT_GRAY);
        subtitle.setTextSize(14);

        subtitle.setGravity(
                Gravity.CENTER
        );

        subtitle.setPadding(
                dp(4),
                0,
                dp(4),
                dp(18)
        );

        return subtitle;
    }

    // =========================================================
    // BUTTON
    // =========================================================

    private Button createButton(
            String text
    ) {

        Button button = new Button(this);

        button.setText(text);
        button.setTextColor(TEXT);
        button.setTextSize(15);
        button.setAllCaps(false);

        button.setGravity(
                Gravity.CENTER
        );

        button.setMinHeight(0);
        button.setMinimumHeight(0);

        button.setPadding(
                dp(8),
                0,
                dp(8),
                0
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);

        background.setCornerRadius(
                dp(18)
        );

        background.setStroke(
                dp(1),
                PURPLE
        );

        button.setBackground(background);

        return button;
    }

    private void addButton(
            LinearLayout layout,
            String text,
            View.OnClickListener listener
    ) {

        Button button =
                createButton(text);

        button.setOnClickListener(
                listener
        );

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

        layout.addView(
                button,
                params
        );
    }

    private void addSectionButton(
            LinearLayout layout,
            String title,
            String description,
            View.OnClickListener listener
    ) {

        Button button =
                createButton(
                        title + "\n" + description
                );

        button.setGravity(
                Gravity.CENTER_VERTICAL |
                Gravity.LEFT
        );

        button.setTextSize(14);

        button.setOnClickListener(
                listener
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        dp(64)
                );

        params.setMargins(
                0,
                dp(5),
                0,
                dp(5)
        );

        layout.addView(
                button,
                params
        );
    }

    // =========================================================
    // CARD
    // =========================================================

    private LinearLayout createCard() {

        LinearLayout card =
                new LinearLayout(this);

        card.setOrientation(
                LinearLayout.VERTICAL
        );

        card.setPadding(
                dp(16),
                dp(16),
                dp(16),
                dp(16)
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);

        background.setCornerRadius(
                dp(18)
        );

        background.setStroke(
                dp(1),
                Color.rgb(70, 55, 120)
        );

        card.setBackground(
                background
        );

        return card;
    }

    private void addInfo(
            LinearLayout card,
            String label,
            String value
    ) {

        TextView info =
                new TextView(this);

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

    private void addInfoToLayout(
            LinearLayout layout,
            String label,
            String value
    ) {

        LinearLayout card =
                createCard();

        addInfo(
                card,
                label,
                value
        );

        layout.addView(card);
    }

    // =========================================================
    // AVESON CENTRAL HOME
    // =========================================================

    private void showCentralHome() {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "AVESON CENTRAL"
                )
        );

        layout.addView(
                createSubtitle(
                        "Global Management & Control Platform"
                )
        );

        addButton(
                layout,
                "☰ MENU",
                v -> showGlobalMenu()
        );

        addSectionButton(
                layout,
                "AVESON ARTIST CONTROL",
                "Artist Management & Release Control",
                v -> showArtistControl()
        );

        addSectionButton(
                layout,
                "AVESON MUSIC CONTROL",
                "Music Catalog & Content Control",
                v -> showMusicControl()
        );

        addSectionButton(
                layout,
                "AVESON DISTRIBUTION CONTROL",
                "Global Distribution & Platform Management",
                v -> showDistributionControl()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // GLOBAL MENU
    // =========================================================

    private void showGlobalMenu() {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "☰ AVESON CENTRAL MENU"
                )
        );

        layout.addView(
                createSubtitle(
                        "Global Central Management"
                )
        );

        addSectionButton(
                layout,
                "Analytics",
                "Global statistics and insights",
                v -> showSimplePage(
                        "ANALYTICS",
                        "Global statistics and insights"
                )
        );

        addSectionButton(
                layout,
                "Royalty Control",
                "Revenue, royalties and reports",
                v -> showSimplePage(
                        "ROYALTY CONTROL",
                        "Revenue and royalty management"
                )
        );

        addSectionButton(
                layout,
                "Security",
                "Access, protection and security",
                v -> showSimplePage(
                        "SECURITY",
                        "AVESON Central security management"
                )
        );

        addSectionButton(
                layout,
                "Parameters",
                "Global system parameters",
                v -> showSimplePage(
                        "PARAMETERS",
                        "Global system parameters"
                )
        );

        addButton(
                layout,
                "← BACK TO AVESON CENTRAL",
                v -> showCentralHome()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // ARTIST CONTROL
    // =========================================================

    private void showArtistControl() {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "AVESON ARTIST CONTROL"
                )
        );

        layout.addView(
                createSubtitle(
                        "Artist Management & Release Control"
                )
        );

        addSectionButton(
                layout,
                "ARTIST SUBMISSIONS",
                "Incoming artist releases",
                v -> showArtistSubmissions()
        );

        addSectionButton(
                layout,
                "RELEASE REVIEW",
                "Review submitted releases",
                v -> showReleaseReview()
        );

        addSectionButton(
                layout,
                "APPROVED RELEASES",
                "Accepted artist releases",
                v -> showSimplePage(
                        "APPROVED RELEASES",
                        "Approved artist releases"
                )
        );

        addSectionButton(
                layout,
                "REJECTED RELEASES",
                "Rejected artist releases",
                v -> showSimplePage(
                        "REJECTED RELEASES",
                        "Rejected artist releases"
                )
        );

        addButton(
                layout,
                "← BACK TO CENTRAL",
                v -> showCentralHome()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // ARTIST SUBMISSIONS
    // =========================================================

    private void showArtistSubmissions() {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "ARTIST SUBMISSIONS"
                )
        );

        layout.addView(
                createSubtitle(
                        "Incoming Artist Releases"
                )
        );

        addSectionButton(
                layout,
                "PENDING",
                "Releases waiting for review",
                v -> showReleaseReview()
        );

        addSectionButton(
                layout,
                "APPROVED",
                "Approved submissions",
                v -> showSimplePage(
                        "APPROVED",
                        "Approved submissions"
                )
        );

        addSectionButton(
                layout,
                "REJECTED",
                "Rejected submissions",
                v -> showSimplePage(
                        "REJECTED",
                        "Rejected submissions"
                )
        );

        addButton(
                layout,
                "← BACK",
                v -> showArtistControl()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // RELEASE REVIEW
    // =========================================================

    private void showReleaseReview() {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "RELEASE REVIEW"
                )
        );

        layout.addView(
                createSubtitle(
                        "Review submitted music releases"
                )
        );

        LinearLayout card =
                createCard();

        addInfo(
                card,
                "Release Status",
                "WAITING FOR REVIEW"
        );

        addInfo(
                card,
                "Audio Standard",
                "WAV PREFERRED"
        );

        addInfo(
                card,
                "Cover Standard",
                "3000 × 3000 OR LARGER"
        );

        layout.addView(card);

        addButton(
                layout,
                "APPROVE",
                v -> showMessage(
                        "Release approved"
                )
        );

        addButton(
                layout,
                "REJECT",
                v -> showMessage(
                        "Release rejected"
                )
        );

        addButton(
                layout,
                "REQUEST CHANGES",
                v -> showMessage(
                        "Changes requested"
                )
        );

        addButton(
                layout,
                "← BACK",
                v -> showArtistSubmissions()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // MUSIC CONTROL
    // =========================================================

    private void showMusicControl() {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "AVESON MUSIC CONTROL"
                )
        );

        layout.addView(
                createSubtitle(
                        "Music Catalog & Content Control"
                )
        );

        addSectionButton(
                layout,
                "TRACKS",
                "Manage music tracks",
                v -> showSimplePage(
                        "TRACKS",
                        "Music track management"
                )
        );

        addSectionButton(
                layout,
                "ALBUMS",
                "Manage albums and releases",
                v -> showSimplePage(
                        "ALBUMS",
                        "Album management"
                )
        );

        addSectionButton(
                layout,
                "GENRES",
                "Music genres",
                v -> showSimplePage(
                        "GENRES",
                        "Music genre management"
                )
        );

        addSectionButton(
                layout,
                "CATALOG",
                "Global AVESON music catalog",
                v -> showSimplePage(
                        "CATALOG",
                        "Global music catalog"
                )
        );

        addButton(
                layout,
                "← BACK TO CENTRAL",
                v -> showCentralHome()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // DISTRIBUTION CONTROL
    // =========================================================

    private void showDistributionControl() {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "AVESON DISTRIBUTION CONTROL"
                )
        );

        layout.addView(
                createSubtitle(
                        "Global Distribution & Platform Management"
                )
        );

        addSectionButton(
                layout,
                "SUBMISSIONS",
                "Distribution submissions",
                v -> showSimplePage(
                        "DISTRIBUTION SUBMISSIONS",
                        "Incoming distribution submissions"
                )
        );

        addSectionButton(
                layout,
                "PLATFORMS",
                "Distribution platforms",
                v -> showSimplePage(
                        "DISTRIBUTION PLATFORMS",
                        "Connected distribution platforms"
                )
        );

        addSectionButton(
                layout,
                "DELIVERIES",
                "Distribution deliveries",
                v -> showSimplePage(
                        "DELIVERIES",
                        "Release delivery status"
                )
        );

        addSectionButton(
                layout,
                "DISTRIBUTION STATUS",
                "Global delivery status",
                v -> showSimplePage(
                        "DISTRIBUTION STATUS",
                        "Global distribution status"
                )
        );

        addButton(
                layout,
                "← BACK TO CENTRAL",
                v -> showCentralHome()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // SIMPLE PAGE
    // =========================================================

    private void showSimplePage(
            String title,
            String description
    ) {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(title)
        );

        layout.addView(
                createSubtitle(description)
        );

        LinearLayout card =
                createCard();

        addInfo(
                card,
                "SYSTEM",
                "AVESON CENTRAL"
        );

        addInfo(
                card,
                "STATUS",
                "READY"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK",
                v -> showCentralHome()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // MESSAGE
    // =========================================================

    private void showMessage(
            String message
    ) {

        LinearLayout layout =
                createRoot();

        layout.addView(
                createTitle(
                        "AVESON CENTRAL"
                )
        );

        layout.addView(
                createSubtitle(message)
        );

        LinearLayout card =
                createCard();

        addInfo(
                card,
                "STATUS",
                "ACTION COMPLETED"
        );

        layout.addView(card);

        addButton(
                layout,
                "← BACK TO CENTRAL",
                v -> showCentralHome()
        );

        setScreen(
                createScroll(layout)
        );
    }

    // =========================================================
    // ANDROID BACK BUTTON
    // =========================================================

    @Override
    public void onBackPressed() {
        showCentralHome();
    }
                    }
