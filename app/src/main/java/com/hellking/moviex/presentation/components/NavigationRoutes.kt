package com.hellking.moviex.presentation.components

const val DETAIL_SCREEN_KEY = "name"
const val DETAIL_SCREEN_OP = "url"

sealed class NavigationRoutes(
    val route: String,
    val title: String
) {
    object Home: NavigationRoutes("home", "Home")
    object Detail: NavigationRoutes("detail/{$DETAIL_SCREEN_KEY}?$DETAIL_SCREEN_OP={$DETAIL_SCREEN_OP}", "Detail") {
        fun passNameAndUrl(
            name: String,
            url: String
        ): String {
            return "detail/$name?url=$url"
        }
    }

//    fun withArguments(vararg args: String): String {
//        return buildString {
//            append(route)
//            args.forEach {
//                append("/$it")
//            }
//        }
//    }
}