package com.aveson.central;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
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

    // =====================================================
    // AVESON CENTRAL HOME
    // =====================================================

    private void showCentral() {

        ScrollView scrollView = createScrollView();

        root = createRoot();
        scrollView.addView(root);

        // MENU
        TextView menu = new TextView(this);

        menu.setText("☰  MENU");
        menu.setTextColor(Color.WHITE);
        menu.setTextSize(16);
        menu.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        menu.setGravity(Gravity.CENTER);

        menu.setPadding(
                dp(18),
                dp(14),
                dp(18),
                dp(14)
        );

        GradientDrawable menuBackground =
                new GradientDrawable();

        menuBackground.setColor(
                Color.rgb(20, 17, 38)
        );

        menuBackground.setCornerRadius(
                dp(35)
        );

        menuBackground.setStroke(
                dp(2),
                Color.rgb(80, 60, 150)
        );

        menu.setBackground(menuBackground);

        LinearLayout.LayoutParams menuParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        // Chap tomonda va tepaga juda yaqin bo'lmasin
        menuParams.gravity = Gravity.START;

        menuParams.setMargins(
                0,
                dp(18),
                0,
                dp(20)
        );

        root.addView(menu, menuParams);

        menu.setOnClickListener(
                v -> showMenu()
        );

        // TITLE
        TextView title = new TextView(this);

        title.setText("AVESON CENTRAL");
        title.setTextColor(Color.WHITE);
        title.setTextSize(27);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        root.addView(title);

        // SUBTITLE
        TextView subtitle = new TextView(this);

        subtitle.setText(
                "CONTROL CENTER\n\nGLOBAL MUSIC ECOSYSTEM"
        );

        subtitle.setTextColor(
                Color.rgb(165, 155, 205)
        );

        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);

        subtitle.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(18)
        );

        root.addView(subtitle);

        // =================================================
        // CENTRAL ROOMS
        // =================================================

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

    // =====================================================
    // MENU
    // =====================================================

    private void showMenu() {

        ScrollView scrollView = createScrollView();

        root = createRoot();
        scrollView.addView(root);

        // BACK
        TextView back = new TextView(this);

        back.setText(
                "← BACK TO AVESON CENTRAL"
        );

        back.setTextColor(
                Color.rgb(120, 190, 255)
        );

        back.setTextSize(16);

        back.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        back.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(22)
        );

        back.setOnClickListener(
                v -> showCentral()
        );

        root.addView(back);

        // TITLE
        TextView title = new TextView(this);

        title.setText(
                "☰  AVESON CENTRAL MENU"
        );

        title.setTextColor(Color.WHITE);
        title.setTextSize(25);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(6)
        );

        root.addView(title);

        // SUBTITLE
        TextView subtitle = new TextView(this);

        subtitle.setText(
                "Central management tools\n" +
                "System-wide controls and information"
        );

        subtitle.setTextColor(TEXT_SECONDARY);
        subtitle.setTextSize(14);

        subtitle.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(24)
        );

        root.addView(subtitle);

        // MENU ITEMS

        addMenuItem(
                "📊",
                "ANALYTICS",
                "AVESON platform statistics and performance.",
                "ANALYTICS"
        );

        addMenuItem(
                "💰",
                "ROYALTY CONTROL",
                "Royalty data, earnings and payment management.",
                "ROYALTY"
        );

        addMenuItem(
                "🔐",
                "SECURITY",
                "System security, access and protection controls.",
                "SECURITY"
        );

        addMenuItem(
                "⚙️",
                "PARAMETERS",
                "Global AVESON Central parameters and settings.",
                "PARAMETERS"
        );

        addMenuItem(
                "🛡️",
                "SYSTEM STATUS",
                "Monitor AVESON Central system status.",
                "STATUS"
        );

        addMenuItem(
                "ℹ️",
                "AVESON CENTRAL INFO",
                "Information about the AVESON Central platform.",
                "INFO"
        );

        setContentView(scrollView);
    }

    // =====================================================
    // MENU ITEM
    // =====================================================

    private void addMenuItem(
            String icon,
            String titleText,
            String description,
            String type
    ) {

        LinearLayout card = new LinearLayout(this);

        card.setOrientation(
                LinearLayout.VERTICAL
        );

        card.setPadding(
                dp(22),
                dp(18),
                dp(22),
                dp(18)
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);
        background.setCornerRadius(dp(24));
        background.setStroke(
                dp(2),
                BORDER
        );

        card.setBackground(background);

        // ICON
        TextView iconView = new TextView(this);

        iconView.setText(icon);
        iconView.setTextSize(25);

        card.addView(iconView);

        // TITLE
        TextView name = new TextView(this);

        name.setText(titleText);
        name.setTextColor(Color.WHITE);
        name.setTextSize(17);

        name.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        name.setPadding(
                0,
                dp(7),
                0,
                dp(4)
        );

        card.addView(name);

        // DESCRIPTION
        TextView desc = new TextView(this);

        desc.setText(description);
        desc.setTextColor(TEXT_SECONDARY);
        desc.setTextSize(13);

        card.addView(desc);

        // OPEN
        TextView open = new TextView(this);

        open.setText("OPEN  →");
        open.setTextColor(Color.WHITE);
        open.setTextSize(14);

        open.setGravity(Gravity.CENTER);

        open.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        open.setPadding(
                dp(12),
                dp(12),
                dp(12),
                dp(12)
        );

        GradientDrawable openBackground =
                new GradientDrawable();

        openBackground.setColor(PURPLE);
        openBackground.setCornerRadius(
                dp(40)
        );

        open.setBackground(openBackground);

        LinearLayout.LayoutParams openParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        openParams.setMargins(
                0,
                dp(14),
                0,
                0
        );

        card.addView(
                open,
                openParams
        );

        card.setOnClickListener(
                v -> openMenuItem(type)
        );

        open.setOnClickListener(
                v -> openMenuItem(type)
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
                dp(10)
        );

        root.addView(
                card,
                params
        );
    }

    // =====================================================
    // OPEN MENU ITEM
    // =====================================================

    private void openMenuItem(String type) {

        if (type.equals("ANALYTICS")) {

            showMenuSection(
                    "📊",
                    "ANALYTICS",
                    "Platform analytics and performance monitoring.",
                    new String[]{
                            "📈  PLATFORM OVERVIEW",
                            "🎵  MUSIC PERFORMANCE",
                            "🎤  ARTIST PERFORMANCE",
                            "🌐  DISTRIBUTION PERFORMANCE",
                            "👥  USER ACTIVITY"
                    }
            );

        } else if (type.equals("ROYALTY")) {

            showMenuSection(
                    "💰",
                    "ROYALTY CONTROL",
                    "Royalty and earnings management center.",
                    new String[]{
                            "💵  ROYALTY OVERVIEW",
                            "📊  EARNINGS DATA",
                            "🎤  ARTIST ROYALTIES",
                            "🌐  DISTRIBUTION ROYALTIES",
                            "💳  PAYMENT STATUS"
                    }
            );

        } else if (type.equals("SECURITY")) {

            showMenuSection(
                    "🔐",
                    "SECURITY",
                    "AVESON Central security and access controls.",
                    new String[]{
                            "🛡️  SYSTEM PROTECTION",
                            "🔑  ACCESS CONTROL",
                            "🚨  SECURITY EVENTS",
                            "📱  ACTIVE SESSIONS",
                            "⚠️  SECURITY STATUS"
                    }
            );

        } else if (type.equals("PARAMETERS")) {

            // =============================================
            // PARAMETERS
            // =============================================

            showMenuSection(
                    "⚙️",
                    "PARAMETERS",
                    "Global AVESON Central configuration.",
                    new String[]{
                            "🌐  LANGUAGES",
                            "🎨  APPEARANCE",
                            "🔔  NOTIFICATIONS",
                            "🎵  MUSIC PARAMETERS",
                            "🌍  DISTRIBUTION PARAMETERS"
                    }
            );

        } else if (type.equals("STATUS")) {

            showMenuSection(
                    "🛡️",
                    "SYSTEM STATUS",
                    "Current AVESON Central system condition.",
                    new String[]{
                            "🟢  CENTRAL SYSTEM",
                            "🟢  ARTIST CONTROL",
                            "🟢  MUSIC CONTROL",
                            "🟢  DISTRIBUTION CONTROL",
                            "🟢  STUDIO CONTROL",
                            "🟢  MAGAZINE CONTROL",
                            "🟢  AVESON FILMS"
                    }
            );

        } else if (type.equals("INFO")) {

            showMenuSection(
                    "ℹ️",
                    "AVESON CENTRAL INFO",
                    "Unified management platform for the AVESON ecosystem.",
                    new String[]{
                            "AVESON CENTRAL",
                            "GLOBAL MUSIC ECOSYSTEM",
                            "CENTRAL MANAGEMENT PLATFORM",
                            "AVESON CONTROL ARCHITECTURE",
                            "SYSTEM VERSION"
                    }
            );
        }
    }

    // =====================================================
    // MENU SECTION
    // =====================================================

    private void showMenuSection(
            String icon,
            String titleText,
            String subtitleText,
            String[] items
    ) {

        ScrollView scrollView =
                createScrollView();

        root = createRoot();

        scrollView.addView(root);

        // BACK
        TextView back = new TextView(this);

        back.setText(
                "← BACK TO MENU"
        );

        back.setTextColor(
                Color.rgb(120, 190, 255)
        );

        back.setTextSize(16);

        back.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        back.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(22)
        );

        back.setOnClickListener(
                v -> showMenu()
        );

        root.addView(back);

        // TITLE
        TextView title = new TextView(this);

        title.setText(
                icon + "  " + titleText
        );

        title.setTextColor(Color.WHITE);
        title.setTextSize(26);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(6)
        );

        root.addView(title);

        // SUBTITLE
        TextView subtitle = new TextView(this);

        subtitle.setText(subtitleText);
        subtitle.setTextColor(TEXT_SECONDARY);
        subtitle.setTextSize(14);

        subtitle.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(24)
        );

        root.addView(subtitle);

        // ITEMS
        for (String item : items) {

            TextView itemView =
                    new TextView(this);

            itemView.setText(item);
            itemView.setTextColor(Color.WHITE);
            itemView.setTextSize(16);

            itemView.setTypeface(
                    Typeface.DEFAULT,
                    Typeface.BOLD
            );

            itemView.setGravity(
                    Gravity.CENTER_VERTICAL
            );

            itemView.setPadding(
                    dp(20),
                    dp(20),
                    dp(20),
                    dp(20)
            );

            GradientDrawable itemBackground =
                    new GradientDrawable();

            itemBackground.setColor(CARD);

            itemBackground.setCornerRadius(
                    dp(22)
            );

            itemBackground.setStroke(
                    dp(2),
                    Color.rgb(65, 50, 110)
            );

            itemView.setBackground(
                    itemBackground
            );

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            params.setMargins(
                    0,
                    dp(5),
                    0,
                    dp(8)
            );

            root.addView(
                    itemView,
                    params
            );

            itemView.setOnClickListener(
                    v -> {

                        // LANGUAGES uchun alohida ekran
                        if (item.equals("🌐  LANGUAGES")) {

                            showLanguages();

                        } else {

                            showMessage(item);
                        }
                    }
            );
        }

        setContentView(scrollView);
    }

    // =====================================================
    // LANGUAGES
    // PARAMETERS ICHIDA JOYLASHGAN
    // =====================================================

    private void showLanguages() {

        ScrollView scrollView =
                createScrollView();

        root = createRoot();

        scrollView.addView(root);

        // BACK
        TextView back = new TextView(this);

        back.setText(
                "← BACK TO PARAMETERS"
        );

        back.setTextColor(
                Color.rgb(120, 190, 255)
        );

        back.setTextSize(16);

        back.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        back.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(22)
        );

        back.setOnClickListener(
                v -> openMenuItem("PARAMETERS")
        );

        root.addView(back);

        // TITLE
        TextView title = new TextView(this);

        title.setText(
                "🌐  LANGUAGES"
        );

        title.setTextColor(Color.WHITE);
        title.setTextSize(27);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(6)
        );

        root.addView(title);

        // SUBTITLE
        TextView subtitle = new TextView(this);

        subtitle.setText(
                "Select the language used by AVESON Central."
        );

        subtitle.setTextColor(
                TEXT_SECONDARY
        );

        subtitle.setTextSize(14);

        subtitle.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(24)
        );

        root.addView(subtitle);

        // LANGUAGES

        addLanguage(
                "🇬🇧",
                "English",
                "English"
        );

        addLanguage(
                "🇺🇿",
                "O'zbek",
                "Uzbek"
        );

        addLanguage(
                "🇷🇺",
                "Русский",
                "Russian"
        );

        addLanguage(
                "🇪🇸",
                "Español",
                "Spanish"
        );

        addLanguage(
                "🇫🇷",
                "Français",
                "French"
        );

        addLanguage(
                "🇩🇪",
                "Deutsch",
                "German"
        );

        addLanguage(
                "🇹🇷",
                "Türkçe",
                "Turkish"
        );

        addLanguage(
                "🇸🇦",
                "العربية",
                "Arabic"
        );

        addLanguage(
                "🇨🇳",
                "中文",
                "Chinese"
        );

        addLanguage(
                "🇰🇷",
                "한국어",
                "Korean"
        );

        setContentView(scrollView);
    }

    // =====================================================
    // LANGUAGE ITEM
    // =====================================================

    private void addLanguage(
            String flag,
            String language,
            String messageName
    ) {

        TextView languageView =
                new TextView(this);

        languageView.setText(
                flag + "  " + language
        );

        languageView.setTextColor(
                Color.WHITE
        );

        languageView.setTextSize(17);

        languageView.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        languageView.setGravity(
                Gravity.CENTER_VERTICAL
        );

        languageView.setPadding(
                dp(20),
                dp(20),
                dp(20),
                dp(20)
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);

        background.setCornerRadius(
                dp(22)
        );

        background.setStroke(
                dp(2),
                Color.rgb(65, 50, 110)
        );

        languageView.setBackground(
                background
        );

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.setMargins(
                0,
                dp(5),
                0,
                dp(8)
        );

        root.addView(
                languageView,
                params
        );

        languageView.setOnClickListener(
                v -> showMessage(
                        "Language selected: " + messageName
                )
        );
    }

    // =====================================================
    // CENTRAL ROOMS
    // =====================================================

    private void addRoom(
            String icon,
            String title,
            String description,
            String type
    ) {

        LinearLayout card =
                new LinearLayout(this);

        card.setOrientation(
                LinearLayout.VERTICAL
        );

        card.setPadding(
                dp(24),
                dp(20),
                dp(24),
                dp(20)
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);

        background.setCornerRadius(
                dp(28)
        );

        background.setStroke(
                dp(2),
                BORDER
        );

        card.setBackground(
                background
        );

        // ICON
        TextView iconView =
                new TextView(this);

        iconView.setText(icon);
        iconView.setTextSize(27);

        card.addView(iconView);

        // NAME
        TextView name =
                new TextView(this);

        name.setText(title);
        name.setTextColor(Color.WHITE);
        name.setTextSize(18);

        name.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        name.setPadding(
                0,
                dp(8),
                0,
                dp(4)
        );

        card.addView(name);

        // DESCRIPTION
        TextView desc =
                new TextView(this);

        desc.setText(description);
        desc.setTextColor(
                TEXT_SECONDARY
        );

        desc.setTextSize(13);

        card.addView(desc);

        // OPEN
        TextView open =
                new TextView(this);

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

        openBackground.setCornerRadius(
                dp(40)
        );

        open.setBackground(
                openBackground
        );

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

        card.addView(
                open,
                openParams
        );

        card.setOnClickListener(
                v -> openRoom(type)
        );

        open.setOnClickListener(
                v -> openRoom(type)
        );

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

        root.addView(
                card,
                params
        );
    }

    // =====================================================
    // OPEN ROOM
    // =====================================================

    private void openRoom(String type) {

        if (type.equals("ARTIST")) {

            showMessage(
                    "AVESON ARTIST CONTROL"
            );

        } else if (type.equals("MUSIC")) {

            showMusicControl();

        } else if (type.equals("DISTRIBUTION")) {

            showMessage(
                    "AVESON DISTRIBUTION CONTROL"
            );

        } else if (type.equals("STUDIO")) {

            showRoom(
                    "🎛️",
                    "AVESON STUDIO CONTROL",
                    "Studio services • Orders • Bookings"
            );

        } else if (type.equals("MAGAZINE")) {

            showRoom(
                    "📰",
                    "AVESON MAGAZINE CONTROL",
                    "Magazine • Media • AVESON Shop"
            );

        } else if (type.equals("FILMS")) {

            showRoom(
                    "🎬",
                    "AVESON FILMS",
                    "Films • Series • Music Videos • Original Content"
            );
        }
    }

    // =====================================================
    // GENERAL ROOM
    // =====================================================

    private void showRoom(
            String icon,
            String titleText,
            String subtitleText
    ) {

        ScrollView scrollView =
                createScrollView();

        root = createRoot();

        scrollView.addView(root);

        // BACK
        TextView back =
                new TextView(this);

        back.setText(
                "← BACK TO AVESON CENTRAL"
        );

        back.setTextColor(
                Color.rgb(120, 190, 255)
        );

        back.setTextSize(16);

        back.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(18)
        );

        back.setOnClickListener(
                v -> showCentral()
        );

        root.addView(back);

        // TITLE
        TextView title =
                new TextView(this);

        title.setText(
                icon + "  " + titleText
        );

        title.setTextColor(Color.WHITE);
        title.setTextSize(26);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(6)
        );

        root.addView(title);

        // SUBTITLE
        TextView subtitle =
                new TextView(this);

        subtitle.setText(
                subtitleText
        );

        subtitle.setTextColor(
                Color.rgb(165, 155, 205)
        );

        subtitle.setTextSize(14);

        subtitle.setPadding(
                dp(8),
                dp(4),
                dp(8),
                dp(24)
        );

        root.addView(subtitle);

        // STATUS
        TextView status =
                new TextView(this);

        status.setText(
                "CONTROL ROOM READY"
        );

        status.setTextColor(
                Color.rgb(190, 170, 255)
        );

        status.setTextSize(17);
        status.setGravity(
                Gravity.CENTER
        );

        status.setPadding(
                dp(20),
                dp(28),
                dp(20),
                dp(28)
        );

        GradientDrawable bg =
                new GradientDrawable();

        bg.setColor(CARD);

        bg.setCornerRadius(
                dp(24)
        );

        bg.setStroke(
                dp(2),
                Color.rgb(80, 60, 150)
        );

        status.setBackground(bg);

        root.addView(status);

        setContentView(scrollView);
    }

    // =====================================================
    // MUSIC CONTROL
    // =====================================================

    private void showMusicControl() {

        ScrollView scrollView =
                createScrollView();

        root = createRoot();

        scrollView.addView(root);

        // BACK
        TextView back =
                new TextView(this);

        back.setText(
                "← BACK TO AVESON CENTRAL"
        );

        back.setTextColor(
                Color.rgb(120, 190, 255)
        );

        back.setTextSize(16);

        back.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(18)
        );

        back.setOnClickListener(
                v -> showCentral()
        );

        root.addView(back);

        // TITLE
        TextView title =
                new TextView(this);

        title.setText(
                "AVESON MUSIC CONTROL"
        );

        title.setTextColor(Color.WHITE);
        title.setTextSize(27);

        title.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        title.setPadding(
                dp(8),
                dp(8),
                dp(8),
                dp(4)
        );

        root.addView(title);

        // SUBTITLE
        TextView subtitle =
                new TextView(this);

        subtitle.setText(
                "Music catalog • Playlists • Content management"
        );

        subtitle.setTextColor(
                Color.rgb(165, 155, 205)
        );

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

    // =====================================================
    // MUSIC BUTTON
    // =====================================================

    private void addMusicControlButton(
            String title,
            String description
    ) {

        LinearLayout card =
                new LinearLayout(this);

        card.setOrientation(
                LinearLayout.VERTICAL
        );

        card.setPadding(
                dp(22),
                dp(18),
                dp(22),
                dp(18)
        );

        GradientDrawable background =
                new GradientDrawable();

        background.setColor(CARD);

        background.setCornerRadius(
                dp(24)
        );

        background.setStroke(
                dp(2),
                Color.rgb(80, 60, 150)
        );

        card.setBackground(background);

        TextView name =
                new TextView(this);

        name.setText(title);
        name.setTextColor(Color.WHITE);
        name.setTextSize(17);

        name.setTypeface(
                Typeface.DEFAULT,
                Typeface.BOLD
        );

        card.addView(name);

        TextView desc =
                new TextView(this);

        desc.setText(description);
        desc.setTextColor(
                TEXT_SECONDARY
        );

        desc.setTextSize(13);

        desc.setPadding(
                0,
                dp(6),
                0,
                0
        );

        card.addView(desc);

        card.setOnClickListener(
                v -> showMessage(title)
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

        root.addView(
                card,
                params
        );
    }

    // =====================================================
    // SCROLL VIEW
    // =====================================================

    private ScrollView createScrollView() {

        ScrollView scrollView =
                new ScrollView(this);

        scrollView.setFillViewport(true);

        scrollView.setClipToPadding(false);

        scrollView.setBackgroundColor(BG);

        // Telefonning pastki navigation qismidan
        // kontentni uzoqroq ushlab turadi.
        scrollView.setPadding(
                0,
                0,
                0,
                dp(36)
        );

        return scrollView;
    }

    // =====================================================
    // ROOT
    // =====================================================

    private LinearLayout createRoot() {

        LinearLayout layout =
                new LinearLayout(this);

        layout.setOrientation(
                LinearLayout.VERTICAL
        );

        layout.setPadding(
                dp(24),
                dp(24),
                dp(24),
                dp(24)
        );

        layout.setBackgroundColor(BG);

        return layout;
    }

    // =====================================================
    // MESSAGE
    // =====================================================

    private void showMessage(String text) {

        Toast.makeText(
                this,
                text,
                Toast.LENGTH_SHORT
        ).show();
    }

    // =====================================================
    // DP
    // =====================================================

    private int dp(int value) {

        return (int) (
                value *
                getResources()
                        .getDisplayMetrics()
                        .density
        );
    }
}
