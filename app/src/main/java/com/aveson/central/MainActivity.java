package com.aveson.central;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showCentral();
    }

    // =========================================================
    // AVESON CENTRAL
    // =========================================================

    private void showCentral() {

        // Scrollable AVESON CENTRAL content
        android.widget.ScrollView scrollView =
                new android.widget.ScrollView(this);

        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(Color.rgb(7, 7, 18));

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 24, 24, 24);
        root.setBackgroundColor(Color.rgb(7, 7, 18));

        scrollView.addView(root);

        TextView title = new TextView(this);
        title.setText("AVESON CENTRAL");
        title.setTextColor(Color.WHITE);
        title.setTextSize(27);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("CONTROL CENTER\n\nGLOBAL MUSIC ECOSYSTEM");
        subtitle.setTextColor(Color.rgb(165, 155, 205));
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(8, 8, 8, 18);
        root.addView(subtitle);

        addRoom("🎤", "AVESON ARTIST CONTROL",
                "Artistlar va release'larni boshqarish.", "ARTIST");

        addRoom("🎵", "AVESON MUSIC CONTROL",
                "Music katalog va music tizimini boshqarish.", "MUSIC");

        addRoom("🌐", "AVESON DISTRIBUTION CONTROL",
                "Release'larni global platformalarga tarqatish.", "DISTRIBUTION");

        addRoom("🎛️", "AVESON STUDIO CONTROL",
                "AVESON Studio xizmatlari va buyurtmalarini boshqarish.", "STUDIO");

        addRoom("📰", "AVESON MAGAZINE CONTROL",
                "Magazine va AVESON Shop boshqaruvi.", "MAGAZINE");

        addRoom("🎬", "AVESON FILMS",
                "Film, serial, klip va video kontent yo'nalishini boshqarish.", "FILMS");

        setContentView(scrollView);
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
        card.setPadding(24, 20, 24, 20);

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.rgb(20, 17, 38));
        background.setCornerRadius(28);
        background.setStroke(2, Color.rgb(70, 55, 120));
        card.setBackground(background);

        TextView iconView = new TextView(this);
        iconView.setText(icon);
        iconView.setTextSize(27);
        card.addView(iconView);

        TextView name = new TextView(this);
        name.setText(title);
        name.setTextColor(Color.WHITE);
        name.setTextSize(18);
        name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        name.setPadding(0, 8, 0, 4);
        card.addView(name);

        TextView desc = new TextView(this);
        desc.setText(description);
        desc.setTextColor(Color.rgb(175, 170, 200));
        desc.setTextSize(13);
        card.addView(desc);

        TextView open = new TextView(this);
        open.setText("OPEN  →");
        open.setTextColor(Color.WHITE);
        open.setTextSize(15);
        open.setGravity(Gravity.CENTER);
        open.setPadding(12, 14, 12, 14);

        GradientDrawable openBackground = new GradientDrawable();
        openBackground.setColor(Color.rgb(145, 80, 245));
        openBackground.setCornerRadius(40);
        open.setBackground(openBackground);

        LinearLayout.LayoutParams openParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        openParams.setMargins(0, 16, 0, 0);
        card.addView(open, openParams);

        card.setOnClickListener(v -> openRoom(type));
        open.setOnClickListener(v -> openRoom(type));

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 8, 0, 12);
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
            showRoom("🎛️", "AVESON STUDIO CONTROL",
                    "Studio services • Orders • Bookings");
        }

        if (type.equals("MAGAZINE")) {
            showRoom("📰", "AVESON MAGAZINE CONTROL",
                    "Magazine • Media • AVESON Shop");
        }

        if (type.equals("FILMS")) {
            showRoom("🎬", "AVESON FILMS",
                    "Films • Series • Music Videos • Original Content");
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

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 24, 24, 24);
        root.setBackgroundColor(Color.rgb(7, 7, 18));

        TextView back = new TextView(this);
        back.setText("← BACK TO AVESON CENTRAL");
        back.setTextColor(Color.rgb(120, 190, 255));
        back.setTextSize(16);
        back.setPadding(8, 8, 8, 18);
        back.setOnClickListener(v -> showCentral());
        root.addView(back);

        TextView title = new TextView(this);
        title.setText(icon + "  " + titleText);
        title.setTextColor(Color.WHITE);
        title.setTextSize(26);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setPadding(8, 8, 8, 6);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText(subtitleText);
        subtitle.setTextColor(Color.rgb(165, 155, 205));
        subtitle.setTextSize(14);
        subtitle.setPadding(8, 4, 8, 24);
        root.addView(subtitle);

        TextView status = new TextView(this);
        status.setText("CONTROL ROOM READY");
        status.setTextColor(Color.rgb(190, 170, 255));
        status.setTextSize(17);
        status.setGravity(Gravity.CENTER);
        status.setPadding(20, 28, 20, 28);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(20, 17, 38));
        bg.setCornerRadius(24);
        bg.setStroke(2, Color.rgb(80, 60, 150));
        status.setBackground(bg);

        root.addView(status);

        setContentView(root);
    }

    // =========================================================
    // AVESON MUSIC CONTROL
    // =========================================================

    private void showMusicControl() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 24, 24, 24);
        root.setBackgroundColor(Color.rgb(7, 7, 18));

        TextView back = new TextView(this);
        back.setText("← BACK TO AVESON CENTRAL");
        back.setTextColor(Color.rgb(120, 190, 255));
        back.setTextSize(16);
        back.setPadding(8, 8, 8, 18);
        back.setOnClickListener(v -> showCentral());
        root.addView(back);

        TextView title = new TextView(this);
        title.setText("AVESON MUSIC CONTROL");
        title.setTextColor(Color.WHITE);
        title.setTextSize(27);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setPadding(8, 8, 8, 4);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Music catalog • Playlists • Content management");
        subtitle.setTextColor(Color.rgb(165, 155, 205));
        subtitle.setTextSize(14);
        subtitle.setPadding(8, 4, 8, 24);
        root.addView(subtitle);

        addMusicControlButton("🎵  MUSIC CATALOG",
                "Tracks • Albums • Releases");
        addMusicControlButton("📀  ALBUMS & RELEASES",
                "Manage music releases");
        addMusicControlButton("🎧  PLAYLISTS",
                "Create and manage playlists");
        addMusicControlButton("👥  MUSIC USERS",
                "Listener accounts and activity");
        addMusicControlButton("📊  MUSIC ANALYTICS",
                "Streaming and usage data");
        addMusicControlButton("⚙️  MUSIC SETTINGS",
                "Music platform settings");

        setContentView(root);
    }

    private void addMusicControlButton(
            String title,
            String description
    ) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(22, 18, 22, 18);

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.rgb(20, 17, 38));
        background.setCornerRadius(24);
        background.setStroke(2, Color.rgb(80, 60, 150));
        card.setBackground(background);

        TextView name = new TextView(this);
        name.setText(title);
        name.setTextColor(Color.WHITE);
        name.setTextSize(17);
        name.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        card.addView(name);

        TextView desc = new TextView(this);
        desc.setText(description);
        desc.setTextColor(Color.rgb(175, 170, 200));
        desc.setTextSize(13);
        desc.setPadding(0, 6, 0, 0);
        card.addView(desc);

        card.setOnClickListener(v -> showMessage(title));

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 6, 0, 8);
        root.addView(card, params);
    }

    // =========================================================
    // MESSAGE
    // =========================================================

    private void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
