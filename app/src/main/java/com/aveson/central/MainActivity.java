private void showAnalytics() {
    ScrollView scrollView = createScrollView();
    LinearLayout root = createRoot();

    TextView back = createButton("← BACK");
    back.setOnClickListener(v -> showMenu());
    root.addView(back);

    TextView title = createTitle("📊 ANALYTICS");
    root.addView(title);

    TextView subtitle = createSubtitle(
            "AVESON CENTRAL SYSTEM ANALYTICS"
    );
    root.addView(subtitle);

    addAnalyticsCard(root, "👤", "TOTAL ARTISTS", "0");
    addAnalyticsCard(root, "🎵", "TOTAL RELEASES", "0");
    addAnalyticsCard(root, "🎧", "TOTAL STREAMS", "0");
    addAnalyticsCard(root, "👁️", "TOTAL VIEWS", "0");
    addAnalyticsCard(root, "💿", "TOTAL ALBUMS", "0");
    addAnalyticsCard(root, "🌍", "ACTIVE DISTRIBUTION", "0");
    addAnalyticsCard(root, "📈", "GROWTH STATISTICS", "No data yet");
    addAnalyticsCard(root, "🌐", "GLOBAL ACTIVITY", "No activity yet");

    scrollView.addView(root);
    setContentView(scrollView);
}

private void addAnalyticsCard(
        LinearLayout root,
        String icon,
        String name,
        String value
) {
    LinearLayout card = new LinearLayout(this);
    card.setOrientation(LinearLayout.VERTICAL);
    card.setPadding(
            dp(18),
            dp(16),
            dp(18),
            dp(16)
    );

    GradientDrawable background = new GradientDrawable();
    background.setColor(CARD);
    background.setCornerRadius(dp(18));
    background.setStroke(dp(1), BORDER);

    card.setBackground(background);

    LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                    -1,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

    params.setMargins(
            0,
            dp(8),
            0,
            dp(8)
    );

    card.setLayoutParams(params);

    TextView iconView = new TextView(this);
    iconView.setText(icon);
    iconView.setTextSize(24);
    iconView.setTextColor(Color.WHITE);

    card.addView(iconView);

    TextView nameView = new TextView(this);
    nameView.setText(name);
    nameView.setTextSize(14);
    nameView.setTextColor(TEXT_SECONDARY);
    nameView.setPadding(0, dp(6), 0, dp(2));

    card.addView(nameView);

    TextView valueView = new TextView(this);
    valueView.setText(value);
    valueView.setTextSize(22);
    valueView.setTypeface(null, Typeface.BOLD);
    valueView.setTextColor(Color.WHITE);

    card.addView(valueView);

    root.addView(card);
}
