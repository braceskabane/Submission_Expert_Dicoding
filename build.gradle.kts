// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.kotlinKsp) apply false
    alias(libs.plugins.daggerHilt) apply false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.androidDynamicFeature) apply false
    alias(libs.plugins.androidLibrary) apply false
}