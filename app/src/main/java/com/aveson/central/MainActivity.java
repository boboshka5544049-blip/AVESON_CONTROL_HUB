package com.aveson.central;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
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

    private void showCentral() {

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 24, 24, 24);
        root.setBackgroundColor(Color.rgb(7, 7, 18));

        // TOP BAR
        LinearLayout top = new LinearLayout(this);
        top.setGravity(Gravity.CENTER_VERTICAL);

        TextView menu = new TextView(this);
        menu.setText("☰");
        menu.setTextColor(Color.WHITE);
        menu.setTextSize(28);
        menu.setGravity(Gravity.CENTER);
        menu.setPadding(12, 8, 20, 8);

        menu.setOnClickListener(v -> showMenu());

        top.addView(menu);

        TextView title = new TextView(this);
        title.setText("AVESON CENTRAL");
        title.setTextColor(Color.WHITE);
        title.setTextSize(23);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        top.addView(title);

        root.addView(top);

        // SUBTITLE
        TextView subtitle = new TextView(this);
        subtitle.setText("Global Management System");
        subtitle.setTextColor(Color.rgb(165, 155, 205));
        subtitle.setTextSize(14);
        subtitle.setPadding(8, 8, 8, 18);

        root.addView(subtitle);

        // CONTROL ROOMS
        addRoom(
                "🎤",
                "AVESON ARTIST CONTROL",
                "Artist & Release Management",
                "ARTIST"
        );

        addRoom(
                "🎵",
                "AVESON MUSIC CONTROL",
                "Music Catalog & Platform",
                "MUSIC"
        );

        addRoom(
                "🌐",
                "AVESON DISTRIBUTION CONTROL",
                "Global Distribution Management",
                "DISTRIBUTION"
        );

        setContentView(root);
    }

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

        card.setOnClickListener(v -> {

            if (type.equals("ARTIST")) {
                showMessage("AVESON ARTIST CONTROL");
            }

            if (type.equals("MUSIC")) {
                showMessage("AVESON MUSIC CONTROL");
            }

            if (type.equals("DISTRIBUTION")) {
                showMessage("AVESON DISTRIBUTION CONTROL");
            }
        });

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(0, 8, 0, 12);

        root.addView(card, params);
    }

    private void showMenu() {

        Toast.makeText(
                this,
                "Analytics • Royalty • Security • Notifications • Global • Settings",
                Toast.LENGTH_LONG
        ).show();
    }

    private void showMessage(String text) {

        Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
        ).show();
    }
}
