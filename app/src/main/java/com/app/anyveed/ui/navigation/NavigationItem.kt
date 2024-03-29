package com.app.anyveed.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.anyveed.R
import com.app.anyveed.utils.Constants.DOWNLOADS_ROUTE
import com.app.anyveed.utils.Constants.HOME_ROUTE
import com.app.anyveed.utils.Constants.SETTINGS_ROUTE

sealed class NavigationItem(
    val name: Int, val route:String, val icon: ImageVector, val iconFilled: ImageVector
) {
    data object HomeScreen : NavigationItem(
        R.string.homescreen_name,
        HOME_ROUTE,
        Icons.Outlined.Home,
        Icons.Filled.Home
    )

    data object DownloadsScreen : NavigationItem(
        R.string.downloadsscreen_name,
        DOWNLOADS_ROUTE,
        Icons.Outlined.Download,
        Icons.Filled.Download
    )

    data object SettingsScreen : NavigationItem(
        R.string.morescreen_name,
        SETTINGS_ROUTE,
        Icons.Outlined.Settings,
        Icons.Filled.Settings
    )
}