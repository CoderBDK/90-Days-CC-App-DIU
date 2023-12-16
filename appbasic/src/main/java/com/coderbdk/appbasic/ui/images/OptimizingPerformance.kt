package com.coderbdk.appbasic.ui.images

/**
 * @link https://developer.android.com/jetpack/compose/graphics/images/optimization
 * Working with images can quickly introduce performance issues if you aren't careful.
 * You can quite easily run into an OutOfMemoryError when working with large bitmaps.
 * Follow these best practices to ensure your app performs at its best.
 */

// Use vectors over bitmaps where possible
// Supply alternative resources for different screen sizes
// When using ImageBitmap, call prepareToDraw before drawing
// Don’t store a bitmap in memory longer than you need it
// Don’t package large images with your AAB/APK file