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

    private LinearLayout root;

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
    // AVESON CENTRAL
    // =========================================================

    private void showCentral() {

        ScrollView scrollView = createScrollView();

        root = createRoot();

        scrollView.addView(root);

        // =====================================================
        // MENU
        // =====================================================

        TextView menu = new TextView(this);
        menu.setText("☰  MENU");
        menu.setTextColor(Color.WHITE);
        menu.setTextSize(16);
        menu.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        menu.setGravity(Gravity.CENTER);
        menu.setPadding(18, 14, 18, 14);

        GradientDrawable menuBackground = new GradientDrawable();
        menuBackground.setColor(Color.rgb(20, 17, 38));
        menuBackground.setCornerRadius(35);
        menuBackground.setStroke(2, Color.rgb(80, 60, 150));
        menu.setBackground(menuBackground);

        LinearLayout.LayoutParams menuParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        menuParams.gravity = Gravity.CENTER_HORIZONTAL;
        menuParams.setMargins(0, 0, 0, 20);

        root.addView(menu, menuParams);

        menu.setOnClickListener(v ->
                showMessage("AVESON CENTRAL MENU")
        );

        // =====================================================
        // TITLE
        // =====================================================

        TextView title = new TextView(this);
        title.setText("AVESON CENTRAL");
        title.setTextColor(Color.WHITE);
        title.setTextSize(27);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        root.addView(title);

        // =====================================================
        // SUBTITLE
        // =====================================================

        TextView subtitle = new TextView(this);
        subtitle.setText(
                "CONTROL CENTER\n\nGLOBAL MUSIC ECOSYSTEM"
        );
        subtitle.setTextColor(Color.rgb(165, 155, 205));
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(8, 8, 8, 18);

        root.addView(subtitle);

        // =====================================================
        // CENTRAL ROOMS
        // =====================================================

        addRoom(
                "🎤",
                "AVESON ARTIST CONTROL",
                "Artistlar va release'larni boshqarish.",
                "ARTIST"
        );

        addRoom(
                "🎵",
                "AVESON MUSIC CONTROL",
                "Music katalog va music tizimini boshqarish.",
                "MUSIC"
        );

        addRoom(
                "🌐",
                "AVESON DISTRIBUTION CONTROL",
                "Release'larni global platformalarga tarqatish.",
                "DISTRIBUTION"
        );

        addRoom(
                "🎛️",
                "AVESON STUDIO CONTROL",
                "AVESON Studio xizmatlari va buyurtmalarini boshqarish.",
                "STUDIO"
        );

        addRoom(
                "📰",
                "AVESON MAGAZINE CONTROL",
                "Magazine va AVESON Shop boshqaruvi.",
                "MAGAZINE"
        );

        addRoom(
                "🎬",
                "AVESON FILMS",
                "Film, serial, klip va video kontent yo'nalishini boshqarish.",
                "FILMS"
        );

        setContentView(scrollView);
    }

    // =========================================================
    // SAFE SCROLL VIEW
    // =========================================================

    private ScrollView createScrollView() {

        ScrollView scrollView = new ScrollView(this);

        scrollView.setFillViewport(true);
        scrollView.setClipToPadding(false);
        scrollView.setBackgroundColor(BG);

        // Pastdagi telefon navigation tugmalari bilan
        // kontent to'qnashmasligi uchun xavfsiz joy.
        scrollView.setPadding(
                0,
                0,
                0,
                dp(36)
        );

        return scrollView;
    }

    // =========================================================
    // ROOT
    // =========================================================

    private LinearLayout createRoot() {

        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        // Yon tomondagi xona o'lchamlari saqlanadi.
        // Yuqorida ham keraksiz katta bo'shliq yo'q.
        layout.setPadding(
                dp(24),
                dp(24),
                dp(24),
                dp(24)
        );

        layout.setBackgroundColor(BG);

        return layout;
    }

    // =========================================================
    // CENTRAL ROOM CARD
    // =========================================================

    private void addRoom(
            String icon,
            String title,
            String description,
            String type
    ) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);

        // Xona kartalarining avvalgi o'lchami saqlanadi.
        card.setPadding(
                dp(24),
                dp(20),
                dp(24),
                dp(20)
        );

        GradientDrawable background = new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(28));
        background.setStroke(dp(2), BORDER);

        card.setBackground(background);

        // =====================================================
        // ICON
        // =====================================================

        TextView iconView = new TextView(this);

        iconView.setText(icon);
        iconView.setTextSize(27);

        card.addView(iconView);

        // =====================================================
        // ROOM NAME
        // =====================================================

        TextView name = new TextView(this);

        name.setText(title);
        name.setTextColor(Color.WHITE);
        name.setTextSize(18);
        name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        name.setPadding(0, dp(8), 0, dp(4));

        card.addView(name);

        // =====================================================
        // DESCRIPTION
        // =====================================================

        TextView desc = new TextView(this);

        desc.setText(description);
        desc.setTextColor(TEXT_SECONDARY);
        desc.setTextSize(13);

        card.addView(desc);

        // =====================================================
        // OPEN BUTTON
        // =====================================================

        TextView open = new TextView(this);

        open.setText("OPEN  →");
        open.setTextColor(Color.WHITE);
        open.setTextSize(15);
        open.setGravity(Gravity.CENTER);

        open.setPadding(
                dp(12),
                dp(14),
                dp(12),
                dp(14)
        );

        GradientDrawable openBackground =
                new GradientDrawable();

        openBackground.setColor(PURPLE);
        openBackground.setCornerRadius(dp(40));

        open.setBackground(openBackground);

        LinearLayout.LayoutParams openParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        openParams.setMargins(
                0,
                dp(16),
                0,
                0
        );

        card.addView(open, openParams);

        // =====================================================
        // CLICK
        // =====================================================

        card.setOnClickListener(v -> openRoom(type));

        open.setOnClickListener(v -> openRoom(type));

        // =====================================================
        // CARD POSITION
        // =====================================================

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(8),
                0,
                dp(12)
        );

        root.addView(card, params);
    }

    // =========================================================
    // ROOM OPENING
    // =========================================================

    private void openRoom(String type) {

        if (type.equals("ARTIST")) {
            showMessage("AVESON ARTIST CONTROL");
        }

        if (type.equals("MUSIC")) {
            showMusicControl();
        }

        if (type.equals("DISTRIBUTION")) {
            showMessage("AVESON DISTRIBUTION CONTROL");
        }

        if (type.equals("STUDIO")) {
            showRoom(
                    "🎛️",
                    "AVESON STUDIO CONTROL",
                    "Studio services • Orders • Bookings"
            );
        }

        if (type.equals("MAGAZINE")) {
            showRoom(
                    "📰",
                    "AVESON MAGAZINE CONTROL",
                    "Magazine • Media • AVESON Shop"
            );
        }

        if (type.equals("FILMS")) {
            showRoom(
                    "🎬",
                    "AVESON FILMS",
                    "Films • Series • Music Videos • Original Content"
            );
        }
    }

    // =========================================================
    // NEW ROOM PLACEHOLDER
    // =========================================================

    private void showRoom(
            String icon,
            String titleText,
            String subtitleText
    ) {

        ScrollView scrollView = createScrollView();

        root = createRoot();

        scrollView.addView(root);

        // =====================================================
        // BACK
        // =====================================================

        TextView back = new TextView(this);

        back.setText("← BACK TO AVESON CENTRAL");
        back.setTextColor(Color.rgb(120, 190, 255));
        back.setTextSize(16);
        back.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(18)
        );

        back.setOnClickListener(v -> showCentral());

        root.addView(back);

        // =====================================================
        // TITLE
        // =====================================================

        TextView title = new TextView(this);

        title.setText(icon + "  " + titleText);
        title.setTextColor(Color.WHITE);
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        title.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(6)
        );

        root.addView(title);

        // =====================================================
        // SUBTITLE
        // =====================================================

        TextView subtitle = new TextView(this);

        subtitle.setText(subtitleText);
        subtitle.setTextColor(Color.rgb(165, 155, 205));
        subtitle.setTextSize(14);

        subtitle.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(24)
        );

        root.addView(subtitle);

        // =====================================================
        // STATUS
        // =====================================================

        TextView status = new TextView(this);

        status.setText("CONTROL ROOM READY");
        status.setTextColor(Color.rgb(190, 170, 255));
        status.setTextSize(17);
        status.setGravity(Gravity.CENTER);

        status.setPadding(
                dp(20),
                dp(28),
                dp(20),
                dp(28)
        );

        GradientDrawable bg = new GradientDrawable();

        bg.setColor(CARD);
        bg.setCornerRadius(dp(24));
        bg.setStroke(dp(2), Color.rgb(80, 60, 150));

        status.setBackground(bg);

        root.addView(status);

        setContentView(scrollView);
    }

    // =========================================================
    // AVESON MUSIC CONTROL
    // =========================================================

    private void showMusicControl() {

        ScrollView scrollView = createScrollView();

        root = createRoot();

        scrollView.addView(root);

        // =====================================================
        // BACK
        // =====================================================

        TextView back = new TextView(this);

        back.setText("← BACK TO AVESON CENTRAL");
        back.setTextColor(Color.rgb(120, 190, 255));
        back.setTextSize(16);

        back.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(18)
        );

        back.setOnClickListener(v -> showCentral());

        root.addView(back);

        // =====================================================
        // TITLE
        // =====================================================

        TextView title = new TextView(this);

        title.setText("AVESON MUSIC CONTROL");
        title.setTextColor(Color.WHITE);
        title.setTextSize(27);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        title.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(4)
        );

        root.addView(title);

        // =====================================================
        // SUBTITLE
        // =====================================================

        TextView subtitle = new TextView(this);

        subtitle.setText(
                "Music catalog • Playlists • Content management"
        );

        subtitle.setTextColor(Color.rgb(165, 155, 205));
        subtitle.setTextSize(14);

        subtitle.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(24)
        );

        root.addView(subtitle);

        addMusicControlButton(
                "🎵  MUSIC CATALOG",
                "Tracks • Albums • Releases"
        );

        addMusicControlButton(
                "📀  ALBUMS & RELEASES",
                "Manage music releases"
        );

        addMusicControlButton(
                "🎧  PLAYLISTS",
                "Create and manage playlists"
        );

        addMusicControlButton(
                "👥  MUSIC USERS",
                "Listener accounts and activity"
        );

        addMusicControlButton(
                "📊  MUSIC ANALYTICS",
                "Streaming and usage data"
        );

        addMusicControlButton(
                "⚙️  MUSIC SETTINGS",
                "Music platform settings"
        );

        setContentView(scrollView);
    }

    // =========================================================
    // MUSIC CONTROL BUTTON
    // =========================================================

    private void addMusicControlButton(
            String title,
            String description
    ) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(LinearLayout.VERTICAL);

        card.setPadding(
                dp(22),
                dp(18),
                dp(22),
                dp(18)
        );

        GradientDrawable background = new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(24));
        background.setStroke(dp(2), Color.rgb(80, 60, 150));

        card.setBackground(background);

        TextView name = new TextView(this);

        name.setText(title);
        name.setTextColor(Color.WHITE);
        name.setTextSize(17);
        name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        card.addView(name);

        TextView desc = new TextView(this);

        desc.setText(description);
        desc.setTextColor(TEXT_SECONDARY);
        desc.setTextSize(13);

        desc.setPadding(
                0,
                dp(6),
                0,
                0
        );

        card.addView(desc);

        card.setOnClickListener(v ->
                showMessage(title)
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(6),
                0,
                dp(8)
        );

        root.addView(card, params);
    }

    // =========================================================
    // MESSAGE
    // =========================================================

    private void showMessage(String text) {

        Toast.makeText(
                this,
                text,
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
