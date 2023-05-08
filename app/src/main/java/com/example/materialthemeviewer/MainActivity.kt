@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.materialthemeviewer

//import 'package:top_app_bar_scroll_behavior/top_app_bar_scroll_behavior.dart';

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior
import androidx.compose.runtime.remember
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialthemeviewer.ui.theme.MaterialThemeViewerTheme
import androidx.compose.material3.TopAppBarDefaults as Material3TopAppBarDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
@OptIn(ExperimentalMaterial3Api::class)
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    setContent {
        layout()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    layout()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun layout(){
    MaterialThemeViewerTheme {
        val decayAnimationSpec = rememberSplineBasedDecay<Float>()
        val scrollBehavior = remember(decayAnimationSpec) {
            Material3TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
        }
        //val scrollBehavior = remember { Material3TopAppBarDefaults.pinnedScrollBehavior() }
        val topAppBarElementColor = MaterialTheme.colorScheme.onSurface

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                LargeTopAppBar(
                    colors = Material3TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        scrolledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                        navigationIconContentColor = topAppBarElementColor,
                        titleContentColor = topAppBarElementColor,
                        actionIconContentColor= topAppBarElementColor,
                    ),
                    title = {
                        Text(
                            "Material Palette",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    scrollBehavior=scrollBehavior,
                    //scrollBehavior: TopAppScrollBarBehavior
                )
            },

        ){
            LazyColumn(
            ) {
                item {
                    Primary("Primary")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Secondary("Secondary")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Tertiary("Tertiary")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Surface("Surface")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Error("Error")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    Background("Background")
                    //Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    //Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

val chipHeight=98.dp
val chipScale=16.dp

//Primary color block
@Composable
fun Primary(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current

    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    text = "Primary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onPrimary
            ) {
                Text(
                    text = "on Primary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Text(
                    text = "Primary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Text(
                    text = "on Primary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                )
            }
        }
    }
}

//secondary color block
@Composable
fun Secondary(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.secondary
            ) {
                Text(
                    text = "Secondary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSecondary
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSecondary
            ) {
                Text(
                    text = "on Secondary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Text(
                    text = "Secondary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ) {
                Text(
                    text = "on Secondary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
    }
}

//tertiary color block
@Composable
fun Tertiary(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.tertiary
            ) {
                Text(
                    text = "Tertiary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onTertiary
            ) {
                Text(
                    text = "on Tertiary",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.tertiaryContainer
            ) {
                Text(
                    text = "Tertiary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onTertiaryContainer
            ) {
                Text(
                    text = "on Tertiary Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.tertiaryContainer
                )
            }
        }
    }
}
//error color block
@Composable
fun Error(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.error
            ) {
                Text(
                    text = "Error",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onError
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onError
            ) {
                Text(
                    text = "on Error",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.errorContainer
            ) {
                Text(
                    text = "Error Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onErrorContainer
            ) {
                Text(
                    text = "on Error Container",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.errorContainer
                )
            }
        }
    }
}

//surface color block
@Composable
fun Surface(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.surface
            ) {
                Text(
                    text = "Surface",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSurface
            ) {
                Text(
                    text = "on Surface",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Text(
                    text = "Surface Variant",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ) {
                Text(
                    text = "on Surface Variant",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }
    }
}

//background color block
@Composable
fun Background(name: String) {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    Column{
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.background
            ) {
                Text(
                    text = "Background",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 1F)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.onBackground
            ) {
                Text(
                    text = "on Background",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.background
                )
            }
        }
        Row {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(chipHeight)
                    .padding(4.dp)
                    .clickable(
                        indication = rememberRipple(
                            bounded = true,
                            color = MaterialTheme.colorScheme.background.copy(alpha = 1f)
                        ),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        Toast.makeText(context, "Material You Colors!", Toast.LENGTH_SHORT).show()
                    },
                shape = RoundedCornerShape(chipScale),
                color = MaterialTheme.colorScheme.outline
            ) {
                Text(
                    text = "Outline",
                    Modifier.padding(24.dp),
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }
    }
}