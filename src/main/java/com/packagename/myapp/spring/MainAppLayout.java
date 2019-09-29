package com.packagename.myapp.spring;


import com.github.appreciated.app.layout.component.applayout.LeftLayouts;
import com.github.appreciated.app.layout.component.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftSubMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.items.LeftClickableItem;
import com.github.appreciated.app.layout.component.menu.left.items.LeftHeaderItem;
import com.github.appreciated.app.layout.component.menu.left.items.LeftNavigationItem;
import com.github.appreciated.app.layout.component.router.AppLayoutRouterLayout;
import com.github.appreciated.app.layout.entity.DefaultBadgeHolder;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;

import static com.github.appreciated.app.layout.entity.Section.FOOTER;
import static com.github.appreciated.app.layout.entity.Section.HEADER;

/**
 * The main view contains a button and a template element.
 */

@Push
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
public class MainAppLayout extends AppLayoutRouterLayout<LeftLayouts.LeftResponsive> {

    public MainAppLayout() {
        LeftNavigationItem menuEntry = new LeftNavigationItem("Menu", VaadinIcon.MENU.create(), MainView.class);
        DefaultBadgeHolder badge = new DefaultBadgeHolder(5);
        badge.bind(menuEntry.getBadge());

        init(AppLayoutBuilder.get(LeftLayouts.LeftResponsive.class)
                .withTitle("App Layout")
                .withAppMenu(LeftAppMenuBuilder.get()
                        .addToSection(HEADER,
                                new LeftHeaderItem("Menu-Header", "Version 4.0.0", "/frontend/images/logo.png"),
                                new LeftClickableItem("Clickable Entry", VaadinIcon.COG.create(), event -> Notification.show("onClick ..."))
                        )
                        .add(new LeftNavigationItem("Home", VaadinIcon.HOME.create(), MainView.class),
                                new LeftNavigationItem("Grid", VaadinIcon.TABLE.create(), MainView.class),
                                LeftSubMenuBuilder.get("My Submenu", VaadinIcon.PLUS.create())
                                        .add(LeftSubMenuBuilder.get("My Submenu", VaadinIcon.PLUS.create())
                                                        .add(new LeftNavigationItem("Charts", VaadinIcon.SPLINE_CHART.create(), MainView.class),
                                                                new LeftNavigationItem("Contact", VaadinIcon.CONNECT.create(), MainView.class),
                                                                new LeftNavigationItem("More", VaadinIcon.COG.create(), MainView.class))
                                                        .build(),
                                                new LeftNavigationItem("Contact1", VaadinIcon.CONNECT.create(), MainView.class),
                                                new LeftNavigationItem("More1", VaadinIcon.COG.create(), MainView.class))
                                        .build(),
                                menuEntry
                        )
                        .addToSection(FOOTER,
                                new LeftClickableItem("Clickable Entry", VaadinIcon.COG.create(), clickEvent -> Notification.show("onClick ..."))
                        )
                        .build())
                .build());
    }
}